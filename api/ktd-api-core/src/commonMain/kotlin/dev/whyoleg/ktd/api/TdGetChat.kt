package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getChat")
data class TdGetChat(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetChat {
        return copy(extra = extra.copy(id = id))
    }
}
