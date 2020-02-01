package dev.whyoleg.ktd.json

actual object TelegramJson {
    fun init(libPath: String): Unit = loadTdlib(libPath)
    actual fun init(): Unit = loadTdlib(null)
    actual external fun create(): Long
    actual external fun destroy(clientId: Long)
    actual external fun send(clientId: Long, request: String)
    actual external fun receive(clientId: Long, timeout: Double): String?
    actual external fun execute(request: String): String
}
