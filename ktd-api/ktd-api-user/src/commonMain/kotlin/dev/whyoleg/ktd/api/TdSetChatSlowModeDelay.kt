package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the slow mode delay of a chat
 * Available only for supergroups
 * Requires can_restrict_members rights
 *
 * @property chatId Chat identifier
 * @property slowModeDelay New slow mode delay for the chat
 *                         Must be one of 0, 10, 30, 60, 300, 900, 3600
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatSlowModeDelay")
data class TdSetChatSlowModeDelay(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("slow_mode_delay")
    val slowModeDelay: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatSlowModeDelay {
        return copy(extra = extra.copy(id = id))
    }
}
