package koropapps.criptoquiz.feature.quiz.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.QUIZ_NAME_ARG
import koropapps.criptoquiz.bussines.GetQuizInteractor
import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.common_ui.utill.UiMessageManager
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.feature.quiz.model.QuizAction
import koropapps.criptoquiz.feature.quiz.model.QuizUiMessage
import koropapps.criptoquiz.feature.quiz.model.QuizViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val getQuizInteractor: GetQuizInteractor,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val quizName: QuizName = savedStateHandle[QUIZ_NAME_ARG]!!

    private val pendingActions = MutableSharedFlow<QuizAction>()

    private val uiMessageManager: UiMessageManager<QuizUiMessage> = UiMessageManager()

    val state: StateFlow<QuizViewState> = combine(
        getQuizInteractor(quizName),
        uiMessageManager.message,
        ::QuizViewState
    ).stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = QuizViewState.Test
    )

    init {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is QuizAction.OpenQuiz -> uiMessageManager.emitMessage(
                        UiMessage(QuizUiMessage.OpenQuiz(action.quiz.name))
                    )
                }
            }
        }
    }

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



