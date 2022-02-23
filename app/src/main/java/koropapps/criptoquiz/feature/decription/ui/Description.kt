package koropapps.criptoquiz.feature.decription.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import koropapps.criptoquiz.common_ui.theme.CriptoTheme
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.feature.decription.model.DescriptionAction
import koropapps.criptoquiz.feature.decription.model.DescriptionUiMessage
import koropapps.criptoquiz.feature.decription.model.DescriptionViewState
import koropapps.criptoquiz.feature.decription.presentation.DescriptionViewModel
import koropapps.criptoquiz.feature.quizzes.model.QuizzesViewState

@ExperimentalMaterialApi
@Composable
fun Description(
    quizName: QuizName,
    openQuiz: (quiz: Quiz) -> Unit,
) {
    Description(
        viewModel = hiltViewModel(),
        openQuiz = openQuiz,
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Description(
    viewModel: DescriptionViewModel,
    openQuiz: (quiz: Quiz) -> Unit,
) {
    val viewState = viewModel.state.collectAsState()

    Description(
        state = viewState.value,
        onMessageShown = viewModel::clearMessage,
        actioner = viewModel::submitAction,
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Description(
    state: DescriptionViewState,
    actioner: (DescriptionAction) -> Unit,
    onMessageShown: (id: Long) -> Unit,
) {
    state.message?.let { uiMessage ->
        when (uiMessage.message) {
            is DescriptionUiMessage.OpenQuiz -> {

            }
        }
        onMessageShown(uiMessage.id)
    }

}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ExercisesPreview() {
    CriptoTheme {
        Description(
            state = DescriptionViewState(),
            onMessageShown = {},
            actioner = {}
        )
    }
}