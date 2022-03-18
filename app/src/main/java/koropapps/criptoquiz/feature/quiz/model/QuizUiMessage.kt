package koropapps.criptoquiz.feature.quiz.model

import koropapps.criptoquiz.data.quizzes.local.model.QuizName

sealed class QuizUiMessage {
    class OpenQuiz(quizName: QuizName) : QuizUiMessage()
}