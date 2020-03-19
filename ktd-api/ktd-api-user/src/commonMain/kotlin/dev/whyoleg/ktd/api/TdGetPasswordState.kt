package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the current state of 2-step verification
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getPasswordState")
data class TdGetPasswordState(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetPasswordState {
        return copy(extra = extra.copy(id = id))
    }
}
