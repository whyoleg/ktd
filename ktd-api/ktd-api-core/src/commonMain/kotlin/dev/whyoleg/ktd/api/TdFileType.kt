package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Represents the type of a file
 */
@Serializable
sealed class TdFileType : TdObject {
    /**
     * The data is not a file
     */
    @Serializable
    @SerialName("fileTypeNone")
    object None : TdFileType()

    /**
     * The file is an animation
     */
    @Serializable
    @SerialName("fileTypeAnimation")
    object Animation : TdFileType()

    /**
     * The file is an audio file
     */
    @Serializable
    @SerialName("fileTypeAudio")
    object Audio : TdFileType()

    /**
     * The file is a document
     */
    @Serializable
    @SerialName("fileTypeDocument")
    object Document : TdFileType()

    /**
     * The file is a photo
     */
    @Serializable
    @SerialName("fileTypePhoto")
    object Photo : TdFileType()

    /**
     * The file is a profile photo
     */
    @Serializable
    @SerialName("fileTypeProfilePhoto")
    object ProfilePhoto : TdFileType()

    /**
     * The file was sent to a secret chat (the file type is not known to the server)
     */
    @Serializable
    @SerialName("fileTypeSecret")
    object Secret : TdFileType()

    /**
     * The file is a thumbnail of a file from a secret chat
     */
    @Serializable
    @SerialName("fileTypeSecretThumbnail")
    object SecretThumbnail : TdFileType()

    /**
     * The file is a file from Secure storage used for storing Telegram Passport files
     */
    @Serializable
    @SerialName("fileTypeSecure")
    object Secure : TdFileType()

    /**
     * The file is a sticker
     */
    @Serializable
    @SerialName("fileTypeSticker")
    object Sticker : TdFileType()

    /**
     * The file is a thumbnail of another file
     */
    @Serializable
    @SerialName("fileTypeThumbnail")
    object Thumbnail : TdFileType()

    /**
     * The file type is not yet known
     */
    @Serializable
    @SerialName("fileTypeUnknown")
    object Unknown : TdFileType()

    /**
     * The file is a video
     */
    @Serializable
    @SerialName("fileTypeVideo")
    object Video : TdFileType()

    /**
     * The file is a video note
     */
    @Serializable
    @SerialName("fileTypeVideoNote")
    object VideoNote : TdFileType()

    /**
     * The file is a voice note
     */
    @Serializable
    @SerialName("fileTypeVoiceNote")
    object VoiceNote : TdFileType()

    /**
     * The file is a wallpaper or a background pattern
     */
    @Serializable
    @SerialName("fileTypeWallpaper")
    object Wallpaper : TdFileType()
}
