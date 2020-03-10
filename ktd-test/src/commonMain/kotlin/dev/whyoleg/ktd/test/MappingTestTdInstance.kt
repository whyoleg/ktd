package dev.whyoleg.ktd.test

import dev.whyoleg.ktd.api.*

class MappingTestTdInstance(private val mapping: (TdApiRequest) -> TdResponseOrError) : TestTdInstance {
    private val responses = BlockingQueue<TdApiResponse>()
    fun update(update: TdUpdate): Unit = responses.offer(update)
    override fun send(request: TdApiRequest): Unit = responses.offer(mapping(request))
    override fun receive(timeout: Double): TdApiResponse? = responses.poll(timeout)
}
