package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns file downloaded prefix size from a given offset
 *
 * @property fileId Identifier of the file
 * @property offset Offset from which downloaded prefix size should be calculated
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getFileDownloadedPrefixSize")
data class TdGetFileDownloadedPrefixSize(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdCount> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetFileDownloadedPrefixSize {
        return copy(extra = extra.copy(id = id))
    }
}
