package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

/**
 * Information about a file was updated
 *
 * @property file New data about the file
 */
@Serializable
@SerialName("updateFile")
data class TdUpdateFile(
    @SerialName("file")
    val file: TdFile
) : TdUpdate
