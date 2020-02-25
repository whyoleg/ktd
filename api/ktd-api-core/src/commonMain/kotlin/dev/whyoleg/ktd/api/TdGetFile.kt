package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a file
 * This is an offline request
 *
 * @property fileId Identifier of the file to get
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getFile")
data class TdGetFile(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdFile> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetFile {
        return copy(extra = extra.copy(id = id))
    }
}
