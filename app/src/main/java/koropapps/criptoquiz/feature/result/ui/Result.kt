package koropapps.criptoquiz.feature.result.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import koropapps.criptoquiz.R
import koropapps.criptoquiz.common_ui.theme.OnSurface
import koropapps.criptoquiz.common_ui.ui.CircularProgressIndicatorWithContent
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.data.quizzes.local.model.getCorrectPercentage
import koropapps.criptoquiz.feature.result.model.ResultViewState
import koropapps.criptoquiz.feature.result.presentation.ResultViewModel
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun Result(
    onBack: () -> Unit,
    onTryAgain: (QuizName) -> Unit
) {
    Result(
        viewModel = hiltViewModel(),
        onBack = onBack,
        onTryAgain = onTryAgain
    )
}

@InternalCoroutinesApi
@ExperimentalMaterialApi
@Composable
internal fun Result(
    viewModel: ResultViewModel,
    onBack: () -> Unit,
    onTryAgain: (QuizName) -> Unit
) {
    val viewState = viewModel.state.collectAsState()

    Result(
        state = viewState.value,
        onBack = onBack,
        onTryAgain = onTryAgain
    )
}

@ExperimentalMaterialApi
@Composable
internal fun Result(
    state: ResultViewState,
    onBack: () -> Unit,
    onTryAgain: (QuizName) -> Unit
) {

    Column {
        Toolbar(stringId = R.string.result) {
            onBack()
        }

        CircularProgressIndicatorWithContent(
            modifierProgress = Modifier.size(150.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(150.dp),
            progress = state.answers.getCorrectPercentage(),
            backgroundStrokeColor = Color.Red,
            strokeWidth = 15.dp,
            backgroundStrokeWidth = 14.dp
        ) {
            Text(
                text = (String.format(
                    "%.2f",
                    (state.answers.getCorrectPercentage() * 100f)
                ) + "%\n" + stringResource(
                    id = R.string.correct_answers
                )),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.caption
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = stringResource(id = R.string.answers),
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .weight(1F)
        ) {
            itemsIndexed(items = state.answers) { index, answer ->
                AnswerItem(item = answer, order = index + 1)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Column(
            Modifier
                .padding(start = 32.dp, end = 32.dp)
                .padding(bottom = 16.dp, top = 16.dp)
        ) {
            Button(
                onClick = {
                    onTryAgain(state.name)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(35),
            ) {
                Text(text = stringResource(id = R.string.try_again))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    onBack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(35),
                colors = ButtonDefaults.buttonColors(backgroundColor = OnSurface)
            ) {
                Text(text = stringResource(id = R.string.finish))
            }
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
                .padding(end = 40.dp)
        )
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ExercisesPreview() {
    MaterialTheme() {
        Result(
            state = ResultViewState(),
            onBack = {},
            onTryAgain = {}
        )
    }
}