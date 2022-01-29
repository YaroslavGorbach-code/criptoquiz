package koropapps.criptoquiz.feature.quizzes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import koropapps.criptoquiz.R
import koropapps.criptoquiz.common_ui.theme.CriptoTheme
import koropapps.criptoquiz.data.quizzes.local.model.Quiz

@ExperimentalMaterialApi
@Composable
fun QuizItem(quiz: Quiz, onExerciseClick: (isAvailable: Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(150.dp)
            .background(color = MaterialTheme.colors.onSurface, shape = MaterialTheme.shapes.medium)
            .padding(8.dp)
    )
    {
        if(quiz.isCompleted){
            Icon(Icons.Filled.CheckCircle, contentDescription = "", tint = Color.Green)
        }

        Row(
            Modifier
                .fillMaxSize()
                .weight(1f)
        ) {

            Icon(
                Icons.Filled.AccountBox,
                contentDescription = "",
                modifier = Modifier
                    .size(80.dp)
                    .align(CenterVertically)
            )
            Column(modifier = Modifier.align(CenterVertically)) {
                Text(
                    text = stringResource(id = quiz.name.resId),
                    style = MaterialTheme.typography.caption,
                    fontSize = 16.sp,
                )
                Text(
                    text = quiz.shortDescription,
                    style = MaterialTheme.typography.h3,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }

        Row(Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.number_of_questions) + " " + quiz.numberOfQuestions.toString(),
                style = MaterialTheme.typography.h3,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .weight(0.5f)
            )

            Text(
                text = stringResource(id = R.string.minutes) + " " + quiz.amountOfMinutesWillTake.toString(),
                style = MaterialTheme.typography.h3,
                fontSize = 12.sp,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .weight(0.5f),
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun QuizItemPreview(quiz: Quiz = Quiz.Test) {
    CriptoTheme {
        QuizItem(quiz = quiz, onExerciseClick = {})
    }
}