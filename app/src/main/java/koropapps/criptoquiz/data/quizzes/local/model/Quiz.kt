package koropapps.criptoquiz.data.quizzes.local.model

import koropapps.criptoquiz.R

data class Quiz(
    val name: QuizName,
    val descriptionRes: Int,
    val iconRes: Int,
    val questions: List<Question>,
    val results: List<QuizResult> = emptyList(),
    val complexity: QuizComplexity
) {
    companion object {
        val Test = Quiz(
            QuizName.BITCOIN_BEGINNER,
            R.string.correct_answers,
            R.drawable.ic_bitcoin_beginer,
            questions = emptyList(),
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
