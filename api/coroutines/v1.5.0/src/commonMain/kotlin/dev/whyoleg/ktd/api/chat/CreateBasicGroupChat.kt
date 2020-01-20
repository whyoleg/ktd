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
 * Returns an existing chat corresponding to a known basic group
 *
 * @basicGroupId - Basic group identifier
 * @force - If true, the chat will be created without network request
 *          In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TelegramClient.createBasicGroupChat(
    basicGroupId: Int = 0,
    force: Boolean = false
): Chat = chat(
    CreateBasicGroupChat(
        basicGroupId,
        force
    )
)

/**
 * Returns an existing chat corresponding to a known basic group
 */
suspend fun TelegramClient.chat(
    f: CreateBasicGroupChat
): Chat = exec(f) as Chat
