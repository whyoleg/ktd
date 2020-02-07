package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Closes the TDLib instance.
 * All databases will be flushed to disk and properly closed.
 * After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
@Serializable
@SerialName("close")
data class TdClose(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdClose = copy(extra = extra.copy(id = id))
}
