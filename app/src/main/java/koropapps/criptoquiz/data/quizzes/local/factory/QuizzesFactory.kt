package koropapps.criptoquiz.data.quizzes.local.factory

import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToQuizComplexityMapper
import koropapps.criptoquiz.data.quizzes.local.mapper.QuizNameToShortDescriptionMapper
import koropapps.criptoquiz.data.quizzes.local.model.Quiz
import koropapps.criptoquiz.data.quizzes.local.model.QuizName
import koropapps.criptoquiz.data.quizzes.local.model.QuizResult

class QuizzesFactory(
    private val quizResults: List<QuizResult>,
    private val questionsFactory: QuestionsFactory,
    private val quizNameToShortDescriptionMapper: QuizNameToShortDescriptionMapper,
    private val quizNameToQuizComplexityMapper: QuizNameToQuizComplexityMapper
) {
    private val names = QuizName.values().toList()

    fun create(): List<Quiz> {
        return names.map { name ->
            Quiz(
                name = name,
                descriptionRes = quizNameToShortDescriptionMapper.map(name),
                questions = questionsFactory.create(name),
                complexity = quizNameToQuizComplexityMapper.map(name),
                results = quizResults.filter { it.name == name }
            )
        }
    }
}