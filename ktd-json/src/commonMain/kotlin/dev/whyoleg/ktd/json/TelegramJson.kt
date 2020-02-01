package dev.whyoleg.ktd.json

expect object TelegramJson {
    fun init()
    fun create(): Long
    fun destroy(clientId: Long)
    fun send(clientId: Long, request: String)
    fun receive(clientId: Long, timeout: Double): String?
    fun execute(request: String): String
}
