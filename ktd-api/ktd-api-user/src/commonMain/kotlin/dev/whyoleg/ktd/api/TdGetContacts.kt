package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns all user contacts
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getContacts")
data class TdGetContacts(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdUsers> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetContacts {
        return copy(extra = extra.copy(id = id))
    }
}
