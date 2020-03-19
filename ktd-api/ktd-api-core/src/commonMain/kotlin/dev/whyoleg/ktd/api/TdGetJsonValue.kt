package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Converts a JSON-serialized string to corresponding JsonValue object
 * This is an offline method
 * Can be called before authorization
 *
 * @property json The JSON-serialized string
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getJsonValue")
data class TdGetJsonValue(
    @SerialName("json")
    val json: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdJsonValue> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetJsonValue {
        return copy(extra = extra.copy(id = id))
    }
}
