package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * A personal document, containing some information about a user
 *
 * @property files List of files containing the pages of the document
 * @property translation List of files containing a certified English translation of the document
 */
@Serializable
@SerialName("personalDocument")
data class TdPersonalDocument(
    @SerialName("files")
    val files: List<TdDatedFile>,
    @SerialName("translation")
    val translation: List<TdDatedFile>
) : TdObject
