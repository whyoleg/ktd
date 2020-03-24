package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Saves application log event on the server
 * Can be called before authorization
 *
 * @property type Event type
 * @property chatId Optional chat identifier, associated with the event
 * @property data The log event data
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("saveApplicationLogEvent")
data class TdSaveApplicationLogEvent(
    @SerialName("type")
    val type: String? = null,
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("data")
    val data: TdJsonValue? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSaveApplicationLogEvent {
        return copy(extra = extra.copy(id = id))
    }
}
