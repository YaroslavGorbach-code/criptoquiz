package koropapps.criptoquiz.data.quizzes.repo

import koropapps.criptoquiz.data.quizzes.local.factory.QuestionsFactory
import koropapps.criptoquiz.data.quizzes.local.factory.QuizzesFactory
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToQuizComplexityMapper
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToShortDescriptionMapper
import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class RepoQuizzesImp : RepoQuizzes {
    private val resentAnswers: MutableSet<Answer> = HashSet()

    override fun observe(): Flow<List<Quiz>> {
        return flowOf(
            QuizzesFactory(
                questionsFactory = QuestionsFactory(),
                quizNameToShortDescriptionMapper = QuizNameToShortDescriptionMapper(),
                quizNameToQuizComplexityMapper = QuizNameToQuizComplexityMapper()
            ).create()
        )
    }

    override var answers: List<Answer>
        get() = resentAnswers.toList()
        set(value) {
            resentAnswers.addAll(value)
        }
}