package koropapps.criptoquiz.bussines

import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import javax.inject.Inject

class SaveQuizResultInteractor @Inject constructor(private val repoQuizzes: RepoQuizzes) {
    suspend operator fun invoke(quizName: QuizName, correctPresent: Float) {
        repoQuizzes.saveResult(quizName, correctPresent)
    }
}