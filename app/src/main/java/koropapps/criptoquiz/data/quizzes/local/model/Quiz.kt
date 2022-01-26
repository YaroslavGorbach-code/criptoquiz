package koropapps.criptoquiz.data.quizzes.local.model

data class Quiz(
    val name: QuizName,
    val shortDescription: String,
    val progress: Int = 0,
    val questions: List<Question>
) {
    companion object {
        val Test = Quiz(QuizName.NONE, "test description", 50, emptyList())
    }
}
