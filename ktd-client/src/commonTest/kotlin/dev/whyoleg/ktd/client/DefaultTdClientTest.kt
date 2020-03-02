package dev.whyoleg.ktd.client

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

class DefaultTdClientTest {
    private class TestTdApi : TdApi {
        override val version: String = "1"

        var clientCreated = false
        var clientDestroyed = false

        override fun createClient(): Long {
            clientCreated = true
            return 1
        }

        override fun destroyClient(clientId: Long) {
            clientDestroyed = true
        }

        override fun sendTo(clientId: Long, request: TdApiRequest) {
        }

        override fun receiveFrom(clientId: Long, timeout: Double): TdApiResponse? {
            TODO("Not yet implemented")
        }

        override fun <R : TdResponse> executeSynchronously(request: TdSyncRequest<R>): TdResult<R> {
            TODO("Not yet implemented")
        }
    }

    //TODO close callback
    //TODO updates callback
    //TODO closing check
    //TODO closed check
    //TODO response on request check
    //TODO error on request check
    //TODO all callbacks handled check
    //TODO response ignore check
    //TODO response error ignore check
    //TODO close/destroy/logout request and send
    //TODO throw error on receive/update/close

}
