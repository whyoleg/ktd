package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns an existing chat corresponding to a given user
 *
 * @property userId User identifier
 * @property force If true, the chat will be created without network request
 *                 In this case all information about the chat except its type, title and photo can be incorrect
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createPrivateChat")
data class TdCreatePrivateChat(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("force")
    val force: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreatePrivateChat {
        return copy(extra = extra.copy(id = id))
    }
}
