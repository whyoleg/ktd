package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLogVerbosityLevel")
data class TdGetLogVerbosityLevel(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdLogVerbosityLevel> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLogVerbosityLevel {
        return copy(extra = extra.copy(id = id))
    }
}
