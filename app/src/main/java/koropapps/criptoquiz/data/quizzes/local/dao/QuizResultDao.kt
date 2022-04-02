package koropapps.criptoquiz.data.quizzes.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import koropapps.criptoquiz.data.quizzes.local.model.QuizResult
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizResultDao {

    @Query("SELECT * FROM QuizResult")
    fun observe(): Flow<List<QuizResult>>

    @Insert()
    suspend fun insert(exercises: QuizResult)

}