package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends a custom request
 *
 * @property method The method name
 * @property parameters JSON-serialized method parameters
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendCustomRequest")
data class TdSendCustomRequest(
    @SerialName("method")
    val method: String? = null,
    @SerialName("parameters")
    val parameters: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCustomRequestResult> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendCustomRequest {
        return copy(extra = extra.copy(id = id))
    }
}
