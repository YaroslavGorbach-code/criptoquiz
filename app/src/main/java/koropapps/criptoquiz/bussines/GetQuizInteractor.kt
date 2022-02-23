package koropapps.criptoquiz.bussines

import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetQuizInteractor @Inject constructor(private val repoQuizzes: RepoQuizzes) {

    operator fun invoke(quizName: QuizName): Flow<Quiz> {
        return repoQuizzes.observe().map { list ->
            list.first { it.name == quizName }
        }
    }
}