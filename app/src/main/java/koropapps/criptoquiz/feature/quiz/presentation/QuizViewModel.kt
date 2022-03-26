package koropapps.criptoquiz.feature.quiz.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.QUIZ_NAME_ARG
import koropapps.criptoquiz.bussines.GetQuestionsInteractor
import koropapps.criptoquiz.bussines.GetQuizInteractor
import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.common_ui.utill.UiMessageManager
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Question
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.feature.quiz.model.QuizAction
import koropapps.criptoquiz.feature.quiz.model.QuizUiMessage
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
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val quizName: QuizName = savedStateHandle[QUIZ_NAME_ARG]!!

    private val pendingActions = MutableSharedFlow<QuizAction>()

    private val uiMessageManager: UiMessageManager<QuizUiMessage> = UiMessageManager()

    private val questions: MutableStateFlow<List<Question>> = MutableStateFlow(emptyList())

    private val answers: MutableStateFlow<MutableList<Answer>> = MutableStateFlow(ArrayList())

    val state: StateFlow<QuizViewState> = combine(
        getQuizInteractor(quizName),
        uiMessageManager.message,
        questions,
        answers,
    ) { quiz, message, questions, answers ->
        QuizViewState(
            quiz = quiz,
            message = message,
            question = questions.firstOrNull(),
            answersSize = answers.size,
            progress = calculateProgress(answersSize = answers.size, questionsSize = questions.size)
        )
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = QuizViewState.Test
    )

    init {
        viewModelScope.launch {
            getQuestionsInteractor(quizName)
                .flowOn(Dispatchers.IO)
                .collect(questions::emit)

            pendingActions.collect { action ->
                when (action) {
                    QuizAction.OnBack -> uiMessageManager.emitMessage(
                        UiMessage(QuizUiMessage.OnBack)
                    )
                    is QuizAction.Answer -> {
                        questions.update { questions ->
                            questions.firstOrNull()?.let { question ->
                                answers.update { answers ->
                                    answers.add(question.getAnswer(action.answerId))
                                    answers
                                }
                            }
                            questions.drop(1)
                        }
                    }
                }
            }
        }
    }

    private fun calculateProgress(answersSize: Int, questionsSize: Int) =
        if (answersSize > 0) (answersSize.toFloat() / (questionsSize.toFloat() + answersSize.toFloat())) else 0.0f

    fun submitAction(action: QuizAction) {
        viewModelScope.launch {
            pendingActions.emit(action)
        }
    }

    fun clearMessage(id: Long) {
        viewModelScope.launch {
            uiMessageManager.clearMessage(id)
        }
    }
}



