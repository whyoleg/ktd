@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Changes the location of a chat
 * Available only for some location-based supergroups, use supergroupFullInfo.can_set_location to check whether the method is allowed to use
 *
 * @chatId - Chat identifier
 * @location - New location for the chat
 *             Must be valid and not null
 */
suspend fun TelegramClient.setChatLocation(
    chatId: Long = 0L,
    location: ChatLocation? = null
): Ok = chat(
    SetChatLocation(
        chatId,
        location
    )
)

/**
 * Changes the location of a chat
 * Available only for some location-based supergroups, use supergroupFullInfo.can_set_location to check whether the method is allowed to use
 */
suspend fun TelegramClient.chat(
    f: SetChatLocation
): Ok = exec(f) as Ok
