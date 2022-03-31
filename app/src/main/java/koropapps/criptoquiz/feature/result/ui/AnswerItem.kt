package koropapps.criptoquiz.feature.result.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import koropapps.criptoquiz.common_ui.theme.CryptoTheme
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Quiz

@ExperimentalMaterialApi
@Composable
fun AnswerItem(item: Answer, order: Int) {

    Column() {
        Text(
            text = "$order." + stringResource(id = item.question.questionId),
            style = MaterialTheme.typography.caption,
            fontSize = 18.sp
        )
        Row() {
            if (item.isCorrect){
                Icon(Icons.Default.Check, contentDescription = "", tint = Color.Green)
            }else{
                Icon(Icons.Default.Close, contentDescription = "", tint = Color.Red)
            }

            Text(text = stringResource(id = item.question.correctAnswerId))
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun QuizItemPreview(quiz: Quiz = Quiz.Test) {
    MaterialTheme {
        AnswerItem(Answer.Test, 1)
    }
}