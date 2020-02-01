package dev.whyoleg.ktd.client.api.deferred

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.api.*
import kotlinx.coroutines.*

class DeferredMapper(job: Job) : ResponseMapper<DeferredResponse, DeferredResponseHandler, Nothing> {
    private val supervisorJob = SupervisorJob(job)
    override fun create(input: Nothing?): DeferredResponseHandler = CompletableDeferred(supervisorJob)
    override fun complete(handler: DeferredResponseHandler, response: TelegramResponseOrError) {
        response.map(handler::complete, handler::completeExceptionally)
    }

    @Suppress("DeferredIsResult")
    override fun getResponse(handler: DeferredResponseHandler): DeferredResponse = handler
}
