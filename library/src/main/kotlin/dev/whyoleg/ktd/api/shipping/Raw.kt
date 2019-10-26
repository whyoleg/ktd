@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.shipping

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the result of a shipping query
 */
@BotsOnly
suspend fun TelegramClient.shipping(
    f: AnswerShippingQuery
): Ok = execRaw(f) as Ok
