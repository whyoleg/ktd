package dev.whyoleg.ktd

import mu.*

internal object TdLog {
    val logger = KotlinLogging.logger("TdLogger")

    private fun onFatalError(errorMessage: String) {
        logger.error { "Native error in telegram: $errorMessage" }
    }
}
