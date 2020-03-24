package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 *
 * @property jsonValue The JsonValue object
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getJsonString")
data class TdGetJsonString(
    @SerialName("json_value")
    val jsonValue: TdJsonValue? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetJsonString {
        return copy(extra = extra.copy(id = id))
    }
}
