package koropapps.criptoquiz.data.quizzes.local.mapper

import koropapps.criptoquiz.R
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuizNameToShortDescriptionMapper {
    fun map(name: QuizName): Int {
        return when (name) {
            QuizName.NONE -> R.string.empty
            QuizName.WHAT_D_Y_KNOW_ABOUT_BLOCKCHAIN -> R.string.description_test
            QuizName.TEST -> R.string.description_test
        }
    }
}