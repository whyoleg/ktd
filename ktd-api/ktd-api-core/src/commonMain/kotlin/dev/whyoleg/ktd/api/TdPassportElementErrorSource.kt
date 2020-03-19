package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains the description of an error in a Telegram Passport element
 */
@Serializable
sealed class TdPassportElementErrorSource : TdObject {
    /**
     * The element contains an error in an unspecified place
     * The error will be considered resolved when new data is added
     */
    @Serializable
    @SerialName("passportElementErrorSourceUnspecified")
    object Unspecified : TdPassportElementErrorSource()

    /**
     * One of the data fields contains an error
     * The error will be considered resolved when the value of the field changes
     *
     * @property fieldName Field name
     */
    @Serializable
    @SerialName("passportElementErrorSourceDataField")
    data class DataField(
        @SerialName("field_name")
        val fieldName: String
    ) : TdPassportElementErrorSource()

    /**
     * The front side of the document contains an error
     * The error will be considered resolved when the file with the front side changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceFrontSide")
    object FrontSide : TdPassportElementErrorSource()

    /**
     * The reverse side of the document contains an error
     * The error will be considered resolved when the file with the reverse side changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceReverseSide")
    object ReverseSide : TdPassportElementErrorSource()

    /**
     * The selfie with the document contains an error
     * The error will be considered resolved when the file with the selfie changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceSelfie")
    object Selfie : TdPassportElementErrorSource()

    /**
     * One of files with the translation of the document contains an error
     * The error will be considered resolved when the file changes
     *
     * @property fileIndex Index of a file with the error
     */
    @Serializable
    @SerialName("passportElementErrorSourceTranslationFile")
    data class TranslationFile(
        @SerialName("file_index")
        val fileIndex: Int
    ) : TdPassportElementErrorSource()

    /**
     * The translation of the document contains an error
     * The error will be considered resolved when the list of translation files changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceTranslationFiles")
    object TranslationFiles : TdPassportElementErrorSource()

    /**
     * The file contains an error
     * The error will be considered resolved when the file changes
     *
     * @property fileIndex Index of a file with the error
     */
    @Serializable
    @SerialName("passportElementErrorSourceFile")
    data class File(
        @SerialName("file_index")
        val fileIndex: Int
    ) : TdPassportElementErrorSource()

    /**
     * The list of attached files contains an error
     * The error will be considered resolved when the list of files changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceFiles")
    object Files : TdPassportElementErrorSource()
}
