package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Downloads a file from the cloud
 * Download progress and completion of the download will be notified through updateFile updates
 *
 * @property fileId Identifier of the file to download
 * @property priority Priority of the download (1-32)
 *                    The higher the priority, the earlier the file will be downloaded
 *                    If the priorities of two files are equal, then the last one for which downloadFile was called will be downloaded first
 * @property offset The starting position from which the file should be downloaded
 * @property limit Number of bytes which should be downloaded starting from the "offset" position before the download will be automatically cancelled
 *                 Use 0 to download without a limit
 * @property synchronous If false, this request returns file state just after the download has been started
 *                       If true, this request returns file state only after the download has succeeded, has failed, has been cancelled or a new downloadFile request with different offset/limit parameters was sent
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("downloadFile")
data class TdDownloadFile(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("priority")
    val priority: Int = 0,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("synchronous")
    val synchronous: Boolean = false,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdFile> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDownloadFile {
        return copy(extra = extra.copy(id = id))
    }
}
