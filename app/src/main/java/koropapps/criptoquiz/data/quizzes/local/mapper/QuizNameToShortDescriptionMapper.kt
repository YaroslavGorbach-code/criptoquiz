package koropapps.criptoquiz.data.quizzes.local.mapper

import koropapps.criptoquiz.R
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuizNameToShortDescriptionMapper {
    fun map(name: QuizName): Int {
        return when (name) {
            QuizName.BITCOIN_BEGINNER -> R.string.bitcoin_beginner_description
            QuizName.TEST ->  R.string.bitcoin_beginner_description
        }
    }
}