package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Stops the uploading of a file
 * Supported only for files uploaded by using uploadFile
 * For other files the behavior is undefined
 *
 * @property fileId Identifier of the file to stop uploading
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("cancelUploadFile")
data class TdCancelUploadFile(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCancelUploadFile {
        return copy(extra = extra.copy(id = id))
    }
}
