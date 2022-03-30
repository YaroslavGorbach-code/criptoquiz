package koropapps.criptoquiz.data.quizzes.local.model

import android.util.Log
import koropapps.criptoquiz.base.utill.calculatePercentage

data class Answer(val question: Question, val isCorrect: Boolean)

fun List<Answer>.getCorrectPercentage(): Float {
   return calculatePercentage(value = filter { it.isCorrect }.size, totalValue = size)
}