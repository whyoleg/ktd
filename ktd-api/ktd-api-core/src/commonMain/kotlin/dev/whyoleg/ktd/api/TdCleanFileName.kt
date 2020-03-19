package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Removes potentially dangerous characters from the name of a file
 * The encoding of the file name is supposed to be UTF-8
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @property fileName File name or path to the file
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("cleanFileName")
data class TdCleanFileName(
    @SerialName("file_name")
    val fileName: String? = null,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdSyncRequest<TdText> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdCleanFileName {
        return copy(extra = extra.copy(id = id))
    }
}
