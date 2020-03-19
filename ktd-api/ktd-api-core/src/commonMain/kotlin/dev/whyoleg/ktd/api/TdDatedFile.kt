package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * File with the date it was uploaded
 *
 * @property file The file
 * @property date Point in time (Unix timestamp) when the file was uploaded
 */
@Serializable
@SerialName("datedFile")
data class TdDatedFile(
    @SerialName("file")
    val file: TdFile,
    @SerialName("date")
    val date: Int
) : TdObject
