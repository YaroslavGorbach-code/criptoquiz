package koropapps.criptoquiz.data.quizzes.local.model

data class Question(val questionId: Int, val answerIds: List<Int>, val correctAnswerId: Int)
