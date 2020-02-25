package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Informs the server about the number of pending bot updates if they haven't been processed for a long time
 *
 * @property pendingUpdateCount The number of pending updates
 * @property errorMessage The last error message
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("setBotUpdatesStatus")
data class TdSetBotUpdatesStatus(
    @SerialName("pending_update_count")
    val pendingUpdateCount: Int = 0,
    @SerialName("error_message")
    val errorMessage: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdSetBotUpdatesStatus {
        return copy(extra = extra.copy(id = id))
    }
}
