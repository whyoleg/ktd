package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Creates a new secret chat
 * Returns the newly created chat
 *
 * @property userId Identifier of the target user
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("createNewSecretChat")
data class TdCreateNewSecretChat(
    @SerialName("user_id")
    val userId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdChat> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCreateNewSecretChat {
        return copy(extra = extra.copy(id = id))
    }
}
