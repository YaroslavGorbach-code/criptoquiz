package koropapps.criptoquiz.feature.quizzes.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import koropapps.criptoquiz.common_ui.theme.CriptoTheme
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.feature.quizzes.model.QuizzesAction
import koropapps.criptoquiz.feature.quizzes.model.QuizzesUiMessage
import koropapps.criptoquiz.feature.quizzes.model.QuizzesViewState
import koropapps.criptoquiz.feature.quizzes.presentation.QuizzesViewModel

@ExperimentalMaterialApi
@Composable
fun Quizzes(
    openDescription: (quiz: Quiz) -> Unit,
) {
    Quizzes(
        viewModel = hiltViewModel(),
        openDescription = openDescription,
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quizzes(
    viewModel: QuizzesViewModel,
    openDescription: (quiz: Quiz) -> Unit,
) {
    Quizzes(
        state = viewModel.state.collectAsState().value,
        onMessageShown = viewModel::clearMessage,
        actioner = viewModel::submitAction,
        openDescription = openDescription
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quizzes(
    state: QuizzesViewState,
    actioner: (QuizzesAction) -> Unit,
    onMessageShown: (id: Long) -> Unit,
    openDescription: (quiz: Quiz) -> Unit,
) {
    state.message?.let { uiMessage ->
        when (val message = uiMessage.message) {
            is QuizzesUiMessage.OpenDescription -> {
                openDescription(message.quiz)
            }
        }
        onMessageShown(uiMessage.id)
    }

    LazyColumn {
        items(state.quizzes) { quiz ->
            QuizItem(quiz = quiz) { isAvailable ->
                if (isAvailable){
                    actioner(QuizzesAction.OpenDescription(quiz))
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ExercisesPreview() {
    CriptoTheme {
        Quizzes(
            state = QuizzesViewState(),
            onMessageShown = {},
            actioner = {},
            openDescription = {}
        )
    }
}