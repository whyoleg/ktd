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
 * Checks whether a maximum number of owned public chats is reached
 * Returns corresponding error if the limit was reached
 *
 * @type - Type of the public chats, for which to check the limit
 */
suspend fun TelegramClient.checkCreatedPublicChatsLimit(
    type: PublicChatType? = null
): Ok = check(
    CheckCreatedPublicChatsLimit(
        type
    )
)

/**
 * Checks whether a maximum number of owned public chats is reached
 * Returns corresponding error if the limit was reached
 */
suspend fun TelegramClient.check(
    f: CheckCreatedPublicChatsLimit
): Ok = exec(f) as Ok
