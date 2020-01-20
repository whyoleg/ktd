@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
 * An updateMessageContentOpened update will be generated if something has changed
 *
 * @chatId - Chat identifier of the message
 * @messageId - Identifier of the message with the opened content
 */
suspend fun TelegramClient.openMessageContent(
    chatId: Long = 0L,
    messageId: Long = 0L
): Ok = message(
    OpenMessageContent(
        chatId,
        messageId
    )
)

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
 * An updateMessageContentOpened update will be generated if something has changed
 */
suspend fun TelegramClient.message(
    f: OpenMessageContent
): Ok = exec(f) as Ok
