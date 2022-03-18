package koropapps.criptoquiz.feature.quiz.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import koropapps.criptoquiz.common_ui.theme.CryptoTheme
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.feature.quiz.model.QuizAction
import koropapps.criptoquiz.feature.quiz.model.QuizUiMessage
import koropapps.criptoquiz.feature.quiz.model.QuizViewState
import koropapps.criptoquiz.feature.quiz.presentation.QuizViewModel

@ExperimentalMaterialApi
@Composable
fun Quiz(
    quizName: QuizName,
    openQuiz: (quiz: Quiz) -> Unit,
) {
    Quiz(
        viewModel = hiltViewModel(),
        openQuiz = openQuiz,
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quiz(
    viewModel: QuizViewModel,
    openQuiz: (quiz: Quiz) -> Unit,
) {
    val viewState = viewModel.state.collectAsState()

    Quiz(
        state = viewState.value,
        onMessageShown = viewModel::clearMessage,
        actioner = viewModel::submitAction,
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quiz(
    state: QuizViewState,
    actioner: (QuizAction) -> Unit,
    onMessageShown: (id: Long) -> Unit,
) {
    state.message?.let { uiMessage ->
        when (uiMessage.message) {
            is QuizUiMessage.OpenQuiz -> {

            }
        }
        onMessageShown(uiMessage.id)
    }

}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ExercisesPreview() {
    CryptoTheme {
        Quiz(
            state = QuizViewState(),
            onMessageShown = {},
            actioner = {}
        )
    }
}