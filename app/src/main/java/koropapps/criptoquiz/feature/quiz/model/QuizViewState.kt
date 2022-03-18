package koropapps.criptoquiz.feature.quiz.model

import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.data.quizzes.local.model.Quiz

data class QuizViewState(
    val quiz: Quiz = Quiz.Test,
    val message: UiMessage<QuizUiMessage>? = null
) {
    companion object {
        val Test = QuizViewState()
    }
}
