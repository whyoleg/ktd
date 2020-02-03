package dev.whyoleg.ktd.api

data class TdLogOut(override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdLogOut = copy(extra = extra.copy(id = id))
}
