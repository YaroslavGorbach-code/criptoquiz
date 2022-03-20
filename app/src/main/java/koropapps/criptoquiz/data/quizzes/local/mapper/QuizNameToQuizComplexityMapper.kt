package koropapps.criptoquiz.data.quizzes.local.mapper

import koropapps.criptoquiz.data.quizzes.local.model.QuizComplexity
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuizNameToQuizComplexityMapper() {
    fun map(name: QuizName): QuizComplexity {
        return when (name) {
            QuizName.BITCOIN_BEGINNER -> QuizComplexity.EASY
            QuizName.TEST -> QuizComplexity.MIDDLE
        }
    }
}