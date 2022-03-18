package koropapps.criptoquiz.data.quizzes.local.factory

import koropapps.criptoquiz.data.quizzes.local.model.Question
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuestionsFactory {
    fun create(name: QuizName): List<Question> {
        return when (name) {
            QuizName.NONE -> emptyList()
            QuizName.WHAT_D_Y_KNOW_ABOUT_BLOCKCHAIN -> emptyList()
            QuizName.TEST -> emptyList()
        }
    }
}