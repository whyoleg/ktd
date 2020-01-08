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
 * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate
 * Returns the newly created chat
 *
 * @userIds - Identifiers of users to be added to the basic group
 * @title - Title of the new basic group
 */
suspend fun TelegramClient.createNewBasicGroupChat(
    userIds: IntArray = intArrayOf(),
    title: String? = null
): Chat = chat(
    CreateNewBasicGroupChat(
        userIds,
        title
    )
)

/**
 * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate
 * Returns the newly created chat
 */
suspend fun TelegramClient.chat(
    f: CreateNewBasicGroupChat
): Chat = exec(f) as Chat
