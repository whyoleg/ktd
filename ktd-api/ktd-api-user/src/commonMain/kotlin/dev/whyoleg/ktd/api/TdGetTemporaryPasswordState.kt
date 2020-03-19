package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about the current temporary password
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getTemporaryPasswordState")
data class TdGetTemporaryPasswordState(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdTemporaryPasswordState> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetTemporaryPasswordState {
        return copy(extra = extra.copy(id = id))
    }
}
