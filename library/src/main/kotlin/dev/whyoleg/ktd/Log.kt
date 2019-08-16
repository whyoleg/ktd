package dev.whyoleg.ktd

internal object Log {
    private fun onFatalError(errorMessage: String) {
        Client.nativeLogger.error { "Native error in telegram: $errorMessage" }
    }
}
