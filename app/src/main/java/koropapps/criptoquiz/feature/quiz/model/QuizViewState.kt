package koropapps.criptoquiz.feature.quiz.model

import koropapps.criptoquiz.data.quizzes.local.model.Question
import koropapps.criptoquiz.data.quizzes.local.model.Quiz

data class QuizViewState(
    val quiz: Quiz = Quiz.Test,
    val question: Question? = Question.Test,
    val questionsSize: Int = quiz.questions.size,
    val answersSize: Int = 0,
    val progress: Float = 0f,
    val isFinish: Boolean = false,
) {
    companion object {
        val Test = QuizViewState()
    }
}
