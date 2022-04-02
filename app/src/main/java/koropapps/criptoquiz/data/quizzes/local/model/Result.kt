package koropapps.criptoquiz.data.quizzes.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuizResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: QuizName,
    val correctPresent: Float
)