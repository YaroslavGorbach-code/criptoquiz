package koropapps.criptoquiz.feature.quizzes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.bussines.ObserveQuizzesInteractor
import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.common_ui.utill.UiMessageManager
import koropapps.criptoquiz.feature.quizzes.model.QuizzesAction
import koropapps.criptoquiz.feature.quizzes.model.QuizzesUiMessage
import koropapps.criptoquiz.feature.quizzes.model.QuizzesViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizzesViewModel @Inject constructor(
    observeQuizzesInteractor: ObserveQuizzesInteractor
) : ViewModel() {
    private val pendingActions = MutableSharedFlow<QuizzesAction>()

    private val uiMessageManager: UiMessageManager<QuizzesUiMessage> = UiMessageManager()

    val state: StateFlow<QuizzesViewState> = combine(
        observeQuizzesInteractor.invoke(),
        uiMessageManager.message,
        ::QuizzesViewState
    ).stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = QuizzesViewState.Empty
    )

    init {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is QuizzesAction.OpenQuiz -> uiMessageManager.emitMessage(
                        UiMessage(
                            QuizzesUiMessage.OpenQuiz(action.quizName)
                        )
                    )
                }
            }
        }
    }

    fun submitAction(action: QuizzesAction) {
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



