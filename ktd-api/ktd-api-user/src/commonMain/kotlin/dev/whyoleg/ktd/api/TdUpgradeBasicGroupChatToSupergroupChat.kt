package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom
 * Requires creator privileges
 * Deactivates the original basic group
 *
 * @property chatId Identifier of the chat to upgrade
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("upgradeBasicGroupChatToSupergroupChat")
data class TdUpgradeBasicGroupChatToSupergroupChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdUpgradeBasicGroupChatToSupergroupChat {
        return copy(extra = extra.copy(id = id))
    }
}
