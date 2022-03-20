package koropapps.criptoquiz.data.quizzes.local.factory

import koropapps.criptoquiz.R
import koropapps.criptoquiz.data.quizzes.local.model.Question
import koropapps.criptoquiz.data.quizzes.local.model.QuizName

class QuestionsFactory {
    fun create(name: QuizName): List<Question> {
        return when (name) {
            QuizName.BITCOIN_BEGINNER -> listOf(
                Question(
                    questionId = R.string.bitcoin_beginer_question_1,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_1_answer_1,
                        R.string.bitcoin_beginer_question_1_answer_2,
                        R.string.bitcoin_beginer_question_1_answer_3_correct,
                        R.string.bitcoin_beginer_question_1_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_1_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_2,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_2_answer_1,
                        R.string.bitcoin_beginer_question_2_answer_2_correct,
                        R.string.bitcoin_beginer_question_2_answer_3,
                        R.string.bitcoin_beginer_question_2_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_2_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_3,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_3_answer_1,
                        R.string.bitcoin_beginer_question_3_answer_2,
                        R.string.bitcoin_beginer_question_3_answer_3,
                        R.string.bitcoin_beginer_question_3_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_3_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_4,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_4_answer_1_correct,
                        R.string.bitcoin_beginer_question_4_answer_2,
                        R.string.bitcoin_beginer_question_4_answer_3,
                        R.string.bitcoin_beginer_question_4_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_4_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_5,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_5_answer_1,
                        R.string.bitcoin_beginer_question_5_answer_2,
                        R.string.bitcoin_beginer_question_5_answer_3_correct,
                        R.string.bitcoin_beginer_question_5_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_5_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_6,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_6_answer_1_correct,
                        R.string.bitcoin_beginer_question_6_answer_2,
                        R.string.bitcoin_beginer_question_6_answer_3,
                        R.string.bitcoin_beginer_question_6_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_6_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_7,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_7_answer_1,
                        R.string.bitcoin_beginer_question_7_answer_2,
                        R.string.bitcoin_beginer_question_7_answer_3_correct,
                        R.string.bitcoin_beginer_question_7_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_7_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_8,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_8_answer_1,
                        R.string.bitcoin_beginer_question_8_answer_2,
                        R.string.bitcoin_beginer_question_8_answer_3,
                        R.string.bitcoin_beginer_question_8_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_8_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_9,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_9_answer_1,
                        R.string.bitcoin_beginer_question_9_answer_2,
                        R.string.bitcoin_beginer_question_9_answer_3_correct,
                        R.string.bitcoin_beginer_question_9_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_9_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_10,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_10_answer_1_correct,
                        R.string.bitcoin_beginer_question_10_answer_2,
                        R.string.bitcoin_beginer_question_10_answer_3,
                        R.string.bitcoin_beginer_question_10_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_10_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_11,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_11_answer_1,
                        R.string.bitcoin_beginer_question_11_answer_2,
                        R.string.bitcoin_beginer_question_11_answer_3,
                        R.string.bitcoin_beginer_question_11_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_11_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_12,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_12_answer_1,
                        R.string.bitcoin_beginer_question_12_answer_2,
                        R.string.bitcoin_beginer_question_12_answer_3,
                        R.string.bitcoin_beginer_question_12_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_12_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_13,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_13_answer_1,
                        R.string.bitcoin_beginer_question_13_answer_2,
                        R.string.bitcoin_beginer_question_13_answer_3,
                        R.string.bitcoin_beginer_question_13_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_13_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_14,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_14_answer_1,
                        R.string.bitcoin_beginer_question_14_answer_2,
                        R.string.bitcoin_beginer_question_14_answer_3,
                        R.string.bitcoin_beginer_question_14_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_14_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_15,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_15_answer_1,
                        R.string.bitcoin_beginer_question_15_answer_2,
                        R.string.bitcoin_beginer_question_15_answer_3_correct,
                        R.string.bitcoin_beginer_question_15_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_15_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_16,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_16_answer_1_correct,
                        R.string.bitcoin_beginer_question_16_answer_2,
                        R.string.bitcoin_beginer_question_16_answer_3,
                        R.string.bitcoin_beginer_question_16_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_16_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_17,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_17_answer_1,
                        R.string.bitcoin_beginer_question_17_answer_2_correct,
                        R.string.bitcoin_beginer_question_17_answer_3,
                        R.string.bitcoin_beginer_question_17_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_17_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_18,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_18_answer_1_correct,
                        R.string.bitcoin_beginer_question_18_answer_2,
                        R.string.bitcoin_beginer_question_18_answer_3,
                        R.string.bitcoin_beginer_question_18_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_18_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_19,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_19_answer_1_correct,
                        R.string.bitcoin_beginer_question_19_answer_2,
                        R.string.bitcoin_beginer_question_19_answer_3,
                        R.string.bitcoin_beginer_question_19_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_19_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_beginer_question_20,
                    answerIds = listOf(
                        R.string.bitcoin_beginer_question_20_answer_1,
                        R.string.bitcoin_beginer_question_20_answer_2,
                        R.string.bitcoin_beginer_question_20_answer_3_correct,
                        R.string.bitcoin_beginer_question_20_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_beginer_question_20_answer_3_correct
                ),
            ).shuffled()
            QuizName.TEST -> emptyList()
        }
    }
}