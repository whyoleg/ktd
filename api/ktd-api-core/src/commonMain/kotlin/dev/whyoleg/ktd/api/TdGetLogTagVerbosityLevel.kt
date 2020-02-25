package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 *
 * @property tag Logging tag to change verbosity level
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLogTagVerbosityLevel")
data class TdGetLogTagVerbosityLevel(
    @SerialName("tag")
    val tag: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdLogVerbosityLevel> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLogTagVerbosityLevel {
        return copy(extra = extra.copy(id = id))
    }
}
