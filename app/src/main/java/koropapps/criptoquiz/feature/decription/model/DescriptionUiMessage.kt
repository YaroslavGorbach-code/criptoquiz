package koropapps.criptoquiz.feature.decription.model

import koropapps.criptoquiz.data.quizzes.local.model.QuizName

sealed class DescriptionUiMessage {
    class OpenQuiz(quizName: QuizName) : DescriptionUiMessage()
}