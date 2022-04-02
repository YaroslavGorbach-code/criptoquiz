package koropapps.criptoquiz.data.quizzes.repo

import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import kotlinx.coroutines.flow.Flow

interface RepoQuizzes {
    fun observe(): Flow<List<Quiz>>
    suspend fun saveResult(quizName: QuizName, correctPresent: Float)
    var answers: List<Answer>
}