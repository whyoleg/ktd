package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the extension of a file, guessed by its MIME type
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @property mimeType The MIME type of the file
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getFileExtension")
data class TdGetFileExtension(
    @SerialName("mime_type")
    val mimeType: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetFileExtension {
        return copy(extra = extra.copy(id = id))
    }
}
