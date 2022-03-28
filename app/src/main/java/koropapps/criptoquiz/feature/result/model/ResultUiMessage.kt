package koropapps.criptoquiz.feature.result.model

sealed class ResultUiMessage {
    object Repeat : ResultUiMessage()
    object OnBack : ResultUiMessage()
}