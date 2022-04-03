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
            QuizName.BITCOIN_INTERMEDIATE -> listOf(
                Question(
                    questionId = R.string.bitcoin_intermediate_question_1,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_1_answer_1,
                        R.string.bitcoin_intermediate_question_1_answer_2_correct,
                        R.string.bitcoin_intermediate_question_1_answer_3,
                        R.string.bitcoin_intermediate_question_1_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_1_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_2,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_2_answer_1_correct,
                        R.string.bitcoin_intermediate_question_2_answer_2,
                        R.string.bitcoin_intermediate_question_2_answer_3,
                        R.string.bitcoin_intermediate_question_2_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_2_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_3,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_3_answer_1,
                        R.string.bitcoin_intermediate_question_3_answer_2,
                        R.string.bitcoin_intermediate_question_3_answer_3_correct,
                        R.string.bitcoin_intermediate_question_3_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_3_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_4,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_4_answer_1_correct,
                        R.string.bitcoin_intermediate_question_4_answer_2,
                        R.string.bitcoin_intermediate_question_4_answer_3,
                        R.string.bitcoin_intermediate_question_4_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_4_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_5,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_5_answer_1,
                        R.string.bitcoin_intermediate_question_5_answer_2,
                        R.string.bitcoin_intermediate_question_5_answer_3,
                        R.string.bitcoin_intermediate_question_5_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_5_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_6,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_6_answer_1,
                        R.string.bitcoin_intermediate_question_6_answer_2,
                        R.string.bitcoin_intermediate_question_6_answer_3,
                        R.string.bitcoin_intermediate_question_6_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_6_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_7,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_7_answer_1,
                        R.string.bitcoin_intermediate_question_7_answer_2,
                        R.string.bitcoin_intermediate_question_7_answer_3_correct,
                        R.string.bitcoin_intermediate_question_7_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_7_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_8,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_8_answer_1,
                        R.string.bitcoin_intermediate_question_8_answer_2_correct,
                        R.string.bitcoin_intermediate_question_8_answer_3,
                        R.string.bitcoin_intermediate_question_8_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_8_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_9,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_9_answer_1,
                        R.string.bitcoin_intermediate_question_9_answer_2_correct,
                        R.string.bitcoin_intermediate_question_9_answer_3,
                        R.string.bitcoin_intermediate_question_9_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_9_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_10,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_10_answer_1,
                        R.string.bitcoin_intermediate_question_10_answer_2_correct,
                        R.string.bitcoin_intermediate_question_10_answer_3,
                        R.string.bitcoin_intermediate_question_10_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_10_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_11,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_11_answer_1_correct,
                        R.string.bitcoin_intermediate_question_11_answer_2,
                        R.string.bitcoin_intermediate_question_11_answer_3,
                        R.string.bitcoin_intermediate_question_11_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_11_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_12,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_12_answer_1,
                        R.string.bitcoin_intermediate_question_12_answer_2,
                        R.string.bitcoin_intermediate_question_12_answer_3_correct,
                        R.string.bitcoin_intermediate_question_12_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_12_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_13,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_13_answer_1,
                        R.string.bitcoin_intermediate_question_13_answer_2_correct,
                        R.string.bitcoin_intermediate_question_13_answer_3,
                        R.string.bitcoin_intermediate_question_13_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_13_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_14,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_14_answer_1,
                        R.string.bitcoin_intermediate_question_14_answer_2_correct,
                        R.string.bitcoin_intermediate_question_14_answer_3,
                        R.string.bitcoin_intermediate_question_14_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_14_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_15,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_15_answer_1,
                        R.string.bitcoin_intermediate_question_15_answer_2,
                        R.string.bitcoin_intermediate_question_15_answer_3,
                        R.string.bitcoin_intermediate_question_15_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_15_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_16,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_16_answer_1,
                        R.string.bitcoin_intermediate_question_16_answer_2,
                        R.string.bitcoin_intermediate_question_16_answer_3,
                        R.string.bitcoin_intermediate_question_16_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_16_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_17,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_17_answer_1,
                        R.string.bitcoin_intermediate_question_17_answer_2,
                        R.string.bitcoin_intermediate_question_17_answer_3,
                        R.string.bitcoin_intermediate_question_17_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_17_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_18,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_18_answer_1,
                        R.string.bitcoin_intermediate_question_18_answer_2_correct,
                        R.string.bitcoin_intermediate_question_18_answer_3,
                        R.string.bitcoin_intermediate_question_18_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_18_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_19,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_19_answer_1,
                        R.string.bitcoin_intermediate_question_19_answer_2,
                        R.string.bitcoin_intermediate_question_19_answer_3_correct,
                        R.string.bitcoin_intermediate_question_19_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_19_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_20,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_20_answer_1,
                        R.string.bitcoin_intermediate_question_20_answer_2_correct,
                        R.string.bitcoin_intermediate_question_20_answer_3,
                        R.string.bitcoin_intermediate_question_20_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_20_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_21,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_21_answer_1,
                        R.string.bitcoin_intermediate_question_21_answer_2_correct,
                        R.string.bitcoin_intermediate_question_21_answer_3,
                        R.string.bitcoin_intermediate_question_21_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_21_answer_2_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_22,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_22_answer_1,
                        R.string.bitcoin_intermediate_question_22_answer_2,
                        R.string.bitcoin_intermediate_question_22_answer_3,
                        R.string.bitcoin_intermediate_question_22_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_22_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_23,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_23_answer_1,
                        R.string.bitcoin_intermediate_question_23_answer_2,
                        R.string.bitcoin_intermediate_question_23_answer_3,
                        R.string.bitcoin_intermediate_question_23_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_23_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_24,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_24_answer_1_correct,
                        R.string.bitcoin_intermediate_question_24_answer_2,
                        R.string.bitcoin_intermediate_question_24_answer_3,
                        R.string.bitcoin_intermediate_question_24_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_24_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_25,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_25_answer_1,
                        R.string.bitcoin_intermediate_question_25_answer_2,
                        R.string.bitcoin_intermediate_question_25_answer_3,
                        R.string.bitcoin_intermediate_question_25_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_25_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_26,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_26_answer_1_correct,
                        R.string.bitcoin_intermediate_question_26_answer_2,
                        R.string.bitcoin_intermediate_question_26_answer_3,
                        R.string.bitcoin_intermediate_question_26_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_26_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_27,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_27_answer_1_correct,
                        R.string.bitcoin_intermediate_question_27_answer_2,
                        R.string.bitcoin_intermediate_question_27_answer_3,
                        R.string.bitcoin_intermediate_question_27_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_27_answer_1_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_28,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_28_answer_1,
                        R.string.bitcoin_intermediate_question_28_answer_2,
                        R.string.bitcoin_intermediate_question_28_answer_3_correct,
                        R.string.bitcoin_intermediate_question_28_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_28_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_29,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_29_answer_1,
                        R.string.bitcoin_intermediate_question_29_answer_2,
                        R.string.bitcoin_intermediate_question_29_answer_3,
                        R.string.bitcoin_intermediate_question_29_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_29_answer_4_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_30,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_30_answer_1,
                        R.string.bitcoin_intermediate_question_30_answer_2,
                        R.string.bitcoin_intermediate_question_30_answer_3_correct,
                        R.string.bitcoin_intermediate_question_30_answer_4
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_30_answer_3_correct
                ),
                Question(
                    questionId = R.string.bitcoin_intermediate_question_31,
                    answerIds = listOf(
                        R.string.bitcoin_intermediate_question_31_answer_1,
                        R.string.bitcoin_intermediate_question_31_answer_2,
                        R.string.bitcoin_intermediate_question_31_answer_3,
                        R.string.bitcoin_intermediate_question_31_answer_4_correct
                    ).shuffled(),
                    correctAnswerId = R.string.bitcoin_intermediate_question_31_answer_4_correct
                ),
            )
            QuizName.BITCOIN_HARDCORE -> {
                listOf(
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_1,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_1_answer_1,
                            R.string.bitcoin_hardcore_question_1_answer_2,
                            R.string.bitcoin_hardcore_question_1_answer_3,
                            R.string.bitcoin_hardcore_question_1_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_1_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_2,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_2_answer_1,
                            R.string.bitcoin_hardcore_question_2_answer_2_correct,
                            R.string.bitcoin_hardcore_question_2_answer_3,
                            R.string.bitcoin_hardcore_question_2_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_2_answer_2_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_3,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_3_answer_1,
                            R.string.bitcoin_hardcore_question_3_answer_2,
                            R.string.bitcoin_hardcore_question_3_answer_3,
                            R.string.bitcoin_hardcore_question_3_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_3_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_4,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_4_answer_1,
                            R.string.bitcoin_hardcore_question_4_answer_2,
                            R.string.bitcoin_hardcore_question_4_answer_3_correct,
                            R.string.bitcoin_hardcore_question_4_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_4_answer_3_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_5,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_5_answer_1_correct,
                            R.string.bitcoin_hardcore_question_5_answer_2,
                            R.string.bitcoin_hardcore_question_5_answer_3,
                            R.string.bitcoin_hardcore_question_5_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_5_answer_1_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_6,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_6_answer_1_correct,
                            R.string.bitcoin_hardcore_question_6_answer_2,
                            R.string.bitcoin_hardcore_question_6_answer_3,
                            R.string.bitcoin_hardcore_question_6_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_6_answer_1_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_7,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_7_answer_1,
                            R.string.bitcoin_hardcore_question_7_answer_2_correct,
                            R.string.bitcoin_hardcore_question_7_answer_3,
                            R.string.bitcoin_hardcore_question_7_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_7_answer_2_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_8,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_8_answer_1,
                            R.string.bitcoin_hardcore_question_8_answer_2,
                            R.string.bitcoin_hardcore_question_8_answer_3_correct,
                            R.string.bitcoin_hardcore_question_8_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_8_answer_3_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_9,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_9_answer_1,
                            R.string.bitcoin_hardcore_question_9_answer_2,
                            R.string.bitcoin_hardcore_question_9_answer_3_correct,
                            R.string.bitcoin_hardcore_question_9_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_9_answer_3_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_10,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_10_answer_1_correct,
                            R.string.bitcoin_hardcore_question_10_answer_2,
                            R.string.bitcoin_hardcore_question_10_answer_3,
                            R.string.bitcoin_hardcore_question_10_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_10_answer_1_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_11,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_11_answer_1,
                            R.string.bitcoin_hardcore_question_11_answer_2,
                            R.string.bitcoin_hardcore_question_11_answer_3,
                            R.string.bitcoin_hardcore_question_11_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_11_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_12,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_12_answer_1,
                            R.string.bitcoin_hardcore_question_12_answer_2,
                            R.string.bitcoin_hardcore_question_12_answer_3_correct,
                            R.string.bitcoin_hardcore_question_12_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_12_answer_3_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_13,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_13_answer_1,
                            R.string.bitcoin_hardcore_question_13_answer_2,
                            R.string.bitcoin_hardcore_question_13_answer_3,
                            R.string.bitcoin_hardcore_question_13_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_13_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_14,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_14_answer_1,
                            R.string.bitcoin_hardcore_question_14_answer_2_correct,
                            R.string.bitcoin_hardcore_question_14_answer_3,
                            R.string.bitcoin_hardcore_question_14_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_14_answer_2_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_15,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_15_answer_1,
                            R.string.bitcoin_hardcore_question_15_answer_2,
                            R.string.bitcoin_hardcore_question_15_answer_3_correct,
                            R.string.bitcoin_hardcore_question_15_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_15_answer_3_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_16,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_16_answer_1,
                            R.string.bitcoin_hardcore_question_16_answer_2,
                            R.string.bitcoin_hardcore_question_16_answer_3,
                            R.string.bitcoin_hardcore_question_16_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_16_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_17,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_17_answer_1,
                            R.string.bitcoin_hardcore_question_17_answer_2_correct,
                            R.string.bitcoin_hardcore_question_17_answer_3,
                            R.string.bitcoin_hardcore_question_17_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_17_answer_2_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_18,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_18_answer_1_correct,
                            R.string.bitcoin_hardcore_question_18_answer_2,
                            R.string.bitcoin_hardcore_question_18_answer_3,
                            R.string.bitcoin_hardcore_question_18_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_18_answer_1_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_19,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_19_answer_1,
                            R.string.bitcoin_hardcore_question_19_answer_2,
                            R.string.bitcoin_hardcore_question_19_answer_3_correct,
                            R.string.bitcoin_hardcore_question_19_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_19_answer_3_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_20,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_20_answer_1,
                            R.string.bitcoin_hardcore_question_20_answer_2,
                            R.string.bitcoin_hardcore_question_20_answer_3,
                            R.string.bitcoin_hardcore_question_20_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_20_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_21,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_21_answer_1,
                            R.string.bitcoin_hardcore_question_21_answer_2,
                            R.string.bitcoin_hardcore_question_21_answer_3,
                            R.string.bitcoin_hardcore_question_21_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_21_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_22,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_22_answer_1,
                            R.string.bitcoin_hardcore_question_22_answer_2,
                            R.string.bitcoin_hardcore_question_22_answer_3,
                            R.string.bitcoin_hardcore_question_22_answer_4_correct,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_22_answer_4_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_23,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_23_answer_1,
                            R.string.bitcoin_hardcore_question_23_answer_2_correct,
                            R.string.bitcoin_hardcore_question_23_answer_3,
                            R.string.bitcoin_hardcore_question_23_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_23_answer_4
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_24,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_24_answer_1,
                            R.string.bitcoin_hardcore_question_24_answer_2,
                            R.string.bitcoin_hardcore_question_24_answer_3_correct,
                            R.string.bitcoin_hardcore_question_24_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_24_answer_3_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_25,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_25_answer_1,
                            R.string.bitcoin_hardcore_question_25_answer_2_correct,
                            R.string.bitcoin_hardcore_question_25_answer_3,
                            R.string.bitcoin_hardcore_question_25_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_25_answer_2_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_26,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_26_answer_1,
                            R.string.bitcoin_hardcore_question_26_answer_2_correct,
                            R.string.bitcoin_hardcore_question_26_answer_3,
                            R.string.bitcoin_hardcore_question_26_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_26_answer_2_correct
                    ),
                    Question(
                        questionId = R.string.bitcoin_hardcore_question_27,
                        answerIds = listOf(
                            R.string.bitcoin_hardcore_question_27_answer_1_correct,
                            R.string.bitcoin_hardcore_question_27_answer_2,
                            R.string.bitcoin_hardcore_question_27_answer_3,
                            R.string.bitcoin_hardcore_question_27_answer_4,
                        ).shuffled(),
                        correctAnswerId = R.string.bitcoin_hardcore_question_27_answer_1_correct
                    ),

                )
            }
        }
    }
}