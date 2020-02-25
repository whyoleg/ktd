package dev.whyoleg.ktd.api

import kotlinx.serialization.*

/**
 * Contains parameters for TDLib initialization
 *
 * @property useTestDc If set to true, the Telegram test environment will be used instead of the production environment
 * @property databaseDirectory The path to the directory for the persistent database
 *                             If empty, the current working directory will be used
 * @property filesDirectory The path to the directory for storing files
 *                          If empty, database_directory will be used
 * @property useFileDatabase If set to true, information about downloaded and uploaded files will be saved between application restarts
 * @property useChatInfoDatabase If set to true, the library will maintain a cache of users, basic groups, supergroups, channels and secret chats
 *                               Implies use_file_database
 * @property useMessageDatabase If set to true, the library will maintain a cache of chats and messages
 *                              Implies use_chat_info_database
 * @property useSecretChats If set to true, support for secret chats will be enabled
 * @property apiId Application identifier for Telegram API access, which can be obtained at https://my.telegram.org
 * @property apiHash Application identifier hash for Telegram API access, which can be obtained at https://my.telegram.org
 * @property systemLanguageCode IETF language tag of the user's operating system language
 * @property deviceModel Model of the device the application is being run on
 * @property systemVersion Version of the operating system the application is being run on
 * @property applicationVersion Application version
 * @property enableStorageOptimizer If set to true, old files will automatically be deleted
 * @property ignoreFileNames If set to true, original file names will be ignored
 *                           Otherwise, downloaded files will be saved under names as close as possible to the original name
 */
@Serializable
@SerialName("tdlibParameters")
data class TdTdlibParameters(
    @SerialName("use_test_dc")
    val useTestDc: Boolean,
    @SerialName("database_directory")
    val databaseDirectory: String,
    @SerialName("files_directory")
    val filesDirectory: String,
    @SerialName("use_file_database")
    val useFileDatabase: Boolean,
    @SerialName("use_chat_info_database")
    val useChatInfoDatabase: Boolean,
    @SerialName("use_message_database")
    val useMessageDatabase: Boolean,
    @SerialName("use_secret_chats")
    val useSecretChats: Boolean,
    @SerialName("api_id")
    val apiId: Int,
    @SerialName("api_hash")
    val apiHash: String,
    @SerialName("system_language_code")
    val systemLanguageCode: String,
    @SerialName("device_model")
    val deviceModel: String,
    @SerialName("system_version")
    val systemVersion: String,
    @SerialName("application_version")
    val applicationVersion: String,
    @SerialName("enable_storage_optimizer")
    val enableStorageOptimizer: Boolean,
    @SerialName("ignore_file_names")
    val ignoreFileNames: Boolean
) : TdObject
