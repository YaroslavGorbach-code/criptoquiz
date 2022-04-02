package koropapps.criptoquiz.feature.quiz.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import koropapps.criptoquiz.R
import koropapps.criptoquiz.common_ui.theme.CryptoTheme

@Composable
fun AnswerItem(answerId: Int, onAnswer: (id: Int) -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 70.dp)
            .padding(8.dp)
            .background(color = MaterialTheme.colors.primary, shape = MaterialTheme.shapes.medium)
            .clickable { onAnswer(answerId) }
    ) {
        Text(
            style = MaterialTheme.typography.caption,
            fontSize = 15.sp,
            text = stringResource(id = answerId),
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(8.dp)
        )
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun QuizItemPreview(id: Int = R.string.question_number) {
    CryptoTheme {
        AnswerItem(id) {}
    }
}