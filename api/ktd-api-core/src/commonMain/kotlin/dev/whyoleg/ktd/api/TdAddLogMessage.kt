package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Adds a message to TDLib internal log
 * This is an offline method
 * Can be called before authorization
 *
 * @property verbosityLevel The minimum verbosity level needed for the message to be logged, 0-1023
 * @property text Text of a message to log
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("addLogMessage")
data class TdAddLogMessage(
    @SerialName("verbosity_level")
    val verbosityLevel: Int = 0,
    @SerialName("text")
    val text: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdAddLogMessage {
        return copy(extra = extra.copy(id = id))
    }
}
