package koropapps.criptoquiz.data.quizzes.local.model

import koropapps.criptoquiz.R

data class Quiz(
    val name: QuizName,
    val descriptionRes: Int,
    val progress: Int = 0,
    val questions: List<Question>,
    val isCompleted: Boolean = false,
    val complexity: QuizComplexity
) {
    companion object {
        val Test = Quiz(
            QuizName.TEST,
            R.string.empty,
            50,
            emptyList(),
            complexity = QuizComplexity.EASY
        )
    }

    val amountOfMinutesWillTake: Int = questions.size / 2

    val numberOfQuestions: Int = questions.size

}
