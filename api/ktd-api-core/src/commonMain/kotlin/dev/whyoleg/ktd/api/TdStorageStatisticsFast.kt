package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains approximate storage usage statistics, excluding files of unknown file type
 *
 * @property filesSize Approximate total size of files
 * @property fileCount Approximate number of files
 * @property databaseSize Size of the database
 * @property languagePackDatabaseSize Size of the language pack database
 * @property logSize Size of the TDLib internal log
 * @property extra Extra data shared between request and response
 */
@Serializable
@SerialName("storageStatisticsFast")
data class TdStorageStatisticsFast(
    @SerialName("files_size")
    val filesSize: Long,
    @SerialName("file_count")
    val fileCount: Int,
    @SerialName("database_size")
    val databaseSize: Long,
    @SerialName("language_pack_database_size")
    val languagePackDatabaseSize: Long,
    @SerialName("log_size")
    val logSize: Long,
    @SerialName("@extra")
    override val extra: TdExtra = TdExtra.EMPTY
) : TdResponse
