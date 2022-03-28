package koropapps.criptoquiz.data.quizzes.repo

import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import kotlinx.coroutines.flow.Flow

interface RepoQuizzes {
    fun observe(): Flow<List<Quiz>>
    var answers: List<Answer>
}