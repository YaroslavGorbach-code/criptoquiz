package koropapps.criptoquiz.feature.quizzes.model

import koropapps.criptoquiz.common_ui.utill.UiMessage

data class QuizzesViewState(
    val quizzes: List<Any> = emptyList(),
    val message: UiMessage<QuizzesUiMessage>? = null
) {
    companion object {
        val Empty = QuizzesViewState()
    }
}
