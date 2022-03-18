package koropapps.criptoquiz.feature.quiz.model

import koropapps.criptoquiz.data.quizzes.local.model.Quiz

sealed class QuizAction {
    class OpenQuiz(val quiz: Quiz) : QuizAction()
}