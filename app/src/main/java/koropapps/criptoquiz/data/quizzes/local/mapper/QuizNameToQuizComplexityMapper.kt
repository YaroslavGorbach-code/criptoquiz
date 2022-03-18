package koropapps.criptoquiz.data.quizzes.local.mapper

import koropapps.criptoquiz.data.quizzes.local.model.QuizComplexity
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuizNameToQuizComplexityMapper() {
    fun map(name: QuizName): QuizComplexity {
        return when (name) {
            QuizName.NONE -> QuizComplexity.EASY
            QuizName.WHAT_D_Y_KNOW_ABOUT_BLOCKCHAIN -> QuizComplexity.MIDDLE
            QuizName.TEST -> QuizComplexity.EASY
        }
    }
}