package koropapps.criptoquiz.feature.quiz.model

sealed class QuizAction {
    class Answer(val answerId: Int) : QuizAction()
    object NavigateToResult: QuizAction()
    object Finish: QuizAction()
}