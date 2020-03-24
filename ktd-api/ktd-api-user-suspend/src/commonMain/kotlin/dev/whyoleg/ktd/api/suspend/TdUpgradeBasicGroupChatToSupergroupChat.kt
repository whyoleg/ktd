package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom
 * Requires creator privileges
 * Deactivates the original basic group
 *
 * @property chatId Identifier of the chat to upgrade
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.upgradeBasicGroupChatToSupergroupChat(chatId: Long = 0L, extra: TdExtra
        = TdExtra.EMPTY): TdChat = exec(TdUpgradeBasicGroupChatToSupergroupChat(chatId, extra))
