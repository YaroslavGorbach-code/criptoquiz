package koropapps.criptoquiz.feature.quiz.ui
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import koropapps.criptoquiz.R
import koropapps.criptoquiz.common_ui.theme.CryptoTheme
import koropapps.criptoquiz.common_ui.theme.OnSurface
import koropapps.criptoquiz.common_ui.theme.PrimaryText
import koropapps.criptoquiz.common_ui.ui.RoundedLinearProgressIndicator
import koropapps.criptoquiz.feature.quiz.model.QuizAction
import koropapps.criptoquiz.feature.quiz.model.QuizViewState
import koropapps.criptoquiz.feature.quiz.presentation.QuizViewModel

@ExperimentalMaterialApi
@Composable
fun Quiz(
    onBack: () -> Unit,
    onResult: () -> Unit,
) {
    Quiz(
        viewModel = hiltViewModel(),
        onBack = onBack,
        onResult = onResult
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quiz(
    viewModel: QuizViewModel,
    onBack: () -> Unit,
    onResult: () -> Unit
) {
    val viewState = viewModel.state.collectAsState()

    Quiz(
        state = viewState.value,
        actioner = viewModel::submitAction,
        onBack = onBack,
        onResult = onResult
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Quiz(
    state: QuizViewState,
    actioner: (QuizAction) -> Unit,
    onBack: () -> Unit,
    onResult: () -> Unit
) {
    Column {
        Toolbar(state.quiz.name.resId) {
            onBack()
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(
                    id = R.string.question_number,
                    "${state.answersSize}/${state.questionsSize}"
                ),
                modifier = Modifier.padding(bottom = 4.dp)
            )

            RoundedLinearProgressIndicator(
                progress = state.progress,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .clickable {
                        onResult.invoke()
                    }
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        )

        if (state.isFinish && state.hasNeedToNavigateToResult) {
            onResult.invoke()
            actioner(QuizAction.NavigateToResult)
        } else {
            Questions(state = state, actioner = actioner)
        }
    }
}

@Composable
private fun Toolbar(stringId: Int, onIconClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp)
    ) {

        Icon(
            Icons.Default.ArrowBack,
            contentDescription = "back",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .size(40.dp)
                .clickable { onIconClick() }
                .padding(4.dp)
        )

        Text(
            text = stringResource(id = stringId),
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        )
    }
}

@Composable
private fun Questions(state: QuizViewState, actioner: (QuizAction) -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .defaultMinSize(minHeight = 200.dp)
            .background(color = OnSurface, shape = RoundedCornerShape(4))
            .padding(16.dp)
    ) {
        state.question?.let { question ->
            Text(
                text = stringResource(id = question.questionId),
                color = PrimaryText,
                style = MaterialTheme.typography.caption,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )

            LazyColumn {
                items(items = state.question.answerIds) { id ->
                    AnswerItem(id) { actioner(QuizAction.Answer(it)) }
                }
            }

        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExercisesPreview() {
    CryptoTheme {
        Quiz(
            state = QuizViewState(),
            actioner = {},
            onBack = {},
            onResult = {}
        )
    }
}