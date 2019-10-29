package dev.whyoleg.ktd

internal object TdLog {
    private fun onFatalError(errorMessage: String) {
        println("TELEGRAM FATAL ERROR: $errorMessage")
    }
}
