package koropapps.criptoquiz.feature.quizzes.model

import koropapps.criptoquiz.data.quizzes.local.model.Quiz

sealed class QuizzesUiMessage {
    data class OpenDescription(val quiz: Quiz) : QuizzesUiMessage()
}