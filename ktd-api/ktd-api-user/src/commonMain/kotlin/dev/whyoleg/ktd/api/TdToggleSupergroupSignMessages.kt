package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Toggles sender signatures messages sent in a channel
 * Requires can_change_info rights
 *
 * @property supergroupId Identifier of the channel
 * @property signMessages New value of sign_messages
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("toggleSupergroupSignMessages")
data class TdToggleSupergroupSignMessages(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("sign_messages")
    val signMessages: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdToggleSupergroupSignMessages {
        return copy(extra = extra.copy(id = id))
    }
}
