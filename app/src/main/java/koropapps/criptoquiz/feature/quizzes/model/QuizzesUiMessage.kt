package koropapps.criptoquiz.feature.quizzes.model

import koropapps.criptoquiz.data.quizzes.local.model.QuizName

sealed class QuizzesUiMessage {
    class OpenDescription(quizName: QuizName) : QuizzesUiMessage()
}