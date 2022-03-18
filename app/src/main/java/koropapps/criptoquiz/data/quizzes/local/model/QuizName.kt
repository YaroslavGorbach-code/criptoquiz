package koropapps.criptoquiz.data.quizzes.local.model

import koropapps.criptoquiz.R

enum class QuizName(val resId: Int) {
    NONE(R.string.empty),
    TEST(R.string.test_quiz_name),
    WHAT_D_Y_KNOW_ABOUT_BLOCKCHAIN(R.string.empty)
}