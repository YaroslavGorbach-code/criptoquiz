package koropapps.criptoquiz.feature.decription.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.bussines.ObserveQuizzesInteractor
import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.common_ui.utill.UiMessageManager
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.feature.decription.model.DescriptionAction
import koropapps.criptoquiz.feature.decription.model.DescriptionUiMessage
import koropapps.criptoquiz.feature.decription.model.DescriptionViewState
import koropapps.criptoquiz.feature.quizzes.model.QuizzesAction
import koropapps.criptoquiz.feature.quizzes.model.QuizzesUiMessage
import koropapps.criptoquiz.feature.quizzes.model.QuizzesViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel @Inject constructor(
    private val quiz: Quiz
) : ViewModel() {
    private val pendingActions = MutableSharedFlow<DescriptionAction>()

    private val uiMessageManager: UiMessageManager<DescriptionUiMessage> = UiMessageManager()

    val state: StateFlow<DescriptionViewState> = combine(
        flowOf(quiz),
        uiMessageManager.message,
        ::DescriptionViewState
    ).stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = DescriptionViewState.Test
    )

    init {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    is DescriptionAction.OpenQuiz -> uiMessageManager.emitMessage(
                        UiMessage(DescriptionUiMessage.OpenQuiz(action.quiz.name))
                    )
                }
            }
        }
    }

    fun submitAction(action: DescriptionAction) {
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



