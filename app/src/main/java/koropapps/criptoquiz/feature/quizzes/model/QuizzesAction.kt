package koropapps.criptoquiz.feature.quizzes.model

import koropapps.criptoquiz.data.quizzes.local.model.QuizName

sealed class QuizzesAction {
    class OpenQuiz(val quizName: QuizName) : QuizzesAction()
}