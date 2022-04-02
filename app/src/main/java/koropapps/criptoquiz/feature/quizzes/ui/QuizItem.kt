package koropapps.criptoquiz.feature.quizzes.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import koropapps.criptoquiz.R
import koropapps.criptoquiz.common_ui.theme.OnSurface
import koropapps.criptoquiz.common_ui.theme.PrimaryText
import koropapps.criptoquiz.common_ui.theme.SecondaryText
import koropapps.criptoquiz.data.quizzes.local.model.Quiz

@ExperimentalMaterialApi
@Composable
fun QuizItem(quiz: Quiz, onStartClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(190.dp)
            .background(color = OnSurface, shape = MaterialTheme.shapes.medium)
            .padding(8.dp)
    )
    {
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
                    .align(Bottom)
            )
            Column(
                modifier = Modifier
                    .align(CenterVertically)
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Column(modifier = Modifier
                    .padding(end = 8.dp)
                    .align(End)) {
                    Row() {
                        Text(
                            text = stringResource(id = R.string.difficulty) + " ",
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = stringResource(id = quiz.complexity.id),
                            fontSize = 12.sp,
                            style = MaterialTheme.typography.caption,
                            color = quiz.complexity.color
                        )
                    }
                    Text(
                        text = stringResource(id = R.string.average_score) + " ${quiz.averageResult}",
                        fontSize = 12.sp
                    )

                }
                Text(
                    text = stringResource(id = quiz.name.resId),
                    style = MaterialTheme.typography.caption,
                    color = PrimaryText,
                    fontSize = 18.sp,
                )
                Text(
                    text = stringResource(id = quiz.descriptionRes),
                    style = MaterialTheme.typography.h3,
                    fontSize = 14.sp,
                    color = SecondaryText,
                    modifier = Modifier.padding(top = 4.dp),
                    overflow = TextOverflow.Ellipsis
                )
            }

        }

        OutlinedButton(
            onClick = { onStartClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp),
            border = BorderStroke(1.dp, MaterialTheme.colors.primary),
            shape = RoundedCornerShape(30),
            colors = ButtonDefaults.outlinedButtonColors(backgroundColor = OnSurface)
        ) {
            Text(text = stringResource(id = R.string.start_quiz))
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun QuizItemPreview(quiz: Quiz = Quiz.Test) {
    MaterialTheme {
        QuizItem(quiz = quiz) {}
    }
}