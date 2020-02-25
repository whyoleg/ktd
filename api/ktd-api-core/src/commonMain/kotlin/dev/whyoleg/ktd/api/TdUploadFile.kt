package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Asynchronously uploads a file to the cloud without sending it in a message
 * UpdateFile will be used to notify about upload progress and successful completion of the upload
 * The file will not have a persistent remote identifier until it will be sent in a message
 *
 * @property file File to upload
 * @property fileType File type
 * @property priority Priority of the upload (1-32)
 *                    The higher the priority, the earlier the file will be uploaded
 *                    If the priorities of two files are equal, then the first one for which uploadFile was called will be uploaded first
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("uploadFile")
data class TdUploadFile(
    @SerialName("file")
    val file: TdInputFile? = null,
    @SerialName("file_type")
    val fileType: TdFileType? = null,
    @SerialName("priority")
    val priority: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdFile> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdUploadFile {
        return copy(extra = extra.copy(id = id))
    }
}
