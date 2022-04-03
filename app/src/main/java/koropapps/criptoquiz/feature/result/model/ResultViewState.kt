package koropapps.criptoquiz.feature.result.model

import koropapps.criptoquiz.data.quizzes.local.model.Answer
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

data class ResultViewState(
    val answers: List<Answer> = listOf(
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
        Answer.Test,
    ),
    val name: QuizName = QuizName.BITCOIN_BEGINNER
) {
    companion object {
        val Test = ResultViewState()
    }
}
