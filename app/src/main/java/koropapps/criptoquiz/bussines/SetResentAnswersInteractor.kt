package koropapps.criptoquiz.bussines

import android.util.Log
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.repo.RepoQuizzes
import javax.inject.Inject

class SetResentAnswersInteractor @Inject constructor(private val repoQuizzes: RepoQuizzes) {
    operator fun invoke(answers: List<Answer>) {
        repoQuizzes.answers = answers
    }

}