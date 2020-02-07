package dev.whyoleg.ktd.api

/**
 * Closes the TDLib instance.
 * All databases will be flushed to disk and properly closed.
 * After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
data class TdClose(override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdClose = copy(extra = extra.copy(id = id))
}
