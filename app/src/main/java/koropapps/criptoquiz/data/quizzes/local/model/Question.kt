package koropapps.criptoquiz.data.quizzes.local.model

data class Question(val question: String, val variants: List<String>, val correctVariant: String)
