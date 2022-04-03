package koropapps.criptoquiz.data.quizzes.local.mapper

import koropapps.criptoquiz.R
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

object QuizNameToIconMapper {
    fun map(quizName: QuizName): Int {
        return when (quizName) {
            QuizName.BITCOIN_BEGINNER -> R.drawable.ic_bitcoin_beginer
            QuizName.BITCOIN_INTERMEDIATE -> R.drawable.ic_bitcoin_interm
            QuizName.BITCOIN_HARDCORE -> R.drawable.ic_bitcoin_hard
        }
    }
}