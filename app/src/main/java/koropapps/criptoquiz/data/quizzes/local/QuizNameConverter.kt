package koropapps.criptoquiz.data.quizzes.local

import androidx.room.TypeConverter
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

object QuizNameConverter {
    @TypeConverter
    fun toName(value: String) = enumValueOf<QuizName>(value)

    @TypeConverter
    fun fromName(value: QuizName) = value.name
}