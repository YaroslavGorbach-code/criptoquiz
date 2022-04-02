package koropapps.criptoquiz.feature.quiz.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.QUIZ_NAME_ARG
import koropapps.criptoquiz.base.utill.calculatePercentage
import koropapps.criptoquiz.bussines.GetQuestionsInteractor
import koropapps.criptoquiz.bussines.GetQuizInteractor
import koropapps.criptoquiz.bussines.SaveQuizResultInteractor
import koropapps.criptoquiz.bussines.SetResentAnswersInteractor
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Question
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.data.quizzes.local.model.getCorrectPercentage
import koropapps.criptoquiz.feature.quiz.model.QuizAction
import koropapps.criptoquiz.feature.quiz.model.QuizViewState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getQuizInteractor: GetQuizInteractor,
    private val getQuestionsInteractor: GetQuestionsInteractor,
    private val setResentAnswersInteractor: SetResentAnswersInteractor,
    private val saveQuizResultInteractor: SaveQuizResultInteractor,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val quizName: QuizName = savedStateHandle[QUIZ_NAME_ARG]!!

    private val pendingActions = MutableSharedFlow<QuizAction>()

    private val questions: MutableStateFlow<List<Question>> = MutableStateFlow(emptyList())

    private val _answers: MutableStateFlow<MutableList<Answer>> = MutableStateFlow(ArrayList())

    val state: StateFlow<QuizViewState> = combine(
        getQuizInteractor(quizName),
        questions,
        _answers,
    ) { quiz, questions, answers ->
        setResentAnswersInteractor.invoke(answers = answers)

        QuizViewState(
            quiz = quiz,
            question = questions.firstOrNull(),
            answersSize = answers.size,
            isFinish = questions.isEmpty() && answers.size > 0,
            progress = calculatePercentage(
                value = answers.size,
                totalValue = questions.size + answers.size,
            ),
        )
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = QuizViewState.Test
    )

    init {
        viewModelScope.launch {
            loadQuestions()
        }

        viewModelScope.launch() {
            pendingActions.collect { action ->
                when (action) {
                    is QuizAction.Answer -> {
                        answerQuestion(action.answerId)
                    }
                    QuizAction.NavigateToResult -> {
                            saveResult()
                    }
                }
            }
        }
    }

    private suspend fun saveResult() {
        saveQuizResultInteractor(
            quizName = quizName,
            correctPresent = _answers.value.getCorrectPercentage() * 100f
        )
    }

    private suspend fun loadQuestions() {
        getQuestionsInteractor(quizName)
            .flowOn(Dispatchers.IO)
            .collect(questions::emit)

        _answers.emit(ArrayList())
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



