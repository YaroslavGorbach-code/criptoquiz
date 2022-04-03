package koropapps.criptoquiz.data.quizzes.repo

import koropapps.criptoquiz.data.quizzes.local.dao.QuizResultDao
import koropapps.criptoquiz.data.quizzes.local.factory.QuestionsFactory
import koropapps.criptoquiz.data.quizzes.local.factory.QuizzesFactory
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToIconMapper
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToQuizComplexityMapper
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToShortDescriptionMapper
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.data.quizzes.local.model.QuizResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepoQuizzesImp @Inject constructor(private val quizResultDao: QuizResultDao) : RepoQuizzes {
    private val resentAnswers: MutableSet<Answer> = HashSet()

    override fun observe(): Flow<List<Quiz>> {
        return quizResultDao.observe().map { results ->
            QuizzesFactory(
                quizResults = results,
                questionsFactory = QuestionsFactory(),
                quizNameToShortDescriptionMapper = QuizNameToShortDescriptionMapper(),
                quizNameToQuizComplexityMapper = QuizNameToQuizComplexityMapper(),
                quizNameToIconMapper = QuizNameToIconMapper
            ).create()
        }
    }

    override suspend fun saveResult(quizName: QuizName, correctPresent: Float) {

        quizResultDao.insert(QuizResult(name = quizName, correctPresent = correctPresent))
    }

    override var answers: List<Answer>
        get() = resentAnswers.toList()
        set(value) {
            resentAnswers.clear()
            resentAnswers.addAll(value)
        }
}