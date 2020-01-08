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
 * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom
 * Requires creator privileges
 * Deactivates the original basic group
 *
 * @chatId - Identifier of the chat to upgrade
 */
suspend fun TelegramClient.upgradeBasicGroupChatToSupergroupChat(
    chatId: Long = 0L
): Chat = chat(
    UpgradeBasicGroupChatToSupergroupChat(
        chatId
    )
)

/**
 * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom
 * Requires creator privileges
 * Deactivates the original basic group
 */
suspend fun TelegramClient.chat(
    f: UpgradeBasicGroupChatToSupergroupChat
): Chat = exec(f) as Chat
