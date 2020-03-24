package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

/**
 * Simplest client to interact with tdlib.
 * Can be used to create more complex clients
 *
 * @property api api to work with tdlib
 */
class TdApiClient(private val api: TdApi) {
    /**
     * Id of tdlib client
     */
    val id: Long by lazy { api.createClient() }

    /**
     * Destroy client. Thread unsafe.
     * Will throw an error if called while [unsafeReceive] is in progress
     */
    fun unsafeDestroy(): Unit = api.destroyClient(id)

    /**
     * Send untyped [TdApiRequest] to tdlib client.
     * Don't add any info for linking request with response
     *
     * @param request untyped request
     */
    fun unsafeSend(request: TdApiRequest): Unit = api.sendTo(id, request)

    /**
     * Receive [TdApiResponse] from tdlib client, block thread for maximum [timeout] seconds. Thread unsafe.
     *
     * @param timeout maximum duration in seconds to wait for [TdApiResponse]
     *
     * @return received [TdApiResponse] or null if no [TdApiResponse] received during [timeout]
     */
    fun unsafeReceive(timeout: Double = TdApi.DEFAULT_RECEIVE_TIMEOUT): TdApiResponse? = api.receiveFrom(id, timeout)
}
