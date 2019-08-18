@file:Suppress("unused")

package dev.whyoleg.ktd.api.update

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Does nothing and ensures that the Update object is used; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.testUseUpdate(): Update = update(
    TestUseUpdate()
)
