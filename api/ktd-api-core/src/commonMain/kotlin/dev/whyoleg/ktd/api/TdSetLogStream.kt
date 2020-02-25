package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 *
 * @property logStream New log stream
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setLogStream")
data class TdSetLogStream(
    @SerialName("log_stream")
    val logStream: TdLogStream? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetLogStream {
        return copy(extra = extra.copy(id = id))
    }
}
