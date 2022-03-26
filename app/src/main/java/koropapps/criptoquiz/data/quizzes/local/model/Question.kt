package koropapps.criptoquiz.data.quizzes.local.model

import koropapps.criptoquiz.R

data class Question(val questionId: Int, val answerIds: List<Int>, val correctAnswerId: Int) {
    companion object {
        val Test = Question(R.string.number_of_questions, emptyList(), R.string.empty)
    }

    fun getAnswer(answerId: Int) = Answer(this, answerId == correctAnswerId)
}
