package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns all active live locations that should be updated by the client
 * The list is persistent across application restarts only if the message database is used
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getActiveLiveLocationMessages")
data class TdGetActiveLiveLocationMessages(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdMessages> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetActiveLiveLocationMessages {
        return copy(extra = extra.copy(id = id))
    }
}
