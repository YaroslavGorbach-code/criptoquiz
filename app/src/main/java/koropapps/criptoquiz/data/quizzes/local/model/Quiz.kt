package koropapps.criptoquiz.data.quizzes.local.model

data class Quiz(
    val name: QuizName,
    val shortDescription: String,
    val progress: Int = 0,
    val questions: List<Question>,
    val isCompleted: Boolean = false,
    val complexity: QuizComplexity
) {
    companion object {
        val Test = Quiz(
            QuizName.NONE,
            "test description",
            50,
            emptyList(),
            complexity = QuizComplexity.EASY
        )
    }

    val amountOfMinutesWillTake: Int = questions.size / 2

    val numberOfQuestions: Int = questions.size

}
