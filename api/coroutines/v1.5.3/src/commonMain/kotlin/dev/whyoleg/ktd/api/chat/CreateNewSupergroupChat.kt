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
 * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate
 * Returns the newly created chat
 *
 * @title - Title of the new chat
 * @isChannel - True, if a channel chat should be created
 * @description - Chat description
 * @location - Chat location if a location-based supergroup is being created
 */
suspend fun TelegramClient.createNewSupergroupChat(
    title: String? = null,
    isChannel: Boolean = false,
    description: String? = null,
    location: ChatLocation? = null
): Chat = chat(
    CreateNewSupergroupChat(
        title,
        isChannel,
        description,
        location
    )
)

/**
 * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate
 * Returns the newly created chat
 */
suspend fun TelegramClient.chat(
    f: CreateNewSupergroupChat
): Chat = exec(f) as Chat
