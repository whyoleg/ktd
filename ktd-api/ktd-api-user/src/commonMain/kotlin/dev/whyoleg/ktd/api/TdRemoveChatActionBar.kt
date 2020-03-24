package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes a chat action bar without any other action
 *
 * @property chatId Chat identifier
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("removeChatActionBar")
data class TdRemoveChatActionBar(
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdRemoveChatActionBar {
        return copy(extra = extra.copy(id = id))
    }
}
