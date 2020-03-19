package dev.whyoleg.ktd.client

/**
 * Runner which configure safely handling api responses from tdlib
 */
interface SynchronizedRunner {
    /**
     * Duration to block thread for receiving tdlib responses
     */
    val timeout: Double get() = TdApi.DEFAULT_RECEIVE_TIMEOUT

    /**
     * Start handling of tdlib responses from client with [id].
     * Must run [block] until it returns false
     *
     * @param id id of tdlib client
     * @param block block which handles tdlib responses
     */
    fun run(id: Long, block: () -> Boolean)

    /**
     * Cleanup runner. Can not be used after cleanup.
     * Must be called by user if runner isn't needed
     */
    fun cleanup(): Unit = Unit
}
