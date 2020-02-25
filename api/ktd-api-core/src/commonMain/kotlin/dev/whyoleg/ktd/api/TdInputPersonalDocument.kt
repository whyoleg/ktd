package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A personal document to be saved to Telegram Passport
 *
 * @property files List of files containing the pages of the document
 * @property translation List of files containing a certified English translation of the document
 */
@Serializable
@SerialName("inputPersonalDocument")
data class TdInputPersonalDocument(
    @SerialName("files")
    val files: List<TdInputFile>,
    @SerialName("translation")
    val translation: List<TdInputFile>
) : TdObject
