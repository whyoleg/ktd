package dev.whyoleg.ktd.client.api

import dev.whyoleg.ktd.api.*

data class ClientManager<Response, ResponseHandler : Any, ResponseHandlerInput : Any, Updates : Any>(
    private val runner: SynchronizedRunner,
    private val mapper: ResponseMapper<Response, ResponseHandler, ResponseHandlerInput>,
    private val storage: ResponseHandlerStorage<ResponseHandler>,
    private val updatesManager: UpdatesManager<Updates>
) {

    val updates: Updates get() = updatesManager.updates

    fun save(requestId: Long, input: ResponseHandlerInput? = null): ResponseHandler {
        val handler = mapper.create(input)
        storage[requestId] = handler
        return handler
    }

    fun getResponse(handler: ResponseHandler): Response = mapper.getResponse(handler)

    fun consume(block: (timeout: Double) -> TelegramApiResponse?) {
        runner.run {
            block(runner.timeout)?.map(updatesManager::handle) { mapper.complete(storage[it.extra.id], it) }
        }
    }
}

private inline fun <T> TelegramApiResponse.map(
    onUpdate: (TelegramUpdate) -> T,
    onResponseOrError: (TelegramResponseOrError) -> T
): T = when (this) {
    is TelegramResponseOrError -> onResponseOrError(this)
    is TelegramUpdate          -> onUpdate(this)
    else                       -> error("")
}
