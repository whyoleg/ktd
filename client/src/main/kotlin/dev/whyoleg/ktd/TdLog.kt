package dev.whyoleg.ktd

internal object TdLog {
    //TODO change it when after support MPP
    private fun onFatalError(errorMessage: String) {
        println("TELEGRAM FATAL ERROR: $errorMessage")
    }
}
