package dev.whyoleg.ktd.test

import dev.whyoleg.ktd.api.*

class ManualTestTdInstance : TestTdInstance {
    private val responses = BlockingQueue<TdApiResponse>()
    private val _requests = mutableListOf<TdApiRequest>()
    val requests: List<TdApiRequest> get() = _requests
    fun update(update: TdUpdate): Unit = responses.offer(update)
    fun response(response: TdResponseOrError): Unit = responses.offer(response)

    override fun send(request: TdApiRequest) {
        _requests += request
    }

    override fun receive(timeout: Double): TdApiResponse? = responses.poll(timeout)
}
