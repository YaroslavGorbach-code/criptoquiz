package koropapps.criptoquiz.data.quizzes.local.mapper

import koropapps.criptoquiz.R
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuizNameToShortDescriptionMapper {
    fun map(name: QuizName): Int {
        return when (name) {
            QuizName.BITCOIN_BEGINNER -> R.string.bitcoin_beginner_description
            QuizName.BITCOIN_INTERMEDIATE -> R.string.bitcoin_intermediate_description
            QuizName.BITCOIN_HARDCORE -> R.string.bitcoin_hardcore_description
        }
    }
}