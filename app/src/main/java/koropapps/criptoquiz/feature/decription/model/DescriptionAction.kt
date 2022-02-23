package koropapps.criptoquiz.feature.decription.model

import koropapps.criptoquiz.data.quizzes.local.model.Quiz

sealed class DescriptionAction {
    class OpenQuiz(val quiz: Quiz) : DescriptionAction()
}