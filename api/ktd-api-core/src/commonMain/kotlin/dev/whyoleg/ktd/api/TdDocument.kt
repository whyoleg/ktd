package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Describes a document of any type
 *
 * @property fileName Original name of the file
 *                    As defined by the sender
 * @property mimeType MIME type of the file
 *                    As defined by the sender
 * @property minithumbnail Document minithumbnail
 * @property thumbnail Document thumbnail in JPEG or PNG format (PNG will be used only for background patterns)
 *                     As defined by the sender
 * @property document File containing the document
 */
@Serializable
@SerialName("document")
data class TdDocument(
    @SerialName("file_name")
    val fileName: String,
    @SerialName("mime_type")
    val mimeType: String,
    @SerialName("minithumbnail")
    val minithumbnail: TdMinithumbnail?,
    @SerialName("thumbnail")
    val thumbnail: TdPhotoSize?,
    @SerialName("document")
    val document: TdFile
) : TdObject
