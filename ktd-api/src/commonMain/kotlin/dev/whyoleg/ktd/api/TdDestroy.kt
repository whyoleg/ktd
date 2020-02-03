package dev.whyoleg.ktd.api

data class TdDestroy(override val extra: TdExtra = TdExtra.EMPTY) : TdRequest<TdOk> {
    override fun withRequestId(id: Long): TdDestroy = copy(extra = extra.copy(id = id))
}
