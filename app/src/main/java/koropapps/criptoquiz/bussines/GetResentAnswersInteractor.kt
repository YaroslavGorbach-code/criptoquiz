package koropapps.criptoquiz.bussines

import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import javax.inject.Inject

class GetResentAnswersInteractor @Inject constructor(private val repoQuizzes: RepoQuizzes) {
    operator fun invoke(): List<Answer> = repoQuizzes.answers
}