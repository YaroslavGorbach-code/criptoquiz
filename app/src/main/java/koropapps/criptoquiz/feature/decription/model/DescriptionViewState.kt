package koropapps.criptoquiz.feature.decription.model

import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.data.quizzes.local.model.Quiz

data class DescriptionViewState(
    val quiz: Quiz = Quiz.Test,
    val message: UiMessage<DescriptionUiMessage>? = null
) {
    companion object {
        val Test = DescriptionViewState()
    }
}
