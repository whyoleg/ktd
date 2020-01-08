@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.call

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new call
 *
 * @userId - Identifier of the user to be called
 * @protocol - Description of the call protocols supported by the client
 */
suspend fun TelegramClient.createCall(
    userId: Int = 0,
    protocol: CallProtocol? = null
): CallId = call(
    CreateCall(
        userId,
        protocol
    )
)

/**
 * Creates a new call
 */
suspend fun TelegramClient.call(
    f: CreateCall
): CallId = exec(f) as CallId
