package dev.whyoleg.ktd.json

import dev.whyoleg.ktd.*

@PublishedApi
internal object TdJson {
    init {
        initTdlib()
    }

    external fun create(): Long
    external fun destroy(clientId: Long)
    external fun send(clientId: Long, request: String)
    external fun receive(clientId: Long, timeout: Double): String?
    external fun execute(request: String): String
}
