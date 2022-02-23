package koropapps.criptoquiz.feature.quizzes.model

import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

sealed class QuizzesAction {
    class OpenDescription(val quiz: Quiz) : QuizzesAction()
}