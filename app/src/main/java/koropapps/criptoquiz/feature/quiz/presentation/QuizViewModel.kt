package koropapps.criptoquiz.feature.quiz.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.NEED_RELOAD_QUIZ_ARG
import koropapps.criptoquiz.QUIZ_NAME_ARG
import koropapps.criptoquiz.base.utill.calculatePercentage
import koropapps.criptoquiz.bussines.GetQuestionsInteractor
import koropapps.criptoquiz.bussines.GetQuizInteractor
import koropapps.criptoquiz.bussines.SetResentAnswersInteractor
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Question
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.feature.quiz.model.QuizAction
import koropapps.criptoquiz.feature.quiz.model.QuizViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getQuizInteractor: GetQuizInteractor,
    private val getQuestionsInteractor: GetQuestionsInteractor,
    private val setResentAnswersInteractor: SetResentAnswersInteractor,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val quizName: QuizName = savedStateHandle[QUIZ_NAME_ARG]!!

    val needReload: Boolean = savedStateHandle[NEED_RELOAD_QUIZ_ARG]!!

    private val pendingActions = MutableSharedFlow<QuizAction>()

    private val questions: MutableStateFlow<List<Question>> = MutableStateFlow(emptyList())

    private val _answers: MutableStateFlow<MutableList<Answer>> = MutableStateFlow(ArrayList())

    private val isNeedToNavigateToResult: MutableStateFlow<Boolean> = MutableStateFlow(true)

    val state: StateFlow<QuizViewState> = combine(
        getQuizInteractor(quizName),
        questions,
        _answers,
        isNeedToNavigateToResult,
    ) { quiz, questions, answers, needToNavigate ->
        setResentAnswersInteractor.invoke(answers = answers)

        QuizViewState(
            quiz = quiz,
            question = questions.firstOrNull(),
            answersSize = answers.size,
            isFinish = questions.isEmpty(),
            progress = calculatePercentage(
                value = answers.size,
                totalValue = questions.size + answers.size,
            ),
            needReload = needReload,
            hasNeedToNavigateToResult = needToNavigate
        )
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = QuizViewState.Test
    )

    init {
        viewModelScope.launch {
            loadQuestions()

            pendingActions.collect { action ->
                when (action) {
                    is QuizAction.Answer -> {
                        answerQuestion(action.answerId)
                    }
                    QuizAction.NavigateToResult -> {
                        isNeedToNavigateToResult.emit(false)
                        loadQuestions()
                    }
                }
            }
        }
    }

    private suspend fun loadQuestions() {
        getQuestionsInteractor(quizName)
            .flowOn(Dispatchers.IO)
            .collect(questions::emit)
    }

    private fun answerQuestion(answerId: Int) {
        questions.update { questions ->
            questions.firstOrNull()?.let { question ->
                _answers.update { answers ->
                    answers.add(question.getAnswer(answerId))
                    answers
                }
            }
            questions.drop(1)
        }
    }

    fun submitAction(action: QuizAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

}



