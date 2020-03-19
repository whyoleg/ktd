package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @property fileName The name of the file or path to the file
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getFileMimeType")
data class TdGetFileMimeType(
    @SerialName("file_name")
    val fileName: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetFileMimeType {
        return copy(extra = extra.copy(id = id))
    }
}
