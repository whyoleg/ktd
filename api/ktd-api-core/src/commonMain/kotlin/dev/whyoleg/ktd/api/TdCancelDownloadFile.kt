package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Stops the downloading of a file
 * If a file has already been downloaded, does nothing
 *
 * @property fileId Identifier of a file to stop downloading
 * @property onlyIfPending Pass true to stop downloading only if it hasn't been started, i.e
 *                         Request hasn't been sent to server
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("cancelDownloadFile")
data class TdCancelDownloadFile(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("only_if_pending")
    val onlyIfPending: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCancelDownloadFile {
        return copy(extra = extra.copy(id = id))
    }
}
