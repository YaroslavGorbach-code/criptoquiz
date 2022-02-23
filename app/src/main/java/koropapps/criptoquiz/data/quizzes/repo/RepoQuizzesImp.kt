package koropapps.criptoquiz.data.quizzes.repo

import android.content.Context
import koropapps.criptoquiz.data.quizzes.local.factory.QuestionsFactory
import koropapps.criptoquiz.data.quizzes.local.factory.QuizzesFactory
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToQuizComplexityMapper
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToShortDescriptionMapper
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RepoQuizzesImp(private val context: Context) : RepoQuizzes {
    override fun observe(): Flow<List<Quiz>> {
        return flowOf(
            QuizzesFactory(
                questionsFactory = QuestionsFactory(),
                quizNameToShortDescriptionMapper = QuizNameToShortDescriptionMapper(context),
                quizNameToQuizComplexityMapper = QuizNameToQuizComplexityMapper()
            ).create()
        )
    }
}