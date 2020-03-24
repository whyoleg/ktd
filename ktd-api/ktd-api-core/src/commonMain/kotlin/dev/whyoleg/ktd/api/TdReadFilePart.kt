package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Reads a part of a file from the TDLib file cache and returns read bytes
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
 *
 * @property fileId Identifier of the file
 *                  The file must be located in the TDLib file cache
 * @property offset The offset from which to read the file
 * @property count Number of bytes to read
 *                 An error will be returned if there are not enough bytes available in the file from the specified position
 *                 Pass 0 to read all available data from the specified position
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("readFilePart")
data class TdReadFilePart(
    @SerialName("file_id")
    val fileId: Int = 0,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("count")
    val count: Int = 0,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdFilePart> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdReadFilePart {
        return copy(extra = extra.copy(id = id))
    }
}
