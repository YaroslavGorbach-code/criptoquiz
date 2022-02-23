package koropapps.criptoquiz.feature.decription.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.QUIZ_NAME_ARG
import koropapps.criptoquiz.bussines.GetQuizInteractor
import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.common_ui.utill.UiMessageManager
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.feature.decription.model.DescriptionAction
import koropapps.criptoquiz.feature.decription.model.DescriptionUiMessage
import koropapps.criptoquiz.feature.decription.model.DescriptionViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel @Inject constructor(
    private val getQuizInteractor: GetQuizInteractor,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val quizName: QuizName = savedStateHandle[QUIZ_NAME_ARG]!!

    private val pendingActions = MutableSharedFlow<DescriptionAction>()

    private val uiMessageManager: UiMessageManager<DescriptionUiMessage> = UiMessageManager()

    val state: StateFlow<DescriptionViewState> = combine(
        getQuizInteractor(quizName),
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



