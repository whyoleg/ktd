package dev.whyoleg.ktd.api

data class TdClose(override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdClose = copy(extra = extra.copy(id = id))
}
