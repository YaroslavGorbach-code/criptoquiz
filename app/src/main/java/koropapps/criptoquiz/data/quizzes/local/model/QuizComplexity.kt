package koropapps.criptoquiz.data.quizzes.local.model

import androidx.compose.ui.graphics.Color
import koropapps.criptoquiz.R

enum class QuizComplexity(val id: Int, val color: Color) {
    EASY(R.string.beginner, Color.Green),
    MIDDLE(R.string.intermediate, Color(0xFFFF9100)),
    HARD(R.string.hardcore, Color.Red)
}