package koropapps.criptoquiz.feature.quizzes.model

import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.data.quizzes.local.model.Quiz

data class QuizzesViewState(
    val quizzes: List<Quiz> = emptyList(),
    val message: UiMessage<QuizzesUiMessage>? = null
) {
    companion object {
        val Empty = QuizzesViewState()
    }
}
