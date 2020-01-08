@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.check

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Sets the result of a pre-checkout query
 *
 * @preCheckoutQueryId - Identifier of the pre-checkout query
 * @errorMessage - An error message, empty on success
 */
@BotsOnly
suspend fun TelegramClient.answerPreCheckoutQuery(
    preCheckoutQueryId: Long = 0L,
    errorMessage: String? = null
): Ok = check(
    AnswerPreCheckoutQuery(
        preCheckoutQueryId,
        errorMessage
    )
)

/**
 * Sets the result of a pre-checkout query
 */
@BotsOnly
suspend fun TelegramClient.check(
    f: AnswerPreCheckoutQuery
): Ok = exec(f) as Ok
