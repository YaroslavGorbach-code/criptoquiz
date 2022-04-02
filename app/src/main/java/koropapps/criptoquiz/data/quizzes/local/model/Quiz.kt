package koropapps.criptoquiz.data.quizzes.local.model

import android.util.Log
import koropapps.criptoquiz.R

data class Quiz(
    val name: QuizName,
    val descriptionRes: Int,
    val questions: List<Question>,
    val results: List<QuizResult> = emptyList(),
    val complexity: QuizComplexity
) {
    companion object {
        val Test = Quiz(
            QuizName.TEST,
            R.string.correct_answers,
            emptyList(),
            complexity = QuizComplexity.EASY
        )
    }

    val averageResult: String
        get() {
            return  String.format(
                "%.2f",
                (results.map(QuizResult::correctPresent)
                    .sum() / results.size.toFloat())
            )
        }
}
