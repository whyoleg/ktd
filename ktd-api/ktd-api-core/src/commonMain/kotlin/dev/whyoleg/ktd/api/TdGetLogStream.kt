package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about currently used log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getLogStream")
data class TdGetLogStream(
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdLogStream> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetLogStream {
        return copy(extra = extra.copy(id = id))
    }
}
