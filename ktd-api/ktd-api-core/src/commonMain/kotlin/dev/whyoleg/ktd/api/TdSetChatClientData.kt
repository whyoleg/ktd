package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes client data associated with a chat
 *
 * @property chatId Chat identifier
 * @property clientData New value of client_data
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setChatClientData")
data class TdSetChatClientData(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("client_data")
    val clientData: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetChatClientData {
        return copy(extra = extra.copy(id = id))
    }
}
