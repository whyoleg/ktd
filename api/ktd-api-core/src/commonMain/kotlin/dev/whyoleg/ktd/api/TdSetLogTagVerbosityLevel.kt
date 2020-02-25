package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets the verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 *
 * @property tag Logging tag to change verbosity level
 * @property newVerbosityLevel New verbosity level
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setLogTagVerbosityLevel")
data class TdSetLogTagVerbosityLevel(
    @SerialName("tag")
    val tag: String? = null,
    @SerialName("new_verbosity_level")
    val newVerbosityLevel: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetLogTagVerbosityLevel {
        return copy(extra = extra.copy(id = id))
    }
}
