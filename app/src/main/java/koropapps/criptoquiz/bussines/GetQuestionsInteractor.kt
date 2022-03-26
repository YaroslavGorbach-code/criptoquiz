package koropapps.criptoquiz.bussines

import koropapps.criptoquiz.data.quizzes.local.model.Question
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetQuestionsInteractor @Inject constructor(private val getQuizInteractor: GetQuizInteractor) {

    operator fun invoke(quizName: QuizName): Flow<List<Question>> {
        return getQuizInteractor(quizName).map { it.questions }
    }
}