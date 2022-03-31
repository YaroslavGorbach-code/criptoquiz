package koropapps.criptoquiz.data.quizzes.local.model

import koropapps.criptoquiz.base.utill.calculatePercentage

data class Answer(val question: Question, val isCorrect: Boolean) {
   companion object {
      val Test = Answer(Question.Test, false)
   }
}

fun List<Answer>.getCorrectPercentage(): Float {
   return calculatePercentage(value = filter { it.isCorrect }.size, totalValue = size)
}