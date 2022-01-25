package koropapps.criptoquiz.feature.quizzes.model

data class QuizzesViewState(
    val quizzes: List<Any> = emptyList(),
) {
    companion object {
        val Empty = QuizzesViewState()
    }
}
