package dev.whyoleg.ktd

import dev.whyoleg.ktd.api.*

@Deprecated("Replaced by TdJson and one of [User,Bots,Core]TdApi instead. For user api - UserTdApi", level = DeprecationLevel.ERROR)
object TelegramRawClient {
    @Deprecated("Use TdJson.create or AnyTdApi.createClient", level = DeprecationLevel.ERROR)
    fun create(): Long = error("")

    @Deprecated("Use TdJson.destroy or AnyTdApi.destroyClient", level = DeprecationLevel.ERROR)
    fun destroy(clientId: Long): Unit = error("")

    @Deprecated("Use TdJson.send or AnyTdApi.sendTo", level = DeprecationLevel.ERROR)
    fun send(clientId: Long, eventId: Long, function: TdApiRequest): Unit = error("")

    @Deprecated("Use TdJson.receive or AnyTdApi.receiveFrom", level = DeprecationLevel.ERROR)
    fun receive(clientId: Long, eventIds: LongArray, events: Array<TdApiResponse?>, timeout: Double): Int = error("")

    @Deprecated("Use TdJson.execute or AnyTdApi.executeSynchronously", level = DeprecationLevel.ERROR)
    fun execute(function: TdApiRequest): TdApiResponse = error("")

}
