package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Deletes a file from the TDLib file cache
 *
 * @property fileId Identifier of the file to delete
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("deleteFile")
data class TdDeleteFile(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdOk> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdDeleteFile {
        return copy(extra = extra.copy(id = id))
    }
}
