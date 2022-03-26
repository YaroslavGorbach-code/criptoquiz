package koropapps.criptoquiz.base.utill

suspend inline fun <T> T.alsoSuspend(crossinline block: suspend (T) -> Unit) = also { block(it) }