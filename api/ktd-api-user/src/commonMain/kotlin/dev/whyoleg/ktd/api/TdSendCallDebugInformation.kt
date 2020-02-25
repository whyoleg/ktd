package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sends debug information for a call
 *
 * @property callId Call identifier
 * @property debugInformation Debug information in application-specific format
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("sendCallDebugInformation")
data class TdSendCallDebugInformation(
    @SerialName("call_id")
    val callId: Int = 0,
    @SerialName("debug_information")
    val debugInformation: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSendCallDebugInformation {
        return copy(extra = extra.copy(id = id))
    }
}
