package koropapps.criptoquiz.bussines

import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveQuizzesInteractor @Inject constructor(
    private val repo: RepoQuizzes,
) {
    operator fun invoke(): Flow<List<Quiz>> = repo.observe()
}