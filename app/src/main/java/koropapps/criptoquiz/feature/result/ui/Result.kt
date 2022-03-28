package koropapps.criptoquiz.feature.result.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import koropapps.criptoquiz.R
import koropapps.criptoquiz.common_ui.theme.CryptoTheme
import koropapps.criptoquiz.feature.result.model.ResultAction
import koropapps.criptoquiz.feature.result.model.ResultUiMessage
import koropapps.criptoquiz.feature.result.model.ResultViewState
import koropapps.criptoquiz.feature.result.presentation.ResultViewModel

@ExperimentalMaterialApi
@Composable
fun Result(
    onBack: () -> Unit
) {
//    Result(
//        viewModel = hiltViewModel(),
//        onBack = onBack
//    )
    Text(text = "ddsddssd")
}
//
//@ExperimentalMaterialApi
//@Composable
//internal fun Result(
//    viewModel: ResultViewModel,
//    onBack: () -> Unit
//) {
//    val viewState = viewModel.state.collectAsState()
//
//    Result(
//        state = viewState.value,
//        onMessageShown = viewModel::clearMessage,
//        actioner = viewModel::submitAction,
//        onBack = onBack
//    )
//}
//
//@ExperimentalMaterialApi
//@Composable
//internal fun Result(
//    state: ResultViewState,
//    actioner: (ResultAction) -> Unit,
//    onMessageShown: (id: Long) -> Unit,
//    onBack: () -> Unit
//) {
//    state.message?.let { uiMessage ->
//        when (uiMessage.message) {
//            ResultUiMessage.OnBack -> {}
//            ResultUiMessage.Repeat -> {}
//        }
//        onMessageShown(uiMessage.id)
//    }
//
//    Column {
//        Text(
//            text = stringResource(id = R.string.result),
//            style = MaterialTheme.typography.caption,
//            textAlign = TextAlign.Center,
//        )
//    }
//}
//
//
//@ExperimentalMaterialApi
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ExercisesPreview() {
//    CryptoTheme {
//        Result(
//            state = ResultViewState(),
//            onMessageShown = {},
//            actioner = {},
//            onBack = {}
//        )
//    }

//}