package koropapps.criptoquiz.feature.result.model

import koropapps.criptoquiz.common_ui.utill.UiMessage
import koropapps.criptoquiz.data.quizzes.local.model.Answer

data class ResultViewState(
    val answers: List<Answer> = emptyList(),
) {
    companion object {
        val Test = ResultViewState()
    }
}
