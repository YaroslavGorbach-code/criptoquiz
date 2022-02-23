package koropapps.criptoquiz.data.quizzes.local.mapper

import android.app.Application
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuizNameToShortDescriptionMapper(private val context: Context) {
    fun map(name: QuizName): String {
        return when (name) {
            QuizName.NONE -> ""
            QuizName.WHAT_D_Y_KNOW_ABOUT_BLOCKCHAIN -> "test"
        }
    }
}