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
 * Returns an existing chat corresponding to a known supergroup or channel
 *
 * @supergroupId - Supergroup or channel identifier
 * @force - If true, the chat will be created without network request
 *          In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TelegramClient.createSupergroupChat(
    supergroupId: Int = 0,
    force: Boolean = false
): Chat = chat(
    CreateSupergroupChat(
        supergroupId,
        force
    )
)

/**
 * Returns an existing chat corresponding to a known supergroup or channel
 */
suspend fun TelegramClient.chat(
    f: CreateSupergroupChat
): Chat = exec(f) as Chat
