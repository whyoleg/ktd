package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the username of a supergroup or channel, requires owner privileges in the supergroup or channel
 *
 * @property supergroupId Identifier of the supergroup or channel
 * @property username New value of the username
 *                    Use an empty string to remove the username
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setSupergroupUsername")
data class TdSetSupergroupUsername(
    @SerialName("supergroup_id")
    val supergroupId: Int = 0,
    @SerialName("username")
    val username: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetSupergroupUsername {
        return copy(extra = extra.copy(id = id))
    }
}
