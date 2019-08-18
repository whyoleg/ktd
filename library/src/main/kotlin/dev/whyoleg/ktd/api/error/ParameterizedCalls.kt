@file:Suppress("unused")

package dev.whyoleg.ktd.api.error

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Does nothing and ensures that the Error object is used; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.testUseError(): Error = error(
    TestUseError()
)
