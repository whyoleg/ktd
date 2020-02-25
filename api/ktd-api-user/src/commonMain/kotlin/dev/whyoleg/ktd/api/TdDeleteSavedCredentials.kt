package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes saved credentials for all payment provider bots
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteSavedCredentials")
data class TdDeleteSavedCredentials(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteSavedCredentials {
        return copy(extra = extra.copy(id = id))
    }
}
