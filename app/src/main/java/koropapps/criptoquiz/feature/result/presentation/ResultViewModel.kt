package koropapps.criptoquiz.feature.result.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.bussines.GetResentAnswersInteractor
import koropapps.criptoquiz.common_ui.utill.UiMessageManager
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.feature.result.model.ResultAction
import koropapps.criptoquiz.feature.result.model.ResultUiMessage
import koropapps.criptoquiz.feature.result.model.ResultViewState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val getResentAnswersInteractor: GetResentAnswersInteractor
) : ViewModel() {

    private val pendingActions = MutableSharedFlow<ResultAction>()

    private val uiMessageManager: UiMessageManager<ResultUiMessage> = UiMessageManager()

    val state: StateFlow<ResultViewState> = combine(
        uiMessageManager.message,
        flowOf(ArrayList<Answer>())
    ) { message, answers ->
        ResultViewState(
            message = message,
            answers = answers,
        )
    }.stateIn(
        scope = viewModelScope,
        started = WhileSubscribed(5000),
        initialValue = ResultViewState.Test
    )

    init {
        viewModelScope.launch {
            pendingActions.collect { action ->
                when (action) {
                    ResultAction.OnBack -> {

                    }
                    ResultAction.Repeat -> {

                    }
                }
            }
        }
    }

    fun submitAction(action: ResultAction) {
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



