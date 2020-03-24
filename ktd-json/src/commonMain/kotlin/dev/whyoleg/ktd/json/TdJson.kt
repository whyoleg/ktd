package dev.whyoleg.ktd.json

/**
 * tdlib json interface.
 * Requests and responses from tdlib represented as json [String]
 */
@ExperimentalTdInterface
expect object TdJson {
    /**
     * Initiate tdlib
     */
    fun init()

    /**
     * Create tdlib client
     *
     * @return id of created tdlib client
     */
    fun create(): Long

    /**
     * Destroy tdlib client by [clientId]
     *
     * @param clientId id of tdlib client
     */
    fun destroy(clientId: Long)

    /**
     * Send json [String] request to client with [clientId]
     *
     * @param clientId id of tdlib client
     * @param request json [String] request to tdlib
     */
    fun send(clientId: Long, request: String)

    /**
     * Receive json [String] response from client with [clientId], block thread for maximum [timeout] seconds
     *
     * @param clientId id of tdlib client
     * @param timeout maximum duration in seconds to wait for json [String] response
     *
     * @return received json [String] api response or null if no response received during [timeout]
     */
    fun receive(clientId: Long, timeout: Double): String?

    /**
     * Execute json [String] request synchronously, blocking until response received
     *
     * @param request synchronous request to tdlib
     *
     * @return json [String] response from api
     */
    fun execute(request: String): String
}
