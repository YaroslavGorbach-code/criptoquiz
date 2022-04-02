package koropapps.criptoquiz.data.quizzes.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import koropapps.criptoquiz.data.quizzes.local.dao.QuizResultDao
import koropapps.criptoquiz.data.quizzes.local.model.QuizResult
import javax.inject.Singleton

@TypeConverters(QuizNameConverter::class)
@Database(
    entities = [QuizResult::class],
    version = 1
)
@Singleton
abstract class QuizDatabase : RoomDatabase() {
    abstract val quizResult: QuizResultDao
}