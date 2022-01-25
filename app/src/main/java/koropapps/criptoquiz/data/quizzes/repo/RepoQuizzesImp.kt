package koropapps.criptoquiz.data.quizzes.repo

import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RepoQuizzesImp : RepoQuizzes {
    override fun observe(): Flow<List<Quiz>> {
        return flowOf(listOf(Quiz.Test, Quiz.Test, Quiz.Test, Quiz.Test))
    }
}