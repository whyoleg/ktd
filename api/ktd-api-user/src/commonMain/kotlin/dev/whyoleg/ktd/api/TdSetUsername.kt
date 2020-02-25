package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Changes the username of the current user
 * If something changes, updateUser will be sent
 *
 * @property username The new value of the username
 *                    Use an empty string to remove the username
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setUsername")
data class TdSetUsername(
    @SerialName("username")
    val username: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetUsername {
        return copy(extra = extra.copy(id = id))
    }
}
