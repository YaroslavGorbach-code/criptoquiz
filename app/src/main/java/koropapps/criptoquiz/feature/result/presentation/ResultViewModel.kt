package koropapps.criptoquiz.feature.result.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import koropapps.criptoquiz.QUIZ_NAME_ARG
import koropapps.criptoquiz.bussines.GetResentAnswersInteractor
import koropapps.criptoquiz.feature.result.model.ResultViewState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class ResultViewModel @Inject constructor(
    getResentAnswersInteractor: GetResentAnswersInteractor,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val state: StateFlow<ResultViewState> =
        MutableStateFlow(
            ResultViewState(
                getResentAnswersInteractor.invoke(),
                savedStateHandle[QUIZ_NAME_ARG]!!
            )
        )

}



