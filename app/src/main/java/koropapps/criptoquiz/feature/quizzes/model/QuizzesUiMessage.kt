package koropapps.criptoquiz.feature.quizzes.model

import koropapps.criptoquiz.data.quizzes.local.model.QuizName

sealed class QuizzesUiMessage {
    class OpenQuiz(quizName: QuizName) : QuizzesUiMessage()
}