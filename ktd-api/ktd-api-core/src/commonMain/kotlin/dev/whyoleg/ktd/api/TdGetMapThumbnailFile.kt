package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Returns information about a file with a map thumbnail in PNG format
 * Only map thumbnail files with size less than 1MB can be downloaded
 *
 * @property location Location of the map center
 * @property zoom Map zoom level
 * @property width Map width in pixels before applying scale
 * @property height Map height in pixels before applying scale
 * @property scale Map scale
 * @property chatId Identifier of a chat, in which the thumbnail will be shown
 *                  Use 0 if unknown
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("getMapThumbnailFile")
data class TdGetMapThumbnailFile(
    @SerialName("location")
    val location: TdLocation? = null,
    @SerialName("zoom")
    val zoom: Int = 0,
    @SerialName("width")
    val width: Int = 0,
    @SerialName("height")
    val height: Int = 0,
    @SerialName("scale")
    val scale: Int = 0,
    @SerialName("chat_id")
    val chatId: Long = 0L,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdRequest<TdFile> {
    @Suppress("OverridingDeprecatedMember")
    override fun withRequestId(id: Long): TdGetMapThumbnailFile {
        return copy(extra = extra.copy(id = id))
    }
}
