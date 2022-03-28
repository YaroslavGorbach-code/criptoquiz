package koropapps.criptoquiz.feature.result.model

sealed class ResultAction {
    object Repeat : ResultAction()
    object OnBack : ResultAction()
}