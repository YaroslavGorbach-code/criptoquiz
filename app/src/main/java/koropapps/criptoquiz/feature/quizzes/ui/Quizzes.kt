package koropapps.criptoquiz.feature.quizzes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.feature.quizzes.presentation.QuizzesViewModel

@ExperimentalMaterialApi
@Composable
fun Quizzes(
    openQuiz: (quiz: Quiz) -> Unit,
) {
    Quizzes(
        viewModel = hiltViewModel(),
        openQuizzes = openQuiz,
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quizzes(
    viewModel: QuizzesViewModel,
    openQuizzes: (quiz: Quiz) -> Unit,
) {
    val viewState = viewModel.state.collectAsState()

    Quizzes(
        state = viewState.value,
        onMessageShown = viewModel::clearMessage,
        actioner = { action ->
            when (action) {
                is ExercisesActions.OpenDetails -> openQuizzes(action.exerciseName)
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quizzes(
    state: ExercisesViewState,
    actioner: (ExercisesActions) -> Unit,
    onMessageShown: (id: Long) -> Unit,
) {
    if (state.exerciseAvailabilityDialogState.isVisible) {
        ShowExerciseAvailableDialog(
            onDismiss = {
                actioner(ExercisesActions.HideExerciseIsNotAvailableDialog)
            },
            onShowAd = {
                actioner(
                    ExercisesActions.RequestShowRewordAd(
                        state.exerciseAvailabilityDialogState.exerciseName
                    )
                )
                actioner(ExercisesActions.HideExerciseIsNotAvailableDialog)
            })
    }

    if (state.isOnboardingDialogVisible) {
        ShowOnboardingDialog(onDismiss = {
            actioner(ExercisesActions.HideOnboardingDialog)
        })
    }

    state.message?.let { uiMessage ->
        when (uiMessage.message) {
            is ExercisesUiMassage.ShowRewardAd -> {
                actioner(
                    ExercisesActions.ShowRewordAd(
                        activity = requireNotNull(LocalContext.current.findActivity()),
                        exerciseName = uiMessage.message.exerciseName
                    )
                )
            }
        }

        onMessageShown(uiMessage.id)
    }

    LazyColumn {
        item {
            Text(
                text = stringResource(id = R.string.exercises),
                style = MaterialTheme.typography.caption,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                text = stringResource(id = R.string.motivation_text),
                style = MaterialTheme.typography.subtitle1,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        items(state.exercises) { exercise ->
            ExerciseItem(exercise = exercise) { isAvailable ->
                if (isAvailable) {
                    actioner(ExercisesActions.OpenDetails(exerciseName = exercise.name))
                } else {
                    actioner(ExercisesActions.ShowExerciseIsNotAvailableDialog(exerciseName = exercise.name))
                }
            }
        }
    }
}

@Composable
private fun ShowExerciseAvailableDialog(onDismiss: () -> Unit, onShowAd: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(id = R.string.exercise_is_unavailable)) },
        text = { Text(stringResource(id = R.string.exercise_is_unavailable_explanation)) },
        buttons = {
            Column(
                modifier = Modifier.padding(all = 8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .background(
                            color = MaterialTheme.colors.primary,
                            shape = MaterialTheme.shapes.medium
                        ),
                    onClick = onDismiss
                ) {
                    Text(stringResource(id = R.string.good))
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)
                        .background(
                            color = MaterialTheme.colors.primary,
                            shape = MaterialTheme.shapes.medium
                        ),
                    onClick = onShowAd
                ) {
                    Text(stringResource(id = R.string.open_by_ad))
                }
            }
        }
    )
}

@Composable
private fun ShowOnboardingDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(id = R.string.about_app)) },
        text = { Text(stringResource(id = R.string.onboarding_text)) },
        buttons = {
            Row(
                modifier = Modifier.padding(all = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(
                            color = MaterialTheme.colors.primary,
                            shape = MaterialTheme.shapes.medium
                        ),
                    onClick = onDismiss
                ) {
                    Text(stringResource(id = R.string.start))
                }
            }
        }
    )
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ExercisesPreview() {
    ReactionTheme {
        Quizzes(
            state = ExercisesViewState(
                exercises = listOf(Exercise.Empty),
            ),
            onMessageShown = {},
            actioner = {}
        )
    }
}