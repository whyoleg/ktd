@file:Suppress(
    "unused",
    "DEPRECATION"
)
@file:UseExperimental(
    TdBotsOnly::class,
    TdTestOnly::class
)

package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.*
import kotlinx.serialization.*

const val abstractTdDeprecatedMessage: String =
    "Classes under TdApi will be removed in 0.6.1, use Td-prefixed typealises"

@Deprecated(
    message = "Deprecated, use TdObject instead",
    replaceWith = ReplaceWith("TdObject"),
    level = DeprecationLevel.WARNING
)
typealias TelegramObject = TdApi.Object

@Deprecated(
    message = "Deprecated, use TdApiRequest instead",
    replaceWith = ReplaceWith("TdApiRequest"),
    level = DeprecationLevel.WARNING
)
typealias TelegramFunction = TdApi.Function

@Deprecated(
    message = "Deprecated, use TdUpdate instead",
    replaceWith = ReplaceWith("TdUpdate"),
    level = DeprecationLevel.WARNING
)
typealias TelegramUpdate = TdApi.Update

@Deprecated(
    message = "Deprecated, use TdError instead",
    replaceWith = ReplaceWith("TdError"),
    level = DeprecationLevel.WARNING
)
typealias TelegramError = TdApi.Error

@Suppress("DEPRECATION_ERROR")
object TdApi : AnyTdApi("1.5.0", apiBuilder) {
    @Deprecated(
        message = "Deprecated, use TdObject instead",
        replaceWith = ReplaceWith("TdObject"),
        level = DeprecationLevel.WARNING
    )
    abstract class Object : TdObject

    @Deprecated(
        message = "Deprecated, use TdApiRequest instead",
        replaceWith = ReplaceWith("TdApiRequest"),
        level = DeprecationLevel.WARNING
    )
    abstract class Function : Object()

    /**
     * An object of this type can be returned on every function call, in case of an error
     *
     * @property code Error code
     *                Subject to future changes
     *                If the error code is 406, the error message must not be processed in any way and must not be displayed to the user
     * @property message Error message
     *                   Subject to future changes
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("error")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdError"),
        level = DeprecationLevel.WARNING
    )
    data class Error(
        @SerialName("code")
        val code: Int,
        @SerialName("message")
        val message: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * An object of this type is returned on a successful function call for certain functions
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("ok")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOk"),
        level = DeprecationLevel.WARNING
    )
    data class Ok(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

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
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTdlibParameters"),
        level = DeprecationLevel.WARNING
    )
    data class TdlibParameters(
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
    ) : Object(), TdObject

    /**
     * Provides information about the method by which an authentication code is delivered to the user
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeType"),
        level = DeprecationLevel.WARNING
    )
    abstract class AuthenticationCodeType : Object(), TdObject

    /**
     * An authentication code is delivered via a private Telegram message, which can be viewed in another client
     *
     * @property length Length of the code
     */
    @Serializable
    @SerialName("authenticationCodeTypeTelegramMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeTypeTelegramMessage"),
        level = DeprecationLevel.WARNING
    )
    data class AuthenticationCodeTypeTelegramMessage(
        @SerialName("length")
        val length: Int
    ) : AuthenticationCodeType()

    /**
     * An authentication code is delivered via an SMS message to the specified phone number
     *
     * @property length Length of the code
     */
    @Serializable
    @SerialName("authenticationCodeTypeSms")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeTypeSms"),
        level = DeprecationLevel.WARNING
    )
    data class AuthenticationCodeTypeSms(
        @SerialName("length")
        val length: Int
    ) : AuthenticationCodeType()

    /**
     * An authentication code is delivered via a phone call to the specified phone number
     *
     * @property length Length of the code
     */
    @Serializable
    @SerialName("authenticationCodeTypeCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeTypeCall"),
        level = DeprecationLevel.WARNING
    )
    data class AuthenticationCodeTypeCall(
        @SerialName("length")
        val length: Int
    ) : AuthenticationCodeType()

    /**
     * An authentication code is delivered by an immediately cancelled call to the specified phone number
     * The number from which the call was made is the code
     *
     * @property pattern Pattern of the phone number from which the call will be made
     */
    @Serializable
    @SerialName("authenticationCodeTypeFlashCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeTypeFlashCall"),
        level = DeprecationLevel.WARNING
    )
    data class AuthenticationCodeTypeFlashCall(
        @SerialName("pattern")
        val pattern: String
    ) : AuthenticationCodeType()

    /**
     * Information about the authentication code that was sent
     *
     * @property phoneNumber A phone number that is being authenticated
     * @property type Describes the way the code was sent to the user
     * @property nextType Describes the way the next code will be sent to the user
     * @property timeout Timeout before the code should be re-sent, in seconds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authenticationCodeInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeInfo"),
        level = DeprecationLevel.WARNING
    )
    data class AuthenticationCodeInfo(
        @SerialName("phone_number")
        val phoneNumber: String,
        @SerialName("type")
        val type: AuthenticationCodeType,
        @SerialName("next_type")
        val nextType: AuthenticationCodeType?,
        @SerialName("timeout")
        val timeout: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Information about the email address authentication code that was sent
     *
     * @property emailAddressPattern Pattern of the email address to which an authentication code was sent
     * @property length Length of the code
     *                  0 if unknown
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("emailAddressAuthenticationCodeInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEmailAddressAuthenticationCodeInfo"),
        level = DeprecationLevel.WARNING
    )
    data class EmailAddressAuthenticationCodeInfo(
        @SerialName("email_address_pattern")
        val emailAddressPattern: String,
        @SerialName("length")
        val length: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a part of the text that needs to be formatted in some unusual way
     *
     * @property offset Offset of the entity in UTF-16 code points
     * @property length Length of the entity, in UTF-16 code points
     * @property type Type of the entity
     */
    @Serializable
    @SerialName("textEntity")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntity"),
        level = DeprecationLevel.WARNING
    )
    data class TextEntity(
        @SerialName("offset")
        val offset: Int,
        @SerialName("length")
        val length: Int,
        @SerialName("type")
        val type: TextEntityType
    ) : Object(), TdObject

    /**
     * Contains a list of text entities
     *
     * @property entities List of text entities
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("textEntities")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntities"),
        level = DeprecationLevel.WARNING
    )
    data class TextEntities(
        @SerialName("entities")
        val entities: Array<TextEntity>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A text with some entities
     *
     * @property text The text
     * @property entities Entities contained in the text
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("formattedText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFormattedText"),
        level = DeprecationLevel.WARNING
    )
    data class FormattedText(
        @SerialName("text")
        val text: String,
        @SerialName("entities")
        val entities: Array<TextEntity>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains Telegram terms of service
     *
     * @property text Text of the terms of service
     * @property minUserAge Minimum age of a user to be able to accept the terms
     *                      0 if any
     * @property showPopup True, if a blocking popup with terms of service must be shown to the user
     */
    @Serializable
    @SerialName("termsOfService")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTermsOfService"),
        level = DeprecationLevel.WARNING
    )
    data class TermsOfService(
        @SerialName("text")
        val text: FormattedText,
        @SerialName("min_user_age")
        val minUserAge: Int,
        @SerialName("show_popup")
        val showPopup: Boolean
    ) : Object(), TdObject

    /**
     * Represents the current authorization state of the client
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState"),
        level = DeprecationLevel.WARNING
    )
    abstract class AuthorizationState : Object(), TdResponse

    /**
     * TDLib needs TdlibParameters for initialization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitTdlibParameters")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateWaitTdlibParameters"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateWaitTdlibParameters(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * TDLib needs an encryption key to decrypt the local database
     *
     * @property isEncrypted True, if the database is currently encrypted
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitEncryptionKey")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateWaitEncryptionKey"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateWaitEncryptionKey(
        @SerialName("is_encrypted")
        val isEncrypted: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * TDLib needs the user's phone number to authorize
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitPhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateWaitPhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateWaitPhoneNumber(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * TDLib needs the user's authentication code to authorize
     *
     * @property codeInfo Information about the authorization code that was sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateWaitCode"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateWaitCode(
        @SerialName("code_info")
        val codeInfo: AuthenticationCodeInfo,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * The user is unregistered and need to accept terms of service and enter their first name and last name to finish registration
     *
     * @property termsOfService Telegram terms of service
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitRegistration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateWaitRegistration"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateWaitRegistration(
        @SerialName("terms_of_service")
        val termsOfService: TermsOfService,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * The user has been authorized, but needs to enter a password to start using the application
     *
     * @property passwordHint Hint for the password
     * @property hasRecoveryEmailAddress True, if a recovery email address has been set up
     * @property recoveryEmailAddressPattern Pattern of the email address to which the recovery email was sent
     *                                       Empty until a recovery email has been sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateWaitPassword")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateWaitPassword"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateWaitPassword(
        @SerialName("password_hint")
        val passwordHint: String?,
        @SerialName("has_recovery_email_address")
        val hasRecoveryEmailAddress: Boolean,
        @SerialName("recovery_email_address_pattern")
        val recoveryEmailAddressPattern: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * The user has been successfully authorized
     * TDLib is now ready to answer queries
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateReady")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateReady"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateReady(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * The user is currently logging out
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateLoggingOut")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateLoggingOut"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateLoggingOut(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * TDLib is closing, all subsequent queries will be answered with the error 500
     * Note that closing TDLib can take a while
     * All resources will be freed only after authorizationStateClosed has been received
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateClosing")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateClosing"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateClosing(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * TDLib client is in its final state
     * All databases are closed and all resources are released
     * No other updates will be received after this
     * All queries will be responded to with error code 500
     * To continue working, one should create a new instance of the TDLib client
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("authorizationStateClosed")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationStateClosed"),
        level = DeprecationLevel.WARNING
    )
    data class AuthorizationStateClosed(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : AuthorizationState()

    /**
     * Represents the current state of 2-step verification
     *
     * @property hasPassword True, if a 2-step verification password is set
     * @property passwordHint Hint for the password
     * @property hasRecoveryEmailAddress True, if a recovery email is set
     * @property hasPassportData True, if some Telegram Passport elements were saved
     * @property recoveryEmailAddressCodeInfo Information about the recovery email address to which the confirmation email was sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passwordState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPasswordState"),
        level = DeprecationLevel.WARNING
    )
    data class PasswordState(
        @SerialName("has_password")
        val hasPassword: Boolean,
        @SerialName("password_hint")
        val passwordHint: String?,
        @SerialName("has_recovery_email_address")
        val hasRecoveryEmailAddress: Boolean,
        @SerialName("has_passport_data")
        val hasPassportData: Boolean,
        @SerialName("recovery_email_address_code_info")
        val recoveryEmailAddressCodeInfo: EmailAddressAuthenticationCodeInfo?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about the current recovery email address
     *
     * @property recoveryEmailAddress Recovery email address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("recoveryEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRecoveryEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    data class RecoveryEmailAddress(
        @SerialName("recovery_email_address")
        val recoveryEmailAddress: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Returns information about the availability of a temporary password, which can be used for payments
     *
     * @property hasPassword True, if a temporary password is available
     * @property validFor Time left before the temporary password expires, in seconds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("temporaryPasswordState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTemporaryPasswordState"),
        level = DeprecationLevel.WARNING
    )
    data class TemporaryPasswordState(
        @SerialName("has_password")
        val hasPassword: Boolean,
        @SerialName("valid_for")
        val validFor: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a local file
     *
     * @property path Local path to the locally available file part
     * @property canBeDownloaded True, if it is possible to try to download or generate the file
     * @property canBeDeleted True, if the file can be deleted
     * @property isDownloadingActive True, if the file is currently being downloaded (or a local copy is being generated by some other means)
     * @property isDownloadingCompleted True, if the local copy is fully available
     * @property downloadOffset Download will be started from this offset
     *                          Downloaded_prefix_size is calculated from this offset
     * @property downloadedPrefixSize If is_downloading_completed is false, then only some prefix of the file starting from download_offset is ready to be read
     *                                Downloaded_prefix_size is the size of that prefix
     * @property downloadedSize Total downloaded file bytes
     *                          Should be used only for calculating download progress
     *                          The actual file size may be bigger, and some parts of it may contain garbage
     */
    @Serializable
    @SerialName("localFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLocalFile"),
        level = DeprecationLevel.WARNING
    )
    data class LocalFile(
        @SerialName("path")
        val path: String?,
        @SerialName("can_be_downloaded")
        val canBeDownloaded: Boolean,
        @SerialName("can_be_deleted")
        val canBeDeleted: Boolean,
        @SerialName("is_downloading_active")
        val isDownloadingActive: Boolean,
        @SerialName("is_downloading_completed")
        val isDownloadingCompleted: Boolean,
        @SerialName("download_offset")
        val downloadOffset: Int,
        @SerialName("downloaded_prefix_size")
        val downloadedPrefixSize: Int,
        @SerialName("downloaded_size")
        val downloadedSize: Int
    ) : Object(), TdObject

    /**
     * Represents a remote file
     *
     * @property id Remote file identifier
     *              Can be used across application restarts or even from other devices for the current user
     *              If the ID starts with "http://" or "https://", it represents the HTTP URL of the file
     *              TDLib is currently unable to download files if only their URL is known
     *              If downloadFile is called on such a file or if it is sent to a secret chat, TDLib starts a file generation process by sending updateFileGenerationStart to the client with the HTTP URL in the original_path and "#url#" as the conversion string
     *              Clients should generate the file by downloading it to the specified location
     * @property isUploadingActive True, if the file is currently being uploaded (or a remote copy is being generated by some other means)
     * @property isUploadingCompleted True, if a remote copy is fully available
     * @property uploadedSize Size of the remote available part of the file
     *                        0 if unknown
     */
    @Serializable
    @SerialName("remoteFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoteFile"),
        level = DeprecationLevel.WARNING
    )
    data class RemoteFile(
        @SerialName("id")
        val id: String?,
        @SerialName("is_uploading_active")
        val isUploadingActive: Boolean,
        @SerialName("is_uploading_completed")
        val isUploadingCompleted: Boolean,
        @SerialName("uploaded_size")
        val uploadedSize: Int
    ) : Object(), TdObject

    /**
     * Represents a file
     *
     * @property id Unique file identifier
     * @property size File size
     *                0 if unknown
     * @property expectedSize Expected file size in case the exact file size is unknown, but an approximate size is known
     *                        Can be used to show download/upload progress
     * @property local Information about the local copy of the file
     * @property remote Information about the remote copy of the file
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("file")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFile"),
        level = DeprecationLevel.WARNING
    )
    data class File(
        @SerialName("id")
        val id: Int,
        @SerialName("size")
        val size: Int,
        @SerialName("expected_size")
        val expectedSize: Int,
        @SerialName("local")
        val local: LocalFile,
        @SerialName("remote")
        val remote: RemoteFile,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Points to a file
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFile"),
        level = DeprecationLevel.WARNING
    )
    abstract class InputFile : Object(), TdObject

    /**
     * A file defined by its unique ID
     *
     * @property id Unique file identifier
     */
    @Serializable
    @SerialName("inputFileId")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFileId"),
        level = DeprecationLevel.WARNING
    )
    data class InputFileId(
        @SerialName("id")
        val id: Int
    ) : InputFile()

    /**
     * A file defined by its remote ID
     *
     * @property id Remote file identifier
     */
    @Serializable
    @SerialName("inputFileRemote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFileRemote"),
        level = DeprecationLevel.WARNING
    )
    data class InputFileRemote(
        @SerialName("id")
        val id: String
    ) : InputFile()

    /**
     * A file defined by a local path
     *
     * @property path Local path to the file
     */
    @Serializable
    @SerialName("inputFileLocal")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFileLocal"),
        level = DeprecationLevel.WARNING
    )
    data class InputFileLocal(
        @SerialName("path")
        val path: String
    ) : InputFile()

    /**
     * A file generated by the client
     *
     * @property originalPath Local path to a file from which the file is generated
     *                        May be empty if there is no such file
     * @property conversion String specifying the conversion applied to the original file
     *                      Should be persistent across application restarts
     *                      Conversions beginning with '#' are reserved for internal TDLib usage
     * @property expectedSize Expected size of the generated file
     *                        0 if unknown
     */
    @Serializable
    @SerialName("inputFileGenerated")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFileGenerated"),
        level = DeprecationLevel.WARNING
    )
    data class InputFileGenerated(
        @SerialName("original_path")
        val originalPath: String,
        @SerialName("conversion")
        val conversion: String,
        @SerialName("expected_size")
        val expectedSize: Int
    ) : InputFile()

    /**
     * Photo description
     *
     * @property type Thumbnail type (see https://core.telegram.org/constructor/photoSize)
     * @property photo Information about the photo file
     * @property width Photo width
     * @property height Photo height
     */
    @Serializable
    @SerialName("photoSize")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPhotoSize"),
        level = DeprecationLevel.WARNING
    )
    data class PhotoSize(
        @SerialName("type")
        val type: String,
        @SerialName("photo")
        val photo: File,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int
    ) : Object(), TdObject

    /**
     * Thumbnail image of a very poor quality and low resolution
     *
     * @property width Thumbnail width, usually doesn't exceed 40
     * @property height Thumbnail height, usually doesn't exceed 40
     * @property data The thumbnail in JPEG format
     */
    @Serializable
    @SerialName("minithumbnail")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMinithumbnail"),
        level = DeprecationLevel.WARNING
    )
    data class Minithumbnail(
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("data")
        val data: ByteArray
    ) : Object(), TdObject

    /**
     * Part of the face, relative to which a mask should be placed
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPoint"),
        level = DeprecationLevel.WARNING
    )
    abstract class MaskPoint : Object(), TdObject

    /**
     * A mask should be placed relatively to the forehead
     */
    @Serializable
    @SerialName("maskPointForehead")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPointForehead"),
        level = DeprecationLevel.WARNING
    )
    object MaskPointForehead : MaskPoint()

    /**
     * A mask should be placed relatively to the eyes
     */
    @Serializable
    @SerialName("maskPointEyes")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPointEyes"),
        level = DeprecationLevel.WARNING
    )
    object MaskPointEyes : MaskPoint()

    /**
     * A mask should be placed relatively to the mouth
     */
    @Serializable
    @SerialName("maskPointMouth")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPointMouth"),
        level = DeprecationLevel.WARNING
    )
    object MaskPointMouth : MaskPoint()

    /**
     * A mask should be placed relatively to the chin
     */
    @Serializable
    @SerialName("maskPointChin")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPointChin"),
        level = DeprecationLevel.WARNING
    )
    object MaskPointChin : MaskPoint()

    /**
     * Position on a photo where a mask should be placed
     *
     * @property point Part of the face, relative to which the mask should be placed
     * @property xShift Shift by X-axis measured in widths of the mask scaled to the face size, from left to right
     *                  (For example, -1.0 will place the mask just to the left of the default mask position)
     * @property yShift Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom
     *                  (For example, 1.0 will place the mask just below the default mask position)
     * @property scale Mask scaling coefficient
     *                 (For example, 2.0 means a doubled size)
     */
    @Serializable
    @SerialName("maskPosition")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPosition"),
        level = DeprecationLevel.WARNING
    )
    data class MaskPosition(
        @SerialName("point")
        val point: MaskPoint,
        @SerialName("x_shift")
        val xShift: Double,
        @SerialName("y_shift")
        val yShift: Double,
        @SerialName("scale")
        val scale: Double
    ) : Object(), TdObject

    /**
     * Describes one answer option of a poll
     *
     * @property text Option text, 1-100 characters
     * @property voterCount Number of voters for this option, available only for closed or voted polls
     * @property votePercentage The percentage of votes for this option, 0-100
     * @property isChosen True, if the option was chosen by the user
     * @property isBeingChosen True, if the option is being chosen by a pending setPollAnswer request
     */
    @Serializable
    @SerialName("pollOption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPollOption"),
        level = DeprecationLevel.WARNING
    )
    data class PollOption(
        @SerialName("text")
        val text: String,
        @SerialName("voter_count")
        val voterCount: Int,
        @SerialName("vote_percentage")
        val votePercentage: Int,
        @SerialName("is_chosen")
        val isChosen: Boolean,
        @SerialName("is_being_chosen")
        val isBeingChosen: Boolean
    ) : Object(), TdObject

    /**
     * Describes an animation file
     * The animation must be encoded in GIF or MPEG4 format
     *
     * @property duration Duration of the animation, in seconds
     *                    As defined by the sender
     * @property width Width of the animation
     * @property height Height of the animation
     * @property fileName Original name of the file
     *                    As defined by the sender
     * @property mimeType MIME type of the file, usually "image/gif" or "video/mp4"
     * @property minithumbnail Animation minithumbnail
     * @property thumbnail Animation thumbnail
     * @property animation File containing the animation
     */
    @Serializable
    @SerialName("animation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class Animation(
        @SerialName("duration")
        val duration: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("file_name")
        val fileName: String,
        @SerialName("mime_type")
        val mimeType: String,
        @SerialName("minithumbnail")
        val minithumbnail: Minithumbnail?,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?,
        @SerialName("animation")
        val animation: File
    ) : Object(), TdObject

    /**
     * Describes an audio file
     * Audio is usually in MP3 format
     *
     * @property duration Duration of the audio, in seconds
     *                    As defined by the sender
     * @property title Title of the audio
     *                 As defined by the sender
     * @property performer Performer of the audio
     *                     As defined by the sender
     * @property fileName Original name of the file
     *                    As defined by the sender
     * @property mimeType The MIME type of the file
     *                    As defined by the sender
     * @property albumCoverMinithumbnail The minithumbnail of the album cover
     * @property albumCoverThumbnail The thumbnail of the album cover
     *                               As defined by the sender
     *                               The full size thumbnail should be extracted from the downloaded file
     * @property audio File containing the audio
     */
    @Serializable
    @SerialName("audio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAudio"),
        level = DeprecationLevel.WARNING
    )
    data class Audio(
        @SerialName("duration")
        val duration: Int,
        @SerialName("title")
        val title: String,
        @SerialName("performer")
        val performer: String,
        @SerialName("file_name")
        val fileName: String,
        @SerialName("mime_type")
        val mimeType: String,
        @SerialName("album_cover_minithumbnail")
        val albumCoverMinithumbnail: Minithumbnail?,
        @SerialName("album_cover_thumbnail")
        val albumCoverThumbnail: PhotoSize?,
        @SerialName("audio")
        val audio: File
    ) : Object(), TdObject

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
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDocument"),
        level = DeprecationLevel.WARNING
    )
    data class Document(
        @SerialName("file_name")
        val fileName: String,
        @SerialName("mime_type")
        val mimeType: String,
        @SerialName("minithumbnail")
        val minithumbnail: Minithumbnail?,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?,
        @SerialName("document")
        val document: File
    ) : Object(), TdObject

    /**
     * Describes a photo
     *
     * @property hasStickers True, if stickers were added to the photo
     * @property minithumbnail Photo minithumbnail
     * @property sizes Available variants of the photo, in different sizes
     */
    @Serializable
    @SerialName("photo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class Photo(
        @SerialName("has_stickers")
        val hasStickers: Boolean,
        @SerialName("minithumbnail")
        val minithumbnail: Minithumbnail?,
        @SerialName("sizes")
        val sizes: Array<PhotoSize>
    ) : Object(), TdObject

    /**
     * Describes a sticker
     *
     * @property setId The identifier of the sticker set to which the sticker belongs
     *                 0 if none
     * @property width Sticker width
     *                 As defined by the sender
     * @property height Sticker height
     *                  As defined by the sender
     * @property emoji Emoji corresponding to the sticker
     * @property isAnimated True, if the sticker is an animated sticker in TGS format
     * @property isMask True, if the sticker is a mask
     * @property maskPosition Position where the mask should be placed
     * @property thumbnail Sticker thumbnail in WEBP or JPEG format
     * @property sticker File containing the sticker
     */
    @Serializable
    @SerialName("sticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSticker"),
        level = DeprecationLevel.WARNING
    )
    data class Sticker(
        @SerialName("set_id")
        val setId: Long,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("emoji")
        val emoji: String,
        @SerialName("is_animated")
        val isAnimated: Boolean,
        @SerialName("is_mask")
        val isMask: Boolean,
        @SerialName("mask_position")
        val maskPosition: MaskPosition?,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?,
        @SerialName("sticker")
        val sticker: File
    ) : Object(), TdObject

    /**
     * Describes a video file
     *
     * @property duration Duration of the video, in seconds
     *                    As defined by the sender
     * @property width Video width
     *                 As defined by the sender
     * @property height Video height
     *                  As defined by the sender
     * @property fileName Original name of the file
     *                    As defined by the sender
     * @property mimeType MIME type of the file
     *                    As defined by the sender
     * @property hasStickers True, if stickers were added to the photo
     * @property supportsStreaming True, if the video should be tried to be streamed
     * @property minithumbnail Video minithumbnail
     * @property thumbnail Video thumbnail
     *                     As defined by the sender
     * @property video File containing the video
     */
    @Serializable
    @SerialName("video")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVideo"),
        level = DeprecationLevel.WARNING
    )
    data class Video(
        @SerialName("duration")
        val duration: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("file_name")
        val fileName: String,
        @SerialName("mime_type")
        val mimeType: String,
        @SerialName("has_stickers")
        val hasStickers: Boolean,
        @SerialName("supports_streaming")
        val supportsStreaming: Boolean,
        @SerialName("minithumbnail")
        val minithumbnail: Minithumbnail?,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?,
        @SerialName("video")
        val video: File
    ) : Object(), TdObject

    /**
     * Describes a video note
     * The video must be equal in width and height, cropped to a circle, and stored in MPEG4 format
     *
     * @property duration Duration of the video, in seconds
     *                    As defined by the sender
     * @property length Video width and height
     *                  As defined by the sender
     * @property minithumbnail Video minithumbnail
     * @property thumbnail Video thumbnail
     *                     As defined by the sender
     * @property video File containing the video
     */
    @Serializable
    @SerialName("videoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVideoNote"),
        level = DeprecationLevel.WARNING
    )
    data class VideoNote(
        @SerialName("duration")
        val duration: Int,
        @SerialName("length")
        val length: Int,
        @SerialName("minithumbnail")
        val minithumbnail: Minithumbnail?,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?,
        @SerialName("video")
        val video: File
    ) : Object(), TdObject

    /**
     * Describes a voice note
     * The voice note must be encoded with the Opus codec, and stored inside an OGG container
     * Voice notes can have only a single audio channel
     *
     * @property duration Duration of the voice note, in seconds
     *                    As defined by the sender
     * @property waveform A waveform representation of the voice note in 5-bit format
     * @property mimeType MIME type of the file
     *                    As defined by the sender
     * @property voice File containing the voice note
     */
    @Serializable
    @SerialName("voiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    data class VoiceNote(
        @SerialName("duration")
        val duration: Int,
        @SerialName("waveform")
        val waveform: ByteArray,
        @SerialName("mime_type")
        val mimeType: String,
        @SerialName("voice")
        val voice: File
    ) : Object(), TdObject

    /**
     * Describes a user contact
     *
     * @property phoneNumber Phone number of the user
     * @property firstName First name of the user
     * @property lastName Last name of the user
     * @property vcard Additional data about the user in a form of vCard
     * @property userId Identifier of the user, if known
     *                  Otherwise 0
     */
    @Serializable
    @SerialName("contact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdContact"),
        level = DeprecationLevel.WARNING
    )
    data class Contact(
        @SerialName("phone_number")
        val phoneNumber: String,
        @SerialName("first_name")
        val firstName: String,
        @SerialName("last_name")
        val lastName: String,
        @SerialName("vcard")
        val vcard: String,
        @SerialName("user_id")
        val userId: Int
    ) : Object(), TdObject

    /**
     * Describes a location on planet Earth
     *
     * @property latitude Latitude of the location in degrees
     *                    As defined by the sender
     * @property longitude Longitude of the location, in degrees
     *                     As defined by the sender
     */
    @Serializable
    @SerialName("location")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLocation"),
        level = DeprecationLevel.WARNING
    )
    data class Location(
        @SerialName("latitude")
        val latitude: Double,
        @SerialName("longitude")
        val longitude: Double
    ) : Object(), TdObject

    /**
     * Describes a venue
     *
     * @property location Venue location
     *                    As defined by the sender
     * @property title Venue name
     *                 As defined by the sender
     * @property address Venue address
     *                   As defined by the sender
     * @property provider Provider of the venue database
     *                    As defined by the sender
     *                    Currently only "foursquare" needs to be supported
     * @property id Identifier of the venue in the provider database
     *              As defined by the sender
     * @property type Type of the venue in the provider database
     *                As defined by the sender
     */
    @Serializable
    @SerialName("venue")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVenue"),
        level = DeprecationLevel.WARNING
    )
    data class Venue(
        @SerialName("location")
        val location: Location,
        @SerialName("title")
        val title: String,
        @SerialName("address")
        val address: String,
        @SerialName("provider")
        val provider: String,
        @SerialName("id")
        val id: String,
        @SerialName("type")
        val type: String
    ) : Object(), TdObject

    /**
     * Describes a game
     *
     * @property id Game ID
     * @property shortName Game short name
     *                     To share a game use the URL https://t.me/{bot_username}?game={game_short_name}
     * @property title Game title
     * @property text Game text, usually containing scoreboards for a game
     * @property description Game description
     * @property photo Game photo
     * @property animation Game animation
     */
    @Serializable
    @SerialName("game")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGame"),
        level = DeprecationLevel.WARNING
    )
    data class Game(
        @SerialName("id")
        val id: Long,
        @SerialName("short_name")
        val shortName: String,
        @SerialName("title")
        val title: String,
        @SerialName("text")
        val text: FormattedText,
        @SerialName("description")
        val description: String,
        @SerialName("photo")
        val photo: Photo,
        @SerialName("animation")
        val animation: Animation?
    ) : Object(), TdObject

    /**
     * Describes a poll
     *
     * @property id Unique poll identifier
     * @property question Poll question, 1-255 characters
     * @property options List of poll answer options
     * @property totalVoterCount Total number of voters, participating in the poll
     * @property isClosed True, if the poll is closed
     */
    @Serializable
    @SerialName("poll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPoll"),
        level = DeprecationLevel.WARNING
    )
    data class Poll(
        @SerialName("id")
        val id: Long,
        @SerialName("question")
        val question: String,
        @SerialName("options")
        val options: Array<PollOption>,
        @SerialName("total_voter_count")
        val totalVoterCount: Int,
        @SerialName("is_closed")
        val isClosed: Boolean
    ) : Object(), TdObject

    /**
     * Describes a user profile photo
     *
     * @property id Photo identifier
     *              0 for an empty photo
     *              Can be used to find a photo in a list of userProfilePhotos
     * @property small A small (160x160) user profile photo
     *                 The file can be downloaded only before the photo is changed
     * @property big A big (640x640) user profile photo
     *               The file can be downloaded only before the photo is changed
     */
    @Serializable
    @SerialName("profilePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProfilePhoto"),
        level = DeprecationLevel.WARNING
    )
    data class ProfilePhoto(
        @SerialName("id")
        val id: Long,
        @SerialName("small")
        val small: File,
        @SerialName("big")
        val big: File
    ) : Object(), TdObject

    /**
     * Describes the photo of a chat
     *
     * @property small A small (160x160) chat photo
     *                 The file can be downloaded only before the photo is changed
     * @property big A big (640x640) chat photo
     *               The file can be downloaded only before the photo is changed
     */
    @Serializable
    @SerialName("chatPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class ChatPhoto(
        @SerialName("small")
        val small: File,
        @SerialName("big")
        val big: File
    ) : Object(), TdObject

    /**
     * Represents the relationship between user A and user B
     * For incoming_link, user A is the current user
     * For outgoing_link, user B is the current user
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLinkState"),
        level = DeprecationLevel.WARNING
    )
    abstract class LinkState : Object(), TdObject

    /**
     * The phone number of user A is not known to user B
     */
    @Serializable
    @SerialName("linkStateNone")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLinkStateNone"),
        level = DeprecationLevel.WARNING
    )
    object LinkStateNone : LinkState()

    /**
     * The phone number of user A is known but that number has not been saved to the contact list of user B
     */
    @Serializable
    @SerialName("linkStateKnowsPhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLinkStateKnowsPhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    object LinkStateKnowsPhoneNumber : LinkState()

    /**
     * The phone number of user A has been saved to the contact list of user B
     */
    @Serializable
    @SerialName("linkStateIsContact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLinkStateIsContact"),
        level = DeprecationLevel.WARNING
    )
    object LinkStateIsContact : LinkState()

    /**
     * Represents the type of the user
     * The following types are possible: regular users, deleted users and bots
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserType"),
        level = DeprecationLevel.WARNING
    )
    abstract class UserType : Object(), TdObject

    /**
     * A regular user
     */
    @Serializable
    @SerialName("userTypeRegular")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserTypeRegular"),
        level = DeprecationLevel.WARNING
    )
    object UserTypeRegular : UserType()

    /**
     * A deleted user or deleted bot
     * No information on the user besides the user_id is available
     * It is not possible to perform any active actions on this type of user
     */
    @Serializable
    @SerialName("userTypeDeleted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserTypeDeleted"),
        level = DeprecationLevel.WARNING
    )
    object UserTypeDeleted : UserType()

    /**
     * A bot (see https://core.telegram.org/bots)
     *
     * @property canJoinGroups True, if the bot can be invited to basic group and supergroup chats
     * @property canReadAllGroupMessages True, if the bot can read all messages in basic group or supergroup chats and not just those addressed to the bot
     *                                   In private and channel chats a bot can always read all messages
     * @property isInline True, if the bot supports inline queries
     * @property inlineQueryPlaceholder Placeholder for inline queries (displayed on the client input field)
     * @property needLocation True, if the location of the user should be sent with every inline query to this bot
     */
    @Serializable
    @SerialName("userTypeBot")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserTypeBot"),
        level = DeprecationLevel.WARNING
    )
    data class UserTypeBot(
        @SerialName("can_join_groups")
        val canJoinGroups: Boolean,
        @SerialName("can_read_all_group_messages")
        val canReadAllGroupMessages: Boolean,
        @SerialName("is_inline")
        val isInline: Boolean,
        @SerialName("inline_query_placeholder")
        val inlineQueryPlaceholder: String,
        @SerialName("need_location")
        val needLocation: Boolean
    ) : UserType()

    /**
     * No information on the user besides the user_id is available, yet this user has not been deleted
     * This object is extremely rare and must be handled like a deleted user
     * It is not possible to perform any actions on users of this type
     */
    @Serializable
    @SerialName("userTypeUnknown")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserTypeUnknown"),
        level = DeprecationLevel.WARNING
    )
    object UserTypeUnknown : UserType()

    /**
     * Represents commands supported by a bot
     *
     * @property command Text of the bot command
     * @property description Description of the bot command
     */
    @Serializable
    @SerialName("botCommand")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBotCommand"),
        level = DeprecationLevel.WARNING
    )
    data class BotCommand(
        @SerialName("command")
        val command: String,
        @SerialName("description")
        val description: String
    ) : Object(), TdObject

    /**
     * Provides information about a bot and its supported commands
     *
     * @property description Long description shown on the user info page
     * @property commands A list of commands supported by the bot
     */
    @Serializable
    @SerialName("botInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBotInfo"),
        level = DeprecationLevel.WARNING
    )
    data class BotInfo(
        @SerialName("description")
        val description: String,
        @SerialName("commands")
        val commands: Array<BotCommand>
    ) : Object(), TdObject

    /**
     * Represents a user
     *
     * @property id User identifier
     * @property firstName First name of the user
     * @property lastName Last name of the user
     * @property username Username of the user
     * @property phoneNumber Phone number of the user
     * @property status Current online status of the user
     * @property profilePhoto Profile photo of the user
     * @property outgoingLink Relationship from the current user to the other user
     * @property incomingLink Relationship from the other user to the current user
     * @property isVerified True, if the user is verified
     * @property isSupport True, if the user is Telegram support account
     * @property restrictionReason If non-empty, it contains the reason why access to this user must be restricted
     *                             The format of the string is "{type}: {description}"
     *                             {type} contains the type of the restriction and at least one of the suffixes "-all", "-ios", "-android", or "-wp", which describe the platforms on which access should be restricted
     *                             (For example, "terms-ios-android"
     *                             {description} contains a human-readable description of the restriction, which can be shown to the user)
     * @property isScam True, if many users reported this user as a scam
     * @property haveAccess If false, the user is inaccessible, and the only information known about the user is inside this class
     *                      It can't be passed to any method except GetUser
     * @property type Type of the user
     * @property languageCode IETF language tag of the user's language
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("user")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUser"),
        level = DeprecationLevel.WARNING
    )
    data class User(
        @SerialName("id")
        val id: Int,
        @SerialName("first_name")
        val firstName: String,
        @SerialName("last_name")
        val lastName: String,
        @SerialName("username")
        val username: String,
        @SerialName("phone_number")
        val phoneNumber: String,
        @SerialName("status")
        val status: UserStatus,
        @SerialName("profile_photo")
        val profilePhoto: ProfilePhoto?,
        @SerialName("outgoing_link")
        val outgoingLink: LinkState,
        @SerialName("incoming_link")
        val incomingLink: LinkState,
        @SerialName("is_verified")
        val isVerified: Boolean,
        @SerialName("is_support")
        val isSupport: Boolean,
        @SerialName("restriction_reason")
        val restrictionReason: String,
        @SerialName("is_scam")
        val isScam: Boolean,
        @SerialName("have_access")
        val haveAccess: Boolean,
        @SerialName("type")
        val type: UserType,
        @SerialName("language_code")
        @TdBotsOnly
        val languageCode: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains full information about a user (except the full list of profile photos)
     *
     * @property isBlocked True, if the user is blacklisted by the current user
     * @property canBeCalled True, if the user can be called
     * @property hasPrivateCalls True, if the user can't be called due to their privacy settings
     * @property bio A short user bio
     * @property shareText For bots, the text that is included with the link when users share the bot
     * @property groupInCommonCount Number of group chats where both the other user and the current user are a member
     *                              0 for the current user
     * @property botInfo If the user is a bot, information about the bot
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("userFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class UserFullInfo(
        @SerialName("is_blocked")
        val isBlocked: Boolean,
        @SerialName("can_be_called")
        val canBeCalled: Boolean,
        @SerialName("has_private_calls")
        val hasPrivateCalls: Boolean,
        @SerialName("bio")
        val bio: String,
        @SerialName("share_text")
        val shareText: String,
        @SerialName("group_in_common_count")
        val groupInCommonCount: Int,
        @SerialName("bot_info")
        val botInfo: BotInfo?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains full information about a user profile photo
     *
     * @property id Unique user profile photo identifier
     * @property addedDate Point in time (Unix timestamp) when the photo has been added
     * @property sizes Available variants of the user photo, in different sizes
     */
    @Serializable
    @SerialName("userProfilePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserProfilePhoto"),
        level = DeprecationLevel.WARNING
    )
    data class UserProfilePhoto(
        @SerialName("id")
        val id: Long,
        @SerialName("added_date")
        val addedDate: Int,
        @SerialName("sizes")
        val sizes: Array<PhotoSize>
    ) : Object(), TdObject

    /**
     * Contains part of the list of user photos
     *
     * @property totalCount Total number of user profile photos
     * @property photos A list of photos
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("userProfilePhotos")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserProfilePhotos"),
        level = DeprecationLevel.WARNING
    )
    data class UserProfilePhotos(
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("photos")
        val photos: Array<UserProfilePhoto>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a list of users
     *
     * @property totalCount Approximate total count of users found
     * @property userIds A list of user identifiers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("users")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUsers"),
        level = DeprecationLevel.WARNING
    )
    data class Users(
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("user_ids")
        val userIds: IntArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes actions that a user is allowed to take in a chat
     *
     * @property canSendMessages True, if the user can send text messages, contacts, locations, and venues
     * @property canSendMediaMessages True, if the user can send audio files, documents, photos, videos, video notes, and voice notes
     *                                Implies can_send_messages permissions
     * @property canSendPolls True, if the user can send polls
     *                        Implies can_send_messages permissions
     * @property canSendOtherMessages True, if the user can send animations, games, and stickers and use inline bots
     *                                Implies can_send_messages permissions
     * @property canAddWebPagePreviews True, if the user may add a web page preview to their messages
     *                                 Implies can_send_messages permissions
     * @property canChangeInfo True, if the user can change the chat title, photo, and other settings
     * @property canInviteUsers True, if the user can invite new users to the chat
     * @property canPinMessages True, if the user can pin messages
     */
    @Serializable
    @SerialName("chatPermissions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatPermissions"),
        level = DeprecationLevel.WARNING
    )
    data class ChatPermissions(
        @SerialName("can_send_messages")
        val canSendMessages: Boolean,
        @SerialName("can_send_media_messages")
        val canSendMediaMessages: Boolean,
        @SerialName("can_send_polls")
        val canSendPolls: Boolean,
        @SerialName("can_send_other_messages")
        val canSendOtherMessages: Boolean,
        @SerialName("can_add_web_page_previews")
        val canAddWebPagePreviews: Boolean,
        @SerialName("can_change_info")
        val canChangeInfo: Boolean,
        @SerialName("can_invite_users")
        val canInviteUsers: Boolean,
        @SerialName("can_pin_messages")
        val canPinMessages: Boolean
    ) : Object(), TdObject

    /**
     * Provides information about the status of a member in a chat
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus"),
        level = DeprecationLevel.WARNING
    )
    abstract class ChatMemberStatus : Object(), TdObject

    /**
     * The user is the creator of a chat and has all the administrator privileges
     *
     * @property isMember True, if the user is a member of the chat
     */
    @Serializable
    @SerialName("chatMemberStatusCreator")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatusCreator"),
        level = DeprecationLevel.WARNING
    )
    data class ChatMemberStatusCreator(
        @SerialName("is_member")
        val isMember: Boolean
    ) : ChatMemberStatus()

    /**
     * The user is a member of a chat and has some additional privileges
     * In basic groups, administrators can edit and delete messages sent by others, add new members, and ban unprivileged members
     * In supergroups and channels, there are more detailed options for administrator privileges
     *
     * @property canBeEdited True, if the current user can edit the administrator privileges for the called user
     * @property canChangeInfo True, if the administrator can change the chat title, photo, and other settings
     * @property canPostMessages True, if the administrator can create channel posts
     *                           Applicable to channels only
     * @property canEditMessages True, if the administrator can edit messages of other users and pin messages
     *                           Applicable to channels only
     * @property canDeleteMessages True, if the administrator can delete messages of other users
     * @property canInviteUsers True, if the administrator can invite new users to the chat
     * @property canRestrictMembers True, if the administrator can restrict, ban, or unban chat members
     * @property canPinMessages True, if the administrator can pin messages
     *                          Applicable to groups only
     * @property canPromoteMembers True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that were directly or indirectly promoted by him
     */
    @Serializable
    @SerialName("chatMemberStatusAdministrator")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatusAdministrator"),
        level = DeprecationLevel.WARNING
    )
    data class ChatMemberStatusAdministrator(
        @SerialName("can_be_edited")
        val canBeEdited: Boolean,
        @SerialName("can_change_info")
        val canChangeInfo: Boolean,
        @SerialName("can_post_messages")
        val canPostMessages: Boolean,
        @SerialName("can_edit_messages")
        val canEditMessages: Boolean,
        @SerialName("can_delete_messages")
        val canDeleteMessages: Boolean,
        @SerialName("can_invite_users")
        val canInviteUsers: Boolean,
        @SerialName("can_restrict_members")
        val canRestrictMembers: Boolean,
        @SerialName("can_pin_messages")
        val canPinMessages: Boolean,
        @SerialName("can_promote_members")
        val canPromoteMembers: Boolean
    ) : ChatMemberStatus()

    /**
     * The user is a member of a chat, without any additional privileges or restrictions
     */
    @Serializable
    @SerialName("chatMemberStatusMember")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatusMember"),
        level = DeprecationLevel.WARNING
    )
    object ChatMemberStatusMember : ChatMemberStatus()

    /**
     * The user is under certain restrictions in the chat
     * Not supported in basic groups and channels
     *
     * @property isMember True, if the user is a member of the chat
     * @property restrictedUntilDate Point in time (Unix timestamp) when restrictions will be lifted from the user
     *                               0 if never
     *                               If the user is restricted for more than 366 days or for less than 30 seconds from the current time, the user is considered to be restricted forever
     * @property permissions User permissions in the chat
     */
    @Serializable
    @SerialName("chatMemberStatusRestricted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatusRestricted"),
        level = DeprecationLevel.WARNING
    )
    data class ChatMemberStatusRestricted(
        @SerialName("is_member")
        val isMember: Boolean,
        @SerialName("restricted_until_date")
        val restrictedUntilDate: Int,
        @SerialName("permissions")
        val permissions: ChatPermissions
    ) : ChatMemberStatus()

    /**
     * The user is not a chat member
     */
    @Serializable
    @SerialName("chatMemberStatusLeft")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatusLeft"),
        level = DeprecationLevel.WARNING
    )
    object ChatMemberStatusLeft : ChatMemberStatus()

    /**
     * The user was banned (and hence is not a member of the chat)
     * Implies the user can't return to the chat or view messages
     *
     * @property bannedUntilDate Point in time (Unix timestamp) when the user will be unbanned
     *                           0 if never
     *                           If the user is banned for more than 366 days or for less than 30 seconds from the current time, the user is considered to be banned forever
     */
    @Serializable
    @SerialName("chatMemberStatusBanned")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatusBanned"),
        level = DeprecationLevel.WARNING
    )
    data class ChatMemberStatusBanned(
        @SerialName("banned_until_date")
        val bannedUntilDate: Int
    ) : ChatMemberStatus()

    /**
     * A user with information about joining/leaving a chat
     *
     * @property userId User identifier of the chat member
     * @property inviterUserId Identifier of a user that invited/promoted/banned this member in the chat
     *                         0 if unknown
     * @property joinedChatDate Point in time (Unix timestamp) when the user joined a chat
     * @property status Status of the member in the chat
     * @property botInfo If the user is a bot, information about the bot
     *                   Can be null even for a bot if the bot is not a chat member
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chatMember")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMember"),
        level = DeprecationLevel.WARNING
    )
    data class ChatMember(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("inviter_user_id")
        val inviterUserId: Int,
        @SerialName("joined_chat_date")
        val joinedChatDate: Int,
        @SerialName("status")
        val status: ChatMemberStatus,
        @SerialName("bot_info")
        val botInfo: BotInfo?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a list of chat members
     *
     * @property totalCount Approximate total count of chat members found
     * @property members A list of chat members
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chatMembers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembers"),
        level = DeprecationLevel.WARNING
    )
    data class ChatMembers(
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("members")
        val members: Array<ChatMember>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Specifies the kind of chat members to return in searchChatMembers
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter"),
        level = DeprecationLevel.WARNING
    )
    abstract class ChatMembersFilter : Object(), TdObject

    /**
     * Returns contacts of the user
     */
    @Serializable
    @SerialName("chatMembersFilterContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilterContacts"),
        level = DeprecationLevel.WARNING
    )
    object ChatMembersFilterContacts : ChatMembersFilter()

    /**
     * Returns the creator and administrators
     */
    @Serializable
    @SerialName("chatMembersFilterAdministrators")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilterAdministrators"),
        level = DeprecationLevel.WARNING
    )
    object ChatMembersFilterAdministrators : ChatMembersFilter()

    /**
     * Returns all chat members, including restricted chat members
     */
    @Serializable
    @SerialName("chatMembersFilterMembers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilterMembers"),
        level = DeprecationLevel.WARNING
    )
    object ChatMembersFilterMembers : ChatMembersFilter()

    /**
     * Returns users under certain restrictions in the chat
     * Can be used only by administrators in a supergroup
     */
    @Serializable
    @SerialName("chatMembersFilterRestricted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilterRestricted"),
        level = DeprecationLevel.WARNING
    )
    object ChatMembersFilterRestricted : ChatMembersFilter()

    /**
     * Returns users banned from the chat
     * Can be used only by administrators in a supergroup or in a channel
     */
    @Serializable
    @SerialName("chatMembersFilterBanned")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilterBanned"),
        level = DeprecationLevel.WARNING
    )
    object ChatMembersFilterBanned : ChatMembersFilter()

    /**
     * Returns bot members of the chat
     */
    @Serializable
    @SerialName("chatMembersFilterBots")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilterBots"),
        level = DeprecationLevel.WARNING
    )
    object ChatMembersFilterBots : ChatMembersFilter()

    /**
     * Specifies the kind of chat members to return in getSupergroupMembers
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter"),
        level = DeprecationLevel.WARNING
    )
    abstract class SupergroupMembersFilter : Object(), TdObject

    /**
     * Returns recently active users in reverse chronological order
     */
    @Serializable
    @SerialName("supergroupMembersFilterRecent")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilterRecent"),
        level = DeprecationLevel.WARNING
    )
    object SupergroupMembersFilterRecent : SupergroupMembersFilter()

    /**
     * Returns contacts of the user, which are members of the supergroup or channel
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilterContacts"),
        level = DeprecationLevel.WARNING
    )
    data class SupergroupMembersFilterContacts(
        @SerialName("query")
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns the creator and administrators
     */
    @Serializable
    @SerialName("supergroupMembersFilterAdministrators")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilterAdministrators"),
        level = DeprecationLevel.WARNING
    )
    object SupergroupMembersFilterAdministrators : SupergroupMembersFilter()

    /**
     * Used to search for supergroup or channel members via a (string) query
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterSearch")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilterSearch"),
        level = DeprecationLevel.WARNING
    )
    data class SupergroupMembersFilterSearch(
        @SerialName("query")
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns restricted supergroup members
     * Can be used only by administrators
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterRestricted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilterRestricted"),
        level = DeprecationLevel.WARNING
    )
    data class SupergroupMembersFilterRestricted(
        @SerialName("query")
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns users banned from the supergroup or channel
     * Can be used only by administrators
     *
     * @property query Query to search for
     */
    @Serializable
    @SerialName("supergroupMembersFilterBanned")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilterBanned"),
        level = DeprecationLevel.WARNING
    )
    data class SupergroupMembersFilterBanned(
        @SerialName("query")
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns bot members of the supergroup or channel
     */
    @Serializable
    @SerialName("supergroupMembersFilterBots")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilterBots"),
        level = DeprecationLevel.WARNING
    )
    object SupergroupMembersFilterBots : SupergroupMembersFilter()

    /**
     * Represents a basic group of 0-200 users (must be upgraded to a supergroup to accommodate more than 200 users)
     *
     * @property id Group identifier
     * @property memberCount Number of members in the group
     * @property status Status of the current user in the group
     * @property isActive True, if the group is active
     * @property upgradedToSupergroupId Identifier of the supergroup to which this group was upgraded
     *                                  0 if none
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("basicGroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBasicGroup"),
        level = DeprecationLevel.WARNING
    )
    data class BasicGroup(
        @SerialName("id")
        val id: Int,
        @SerialName("member_count")
        val memberCount: Int,
        @SerialName("status")
        val status: ChatMemberStatus,
        @SerialName("is_active")
        val isActive: Boolean,
        @SerialName("upgraded_to_supergroup_id")
        val upgradedToSupergroupId: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains full information about a basic group
     *
     * @property description Group description
     * @property creatorUserId User identifier of the creator of the group
     *                         0 if unknown
     * @property members Group members
     * @property inviteLink Invite link for this group
     *                      Available only for the group creator and only after it has been generated at least once
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("basicGroupFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBasicGroupFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class BasicGroupFullInfo(
        @SerialName("description")
        val description: String,
        @SerialName("creator_user_id")
        val creatorUserId: Int,
        @SerialName("members")
        val members: Array<ChatMember>,
        @SerialName("invite_link")
        val inviteLink: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a supergroup or channel with zero or more members (subscribers in the case of channels)
     * From the point of view of the system, a channel is a special kind of a supergroup: only administrators can post and see the list of members, and posts from all administrators use the name and photo of the channel instead of individual names and profile photos
     * Unlike supergroups, channels can have an unlimited number of subscribers
     *
     * @property id Supergroup or channel identifier
     * @property username Username of the supergroup or channel
     *                    Empty for private supergroups or channels
     * @property date Point in time (Unix timestamp) when the current user joined, or the point in time when the supergroup or channel was created, in case the user is not a member
     * @property status Status of the current user in the supergroup or channel
     * @property memberCount Member count
     *                       0 if unknown
     *                       Currently it is guaranteed to be known only if the supergroup or channel was found through SearchPublicChats
     * @property signMessages True, if messages sent to the channel should contain information about the sender
     *                        This field is only applicable to channels
     * @property isChannel True, if the supergroup is a channel
     * @property isVerified True, if the supergroup or channel is verified
     * @property restrictionReason If non-empty, contains the reason why access to this supergroup or channel must be restricted
     *                             Format of the string is "{type}: {description}"
     *                             {type} Contains the type of the restriction and at least one of the suffixes "-all", "-ios", "-android", or "-wp", which describe the platforms on which access should be restricted
     *                             (For example, "terms-ios-android"
     *                             {description} contains a human-readable description of the restriction, which can be shown to the user)
     * @property isScam True, if many users reported this supergroup as a scam
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("supergroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroup"),
        level = DeprecationLevel.WARNING
    )
    data class Supergroup(
        @SerialName("id")
        val id: Int,
        @SerialName("username")
        val username: String,
        @SerialName("date")
        val date: Int,
        @SerialName("status")
        val status: ChatMemberStatus,
        @SerialName("member_count")
        val memberCount: Int,
        @SerialName("sign_messages")
        val signMessages: Boolean,
        @SerialName("is_channel")
        val isChannel: Boolean,
        @SerialName("is_verified")
        val isVerified: Boolean,
        @SerialName("restriction_reason")
        val restrictionReason: String,
        @SerialName("is_scam")
        val isScam: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains full information about a supergroup or channel
     *
     * @property description Supergroup or channel description
     * @property memberCount Number of members in the supergroup or channel
     *                       0 if unknown
     * @property administratorCount Number of privileged users in the supergroup or channel
     *                              0 if unknown
     * @property restrictedCount Number of restricted users in the supergroup
     *                           0 if unknown
     * @property bannedCount Number of users banned from chat
     *                       0 if unknown
     * @property canGetMembers True, if members of the chat can be retrieved
     * @property canSetUsername True, if the chat can be made public
     * @property canSetStickerSet True, if the supergroup sticker set can be changed
     * @property canViewStatistics True, if the channel statistics is available through getChatStatisticsUrl
     * @property isAllHistoryAvailable True, if new chat members will have access to old messages
     *                                 In public supergroups and both public and private channels, old messages are always available, so this option affects only private supergroups
     *                                 The value of this field is only available for chat administrators
     * @property stickerSetId Identifier of the supergroup sticker set
     *                        0 if none
     * @property inviteLink Invite link for this chat
     * @property upgradedFromBasicGroupId Identifier of the basic group from which supergroup was upgraded
     *                                    0 if none
     * @property upgradedFromMaxMessageId Identifier of the last message in the basic group from which supergroup was upgraded
     *                                    0 if none
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("supergroupFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class SupergroupFullInfo(
        @SerialName("description")
        val description: String,
        @SerialName("member_count")
        val memberCount: Int,
        @SerialName("administrator_count")
        val administratorCount: Int,
        @SerialName("restricted_count")
        val restrictedCount: Int,
        @SerialName("banned_count")
        val bannedCount: Int,
        @SerialName("can_get_members")
        val canGetMembers: Boolean,
        @SerialName("can_set_username")
        val canSetUsername: Boolean,
        @SerialName("can_set_sticker_set")
        val canSetStickerSet: Boolean,
        @SerialName("can_view_statistics")
        val canViewStatistics: Boolean,
        @SerialName("is_all_history_available")
        val isAllHistoryAvailable: Boolean,
        @SerialName("sticker_set_id")
        val stickerSetId: Long,
        @SerialName("invite_link")
        val inviteLink: String,
        @SerialName("upgraded_from_basic_group_id")
        val upgradedFromBasicGroupId: Int,
        @SerialName("upgraded_from_max_message_id")
        val upgradedFromMaxMessageId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes the current secret chat state
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatState"),
        level = DeprecationLevel.WARNING
    )
    abstract class SecretChatState : Object(), TdObject

    /**
     * The secret chat is not yet created
     * Waiting for the other user to get online
     */
    @Serializable
    @SerialName("secretChatStatePending")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatStatePending"),
        level = DeprecationLevel.WARNING
    )
    object SecretChatStatePending : SecretChatState()

    /**
     * The secret chat is ready to use
     */
    @Serializable
    @SerialName("secretChatStateReady")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatStateReady"),
        level = DeprecationLevel.WARNING
    )
    object SecretChatStateReady : SecretChatState()

    /**
     * The secret chat is closed
     */
    @Serializable
    @SerialName("secretChatStateClosed")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatStateClosed"),
        level = DeprecationLevel.WARNING
    )
    object SecretChatStateClosed : SecretChatState()

    /**
     * Represents a secret chat
     *
     * @property id Secret chat identifier
     * @property userId Identifier of the chat partner
     * @property state State of the secret chat
     * @property isOutbound True, if the chat was created by the current user
     *                      Otherwise false
     * @property ttl Current message Time To Live setting (self-destruct timer) for the chat, in seconds
     * @property keyHash Hash of the currently used key for comparison with the hash of the chat partner's key
     *                   This is a string of 36 bytes, which must be used to make a 12x12 square image with a color depth of 4
     *                   The first 16 bytes should be used to make a central 8x8 square, while the remaining 20 bytes should be used to construct a 2-pixel-wide border around that square
     *                   Alternatively, the first 32 bytes of the hash can be converted to the hexadecimal format and printed as 32 2-digit hex numbers
     * @property layer Secret chat layer
     *                 Determines features supported by the other client
     *                 Video notes are supported if the layer >= 66
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("secretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChat"),
        level = DeprecationLevel.WARNING
    )
    data class SecretChat(
        @SerialName("id")
        val id: Int,
        @SerialName("user_id")
        val userId: Int,
        @SerialName("state")
        val state: SecretChatState,
        @SerialName("is_outbound")
        val isOutbound: Boolean,
        @SerialName("ttl")
        val ttl: Int,
        @SerialName("key_hash")
        val keyHash: ByteArray,
        @SerialName("layer")
        val layer: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about the origin of a forwarded message
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOrigin"),
        level = DeprecationLevel.WARNING
    )
    abstract class MessageForwardOrigin : Object(), TdObject

    /**
     * The message was originally written by a known user
     *
     * @property senderUserId Identifier of the user that originally sent the message
     */
    @Serializable
    @SerialName("messageForwardOriginUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOriginUser"),
        level = DeprecationLevel.WARNING
    )
    data class MessageForwardOriginUser(
        @SerialName("sender_user_id")
        val senderUserId: Int
    ) : MessageForwardOrigin()

    /**
     * The message was originally written by a user, which is hidden by their privacy settings
     *
     * @property senderName Name of the sender
     */
    @Serializable
    @SerialName("messageForwardOriginHiddenUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOriginHiddenUser"),
        level = DeprecationLevel.WARNING
    )
    data class MessageForwardOriginHiddenUser(
        @SerialName("sender_name")
        val senderName: String
    ) : MessageForwardOrigin()

    /**
     * The message was originally a post in a channel
     *
     * @property chatId Identifier of the chat from which the message was originally forwarded
     * @property messageId Message identifier of the original message
     *                     0 if unknown
     * @property authorSignature Original post author signature
     */
    @Serializable
    @SerialName("messageForwardOriginChannel")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOriginChannel"),
        level = DeprecationLevel.WARNING
    )
    data class MessageForwardOriginChannel(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("author_signature")
        val authorSignature: String
    ) : MessageForwardOrigin()

    /**
     * Contains information about a forwarded message
     *
     * @property origin Origin of a forwarded message
     * @property date Point in time (Unix timestamp) when the message was originally sent
     * @property fromChatId For messages forwarded to the chat with the current user (saved messages) or to the channel discussion supergroup, the identifier of the chat from which the message was forwarded last time
     *                      0 if unknown
     * @property fromMessageId For messages forwarded to the chat with the current user (saved messages) or to the channel discussion supergroup, the identifier of the original message from which the new message was forwarded last time
     *                         0 if unknown
     */
    @Serializable
    @SerialName("messageForwardInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardInfo"),
        level = DeprecationLevel.WARNING
    )
    data class MessageForwardInfo(
        @SerialName("origin")
        val origin: MessageForwardOrigin,
        @SerialName("date")
        val date: Int,
        @SerialName("from_chat_id")
        val fromChatId: Long,
        @SerialName("from_message_id")
        val fromMessageId: Long
    ) : Object(), TdObject

    /**
     * Contains information about the sending state of the message
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSendingState"),
        level = DeprecationLevel.WARNING
    )
    abstract class MessageSendingState : Object(), TdObject

    /**
     * The message is being sent now, but has not yet been delivered to the server
     */
    @Serializable
    @SerialName("messageSendingStatePending")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSendingStatePending"),
        level = DeprecationLevel.WARNING
    )
    object MessageSendingStatePending : MessageSendingState()

    /**
     * The message failed to be sent
     *
     * @property errorCode An error code
     *                     0 if unknown
     * @property errorMessage Error message
     * @property canRetry True, if the message can be re-sent
     * @property retryAfter Time left before the message can be re-sent, in seconds
     *                      No update is sent when this field changes
     */
    @Serializable
    @SerialName("messageSendingStateFailed")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSendingStateFailed"),
        level = DeprecationLevel.WARNING
    )
    data class MessageSendingStateFailed(
        @SerialName("error_code")
        val errorCode: Int,
        @SerialName("error_message")
        val errorMessage: String,
        @SerialName("can_retry")
        val canRetry: Boolean,
        @SerialName("retry_after")
        val retryAfter: Double
    ) : MessageSendingState()

    /**
     * Describes a message
     *
     * @property id Message identifier, unique for the chat to which the message belongs
     * @property senderUserId Identifier of the user who sent the message
     *                        0 if unknown
     *                        Currently, it is unknown for channel posts and for channel posts automatically forwarded to discussion group
     * @property chatId Chat identifier
     * @property sendingState Information about the sending state of the message
     * @property isOutgoing True, if the message is outgoing
     * @property canBeEdited True, if the message can be edited
     *                       For live location and poll messages this fields shows, whether editMessageLiveLocation or stopPoll can be used with this message by the client
     * @property canBeForwarded True, if the message can be forwarded
     * @property canBeDeletedOnlyForSelf True, if the message can be deleted only for the current user while other users will continue to see it
     * @property canBeDeletedForAllUsers True, if the message can be deleted for all users
     * @property isChannelPost True, if the message is a channel post
     *                         All messages to channels are channel posts, all other messages are not channel posts
     * @property containsUnreadMention True, if the message contains an unread mention for the current user
     * @property date Point in time (Unix timestamp) when the message was sent
     * @property editDate Point in time (Unix timestamp) when the message was last edited
     * @property forwardInfo Information about the initial message sender
     * @property replyToMessageId If non-zero, the identifier of the message this message is replying to
     *                            Can be the identifier of a deleted message
     * @property ttl For self-destructing messages, the message's TTL (Time To Live), in seconds
     *               0 if none
     *               TDLib will send updateDeleteMessages or updateMessageContent once the TTL expires
     * @property ttlExpiresIn Time left before the message expires, in seconds
     * @property viaBotUserId If non-zero, the user identifier of the bot through which this message was sent
     * @property authorSignature For channel posts, optional author signature
     * @property views Number of times this message was viewed
     * @property mediaAlbumId Unique identifier of an album this message belongs to
     *                        Only photos and videos can be grouped together in albums
     * @property content Content of the message
     * @property replyMarkup Reply markup for the message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("message")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessage"),
        level = DeprecationLevel.WARNING
    )
    data class Message(
        @SerialName("id")
        val id: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("sending_state")
        val sendingState: MessageSendingState?,
        @SerialName("is_outgoing")
        val isOutgoing: Boolean,
        @SerialName("can_be_edited")
        val canBeEdited: Boolean,
        @SerialName("can_be_forwarded")
        val canBeForwarded: Boolean,
        @SerialName("can_be_deleted_only_for_self")
        val canBeDeletedOnlyForSelf: Boolean,
        @SerialName("can_be_deleted_for_all_users")
        val canBeDeletedForAllUsers: Boolean,
        @SerialName("is_channel_post")
        val isChannelPost: Boolean,
        @SerialName("contains_unread_mention")
        val containsUnreadMention: Boolean,
        @SerialName("date")
        val date: Int,
        @SerialName("edit_date")
        val editDate: Int,
        @SerialName("forward_info")
        val forwardInfo: MessageForwardInfo?,
        @SerialName("reply_to_message_id")
        val replyToMessageId: Long,
        @SerialName("ttl")
        val ttl: Int,
        @SerialName("ttl_expires_in")
        val ttlExpiresIn: Double,
        @SerialName("via_bot_user_id")
        val viaBotUserId: Int,
        @SerialName("author_signature")
        val authorSignature: String,
        @SerialName("views")
        val views: Int,
        @SerialName("media_album_id")
        val mediaAlbumId: Long,
        @SerialName("content")
        val content: MessageContent,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a list of messages
     *
     * @property totalCount Approximate total count of messages found
     * @property messages List of messages
     *                    Messages may be null
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("messages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessages"),
        level = DeprecationLevel.WARNING
    )
    data class Messages(
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("messages")
        val messages: Array<Message>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a list of messages found by a search
     *
     * @property messages List of messages
     * @property nextFromSearchId Value to pass as from_search_id to get more results
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("foundMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFoundMessages"),
        level = DeprecationLevel.WARNING
    )
    data class FoundMessages(
        @SerialName("messages")
        val messages: Array<Message>,
        @SerialName("next_from_search_id")
        val nextFromSearchId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes the types of chats to which notification settings are applied
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScope"),
        level = DeprecationLevel.WARNING
    )
    abstract class NotificationSettingsScope : Object(), TdObject

    /**
     * Notification settings applied to all private and secret chats when the corresponding chat setting has a default value
     */
    @Serializable
    @SerialName("notificationSettingsScopePrivateChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScopePrivateChats"),
        level = DeprecationLevel.WARNING
    )
    object NotificationSettingsScopePrivateChats : NotificationSettingsScope()

    /**
     * Notification settings applied to all basic groups and supergroups when the corresponding chat setting has a default value
     */
    @Serializable
    @SerialName("notificationSettingsScopeGroupChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScopeGroupChats"),
        level = DeprecationLevel.WARNING
    )
    object NotificationSettingsScopeGroupChats : NotificationSettingsScope()

    /**
     * Notification settings applied to all channels when the corresponding chat setting has a default value
     */
    @Serializable
    @SerialName("notificationSettingsScopeChannelChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScopeChannelChats"),
        level = DeprecationLevel.WARNING
    )
    object NotificationSettingsScopeChannelChats : NotificationSettingsScope()

    /**
     * Contains information about notification settings for a chat
     *
     * @property useDefaultMuteFor If true, mute_for is ignored and the value for the relevant type of chat is used instead
     * @property muteFor Time left before notifications will be unmuted, in seconds
     * @property useDefaultSound If true, sound is ignored and the value for the relevant type of chat is used instead
     * @property sound The name of an audio file to be used for notification sounds
     *                 Only applies to iOS applications
     * @property useDefaultShowPreview If true, show_preview is ignored and the value for the relevant type of chat is used instead
     * @property showPreview True, if message content should be displayed in notifications
     * @property useDefaultDisablePinnedMessageNotifications If true, disable_pinned_message_notifications is ignored and the value for the relevant type of chat is used instead
     * @property disablePinnedMessageNotifications If true, notifications for incoming pinned messages will be created as for an ordinary unread message
     * @property useDefaultDisableMentionNotifications If true, disable_mention_notifications is ignored and the value for the relevant type of chat is used instead
     * @property disableMentionNotifications If true, notifications for messages with mentions will be created as for an ordinary unread message
     */
    @Serializable
    @SerialName("chatNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class ChatNotificationSettings(
        @SerialName("use_default_mute_for")
        val useDefaultMuteFor: Boolean,
        @SerialName("mute_for")
        val muteFor: Int,
        @SerialName("use_default_sound")
        val useDefaultSound: Boolean,
        @SerialName("sound")
        val sound: String,
        @SerialName("use_default_show_preview")
        val useDefaultShowPreview: Boolean,
        @SerialName("show_preview")
        val showPreview: Boolean,
        @SerialName("use_default_disable_pinned_message_notifications")
        val useDefaultDisablePinnedMessageNotifications: Boolean,
        @SerialName("disable_pinned_message_notifications")
        val disablePinnedMessageNotifications: Boolean,
        @SerialName("use_default_disable_mention_notifications")
        val useDefaultDisableMentionNotifications: Boolean,
        @SerialName("disable_mention_notifications")
        val disableMentionNotifications: Boolean
    ) : Object(), TdObject

    /**
     * Contains information about notification settings for several chats
     *
     * @property muteFor Time left before notifications will be unmuted, in seconds
     * @property sound The name of an audio file to be used for notification sounds
     *                 Only applies to iOS applications
     * @property showPreview True, if message content should be displayed in notifications
     * @property disablePinnedMessageNotifications True, if notifications for incoming pinned messages will be created as for an ordinary unread message
     * @property disableMentionNotifications True, if notifications for messages with mentions will be created as for an ordinary unread message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("scopeNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdScopeNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class ScopeNotificationSettings(
        @SerialName("mute_for")
        val muteFor: Int,
        @SerialName("sound")
        val sound: String,
        @SerialName("show_preview")
        val showPreview: Boolean,
        @SerialName("disable_pinned_message_notifications")
        val disablePinnedMessageNotifications: Boolean,
        @SerialName("disable_mention_notifications")
        val disableMentionNotifications: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about a message draft
     *
     * @property replyToMessageId Identifier of the message to reply to
     *                            0 if none
     * @property inputMessageText Content of the message draft
     *                            This should always be of type inputMessageText
     */
    @Serializable
    @SerialName("draftMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDraftMessage"),
        level = DeprecationLevel.WARNING
    )
    data class DraftMessage(
        @SerialName("reply_to_message_id")
        val replyToMessageId: Long,
        @SerialName("input_message_text")
        val inputMessageText: InputMessageContent
    ) : Object(), TdObject

    /**
     * Describes the type of a chat
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatType"),
        level = DeprecationLevel.WARNING
    )
    abstract class ChatType : Object(), TdObject

    /**
     * An ordinary chat with a user
     *
     * @property userId User identifier
     */
    @Serializable
    @SerialName("chatTypePrivate")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatTypePrivate"),
        level = DeprecationLevel.WARNING
    )
    data class ChatTypePrivate(
        @SerialName("user_id")
        val userId: Int
    ) : ChatType()

    /**
     * A basic group (i.e., a chat with 0-200 other users)
     *
     * @property basicGroupId Basic group identifier
     */
    @Serializable
    @SerialName("chatTypeBasicGroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatTypeBasicGroup"),
        level = DeprecationLevel.WARNING
    )
    data class ChatTypeBasicGroup(
        @SerialName("basic_group_id")
        val basicGroupId: Int
    ) : ChatType()

    /**
     * A supergroup (i.e
     * A chat with up to GetOption("supergroup_max_size") other users), or channel (with unlimited members)
     *
     * @property supergroupId Supergroup or channel identifier
     * @property isChannel True, if the supergroup is a channel
     */
    @Serializable
    @SerialName("chatTypeSupergroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatTypeSupergroup"),
        level = DeprecationLevel.WARNING
    )
    data class ChatTypeSupergroup(
        @SerialName("supergroup_id")
        val supergroupId: Int,
        @SerialName("is_channel")
        val isChannel: Boolean
    ) : ChatType()

    /**
     * A secret chat with a user
     *
     * @property secretChatId Secret chat identifier
     * @property userId User identifier of the secret chat peer
     */
    @Serializable
    @SerialName("chatTypeSecret")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatTypeSecret"),
        level = DeprecationLevel.WARNING
    )
    data class ChatTypeSecret(
        @SerialName("secret_chat_id")
        val secretChatId: Int,
        @SerialName("user_id")
        val userId: Int
    ) : ChatType()

    /**
     * A chat
     * (Can be a private chat, basic group, supergroup, or secret chat)
     *
     * @property id Chat unique identifier
     * @property type Type of the chat
     * @property title Chat title
     * @property photo Chat photo
     * @property permissions Actions that non-administrator chat members are allowed to take in the chat
     * @property lastMessage Last message in the chat
     * @property order Descending parameter by which chats are sorted in the main chat list
     *                 If the order number of two chats is the same, they must be sorted in descending order by ID
     *                 If 0, the position of the chat in the list is undetermined
     * @property isPinned True, if the chat is pinned
     * @property isMarkedAsUnread True, if the chat is marked as unread
     * @property isSponsored True, if the chat is sponsored by the user's MTProxy server
     * @property canBeDeletedOnlyForSelf True, if the chat messages can be deleted only for the current user while other users will continue to see the messages
     * @property canBeDeletedForAllUsers True, if the chat messages can be deleted for all users
     * @property canBeReported True, if the chat can be reported to Telegram moderators through reportChat
     * @property defaultDisableNotification Default value of the disable_notification parameter, used when a message is sent to the chat
     * @property unreadCount Number of unread messages in the chat
     * @property lastReadInboxMessageId Identifier of the last read incoming message
     * @property lastReadOutboxMessageId Identifier of the last read outgoing message
     * @property unreadMentionCount Number of unread messages with a mention/reply in the chat
     * @property notificationSettings Notification settings for this chat
     * @property pinnedMessageId Identifier of the pinned message in the chat
     *                           0 if none
     * @property replyMarkupMessageId Identifier of the message from which reply markup needs to be used
     *                                0 if there is no default custom reply markup in the chat
     * @property draftMessage A draft of a message in the chat
     * @property clientData Contains client-specific data associated with the chat
     *                      (For example, the chat position or local chat notification settings can be stored here.) Persistent if a message database is used
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChat"),
        level = DeprecationLevel.WARNING
    )
    data class Chat(
        @SerialName("id")
        val id: Long,
        @SerialName("type")
        val type: ChatType,
        @SerialName("title")
        val title: String,
        @SerialName("photo")
        val photo: ChatPhoto?,
        @SerialName("permissions")
        val permissions: ChatPermissions,
        @SerialName("last_message")
        val lastMessage: Message?,
        @SerialName("order")
        val order: Long,
        @SerialName("is_pinned")
        val isPinned: Boolean,
        @SerialName("is_marked_as_unread")
        val isMarkedAsUnread: Boolean,
        @SerialName("is_sponsored")
        val isSponsored: Boolean,
        @SerialName("can_be_deleted_only_for_self")
        val canBeDeletedOnlyForSelf: Boolean,
        @SerialName("can_be_deleted_for_all_users")
        val canBeDeletedForAllUsers: Boolean,
        @SerialName("can_be_reported")
        val canBeReported: Boolean,
        @SerialName("default_disable_notification")
        val defaultDisableNotification: Boolean,
        @SerialName("unread_count")
        val unreadCount: Int,
        @SerialName("last_read_inbox_message_id")
        val lastReadInboxMessageId: Long,
        @SerialName("last_read_outbox_message_id")
        val lastReadOutboxMessageId: Long,
        @SerialName("unread_mention_count")
        val unreadMentionCount: Int,
        @SerialName("notification_settings")
        val notificationSettings: ChatNotificationSettings,
        @SerialName("pinned_message_id")
        val pinnedMessageId: Long,
        @SerialName("reply_markup_message_id")
        val replyMarkupMessageId: Long,
        @SerialName("draft_message")
        val draftMessage: DraftMessage?,
        @SerialName("client_data")
        val clientData: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a list of chats
     *
     * @property chatIds List of chat identifiers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChats"),
        level = DeprecationLevel.WARNING
    )
    data class Chats(
        @SerialName("chat_ids")
        val chatIds: LongArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a chat invite link
     *
     * @property inviteLink Chat invite link
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chatInviteLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatInviteLink"),
        level = DeprecationLevel.WARNING
    )
    data class ChatInviteLink(
        @SerialName("invite_link")
        val inviteLink: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about a chat invite link
     *
     * @property chatId Chat identifier of the invite link
     *                  0 if the user is not a member of this chat
     * @property type Contains information about the type of the chat
     * @property title Title of the chat
     * @property photo Chat photo
     * @property memberCount Number of members
     * @property memberUserIds User identifiers of some chat members that may be known to the current user
     * @property isPublic True, if the chat is a public supergroup or a channel with a username
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chatInviteLinkInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatInviteLinkInfo"),
        level = DeprecationLevel.WARNING
    )
    data class ChatInviteLinkInfo(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("type")
        val type: ChatType,
        @SerialName("title")
        val title: String,
        @SerialName("photo")
        val photo: ChatPhoto?,
        @SerialName("member_count")
        val memberCount: Int,
        @SerialName("member_user_ids")
        val memberUserIds: IntArray,
        @SerialName("is_public")
        val isPublic: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes a keyboard button type
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonType"),
        level = DeprecationLevel.WARNING
    )
    abstract class KeyboardButtonType : Object(), TdObject

    /**
     * A simple button, with text that should be sent when the button is pressed
     */
    @Serializable
    @SerialName("keyboardButtonTypeText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonTypeText"),
        level = DeprecationLevel.WARNING
    )
    object KeyboardButtonTypeText : KeyboardButtonType()

    /**
     * A button that sends the user's phone number when pressed
     * Available only in private chats
     */
    @Serializable
    @SerialName("keyboardButtonTypeRequestPhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonTypeRequestPhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    object KeyboardButtonTypeRequestPhoneNumber : KeyboardButtonType()

    /**
     * A button that sends the user's location when pressed
     * Available only in private chats
     */
    @Serializable
    @SerialName("keyboardButtonTypeRequestLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonTypeRequestLocation"),
        level = DeprecationLevel.WARNING
    )
    object KeyboardButtonTypeRequestLocation : KeyboardButtonType()

    /**
     * Represents a single button in a bot keyboard
     *
     * @property text Text of the button
     * @property type Type of the button
     */
    @Serializable
    @SerialName("keyboardButton")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButton"),
        level = DeprecationLevel.WARNING
    )
    data class KeyboardButton(
        @SerialName("text")
        val text: String,
        @SerialName("type")
        val type: KeyboardButtonType
    ) : Object(), TdObject

    /**
     * Describes the type of an inline keyboard button
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType"),
        level = DeprecationLevel.WARNING
    )
    abstract class InlineKeyboardButtonType : Object(), TdObject

    /**
     * A button that opens a specified URL
     *
     * @property url HTTP or tg:// URL to open
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonTypeUrl"),
        level = DeprecationLevel.WARNING
    )
    data class InlineKeyboardButtonTypeUrl(
        @SerialName("url")
        val url: String
    ) : InlineKeyboardButtonType()

    /**
     * A button that opens a specified URL and automatically logs in in current user if they allowed to do that
     *
     * @property url HTTP URL to open
     * @property id Unique button identifier
     * @property forwardText If non-empty, new text of the button in forwarded messages
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeLoginUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonTypeLoginUrl"),
        level = DeprecationLevel.WARNING
    )
    data class InlineKeyboardButtonTypeLoginUrl(
        @SerialName("url")
        val url: String,
        @SerialName("id")
        val id: Int,
        @SerialName("forward_text")
        val forwardText: String
    ) : InlineKeyboardButtonType()

    /**
     * A button that sends a special callback query to a bot
     *
     * @property data Data to be sent to the bot via a callback query
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeCallback")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonTypeCallback"),
        level = DeprecationLevel.WARNING
    )
    data class InlineKeyboardButtonTypeCallback(
        @SerialName("data")
        val data: ByteArray
    ) : InlineKeyboardButtonType()

    /**
     * A button with a game that sends a special callback query to a bot
     * This button must be in the first column and row of the keyboard and can be attached only to a message with content of the type messageGame
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeCallbackGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonTypeCallbackGame"),
        level = DeprecationLevel.WARNING
    )
    object InlineKeyboardButtonTypeCallbackGame : InlineKeyboardButtonType()

    /**
     * A button that forces an inline query to the bot to be inserted in the input field
     *
     * @property query Inline query to be sent to the bot
     * @property inCurrentChat True, if the inline query should be sent from the current chat
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeSwitchInline")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonTypeSwitchInline"),
        level = DeprecationLevel.WARNING
    )
    data class InlineKeyboardButtonTypeSwitchInline(
        @SerialName("query")
        val query: String,
        @SerialName("in_current_chat")
        val inCurrentChat: Boolean
    ) : InlineKeyboardButtonType()

    /**
     * A button to buy something
     * This button must be in the first column and row of the keyboard and can be attached only to a message with content of the type messageInvoice
     */
    @Serializable
    @SerialName("inlineKeyboardButtonTypeBuy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonTypeBuy"),
        level = DeprecationLevel.WARNING
    )
    object InlineKeyboardButtonTypeBuy : InlineKeyboardButtonType()

    /**
     * Represents a single button in an inline keyboard
     *
     * @property text Text of the button
     * @property type Type of the button
     */
    @Serializable
    @SerialName("inlineKeyboardButton")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButton"),
        level = DeprecationLevel.WARNING
    )
    data class InlineKeyboardButton(
        @SerialName("text")
        val text: String,
        @SerialName("type")
        val type: InlineKeyboardButtonType
    ) : Object(), TdObject

    /**
     * Contains a description of a custom keyboard and actions that can be done with it to quickly reply to bots
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkup"),
        level = DeprecationLevel.WARNING
    )
    abstract class ReplyMarkup : Object(), TdObject

    /**
     * Instructs clients to remove the keyboard once this message has been received
     * This kind of keyboard can't be received in an incoming message
     * Instead, UpdateChatReplyMarkup with message_id == 0 will be sent
     *
     * @property isPersonal True, if the keyboard is removed only for the mentioned users or the target user of a reply
     */
    @Serializable
    @SerialName("replyMarkupRemoveKeyboard")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkupRemoveKeyboard"),
        level = DeprecationLevel.WARNING
    )
    data class ReplyMarkupRemoveKeyboard(
        @SerialName("is_personal")
        val isPersonal: Boolean
    ) : ReplyMarkup()

    /**
     * Instructs clients to force a reply to this message
     *
     * @property isPersonal True, if a forced reply must automatically be shown to the current user
     *                      For outgoing messages, specify true to show the forced reply only for the mentioned users and for the target user of a reply
     */
    @Serializable
    @SerialName("replyMarkupForceReply")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkupForceReply"),
        level = DeprecationLevel.WARNING
    )
    data class ReplyMarkupForceReply(
        @SerialName("is_personal")
        val isPersonal: Boolean
    ) : ReplyMarkup()

    /**
     * Contains a custom keyboard layout to quickly reply to bots
     *
     * @property rows A list of rows of bot keyboard buttons
     * @property resizeKeyboard True, if the client needs to resize the keyboard vertically
     * @property oneTime True, if the client needs to hide the keyboard after use
     * @property isPersonal True, if the keyboard must automatically be shown to the current user
     *                      For outgoing messages, specify true to show the keyboard only for the mentioned users and for the target user of a reply
     */
    @Serializable
    @SerialName("replyMarkupShowKeyboard")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkupShowKeyboard"),
        level = DeprecationLevel.WARNING
    )
    data class ReplyMarkupShowKeyboard(
        @SerialName("rows")
        val rows: Array<Array<KeyboardButton>>,
        @SerialName("resize_keyboard")
        val resizeKeyboard: Boolean,
        @SerialName("one_time")
        val oneTime: Boolean,
        @SerialName("is_personal")
        val isPersonal: Boolean
    ) : ReplyMarkup()

    /**
     * Contains an inline keyboard layout
     *
     * @property rows A list of rows of inline keyboard buttons
     */
    @Serializable
    @SerialName("replyMarkupInlineKeyboard")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkupInlineKeyboard"),
        level = DeprecationLevel.WARNING
    )
    data class ReplyMarkupInlineKeyboard(
        @SerialName("rows")
        val rows: Array<Array<InlineKeyboardButton>>
    ) : ReplyMarkup()

    /**
     * Describes a text object inside an instant-view web page
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText"),
        level = DeprecationLevel.WARNING
    )
    abstract class RichText : Object(), TdObject

    /**
     * A plain text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextPlain")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextPlain"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextPlain(
        @SerialName("text")
        val text: String
    ) : RichText()

    /**
     * A bold rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextBold")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextBold"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextBold(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * An italicized rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextItalic")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextItalic"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextItalic(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * An underlined rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextUnderline")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextUnderline"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextUnderline(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * A strike-through rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextStrikethrough")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextStrikethrough"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextStrikethrough(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * A fixed-width rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextFixed")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextFixed"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextFixed(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * A rich text URL link
     *
     * @property text Text
     * @property url URL
     */
    @Serializable
    @SerialName("richTextUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextUrl"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextUrl(
        @SerialName("text")
        val text: RichText,
        @SerialName("url")
        val url: String
    ) : RichText()

    /**
     * A rich text email link
     *
     * @property text Text
     * @property emailAddress Email address
     */
    @Serializable
    @SerialName("richTextEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextEmailAddress(
        @SerialName("text")
        val text: RichText,
        @SerialName("email_address")
        val emailAddress: String
    ) : RichText()

    /**
     * A subscript rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextSubscript")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextSubscript"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextSubscript(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * A superscript rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextSuperscript")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextSuperscript"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextSuperscript(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * A marked rich text
     *
     * @property text Text
     */
    @Serializable
    @SerialName("richTextMarked")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextMarked"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextMarked(
        @SerialName("text")
        val text: RichText
    ) : RichText()

    /**
     * A rich text phone number
     *
     * @property text Text
     * @property phoneNumber Phone number
     */
    @Serializable
    @SerialName("richTextPhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextPhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextPhoneNumber(
        @SerialName("text")
        val text: RichText,
        @SerialName("phone_number")
        val phoneNumber: String
    ) : RichText()

    /**
     * A small image inside the text
     *
     * @property document The image represented as a document
     *                    The image can be in GIF, JPEG or PNG format
     * @property width Width of a bounding box in which the image should be shown
     *                 0 if unknown
     * @property height Height of a bounding box in which the image should be shown
     *                  0 if unknown
     */
    @Serializable
    @SerialName("richTextIcon")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextIcon"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextIcon(
        @SerialName("document")
        val document: Document,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int
    ) : RichText()

    /**
     * A rich text anchor
     *
     * @property text Text
     * @property name Anchor name
     */
    @Serializable
    @SerialName("richTextAnchor")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTextAnchor"),
        level = DeprecationLevel.WARNING
    )
    data class RichTextAnchor(
        @SerialName("text")
        val text: RichText,
        @SerialName("name")
        val name: String
    ) : RichText()

    /**
     * A concatenation of rich texts
     *
     * @property texts Texts
     */
    @Serializable
    @SerialName("richTexts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichTexts"),
        level = DeprecationLevel.WARNING
    )
    data class RichTexts(
        @SerialName("texts")
        val texts: Array<RichText>
    ) : RichText()

    /**
     * Contains a caption of an instant view web page block, consisting of a text and a trailing credit
     *
     * @property text Content of the caption
     * @property credit Block credit (like HTML tag <cite>)
     */
    @Serializable
    @SerialName("pageBlockCaption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockCaption"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockCaption(
        @SerialName("text")
        val text: RichText,
        @SerialName("credit")
        val credit: RichText
    ) : Object(), TdObject

    /**
     * Describes an item of a list page block
     *
     * @property label Item label
     * @property pageBlocks Item blocks
     */
    @Serializable
    @SerialName("pageBlockListItem")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockListItem"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockListItem(
        @SerialName("label")
        val label: String,
        @SerialName("page_blocks")
        val pageBlocks: Array<PageBlock>
    ) : Object(), TdObject

    /**
     * Describes a horizontal alignment of a table cell content
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignment"),
        level = DeprecationLevel.WARNING
    )
    abstract class PageBlockHorizontalAlignment : Object(), TdObject

    /**
     * The content should be left-aligned
     */
    @Serializable
    @SerialName("pageBlockHorizontalAlignmentLeft")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignmentLeft"),
        level = DeprecationLevel.WARNING
    )
    object PageBlockHorizontalAlignmentLeft : PageBlockHorizontalAlignment()

    /**
     * The content should be center-aligned
     */
    @Serializable
    @SerialName("pageBlockHorizontalAlignmentCenter")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignmentCenter"),
        level = DeprecationLevel.WARNING
    )
    object PageBlockHorizontalAlignmentCenter : PageBlockHorizontalAlignment()

    /**
     * The content should be right-aligned
     */
    @Serializable
    @SerialName("pageBlockHorizontalAlignmentRight")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignmentRight"),
        level = DeprecationLevel.WARNING
    )
    object PageBlockHorizontalAlignmentRight : PageBlockHorizontalAlignment()

    /**
     * Describes a Vertical alignment of a table cell content
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignment"),
        level = DeprecationLevel.WARNING
    )
    abstract class PageBlockVerticalAlignment : Object(), TdObject

    /**
     * The content should be top-aligned
     */
    @Serializable
    @SerialName("pageBlockVerticalAlignmentTop")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignmentTop"),
        level = DeprecationLevel.WARNING
    )
    object PageBlockVerticalAlignmentTop : PageBlockVerticalAlignment()

    /**
     * The content should be middle-aligned
     */
    @Serializable
    @SerialName("pageBlockVerticalAlignmentMiddle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignmentMiddle"),
        level = DeprecationLevel.WARNING
    )
    object PageBlockVerticalAlignmentMiddle : PageBlockVerticalAlignment()

    /**
     * The content should be bottom-aligned
     */
    @Serializable
    @SerialName("pageBlockVerticalAlignmentBottom")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignmentBottom"),
        level = DeprecationLevel.WARNING
    )
    object PageBlockVerticalAlignmentBottom : PageBlockVerticalAlignment()

    /**
     * Represents a cell of a table
     *
     * @property text Cell text
     * @property isHeader True, if it is a header cell
     * @property colspan The number of columns the cell should span
     * @property rowspan The number of rows the cell should span
     * @property align Horizontal cell content alignment
     * @property valign Vertical cell content alignment
     */
    @Serializable
    @SerialName("pageBlockTableCell")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockTableCell"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockTableCell(
        @SerialName("text")
        val text: RichText,
        @SerialName("is_header")
        val isHeader: Boolean,
        @SerialName("colspan")
        val colspan: Int,
        @SerialName("rowspan")
        val rowspan: Int,
        @SerialName("align")
        val align: PageBlockHorizontalAlignment,
        @SerialName("valign")
        val valign: PageBlockVerticalAlignment
    ) : Object(), TdObject

    /**
     * Contains information about a related article
     *
     * @property url Related article URL
     * @property title Article title
     * @property description Article description
     * @property photo Article photo
     * @property author Article author
     * @property publishDate Point in time (Unix timestamp) when the article was published
     *                       0 if unknown
     */
    @Serializable
    @SerialName("pageBlockRelatedArticle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockRelatedArticle"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockRelatedArticle(
        @SerialName("url")
        val url: String,
        @SerialName("title")
        val title: String?,
        @SerialName("description")
        val description: String?,
        @SerialName("photo")
        val photo: Photo?,
        @SerialName("author")
        val author: String?,
        @SerialName("publish_date")
        val publishDate: Int
    ) : Object(), TdObject

    /**
     * Describes a block of an instant view web page
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock"),
        level = DeprecationLevel.WARNING
    )
    abstract class PageBlock : Object(), TdObject

    /**
     * The title of a page
     *
     * @property title Title
     */
    @Serializable
    @SerialName("pageBlockTitle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockTitle"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockTitle(
        @SerialName("title")
        val title: RichText
    ) : PageBlock()

    /**
     * The subtitle of a page
     *
     * @property subtitle Subtitle
     */
    @Serializable
    @SerialName("pageBlockSubtitle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockSubtitle"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockSubtitle(
        @SerialName("subtitle")
        val subtitle: RichText
    ) : PageBlock()

    /**
     * The author and publishing date of a page
     *
     * @property author Author
     * @property publishDate Point in time (Unix timestamp) when the article was published
     *                       0 if unknown
     */
    @Serializable
    @SerialName("pageBlockAuthorDate")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockAuthorDate"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockAuthorDate(
        @SerialName("author")
        val author: RichText,
        @SerialName("publish_date")
        val publishDate: Int
    ) : PageBlock()

    /**
     * A header
     *
     * @property header Header
     */
    @Serializable
    @SerialName("pageBlockHeader")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHeader"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockHeader(
        @SerialName("header")
        val header: RichText
    ) : PageBlock()

    /**
     * A subheader
     *
     * @property subheader Subheader
     */
    @Serializable
    @SerialName("pageBlockSubheader")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockSubheader"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockSubheader(
        @SerialName("subheader")
        val subheader: RichText
    ) : PageBlock()

    /**
     * A kicker
     *
     * @property kicker Kicker
     */
    @Serializable
    @SerialName("pageBlockKicker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockKicker"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockKicker(
        @SerialName("kicker")
        val kicker: RichText
    ) : PageBlock()

    /**
     * A text paragraph
     *
     * @property text Paragraph text
     */
    @Serializable
    @SerialName("pageBlockParagraph")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockParagraph"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockParagraph(
        @SerialName("text")
        val text: RichText
    ) : PageBlock()

    /**
     * A preformatted text paragraph
     *
     * @property text Paragraph text
     * @property language Programming language for which the text should be formatted
     */
    @Serializable
    @SerialName("pageBlockPreformatted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockPreformatted"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockPreformatted(
        @SerialName("text")
        val text: RichText,
        @SerialName("language")
        val language: String
    ) : PageBlock()

    /**
     * The footer of a page
     *
     * @property footer Footer
     */
    @Serializable
    @SerialName("pageBlockFooter")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockFooter"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockFooter(
        @SerialName("footer")
        val footer: RichText
    ) : PageBlock()

    /**
     * An empty block separating a page
     */
    @Serializable
    @SerialName("pageBlockDivider")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockDivider"),
        level = DeprecationLevel.WARNING
    )
    object PageBlockDivider : PageBlock()

    /**
     * An invisible anchor on a page, which can be used in a URL to open the page from the specified anchor
     *
     * @property name Name of the anchor
     */
    @Serializable
    @SerialName("pageBlockAnchor")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockAnchor"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockAnchor(
        @SerialName("name")
        val name: String
    ) : PageBlock()

    /**
     * A list of data blocks
     *
     * @property items The items of the list
     */
    @Serializable
    @SerialName("pageBlockList")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockList"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockList(
        @SerialName("items")
        val items: Array<PageBlockListItem>
    ) : PageBlock()

    /**
     * A block quote
     *
     * @property text Quote text
     * @property credit Quote credit
     */
    @Serializable
    @SerialName("pageBlockBlockQuote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockBlockQuote"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockBlockQuote(
        @SerialName("text")
        val text: RichText,
        @SerialName("credit")
        val credit: RichText
    ) : PageBlock()

    /**
     * A pull quote
     *
     * @property text Quote text
     * @property credit Quote credit
     */
    @Serializable
    @SerialName("pageBlockPullQuote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockPullQuote"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockPullQuote(
        @SerialName("text")
        val text: RichText,
        @SerialName("credit")
        val credit: RichText
    ) : PageBlock()

    /**
     * An animation
     *
     * @property animation Animation file
     * @property caption Animation caption
     * @property needAutoplay True, if the animation should be played automatically
     */
    @Serializable
    @SerialName("pageBlockAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockAnimation(
        @SerialName("animation")
        val animation: Animation?,
        @SerialName("caption")
        val caption: PageBlockCaption,
        @SerialName("need_autoplay")
        val needAutoplay: Boolean
    ) : PageBlock()

    /**
     * An audio file
     *
     * @property audio Audio file
     * @property caption Audio file caption
     */
    @Serializable
    @SerialName("pageBlockAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockAudio"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockAudio(
        @SerialName("audio")
        val audio: Audio?,
        @SerialName("caption")
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A photo
     *
     * @property photo Photo file
     * @property caption Photo caption
     * @property url URL that needs to be opened when the photo is clicked
     */
    @Serializable
    @SerialName("pageBlockPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockPhoto(
        @SerialName("photo")
        val photo: Photo?,
        @SerialName("caption")
        val caption: PageBlockCaption,
        @SerialName("url")
        val url: String
    ) : PageBlock()

    /**
     * A video
     *
     * @property video Video file
     * @property caption Video caption
     * @property needAutoplay True, if the video should be played automatically
     * @property isLooped True, if the video should be looped
     */
    @Serializable
    @SerialName("pageBlockVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVideo"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockVideo(
        @SerialName("video")
        val video: Video?,
        @SerialName("caption")
        val caption: PageBlockCaption,
        @SerialName("need_autoplay")
        val needAutoplay: Boolean,
        @SerialName("is_looped")
        val isLooped: Boolean
    ) : PageBlock()

    /**
     * A page cover
     *
     * @property cover Cover
     */
    @Serializable
    @SerialName("pageBlockCover")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockCover"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockCover(
        @SerialName("cover")
        val cover: PageBlock
    ) : PageBlock()

    /**
     * An embedded web page
     *
     * @property url Web page URL, if available
     * @property html HTML-markup of the embedded page
     * @property posterPhoto Poster photo, if available
     * @property width Block width
     *                 0 if unknown
     * @property height Block height
     *                  0 if unknown
     * @property caption Block caption
     * @property isFullWidth True, if the block should be full width
     * @property allowScrolling True, if scrolling should be allowed
     */
    @Serializable
    @SerialName("pageBlockEmbedded")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockEmbedded"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockEmbedded(
        @SerialName("url")
        val url: String,
        @SerialName("html")
        val html: String,
        @SerialName("poster_photo")
        val posterPhoto: Photo?,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: PageBlockCaption,
        @SerialName("is_full_width")
        val isFullWidth: Boolean,
        @SerialName("allow_scrolling")
        val allowScrolling: Boolean
    ) : PageBlock()

    /**
     * An embedded post
     *
     * @property url Web page URL
     * @property author Post author
     * @property authorPhoto Post author photo
     * @property date Point in time (Unix timestamp) when the post was created
     *                0 if unknown
     * @property pageBlocks Post content
     * @property caption Post caption
     */
    @Serializable
    @SerialName("pageBlockEmbeddedPost")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockEmbeddedPost"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockEmbeddedPost(
        @SerialName("url")
        val url: String,
        @SerialName("author")
        val author: String,
        @SerialName("author_photo")
        val authorPhoto: Photo?,
        @SerialName("date")
        val date: Int,
        @SerialName("page_blocks")
        val pageBlocks: Array<PageBlock>,
        @SerialName("caption")
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A collage
     *
     * @property pageBlocks Collage item contents
     * @property caption Block caption
     */
    @Serializable
    @SerialName("pageBlockCollage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockCollage"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockCollage(
        @SerialName("page_blocks")
        val pageBlocks: Array<PageBlock>,
        @SerialName("caption")
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A slideshow
     *
     * @property pageBlocks Slideshow item contents
     * @property caption Block caption
     */
    @Serializable
    @SerialName("pageBlockSlideshow")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockSlideshow"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockSlideshow(
        @SerialName("page_blocks")
        val pageBlocks: Array<PageBlock>,
        @SerialName("caption")
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A link to a chat
     *
     * @property title Chat title
     * @property photo Chat photo
     * @property username Chat username, by which all other information about the chat should be resolved
     */
    @Serializable
    @SerialName("pageBlockChatLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockChatLink"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockChatLink(
        @SerialName("title")
        val title: String,
        @SerialName("photo")
        val photo: ChatPhoto?,
        @SerialName("username")
        val username: String
    ) : PageBlock()

    /**
     * A table
     *
     * @property caption Table caption
     * @property cells Table cells
     * @property isBordered True, if the table is bordered
     * @property isStriped True, if the table is striped
     */
    @Serializable
    @SerialName("pageBlockTable")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockTable"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockTable(
        @SerialName("caption")
        val caption: RichText,
        @SerialName("cells")
        val cells: Array<Array<PageBlockTableCell>>,
        @SerialName("is_bordered")
        val isBordered: Boolean,
        @SerialName("is_striped")
        val isStriped: Boolean
    ) : PageBlock()

    /**
     * A collapsible block
     *
     * @property header Always visible heading for the block
     * @property pageBlocks Block contents
     * @property isOpen True, if the block is open by default
     */
    @Serializable
    @SerialName("pageBlockDetails")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockDetails"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockDetails(
        @SerialName("header")
        val header: RichText,
        @SerialName("page_blocks")
        val pageBlocks: Array<PageBlock>,
        @SerialName("is_open")
        val isOpen: Boolean
    ) : PageBlock()

    /**
     * Related articles
     *
     * @property header Block header
     * @property articles List of related articles
     */
    @Serializable
    @SerialName("pageBlockRelatedArticles")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockRelatedArticles"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockRelatedArticles(
        @SerialName("header")
        val header: RichText,
        @SerialName("articles")
        val articles: Array<PageBlockRelatedArticle>
    ) : PageBlock()

    /**
     * A map
     *
     * @property location Location of the map center
     * @property zoom Map zoom level
     * @property width Map width
     * @property height Map height
     * @property caption Block caption
     */
    @Serializable
    @SerialName("pageBlockMap")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockMap"),
        level = DeprecationLevel.WARNING
    )
    data class PageBlockMap(
        @SerialName("location")
        val location: Location,
        @SerialName("zoom")
        val zoom: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * Describes an instant view page for a web page
     *
     * @property pageBlocks Content of the web page
     * @property version Version of the instant view, currently can be 1 or 2
     * @property url Instant view URL
     *               May be different from WebPage.url and must be used for the correct anchors handling
     * @property isRtl True, if the instant view must be shown from right to left
     * @property isFull True, if the instant view contains the full page
     *                  A network request might be needed to get the full web page instant view
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("webPageInstantView")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdWebPageInstantView"),
        level = DeprecationLevel.WARNING
    )
    data class WebPageInstantView(
        @SerialName("page_blocks")
        val pageBlocks: Array<PageBlock>,
        @SerialName("version")
        val version: Int,
        @SerialName("url")
        val url: String,
        @SerialName("is_rtl")
        val isRtl: Boolean,
        @SerialName("is_full")
        val isFull: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes a web page preview
     *
     * @property url Original URL of the link
     * @property displayUrl URL to display
     * @property type Type of the web page
     *                Can be: article, photo, audio, video, document, profile, app, or something else
     * @property siteName Short name of the site (e.g., Google Docs, App Store)
     * @property title Title of the content
     * @property description Description of the content
     * @property photo Image representing the content
     * @property embedUrl URL to show in the embedded preview
     * @property embedType MIME type of the embedded preview, (e.g., text/html or video/mp4)
     * @property embedWidth Width of the embedded preview
     * @property embedHeight Height of the embedded preview
     * @property duration Duration of the content, in seconds
     * @property author Author of the content
     * @property animation Preview of the content as an animation, if available
     * @property audio Preview of the content as an audio file, if available
     * @property document Preview of the content as a document, if available (currently only available for small PDF files and ZIP archives)
     * @property sticker Preview of the content as a sticker for small WEBP files, if available
     * @property video Preview of the content as a video, if available
     * @property videoNote Preview of the content as a video note, if available
     * @property voiceNote Preview of the content as a voice note, if available
     * @property instantViewVersion Version of instant view, available for the web page (currently can be 1 or 2), 0 if none
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("webPage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdWebPage"),
        level = DeprecationLevel.WARNING
    )
    data class WebPage(
        @SerialName("url")
        val url: String,
        @SerialName("display_url")
        val displayUrl: String,
        @SerialName("type")
        val type: String,
        @SerialName("site_name")
        val siteName: String,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("photo")
        val photo: Photo?,
        @SerialName("embed_url")
        val embedUrl: String,
        @SerialName("embed_type")
        val embedType: String,
        @SerialName("embed_width")
        val embedWidth: Int,
        @SerialName("embed_height")
        val embedHeight: Int,
        @SerialName("duration")
        val duration: Int,
        @SerialName("author")
        val author: String,
        @SerialName("animation")
        val animation: Animation?,
        @SerialName("audio")
        val audio: Audio?,
        @SerialName("document")
        val document: Document?,
        @SerialName("sticker")
        val sticker: Sticker?,
        @SerialName("video")
        val video: Video?,
        @SerialName("video_note")
        val videoNote: VideoNote?,
        @SerialName("voice_note")
        val voiceNote: VoiceNote?,
        @SerialName("instant_view_version")
        val instantViewVersion: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes an address
     *
     * @property countryCode A two-letter ISO 3166-1 alpha-2 country code
     * @property state State, if applicable
     * @property city City
     * @property streetLine1 First line of the address
     * @property streetLine2 Second line of the address
     * @property postalCode Address postal code
     */
    @Serializable
    @SerialName("address")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddress"),
        level = DeprecationLevel.WARNING
    )
    data class Address(
        @SerialName("country_code")
        val countryCode: String,
        @SerialName("state")
        val state: String,
        @SerialName("city")
        val city: String,
        @SerialName("street_line1")
        val streetLine1: String,
        @SerialName("street_line2")
        val streetLine2: String,
        @SerialName("postal_code")
        val postalCode: String
    ) : Object(), TdObject

    /**
     * Portion of the price of a product (e.g., "delivery cost", "tax amount")
     *
     * @property label Label for this portion of the product price
     * @property amount Currency amount in minimal quantity of the currency
     */
    @Serializable
    @SerialName("labeledPricePart")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLabeledPricePart"),
        level = DeprecationLevel.WARNING
    )
    data class LabeledPricePart(
        @SerialName("label")
        val label: String,
        @SerialName("amount")
        val amount: Long
    ) : Object(), TdObject

    /**
     * Product invoice
     *
     * @property currency ISO 4217 currency code
     * @property priceParts A list of objects used to calculate the total price of the product
     * @property isTest True, if the payment is a test payment
     * @property needName True, if the user's name is needed for payment
     * @property needPhoneNumber True, if the user's phone number is needed for payment
     * @property needEmailAddress True, if the user's email address is needed for payment
     * @property needShippingAddress True, if the user's shipping address is needed for payment
     * @property sendPhoneNumberToProvider True, if the user's phone number will be sent to the provider
     * @property sendEmailAddressToProvider True, if the user's email address will be sent to the provider
     * @property isFlexible True, if the total price depends on the shipping method
     */
    @Serializable
    @SerialName("invoice")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInvoice"),
        level = DeprecationLevel.WARNING
    )
    data class Invoice(
        @SerialName("currency")
        val currency: String,
        @SerialName("price_parts")
        val priceParts: Array<LabeledPricePart>,
        @SerialName("is_test")
        val isTest: Boolean,
        @SerialName("need_name")
        val needName: Boolean,
        @SerialName("need_phone_number")
        val needPhoneNumber: Boolean,
        @SerialName("need_email_address")
        val needEmailAddress: Boolean,
        @SerialName("need_shipping_address")
        val needShippingAddress: Boolean,
        @SerialName("send_phone_number_to_provider")
        val sendPhoneNumberToProvider: Boolean,
        @SerialName("send_email_address_to_provider")
        val sendEmailAddressToProvider: Boolean,
        @SerialName("is_flexible")
        val isFlexible: Boolean
    ) : Object(), TdObject

    /**
     * Order information
     *
     * @property name Name of the user
     * @property phoneNumber Phone number of the user
     * @property emailAddress Email address of the user
     * @property shippingAddress Shipping address for this order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("orderInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOrderInfo"),
        level = DeprecationLevel.WARNING
    )
    data class OrderInfo(
        @SerialName("name")
        val name: String,
        @SerialName("phone_number")
        val phoneNumber: String,
        @SerialName("email_address")
        val emailAddress: String,
        @SerialName("shipping_address")
        val shippingAddress: Address?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * One shipping option
     *
     * @property id Shipping option identifier
     * @property title Option title
     * @property priceParts A list of objects used to calculate the total shipping costs
     */
    @Serializable
    @SerialName("shippingOption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdShippingOption"),
        level = DeprecationLevel.WARNING
    )
    data class ShippingOption(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("price_parts")
        val priceParts: Array<LabeledPricePart>
    ) : Object(), TdObject

    /**
     * Contains information about saved card credentials
     *
     * @property id Unique identifier of the saved credentials
     * @property title Title of the saved credentials
     */
    @Serializable
    @SerialName("savedCredentials")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSavedCredentials"),
        level = DeprecationLevel.WARNING
    )
    data class SavedCredentials(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String
    ) : Object(), TdObject

    /**
     * Contains information about the payment method chosen by the user
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentials"),
        level = DeprecationLevel.WARNING
    )
    abstract class InputCredentials : Object(), TdObject

    /**
     * Applies if a user chooses some previously saved payment credentials
     * To use their previously saved credentials, the user must have a valid temporary password
     *
     * @property savedCredentialsId Identifier of the saved credentials
     */
    @Serializable
    @SerialName("inputCredentialsSaved")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentialsSaved"),
        level = DeprecationLevel.WARNING
    )
    data class InputCredentialsSaved(
        @SerialName("saved_credentials_id")
        val savedCredentialsId: String
    ) : InputCredentials()

    /**
     * Applies if a user enters new credentials on a payment provider website
     *
     * @property data Contains JSON-encoded data with a credential identifier from the payment provider
     * @property allowSave True, if the credential identifier can be saved on the server side
     */
    @Serializable
    @SerialName("inputCredentialsNew")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentialsNew"),
        level = DeprecationLevel.WARNING
    )
    data class InputCredentialsNew(
        @SerialName("data")
        val data: String,
        @SerialName("allow_save")
        val allowSave: Boolean
    ) : InputCredentials()

    /**
     * Applies if a user enters new credentials using Android Pay
     *
     * @property data JSON-encoded data with the credential identifier
     */
    @Serializable
    @SerialName("inputCredentialsAndroidPay")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentialsAndroidPay"),
        level = DeprecationLevel.WARNING
    )
    data class InputCredentialsAndroidPay(
        @SerialName("data")
        val data: String
    ) : InputCredentials()

    /**
     * Applies if a user enters new credentials using Apple Pay
     *
     * @property data JSON-encoded data with the credential identifier
     */
    @Serializable
    @SerialName("inputCredentialsApplePay")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentialsApplePay"),
        level = DeprecationLevel.WARNING
    )
    data class InputCredentialsApplePay(
        @SerialName("data")
        val data: String
    ) : InputCredentials()

    /**
     * Stripe payment provider
     *
     * @property publishableKey Stripe API publishable key
     * @property needCountry True, if the user country must be provided
     * @property needPostalCode True, if the user ZIP/postal code must be provided
     * @property needCardholderName True, if the cardholder name must be provided
     */
    @Serializable
    @SerialName("paymentsProviderStripe")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentsProviderStripe"),
        level = DeprecationLevel.WARNING
    )
    data class PaymentsProviderStripe(
        @SerialName("publishable_key")
        val publishableKey: String,
        @SerialName("need_country")
        val needCountry: Boolean,
        @SerialName("need_postal_code")
        val needPostalCode: Boolean,
        @SerialName("need_cardholder_name")
        val needCardholderName: Boolean
    ) : Object(), TdObject

    /**
     * Contains information about an invoice payment form
     *
     * @property invoice Full information of the invoice
     * @property url Payment form URL
     * @property paymentsProvider Contains information about the payment provider, if available, to support it natively without the need for opening the URL
     * @property savedOrderInfo Saved server-side order information
     * @property savedCredentials Contains information about saved card credentials
     * @property canSaveCredentials True, if the user can choose to save credentials
     * @property needPassword True, if the user will be able to save credentials protected by a password they set up
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("paymentForm")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentForm"),
        level = DeprecationLevel.WARNING
    )
    data class PaymentForm(
        @SerialName("invoice")
        val invoice: Invoice,
        @SerialName("url")
        val url: String,
        @SerialName("payments_provider")
        val paymentsProvider: PaymentsProviderStripe?,
        @SerialName("saved_order_info")
        val savedOrderInfo: OrderInfo?,
        @SerialName("saved_credentials")
        val savedCredentials: SavedCredentials?,
        @SerialName("can_save_credentials")
        val canSaveCredentials: Boolean,
        @SerialName("need_password")
        val needPassword: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a temporary identifier of validated order information, which is stored for one hour
     * Also contains the available shipping options
     *
     * @property orderInfoId Temporary identifier of the order information
     * @property shippingOptions Available shipping options
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("validatedOrderInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdValidatedOrderInfo"),
        level = DeprecationLevel.WARNING
    )
    data class ValidatedOrderInfo(
        @SerialName("order_info_id")
        val orderInfoId: String,
        @SerialName("shipping_options")
        val shippingOptions: Array<ShippingOption>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains the result of a payment request
     *
     * @property success True, if the payment request was successful
     *                   Otherwise the verification_url will be not empty
     * @property verificationUrl URL for additional payment credentials verification
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("paymentResult")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentResult"),
        level = DeprecationLevel.WARNING
    )
    data class PaymentResult(
        @SerialName("success")
        val success: Boolean,
        @SerialName("verification_url")
        val verificationUrl: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about a successful payment
     *
     * @property date Point in time (Unix timestamp) when the payment was made
     * @property paymentsProviderUserId User identifier of the payment provider bot
     * @property invoice Contains information about the invoice
     * @property orderInfo Contains order information
     * @property shippingOption Chosen shipping option
     * @property credentialsTitle Title of the saved credentials
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("paymentReceipt")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentReceipt"),
        level = DeprecationLevel.WARNING
    )
    data class PaymentReceipt(
        @SerialName("date")
        val date: Int,
        @SerialName("payments_provider_user_id")
        val paymentsProviderUserId: Int,
        @SerialName("invoice")
        val invoice: Invoice,
        @SerialName("order_info")
        val orderInfo: OrderInfo?,
        @SerialName("shipping_option")
        val shippingOption: ShippingOption?,
        @SerialName("credentials_title")
        val credentialsTitle: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * File with the date it was uploaded
     *
     * @property file The file
     * @property date Point in time (Unix timestamp) when the file was uploaded
     */
    @Serializable
    @SerialName("datedFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDatedFile"),
        level = DeprecationLevel.WARNING
    )
    data class DatedFile(
        @SerialName("file")
        val file: File,
        @SerialName("date")
        val date: Int
    ) : Object(), TdObject

    /**
     * Contains the type of a Telegram Passport element
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType"),
        level = DeprecationLevel.WARNING
    )
    abstract class PassportElementType : Object(), TdObject

    /**
     * A Telegram Passport element containing the user's personal details
     */
    @Serializable
    @SerialName("passportElementTypePersonalDetails")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypePersonalDetails"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypePersonalDetails : PassportElementType()

    /**
     * A Telegram Passport element containing the user's passport
     */
    @Serializable
    @SerialName("passportElementTypePassport")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypePassport"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypePassport : PassportElementType()

    /**
     * A Telegram Passport element containing the user's driver license
     */
    @Serializable
    @SerialName("passportElementTypeDriverLicense")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeDriverLicense"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeDriverLicense : PassportElementType()

    /**
     * A Telegram Passport element containing the user's identity card
     */
    @Serializable
    @SerialName("passportElementTypeIdentityCard")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeIdentityCard"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeIdentityCard : PassportElementType()

    /**
     * A Telegram Passport element containing the user's internal passport
     */
    @Serializable
    @SerialName("passportElementTypeInternalPassport")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeInternalPassport"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeInternalPassport : PassportElementType()

    /**
     * A Telegram Passport element containing the user's address
     */
    @Serializable
    @SerialName("passportElementTypeAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeAddress"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeAddress : PassportElementType()

    /**
     * A Telegram Passport element containing the user's utility bill
     */
    @Serializable
    @SerialName("passportElementTypeUtilityBill")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeUtilityBill"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeUtilityBill : PassportElementType()

    /**
     * A Telegram Passport element containing the user's bank statement
     */
    @Serializable
    @SerialName("passportElementTypeBankStatement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeBankStatement"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeBankStatement : PassportElementType()

    /**
     * A Telegram Passport element containing the user's rental agreement
     */
    @Serializable
    @SerialName("passportElementTypeRentalAgreement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeRentalAgreement"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeRentalAgreement : PassportElementType()

    /**
     * A Telegram Passport element containing the registration page of the user's passport
     */
    @Serializable
    @SerialName("passportElementTypePassportRegistration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypePassportRegistration"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypePassportRegistration : PassportElementType()

    /**
     * A Telegram Passport element containing the user's temporary registration
     */
    @Serializable
    @SerialName("passportElementTypeTemporaryRegistration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeTemporaryRegistration"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeTemporaryRegistration : PassportElementType()

    /**
     * A Telegram Passport element containing the user's phone number
     */
    @Serializable
    @SerialName("passportElementTypePhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypePhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypePhoneNumber : PassportElementType()

    /**
     * A Telegram Passport element containing the user's email address
     */
    @Serializable
    @SerialName("passportElementTypeEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTypeEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementTypeEmailAddress : PassportElementType()

    /**
     * Represents a date according to the Gregorian calendar
     *
     * @property day Day of the month, 1-31
     * @property month Month, 1-12
     * @property year Year, 1-9999
     */
    @Serializable
    @SerialName("date")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDate"),
        level = DeprecationLevel.WARNING
    )
    data class Date(
        @SerialName("day")
        val day: Int,
        @SerialName("month")
        val month: Int,
        @SerialName("year")
        val year: Int
    ) : Object(), TdObject

    /**
     * Contains the user's personal details
     *
     * @property firstName First name of the user written in English
     * @property middleName Middle name of the user written in English
     * @property lastName Last name of the user written in English
     * @property nativeFirstName Native first name of the user
     * @property nativeMiddleName Native middle name of the user
     * @property nativeLastName Native last name of the user
     * @property birthdate Birthdate of the user
     * @property gender Gender of the user, "male" or "female"
     * @property countryCode A two-letter ISO 3166-1 alpha-2 country code of the user's country
     * @property residenceCountryCode A two-letter ISO 3166-1 alpha-2 country code of the user's residence country
     */
    @Serializable
    @SerialName("personalDetails")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPersonalDetails"),
        level = DeprecationLevel.WARNING
    )
    data class PersonalDetails(
        @SerialName("first_name")
        val firstName: String,
        @SerialName("middle_name")
        val middleName: String,
        @SerialName("last_name")
        val lastName: String,
        @SerialName("native_first_name")
        val nativeFirstName: String,
        @SerialName("native_middle_name")
        val nativeMiddleName: String,
        @SerialName("native_last_name")
        val nativeLastName: String,
        @SerialName("birthdate")
        val birthdate: Date,
        @SerialName("gender")
        val gender: String,
        @SerialName("country_code")
        val countryCode: String,
        @SerialName("residence_country_code")
        val residenceCountryCode: String
    ) : Object(), TdObject

    /**
     * An identity document
     *
     * @property number Document number
     * @property expiryDate Document expiry date
     * @property frontSide Front side of the document
     * @property reverseSide Reverse side of the document
     *                       Only for driver license and identity card
     * @property selfie Selfie with the document
     * @property translation List of files containing a certified English translation of the document
     */
    @Serializable
    @SerialName("identityDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdIdentityDocument"),
        level = DeprecationLevel.WARNING
    )
    data class IdentityDocument(
        @SerialName("number")
        val number: String,
        @SerialName("expiry_date")
        val expiryDate: Date?,
        @SerialName("front_side")
        val frontSide: DatedFile,
        @SerialName("reverse_side")
        val reverseSide: DatedFile,
        @SerialName("selfie")
        val selfie: DatedFile?,
        @SerialName("translation")
        val translation: Array<DatedFile>
    ) : Object(), TdObject

    /**
     * An identity document to be saved to Telegram Passport
     *
     * @property number Document number
     * @property expiryDate Document expiry date, if available
     * @property frontSide Front side of the document
     * @property reverseSide Reverse side of the document
     *                       Only for driver license and identity card
     * @property selfie Selfie with the document, if available
     * @property translation List of files containing a certified English translation of the document
     */
    @Serializable
    @SerialName("inputIdentityDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputIdentityDocument"),
        level = DeprecationLevel.WARNING
    )
    data class InputIdentityDocument(
        @SerialName("number")
        val number: String,
        @SerialName("expiry_date")
        val expiryDate: Date,
        @SerialName("front_side")
        val frontSide: InputFile,
        @SerialName("reverse_side")
        val reverseSide: InputFile,
        @SerialName("selfie")
        val selfie: InputFile,
        @SerialName("translation")
        val translation: Array<InputFile>
    ) : Object(), TdObject

    /**
     * A personal document, containing some information about a user
     *
     * @property files List of files containing the pages of the document
     * @property translation List of files containing a certified English translation of the document
     */
    @Serializable
    @SerialName("personalDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPersonalDocument"),
        level = DeprecationLevel.WARNING
    )
    data class PersonalDocument(
        @SerialName("files")
        val files: Array<DatedFile>,
        @SerialName("translation")
        val translation: Array<DatedFile>
    ) : Object(), TdObject

    /**
     * A personal document to be saved to Telegram Passport
     *
     * @property files List of files containing the pages of the document
     * @property translation List of files containing a certified English translation of the document
     */
    @Serializable
    @SerialName("inputPersonalDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPersonalDocument"),
        level = DeprecationLevel.WARNING
    )
    data class InputPersonalDocument(
        @SerialName("files")
        val files: Array<InputFile>,
        @SerialName("translation")
        val translation: Array<InputFile>
    ) : Object(), TdObject

    /**
     * Contains information about a Telegram Passport element
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement"),
        level = DeprecationLevel.WARNING
    )
    abstract class PassportElement : Object(), TdResponse

    /**
     * A Telegram Passport element containing the user's personal details
     *
     * @property personalDetails Personal details of the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPersonalDetails")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementPersonalDetails"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementPersonalDetails(
        @SerialName("personal_details")
        val personalDetails: PersonalDetails,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's passport
     *
     * @property passport Passport
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPassport")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementPassport"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementPassport(
        @SerialName("passport")
        val passport: IdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's driver license
     *
     * @property driverLicense Driver license
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementDriverLicense")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementDriverLicense"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementDriverLicense(
        @SerialName("driver_license")
        val driverLicense: IdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's identity card
     *
     * @property identityCard Identity card
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementIdentityCard")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementIdentityCard"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementIdentityCard(
        @SerialName("identity_card")
        val identityCard: IdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's internal passport
     *
     * @property internalPassport Internal passport
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementInternalPassport")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementInternalPassport"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementInternalPassport(
        @SerialName("internal_passport")
        val internalPassport: IdentityDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's address
     *
     * @property address Address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementAddress"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementAddress(
        @SerialName("address")
        val address: Address,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's utility bill
     *
     * @property utilityBill Utility bill
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementUtilityBill")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementUtilityBill"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementUtilityBill(
        @SerialName("utility_bill")
        val utilityBill: PersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's bank statement
     *
     * @property bankStatement Bank statement
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementBankStatement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementBankStatement"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementBankStatement(
        @SerialName("bank_statement")
        val bankStatement: PersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's rental agreement
     *
     * @property rentalAgreement Rental agreement
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementRentalAgreement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementRentalAgreement"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementRentalAgreement(
        @SerialName("rental_agreement")
        val rentalAgreement: PersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's passport registration pages
     *
     * @property passportRegistration Passport registration pages
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPassportRegistration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementPassportRegistration"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementPassportRegistration(
        @SerialName("passport_registration")
        val passportRegistration: PersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's temporary registration
     *
     * @property temporaryRegistration Temporary registration
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementTemporaryRegistration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementTemporaryRegistration"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementTemporaryRegistration(
        @SerialName("temporary_registration")
        val temporaryRegistration: PersonalDocument,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's phone number
     *
     * @property phoneNumber Phone number
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementPhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementPhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementPhoneNumber(
        @SerialName("phone_number")
        val phoneNumber: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's email address
     *
     * @property emailAddress Email address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementEmailAddress(
        @SerialName("email_address")
        val emailAddress: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : PassportElement()

    /**
     * Contains information about a Telegram Passport element to be saved
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement"),
        level = DeprecationLevel.WARNING
    )
    abstract class InputPassportElement : Object(), TdObject

    /**
     * A Telegram Passport element to be saved containing the user's personal details
     *
     * @property personalDetails Personal details of the user
     */
    @Serializable
    @SerialName("inputPassportElementPersonalDetails")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementPersonalDetails"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementPersonalDetails(
        @SerialName("personal_details")
        val personalDetails: PersonalDetails
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's passport
     *
     * @property passport The passport to be saved
     */
    @Serializable
    @SerialName("inputPassportElementPassport")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementPassport"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementPassport(
        @SerialName("passport")
        val passport: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's driver license
     *
     * @property driverLicense The driver license to be saved
     */
    @Serializable
    @SerialName("inputPassportElementDriverLicense")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementDriverLicense"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementDriverLicense(
        @SerialName("driver_license")
        val driverLicense: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's identity card
     *
     * @property identityCard The identity card to be saved
     */
    @Serializable
    @SerialName("inputPassportElementIdentityCard")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementIdentityCard"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementIdentityCard(
        @SerialName("identity_card")
        val identityCard: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's internal passport
     *
     * @property internalPassport The internal passport to be saved
     */
    @Serializable
    @SerialName("inputPassportElementInternalPassport")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementInternalPassport"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementInternalPassport(
        @SerialName("internal_passport")
        val internalPassport: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's address
     *
     * @property address The address to be saved
     */
    @Serializable
    @SerialName("inputPassportElementAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementAddress"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementAddress(
        @SerialName("address")
        val address: Address
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's utility bill
     *
     * @property utilityBill The utility bill to be saved
     */
    @Serializable
    @SerialName("inputPassportElementUtilityBill")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementUtilityBill"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementUtilityBill(
        @SerialName("utility_bill")
        val utilityBill: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's bank statement
     *
     * @property bankStatement The bank statement to be saved
     */
    @Serializable
    @SerialName("inputPassportElementBankStatement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementBankStatement"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementBankStatement(
        @SerialName("bank_statement")
        val bankStatement: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's rental agreement
     *
     * @property rentalAgreement The rental agreement to be saved
     */
    @Serializable
    @SerialName("inputPassportElementRentalAgreement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementRentalAgreement"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementRentalAgreement(
        @SerialName("rental_agreement")
        val rentalAgreement: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's passport registration
     *
     * @property passportRegistration The passport registration page to be saved
     */
    @Serializable
    @SerialName("inputPassportElementPassportRegistration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementPassportRegistration"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementPassportRegistration(
        @SerialName("passport_registration")
        val passportRegistration: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's temporary registration
     *
     * @property temporaryRegistration The temporary registration document to be saved
     */
    @Serializable
    @SerialName("inputPassportElementTemporaryRegistration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementTemporaryRegistration"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementTemporaryRegistration(
        @SerialName("temporary_registration")
        val temporaryRegistration: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's phone number
     *
     * @property phoneNumber The phone number to be saved
     */
    @Serializable
    @SerialName("inputPassportElementPhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementPhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementPhoneNumber(
        @SerialName("phone_number")
        val phoneNumber: String
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's email address
     *
     * @property emailAddress The email address to be saved
     */
    @Serializable
    @SerialName("inputPassportElementEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementEmailAddress(
        @SerialName("email_address")
        val emailAddress: String
    ) : InputPassportElement()

    /**
     * Contains information about saved Telegram Passport elements
     *
     * @property elements Telegram Passport elements
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElements")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElements"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElements(
        @SerialName("elements")
        val elements: Array<PassportElement>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains the description of an error in a Telegram Passport element
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource"),
        level = DeprecationLevel.WARNING
    )
    abstract class PassportElementErrorSource : Object(), TdObject

    /**
     * The element contains an error in an unspecified place
     * The error will be considered resolved when new data is added
     */
    @Serializable
    @SerialName("passportElementErrorSourceUnspecified")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceUnspecified"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementErrorSourceUnspecified : PassportElementErrorSource()

    /**
     * One of the data fields contains an error
     * The error will be considered resolved when the value of the field changes
     *
     * @property fieldName Field name
     */
    @Serializable
    @SerialName("passportElementErrorSourceDataField")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceDataField"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementErrorSourceDataField(
        @SerialName("field_name")
        val fieldName: String
    ) : PassportElementErrorSource()

    /**
     * The front side of the document contains an error
     * The error will be considered resolved when the file with the front side changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceFrontSide")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceFrontSide"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementErrorSourceFrontSide : PassportElementErrorSource()

    /**
     * The reverse side of the document contains an error
     * The error will be considered resolved when the file with the reverse side changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceReverseSide")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceReverseSide"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementErrorSourceReverseSide : PassportElementErrorSource()

    /**
     * The selfie with the document contains an error
     * The error will be considered resolved when the file with the selfie changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceSelfie")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceSelfie"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementErrorSourceSelfie : PassportElementErrorSource()

    /**
     * One of files with the translation of the document contains an error
     * The error will be considered resolved when the file changes
     *
     * @property fileIndex Index of a file with the error
     */
    @Serializable
    @SerialName("passportElementErrorSourceTranslationFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceTranslationFile"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementErrorSourceTranslationFile(
        @SerialName("file_index")
        val fileIndex: Int
    ) : PassportElementErrorSource()

    /**
     * The translation of the document contains an error
     * The error will be considered resolved when the list of translation files changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceTranslationFiles")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceTranslationFiles"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementErrorSourceTranslationFiles : PassportElementErrorSource()

    /**
     * The file contains an error
     * The error will be considered resolved when the file changes
     *
     * @property fileIndex Index of a file with the error
     */
    @Serializable
    @SerialName("passportElementErrorSourceFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceFile"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementErrorSourceFile(
        @SerialName("file_index")
        val fileIndex: Int
    ) : PassportElementErrorSource()

    /**
     * The list of attached files contains an error
     * The error will be considered resolved when the list of files changes
     */
    @Serializable
    @SerialName("passportElementErrorSourceFiles")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSourceFiles"),
        level = DeprecationLevel.WARNING
    )
    object PassportElementErrorSourceFiles : PassportElementErrorSource()

    /**
     * Contains the description of an error in a Telegram Passport element
     *
     * @property type Type of the Telegram Passport element which has the error
     * @property message Error message
     * @property source Error source
     */
    @Serializable
    @SerialName("passportElementError")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementError"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementError(
        @SerialName("type")
        val type: PassportElementType,
        @SerialName("message")
        val message: String,
        @SerialName("source")
        val source: PassportElementErrorSource
    ) : Object(), TdObject

    /**
     * Contains information about a Telegram Passport element that was requested by a service
     *
     * @property type Type of the element
     * @property isSelfieRequired True, if a selfie is required with the identity document
     * @property isTranslationRequired True, if a certified English translation is required with the document
     * @property isNativeNameRequired True, if personal details must include the user's name in the language of their country of residence
     */
    @Serializable
    @SerialName("passportSuitableElement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportSuitableElement"),
        level = DeprecationLevel.WARNING
    )
    data class PassportSuitableElement(
        @SerialName("type")
        val type: PassportElementType,
        @SerialName("is_selfie_required")
        val isSelfieRequired: Boolean,
        @SerialName("is_translation_required")
        val isTranslationRequired: Boolean,
        @SerialName("is_native_name_required")
        val isNativeNameRequired: Boolean
    ) : Object(), TdObject

    /**
     * Contains a description of the required Telegram Passport element that was requested by a service
     *
     * @property suitableElements List of Telegram Passport elements any of which is enough to provide
     */
    @Serializable
    @SerialName("passportRequiredElement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportRequiredElement"),
        level = DeprecationLevel.WARNING
    )
    data class PassportRequiredElement(
        @SerialName("suitable_elements")
        val suitableElements: Array<PassportSuitableElement>
    ) : Object(), TdObject

    /**
     * Contains information about a Telegram Passport authorization form that was requested
     *
     * @property id Unique identifier of the authorization form
     * @property requiredElements Information about the Telegram Passport elements that need to be provided to complete the form
     * @property privacyPolicyUrl URL for the privacy policy of the service
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportAuthorizationForm")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportAuthorizationForm"),
        level = DeprecationLevel.WARNING
    )
    data class PassportAuthorizationForm(
        @SerialName("id")
        val id: Int,
        @SerialName("required_elements")
        val requiredElements: Array<PassportRequiredElement>,
        @SerialName("privacy_policy_url")
        val privacyPolicyUrl: String?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about a Telegram Passport elements and corresponding errors
     *
     * @property elements Telegram Passport elements
     * @property errors Errors in the elements that are already available
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("passportElementsWithErrors")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementsWithErrors"),
        level = DeprecationLevel.WARNING
    )
    data class PassportElementsWithErrors(
        @SerialName("elements")
        val elements: Array<PassportElement>,
        @SerialName("errors")
        val errors: Array<PassportElementError>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains encrypted Telegram Passport data credentials
     *
     * @property data The encrypted credentials
     * @property hash The decrypted data hash
     * @property secret Secret for data decryption, encrypted with the service's public key
     */
    @Serializable
    @SerialName("encryptedCredentials")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEncryptedCredentials"),
        level = DeprecationLevel.WARNING
    )
    data class EncryptedCredentials(
        @SerialName("data")
        val data: ByteArray,
        @SerialName("hash")
        val hash: ByteArray,
        @SerialName("secret")
        val secret: ByteArray
    ) : Object(), TdObject

    /**
     * Contains information about an encrypted Telegram Passport element
     *
     * @property type Type of Telegram Passport element
     * @property data Encrypted JSON-encoded data about the user
     * @property frontSide The front side of an identity document
     * @property reverseSide The reverse side of an identity document
     * @property selfie Selfie with the document
     * @property translation List of files containing a certified English translation of the document
     * @property files List of attached files
     * @property value Unencrypted data, phone number or email address
     * @property hash Hash of the entire element
     */
    @Serializable
    @SerialName("encryptedPassportElement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEncryptedPassportElement"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class EncryptedPassportElement(
        @SerialName("type")
        val type: PassportElementType,
        @SerialName("data")
        val data: ByteArray,
        @SerialName("front_side")
        val frontSide: DatedFile,
        @SerialName("reverse_side")
        val reverseSide: DatedFile?,
        @SerialName("selfie")
        val selfie: DatedFile?,
        @SerialName("translation")
        val translation: Array<DatedFile>,
        @SerialName("files")
        val files: Array<DatedFile>,
        @SerialName("value")
        val value: String,
        @SerialName("hash")
        val hash: String
    ) : Object(), TdObject

    /**
     * Contains the description of an error in a Telegram Passport element
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource"),
        level = DeprecationLevel.WARNING
    )
    abstract class InputPassportElementErrorSource : Object(), TdObject

    /**
     * The element contains an error in an unspecified place
     * The error will be considered resolved when new data is added
     *
     * @property elementHash Current hash of the entire element
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceUnspecified")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceUnspecified"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceUnspecified(
        @SerialName("element_hash")
        val elementHash: ByteArray
    ) : InputPassportElementErrorSource()

    /**
     * A data field contains an error
     * The error is considered resolved when the field's value changes
     *
     * @property fieldName Field name
     * @property dataHash Current data hash
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceDataField")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceDataField"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceDataField(
        @SerialName("field_name")
        val fieldName: String,
        @SerialName("data_hash")
        val dataHash: ByteArray
    ) : InputPassportElementErrorSource()

    /**
     * The front side of the document contains an error
     * The error is considered resolved when the file with the front side of the document changes
     *
     * @property fileHash Current hash of the file containing the front side
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceFrontSide")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceFrontSide"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceFrontSide(
        @SerialName("file_hash")
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    /**
     * The reverse side of the document contains an error
     * The error is considered resolved when the file with the reverse side of the document changes
     *
     * @property fileHash Current hash of the file containing the reverse side
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceReverseSide")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceReverseSide"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceReverseSide(
        @SerialName("file_hash")
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    /**
     * The selfie contains an error
     * The error is considered resolved when the file with the selfie changes
     *
     * @property fileHash Current hash of the file containing the selfie
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceSelfie")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceSelfie"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceSelfie(
        @SerialName("file_hash")
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    /**
     * One of the files containing the translation of the document contains an error
     * The error is considered resolved when the file with the translation changes
     *
     * @property fileHash Current hash of the file containing the translation
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceTranslationFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceTranslationFile"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceTranslationFile(
        @SerialName("file_hash")
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    /**
     * The translation of the document contains an error
     * The error is considered resolved when the list of files changes
     *
     * @property fileHashes Current hashes of all files with the translation
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceTranslationFiles")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceTranslationFiles"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceTranslationFiles(
        @SerialName("file_hashes")
        val fileHashes: Array<ByteArray>
    ) : InputPassportElementErrorSource()

    /**
     * The file contains an error
     * The error is considered resolved when the file changes
     *
     * @property fileHash Current hash of the file which has the error
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceFile"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceFile(
        @SerialName("file_hash")
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    /**
     * The list of attached files contains an error
     * The error is considered resolved when the file list changes
     *
     * @property fileHashes Current hashes of all attached files
     */
    @Serializable
    @SerialName("inputPassportElementErrorSourceFiles")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSourceFiles"),
        level = DeprecationLevel.WARNING
    )
    data class InputPassportElementErrorSourceFiles(
        @SerialName("file_hashes")
        val fileHashes: Array<ByteArray>
    ) : InputPassportElementErrorSource()

    /**
     * Contains the description of an error in a Telegram Passport element
     *
     * @property type Type of Telegram Passport element that has the error
     * @property message Error message
     * @property source Error source
     */
    @Serializable
    @SerialName("inputPassportElementError")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementError"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class InputPassportElementError(
        @SerialName("type")
        val type: PassportElementType,
        @SerialName("message")
        val message: String,
        @SerialName("source")
        val source: InputPassportElementErrorSource
    ) : Object(), TdObject

    /**
     * Contains the content of a message
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent"),
        level = DeprecationLevel.WARNING
    )
    abstract class MessageContent : Object(), TdObject

    /**
     * A text message
     *
     * @property text Text of the message
     * @property webPage A preview of the web page that's mentioned in the text
     */
    @Serializable
    @SerialName("messageText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageText"),
        level = DeprecationLevel.WARNING
    )
    data class MessageText(
        @SerialName("text")
        val text: FormattedText,
        @SerialName("web_page")
        val webPage: WebPage?
    ) : MessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @property animation Message content
     * @property caption Animation caption
     * @property isSecret True, if the animation thumbnail must be blurred and the animation must be shown only while tapped
     */
    @Serializable
    @SerialName("messageAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class MessageAnimation(
        @SerialName("animation")
        val animation: Animation,
        @SerialName("caption")
        val caption: FormattedText,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * An audio message
     *
     * @property audio Message content
     * @property caption Audio caption
     */
    @Serializable
    @SerialName("messageAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageAudio"),
        level = DeprecationLevel.WARNING
    )
    data class MessageAudio(
        @SerialName("audio")
        val audio: Audio,
        @SerialName("caption")
        val caption: FormattedText
    ) : MessageContent()

    /**
     * A document message (general file)
     *
     * @property document Message content
     * @property caption Document caption
     */
    @Serializable
    @SerialName("messageDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageDocument"),
        level = DeprecationLevel.WARNING
    )
    data class MessageDocument(
        @SerialName("document")
        val document: Document,
        @SerialName("caption")
        val caption: FormattedText
    ) : MessageContent()

    /**
     * A photo message
     *
     * @property photo Message content
     * @property caption Photo caption
     * @property isSecret True, if the photo must be blurred and must be shown only while tapped
     */
    @Serializable
    @SerialName("messagePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessagePhoto"),
        level = DeprecationLevel.WARNING
    )
    data class MessagePhoto(
        @SerialName("photo")
        val photo: Photo,
        @SerialName("caption")
        val caption: FormattedText,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * An expired photo message (self-destructed after TTL has elapsed)
     */
    @Serializable
    @SerialName("messageExpiredPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageExpiredPhoto"),
        level = DeprecationLevel.WARNING
    )
    object MessageExpiredPhoto : MessageContent()

    /**
     * A sticker message
     *
     * @property sticker Message content
     */
    @Serializable
    @SerialName("messageSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSticker"),
        level = DeprecationLevel.WARNING
    )
    data class MessageSticker(
        @SerialName("sticker")
        val sticker: Sticker
    ) : MessageContent()

    /**
     * A video message
     *
     * @property video Message content
     * @property caption Video caption
     * @property isSecret True, if the video thumbnail must be blurred and the video must be shown only while tapped
     */
    @Serializable
    @SerialName("messageVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageVideo"),
        level = DeprecationLevel.WARNING
    )
    data class MessageVideo(
        @SerialName("video")
        val video: Video,
        @SerialName("caption")
        val caption: FormattedText,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * An expired video message (self-destructed after TTL has elapsed)
     */
    @Serializable
    @SerialName("messageExpiredVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageExpiredVideo"),
        level = DeprecationLevel.WARNING
    )
    object MessageExpiredVideo : MessageContent()

    /**
     * A video note message
     *
     * @property videoNote Message content
     * @property isViewed True, if at least one of the recipients has viewed the video note
     * @property isSecret True, if the video note thumbnail must be blurred and the video note must be shown only while tapped
     */
    @Serializable
    @SerialName("messageVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageVideoNote"),
        level = DeprecationLevel.WARNING
    )
    data class MessageVideoNote(
        @SerialName("video_note")
        val videoNote: VideoNote,
        @SerialName("is_viewed")
        val isViewed: Boolean,
        @SerialName("is_secret")
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * A voice note message
     *
     * @property voiceNote Message content
     * @property caption Voice note caption
     * @property isListened True, if at least one of the recipients has listened to the voice note
     */
    @Serializable
    @SerialName("messageVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    data class MessageVoiceNote(
        @SerialName("voice_note")
        val voiceNote: VoiceNote,
        @SerialName("caption")
        val caption: FormattedText,
        @SerialName("is_listened")
        val isListened: Boolean
    ) : MessageContent()

    /**
     * A message with a location
     *
     * @property location Message content
     * @property livePeriod Time relative to the message sent date until which the location can be updated, in seconds
     * @property expiresIn Left time for which the location can be updated, in seconds
     *                     UpdateMessageContent is not sent when this field changes
     */
    @Serializable
    @SerialName("messageLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageLocation"),
        level = DeprecationLevel.WARNING
    )
    data class MessageLocation(
        @SerialName("location")
        val location: Location,
        @SerialName("live_period")
        val livePeriod: Int,
        @SerialName("expires_in")
        val expiresIn: Int
    ) : MessageContent()

    /**
     * A message with information about a venue
     *
     * @property venue Message content
     */
    @Serializable
    @SerialName("messageVenue")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageVenue"),
        level = DeprecationLevel.WARNING
    )
    data class MessageVenue(
        @SerialName("venue")
        val venue: Venue
    ) : MessageContent()

    /**
     * A message with a user contact
     *
     * @property contact Message content
     */
    @Serializable
    @SerialName("messageContact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContact"),
        level = DeprecationLevel.WARNING
    )
    data class MessageContact(
        @SerialName("contact")
        val contact: Contact
    ) : MessageContent()

    /**
     * A message with a game
     *
     * @property game Game
     */
    @Serializable
    @SerialName("messageGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageGame"),
        level = DeprecationLevel.WARNING
    )
    data class MessageGame(
        @SerialName("game")
        val game: Game
    ) : MessageContent()

    /**
     * A message with a poll
     *
     * @property poll Poll
     */
    @Serializable
    @SerialName("messagePoll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessagePoll"),
        level = DeprecationLevel.WARNING
    )
    data class MessagePoll(
        @SerialName("poll")
        val poll: Poll
    ) : MessageContent()

    /**
     * A message with an invoice from a bot
     *
     * @property title Product title
     * @property description Product description
     * @property photo Product photo
     * @property currency Currency for the product price
     * @property totalAmount Product total price in the minimal quantity of the currency
     * @property startParameter Unique invoice bot start_parameter
     *                          To share an invoice use the URL https://t.me/{bot_username}?start={start_parameter}
     * @property isTest True, if the invoice is a test invoice
     * @property needShippingAddress True, if the shipping address should be specified
     * @property receiptMessageId The identifier of the message with the receipt, after the product has been purchased
     */
    @Serializable
    @SerialName("messageInvoice")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageInvoice"),
        level = DeprecationLevel.WARNING
    )
    data class MessageInvoice(
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("photo")
        val photo: Photo?,
        @SerialName("currency")
        val currency: String,
        @SerialName("total_amount")
        val totalAmount: Long,
        @SerialName("start_parameter")
        val startParameter: String,
        @SerialName("is_test")
        val isTest: Boolean,
        @SerialName("need_shipping_address")
        val needShippingAddress: Boolean,
        @SerialName("receipt_message_id")
        val receiptMessageId: Long
    ) : MessageContent()

    /**
     * A message with information about an ended call
     *
     * @property discardReason Reason why the call was discarded
     * @property duration Call duration, in seconds
     */
    @Serializable
    @SerialName("messageCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageCall"),
        level = DeprecationLevel.WARNING
    )
    data class MessageCall(
        @SerialName("discard_reason")
        val discardReason: CallDiscardReason,
        @SerialName("duration")
        val duration: Int
    ) : MessageContent()

    /**
     * A newly created basic group
     *
     * @property title Title of the basic group
     * @property memberUserIds User identifiers of members in the basic group
     */
    @Serializable
    @SerialName("messageBasicGroupChatCreate")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageBasicGroupChatCreate"),
        level = DeprecationLevel.WARNING
    )
    data class MessageBasicGroupChatCreate(
        @SerialName("title")
        val title: String,
        @SerialName("member_user_ids")
        val memberUserIds: IntArray
    ) : MessageContent()

    /**
     * A newly created supergroup or channel
     *
     * @property title Title of the supergroup or channel
     */
    @Serializable
    @SerialName("messageSupergroupChatCreate")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSupergroupChatCreate"),
        level = DeprecationLevel.WARNING
    )
    data class MessageSupergroupChatCreate(
        @SerialName("title")
        val title: String
    ) : MessageContent()

    /**
     * An updated chat title
     *
     * @property title New chat title
     */
    @Serializable
    @SerialName("messageChatChangeTitle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatChangeTitle"),
        level = DeprecationLevel.WARNING
    )
    data class MessageChatChangeTitle(
        @SerialName("title")
        val title: String
    ) : MessageContent()

    /**
     * An updated chat photo
     *
     * @property photo New chat photo
     */
    @Serializable
    @SerialName("messageChatChangePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatChangePhoto"),
        level = DeprecationLevel.WARNING
    )
    data class MessageChatChangePhoto(
        @SerialName("photo")
        val photo: Photo
    ) : MessageContent()

    /**
     * A deleted chat photo
     */
    @Serializable
    @SerialName("messageChatDeletePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatDeletePhoto"),
        level = DeprecationLevel.WARNING
    )
    object MessageChatDeletePhoto : MessageContent()

    /**
     * New chat members were added
     *
     * @property memberUserIds User identifiers of the new members
     */
    @Serializable
    @SerialName("messageChatAddMembers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatAddMembers"),
        level = DeprecationLevel.WARNING
    )
    data class MessageChatAddMembers(
        @SerialName("member_user_ids")
        val memberUserIds: IntArray
    ) : MessageContent()

    /**
     * A new member joined the chat by invite link
     */
    @Serializable
    @SerialName("messageChatJoinByLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatJoinByLink"),
        level = DeprecationLevel.WARNING
    )
    object MessageChatJoinByLink : MessageContent()

    /**
     * A chat member was deleted
     *
     * @property userId User identifier of the deleted chat member
     */
    @Serializable
    @SerialName("messageChatDeleteMember")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatDeleteMember"),
        level = DeprecationLevel.WARNING
    )
    data class MessageChatDeleteMember(
        @SerialName("user_id")
        val userId: Int
    ) : MessageContent()

    /**
     * A basic group was upgraded to a supergroup and was deactivated as the result
     *
     * @property supergroupId Identifier of the supergroup to which the basic group was upgraded
     */
    @Serializable
    @SerialName("messageChatUpgradeTo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatUpgradeTo"),
        level = DeprecationLevel.WARNING
    )
    data class MessageChatUpgradeTo(
        @SerialName("supergroup_id")
        val supergroupId: Int
    ) : MessageContent()

    /**
     * A supergroup has been created from a basic group
     *
     * @property title Title of the newly created supergroup
     * @property basicGroupId The identifier of the original basic group
     */
    @Serializable
    @SerialName("messageChatUpgradeFrom")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatUpgradeFrom"),
        level = DeprecationLevel.WARNING
    )
    data class MessageChatUpgradeFrom(
        @SerialName("title")
        val title: String,
        @SerialName("basic_group_id")
        val basicGroupId: Int
    ) : MessageContent()

    /**
     * A message has been pinned
     *
     * @property messageId Identifier of the pinned message, can be an identifier of a deleted message or 0
     */
    @Serializable
    @SerialName("messagePinMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessagePinMessage"),
        level = DeprecationLevel.WARNING
    )
    data class MessagePinMessage(
        @SerialName("message_id")
        val messageId: Long
    ) : MessageContent()

    /**
     * A screenshot of a message in the chat has been taken
     */
    @Serializable
    @SerialName("messageScreenshotTaken")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageScreenshotTaken"),
        level = DeprecationLevel.WARNING
    )
    object MessageScreenshotTaken : MessageContent()

    /**
     * The TTL (Time To Live) setting messages in a secret chat has been changed
     *
     * @property ttl New TTL
     */
    @Serializable
    @SerialName("messageChatSetTtl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageChatSetTtl"),
        level = DeprecationLevel.WARNING
    )
    data class MessageChatSetTtl(
        @SerialName("ttl")
        val ttl: Int
    ) : MessageContent()

    /**
     * A non-standard action has happened in the chat
     *
     * @property text Message text to be shown in the chat
     */
    @Serializable
    @SerialName("messageCustomServiceAction")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageCustomServiceAction"),
        level = DeprecationLevel.WARNING
    )
    data class MessageCustomServiceAction(
        @SerialName("text")
        val text: String
    ) : MessageContent()

    /**
     * A new high score was achieved in a game
     *
     * @property gameMessageId Identifier of the message with the game, can be an identifier of a deleted message
     * @property gameId Identifier of the game
     *                  May be different from the games presented in the message with the game
     * @property score New score
     */
    @Serializable
    @SerialName("messageGameScore")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageGameScore"),
        level = DeprecationLevel.WARNING
    )
    data class MessageGameScore(
        @SerialName("game_message_id")
        val gameMessageId: Long,
        @SerialName("game_id")
        val gameId: Long,
        @SerialName("score")
        val score: Int
    ) : MessageContent()

    /**
     * A payment has been completed
     *
     * @property invoiceMessageId Identifier of the message with the corresponding invoice
     *                            Can be an identifier of a deleted message
     * @property currency Currency for the price of the product
     * @property totalAmount Total price for the product, in the minimal quantity of the currency
     */
    @Serializable
    @SerialName("messagePaymentSuccessful")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessagePaymentSuccessful"),
        level = DeprecationLevel.WARNING
    )
    data class MessagePaymentSuccessful(
        @SerialName("invoice_message_id")
        val invoiceMessageId: Long,
        @SerialName("currency")
        val currency: String,
        @SerialName("total_amount")
        val totalAmount: Long
    ) : MessageContent()

    /**
     * A payment has been completed
     *
     * @property invoiceMessageId Identifier of the message with the corresponding invoice
     *                            Can be an identifier of a deleted message
     * @property currency Currency for price of the product
     * @property totalAmount Total price for the product, in the minimal quantity of the currency
     * @property invoicePayload Invoice payload
     * @property shippingOptionId Identifier of the shipping option chosen by the user
     *                            May be empty if not applicable
     * @property orderInfo Information about the order
     * @property telegramPaymentChargeId Telegram payment identifier
     * @property providerPaymentChargeId Provider payment identifier
     */
    @Serializable
    @SerialName("messagePaymentSuccessfulBot")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessagePaymentSuccessfulBot"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class MessagePaymentSuccessfulBot(
        @SerialName("invoice_message_id")
        val invoiceMessageId: Long,
        @SerialName("currency")
        val currency: String,
        @SerialName("total_amount")
        val totalAmount: Long,
        @SerialName("invoice_payload")
        val invoicePayload: ByteArray,
        @SerialName("shipping_option_id")
        val shippingOptionId: String?,
        @SerialName("order_info")
        val orderInfo: OrderInfo?,
        @SerialName("telegram_payment_charge_id")
        val telegramPaymentChargeId: String,
        @SerialName("provider_payment_charge_id")
        val providerPaymentChargeId: String
    ) : MessageContent()

    /**
     * A contact has registered with Telegram
     */
    @Serializable
    @SerialName("messageContactRegistered")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContactRegistered"),
        level = DeprecationLevel.WARNING
    )
    object MessageContactRegistered : MessageContent()

    /**
     * The current user has connected a website by logging in using Telegram Login Widget on it
     *
     * @property domainName Domain name of the connected website
     */
    @Serializable
    @SerialName("messageWebsiteConnected")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageWebsiteConnected"),
        level = DeprecationLevel.WARNING
    )
    data class MessageWebsiteConnected(
        @SerialName("domain_name")
        val domainName: String
    ) : MessageContent()

    /**
     * Telegram Passport data has been sent
     *
     * @property types List of Telegram Passport element types sent
     */
    @Serializable
    @SerialName("messagePassportDataSent")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessagePassportDataSent"),
        level = DeprecationLevel.WARNING
    )
    data class MessagePassportDataSent(
        @SerialName("types")
        val types: Array<PassportElementType>
    ) : MessageContent()

    /**
     * Telegram Passport data has been received
     *
     * @property elements List of received Telegram Passport elements
     * @property credentials Encrypted data credentials
     */
    @Serializable
    @SerialName("messagePassportDataReceived")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessagePassportDataReceived"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class MessagePassportDataReceived(
        @SerialName("elements")
        val elements: Array<EncryptedPassportElement>,
        @SerialName("credentials")
        val credentials: EncryptedCredentials
    ) : MessageContent()

    /**
     * Message content that is not supported by the client
     */
    @Serializable
    @SerialName("messageUnsupported")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageUnsupported"),
        level = DeprecationLevel.WARNING
    )
    object MessageUnsupported : MessageContent()

    /**
     * Represents a part of the text which must be formatted differently
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType"),
        level = DeprecationLevel.WARNING
    )
    abstract class TextEntityType : Object(), TdObject

    /**
     * A mention of a user by their username
     */
    @Serializable
    @SerialName("textEntityTypeMention")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeMention"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeMention : TextEntityType()

    /**
     * A hashtag text, beginning with "#"
     */
    @Serializable
    @SerialName("textEntityTypeHashtag")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeHashtag"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeHashtag : TextEntityType()

    /**
     * A cashtag text, beginning with "$" and consisting of capital english letters (i.e
     * "$USD")
     */
    @Serializable
    @SerialName("textEntityTypeCashtag")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeCashtag"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeCashtag : TextEntityType()

    /**
     * A bot command, beginning with "/"
     * This shouldn't be highlighted if there are no bots in the chat
     */
    @Serializable
    @SerialName("textEntityTypeBotCommand")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeBotCommand"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeBotCommand : TextEntityType()

    /**
     * An HTTP URL
     */
    @Serializable
    @SerialName("textEntityTypeUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeUrl"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeUrl : TextEntityType()

    /**
     * An email address
     */
    @Serializable
    @SerialName("textEntityTypeEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeEmailAddress : TextEntityType()

    /**
     * A bold text
     */
    @Serializable
    @SerialName("textEntityTypeBold")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeBold"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeBold : TextEntityType()

    /**
     * An italic text
     */
    @Serializable
    @SerialName("textEntityTypeItalic")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeItalic"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeItalic : TextEntityType()

    /**
     * Text that must be formatted as if inside a code HTML tag
     */
    @Serializable
    @SerialName("textEntityTypeCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeCode"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypeCode : TextEntityType()

    /**
     * Text that must be formatted as if inside a pre HTML tag
     */
    @Serializable
    @SerialName("textEntityTypePre")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypePre"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypePre : TextEntityType()

    /**
     * Text that must be formatted as if inside pre, and code HTML tags
     *
     * @property language Programming language of the code
     *                    As defined by the sender
     */
    @Serializable
    @SerialName("textEntityTypePreCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypePreCode"),
        level = DeprecationLevel.WARNING
    )
    data class TextEntityTypePreCode(
        @SerialName("language")
        val language: String
    ) : TextEntityType()

    /**
     * A text description shown instead of a raw URL
     *
     * @property url HTTP or tg:// URL to be opened when the link is clicked
     */
    @Serializable
    @SerialName("textEntityTypeTextUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeTextUrl"),
        level = DeprecationLevel.WARNING
    )
    data class TextEntityTypeTextUrl(
        @SerialName("url")
        val url: String
    ) : TextEntityType()

    /**
     * A text shows instead of a raw mention of the user (e.g., when the user has no username)
     *
     * @property userId Identifier of the mentioned user
     */
    @Serializable
    @SerialName("textEntityTypeMentionName")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypeMentionName"),
        level = DeprecationLevel.WARNING
    )
    data class TextEntityTypeMentionName(
        @SerialName("user_id")
        val userId: Int
    ) : TextEntityType()

    /**
     * A phone number
     */
    @Serializable
    @SerialName("textEntityTypePhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityTypePhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    object TextEntityTypePhoneNumber : TextEntityType()

    /**
     * A thumbnail to be sent along with a file
     * Should be in JPEG or WEBP format for stickers, and less than 200 kB in size
     *
     * @property thumbnail Thumbnail file to send
     *                     Sending thumbnails by file_id is currently not supported
     * @property width Thumbnail width, usually shouldn't exceed 320
     *                 Use 0 if unknown
     * @property height Thumbnail height, usually shouldn't exceed 320
     *                  Use 0 if unknown
     */
    @Serializable
    @SerialName("inputThumbnail")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputThumbnail"),
        level = DeprecationLevel.WARNING
    )
    data class InputThumbnail(
        @SerialName("thumbnail")
        val thumbnail: InputFile,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int
    ) : Object(), TdObject

    /**
     * The content of a message to send
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent"),
        level = DeprecationLevel.WARNING
    )
    abstract class InputMessageContent : Object(), TdObject

    /**
     * A text message
     *
     * @property text Formatted text to be sent
     *                1-GetOption("message_text_length_max") characters
     *                Only Bold, Italic, Code, Pre, PreCode and TextUrl entities are allowed to be specified manually
     * @property disableWebPagePreview True, if rich web page previews for URLs in the message text should be disabled
     * @property clearDraft True, if a chat message draft should be deleted
     */
    @Serializable
    @SerialName("inputMessageText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageText"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageText(
        @SerialName("text")
        val text: FormattedText,
        @SerialName("disable_web_page_preview")
        val disableWebPagePreview: Boolean,
        @SerialName("clear_draft")
        val clearDraft: Boolean
    ) : InputMessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @property animation Animation file to be sent
     * @property thumbnail Animation thumbnail, if available
     * @property duration Duration of the animation, in seconds
     * @property width Width of the animation
     *                 May be replaced by the server
     * @property height Height of the animation
     *                  May be replaced by the server
     * @property caption Animation caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageAnimation(
        @SerialName("animation")
        val animation: InputFile,
        @SerialName("thumbnail")
        val thumbnail: InputThumbnail,
        @SerialName("duration")
        val duration: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * An audio message
     *
     * @property audio Audio file to be sent
     * @property albumCoverThumbnail Thumbnail of the cover for the album, if available
     * @property duration Duration of the audio, in seconds
     *                    May be replaced by the server
     * @property title Title of the audio
     *                 May be replaced by the server
     * @property performer Performer of the audio
     * @property caption Audio caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageAudio"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageAudio(
        @SerialName("audio")
        val audio: InputFile,
        @SerialName("album_cover_thumbnail")
        val albumCoverThumbnail: InputThumbnail,
        @SerialName("duration")
        val duration: Int,
        @SerialName("title")
        val title: String,
        @SerialName("performer")
        val performer: String,
        @SerialName("caption")
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * A document message (general file)
     *
     * @property document Document to be sent
     * @property thumbnail Document thumbnail, if available
     * @property caption Document caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageDocument"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageDocument(
        @SerialName("document")
        val document: InputFile,
        @SerialName("thumbnail")
        val thumbnail: InputThumbnail,
        @SerialName("caption")
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * A photo message
     *
     * @property photo Photo to send
     * @property thumbnail Photo thumbnail to be sent, this is sent to the other party in secret chats only
     * @property addedStickerFileIds File identifiers of the stickers added to the photo, if applicable
     * @property width Photo width
     * @property height Photo height
     * @property caption Photo caption
     *                   0-GetOption("message_caption_length_max") characters
     * @property ttl Photo TTL (Time To Live), in seconds (0-60)
     *               A non-zero TTL can be specified only in private chats
     */
    @Serializable
    @SerialName("inputMessagePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessagePhoto"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessagePhoto(
        @SerialName("photo")
        val photo: InputFile,
        @SerialName("thumbnail")
        val thumbnail: InputThumbnail,
        @SerialName("added_sticker_file_ids")
        val addedStickerFileIds: IntArray,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("caption")
        val caption: FormattedText,
        @SerialName("ttl")
        val ttl: Int
    ) : InputMessageContent()

    /**
     * A sticker message
     *
     * @property sticker Sticker to be sent
     * @property thumbnail Sticker thumbnail, if available
     * @property width Sticker width
     * @property height Sticker height
     */
    @Serializable
    @SerialName("inputMessageSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageSticker"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageSticker(
        @SerialName("sticker")
        val sticker: InputFile,
        @SerialName("thumbnail")
        val thumbnail: InputThumbnail,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int
    ) : InputMessageContent()

    /**
     * A video message
     *
     * @property video Video to be sent
     * @property thumbnail Video thumbnail, if available
     * @property addedStickerFileIds File identifiers of the stickers added to the video, if applicable
     * @property duration Duration of the video, in seconds
     * @property width Video width
     * @property height Video height
     * @property supportsStreaming True, if the video should be tried to be streamed
     * @property caption Video caption
     *                   0-GetOption("message_caption_length_max") characters
     * @property ttl Video TTL (Time To Live), in seconds (0-60)
     *               A non-zero TTL can be specified only in private chats
     */
    @Serializable
    @SerialName("inputMessageVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageVideo"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageVideo(
        @SerialName("video")
        val video: InputFile,
        @SerialName("thumbnail")
        val thumbnail: InputThumbnail,
        @SerialName("added_sticker_file_ids")
        val addedStickerFileIds: IntArray,
        @SerialName("duration")
        val duration: Int,
        @SerialName("width")
        val width: Int,
        @SerialName("height")
        val height: Int,
        @SerialName("supports_streaming")
        val supportsStreaming: Boolean,
        @SerialName("caption")
        val caption: FormattedText,
        @SerialName("ttl")
        val ttl: Int
    ) : InputMessageContent()

    /**
     * A video note message
     *
     * @property videoNote Video note to be sent
     * @property thumbnail Video thumbnail, if available
     * @property duration Duration of the video, in seconds
     * @property length Video width and height
     *                  Must be positive and not greater than 640
     */
    @Serializable
    @SerialName("inputMessageVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageVideoNote"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageVideoNote(
        @SerialName("video_note")
        val videoNote: InputFile,
        @SerialName("thumbnail")
        val thumbnail: InputThumbnail,
        @SerialName("duration")
        val duration: Int,
        @SerialName("length")
        val length: Int
    ) : InputMessageContent()

    /**
     * A voice note message
     *
     * @property voiceNote Voice note to be sent
     * @property duration Duration of the voice note, in seconds
     * @property waveform Waveform representation of the voice note, in 5-bit format
     * @property caption Voice note caption
     *                   0-GetOption("message_caption_length_max") characters
     */
    @Serializable
    @SerialName("inputMessageVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageVoiceNote(
        @SerialName("voice_note")
        val voiceNote: InputFile,
        @SerialName("duration")
        val duration: Int,
        @SerialName("waveform")
        val waveform: ByteArray,
        @SerialName("caption")
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * A message with a location
     *
     * @property location Location to be sent
     * @property livePeriod Period for which the location can be updated, in seconds
     *                      Should bebetween 60 and 86400 for a live location and 0 otherwise
     */
    @Serializable
    @SerialName("inputMessageLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageLocation"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageLocation(
        @SerialName("location")
        val location: Location,
        @SerialName("live_period")
        val livePeriod: Int
    ) : InputMessageContent()

    /**
     * A message with information about a venue
     *
     * @property venue Venue to send
     */
    @Serializable
    @SerialName("inputMessageVenue")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageVenue"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageVenue(
        @SerialName("venue")
        val venue: Venue
    ) : InputMessageContent()

    /**
     * A message containing a user contact
     *
     * @property contact Contact to send
     */
    @Serializable
    @SerialName("inputMessageContact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContact"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageContact(
        @SerialName("contact")
        val contact: Contact
    ) : InputMessageContent()

    /**
     * A message with a game
     * Not supported for channels or secret chats
     *
     * @property botUserId User identifier of the bot that owns the game
     * @property gameShortName Short name of the game
     */
    @Serializable
    @SerialName("inputMessageGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageGame"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageGame(
        @SerialName("bot_user_id")
        val botUserId: Int,
        @SerialName("game_short_name")
        val gameShortName: String
    ) : InputMessageContent()

    /**
     * A message with an invoice
     *
     * @property invoice Invoice
     * @property title Product title
     * @property description Product description
     * @property photoUrl Product photo URL
     * @property photoSize Product photo size
     * @property photoWidth Product photo width
     * @property photoHeight Product photo height
     * @property payload The invoice payload
     * @property providerToken Payment provider token
     * @property providerData JSON-encoded data about the invoice, which will be shared with the payment provider
     * @property startParameter Unique invoice bot start_parameter for the generation of this invoice
     */
    @Serializable
    @SerialName("inputMessageInvoice")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageInvoice"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class InputMessageInvoice(
        @SerialName("invoice")
        val invoice: Invoice,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("photo_url")
        val photoUrl: String?,
        @SerialName("photo_size")
        val photoSize: Int,
        @SerialName("photo_width")
        val photoWidth: Int,
        @SerialName("photo_height")
        val photoHeight: Int,
        @SerialName("payload")
        val payload: ByteArray,
        @SerialName("provider_token")
        val providerToken: String,
        @SerialName("provider_data")
        val providerData: String,
        @SerialName("start_parameter")
        val startParameter: String
    ) : InputMessageContent()

    /**
     * A message with a poll
     * Polls can't be sent to private or secret chats
     *
     * @property question Poll question, 1-255 characters
     * @property options List of poll answer options, 2-10 strings 1-100 characters each
     */
    @Serializable
    @SerialName("inputMessagePoll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessagePoll"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessagePoll(
        @SerialName("question")
        val question: String,
        @SerialName("options")
        val options: Array<String>
    ) : InputMessageContent()

    /**
     * A forwarded message
     *
     * @property fromChatId Identifier for the chat this forwarded message came from
     * @property messageId Identifier of the message to forward
     * @property inGameShare True, if a game message should be shared within a launched game
     *                       Applies only to game messages
     * @property sendCopy True, if content of the message needs to be copied without a link to the original message
     *                    Always true if the message is forwarded to a secret chat
     * @property removeCaption True, if media caption of the message copy needs to be removed
     *                         Ignored if send_copy is false
     */
    @Serializable
    @SerialName("inputMessageForwarded")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageForwarded"),
        level = DeprecationLevel.WARNING
    )
    data class InputMessageForwarded(
        @SerialName("from_chat_id")
        val fromChatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("in_game_share")
        val inGameShare: Boolean,
        @SerialName("send_copy")
        val sendCopy: Boolean,
        @SerialName("remove_caption")
        val removeCaption: Boolean
    ) : InputMessageContent()

    /**
     * Represents a filter for message search results
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter"),
        level = DeprecationLevel.WARNING
    )
    abstract class SearchMessagesFilter : Object(), TdObject

    /**
     * Returns all found messages, no filter is applied
     */
    @Serializable
    @SerialName("searchMessagesFilterEmpty")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterEmpty"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterEmpty : SearchMessagesFilter()

    /**
     * Returns only animation messages
     */
    @Serializable
    @SerialName("searchMessagesFilterAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterAnimation"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterAnimation : SearchMessagesFilter()

    /**
     * Returns only audio messages
     */
    @Serializable
    @SerialName("searchMessagesFilterAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterAudio"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterAudio : SearchMessagesFilter()

    /**
     * Returns only document messages
     */
    @Serializable
    @SerialName("searchMessagesFilterDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterDocument"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterDocument : SearchMessagesFilter()

    /**
     * Returns only photo messages
     */
    @Serializable
    @SerialName("searchMessagesFilterPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterPhoto"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterPhoto : SearchMessagesFilter()

    /**
     * Returns only video messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterVideo"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterVideo : SearchMessagesFilter()

    /**
     * Returns only voice note messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterVoiceNote : SearchMessagesFilter()

    /**
     * Returns only photo and video messages
     */
    @Serializable
    @SerialName("searchMessagesFilterPhotoAndVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterPhotoAndVideo"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterPhotoAndVideo : SearchMessagesFilter()

    /**
     * Returns only messages containing URLs
     */
    @Serializable
    @SerialName("searchMessagesFilterUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterUrl"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterUrl : SearchMessagesFilter()

    /**
     * Returns only messages containing chat photos
     */
    @Serializable
    @SerialName("searchMessagesFilterChatPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterChatPhoto"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterChatPhoto : SearchMessagesFilter()

    /**
     * Returns only call messages
     */
    @Serializable
    @SerialName("searchMessagesFilterCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterCall"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterCall : SearchMessagesFilter()

    /**
     * Returns only incoming call messages with missed/declined discard reasons
     */
    @Serializable
    @SerialName("searchMessagesFilterMissedCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterMissedCall"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterMissedCall : SearchMessagesFilter()

    /**
     * Returns only video note messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterVideoNote"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterVideoNote : SearchMessagesFilter()

    /**
     * Returns only voice and video note messages
     */
    @Serializable
    @SerialName("searchMessagesFilterVoiceAndVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterVoiceAndVideoNote"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterVoiceAndVideoNote : SearchMessagesFilter()

    /**
     * Returns only messages with mentions of the current user, or messages that are replies to their messages
     */
    @Serializable
    @SerialName("searchMessagesFilterMention")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterMention"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterMention : SearchMessagesFilter()

    /**
     * Returns only messages with unread mentions of the current user, or messages that are replies to their messages
     * When using this filter the results can't be additionally filtered by a query or by the sending user
     */
    @Serializable
    @SerialName("searchMessagesFilterUnreadMention")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilterUnreadMention"),
        level = DeprecationLevel.WARNING
    )
    object SearchMessagesFilterUnreadMention : SearchMessagesFilter()

    /**
     * Describes the different types of activity in a chat
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction"),
        level = DeprecationLevel.WARNING
    )
    abstract class ChatAction : Object(), TdObject

    /**
     * The user is typing a message
     */
    @Serializable
    @SerialName("chatActionTyping")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionTyping"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionTyping : ChatAction()

    /**
     * The user is recording a video
     */
    @Serializable
    @SerialName("chatActionRecordingVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionRecordingVideo"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionRecordingVideo : ChatAction()

    /**
     * The user is uploading a video
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionUploadingVideo"),
        level = DeprecationLevel.WARNING
    )
    data class ChatActionUploadingVideo(
        @SerialName("progress")
        val progress: Int
    ) : ChatAction()

    /**
     * The user is recording a voice note
     */
    @Serializable
    @SerialName("chatActionRecordingVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionRecordingVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionRecordingVoiceNote : ChatAction()

    /**
     * The user is uploading a voice note
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionUploadingVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    data class ChatActionUploadingVoiceNote(
        @SerialName("progress")
        val progress: Int
    ) : ChatAction()

    /**
     * The user is uploading a photo
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionUploadingPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class ChatActionUploadingPhoto(
        @SerialName("progress")
        val progress: Int
    ) : ChatAction()

    /**
     * The user is uploading a document
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionUploadingDocument"),
        level = DeprecationLevel.WARNING
    )
    data class ChatActionUploadingDocument(
        @SerialName("progress")
        val progress: Int
    ) : ChatAction()

    /**
     * The user is picking a location or venue to send
     */
    @Serializable
    @SerialName("chatActionChoosingLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionChoosingLocation"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionChoosingLocation : ChatAction()

    /**
     * The user is picking a contact to send
     */
    @Serializable
    @SerialName("chatActionChoosingContact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionChoosingContact"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionChoosingContact : ChatAction()

    /**
     * The user has started to play a game
     */
    @Serializable
    @SerialName("chatActionStartPlayingGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionStartPlayingGame"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionStartPlayingGame : ChatAction()

    /**
     * The user is recording a video note
     */
    @Serializable
    @SerialName("chatActionRecordingVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionRecordingVideoNote"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionRecordingVideoNote : ChatAction()

    /**
     * The user is uploading a video note
     *
     * @property progress Upload progress, as a percentage
     */
    @Serializable
    @SerialName("chatActionUploadingVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionUploadingVideoNote"),
        level = DeprecationLevel.WARNING
    )
    data class ChatActionUploadingVideoNote(
        @SerialName("progress")
        val progress: Int
    ) : ChatAction()

    /**
     * The user has cancelled the previous action
     */
    @Serializable
    @SerialName("chatActionCancel")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionCancel"),
        level = DeprecationLevel.WARNING
    )
    object ChatActionCancel : ChatAction()

    /**
     * Describes the last time the user was online
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus"),
        level = DeprecationLevel.WARNING
    )
    abstract class UserStatus : Object(), TdObject

    /**
     * The user status was never changed
     */
    @Serializable
    @SerialName("userStatusEmpty")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatusEmpty"),
        level = DeprecationLevel.WARNING
    )
    object UserStatusEmpty : UserStatus()

    /**
     * The user is online
     *
     * @property expires Point in time (Unix timestamp) when the user's online status will expire
     */
    @Serializable
    @SerialName("userStatusOnline")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatusOnline"),
        level = DeprecationLevel.WARNING
    )
    data class UserStatusOnline(
        @SerialName("expires")
        val expires: Int
    ) : UserStatus()

    /**
     * The user is offline
     *
     * @property wasOnline Point in time (Unix timestamp) when the user was last online
     */
    @Serializable
    @SerialName("userStatusOffline")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatusOffline"),
        level = DeprecationLevel.WARNING
    )
    data class UserStatusOffline(
        @SerialName("was_online")
        val wasOnline: Int
    ) : UserStatus()

    /**
     * The user was online recently
     */
    @Serializable
    @SerialName("userStatusRecently")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatusRecently"),
        level = DeprecationLevel.WARNING
    )
    object UserStatusRecently : UserStatus()

    /**
     * The user is offline, but was online last week
     */
    @Serializable
    @SerialName("userStatusLastWeek")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatusLastWeek"),
        level = DeprecationLevel.WARNING
    )
    object UserStatusLastWeek : UserStatus()

    /**
     * The user is offline, but was online last month
     */
    @Serializable
    @SerialName("userStatusLastMonth")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatusLastMonth"),
        level = DeprecationLevel.WARNING
    )
    object UserStatusLastMonth : UserStatus()

    /**
     * Represents a list of stickers
     *
     * @property stickers List of stickers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("stickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickers"),
        level = DeprecationLevel.WARNING
    )
    data class Stickers(
        @SerialName("stickers")
        val stickers: Array<Sticker>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a list of emoji
     *
     * @property emojis List of emojis
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("emojis")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEmojis"),
        level = DeprecationLevel.WARNING
    )
    data class Emojis(
        @SerialName("emojis")
        val emojis: Array<String>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a sticker set
     *
     * @property id Identifier of the sticker set
     * @property title Title of the sticker set
     * @property name Name of the sticker set
     * @property thumbnail Sticker set thumbnail in WEBP format with width and height 100
     *                     The file can be downloaded only before the thumbnail is changed
     * @property isInstalled True, if the sticker set has been installed by the current user
     * @property isArchived True, if the sticker set has been archived
     *                      A sticker set can't be installed and archived simultaneously
     * @property isOfficial True, if the sticker set is official
     * @property isAnimated True, is the stickers in the set are animated
     * @property isMasks True, if the stickers in the set are masks
     * @property isViewed True for already viewed trending sticker sets
     * @property stickers List of stickers in this set
     * @property emojis A list of emoji corresponding to the stickers in the same order
     *                  The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("stickerSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickerSet"),
        level = DeprecationLevel.WARNING
    )
    data class StickerSet(
        @SerialName("id")
        val id: Long,
        @SerialName("title")
        val title: String,
        @SerialName("name")
        val name: String,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?,
        @SerialName("is_installed")
        val isInstalled: Boolean,
        @SerialName("is_archived")
        val isArchived: Boolean,
        @SerialName("is_official")
        val isOfficial: Boolean,
        @SerialName("is_animated")
        val isAnimated: Boolean,
        @SerialName("is_masks")
        val isMasks: Boolean,
        @SerialName("is_viewed")
        val isViewed: Boolean,
        @SerialName("stickers")
        val stickers: Array<Sticker>,
        @SerialName("emojis")
        val emojis: Array<Emojis>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents short information about a sticker set
     *
     * @property id Identifier of the sticker set
     * @property title Title of the sticker set
     * @property name Name of the sticker set
     * @property thumbnail Sticker set thumbnail in WEBP format with width and height 100
     * @property isInstalled True, if the sticker set has been installed by current user
     * @property isArchived True, if the sticker set has been archived
     *                      A sticker set can't be installed and archived simultaneously
     * @property isOfficial True, if the sticker set is official
     * @property isAnimated True, is the stickers in the set are animated
     * @property isMasks True, if the stickers in the set are masks
     * @property isViewed True for already viewed trending sticker sets
     * @property size Total number of stickers in the set
     * @property covers Contains up to the first 5 stickers from the set, depending on the context
     *                  If the client needs more stickers the full set should be requested
     */
    @Serializable
    @SerialName("stickerSetInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickerSetInfo"),
        level = DeprecationLevel.WARNING
    )
    data class StickerSetInfo(
        @SerialName("id")
        val id: Long,
        @SerialName("title")
        val title: String,
        @SerialName("name")
        val name: String,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?,
        @SerialName("is_installed")
        val isInstalled: Boolean,
        @SerialName("is_archived")
        val isArchived: Boolean,
        @SerialName("is_official")
        val isOfficial: Boolean,
        @SerialName("is_animated")
        val isAnimated: Boolean,
        @SerialName("is_masks")
        val isMasks: Boolean,
        @SerialName("is_viewed")
        val isViewed: Boolean,
        @SerialName("size")
        val size: Int,
        @SerialName("covers")
        val covers: Array<Sticker>
    ) : Object(), TdObject

    /**
     * Represents a list of sticker sets
     *
     * @property totalCount Approximate total number of sticker sets found
     * @property sets List of sticker sets
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("stickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class StickerSets(
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("sets")
        val sets: Array<StickerSetInfo>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes the reason why a call was discarded
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReason"),
        level = DeprecationLevel.WARNING
    )
    abstract class CallDiscardReason : Object(), TdObject

    /**
     * The call wasn't discarded, or the reason is unknown
     */
    @Serializable
    @SerialName("callDiscardReasonEmpty")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReasonEmpty"),
        level = DeprecationLevel.WARNING
    )
    object CallDiscardReasonEmpty : CallDiscardReason()

    /**
     * The call was ended before the conversation started
     * It was cancelled by the caller or missed by the other party
     */
    @Serializable
    @SerialName("callDiscardReasonMissed")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReasonMissed"),
        level = DeprecationLevel.WARNING
    )
    object CallDiscardReasonMissed : CallDiscardReason()

    /**
     * The call was ended before the conversation started
     * It was declined by the other party
     */
    @Serializable
    @SerialName("callDiscardReasonDeclined")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReasonDeclined"),
        level = DeprecationLevel.WARNING
    )
    object CallDiscardReasonDeclined : CallDiscardReason()

    /**
     * The call was ended during the conversation because the users were disconnected
     */
    @Serializable
    @SerialName("callDiscardReasonDisconnected")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReasonDisconnected"),
        level = DeprecationLevel.WARNING
    )
    object CallDiscardReasonDisconnected : CallDiscardReason()

    /**
     * The call was ended because one of the parties hung up
     */
    @Serializable
    @SerialName("callDiscardReasonHungUp")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReasonHungUp"),
        level = DeprecationLevel.WARNING
    )
    object CallDiscardReasonHungUp : CallDiscardReason()

    /**
     * Specifies the supported call protocols
     *
     * @property udpP2p True, if UDP peer-to-peer connections are supported
     * @property udpReflector True, if connection through UDP reflectors is supported
     * @property minLayer Minimum supported API layer
     * @property maxLayer Maximum supported API layer
     */
    @Serializable
    @SerialName("callProtocol")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProtocol"),
        level = DeprecationLevel.WARNING
    )
    data class CallProtocol(
        @SerialName("udp_p2p")
        val udpP2p: Boolean,
        @SerialName("udp_reflector")
        val udpReflector: Boolean,
        @SerialName("min_layer")
        val minLayer: Int,
        @SerialName("max_layer")
        val maxLayer: Int
    ) : Object(), TdObject

    /**
     * Describes the address of UDP reflectors
     *
     * @property id Reflector identifier
     * @property ip IPv4 reflector address
     * @property ipv6 IPv6 reflector address
     * @property port Reflector port number
     * @property peerTag Connection peer tag
     */
    @Serializable
    @SerialName("callConnection")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallConnection"),
        level = DeprecationLevel.WARNING
    )
    data class CallConnection(
        @SerialName("id")
        val id: Long,
        @SerialName("ip")
        val ip: String,
        @SerialName("ipv6")
        val ipv6: String,
        @SerialName("port")
        val port: Int,
        @SerialName("peer_tag")
        val peerTag: ByteArray
    ) : Object(), TdObject

    /**
     * Contains the call identifier
     *
     * @property id Call identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("callId")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallId"),
        level = DeprecationLevel.WARNING
    )
    data class CallId(
        @SerialName("id")
        val id: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes the current call state
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState"),
        level = DeprecationLevel.WARNING
    )
    abstract class CallState : Object(), TdObject

    /**
     * The call is pending, waiting to be accepted by a user
     *
     * @property isCreated True, if the call has already been created by the server
     * @property isReceived True, if the call has already been received by the other party
     */
    @Serializable
    @SerialName("callStatePending")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallStatePending"),
        level = DeprecationLevel.WARNING
    )
    data class CallStatePending(
        @SerialName("is_created")
        val isCreated: Boolean,
        @SerialName("is_received")
        val isReceived: Boolean
    ) : CallState()

    /**
     * The call has been answered and encryption keys are being exchanged
     */
    @Serializable
    @SerialName("callStateExchangingKeys")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallStateExchangingKeys"),
        level = DeprecationLevel.WARNING
    )
    object CallStateExchangingKeys : CallState()

    /**
     * The call is ready to use
     *
     * @property protocol Call protocols supported by the peer
     * @property connections Available UDP reflectors
     * @property config A JSON-encoded call config
     * @property encryptionKey Call encryption key
     * @property emojis Encryption key emojis fingerprint
     * @property allowP2p True, if peer-to-peer connection is allowed by users privacy settings
     */
    @Serializable
    @SerialName("callStateReady")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallStateReady"),
        level = DeprecationLevel.WARNING
    )
    data class CallStateReady(
        @SerialName("protocol")
        val protocol: CallProtocol,
        @SerialName("connections")
        val connections: Array<CallConnection>,
        @SerialName("config")
        val config: String,
        @SerialName("encryption_key")
        val encryptionKey: ByteArray,
        @SerialName("emojis")
        val emojis: Array<String>,
        @SerialName("allow_p2p")
        val allowP2p: Boolean
    ) : CallState()

    /**
     * The call is hanging up after discardCall has been called
     */
    @Serializable
    @SerialName("callStateHangingUp")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallStateHangingUp"),
        level = DeprecationLevel.WARNING
    )
    object CallStateHangingUp : CallState()

    /**
     * The call has ended successfully
     *
     * @property reason The reason, why the call has ended
     * @property needRating True, if the call rating should be sent to the server
     * @property needDebugInformation True, if the call debug information should be sent to the server
     */
    @Serializable
    @SerialName("callStateDiscarded")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallStateDiscarded"),
        level = DeprecationLevel.WARNING
    )
    data class CallStateDiscarded(
        @SerialName("reason")
        val reason: CallDiscardReason,
        @SerialName("need_rating")
        val needRating: Boolean,
        @SerialName("need_debug_information")
        val needDebugInformation: Boolean
    ) : CallState()

    /**
     * The call has ended with an error
     *
     * @property error Error
     *                 An error with the code 4005000 will be returned if an outgoing call is missed because of an expired timeout
     */
    @Serializable
    @SerialName("callStateError")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallStateError"),
        level = DeprecationLevel.WARNING
    )
    data class CallStateError(
        @SerialName("error")
        val error: Error
    ) : CallState()

    /**
     * Describes the exact type of a problem with a call
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem"),
        level = DeprecationLevel.WARNING
    )
    abstract class CallProblem : Object(), TdObject

    /**
     * The user heard their own voice
     */
    @Serializable
    @SerialName("callProblemEcho")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblemEcho"),
        level = DeprecationLevel.WARNING
    )
    object CallProblemEcho : CallProblem()

    /**
     * The user heard background noise
     */
    @Serializable
    @SerialName("callProblemNoise")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblemNoise"),
        level = DeprecationLevel.WARNING
    )
    object CallProblemNoise : CallProblem()

    /**
     * The other side kept disappearing
     */
    @Serializable
    @SerialName("callProblemInterruptions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblemInterruptions"),
        level = DeprecationLevel.WARNING
    )
    object CallProblemInterruptions : CallProblem()

    /**
     * The speech was distorted
     */
    @Serializable
    @SerialName("callProblemDistortedSpeech")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblemDistortedSpeech"),
        level = DeprecationLevel.WARNING
    )
    object CallProblemDistortedSpeech : CallProblem()

    /**
     * The user couldn't hear the other side
     */
    @Serializable
    @SerialName("callProblemSilentLocal")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblemSilentLocal"),
        level = DeprecationLevel.WARNING
    )
    object CallProblemSilentLocal : CallProblem()

    /**
     * The other side couldn't hear the user
     */
    @Serializable
    @SerialName("callProblemSilentRemote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblemSilentRemote"),
        level = DeprecationLevel.WARNING
    )
    object CallProblemSilentRemote : CallProblem()

    /**
     * The call ended unexpectedly
     */
    @Serializable
    @SerialName("callProblemDropped")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblemDropped"),
        level = DeprecationLevel.WARNING
    )
    object CallProblemDropped : CallProblem()

    /**
     * Describes a call
     *
     * @property id Call identifier, not persistent
     * @property userId Peer user identifier
     * @property isOutgoing True, if the call is outgoing
     * @property state Call state
     */
    @Serializable
    @SerialName("call")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCall"),
        level = DeprecationLevel.WARNING
    )
    data class Call(
        @SerialName("id")
        val id: Int,
        @SerialName("user_id")
        val userId: Int,
        @SerialName("is_outgoing")
        val isOutgoing: Boolean,
        @SerialName("state")
        val state: CallState
    ) : Object(), TdObject

    /**
     * Contains settings for the authentication of the user's phone number
     *
     * @property allowFlashCall Pass true if the authentication code may be sent via flash call to the specified phone number
     * @property isCurrentPhoneNumber Pass true if the authenticated phone number is used on the current device
     * @property allowSmsRetrieverApi For official applications only
     *                                True, if the app can use Android SMS Retriever API (requires Google Play Services >= 10.2) to automatically receive the authentication code from the SMS
     *                                See https://developers.google.com/identity/sms-retriever/ for more details
     */
    @Serializable
    @SerialName("phoneNumberAuthenticationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPhoneNumberAuthenticationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class PhoneNumberAuthenticationSettings(
        @SerialName("allow_flash_call")
        val allowFlashCall: Boolean,
        @SerialName("is_current_phone_number")
        val isCurrentPhoneNumber: Boolean,
        @SerialName("allow_sms_retriever_api")
        val allowSmsRetrieverApi: Boolean
    ) : Object(), TdObject

    /**
     * Represents a list of animations
     *
     * @property animations List of animations
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("animations")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnimations"),
        level = DeprecationLevel.WARNING
    )
    data class Animations(
        @SerialName("animations")
        val animations: Array<Animation>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents the result of an ImportContacts request
     *
     * @property userIds User identifiers of the imported contacts in the same order as they were specified in the request
     *                   0 if the contact is not yet a registered user
     * @property importerCount The number of users that imported the corresponding contact
     *                         0 for already registered users or if unavailable
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("importedContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdImportedContacts"),
        level = DeprecationLevel.WARNING
    )
    data class ImportedContacts(
        @SerialName("user_ids")
        val userIds: IntArray,
        @SerialName("importer_count")
        val importerCount: IntArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains an HTTP URL
     *
     * @property url The URL
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("httpUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdHttpUrl"),
        level = DeprecationLevel.WARNING
    )
    data class HttpUrl(
        @SerialName("url")
        val url: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a single result of an inline query
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult"),
        level = DeprecationLevel.WARNING
    )
    abstract class InputInlineQueryResult : Object(), TdObject

    /**
     * Represents a link to an animated GIF
     *
     * @property id Unique identifier of the query result
     * @property title Title of the query result
     * @property thumbnailUrl URL of the static result thumbnail (JPEG or GIF), if it exists
     * @property gifUrl The URL of the GIF-file (file size must not exceed 1MB)
     * @property gifDuration Duration of the GIF, in seconds
     * @property gifWidth Width of the GIF
     * @property gifHeight Height of the GIF
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageAnimation, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultAnimatedGif")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultAnimatedGif"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultAnimatedGif(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("gif_url")
        val gifUrl: String,
        @SerialName("gif_duration")
        val gifDuration: Int,
        @SerialName("gif_width")
        val gifWidth: Int,
        @SerialName("gif_height")
        val gifHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an animated (i.e
     * Without sound) H.264/MPEG-4 AVC video
     *
     * @property id Unique identifier of the query result
     * @property title Title of the result
     * @property thumbnailUrl URL of the static result thumbnail (JPEG or GIF), if it exists
     * @property mpeg4Url The URL of the MPEG4-file (file size must not exceed 1MB)
     * @property mpeg4Duration Duration of the video, in seconds
     * @property mpeg4Width Width of the video
     * @property mpeg4Height Height of the video
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageAnimation, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultAnimatedMpeg4")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultAnimatedMpeg4"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultAnimatedMpeg4(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("mpeg4_url")
        val mpeg4Url: String,
        @SerialName("mpeg4_duration")
        val mpeg4Duration: Int,
        @SerialName("mpeg4_width")
        val mpeg4Width: Int,
        @SerialName("mpeg4_height")
        val mpeg4Height: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an article or web page
     *
     * @property id Unique identifier of the query result
     * @property url URL of the result, if it exists
     * @property hideUrl True, if the URL must be not shown
     * @property title Title of the result
     * @property description A short description of the result
     * @property thumbnailUrl URL of the result thumbnail, if it exists
     * @property thumbnailWidth Thumbnail width, if known
     * @property thumbnailHeight Thumbnail height, if known
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultArticle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultArticle"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultArticle(
        @SerialName("id")
        val id: String,
        @SerialName("url")
        val url: String,
        @SerialName("hide_url")
        val hideUrl: Boolean,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("thumbnail_width")
        val thumbnailWidth: Int,
        @SerialName("thumbnail_height")
        val thumbnailHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an MP3 audio file
     *
     * @property id Unique identifier of the query result
     * @property title Title of the audio file
     * @property performer Performer of the audio file
     * @property audioUrl The URL of the audio file
     * @property audioDuration Audio file duration, in seconds
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageAudio, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultAudio"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultAudio(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("performer")
        val performer: String,
        @SerialName("audio_url")
        val audioUrl: String,
        @SerialName("audio_duration")
        val audioDuration: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a user contact
     *
     * @property id Unique identifier of the query result
     * @property contact User contact
     * @property thumbnailUrl URL of the result thumbnail, if it exists
     * @property thumbnailWidth Thumbnail width, if known
     * @property thumbnailHeight Thumbnail height, if known
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultContact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultContact"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultContact(
        @SerialName("id")
        val id: String,
        @SerialName("contact")
        val contact: Contact,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("thumbnail_width")
        val thumbnailWidth: Int,
        @SerialName("thumbnail_height")
        val thumbnailHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to a file
     *
     * @property id Unique identifier of the query result
     * @property title Title of the resulting file
     * @property description Short description of the result, if known
     * @property documentUrl URL of the file
     * @property mimeType MIME type of the file content
     *                    Only "application/pdf" and "application/zip" are currently allowed
     * @property thumbnailUrl The URL of the file thumbnail, if it exists
     * @property thumbnailWidth Width of the thumbnail
     * @property thumbnailHeight Height of the thumbnail
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageDocument, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultDocument"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultDocument(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("document_url")
        val documentUrl: String,
        @SerialName("mime_type")
        val mimeType: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("thumbnail_width")
        val thumbnailWidth: Int,
        @SerialName("thumbnail_height")
        val thumbnailHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a game
     *
     * @property id Unique identifier of the query result
     * @property gameShortName Short name of the game
     * @property replyMarkup Message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     */
    @Serializable
    @SerialName("inputInlineQueryResultGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultGame"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultGame(
        @SerialName("id")
        val id: String,
        @SerialName("game_short_name")
        val gameShortName: String,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup
    ) : InputInlineQueryResult()

    /**
     * Represents a point on the map
     *
     * @property id Unique identifier of the query result
     * @property location Location result
     * @property livePeriod Amount of time relative to the message sent time until the location can be updated, in seconds
     * @property title Title of the result
     * @property thumbnailUrl URL of the result thumbnail, if it exists
     * @property thumbnailWidth Thumbnail width, if known
     * @property thumbnailHeight Thumbnail height, if known
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultLocation"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultLocation(
        @SerialName("id")
        val id: String,
        @SerialName("location")
        val location: Location,
        @SerialName("live_period")
        val livePeriod: Int,
        @SerialName("title")
        val title: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("thumbnail_width")
        val thumbnailWidth: Int,
        @SerialName("thumbnail_height")
        val thumbnailHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents link to a JPEG image
     *
     * @property id Unique identifier of the query result
     * @property title Title of the result, if known
     * @property description A short description of the result, if known
     * @property thumbnailUrl URL of the photo thumbnail, if it exists
     * @property photoUrl The URL of the JPEG photo (photo size must not exceed 5MB)
     * @property photoWidth Width of the photo
     * @property photoHeight Height of the photo
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessagePhoto, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultPhoto(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("photo_url")
        val photoUrl: String,
        @SerialName("photo_width")
        val photoWidth: Int,
        @SerialName("photo_height")
        val photoHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to a WEBP or a TGS sticker
     *
     * @property id Unique identifier of the query result
     * @property thumbnailUrl URL of the sticker thumbnail, if it exists
     * @property stickerUrl The URL of the WEBP or a TGS sticker (sticker file size must not exceed 5MB)
     * @property stickerWidth Width of the sticker
     * @property stickerHeight Height of the sticker
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, inputMessageSticker, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultSticker"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultSticker(
        @SerialName("id")
        val id: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("sticker_url")
        val stickerUrl: String,
        @SerialName("sticker_width")
        val stickerWidth: Int,
        @SerialName("sticker_height")
        val stickerHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents information about a venue
     *
     * @property id Unique identifier of the query result
     * @property venue Venue result
     * @property thumbnailUrl URL of the result thumbnail, if it exists
     * @property thumbnailWidth Thumbnail width, if known
     * @property thumbnailHeight Thumbnail height, if known
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultVenue")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultVenue"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultVenue(
        @SerialName("id")
        val id: String,
        @SerialName("venue")
        val venue: Venue,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("thumbnail_width")
        val thumbnailWidth: Int,
        @SerialName("thumbnail_height")
        val thumbnailHeight: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to a page containing an embedded video player or a video file
     *
     * @property id Unique identifier of the query result
     * @property title Title of the result
     * @property description A short description of the result, if known
     * @property thumbnailUrl The URL of the video thumbnail (JPEG), if it exists
     * @property videoUrl URL of the embedded video player or video file
     * @property mimeType MIME type of the content of the video URL, only "text/html" or "video/mp4" are currently supported
     * @property videoWidth Width of the video
     * @property videoHeight Height of the video
     * @property videoDuration Video duration, in seconds
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageVideo, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultVideo"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultVideo(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("thumbnail_url")
        val thumbnailUrl: String,
        @SerialName("video_url")
        val videoUrl: String,
        @SerialName("mime_type")
        val mimeType: String,
        @SerialName("video_width")
        val videoWidth: Int,
        @SerialName("video_height")
        val videoHeight: Int,
        @SerialName("video_duration")
        val videoDuration: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an opus-encoded audio file within an OGG container, single channel audio
     *
     * @property id Unique identifier of the query result
     * @property title Title of the voice note
     * @property voiceNoteUrl The URL of the voice note file
     * @property voiceNoteDuration Duration of the voice note, in seconds
     * @property replyMarkup The message reply markup
     *                       Must be of type replyMarkupInlineKeyboard or null
     * @property inputMessageContent The content of the message to be sent
     *                               Must be one of the following types: InputMessageText, InputMessageVoiceNote, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    @Serializable
    @SerialName("inputInlineQueryResultVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResultVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    data class InputInlineQueryResultVoiceNote(
        @SerialName("id")
        val id: String,
        @SerialName("title")
        val title: String,
        @SerialName("voice_note_url")
        val voiceNoteUrl: String,
        @SerialName("voice_note_duration")
        val voiceNoteDuration: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a single result of an inline query
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult"),
        level = DeprecationLevel.WARNING
    )
    abstract class InlineQueryResult : Object(), TdObject

    /**
     * Represents a link to an article or web page
     *
     * @property id Unique identifier of the query result
     * @property url URL of the result, if it exists
     * @property hideUrl True, if the URL must be not shown
     * @property title Title of the result
     * @property description A short description of the result
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultArticle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultArticle"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultArticle(
        @SerialName("id")
        val id: String,
        @SerialName("url")
        val url: String,
        @SerialName("hide_url")
        val hideUrl: Boolean,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents a user contact
     *
     * @property id Unique identifier of the query result
     * @property contact A user contact
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultContact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultContact"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultContact(
        @SerialName("id")
        val id: String,
        @SerialName("contact")
        val contact: Contact,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents a point on the map
     *
     * @property id Unique identifier of the query result
     * @property location Location result
     * @property title Title of the result
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultLocation"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultLocation(
        @SerialName("id")
        val id: String,
        @SerialName("location")
        val location: Location,
        @SerialName("title")
        val title: String,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents information about a venue
     *
     * @property id Unique identifier of the query result
     * @property venue Venue result
     * @property thumbnail Result thumbnail
     */
    @Serializable
    @SerialName("inlineQueryResultVenue")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultVenue"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultVenue(
        @SerialName("id")
        val id: String,
        @SerialName("venue")
        val venue: Venue,
        @SerialName("thumbnail")
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents information about a game
     *
     * @property id Unique identifier of the query result
     * @property game Game result
     */
    @Serializable
    @SerialName("inlineQueryResultGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultGame"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultGame(
        @SerialName("id")
        val id: String,
        @SerialName("game")
        val game: Game
    ) : InlineQueryResult()

    /**
     * Represents an animation file
     *
     * @property id Unique identifier of the query result
     * @property animation Animation file
     * @property title Animation title
     */
    @Serializable
    @SerialName("inlineQueryResultAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultAnimation(
        @SerialName("id")
        val id: String,
        @SerialName("animation")
        val animation: Animation,
        @SerialName("title")
        val title: String
    ) : InlineQueryResult()

    /**
     * Represents an audio file
     *
     * @property id Unique identifier of the query result
     * @property audio Audio file
     */
    @Serializable
    @SerialName("inlineQueryResultAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultAudio"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultAudio(
        @SerialName("id")
        val id: String,
        @SerialName("audio")
        val audio: Audio
    ) : InlineQueryResult()

    /**
     * Represents a document
     *
     * @property id Unique identifier of the query result
     * @property document Document
     * @property title Document title
     * @property description Document description
     */
    @Serializable
    @SerialName("inlineQueryResultDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultDocument"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultDocument(
        @SerialName("id")
        val id: String,
        @SerialName("document")
        val document: Document,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String
    ) : InlineQueryResult()

    /**
     * Represents a photo
     *
     * @property id Unique identifier of the query result
     * @property photo Photo
     * @property title Title of the result, if known
     * @property description A short description of the result, if known
     */
    @Serializable
    @SerialName("inlineQueryResultPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultPhoto(
        @SerialName("id")
        val id: String,
        @SerialName("photo")
        val photo: Photo,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String
    ) : InlineQueryResult()

    /**
     * Represents a sticker
     *
     * @property id Unique identifier of the query result
     * @property sticker Sticker
     */
    @Serializable
    @SerialName("inlineQueryResultSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultSticker"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultSticker(
        @SerialName("id")
        val id: String,
        @SerialName("sticker")
        val sticker: Sticker
    ) : InlineQueryResult()

    /**
     * Represents a video
     *
     * @property id Unique identifier of the query result
     * @property video Video
     * @property title Title of the video
     * @property description Description of the video
     */
    @Serializable
    @SerialName("inlineQueryResultVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultVideo"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultVideo(
        @SerialName("id")
        val id: String,
        @SerialName("video")
        val video: Video,
        @SerialName("title")
        val title: String,
        @SerialName("description")
        val description: String
    ) : InlineQueryResult()

    /**
     * Represents a voice note
     *
     * @property id Unique identifier of the query result
     * @property voiceNote Voice note
     * @property title Title of the voice note
     */
    @Serializable
    @SerialName("inlineQueryResultVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResultVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResultVoiceNote(
        @SerialName("id")
        val id: String,
        @SerialName("voice_note")
        val voiceNote: VoiceNote,
        @SerialName("title")
        val title: String
    ) : InlineQueryResult()

    /**
     * Represents the results of the inline query
     * Use sendInlineQueryResultMessage to send the result of the query
     *
     * @property inlineQueryId Unique identifier of the inline query
     * @property nextOffset The offset for the next request
     *                      If empty, there are no more results
     * @property results Results of the query
     * @property switchPmText If non-empty, this text should be shown on the button, which opens a private chat with the bot and sends the bot a start message with the switch_pm_parameter
     * @property switchPmParameter Parameter for the bot start message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("inlineQueryResults")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResults"),
        level = DeprecationLevel.WARNING
    )
    data class InlineQueryResults(
        @SerialName("inline_query_id")
        val inlineQueryId: Long,
        @SerialName("next_offset")
        val nextOffset: String,
        @SerialName("results")
        val results: Array<InlineQueryResult>,
        @SerialName("switch_pm_text")
        val switchPmText: String,
        @SerialName("switch_pm_parameter")
        val switchPmParameter: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a payload of a callback query
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryPayload"),
        level = DeprecationLevel.WARNING
    )
    abstract class CallbackQueryPayload : Object(), TdObject

    /**
     * The payload from a general callback button
     *
     * @property data Data that was attached to the callback button
     */
    @Serializable
    @SerialName("callbackQueryPayloadData")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryPayloadData"),
        level = DeprecationLevel.WARNING
    )
    data class CallbackQueryPayloadData(
        @SerialName("data")
        val data: ByteArray
    ) : CallbackQueryPayload()

    /**
     * The payload from a game callback button
     *
     * @property gameShortName A short name of the game that was attached to the callback button
     */
    @Serializable
    @SerialName("callbackQueryPayloadGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryPayloadGame"),
        level = DeprecationLevel.WARNING
    )
    data class CallbackQueryPayloadGame(
        @SerialName("game_short_name")
        val gameShortName: String
    ) : CallbackQueryPayload()

    /**
     * Contains a bot's answer to a callback query
     *
     * @property text Text of the answer
     * @property showAlert True, if an alert should be shown to the user instead of a toast notification
     * @property url URL to be opened
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("callbackQueryAnswer")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryAnswer"),
        level = DeprecationLevel.WARNING
    )
    data class CallbackQueryAnswer(
        @SerialName("text")
        val text: String,
        @SerialName("show_alert")
        val showAlert: Boolean,
        @SerialName("url")
        val url: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains the result of a custom request
     *
     * @property result A JSON-serialized result
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("customRequestResult")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCustomRequestResult"),
        level = DeprecationLevel.WARNING
    )
    data class CustomRequestResult(
        @SerialName("result")
        val result: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains one row of the game high score table
     *
     * @property position Position in the high score table
     * @property userId User identifier
     * @property score User score
     */
    @Serializable
    @SerialName("gameHighScore")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGameHighScore"),
        level = DeprecationLevel.WARNING
    )
    data class GameHighScore(
        @SerialName("position")
        val position: Int,
        @SerialName("user_id")
        val userId: Int,
        @SerialName("score")
        val score: Int
    ) : Object(), TdObject

    /**
     * Contains a list of game high scores
     *
     * @property scores A list of game high scores
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("gameHighScores")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGameHighScores"),
        level = DeprecationLevel.WARNING
    )
    data class GameHighScores(
        @SerialName("scores")
        val scores: Array<GameHighScore>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a chat event
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction"),
        level = DeprecationLevel.WARNING
    )
    abstract class ChatEventAction : Object(), TdObject

    /**
     * A message was edited
     *
     * @property oldMessage The original message before the edit
     * @property newMessage The message after it was edited
     */
    @Serializable
    @SerialName("chatEventMessageEdited")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMessageEdited"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventMessageEdited(
        @SerialName("old_message")
        val oldMessage: Message,
        @SerialName("new_message")
        val newMessage: Message
    ) : ChatEventAction()

    /**
     * A message was deleted
     *
     * @property message Deleted message
     */
    @Serializable
    @SerialName("chatEventMessageDeleted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMessageDeleted"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventMessageDeleted(
        @SerialName("message")
        val message: Message
    ) : ChatEventAction()

    /**
     * A poll in a message was stopped
     *
     * @property message The message with the poll
     */
    @Serializable
    @SerialName("chatEventPollStopped")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventPollStopped"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventPollStopped(
        @SerialName("message")
        val message: Message
    ) : ChatEventAction()

    /**
     * A message was pinned
     *
     * @property message Pinned message
     */
    @Serializable
    @SerialName("chatEventMessagePinned")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMessagePinned"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventMessagePinned(
        @SerialName("message")
        val message: Message
    ) : ChatEventAction()

    /**
     * A message was unpinned
     */
    @Serializable
    @SerialName("chatEventMessageUnpinned")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMessageUnpinned"),
        level = DeprecationLevel.WARNING
    )
    object ChatEventMessageUnpinned : ChatEventAction()

    /**
     * A new member joined the chat
     */
    @Serializable
    @SerialName("chatEventMemberJoined")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMemberJoined"),
        level = DeprecationLevel.WARNING
    )
    object ChatEventMemberJoined : ChatEventAction()

    /**
     * A member left the chat
     */
    @Serializable
    @SerialName("chatEventMemberLeft")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMemberLeft"),
        level = DeprecationLevel.WARNING
    )
    object ChatEventMemberLeft : ChatEventAction()

    /**
     * A new chat member was invited
     *
     * @property userId New member user identifier
     * @property status New member status
     */
    @Serializable
    @SerialName("chatEventMemberInvited")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMemberInvited"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventMemberInvited(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("status")
        val status: ChatMemberStatus
    ) : ChatEventAction()

    /**
     * A chat member has gained/lost administrator status, or the list of their administrator privileges has changed
     *
     * @property userId Chat member user identifier
     * @property oldStatus Previous status of the chat member
     * @property newStatus New status of the chat member
     */
    @Serializable
    @SerialName("chatEventMemberPromoted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMemberPromoted"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventMemberPromoted(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("old_status")
        val oldStatus: ChatMemberStatus,
        @SerialName("new_status")
        val newStatus: ChatMemberStatus
    ) : ChatEventAction()

    /**
     * A chat member was restricted/unrestricted or banned/unbanned, or the list of their restrictions has changed
     *
     * @property userId Chat member user identifier
     * @property oldStatus Previous status of the chat member
     * @property newStatus New status of the chat member
     */
    @Serializable
    @SerialName("chatEventMemberRestricted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventMemberRestricted"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventMemberRestricted(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("old_status")
        val oldStatus: ChatMemberStatus,
        @SerialName("new_status")
        val newStatus: ChatMemberStatus
    ) : ChatEventAction()

    /**
     * The chat title was changed
     *
     * @property oldTitle Previous chat title
     * @property newTitle New chat title
     */
    @Serializable
    @SerialName("chatEventTitleChanged")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventTitleChanged"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventTitleChanged(
        @SerialName("old_title")
        val oldTitle: String,
        @SerialName("new_title")
        val newTitle: String
    ) : ChatEventAction()

    /**
     * The chat permissions was changed
     *
     * @property oldPermissions Previous chat permissions
     * @property newPermissions New chat permissions
     */
    @Serializable
    @SerialName("chatEventPermissionsChanged")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventPermissionsChanged"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventPermissionsChanged(
        @SerialName("old_permissions")
        val oldPermissions: ChatPermissions,
        @SerialName("new_permissions")
        val newPermissions: ChatPermissions
    ) : ChatEventAction()

    /**
     * The chat description was changed
     *
     * @property oldDescription Previous chat description
     * @property newDescription New chat description
     */
    @Serializable
    @SerialName("chatEventDescriptionChanged")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventDescriptionChanged"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventDescriptionChanged(
        @SerialName("old_description")
        val oldDescription: String,
        @SerialName("new_description")
        val newDescription: String
    ) : ChatEventAction()

    /**
     * The chat username was changed
     *
     * @property oldUsername Previous chat username
     * @property newUsername New chat username
     */
    @Serializable
    @SerialName("chatEventUsernameChanged")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventUsernameChanged"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventUsernameChanged(
        @SerialName("old_username")
        val oldUsername: String,
        @SerialName("new_username")
        val newUsername: String
    ) : ChatEventAction()

    /**
     * The chat photo was changed
     *
     * @property oldPhoto Previous chat photo value
     * @property newPhoto New chat photo value
     */
    @Serializable
    @SerialName("chatEventPhotoChanged")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventPhotoChanged"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventPhotoChanged(
        @SerialName("old_photo")
        val oldPhoto: Photo?,
        @SerialName("new_photo")
        val newPhoto: Photo?
    ) : ChatEventAction()

    /**
     * The can_invite_users permission of a supergroup chat was toggled
     *
     * @property canInviteUsers New value of can_invite_users permission
     */
    @Serializable
    @SerialName("chatEventInvitesToggled")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventInvitesToggled"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventInvitesToggled(
        @SerialName("can_invite_users")
        val canInviteUsers: Boolean
    ) : ChatEventAction()

    /**
     * The sign_messages setting of a channel was toggled
     *
     * @property signMessages New value of sign_messages
     */
    @Serializable
    @SerialName("chatEventSignMessagesToggled")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventSignMessagesToggled"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventSignMessagesToggled(
        @SerialName("sign_messages")
        val signMessages: Boolean
    ) : ChatEventAction()

    /**
     * The supergroup sticker set was changed
     *
     * @property oldStickerSetId Previous identifier of the chat sticker set
     *                           0 if none
     * @property newStickerSetId New identifier of the chat sticker set
     *                           0 if none
     */
    @Serializable
    @SerialName("chatEventStickerSetChanged")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventStickerSetChanged"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventStickerSetChanged(
        @SerialName("old_sticker_set_id")
        val oldStickerSetId: Long,
        @SerialName("new_sticker_set_id")
        val newStickerSetId: Long
    ) : ChatEventAction()

    /**
     * The is_all_history_available setting of a supergroup was toggled
     *
     * @property isAllHistoryAvailable New value of is_all_history_available
     */
    @Serializable
    @SerialName("chatEventIsAllHistoryAvailableToggled")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventIsAllHistoryAvailableToggled"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventIsAllHistoryAvailableToggled(
        @SerialName("is_all_history_available")
        val isAllHistoryAvailable: Boolean
    ) : ChatEventAction()

    /**
     * Represents a chat event
     *
     * @property id Chat event identifier
     * @property date Point in time (Unix timestamp) when the event happened
     * @property userId Identifier of the user who performed the action that triggered the event
     * @property action Action performed by the user
     */
    @Serializable
    @SerialName("chatEvent")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEvent"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEvent(
        @SerialName("id")
        val id: Long,
        @SerialName("date")
        val date: Int,
        @SerialName("user_id")
        val userId: Int,
        @SerialName("action")
        val action: ChatEventAction
    ) : Object(), TdObject

    /**
     * Contains a list of chat events
     *
     * @property events List of events
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chatEvents")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEvents"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEvents(
        @SerialName("events")
        val events: Array<ChatEvent>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a set of filters used to obtain a chat event log
     *
     * @property messageEdits True, if message edits should be returned
     * @property messageDeletions True, if message deletions should be returned
     * @property messagePins True, if pin/unpin events should be returned
     * @property memberJoins True, if members joining events should be returned
     * @property memberLeaves True, if members leaving events should be returned
     * @property memberInvites True, if invited member events should be returned
     * @property memberPromotions True, if member promotion/demotion events should be returned
     * @property memberRestrictions True, if member restricted/unrestricted/banned/unbanned events should be returned
     * @property infoChanges True, if changes in chat information should be returned
     * @property settingChanges True, if changes in chat settings should be returned
     */
    @Serializable
    @SerialName("chatEventLogFilters")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventLogFilters"),
        level = DeprecationLevel.WARNING
    )
    data class ChatEventLogFilters(
        @SerialName("message_edits")
        val messageEdits: Boolean,
        @SerialName("message_deletions")
        val messageDeletions: Boolean,
        @SerialName("message_pins")
        val messagePins: Boolean,
        @SerialName("member_joins")
        val memberJoins: Boolean,
        @SerialName("member_leaves")
        val memberLeaves: Boolean,
        @SerialName("member_invites")
        val memberInvites: Boolean,
        @SerialName("member_promotions")
        val memberPromotions: Boolean,
        @SerialName("member_restrictions")
        val memberRestrictions: Boolean,
        @SerialName("info_changes")
        val infoChanges: Boolean,
        @SerialName("setting_changes")
        val settingChanges: Boolean
    ) : Object(), TdObject

    /**
     * Represents the value of a string in a language pack
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValue"),
        level = DeprecationLevel.WARNING
    )
    abstract class LanguagePackStringValue : Object(), TdResponse

    /**
     * An ordinary language pack string
     *
     * @property value String value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackStringValueOrdinary")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValueOrdinary"),
        level = DeprecationLevel.WARNING
    )
    data class LanguagePackStringValueOrdinary(
        @SerialName("value")
        val value: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : LanguagePackStringValue()

    /**
     * A language pack string which has different forms based on the number of some object it mentions
     * See https://www.unicode.org/cldr/charts/latest/supplemental/language_plural_rules.html for more info
     *
     * @property zeroValue Value for zero objects
     * @property oneValue Value for one object
     * @property twoValue Value for two objects
     * @property fewValue Value for few objects
     * @property manyValue Value for many objects
     * @property otherValue Default value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackStringValuePluralized")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValuePluralized"),
        level = DeprecationLevel.WARNING
    )
    data class LanguagePackStringValuePluralized(
        @SerialName("zero_value")
        val zeroValue: String,
        @SerialName("one_value")
        val oneValue: String,
        @SerialName("two_value")
        val twoValue: String,
        @SerialName("few_value")
        val fewValue: String,
        @SerialName("many_value")
        val manyValue: String,
        @SerialName("other_value")
        val otherValue: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : LanguagePackStringValue()

    /**
     * A deleted language pack string, the value should be taken from the built-in english language pack
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackStringValueDeleted")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValueDeleted"),
        level = DeprecationLevel.WARNING
    )
    data class LanguagePackStringValueDeleted(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : LanguagePackStringValue()

    /**
     * Represents one language pack string
     *
     * @property key String key
     * @property value String value
     */
    @Serializable
    @SerialName("languagePackString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackString"),
        level = DeprecationLevel.WARNING
    )
    data class LanguagePackString(
        @SerialName("key")
        val key: String,
        @SerialName("value")
        val value: LanguagePackStringValue
    ) : Object(), TdObject

    /**
     * Contains a list of language pack strings
     *
     * @property strings A list of language pack strings
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackStrings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStrings"),
        level = DeprecationLevel.WARNING
    )
    data class LanguagePackStrings(
        @SerialName("strings")
        val strings: Array<LanguagePackString>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about a language pack
     *
     * @property id Unique language pack identifier
     * @property baseLanguagePackId Identifier of a base language pack
     *                              If a string is missed in the language pack, then it should be fetched from base language pack
     *                              Unsupported in custom language packs
     * @property name Language name
     * @property nativeName Name of the language in that language
     * @property pluralCode A language code to be used to apply plural forms
     *                      See https://www.unicode.org/cldr/charts/latest/supplemental/language_plural_rules.html for more info
     * @property isOfficial True, if the language pack is official
     * @property isRtl True, if the language pack strings are RTL
     * @property isBeta True, if the language pack is a beta language pack
     * @property isInstalled True, if the language pack is installed by the current user
     * @property totalStringCount Total number of non-deleted strings from the language pack
     * @property translatedStringCount Total number of translated strings from the language pack
     * @property localStringCount Total number of non-deleted strings from the language pack available locally
     * @property translationUrl Link to language translation interface
     *                          Empty for custom local language packs
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("languagePackInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackInfo"),
        level = DeprecationLevel.WARNING
    )
    data class LanguagePackInfo(
        @SerialName("id")
        val id: String,
        @SerialName("base_language_pack_id")
        val baseLanguagePackId: String?,
        @SerialName("name")
        val name: String,
        @SerialName("native_name")
        val nativeName: String,
        @SerialName("plural_code")
        val pluralCode: String,
        @SerialName("is_official")
        val isOfficial: Boolean,
        @SerialName("is_rtl")
        val isRtl: Boolean,
        @SerialName("is_beta")
        val isBeta: Boolean,
        @SerialName("is_installed")
        val isInstalled: Boolean,
        @SerialName("total_string_count")
        val totalStringCount: Int,
        @SerialName("translated_string_count")
        val translatedStringCount: Int,
        @SerialName("local_string_count")
        val localStringCount: Int,
        @SerialName("translation_url")
        val translationUrl: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about the current localization target
     *
     * @property languagePacks List of available language packs for this application
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("localizationTargetInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLocalizationTargetInfo"),
        level = DeprecationLevel.WARNING
    )
    data class LocalizationTargetInfo(
        @SerialName("language_packs")
        val languagePacks: Array<LanguagePackInfo>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a data needed to subscribe for push notifications through registerDevice method
     * To use specific push notification service, you must specify the correct application platform and upload valid server authentication data at https://my.telegram.org
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken"),
        level = DeprecationLevel.WARNING
    )
    abstract class DeviceToken : Object(), TdObject

    /**
     * A token for Firebase Cloud Messaging
     *
     * @property token Device registration token
     *                 May be empty to de-register a device
     * @property encrypt True, if push notifications should be additionally encrypted
     */
    @Serializable
    @SerialName("deviceTokenFirebaseCloudMessaging")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenFirebaseCloudMessaging"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenFirebaseCloudMessaging(
        @SerialName("token")
        val token: String?,
        @SerialName("encrypt")
        val encrypt: Boolean
    ) : DeviceToken()

    /**
     * A token for Apple Push Notification service
     *
     * @property deviceToken Device token
     *                       May be empty to de-register a device
     * @property isAppSandbox True, if App Sandbox is enabled
     */
    @Serializable
    @SerialName("deviceTokenApplePush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenApplePush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenApplePush(
        @SerialName("device_token")
        val deviceToken: String?,
        @SerialName("is_app_sandbox")
        val isAppSandbox: Boolean
    ) : DeviceToken()

    /**
     * A token for Apple Push Notification service VoIP notifications
     *
     * @property deviceToken Device token
     *                       May be empty to de-register a device
     * @property isAppSandbox True, if App Sandbox is enabled
     * @property encrypt True, if push notifications should be additionally encrypted
     */
    @Serializable
    @SerialName("deviceTokenApplePushVoIP")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenApplePushVoIP"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenApplePushVoIP(
        @SerialName("device_token")
        val deviceToken: String?,
        @SerialName("is_app_sandbox")
        val isAppSandbox: Boolean,
        @SerialName("encrypt")
        val encrypt: Boolean
    ) : DeviceToken()

    /**
     * A token for Windows Push Notification Services
     *
     * @property accessToken The access token that will be used to send notifications
     *                       May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenWindowsPush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenWindowsPush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenWindowsPush(
        @SerialName("access_token")
        val accessToken: String?
    ) : DeviceToken()

    /**
     * A token for Microsoft Push Notification Service
     *
     * @property channelUri Push notification channel URI
     *                      May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenMicrosoftPush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenMicrosoftPush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenMicrosoftPush(
        @SerialName("channel_uri")
        val channelUri: String?
    ) : DeviceToken()

    /**
     * A token for Microsoft Push Notification Service VoIP channel
     *
     * @property channelUri Push notification channel URI
     *                      May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenMicrosoftPushVoIP")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenMicrosoftPushVoIP"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenMicrosoftPushVoIP(
        @SerialName("channel_uri")
        val channelUri: String?
    ) : DeviceToken()

    /**
     * A token for web Push API
     *
     * @property endpoint Absolute URL exposed by the push service where the application server can send push messages
     *                    May be empty to de-register a device
     * @property p256dhBase64url Base64url-encoded P-256 elliptic curve Diffie-Hellman public key
     * @property authBase64url Base64url-encoded authentication secret
     */
    @Serializable
    @SerialName("deviceTokenWebPush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenWebPush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenWebPush(
        @SerialName("endpoint")
        val endpoint: String?,
        @SerialName("p256dh_base64url")
        val p256dhBase64url: String,
        @SerialName("auth_base64url")
        val authBase64url: String
    ) : DeviceToken()

    /**
     * A token for Simple Push API for Firefox OS
     *
     * @property endpoint Absolute URL exposed by the push service where the application server can send push messages
     *                    May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenSimplePush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenSimplePush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenSimplePush(
        @SerialName("endpoint")
        val endpoint: String?
    ) : DeviceToken()

    /**
     * A token for Ubuntu Push Client service
     *
     * @property token Token
     *                 May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenUbuntuPush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenUbuntuPush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenUbuntuPush(
        @SerialName("token")
        val token: String?
    ) : DeviceToken()

    /**
     * A token for BlackBerry Push Service
     *
     * @property token Token
     *                 May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenBlackBerryPush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenBlackBerryPush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenBlackBerryPush(
        @SerialName("token")
        val token: String?
    ) : DeviceToken()

    /**
     * A token for Tizen Push Service
     *
     * @property regId Push service registration identifier
     *                 May be empty to de-register a device
     */
    @Serializable
    @SerialName("deviceTokenTizenPush")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceTokenTizenPush"),
        level = DeprecationLevel.WARNING
    )
    data class DeviceTokenTizenPush(
        @SerialName("reg_id")
        val regId: String?
    ) : DeviceToken()

    /**
     * Contains a globally unique push receiver identifier, which can be used to identify which account has received a push notification
     *
     * @property id The globally unique identifier of push notification subscription
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("pushReceiverId")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushReceiverId"),
        level = DeprecationLevel.WARNING
    )
    data class PushReceiverId(
        @SerialName("id")
        val id: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes a type of a background
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundType"),
        level = DeprecationLevel.WARNING
    )
    abstract class BackgroundType : Object(), TdObject

    /**
     * A wallpaper in JPEG format
     *
     * @property isBlurred True, if the wallpaper must be downscaled to fit in 450x450 square and then box-blurred with radius 12
     * @property isMoving True, if the background needs to be slightly moved when device is rotated
     */
    @Serializable
    @SerialName("backgroundTypeWallpaper")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundTypeWallpaper"),
        level = DeprecationLevel.WARNING
    )
    data class BackgroundTypeWallpaper(
        @SerialName("is_blurred")
        val isBlurred: Boolean,
        @SerialName("is_moving")
        val isMoving: Boolean
    ) : BackgroundType()

    /**
     * A PNG pattern to be combined with the color chosen by the user
     *
     * @property isMoving True, if the background needs to be slightly moved when device is rotated
     * @property color Main color of the background in RGB24 format
     * @property intensity Intensity of the pattern when it is shown above the main background color, 0-100
     */
    @Serializable
    @SerialName("backgroundTypePattern")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundTypePattern"),
        level = DeprecationLevel.WARNING
    )
    data class BackgroundTypePattern(
        @SerialName("is_moving")
        val isMoving: Boolean,
        @SerialName("color")
        val color: Int,
        @SerialName("intensity")
        val intensity: Int
    ) : BackgroundType()

    /**
     * A solid background
     *
     * @property color A color of the background in RGB24 format
     */
    @Serializable
    @SerialName("backgroundTypeSolid")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundTypeSolid"),
        level = DeprecationLevel.WARNING
    )
    data class BackgroundTypeSolid(
        @SerialName("color")
        val color: Int
    ) : BackgroundType()

    /**
     * Describes a chat background
     *
     * @property id Unique background identifier
     * @property isDefault True, if this is one of default backgrounds
     * @property isDark True, if the background is dark and is recommended to be used with dark theme
     * @property name Unique background name
     * @property document Document with the background
     *                    Null only for solid backgrounds
     * @property type Type of the background
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("background")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackground"),
        level = DeprecationLevel.WARNING
    )
    data class Background(
        @SerialName("id")
        val id: Long,
        @SerialName("is_default")
        val isDefault: Boolean,
        @SerialName("is_dark")
        val isDark: Boolean,
        @SerialName("name")
        val name: String,
        @SerialName("document")
        val document: Document?,
        @SerialName("type")
        val type: BackgroundType,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a list of backgrounds
     *
     * @property backgrounds A list of backgrounds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("backgrounds")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgrounds"),
        level = DeprecationLevel.WARNING
    )
    data class Backgrounds(
        @SerialName("backgrounds")
        val backgrounds: Array<Background>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about background to set
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputBackground"),
        level = DeprecationLevel.WARNING
    )
    abstract class InputBackground : Object(), TdObject

    /**
     * A background from a local file
     *
     * @property background Background file to use
     *                      Only inputFileLocal and inputFileGenerated are supported
     *                      The file nust be in JPEG format for wallpapers and in PNG format for patterns
     */
    @Serializable
    @SerialName("inputBackgroundLocal")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputBackgroundLocal"),
        level = DeprecationLevel.WARNING
    )
    data class InputBackgroundLocal(
        @SerialName("background")
        val background: InputFile
    ) : InputBackground()

    /**
     * A background from the server
     *
     * @property backgroundId The background identifier
     */
    @Serializable
    @SerialName("inputBackgroundRemote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputBackgroundRemote"),
        level = DeprecationLevel.WARNING
    )
    data class InputBackgroundRemote(
        @SerialName("background_id")
        val backgroundId: Long
    ) : InputBackground()

    /**
     * Contains a list of hashtags
     *
     * @property hashtags A list of hashtags
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("hashtags")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdHashtags"),
        level = DeprecationLevel.WARNING
    )
    data class Hashtags(
        @SerialName("hashtags")
        val hashtags: Array<String>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents result of checking whether a username can be set for a chat
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResult"),
        level = DeprecationLevel.WARNING
    )
    abstract class CheckChatUsernameResult : Object(), TdResponse

    /**
     * The username can be set
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultOk")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResultOk"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChatUsernameResultOk(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : CheckChatUsernameResult()

    /**
     * The username is invalid
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultUsernameInvalid")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResultUsernameInvalid"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChatUsernameResultUsernameInvalid(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : CheckChatUsernameResult()

    /**
     * The username is occupied
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultUsernameOccupied")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResultUsernameOccupied"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChatUsernameResultUsernameOccupied(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : CheckChatUsernameResult()

    /**
     * The user has too much chats with username, one of them should be made private first
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultPublicChatsTooMuch")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResultPublicChatsTooMuch"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChatUsernameResultPublicChatsTooMuch(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : CheckChatUsernameResult()

    /**
     * The user can't be a member of a public supergroup
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsernameResultPublicGroupsUnavailable")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResultPublicGroupsUnavailable"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChatUsernameResultPublicGroupsUnavailable(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : CheckChatUsernameResult()

    /**
     * Contains content of a push message notification
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent"),
        level = DeprecationLevel.WARNING
    )
    abstract class PushMessageContent : Object(), TdObject

    /**
     * A general message with hidden content
     *
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentHidden")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentHidden"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentHidden(
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @property animation Message content
     * @property caption Animation caption
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentAnimation(
        @SerialName("animation")
        val animation: Animation?,
        @SerialName("caption")
        val caption: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * An audio message
     *
     * @property audio Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentAudio"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentAudio(
        @SerialName("audio")
        val audio: Audio?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a user contact
     *
     * @property name Contact's name
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentContact")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentContact"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentContact(
        @SerialName("name")
        val name: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A contact has registered with Telegram
     */
    @Serializable
    @SerialName("pushMessageContentContactRegistered")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentContactRegistered"),
        level = DeprecationLevel.WARNING
    )
    object PushMessageContentContactRegistered : PushMessageContent()

    /**
     * A document message (a general file)
     *
     * @property document Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentDocument"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentDocument(
        @SerialName("document")
        val document: Document?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a game
     *
     * @property title Game title, empty for pinned game message
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentGame")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentGame"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentGame(
        @SerialName("title")
        val title: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A new high score was achieved in a game
     *
     * @property title Game title, empty for pinned message
     * @property score New score, 0 for pinned message
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentGameScore")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentGameScore"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentGameScore(
        @SerialName("title")
        val title: String,
        @SerialName("score")
        val score: Int,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with an invoice from a bot
     *
     * @property price Product price
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentInvoice")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentInvoice"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentInvoice(
        @SerialName("price")
        val price: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a location
     *
     * @property isLive True, if the location is live
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentLocation"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentLocation(
        @SerialName("is_live")
        val isLive: Boolean,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A photo message
     *
     * @property photo Message content
     * @property caption Photo caption
     * @property isSecret True, if the photo is secret
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentPhoto(
        @SerialName("photo")
        val photo: Photo?,
        @SerialName("caption")
        val caption: String,
        @SerialName("is_secret")
        val isSecret: Boolean,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a poll
     *
     * @property question Poll question
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentPoll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentPoll"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentPoll(
        @SerialName("question")
        val question: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A screenshot of a message in the chat has been taken
     */
    @Serializable
    @SerialName("pushMessageContentScreenshotTaken")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentScreenshotTaken"),
        level = DeprecationLevel.WARNING
    )
    object PushMessageContentScreenshotTaken : PushMessageContent()

    /**
     * A message with a sticker
     *
     * @property sticker Message content
     * @property emoji Emoji corresponding to the sticker
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentSticker"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentSticker(
        @SerialName("sticker")
        val sticker: Sticker?,
        @SerialName("emoji")
        val emoji: String?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A text message
     *
     * @property text Message text
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentText"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentText(
        @SerialName("text")
        val text: String,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A video message
     *
     * @property video Message content
     * @property caption Video caption
     * @property isSecret True, if the video is secret
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentVideo"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentVideo(
        @SerialName("video")
        val video: Video?,
        @SerialName("caption")
        val caption: String,
        @SerialName("is_secret")
        val isSecret: Boolean,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A video note message
     *
     * @property videoNote Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentVideoNote"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentVideoNote(
        @SerialName("video_note")
        val videoNote: VideoNote?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A voice note message
     *
     * @property voiceNote Message content
     * @property isPinned True, if the message is a pinned message with the specified content
     */
    @Serializable
    @SerialName("pushMessageContentVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentVoiceNote(
        @SerialName("voice_note")
        val voiceNote: VoiceNote?,
        @SerialName("is_pinned")
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A newly created basic group
     */
    @Serializable
    @SerialName("pushMessageContentBasicGroupChatCreate")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentBasicGroupChatCreate"),
        level = DeprecationLevel.WARNING
    )
    object PushMessageContentBasicGroupChatCreate : PushMessageContent()

    /**
     * New chat members were invited to a group
     *
     * @property memberName Name of the added member
     * @property isCurrentUser True, if the current user was added to the group
     * @property isReturned True, if the user has returned to the group himself
     */
    @Serializable
    @SerialName("pushMessageContentChatAddMembers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentChatAddMembers"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentChatAddMembers(
        @SerialName("member_name")
        val memberName: String,
        @SerialName("is_current_user")
        val isCurrentUser: Boolean,
        @SerialName("is_returned")
        val isReturned: Boolean
    ) : PushMessageContent()

    /**
     * A chat photo was edited
     */
    @Serializable
    @SerialName("pushMessageContentChatChangePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentChatChangePhoto"),
        level = DeprecationLevel.WARNING
    )
    object PushMessageContentChatChangePhoto : PushMessageContent()

    /**
     * A chat title was edited
     *
     * @property title New chat title
     */
    @Serializable
    @SerialName("pushMessageContentChatChangeTitle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentChatChangeTitle"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentChatChangeTitle(
        @SerialName("title")
        val title: String
    ) : PushMessageContent()

    /**
     * A chat member was deleted
     *
     * @property memberName Name of the deleted member
     * @property isCurrentUser True, if the current user was deleted from the group
     * @property isLeft True, if the user has left the group himself
     */
    @Serializable
    @SerialName("pushMessageContentChatDeleteMember")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentChatDeleteMember"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentChatDeleteMember(
        @SerialName("member_name")
        val memberName: String,
        @SerialName("is_current_user")
        val isCurrentUser: Boolean,
        @SerialName("is_left")
        val isLeft: Boolean
    ) : PushMessageContent()

    /**
     * A new member joined the chat by invite link
     */
    @Serializable
    @SerialName("pushMessageContentChatJoinByLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentChatJoinByLink"),
        level = DeprecationLevel.WARNING
    )
    object PushMessageContentChatJoinByLink : PushMessageContent()

    /**
     * A forwarded messages
     *
     * @property totalCount Number of forwarded messages
     */
    @Serializable
    @SerialName("pushMessageContentMessageForwards")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentMessageForwards"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentMessageForwards(
        @SerialName("total_count")
        val totalCount: Int
    ) : PushMessageContent()

    /**
     * A media album
     *
     * @property totalCount Number of messages in the album
     * @property hasPhotos True, if the album has at least one photo
     * @property hasVideos True, if the album has at least one video
     */
    @Serializable
    @SerialName("pushMessageContentMediaAlbum")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContentMediaAlbum"),
        level = DeprecationLevel.WARNING
    )
    data class PushMessageContentMediaAlbum(
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("has_photos")
        val hasPhotos: Boolean,
        @SerialName("has_videos")
        val hasVideos: Boolean
    ) : PushMessageContent()

    /**
     * Contains detailed information about a notification
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationType"),
        level = DeprecationLevel.WARNING
    )
    abstract class NotificationType : Object(), TdObject

    /**
     * New message was received
     *
     * @property message The message
     */
    @Serializable
    @SerialName("notificationTypeNewMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationTypeNewMessage"),
        level = DeprecationLevel.WARNING
    )
    data class NotificationTypeNewMessage(
        @SerialName("message")
        val message: Message
    ) : NotificationType()

    /**
     * New secret chat was created
     */
    @Serializable
    @SerialName("notificationTypeNewSecretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationTypeNewSecretChat"),
        level = DeprecationLevel.WARNING
    )
    object NotificationTypeNewSecretChat : NotificationType()

    /**
     * New call was received
     *
     * @property callId Call identifier
     */
    @Serializable
    @SerialName("notificationTypeNewCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationTypeNewCall"),
        level = DeprecationLevel.WARNING
    )
    data class NotificationTypeNewCall(
        @SerialName("call_id")
        val callId: Int
    ) : NotificationType()

    /**
     * New message was received through a push notification
     *
     * @property messageId The message identifier
     *                     The message will not be available in the chat history, but the ID can be used in viewMessages and as reply_to_message_id
     * @property senderUserId Sender of the message
     *                        Corresponding user may be inaccessible
     * @property content Push message content
     */
    @Serializable
    @SerialName("notificationTypeNewPushMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationTypeNewPushMessage"),
        level = DeprecationLevel.WARNING
    )
    data class NotificationTypeNewPushMessage(
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("content")
        val content: PushMessageContent
    ) : NotificationType()

    /**
     * Describes type of notifications in the group
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupType"),
        level = DeprecationLevel.WARNING
    )
    abstract class NotificationGroupType : Object(), TdObject

    /**
     * A group containing notifications of type notificationTypeNewMessage and notificationTypeNewPushMessage with ordinary unread messages
     */
    @Serializable
    @SerialName("notificationGroupTypeMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupTypeMessages"),
        level = DeprecationLevel.WARNING
    )
    object NotificationGroupTypeMessages : NotificationGroupType()

    /**
     * A group containing notifications of type notificationTypeNewMessage and notificationTypeNewPushMessage with unread mentions of the current user, replies to their messages, or a pinned message
     */
    @Serializable
    @SerialName("notificationGroupTypeMentions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupTypeMentions"),
        level = DeprecationLevel.WARNING
    )
    object NotificationGroupTypeMentions : NotificationGroupType()

    /**
     * A group containing a notification of type notificationTypeNewSecretChat
     */
    @Serializable
    @SerialName("notificationGroupTypeSecretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupTypeSecretChat"),
        level = DeprecationLevel.WARNING
    )
    object NotificationGroupTypeSecretChat : NotificationGroupType()

    /**
     * A group containing notifications of type notificationTypeNewCall
     */
    @Serializable
    @SerialName("notificationGroupTypeCalls")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupTypeCalls"),
        level = DeprecationLevel.WARNING
    )
    object NotificationGroupTypeCalls : NotificationGroupType()

    /**
     * Contains information about a notification
     *
     * @property id Unique persistent identifier of this notification
     * @property date Notification date
     * @property type Notification type
     */
    @Serializable
    @SerialName("notification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotification"),
        level = DeprecationLevel.WARNING
    )
    data class Notification(
        @SerialName("id")
        val id: Int,
        @SerialName("date")
        val date: Int,
        @SerialName("type")
        val type: NotificationType
    ) : Object(), TdObject

    /**
     * Describes a group of notifications
     *
     * @property id Unique persistent auto-incremented from 1 identifier of the notification group
     * @property type Type of the group
     * @property chatId Identifier of a chat to which all notifications in the group belong
     * @property totalCount Total number of active notifications in the group
     * @property notifications The list of active notifications
     */
    @Serializable
    @SerialName("notificationGroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroup"),
        level = DeprecationLevel.WARNING
    )
    data class NotificationGroup(
        @SerialName("id")
        val id: Int,
        @SerialName("type")
        val type: NotificationGroupType,
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("notifications")
        val notifications: Array<Notification>
    ) : Object(), TdObject

    /**
     * Represents the value of an option
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValue"),
        level = DeprecationLevel.WARNING
    )
    abstract class OptionValue : Object(), TdResponse

    /**
     * Represents a boolean option
     *
     * @property value The value of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueBoolean")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValueBoolean"),
        level = DeprecationLevel.WARNING
    )
    data class OptionValueBoolean(
        @SerialName("value")
        val value: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : OptionValue()

    /**
     * Represents an unknown option or an option which has a default value
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueEmpty")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValueEmpty"),
        level = DeprecationLevel.WARNING
    )
    data class OptionValueEmpty(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : OptionValue()

    /**
     * Represents an integer option
     *
     * @property value The value of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueInteger")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValueInteger"),
        level = DeprecationLevel.WARNING
    )
    data class OptionValueInteger(
        @SerialName("value")
        val value: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : OptionValue()

    /**
     * Represents a string option
     *
     * @property value The value of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optionValueString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValueString"),
        level = DeprecationLevel.WARNING
    )
    data class OptionValueString(
        @SerialName("value")
        val value: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : OptionValue()

    /**
     * Represents one member of a JSON object
     *
     * @property key Member's key
     * @property value Member's value
     */
    @Serializable
    @SerialName("jsonObjectMember")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonObjectMember"),
        level = DeprecationLevel.WARNING
    )
    data class JsonObjectMember(
        @SerialName("key")
        val key: String,
        @SerialName("value")
        val value: JsonValue
    ) : Object(), TdObject

    /**
     * Represents a JSON value
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue"),
        level = DeprecationLevel.WARNING
    )
    abstract class JsonValue : Object(), TdResponse

    /**
     * Represents a null JSON value
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueNull")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValueNull"),
        level = DeprecationLevel.WARNING
    )
    data class JsonValueNull(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : JsonValue()

    /**
     * Represents a boolean JSON value
     *
     * @property value The value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueBoolean")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValueBoolean"),
        level = DeprecationLevel.WARNING
    )
    data class JsonValueBoolean(
        @SerialName("value")
        val value: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : JsonValue()

    /**
     * Represents a numeric JSON value
     *
     * @property value The value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValueNumber"),
        level = DeprecationLevel.WARNING
    )
    data class JsonValueNumber(
        @SerialName("value")
        val value: Double,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : JsonValue()

    /**
     * Represents a string JSON value
     *
     * @property value The value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValueString"),
        level = DeprecationLevel.WARNING
    )
    data class JsonValueString(
        @SerialName("value")
        val value: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : JsonValue()

    /**
     * Represents a JSON array
     *
     * @property values The list of array elements
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueArray")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValueArray"),
        level = DeprecationLevel.WARNING
    )
    data class JsonValueArray(
        @SerialName("values")
        val values: Array<JsonValue>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : JsonValue()

    /**
     * Represents a JSON object
     *
     * @property members The list of object members
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("jsonValueObject")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValueObject"),
        level = DeprecationLevel.WARNING
    )
    data class JsonValueObject(
        @SerialName("members")
        val members: Array<JsonObjectMember>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : JsonValue()

    /**
     * Represents a single rule for managing privacy settings
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule"),
        level = DeprecationLevel.WARNING
    )
    abstract class UserPrivacySettingRule : Object(), TdObject

    /**
     * A rule to allow all users to do something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleAllowAll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRuleAllowAll"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingRuleAllowAll : UserPrivacySettingRule()

    /**
     * A rule to allow all of a user's contacts to do something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleAllowContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRuleAllowContacts"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingRuleAllowContacts : UserPrivacySettingRule()

    /**
     * A rule to allow certain specified users to do something
     *
     * @property userIds The user identifiers
     */
    @Serializable
    @SerialName("userPrivacySettingRuleAllowUsers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRuleAllowUsers"),
        level = DeprecationLevel.WARNING
    )
    data class UserPrivacySettingRuleAllowUsers(
        @SerialName("user_ids")
        val userIds: IntArray
    ) : UserPrivacySettingRule()

    /**
     * A rule to restrict all users from doing something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleRestrictAll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRuleRestrictAll"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingRuleRestrictAll : UserPrivacySettingRule()

    /**
     * A rule to restrict all contacts of a user from doing something
     */
    @Serializable
    @SerialName("userPrivacySettingRuleRestrictContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRuleRestrictContacts"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingRuleRestrictContacts : UserPrivacySettingRule()

    /**
     * A rule to restrict all specified users from doing something
     *
     * @property userIds The user identifiers
     */
    @Serializable
    @SerialName("userPrivacySettingRuleRestrictUsers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRuleRestrictUsers"),
        level = DeprecationLevel.WARNING
    )
    data class UserPrivacySettingRuleRestrictUsers(
        @SerialName("user_ids")
        val userIds: IntArray
    ) : UserPrivacySettingRule()

    /**
     * A list of privacy rules
     * Rules are matched in the specified order
     * The first matched rule defines the privacy setting for a given user
     * If no rule matches, the action is not allowed
     *
     * @property rules A list of rules
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("userPrivacySettingRules")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRules"),
        level = DeprecationLevel.WARNING
    )
    data class UserPrivacySettingRules(
        @SerialName("rules")
        val rules: Array<UserPrivacySettingRule>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes available user privacy settings
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting"),
        level = DeprecationLevel.WARNING
    )
    abstract class UserPrivacySetting : Object(), TdObject

    /**
     * A privacy setting for managing whether the user's online status is visible
     */
    @Serializable
    @SerialName("userPrivacySettingShowStatus")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingShowStatus"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingShowStatus : UserPrivacySetting()

    /**
     * A privacy setting for managing whether the user's profile photo is visible
     */
    @Serializable
    @SerialName("userPrivacySettingShowProfilePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingShowProfilePhoto"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingShowProfilePhoto : UserPrivacySetting()

    /**
     * A privacy setting for managing whether a link to the user's account is included in forwarded messages
     */
    @Serializable
    @SerialName("userPrivacySettingShowLinkInForwardedMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingShowLinkInForwardedMessages"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingShowLinkInForwardedMessages : UserPrivacySetting()

    /**
     * A privacy setting for managing whether the user can be invited to chats
     */
    @Serializable
    @SerialName("userPrivacySettingAllowChatInvites")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingAllowChatInvites"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingAllowChatInvites : UserPrivacySetting()

    /**
     * A privacy setting for managing whether the user can be called
     */
    @Serializable
    @SerialName("userPrivacySettingAllowCalls")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingAllowCalls"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingAllowCalls : UserPrivacySetting()

    /**
     * A privacy setting for managing whether peer-to-peer connections can be used for calls
     */
    @Serializable
    @SerialName("userPrivacySettingAllowPeerToPeerCalls")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingAllowPeerToPeerCalls"),
        level = DeprecationLevel.WARNING
    )
    object UserPrivacySettingAllowPeerToPeerCalls : UserPrivacySetting()

    /**
     * Contains information about the period of inactivity after which the current user's account will automatically be deleted
     *
     * @property days Number of days of inactivity before the account will be flagged for deletion
     *                Should range from 30-366 days
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("accountTtl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAccountTtl"),
        level = DeprecationLevel.WARNING
    )
    data class AccountTtl(
        @SerialName("days")
        val days: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about one session in a Telegram application used by the current user
     * Sessions should be shown to the user in the returned order
     *
     * @property id Session identifier
     * @property isCurrent True, if this session is the current session
     * @property isPasswordPending True, if a password is needed to complete authorization of the session
     * @property apiId Telegram API identifier, as provided by the application
     * @property applicationName Name of the application, as provided by the application
     * @property applicationVersion The version of the application, as provided by the application
     * @property isOfficialApplication True, if the application is an official application or uses the api_id of an official application
     * @property deviceModel Model of the device the application has been run or is running on, as provided by the application
     * @property platform Operating system the application has been run or is running on, as provided by the application
     * @property systemVersion Version of the operating system the application has been run or is running on, as provided by the application
     * @property logInDate Point in time (Unix timestamp) when the user has logged in
     * @property lastActiveDate Point in time (Unix timestamp) when the session was last used
     * @property ip IP address from which the session was created, in human-readable format
     * @property country A two-letter country code for the country from which the session was created, based on the IP address
     * @property region Region code from which the session was created, based on the IP address
     */
    @Serializable
    @SerialName("session")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSession"),
        level = DeprecationLevel.WARNING
    )
    data class Session(
        @SerialName("id")
        val id: Long,
        @SerialName("is_current")
        val isCurrent: Boolean,
        @SerialName("is_password_pending")
        val isPasswordPending: Boolean,
        @SerialName("api_id")
        val apiId: Int,
        @SerialName("application_name")
        val applicationName: String,
        @SerialName("application_version")
        val applicationVersion: String,
        @SerialName("is_official_application")
        val isOfficialApplication: Boolean,
        @SerialName("device_model")
        val deviceModel: String,
        @SerialName("platform")
        val platform: String,
        @SerialName("system_version")
        val systemVersion: String,
        @SerialName("log_in_date")
        val logInDate: Int,
        @SerialName("last_active_date")
        val lastActiveDate: Int,
        @SerialName("ip")
        val ip: String,
        @SerialName("country")
        val country: String,
        @SerialName("region")
        val region: String
    ) : Object(), TdObject

    /**
     * Contains a list of sessions
     *
     * @property sessions List of sessions
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sessions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSessions"),
        level = DeprecationLevel.WARNING
    )
    data class Sessions(
        @SerialName("sessions")
        val sessions: Array<Session>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about one website the current user is logged in with Telegram
     *
     * @property id Website identifier
     * @property domainName The domain name of the website
     * @property botUserId User identifier of a bot linked with the website
     * @property browser The version of a browser used to log in
     * @property platform Operating system the browser is running on
     * @property logInDate Point in time (Unix timestamp) when the user was logged in
     * @property lastActiveDate Point in time (Unix timestamp) when obtained authorization was last used
     * @property ip IP address from which the user was logged in, in human-readable format
     * @property location Human-readable description of a country and a region, from which the user was logged in, based on the IP address
     */
    @Serializable
    @SerialName("connectedWebsite")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectedWebsite"),
        level = DeprecationLevel.WARNING
    )
    data class ConnectedWebsite(
        @SerialName("id")
        val id: Long,
        @SerialName("domain_name")
        val domainName: String,
        @SerialName("bot_user_id")
        val botUserId: Int,
        @SerialName("browser")
        val browser: String,
        @SerialName("platform")
        val platform: String,
        @SerialName("log_in_date")
        val logInDate: Int,
        @SerialName("last_active_date")
        val lastActiveDate: Int,
        @SerialName("ip")
        val ip: String,
        @SerialName("location")
        val location: String
    ) : Object(), TdObject

    /**
     * Contains a list of websites the current user is logged in with Telegram
     *
     * @property websites List of connected websites
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("connectedWebsites")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectedWebsites"),
        level = DeprecationLevel.WARNING
    )
    data class ConnectedWebsites(
        @SerialName("websites")
        val websites: Array<ConnectedWebsite>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about the availability of the "Report spam" action for a chat
     *
     * @property canReportSpam True, if a prompt with the "Report spam" action should be shown to the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("chatReportSpamState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportSpamState"),
        level = DeprecationLevel.WARNING
    )
    data class ChatReportSpamState(
        @SerialName("can_report_spam")
        val canReportSpam: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes the reason why a chat is reported
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason"),
        level = DeprecationLevel.WARNING
    )
    abstract class ChatReportReason : Object(), TdObject

    /**
     * The chat contains spam messages
     */
    @Serializable
    @SerialName("chatReportReasonSpam")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReasonSpam"),
        level = DeprecationLevel.WARNING
    )
    object ChatReportReasonSpam : ChatReportReason()

    /**
     * The chat promotes violence
     */
    @Serializable
    @SerialName("chatReportReasonViolence")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReasonViolence"),
        level = DeprecationLevel.WARNING
    )
    object ChatReportReasonViolence : ChatReportReason()

    /**
     * The chat contains pornographic messages
     */
    @Serializable
    @SerialName("chatReportReasonPornography")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReasonPornography"),
        level = DeprecationLevel.WARNING
    )
    object ChatReportReasonPornography : ChatReportReason()

    /**
     * The chat has child abuse related content
     */
    @Serializable
    @SerialName("chatReportReasonChildAbuse")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReasonChildAbuse"),
        level = DeprecationLevel.WARNING
    )
    object ChatReportReasonChildAbuse : ChatReportReason()

    /**
     * The chat contains copyrighted content
     */
    @Serializable
    @SerialName("chatReportReasonCopyright")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReasonCopyright"),
        level = DeprecationLevel.WARNING
    )
    object ChatReportReasonCopyright : ChatReportReason()

    /**
     * A custom reason provided by the user
     *
     * @property text Report text
     */
    @Serializable
    @SerialName("chatReportReasonCustom")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReasonCustom"),
        level = DeprecationLevel.WARNING
    )
    data class ChatReportReasonCustom(
        @SerialName("text")
        val text: String
    ) : ChatReportReason()

    /**
     * Contains a public HTTPS link to a message in a public supergroup or channel with a username
     *
     * @property link Message link
     * @property html HTML-code for embedding the message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("publicMessageLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPublicMessageLink"),
        level = DeprecationLevel.WARNING
    )
    data class PublicMessageLink(
        @SerialName("link")
        val link: String,
        @SerialName("html")
        val html: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about a link to a message in a chat
     *
     * @property isPublic True, if the link is a public link for a message in a chat
     * @property chatId If found, identifier of the chat to which the message belongs, 0 otherwise
     * @property message If found, the linked message
     * @property forAlbum True, if the whole media album to which the message belongs is linked
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("messageLinkInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageLinkInfo"),
        level = DeprecationLevel.WARNING
    )
    data class MessageLinkInfo(
        @SerialName("is_public")
        val isPublic: Boolean,
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message")
        val message: Message?,
        @SerialName("for_album")
        val forAlbum: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a part of a file
     *
     * @property data File bytes
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("filePart")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFilePart"),
        level = DeprecationLevel.WARNING
    )
    data class FilePart(
        @SerialName("data")
        val data: ByteArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents the type of a file
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType"),
        level = DeprecationLevel.WARNING
    )
    abstract class FileType : Object(), TdObject

    /**
     * The data is not a file
     */
    @Serializable
    @SerialName("fileTypeNone")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeNone"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeNone : FileType()

    /**
     * The file is an animation
     */
    @Serializable
    @SerialName("fileTypeAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeAnimation"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeAnimation : FileType()

    /**
     * The file is an audio file
     */
    @Serializable
    @SerialName("fileTypeAudio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeAudio"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeAudio : FileType()

    /**
     * The file is a document
     */
    @Serializable
    @SerialName("fileTypeDocument")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeDocument"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeDocument : FileType()

    /**
     * The file is a photo
     */
    @Serializable
    @SerialName("fileTypePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypePhoto"),
        level = DeprecationLevel.WARNING
    )
    object FileTypePhoto : FileType()

    /**
     * The file is a profile photo
     */
    @Serializable
    @SerialName("fileTypeProfilePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeProfilePhoto"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeProfilePhoto : FileType()

    /**
     * The file was sent to a secret chat (the file type is not known to the server)
     */
    @Serializable
    @SerialName("fileTypeSecret")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeSecret"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeSecret : FileType()

    /**
     * The file is a thumbnail of a file from a secret chat
     */
    @Serializable
    @SerialName("fileTypeSecretThumbnail")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeSecretThumbnail"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeSecretThumbnail : FileType()

    /**
     * The file is a file from Secure storage used for storing Telegram Passport files
     */
    @Serializable
    @SerialName("fileTypeSecure")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeSecure"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeSecure : FileType()

    /**
     * The file is a sticker
     */
    @Serializable
    @SerialName("fileTypeSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeSticker"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeSticker : FileType()

    /**
     * The file is a thumbnail of another file
     */
    @Serializable
    @SerialName("fileTypeThumbnail")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeThumbnail"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeThumbnail : FileType()

    /**
     * The file type is not yet known
     */
    @Serializable
    @SerialName("fileTypeUnknown")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeUnknown"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeUnknown : FileType()

    /**
     * The file is a video
     */
    @Serializable
    @SerialName("fileTypeVideo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeVideo"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeVideo : FileType()

    /**
     * The file is a video note
     */
    @Serializable
    @SerialName("fileTypeVideoNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeVideoNote"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeVideoNote : FileType()

    /**
     * The file is a voice note
     */
    @Serializable
    @SerialName("fileTypeVoiceNote")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeVoiceNote"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeVoiceNote : FileType()

    /**
     * The file is a wallpaper or a background pattern
     */
    @Serializable
    @SerialName("fileTypeWallpaper")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileTypeWallpaper"),
        level = DeprecationLevel.WARNING
    )
    object FileTypeWallpaper : FileType()

    /**
     * Contains the storage usage statistics for a specific file type
     *
     * @property fileType File type
     * @property size Total size of the files
     * @property count Total number of files
     */
    @Serializable
    @SerialName("storageStatisticsByFileType")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatisticsByFileType"),
        level = DeprecationLevel.WARNING
    )
    data class StorageStatisticsByFileType(
        @SerialName("file_type")
        val fileType: FileType,
        @SerialName("size")
        val size: Long,
        @SerialName("count")
        val count: Int
    ) : Object(), TdObject

    /**
     * Contains the storage usage statistics for a specific chat
     *
     * @property chatId Chat identifier
     *                  0 if none
     * @property size Total size of the files in the chat
     * @property count Total number of files in the chat
     * @property byFileType Statistics split by file types
     */
    @Serializable
    @SerialName("storageStatisticsByChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatisticsByChat"),
        level = DeprecationLevel.WARNING
    )
    data class StorageStatisticsByChat(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("size")
        val size: Long,
        @SerialName("count")
        val count: Int,
        @SerialName("by_file_type")
        val byFileType: Array<StorageStatisticsByFileType>
    ) : Object(), TdObject

    /**
     * Contains the exact storage usage statistics split by chats and file type
     *
     * @property size Total size of files
     * @property count Total number of files
     * @property byChat Statistics split by chats
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("storageStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class StorageStatistics(
        @SerialName("size")
        val size: Long,
        @SerialName("count")
        val count: Int,
        @SerialName("by_chat")
        val byChat: Array<StorageStatisticsByChat>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

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
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatisticsFast"),
        level = DeprecationLevel.WARNING
    )
    data class StorageStatisticsFast(
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
    ) : Object(), TdResponse

    /**
     * Contains database statistics
     *
     * @property statistics Database statistics in an unspecified human-readable format
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("databaseStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDatabaseStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class DatabaseStatistics(
        @SerialName("statistics")
        val statistics: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents the type of a network
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkType"),
        level = DeprecationLevel.WARNING
    )
    abstract class NetworkType : Object(), TdObject

    /**
     * The network is not available
     */
    @Serializable
    @SerialName("networkTypeNone")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkTypeNone"),
        level = DeprecationLevel.WARNING
    )
    object NetworkTypeNone : NetworkType()

    /**
     * A mobile network
     */
    @Serializable
    @SerialName("networkTypeMobile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkTypeMobile"),
        level = DeprecationLevel.WARNING
    )
    object NetworkTypeMobile : NetworkType()

    /**
     * A mobile roaming network
     */
    @Serializable
    @SerialName("networkTypeMobileRoaming")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkTypeMobileRoaming"),
        level = DeprecationLevel.WARNING
    )
    object NetworkTypeMobileRoaming : NetworkType()

    /**
     * A Wi-Fi network
     */
    @Serializable
    @SerialName("networkTypeWiFi")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkTypeWiFi"),
        level = DeprecationLevel.WARNING
    )
    object NetworkTypeWiFi : NetworkType()

    /**
     * A different network type (e.g., Ethernet network)
     */
    @Serializable
    @SerialName("networkTypeOther")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkTypeOther"),
        level = DeprecationLevel.WARNING
    )
    object NetworkTypeOther : NetworkType()

    /**
     * Contains statistics about network usage
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatisticsEntry"),
        level = DeprecationLevel.WARNING
    )
    abstract class NetworkStatisticsEntry : Object(), TdObject

    /**
     * Contains information about the total amount of data that was used to send and receive files
     *
     * @property fileType Type of the file the data is part of
     * @property networkType Type of the network the data was sent through
     *                       Call setNetworkType to maintain the actual network type
     * @property sentBytes Total number of bytes sent
     * @property receivedBytes Total number of bytes received
     */
    @Serializable
    @SerialName("networkStatisticsEntryFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatisticsEntryFile"),
        level = DeprecationLevel.WARNING
    )
    data class NetworkStatisticsEntryFile(
        @SerialName("file_type")
        val fileType: FileType,
        @SerialName("network_type")
        val networkType: NetworkType,
        @SerialName("sent_bytes")
        val sentBytes: Long,
        @SerialName("received_bytes")
        val receivedBytes: Long
    ) : NetworkStatisticsEntry()

    /**
     * Contains information about the total amount of data that was used for calls
     *
     * @property networkType Type of the network the data was sent through
     *                       Call setNetworkType to maintain the actual network type
     * @property sentBytes Total number of bytes sent
     * @property receivedBytes Total number of bytes received
     * @property duration Total call duration, in seconds
     */
    @Serializable
    @SerialName("networkStatisticsEntryCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatisticsEntryCall"),
        level = DeprecationLevel.WARNING
    )
    data class NetworkStatisticsEntryCall(
        @SerialName("network_type")
        val networkType: NetworkType,
        @SerialName("sent_bytes")
        val sentBytes: Long,
        @SerialName("received_bytes")
        val receivedBytes: Long,
        @SerialName("duration")
        val duration: Double
    ) : NetworkStatisticsEntry()

    /**
     * A full list of available network statistic entries
     *
     * @property sinceDate Point in time (Unix timestamp) when the app began collecting statistics
     * @property entries Network statistics entries
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("networkStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class NetworkStatistics(
        @SerialName("since_date")
        val sinceDate: Int,
        @SerialName("entries")
        val entries: Array<NetworkStatisticsEntry>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains auto-download settings
     *
     * @property isAutoDownloadEnabled True, if the auto-download is enabled
     * @property maxPhotoFileSize Maximum size of a photo file to be auto-downloaded
     * @property maxVideoFileSize Maximum size of a video file to be auto-downloaded
     * @property maxOtherFileSize Maximum size of other file types to be auto-downloaded
     * @property preloadLargeVideos True, if the beginning of videos needs to be preloaded for instant playback
     * @property preloadNextAudio True, if the next audio track needs to be preloaded while the user is listening to an audio file
     * @property useLessDataForCalls True, if "use less data for calls" option needs to be enabled
     */
    @Serializable
    @SerialName("autoDownloadSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAutoDownloadSettings"),
        level = DeprecationLevel.WARNING
    )
    data class AutoDownloadSettings(
        @SerialName("is_auto_download_enabled")
        val isAutoDownloadEnabled: Boolean,
        @SerialName("max_photo_file_size")
        val maxPhotoFileSize: Int,
        @SerialName("max_video_file_size")
        val maxVideoFileSize: Int,
        @SerialName("max_other_file_size")
        val maxOtherFileSize: Int,
        @SerialName("preload_large_videos")
        val preloadLargeVideos: Boolean,
        @SerialName("preload_next_audio")
        val preloadNextAudio: Boolean,
        @SerialName("use_less_data_for_calls")
        val useLessDataForCalls: Boolean
    ) : Object(), TdObject

    /**
     * Contains auto-download settings presets for the user
     *
     * @property low Preset with lowest settings
     *               Supposed to be used by default when roaming
     * @property medium Preset with medium settings
     *                  Supposed to be used by default when using mobile data
     * @property high Preset with highest settings
     *                Supposed to be used by default when connected on Wi-Fi
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("autoDownloadSettingsPresets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAutoDownloadSettingsPresets"),
        level = DeprecationLevel.WARNING
    )
    data class AutoDownloadSettingsPresets(
        @SerialName("low")
        val low: AutoDownloadSettings,
        @SerialName("medium")
        val medium: AutoDownloadSettings,
        @SerialName("high")
        val high: AutoDownloadSettings,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes the current state of the connection to Telegram servers
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionState"),
        level = DeprecationLevel.WARNING
    )
    abstract class ConnectionState : Object(), TdObject

    /**
     * Currently waiting for the network to become available
     * Use setNetworkType to change the available network type
     */
    @Serializable
    @SerialName("connectionStateWaitingForNetwork")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionStateWaitingForNetwork"),
        level = DeprecationLevel.WARNING
    )
    object ConnectionStateWaitingForNetwork : ConnectionState()

    /**
     * Currently establishing a connection with a proxy server
     */
    @Serializable
    @SerialName("connectionStateConnectingToProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionStateConnectingToProxy"),
        level = DeprecationLevel.WARNING
    )
    object ConnectionStateConnectingToProxy : ConnectionState()

    /**
     * Currently establishing a connection to the Telegram servers
     */
    @Serializable
    @SerialName("connectionStateConnecting")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionStateConnecting"),
        level = DeprecationLevel.WARNING
    )
    object ConnectionStateConnecting : ConnectionState()

    /**
     * Downloading data received while the client was offline
     */
    @Serializable
    @SerialName("connectionStateUpdating")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionStateUpdating"),
        level = DeprecationLevel.WARNING
    )
    object ConnectionStateUpdating : ConnectionState()

    /**
     * There is a working connection to the Telegram servers
     */
    @Serializable
    @SerialName("connectionStateReady")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionStateReady"),
        level = DeprecationLevel.WARNING
    )
    object ConnectionStateReady : ConnectionState()

    /**
     * Represents the categories of chats for which a list of frequently used chats can be retrieved
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory"),
        level = DeprecationLevel.WARNING
    )
    abstract class TopChatCategory : Object(), TdObject

    /**
     * A category containing frequently used private chats with non-bot users
     */
    @Serializable
    @SerialName("topChatCategoryUsers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategoryUsers"),
        level = DeprecationLevel.WARNING
    )
    object TopChatCategoryUsers : TopChatCategory()

    /**
     * A category containing frequently used private chats with bot users
     */
    @Serializable
    @SerialName("topChatCategoryBots")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategoryBots"),
        level = DeprecationLevel.WARNING
    )
    object TopChatCategoryBots : TopChatCategory()

    /**
     * A category containing frequently used basic groups and supergroups
     */
    @Serializable
    @SerialName("topChatCategoryGroups")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategoryGroups"),
        level = DeprecationLevel.WARNING
    )
    object TopChatCategoryGroups : TopChatCategory()

    /**
     * A category containing frequently used channels
     */
    @Serializable
    @SerialName("topChatCategoryChannels")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategoryChannels"),
        level = DeprecationLevel.WARNING
    )
    object TopChatCategoryChannels : TopChatCategory()

    /**
     * A category containing frequently used chats with inline bots sorted by their usage in inline mode
     */
    @Serializable
    @SerialName("topChatCategoryInlineBots")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategoryInlineBots"),
        level = DeprecationLevel.WARNING
    )
    object TopChatCategoryInlineBots : TopChatCategory()

    /**
     * A category containing frequently used chats used for calls
     */
    @Serializable
    @SerialName("topChatCategoryCalls")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategoryCalls"),
        level = DeprecationLevel.WARNING
    )
    object TopChatCategoryCalls : TopChatCategory()

    /**
     * Describes the type of a URL linking to an internal Telegram entity
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlType"),
        level = DeprecationLevel.WARNING
    )
    abstract class TMeUrlType : Object(), TdObject

    /**
     * A URL linking to a user
     *
     * @property userId Identifier of the user
     */
    @Serializable
    @SerialName("tMeUrlTypeUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlTypeUser"),
        level = DeprecationLevel.WARNING
    )
    data class TMeUrlTypeUser(
        @SerialName("user_id")
        val userId: Int
    ) : TMeUrlType()

    /**
     * A URL linking to a public supergroup or channel
     *
     * @property supergroupId Identifier of the supergroup or channel
     */
    @Serializable
    @SerialName("tMeUrlTypeSupergroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlTypeSupergroup"),
        level = DeprecationLevel.WARNING
    )
    data class TMeUrlTypeSupergroup(
        @SerialName("supergroup_id")
        val supergroupId: Long
    ) : TMeUrlType()

    /**
     * A chat invite link
     *
     * @property info Chat invite link info
     */
    @Serializable
    @SerialName("tMeUrlTypeChatInvite")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlTypeChatInvite"),
        level = DeprecationLevel.WARNING
    )
    data class TMeUrlTypeChatInvite(
        @SerialName("info")
        val info: ChatInviteLinkInfo
    ) : TMeUrlType()

    /**
     * A URL linking to a sticker set
     *
     * @property stickerSetId Identifier of the sticker set
     */
    @Serializable
    @SerialName("tMeUrlTypeStickerSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlTypeStickerSet"),
        level = DeprecationLevel.WARNING
    )
    data class TMeUrlTypeStickerSet(
        @SerialName("sticker_set_id")
        val stickerSetId: Long
    ) : TMeUrlType()

    /**
     * Represents a URL linking to an internal Telegram entity
     *
     * @property url URL
     * @property type Type of the URL
     */
    @Serializable
    @SerialName("tMeUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrl"),
        level = DeprecationLevel.WARNING
    )
    data class TMeUrl(
        @SerialName("url")
        val url: String,
        @SerialName("type")
        val type: TMeUrlType
    ) : Object(), TdObject

    /**
     * Contains a list of t.me URLs
     *
     * @property urls List of URLs
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("tMeUrls")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrls"),
        level = DeprecationLevel.WARNING
    )
    data class TMeUrls(
        @SerialName("urls")
        val urls: Array<TMeUrl>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a counter
     *
     * @property count Count
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("count")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCount"),
        level = DeprecationLevel.WARNING
    )
    data class Count(
        @SerialName("count")
        val count: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains some text
     *
     * @property text Text
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("text")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdText"),
        level = DeprecationLevel.WARNING
    )
    data class Text(
        @SerialName("text")
        val text: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a value representing a number of seconds
     *
     * @property seconds Number of seconds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("seconds")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSeconds"),
        level = DeprecationLevel.WARNING
    )
    data class Seconds(
        @SerialName("seconds")
        val seconds: Double,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains information about a tg:// deep link
     *
     * @property text Text to be shown to the user
     * @property needUpdateApplication True, if user should be asked to update the application
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deepLinkInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeepLinkInfo"),
        level = DeprecationLevel.WARNING
    )
    data class DeepLinkInfo(
        @SerialName("text")
        val text: FormattedText,
        @SerialName("need_update_application")
        val needUpdateApplication: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes the way the text should be parsed for TextEntities
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextParseMode"),
        level = DeprecationLevel.WARNING
    )
    abstract class TextParseMode : Object(), TdObject

    /**
     * The text should be parsed in markdown-style
     */
    @Serializable
    @SerialName("textParseModeMarkdown")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextParseModeMarkdown"),
        level = DeprecationLevel.WARNING
    )
    object TextParseModeMarkdown : TextParseMode()

    /**
     * The text should be parsed in HTML-style
     */
    @Serializable
    @SerialName("textParseModeHTML")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextParseModeHTML"),
        level = DeprecationLevel.WARNING
    )
    object TextParseModeHTML : TextParseMode()

    /**
     * Describes the type of the proxy server
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyType"),
        level = DeprecationLevel.WARNING
    )
    abstract class ProxyType : Object(), TdObject

    /**
     * A SOCKS5 proxy server
     *
     * @property username Username for logging in
     * @property password Password for logging in
     */
    @Serializable
    @SerialName("proxyTypeSocks5")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyTypeSocks5"),
        level = DeprecationLevel.WARNING
    )
    data class ProxyTypeSocks5(
        @SerialName("username")
        val username: String?,
        @SerialName("password")
        val password: String?
    ) : ProxyType()

    /**
     * A HTTP transparent proxy server
     *
     * @property username Username for logging in
     * @property password Password for logging in
     * @property httpOnly Pass true, if the proxy supports only HTTP requests and doesn't support transparent TCP connections via HTTP CONNECT method
     */
    @Serializable
    @SerialName("proxyTypeHttp")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyTypeHttp"),
        level = DeprecationLevel.WARNING
    )
    data class ProxyTypeHttp(
        @SerialName("username")
        val username: String?,
        @SerialName("password")
        val password: String?,
        @SerialName("http_only")
        val httpOnly: Boolean
    ) : ProxyType()

    /**
     * An MTProto proxy server
     *
     * @property secret The proxy's secret in hexadecimal encoding
     */
    @Serializable
    @SerialName("proxyTypeMtproto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyTypeMtproto"),
        level = DeprecationLevel.WARNING
    )
    data class ProxyTypeMtproto(
        @SerialName("secret")
        val secret: String
    ) : ProxyType()

    /**
     * Contains information about a proxy server
     *
     * @property id Unique identifier of the proxy
     * @property server Proxy server IP address
     * @property port Proxy server port
     * @property lastUsedDate Point in time (Unix timestamp) when the proxy was last used
     *                        0 if never
     * @property isEnabled True, if the proxy is enabled now
     * @property type Type of the proxy
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("proxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxy"),
        level = DeprecationLevel.WARNING
    )
    data class Proxy(
        @SerialName("id")
        val id: Int,
        @SerialName("server")
        val server: String,
        @SerialName("port")
        val port: Int,
        @SerialName("last_used_date")
        val lastUsedDate: Int,
        @SerialName("is_enabled")
        val isEnabled: Boolean,
        @SerialName("type")
        val type: ProxyType,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Represents a list of proxy servers
     *
     * @property proxies List of proxy servers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("proxies")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxies"),
        level = DeprecationLevel.WARNING
    )
    data class Proxies(
        @SerialName("proxies")
        val proxies: Array<Proxy>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes a sticker that should be added to a sticker set
     *
     * @property pngSticker PNG image with the sticker
     *                      Must be up to 512 kB in size and fit in a 512x512 square
     * @property emojis Emoji corresponding to the sticker
     * @property maskPosition For masks, position where the mask should be placed
     */
    @Serializable
    @SerialName("inputSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputSticker"),
        level = DeprecationLevel.WARNING
    )
    data class InputSticker(
        @SerialName("png_sticker")
        val pngSticker: InputFile,
        @SerialName("emojis")
        val emojis: String,
        @SerialName("mask_position")
        val maskPosition: MaskPosition?
    ) : Object(), TdObject

    /**
     * Contains notifications about data changes
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdate"),
        level = DeprecationLevel.WARNING
    )
    abstract class Update : Object(), TdUpdate, TdResponse

    /**
     * The user authorization state has changed
     *
     * @property authorizationState New authorization state
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateAuthorizationState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateAuthorizationState"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateAuthorizationState(
        @SerialName("authorization_state")
        val authorizationState: AuthorizationState,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new message was received
     * Can also be an outgoing message
     *
     * @property message The new message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewMessage"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateNewMessage(
        @SerialName("message")
        val message: Message,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A request to send a message has reached the Telegram server
     * This doesn't mean that the message will be sent successfully or even that the send message request will be processed
     * This update will be sent only if the option "use_quick_ack" is set to true
     * This update may be sent multiple times for the same message
     *
     * @property chatId The chat identifier of the sent message
     * @property messageId A temporary message identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageSendAcknowledged")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageSendAcknowledged"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageSendAcknowledged(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A message has been successfully sent
     *
     * @property message Information about the sent message
     *                   Usually only the message identifier, date, and content are changed, but almost all other fields can also change
     * @property oldMessageId The previous temporary message identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageSendSucceeded")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageSendSucceeded"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageSendSucceeded(
        @SerialName("message")
        val message: Message,
        @SerialName("old_message_id")
        val oldMessageId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A message failed to send
     * Be aware that some messages being sent can be irrecoverably deleted, in which case updateDeleteMessages will be received instead of this update
     *
     * @property message Contains information about the message which failed to send
     * @property oldMessageId The previous temporary message identifier
     * @property errorCode An error code
     * @property errorMessage Error message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageSendFailed")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageSendFailed"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageSendFailed(
        @SerialName("message")
        val message: Message,
        @SerialName("old_message_id")
        val oldMessageId: Long,
        @SerialName("error_code")
        val errorCode: Int,
        @SerialName("error_message")
        val errorMessage: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The message content has changed
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property newContent New message content
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageContent")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageContent"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageContent(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("new_content")
        val newContent: MessageContent,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A message was edited
     * Changes in the message content will come in a separate updateMessageContent
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property editDate Point in time (Unix timestamp) when the message was edited
     * @property replyMarkup New message reply markup
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageEdited")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageEdited"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageEdited(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("edit_date")
        val editDate: Int,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The view count of the message has changed
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property views New value of the view count
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageViews")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageViews"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageViews(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("views")
        val views: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The message content was opened
     * Updates voice note messages to "listened", video note messages to "viewed" and starts the TTL timer for self-destructing messages
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageContentOpened")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageContentOpened"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageContentOpened(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A message with an unread mention was read
     *
     * @property chatId Chat identifier
     * @property messageId Message identifier
     * @property unreadMentionCount The new number of unread mention messages left in the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateMessageMentionRead")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessageMentionRead"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateMessageMentionRead(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("unread_mention_count")
        val unreadMentionCount: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new chat has been loaded/created
     * This update is guaranteed to come before the chat identifier is returned to the client
     * The chat field changes will be reported through separate updates
     *
     * @property chat The chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewChat"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateNewChat(
        @SerialName("chat")
        val chat: Chat,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The title of a chat was changed
     *
     * @property chatId Chat identifier
     * @property title The new chat title
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatTitle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatTitle"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatTitle(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("title")
        val title: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A chat photo was changed
     *
     * @property chatId Chat identifier
     * @property photo The new chat photo
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatPhoto(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("photo")
        val photo: ChatPhoto?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Chat permissions was changed
     *
     * @property chatId Chat identifier
     * @property permissions The new chat permissions
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatPermissions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatPermissions"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatPermissions(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("permissions")
        val permissions: ChatPermissions,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The last message of a chat was changed
     * If last_message is null then the last message in the chat became unknown
     * Some new unknown messages might be added to the chat in this case
     *
     * @property chatId Chat identifier
     * @property lastMessage The new last message in the chat
     * @property order New value of the chat order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatLastMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatLastMessage"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatLastMessage(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("last_message")
        val lastMessage: Message?,
        @SerialName("order")
        val order: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The order of the chat in the chat list has changed
     * Instead of this update updateChatLastMessage, updateChatIsPinned or updateChatDraftMessage might be sent
     *
     * @property chatId Chat identifier
     * @property order New value of the order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatOrder")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatOrder"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatOrder(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("order")
        val order: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A chat was pinned or unpinned
     *
     * @property chatId Chat identifier
     * @property isPinned New value of is_pinned
     * @property order New value of the chat order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatIsPinned")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatIsPinned"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatIsPinned(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("is_pinned")
        val isPinned: Boolean,
        @SerialName("order")
        val order: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A chat was marked as unread or was read
     *
     * @property chatId Chat identifier
     * @property isMarkedAsUnread New value of is_marked_as_unread
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatIsMarkedAsUnread")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatIsMarkedAsUnread"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatIsMarkedAsUnread(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("is_marked_as_unread")
        val isMarkedAsUnread: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A chat's is_sponsored field has changed
     *
     * @property chatId Chat identifier
     * @property isSponsored New value of is_sponsored
     * @property order New value of chat order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatIsSponsored")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatIsSponsored"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatIsSponsored(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("is_sponsored")
        val isSponsored: Boolean,
        @SerialName("order")
        val order: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The value of the default disable_notification parameter, used when a message is sent to the chat, was changed
     *
     * @property chatId Chat identifier
     * @property defaultDisableNotification The new default_disable_notification value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatDefaultDisableNotification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatDefaultDisableNotification"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatDefaultDisableNotification(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("default_disable_notification")
        val defaultDisableNotification: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Incoming messages were read or number of unread messages has been changed
     *
     * @property chatId Chat identifier
     * @property lastReadInboxMessageId Identifier of the last read incoming message
     * @property unreadCount The number of unread messages left in the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatReadInbox")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatReadInbox"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatReadInbox(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("last_read_inbox_message_id")
        val lastReadInboxMessageId: Long,
        @SerialName("unread_count")
        val unreadCount: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Outgoing messages were read
     *
     * @property chatId Chat identifier
     * @property lastReadOutboxMessageId Identifier of last read outgoing message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatReadOutbox")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatReadOutbox"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatReadOutbox(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("last_read_outbox_message_id")
        val lastReadOutboxMessageId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The chat unread_mention_count has changed
     *
     * @property chatId Chat identifier
     * @property unreadMentionCount The number of unread mention messages left in the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatUnreadMentionCount")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatUnreadMentionCount"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatUnreadMentionCount(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("unread_mention_count")
        val unreadMentionCount: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Notification settings for a chat were changed
     *
     * @property chatId Chat identifier
     * @property notificationSettings The new notification settings
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatNotificationSettings(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("notification_settings")
        val notificationSettings: ChatNotificationSettings,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Notification settings for some type of chats were updated
     *
     * @property scope Types of chats for which notification settings were updated
     * @property notificationSettings The new notification settings
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateScopeNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateScopeNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateScopeNotificationSettings(
        @SerialName("scope")
        val scope: NotificationSettingsScope,
        @SerialName("notification_settings")
        val notificationSettings: ScopeNotificationSettings,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The chat pinned message was changed
     *
     * @property chatId Chat identifier
     * @property pinnedMessageId The new identifier of the pinned message
     *                           0 if there is no pinned message in the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatPinnedMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatPinnedMessage"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatPinnedMessage(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("pinned_message_id")
        val pinnedMessageId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The default chat reply markup was changed
     * Can occur because new messages with reply markup were received or because an old reply markup was hidden by the user
     *
     * @property chatId Chat identifier
     * @property replyMarkupMessageId Identifier of the message from which reply markup needs to be used
     *                                0 if there is no default custom reply markup in the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatReplyMarkup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatReplyMarkup"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatReplyMarkup(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("reply_markup_message_id")
        val replyMarkupMessageId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A chat draft has changed
     * Be aware that the update may come in the currently opened chat but with old content of the draft
     * If the user has changed the content of the draft, this update shouldn't be applied
     *
     * @property chatId Chat identifier
     * @property draftMessage The new draft message
     * @property order New value of the chat order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatDraftMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatDraftMessage"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatDraftMessage(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("draft_message")
        val draftMessage: DraftMessage?,
        @SerialName("order")
        val order: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The number of online group members has changed
     * This update with non-zero count is sent only for currently opened chats
     * There is no guarantee that it will be sent just after the count has changed
     *
     * @property chatId Identifier of the chat
     * @property onlineMemberCount New number of online members in the chat, or 0 if unknown
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateChatOnlineMemberCount")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChatOnlineMemberCount"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateChatOnlineMemberCount(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("online_member_count")
        val onlineMemberCount: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A notification was changed
     *
     * @property notificationGroupId Unique notification group identifier
     * @property notification Changed notification
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNotification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNotification"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateNotification(
        @SerialName("notification_group_id")
        val notificationGroupId: Int,
        @SerialName("notification")
        val notification: Notification,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A list of active notifications in a notification group has changed
     *
     * @property notificationGroupId Unique notification group identifier
     * @property type New type of the notification group
     * @property chatId Identifier of a chat to which all notifications in the group belong
     * @property notificationSettingsChatId Chat identifier, which notification settings must be applied to the added notifications
     * @property isSilent True, if the notifications should be shown without sound
     * @property totalCount Total number of unread notifications in the group, can be bigger than number of active notifications
     * @property addedNotifications List of added group notifications, sorted by notification ID
     * @property removedNotificationIds Identifiers of removed group notifications, sorted by notification ID
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNotificationGroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNotificationGroup"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateNotificationGroup(
        @SerialName("notification_group_id")
        val notificationGroupId: Int,
        @SerialName("type")
        val type: NotificationGroupType,
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("notification_settings_chat_id")
        val notificationSettingsChatId: Long,
        @SerialName("is_silent")
        val isSilent: Boolean,
        @SerialName("total_count")
        val totalCount: Int,
        @SerialName("added_notifications")
        val addedNotifications: Array<Notification>,
        @SerialName("removed_notification_ids")
        val removedNotificationIds: IntArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Contains active notifications that was shown on previous application launches
     * This update is sent only if a message database is used
     * In that case it comes once before any updateNotification and updateNotificationGroup update
     *
     * @property groups Lists of active notification groups
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateActiveNotifications")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateActiveNotifications"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateActiveNotifications(
        @SerialName("groups")
        val groups: Array<NotificationGroup>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Describes, whether there are some pending notification updates
     * Can be used to prevent application from killing, while there are some pending notifications
     *
     * @property haveDelayedNotifications True, if there are some delayed notification updates, which will be sent soon
     * @property haveUnreceivedNotifications True, if there can be some yet unreceived notifications, which are being fetched from the server
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateHavePendingNotifications")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateHavePendingNotifications"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateHavePendingNotifications(
        @SerialName("have_delayed_notifications")
        val haveDelayedNotifications: Boolean,
        @SerialName("have_unreceived_notifications")
        val haveUnreceivedNotifications: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some messages were deleted
     *
     * @property chatId Chat identifier
     * @property messageIds Identifiers of the deleted messages
     * @property isPermanent True, if the messages are permanently deleted by a user (as opposed to just becoming inaccessible)
     * @property fromCache True, if the messages are deleted only from the cache and can possibly be retrieved again in the future
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateDeleteMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateDeleteMessages"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateDeleteMessages(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_ids")
        val messageIds: LongArray,
        @SerialName("is_permanent")
        val isPermanent: Boolean,
        @SerialName("from_cache")
        val fromCache: Boolean,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * User activity in the chat has changed
     *
     * @property chatId Chat identifier
     * @property userId Identifier of a user performing an action
     * @property action The action description
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateUserChatAction")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUserChatAction"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateUserChatAction(
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("user_id")
        val userId: Int,
        @SerialName("action")
        val action: ChatAction,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The user went online or offline
     *
     * @property userId User identifier
     * @property status New status of the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateUserStatus")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUserStatus"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateUserStatus(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("status")
        val status: UserStatus,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some data of a user has changed
     * This update is guaranteed to come before the user identifier is returned to the client
     *
     * @property user New data about the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUser"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateUser(
        @SerialName("user")
        val user: User,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some data of a basic group has changed
     * This update is guaranteed to come before the basic group identifier is returned to the client
     *
     * @property basicGroup New data about the group
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateBasicGroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateBasicGroup"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateBasicGroup(
        @SerialName("basic_group")
        val basicGroup: BasicGroup,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some data of a supergroup or a channel has changed
     * This update is guaranteed to come before the supergroup identifier is returned to the client
     *
     * @property supergroup New data about the supergroup
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateSupergroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSupergroup"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateSupergroup(
        @SerialName("supergroup")
        val supergroup: Supergroup,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some data of a secret chat has changed
     * This update is guaranteed to come before the secret chat identifier is returned to the client
     *
     * @property secretChat New data about the secret chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateSecretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSecretChat"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateSecretChat(
        @SerialName("secret_chat")
        val secretChat: SecretChat,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some data from userFullInfo has been changed
     *
     * @property userId User identifier
     * @property userFullInfo New full information about the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateUserFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUserFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateUserFullInfo(
        @SerialName("user_id")
        val userId: Int,
        @SerialName("user_full_info")
        val userFullInfo: UserFullInfo,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some data from basicGroupFullInfo has been changed
     *
     * @property basicGroupId Identifier of a basic group
     * @property basicGroupFullInfo New full information about the group
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateBasicGroupFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateBasicGroupFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateBasicGroupFullInfo(
        @SerialName("basic_group_id")
        val basicGroupId: Int,
        @SerialName("basic_group_full_info")
        val basicGroupFullInfo: BasicGroupFullInfo,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some data from supergroupFullInfo has been changed
     *
     * @property supergroupId Identifier of the supergroup or channel
     * @property supergroupFullInfo New full information about the supergroup
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateSupergroupFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSupergroupFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateSupergroupFullInfo(
        @SerialName("supergroup_id")
        val supergroupId: Int,
        @SerialName("supergroup_full_info")
        val supergroupFullInfo: SupergroupFullInfo,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Service notification from the server
     * Upon receiving this the client must show a popup with the content of the notification
     *
     * @property type Notification type
     *                If type begins with "AUTH_KEY_DROP_", then two buttons "Cancel" and "Log out" should be shown under notification
     *                If user presses the second, all local data should be destroyed using Destroy method
     * @property content Notification content
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateServiceNotification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateServiceNotification"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateServiceNotification(
        @SerialName("type")
        val type: String,
        @SerialName("content")
        val content: MessageContent,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Information about a file was updated
     *
     * @property file New data about the file
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFile"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateFile(
        @SerialName("file")
        val file: File,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The file generation process needs to be started by the client
     *
     * @property generationId Unique identifier for the generation process
     * @property originalPath The path to a file from which a new file is generated
     * @property destinationPath The path to a file that should be created and where the new file should be generated
     * @property conversion String specifying the conversion applied to the original file
     *                      If conversion is "#url#" than original_path contains an HTTP/HTTPS URL of a file, which should be downloaded by the client
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateFileGenerationStart")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFileGenerationStart"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateFileGenerationStart(
        @SerialName("generation_id")
        val generationId: Long,
        @SerialName("original_path")
        val originalPath: String?,
        @SerialName("destination_path")
        val destinationPath: String,
        @SerialName("conversion")
        val conversion: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * File generation is no longer needed
     *
     * @property generationId Unique identifier for the generation process
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateFileGenerationStop")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFileGenerationStop"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateFileGenerationStop(
        @SerialName("generation_id")
        val generationId: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * New call was created or information about a call was updated
     *
     * @property call New data about a call
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateCall"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateCall(
        @SerialName("call")
        val call: Call,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some privacy setting rules have been changed
     *
     * @property setting The privacy setting
     * @property rules New privacy rules
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateUserPrivacySettingRules")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUserPrivacySettingRules"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateUserPrivacySettingRules(
        @SerialName("setting")
        val setting: UserPrivacySetting,
        @SerialName("rules")
        val rules: UserPrivacySettingRules,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Number of unread messages has changed
     * This update is sent only if a message database is used
     *
     * @property unreadCount Total number of unread messages
     * @property unreadUnmutedCount Total number of unread messages in unmuted chats
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateUnreadMessageCount")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUnreadMessageCount"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateUnreadMessageCount(
        @SerialName("unread_count")
        val unreadCount: Int,
        @SerialName("unread_unmuted_count")
        val unreadUnmutedCount: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Number of unread chats, i.e
     * With unread messages or marked as unread, has changed
     * This update is sent only if a message database is used
     *
     * @property unreadCount Total number of unread chats
     * @property unreadUnmutedCount Total number of unread unmuted chats
     * @property markedAsUnreadCount Total number of chats marked as unread
     * @property markedAsUnreadUnmutedCount Total number of unmuted chats marked as unread
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateUnreadChatCount")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUnreadChatCount"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateUnreadChatCount(
        @SerialName("unread_count")
        val unreadCount: Int,
        @SerialName("unread_unmuted_count")
        val unreadUnmutedCount: Int,
        @SerialName("marked_as_unread_count")
        val markedAsUnreadCount: Int,
        @SerialName("marked_as_unread_unmuted_count")
        val markedAsUnreadUnmutedCount: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * An option changed its value
     *
     * @property name The option name
     * @property value The new option value
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateOption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateOption"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateOption(
        @SerialName("name")
        val name: String,
        @SerialName("value")
        val value: OptionValue,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The list of installed sticker sets was updated
     *
     * @property isMasks True, if the list of installed mask sticker sets was updated
     * @property stickerSetIds The new list of installed ordinary sticker sets
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateInstalledStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateInstalledStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateInstalledStickerSets(
        @SerialName("is_masks")
        val isMasks: Boolean,
        @SerialName("sticker_set_ids")
        val stickerSetIds: LongArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The list of trending sticker sets was updated or some of them were viewed
     *
     * @property stickerSets The new list of trending sticker sets
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateTrendingStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateTrendingStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateTrendingStickerSets(
        @SerialName("sticker_sets")
        val stickerSets: StickerSets,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The list of recently used stickers was updated
     *
     * @property isAttached True, if the list of stickers attached to photo or video files was updated, otherwise the list of sent stickers is updated
     * @property stickerIds The new list of file identifiers of recently used stickers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateRecentStickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateRecentStickers"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateRecentStickers(
        @SerialName("is_attached")
        val isAttached: Boolean,
        @SerialName("sticker_ids")
        val stickerIds: IntArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The list of favorite stickers was updated
     *
     * @property stickerIds The new list of file identifiers of favorite stickers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateFavoriteStickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFavoriteStickers"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateFavoriteStickers(
        @SerialName("sticker_ids")
        val stickerIds: IntArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The list of saved animations was updated
     *
     * @property animationIds The new list of file identifiers of saved animations
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateSavedAnimations")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSavedAnimations"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateSavedAnimations(
        @SerialName("animation_ids")
        val animationIds: IntArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The selected background has changed
     *
     * @property forDarkTheme True, if background for dark theme has changed
     * @property background The new selected background
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateSelectedBackground")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSelectedBackground"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateSelectedBackground(
        @SerialName("for_dark_theme")
        val forDarkTheme: Boolean,
        @SerialName("background")
        val background: Background?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Some language pack strings have been updated
     *
     * @property localizationTarget Localization target to which the language pack belongs
     * @property languagePackId Identifier of the updated language pack
     * @property strings List of changed language pack strings
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateLanguagePackStrings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateLanguagePackStrings"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateLanguagePackStrings(
        @SerialName("localization_target")
        val localizationTarget: String,
        @SerialName("language_pack_id")
        val languagePackId: String,
        @SerialName("strings")
        val strings: Array<LanguagePackString>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The connection state has changed
     *
     * @property state The new connection state
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateConnectionState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateConnectionState"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateConnectionState(
        @SerialName("state")
        val state: ConnectionState,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * New terms of service must be accepted by the user
     * If the terms of service are declined, then the deleteAccount method should be called with the reason "Decline ToS update"
     *
     * @property termsOfServiceId Identifier of the terms of service
     * @property termsOfService The new terms of service
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateTermsOfService")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateTermsOfService"),
        level = DeprecationLevel.WARNING
    )
    data class UpdateTermsOfService(
        @SerialName("terms_of_service_id")
        val termsOfServiceId: String,
        @SerialName("terms_of_service")
        val termsOfService: TermsOfService,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new incoming inline query
     *
     * @property id Unique query identifier
     * @property senderUserId Identifier of the user who sent the query
     * @property userLocation User location, provided by the client
     * @property query Text of the query
     * @property offset Offset of the first entry to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewInlineQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewInlineQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewInlineQuery(
        @SerialName("id")
        val id: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("user_location")
        val userLocation: Location?,
        @SerialName("query")
        val query: String,
        @SerialName("offset")
        val offset: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * The user has chosen a result of an inline query
     *
     * @property senderUserId Identifier of the user who sent the query
     * @property userLocation User location, provided by the client
     * @property query Text of the query
     * @property resultId Identifier of the chosen result
     * @property inlineMessageId Identifier of the sent inline message, if known
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewChosenInlineResult")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewChosenInlineResult"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewChosenInlineResult(
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("user_location")
        val userLocation: Location?,
        @SerialName("query")
        val query: String,
        @SerialName("result_id")
        val resultId: String,
        @SerialName("inline_message_id")
        val inlineMessageId: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new incoming callback query
     *
     * @property id Unique query identifier
     * @property senderUserId Identifier of the user who sent the query
     * @property chatId Identifier of the chat, in which the query was sent
     * @property messageId Identifier of the message, from which the query originated
     * @property chatInstance Identifier that uniquely corresponds to the chat to which the message was sent
     * @property payload Query payload
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewCallbackQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewCallbackQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewCallbackQuery(
        @SerialName("id")
        val id: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("chat_id")
        val chatId: Long,
        @SerialName("message_id")
        val messageId: Long,
        @SerialName("chat_instance")
        val chatInstance: Long,
        @SerialName("payload")
        val payload: CallbackQueryPayload,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new incoming callback query from a message sent via a bot
     *
     * @property id Unique query identifier
     * @property senderUserId Identifier of the user who sent the query
     * @property inlineMessageId Identifier of the inline message, from which the query originated
     * @property chatInstance An identifier uniquely corresponding to the chat a message was sent to
     * @property payload Query payload
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewInlineCallbackQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewInlineCallbackQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewInlineCallbackQuery(
        @SerialName("id")
        val id: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("inline_message_id")
        val inlineMessageId: String,
        @SerialName("chat_instance")
        val chatInstance: Long,
        @SerialName("payload")
        val payload: CallbackQueryPayload,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new incoming shipping query
     * Only for invoices with flexible price
     *
     * @property id Unique query identifier
     * @property senderUserId Identifier of the user who sent the query
     * @property invoicePayload Invoice payload
     * @property shippingAddress User shipping address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewShippingQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewShippingQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewShippingQuery(
        @SerialName("id")
        val id: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("invoice_payload")
        val invoicePayload: String,
        @SerialName("shipping_address")
        val shippingAddress: Address,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new incoming pre-checkout query
     * Contains full information about a checkout
     *
     * @property id Unique query identifier
     * @property senderUserId Identifier of the user who sent the query
     * @property currency Currency for the product price
     * @property totalAmount Total price for the product, in the minimal quantity of the currency
     * @property invoicePayload Invoice payload
     * @property shippingOptionId Identifier of a shipping option chosen by the user
     *                            May be empty if not applicable
     * @property orderInfo Information about the order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewPreCheckoutQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewPreCheckoutQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewPreCheckoutQuery(
        @SerialName("id")
        val id: Long,
        @SerialName("sender_user_id")
        val senderUserId: Int,
        @SerialName("currency")
        val currency: String,
        @SerialName("total_amount")
        val totalAmount: Long,
        @SerialName("invoice_payload")
        val invoicePayload: ByteArray,
        @SerialName("shipping_option_id")
        val shippingOptionId: String?,
        @SerialName("order_info")
        val orderInfo: OrderInfo?,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new incoming event
     *
     * @property event A JSON-serialized event
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewCustomEvent")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewCustomEvent"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewCustomEvent(
        @SerialName("event")
        val event: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * A new incoming query
     *
     * @property id The query identifier
     * @property data JSON-serialized query data
     * @property timeout Query timeout
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updateNewCustomQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewCustomQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdateNewCustomQuery(
        @SerialName("id")
        val id: Long,
        @SerialName("data")
        val data: String,
        @SerialName("timeout")
        val timeout: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Information about a poll was updated
     *
     * @property poll New data about the poll
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updatePoll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdatePoll"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UpdatePoll(
        @SerialName("poll")
        val poll: Poll,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Update()

    /**
     * Contains a list of updates
     *
     * @property updates List of updates
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("updates")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdates"),
        level = DeprecationLevel.WARNING
    )
    data class Updates(
        @SerialName("updates")
        val updates: Array<Update>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Describes a stream to which TDLib internal log is written
     */
    @Serializable
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStream"),
        level = DeprecationLevel.WARNING
    )
    abstract class LogStream : Object(), TdResponse

    /**
     * The log is written to stderr or an OS specific log
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logStreamDefault")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStreamDefault"),
        level = DeprecationLevel.WARNING
    )
    data class LogStreamDefault(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : LogStream()

    /**
     * The log is written to a file
     *
     * @property path Path to the file to where the internal TDLib log will be written
     * @property maxFileSize Maximum size of the file to where the internal TDLib log is written before the file will be auto-rotated
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logStreamFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStreamFile"),
        level = DeprecationLevel.WARNING
    )
    data class LogStreamFile(
        @SerialName("path")
        val path: String,
        @SerialName("max_file_size")
        val maxFileSize: Long,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : LogStream()

    /**
     * The log is written nowhere
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logStreamEmpty")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStreamEmpty"),
        level = DeprecationLevel.WARNING
    )
    data class LogStreamEmpty(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : LogStream()

    /**
     * Contains a TDLib internal log verbosity level
     *
     * @property verbosityLevel Log verbosity level
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logVerbosityLevel")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogVerbosityLevel"),
        level = DeprecationLevel.WARNING
    )
    data class LogVerbosityLevel(
        @SerialName("verbosity_level")
        val verbosityLevel: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Contains a list of available TDLib internal log tags
     *
     * @property tags List of log tags
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logTags")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogTags"),
        level = DeprecationLevel.WARNING
    )
    data class LogTags(
        @SerialName("tags")
        val tags: Array<String>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A simple object containing a number
     *
     * @property value Number
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testInt")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestInt"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestInt(
        @SerialName("value")
        val value: Int,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A simple object containing a string
     *
     * @property value String
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestString"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestString(
        @SerialName("value")
        val value: String,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A simple object containing a sequence of bytes
     *
     * @property value Bytes
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testBytes")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestBytes"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestBytes(
        @SerialName("value")
        val value: ByteArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A simple object containing a vector of numbers
     *
     * @property value Vector of numbers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testVectorInt")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorInt"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestVectorInt(
        @SerialName("value")
        val value: IntArray,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A simple object containing a vector of objects that hold a number
     *
     * @property value Vector of objects
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testVectorIntObject")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorIntObject"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestVectorIntObject(
        @SerialName("value")
        val value: Array<TestInt>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A simple object containing a vector of strings
     *
     * @property value Vector of strings
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testVectorString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorString"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestVectorString(
        @SerialName("value")
        val value: Array<String>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * A simple object containing a vector of objects that hold a string
     *
     * @property value Vector of objects
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testVectorStringObject")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorStringObject"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestVectorStringObject(
        @SerialName("value")
        val value: Array<TestString>,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Object(), TdResponse

    /**
     * Returns the current authorization state
     * This is an offline request
     * For informational purposes only
     * Use updateAuthorizationState instead to maintain the current authorization state
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getAuthorizationState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAuthorizationState"),
        level = DeprecationLevel.WARNING
    )
    data class GetAuthorizationState(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AuthorizationState> {
        override fun withRequestId(id: Long): GetAuthorizationState {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the parameters for TDLib initialization
     * Works only when the current authorization state is authorizationStateWaitTdlibParameters
     *
     * @property parameters Parameters
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setTdlibParameters")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetTdlibParameters"),
        level = DeprecationLevel.WARNING
    )
    data class SetTdlibParameters(
        @SerialName("parameters")
        val parameters: TdlibParameters? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetTdlibParameters {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the database encryption key for correctness
     * Works only when the current authorization state is authorizationStateWaitEncryptionKey
     *
     * @property encryptionKey Encryption key to check or set up
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkDatabaseEncryptionKey")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckDatabaseEncryptionKey"),
        level = DeprecationLevel.WARNING
    )
    data class CheckDatabaseEncryptionKey(
        @SerialName("encryption_key")
        val encryptionKey: ByteArray = byteArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckDatabaseEncryptionKey {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the phone number of the user and sends an authentication code to the user
     * Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitCode or authorizationStateWaitPassword
     *
     * @property phoneNumber The phone number of the user, in international format
     * @property settings Settings for the authentication of the user's phone number
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setAuthenticationPhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAuthenticationPhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    data class SetAuthenticationPhoneNumber(
        @SerialName("phone_number")
        val phoneNumber: String? = null,
        @SerialName("settings")
        val settings: PhoneNumberAuthenticationSettings? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetAuthenticationPhoneNumber {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Re-sends an authentication code to the user
     * Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resendAuthenticationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendAuthenticationCode"),
        level = DeprecationLevel.WARNING
    )
    data class ResendAuthenticationCode(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ResendAuthenticationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the authentication code
     * Works only when the current authorization state is authorizationStateWaitCode
     *
     * @property code The verification code received via SMS, Telegram message, phone call, or flash call
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkAuthenticationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckAuthenticationCode"),
        level = DeprecationLevel.WARNING
    )
    data class CheckAuthenticationCode(
        @SerialName("code")
        val code: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckAuthenticationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Finishes user registration
     * Works only when the current authorization state is authorizationStateWaitRegistration
     *
     * @property firstName The first name of the user
     * @property lastName The last name of the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("registerUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRegisterUser"),
        level = DeprecationLevel.WARNING
    )
    data class RegisterUser(
        @SerialName("first_name")
        val firstName: String? = null,
        @SerialName("last_name")
        val lastName: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RegisterUser {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the authentication password for correctness
     * Works only when the current authorization state is authorizationStateWaitPassword
     *
     * @property password The password to check
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkAuthenticationPassword")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckAuthenticationPassword"),
        level = DeprecationLevel.WARNING
    )
    data class CheckAuthenticationPassword(
        @SerialName("password")
        val password: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckAuthenticationPassword {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Requests to send a password recovery code to an email address that was previously set up
     * Works only when the current authorization state is authorizationStateWaitPassword
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("requestAuthenticationPasswordRecovery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRequestAuthenticationPasswordRecovery"),
        level = DeprecationLevel.WARNING
    )
    data class RequestAuthenticationPasswordRecovery(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RequestAuthenticationPasswordRecovery {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Recovers the password with a password recovery code sent to an email address that was previously set up
     * Works only when the current authorization state is authorizationStateWaitPassword
     *
     * @property recoveryCode Recovery code to check
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("recoverAuthenticationPassword")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRecoverAuthenticationPassword"),
        level = DeprecationLevel.WARNING
    )
    data class RecoverAuthenticationPassword(
        @SerialName("recovery_code")
        val recoveryCode: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RecoverAuthenticationPassword {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the authentication token of a bot
     * Works only when the current authorization state is authorizationStateWaitPhoneNumber
     * Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in
     *
     * @property token The bot token
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkAuthenticationBotToken")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckAuthenticationBotToken"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class CheckAuthenticationBotToken(
        @SerialName("token")
        val token: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckAuthenticationBotToken {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Closes the TDLib instance after a proper logout
     * Requires an available network connection
     * All local data will be destroyed
     * After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("logOut")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogOut"),
        level = DeprecationLevel.WARNING
    )
    data class LogOut(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): LogOut {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Closes the TDLib instance
     * All databases will be flushed to disk and properly closed
     * After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("close")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClose"),
        level = DeprecationLevel.WARNING
    )
    data class Close(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): Close {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Closes the TDLib instance, destroying all local data without a proper logout
     * The current user session will remain in the list of all active sessions
     * All local data will be destroyed
     * After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("destroy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDestroy"),
        level = DeprecationLevel.WARNING
    )
    data class Destroy(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): Destroy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns all updates needed to restore current TDLib state, i.e
     * All actual UpdateAuthorizationState/UpdateUser/UpdateNewChat and others
     * This is especially usefull if TDLib is run in a separate process
     * This is an offline method
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getCurrentState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCurrentState"),
        level = DeprecationLevel.WARNING
    )
    data class GetCurrentState(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Updates> {
        override fun withRequestId(id: Long): GetCurrentState {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the database encryption key
     * Usually the encryption key is never changed and is stored in some OS keychain
     *
     * @property newEncryptionKey New encryption key
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setDatabaseEncryptionKey")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetDatabaseEncryptionKey"),
        level = DeprecationLevel.WARNING
    )
    data class SetDatabaseEncryptionKey(
        @SerialName("new_encryption_key")
        val newEncryptionKey: ByteArray = byteArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetDatabaseEncryptionKey {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the current state of 2-step verification
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPasswordState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPasswordState"),
        level = DeprecationLevel.WARNING
    )
    data class GetPasswordState(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PasswordState> {
        override fun withRequestId(id: Long): GetPasswordState {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the password for the user
     * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
     *
     * @property oldPassword Previous password of the user
     * @property newPassword New password of the user
     *                       May be empty to remove the password
     * @property newHint New password hint
     * @property setRecoveryEmailAddress Pass true if the recovery email address should be changed
     * @property newRecoveryEmailAddress New recovery email address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setPassword")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPassword"),
        level = DeprecationLevel.WARNING
    )
    data class SetPassword(
        @SerialName("old_password")
        val oldPassword: String? = null,
        @SerialName("new_password")
        val newPassword: String? = null,
        @SerialName("new_hint")
        val newHint: String? = null,
        @SerialName("set_recovery_email_address")
        val setRecoveryEmailAddress: Boolean = false,
        @SerialName("new_recovery_email_address")
        val newRecoveryEmailAddress: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PasswordState> {
        override fun withRequestId(id: Long): SetPassword {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a 2-step verification recovery email address that was previously set up
     * This method can be used to verify a password provided by the user
     *
     * @property password The password for the current user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getRecoveryEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecoveryEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    data class GetRecoveryEmailAddress(
        @SerialName("password")
        val password: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<RecoveryEmailAddress> {
        override fun withRequestId(id: Long): GetRecoveryEmailAddress {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the 2-step verification recovery email address of the user
     * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
     * If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
     *
     * @property password Password of the current user
     * @property newRecoveryEmailAddress New recovery email address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setRecoveryEmailAddress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetRecoveryEmailAddress"),
        level = DeprecationLevel.WARNING
    )
    data class SetRecoveryEmailAddress(
        @SerialName("password")
        val password: String? = null,
        @SerialName("new_recovery_email_address")
        val newRecoveryEmailAddress: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PasswordState> {
        override fun withRequestId(id: Long): SetRecoveryEmailAddress {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the 2-step verification recovery email address verification code
     *
     * @property code Verification code
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkRecoveryEmailAddressCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckRecoveryEmailAddressCode"),
        level = DeprecationLevel.WARNING
    )
    data class CheckRecoveryEmailAddressCode(
        @SerialName("code")
        val code: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PasswordState> {
        override fun withRequestId(id: Long): CheckRecoveryEmailAddressCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Resends the 2-step verification recovery email address verification code
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resendRecoveryEmailAddressCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendRecoveryEmailAddressCode"),
        level = DeprecationLevel.WARNING
    )
    data class ResendRecoveryEmailAddressCode(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PasswordState> {
        override fun withRequestId(id: Long): ResendRecoveryEmailAddressCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Requests to send a password recovery code to an email address that was previously set up
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("requestPasswordRecovery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRequestPasswordRecovery"),
        level = DeprecationLevel.WARNING
    )
    data class RequestPasswordRecovery(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<EmailAddressAuthenticationCodeInfo> {
        override fun withRequestId(id: Long): RequestPasswordRecovery {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Recovers the password using a recovery code sent to an email address that was previously set up
     *
     * @property recoveryCode Recovery code to check
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("recoverPassword")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRecoverPassword"),
        level = DeprecationLevel.WARNING
    )
    data class RecoverPassword(
        @SerialName("recovery_code")
        val recoveryCode: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PasswordState> {
        override fun withRequestId(id: Long): RecoverPassword {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Creates a new temporary password for processing payments
     *
     * @property password Persistent user password
     * @property validFor Time during which the temporary password will be valid, in seconds
     *                    Should be between 60 and 86400
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createTemporaryPassword")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateTemporaryPassword"),
        level = DeprecationLevel.WARNING
    )
    data class CreateTemporaryPassword(
        @SerialName("password")
        val password: String? = null,
        @SerialName("valid_for")
        val validFor: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TemporaryPasswordState> {
        override fun withRequestId(id: Long): CreateTemporaryPassword {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about the current temporary password
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getTemporaryPasswordState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTemporaryPasswordState"),
        level = DeprecationLevel.WARNING
    )
    data class GetTemporaryPasswordState(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TemporaryPasswordState> {
        override fun withRequestId(id: Long): GetTemporaryPasswordState {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the current user
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getMe")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMe"),
        level = DeprecationLevel.WARNING
    )
    data class GetMe(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<User> {
        override fun withRequestId(id: Long): GetMe {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a user by their identifier
     * This is an offline request if the current user is not a bot
     *
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUser"),
        level = DeprecationLevel.WARNING
    )
    data class GetUser(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<User> {
        override fun withRequestId(id: Long): GetUser {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns full information about a user by their identifier
     *
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getUserFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUserFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetUserFullInfo(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<UserFullInfo> {
        override fun withRequestId(id: Long): GetUserFullInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a basic group by its identifier
     * This is an offline request if the current user is not a bot
     *
     * @property basicGroupId Basic group identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getBasicGroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBasicGroup"),
        level = DeprecationLevel.WARNING
    )
    data class GetBasicGroup(
        @SerialName("basic_group_id")
        val basicGroupId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<BasicGroup> {
        override fun withRequestId(id: Long): GetBasicGroup {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns full information about a basic group by its identifier
     *
     * @property basicGroupId Basic group identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getBasicGroupFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBasicGroupFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetBasicGroupFullInfo(
        @SerialName("basic_group_id")
        val basicGroupId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<BasicGroupFullInfo> {
        override fun withRequestId(id: Long): GetBasicGroupFullInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a supergroup or channel by its identifier
     * This is an offline request if the current user is not a bot
     *
     * @property supergroupId Supergroup or channel identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getSupergroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupergroup"),
        level = DeprecationLevel.WARNING
    )
    data class GetSupergroup(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Supergroup> {
        override fun withRequestId(id: Long): GetSupergroup {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns full information about a supergroup or channel by its identifier, cached for up to 1 minute
     *
     * @property supergroupId Supergroup or channel identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getSupergroupFullInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupergroupFullInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetSupergroupFullInfo(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<SupergroupFullInfo> {
        override fun withRequestId(id: Long): GetSupergroupFullInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a secret chat by its identifier
     * This is an offline request
     *
     * @property secretChatId Secret chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getSecretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSecretChat"),
        level = DeprecationLevel.WARNING
    )
    data class GetSecretChat(
        @SerialName("secret_chat_id")
        val secretChatId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<SecretChat> {
        override fun withRequestId(id: Long): GetSecretChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChat"),
        level = DeprecationLevel.WARNING
    )
    data class GetChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): GetChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a message
     *
     * @property chatId Identifier of the chat the message belongs to
     * @property messageId Identifier of the message to get
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessage"),
        level = DeprecationLevel.WARNING
    )
    data class GetMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): GetMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a message, if it is available locally without sending network request
     * This is an offline request
     *
     * @property chatId Identifier of the chat the message belongs to
     * @property messageId Identifier of the message to get
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getMessageLocally")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessageLocally"),
        level = DeprecationLevel.WARNING
    )
    data class GetMessageLocally(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): GetMessageLocally {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a message that is replied by given message
     *
     * @property chatId Identifier of the chat the message belongs to
     * @property messageId Identifier of the message reply to which get
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getRepliedMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRepliedMessage"),
        level = DeprecationLevel.WARNING
    )
    data class GetRepliedMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): GetRepliedMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a pinned chat message
     *
     * @property chatId Identifier of the chat the message belongs to
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatPinnedMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatPinnedMessage"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatPinnedMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): GetChatPinnedMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about messages
     * If a message is not found, returns null on the corresponding position of the result
     *
     * @property chatId Identifier of the chat the messages belong to
     * @property messageIds Identifiers of the messages to get
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessages"),
        level = DeprecationLevel.WARNING
    )
    data class GetMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_ids")
        val messageIds: LongArray = longArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): GetMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a file
     * This is an offline request
     *
     * @property fileId Identifier of the file to get
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFile"),
        level = DeprecationLevel.WARNING
    )
    data class GetFile(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<File> {
        override fun withRequestId(id: Long): GetFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a file by its remote ID
     * This is an offline request
     * Can be used to register a URL as a file for further uploading, or sending as a message
     *
     * @property remoteFileId Remote identifier of the file to get
     * @property fileType File type, if known
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getRemoteFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRemoteFile"),
        level = DeprecationLevel.WARNING
    )
    data class GetRemoteFile(
        @SerialName("remote_file_id")
        val remoteFileId: String? = null,
        @SerialName("file_type")
        val fileType: FileType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<File> {
        override fun withRequestId(id: Long): GetRemoteFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an ordered list of chats
     * Chats are sorted by the pair (order, chat_id) in decreasing order
     * (For example, to get a list of chats from the beginning, the offset_order should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1)
     * For optimal performance the number of returned chats is chosen by the library
     *
     * @property offsetOrder Chat order to return chats from
     * @property offsetChatId Chat identifier to return chats from
     * @property limit The maximum number of chats to be returned
     *                 It is possible that fewer chats than the limit are returned even if the end of the list is not reached
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChats"),
        level = DeprecationLevel.WARNING
    )
    data class GetChats(
        @SerialName("offset_order")
        val offsetOrder: Long = 0L,
        @SerialName("offset_chat_id")
        val offsetChatId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): GetChats {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches a public chat by its username
     * Currently only private chats, supergroups and channels can be public
     * Returns the chat if found
     * Otherwise an error is returned
     *
     * @property username Username to be resolved
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchPublicChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchPublicChat"),
        level = DeprecationLevel.WARNING
    )
    data class SearchPublicChat(
        @SerialName("username")
        val username: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): SearchPublicChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches public chats by looking for specified query in their username and title
     * Currently only private chats, supergroups and channels can be public
     * Returns a meaningful number of results
     * Returns nothing if the length of the searched username prefix is less than 5
     * Excludes private chats with contacts and chats from the chat list from the results
     *
     * @property query Query to search for
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchPublicChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchPublicChats"),
        level = DeprecationLevel.WARNING
    )
    data class SearchPublicChats(
        @SerialName("query")
        val query: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): SearchPublicChats {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for the specified query in the title and username of already known chats, this is an offline request
     * Returns chats in the order seen in the chat list
     *
     * @property query Query to search for
     *                 If the query is empty, returns up to 20 recently found chats
     * @property limit Maximum number of chats to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChats"),
        level = DeprecationLevel.WARNING
    )
    data class SearchChats(
        @SerialName("query")
        val query: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): SearchChats {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for the specified query in the title and username of already known chats via request to the server
     * Returns chats in the order seen in the chat list
     *
     * @property query Query to search for
     * @property limit Maximum number of chats to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchChatsOnServer")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatsOnServer"),
        level = DeprecationLevel.WARNING
    )
    data class SearchChatsOnServer(
        @SerialName("query")
        val query: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): SearchChatsOnServer {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of frequently used chats
     * Supported only if the chat info database is enabled
     *
     * @property category Category of chats to be returned
     * @property limit Maximum number of chats to be returned
     *                 Up to 30
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getTopChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTopChats"),
        level = DeprecationLevel.WARNING
    )
    data class GetTopChats(
        @SerialName("category")
        val category: TopChatCategory? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): GetTopChats {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a chat from the list of frequently used chats
     * Supported only if the chat info database is enabled
     *
     * @property category Category of frequently used chats
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeTopChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveTopChat"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveTopChat(
        @SerialName("category")
        val category: TopChatCategory? = null,
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveTopChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a chat to the list of recently found chats
     * The chat is added to the beginning of the list
     * If the chat is already in the list, it will be removed from the list first
     *
     * @property chatId Identifier of the chat to add
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addRecentlyFoundChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddRecentlyFoundChat"),
        level = DeprecationLevel.WARNING
    )
    data class AddRecentlyFoundChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AddRecentlyFoundChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a chat from the list of recently found chats
     *
     * @property chatId Identifier of the chat to be removed
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeRecentlyFoundChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveRecentlyFoundChat"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveRecentlyFoundChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveRecentlyFoundChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Clears the list of recently found chats
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("clearRecentlyFoundChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearRecentlyFoundChats"),
        level = DeprecationLevel.WARNING
    )
    data class ClearRecentlyFoundChats(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ClearRecentlyFoundChats {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks whether a username can be set for a chat
     *
     * @property chatId Chat identifier
     *                  Should be identifier of a supergroup chat, or a channel chat, or a private chat with self, or zero if chat is being created
     * @property username Username to be checked
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatUsername")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsername"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChatUsername(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("username")
        val username: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<CheckChatUsernameResult> {
        override fun withRequestId(id: Long): CheckChatUsername {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of public chats with username created by the user
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getCreatedPublicChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCreatedPublicChats"),
        level = DeprecationLevel.WARNING
    )
    data class GetCreatedPublicChats(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): GetCreatedPublicChats {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of common group chats with a given user
     * Chats are sorted by their type and creation date
     *
     * @property userId User identifier
     * @property offsetChatId Chat identifier starting from which to return chats
     *                        Use 0 for the first request
     * @property limit Maximum number of chats to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getGroupsInCommon")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetGroupsInCommon"),
        level = DeprecationLevel.WARNING
    )
    data class GetGroupsInCommon(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("offset_chat_id")
        val offsetChatId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): GetGroupsInCommon {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns messages in a chat
     * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
     * For optimal performance the number of returned messages is chosen by the library
     * This is an offline request if only_local is true
     *
     * @property chatId Chat identifier
     * @property fromMessageId Identifier of the message starting from which history must be fetched
     *                         Use 0 to get results from the last message
     * @property offset Specify 0 to get results from exactly the from_message_id or a negative offset up to 99 to get additionally some newer messages
     * @property limit The maximum number of messages to be returned
     *                 Must be positive and can't be greater than 100
     *                 If the offset is negative, the limit must be greater or equal to -offset
     *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @property onlyLocal If true, returns only messages that are available locally without sending network requests
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatHistory")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatHistory"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatHistory(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("from_message_id")
        val fromMessageId: Long = 0L,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("only_local")
        val onlyLocal: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): GetChatHistory {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes all messages in the chat
     * Use Chat.can_be_deleted_only_for_self and Chat.can_be_deleted_for_all_users fields to find whether and how the method can be applied to the chat
     *
     * @property chatId Chat identifier
     * @property removeFromChatList Pass true if the chat should be removed from the chat list
     * @property revoke Pass true to try to delete chat history for all users
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteChatHistory")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteChatHistory"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteChatHistory(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("remove_from_chat_list")
        val removeFromChatList: Boolean = false,
        @SerialName("revoke")
        val revoke: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteChatHistory {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for messages with given words in the chat
     * Returns the results in reverse chronological order, i.e
     * In order of decreasing message_id
     * Cannot be used in secret chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled message database
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @property chatId Identifier of the chat in which to search messages
     * @property query Query to search for
     * @property senderUserId If not 0, only messages sent by the specified user will be returned
     *                        Not supported in secret chats
     * @property fromMessageId Identifier of the message starting from which history must be fetched
     *                         Use 0 to get results from the last message
     * @property offset Specify 0 to get results from exactly the from_message_id or a negative offset to get the specified message and some newer messages
     * @property limit The maximum number of messages to be returned
     *                 Must be positive and can't be greater than 100
     *                 If the offset is negative, the limit must be greater than -offset
     *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @property filter Filter for message content in the search results
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchChatMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatMessages"),
        level = DeprecationLevel.WARNING
    )
    data class SearchChatMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("query")
        val query: String? = null,
        @SerialName("sender_user_id")
        val senderUserId: Int = 0,
        @SerialName("from_message_id")
        val fromMessageId: Long = 0L,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("filter")
        val filter: SearchMessagesFilter? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): SearchChatMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for messages in all chats except secret chats
     * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @property query Query to search for
     * @property offsetDate The date of the message starting from which the results should be fetched
     *                      Use 0 or any date in the future to get results from the last message
     * @property offsetChatId The chat identifier of the last found message, or 0 for the first request
     * @property offsetMessageId The message identifier of the last found message, or 0 for the first request
     * @property limit The maximum number of messages to be returned, up to 100
     *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessages"),
        level = DeprecationLevel.WARNING
    )
    data class SearchMessages(
        @SerialName("query")
        val query: String? = null,
        @SerialName("offset_date")
        val offsetDate: Int = 0,
        @SerialName("offset_chat_id")
        val offsetChatId: Long = 0L,
        @SerialName("offset_message_id")
        val offsetMessageId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): SearchMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for messages in secret chats
     * Returns the results in reverse chronological order
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @property chatId Identifier of the chat in which to search
     *                  Specify 0 to search in all secret chats
     * @property query Query to search for
     *                 If empty, searchChatMessages should be used instead
     * @property fromSearchId The identifier from the result of a previous request, use 0 to get results from the last message
     * @property limit Maximum number of messages to be returned
     *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @property filter A filter for the content of messages in the search results
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchSecretMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchSecretMessages"),
        level = DeprecationLevel.WARNING
    )
    data class SearchSecretMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("query")
        val query: String? = null,
        @SerialName("from_search_id")
        val fromSearchId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("filter")
        val filter: SearchMessagesFilter? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<FoundMessages> {
        override fun withRequestId(id: Long): SearchSecretMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for call messages
     * Returns the results in reverse chronological order (i
     * E., in order of decreasing message_id)
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @property fromMessageId Identifier of the message from which to search
     *                         Use 0 to get results from the last message
     * @property limit The maximum number of messages to be returned
     *                 Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @property onlyMissed If true, returns only messages with missed calls
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchCallMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchCallMessages"),
        level = DeprecationLevel.WARNING
    )
    data class SearchCallMessages(
        @SerialName("from_message_id")
        val fromMessageId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("only_missed")
        val onlyMissed: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): SearchCallMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about the recent locations of chat members that were sent to the chat
     * Returns up to 1 location message per user
     *
     * @property chatId Chat identifier
     * @property limit Maximum number of messages to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchChatRecentLocationMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatRecentLocationMessages"),
        level = DeprecationLevel.WARNING
    )
    data class SearchChatRecentLocationMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): SearchChatRecentLocationMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns all active live locations that should be updated by the client
     * The list is persistent across application restarts only if the message database is used
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getActiveLiveLocationMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetActiveLiveLocationMessages"),
        level = DeprecationLevel.WARNING
    )
    data class GetActiveLiveLocationMessages(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): GetActiveLiveLocationMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the last message sent in a chat no later than the specified date
     *
     * @property chatId Chat identifier
     * @property date Point in time (Unix timestamp) relative to which to search for messages
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatMessageByDate")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatMessageByDate"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatMessageByDate(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("date")
        val date: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): GetChatMessageByDate {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns approximate number of messages of the specified type in the chat
     *
     * @property chatId Identifier of the chat in which to count messages
     * @property filter Filter for message content
     *                  SearchMessagesFilterEmpty is unsupported in this function
     * @property returnLocal If true, returns count that is available locally without sending network requests, returning -1 if the number of messages is unknown
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatMessageCount")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatMessageCount"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatMessageCount(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("filter")
        val filter: SearchMessagesFilter? = null,
        @SerialName("return_local")
        val returnLocal: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Count> {
        override fun withRequestId(id: Long): GetChatMessageCount {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes an active notification from notification list
     * Needs to be called only if the notification is removed by the current user
     *
     * @property notificationGroupId Identifier of notification group to which the notification belongs
     * @property notificationId Identifier of removed notification
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeNotification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveNotification"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveNotification(
        @SerialName("notification_group_id")
        val notificationGroupId: Int = 0,
        @SerialName("notification_id")
        val notificationId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveNotification {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a group of active notifications
     * Needs to be called only if the notification group is removed by the current user
     *
     * @property notificationGroupId Notification group identifier
     * @property maxNotificationId Maximum identifier of removed notifications
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeNotificationGroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveNotificationGroup"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveNotificationGroup(
        @SerialName("notification_group_id")
        val notificationGroupId: Int = 0,
        @SerialName("max_notification_id")
        val maxNotificationId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveNotificationGroup {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a public HTTPS link to a message
     * Available only for messages in supergroups and channels with username
     *
     * @property chatId Identifier of the chat to which the message belongs
     * @property messageId Identifier of the message
     * @property forAlbum Pass true if a link for a whole media album should be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPublicMessageLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPublicMessageLink"),
        level = DeprecationLevel.WARNING
    )
    data class GetPublicMessageLink(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("for_album")
        val forAlbum: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PublicMessageLink> {
        override fun withRequestId(id: Long): GetPublicMessageLink {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a private HTTPS link to a message in a chat
     * Available only for already sent messages in supergroups and channels
     * The link will work only for members of the chat
     *
     * @property chatId Identifier of the chat to which the message belongs
     * @property messageId Identifier of the message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getMessageLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessageLink"),
        level = DeprecationLevel.WARNING
    )
    data class GetMessageLink(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<HttpUrl> {
        override fun withRequestId(id: Long): GetMessageLink {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a public or private message link
     *
     * @property url The message link in the format "https://t.me/c/...", or "tg://privatepost?...", or "https://t.me/username/...", or "tg://resolve?..."
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getMessageLinkInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessageLinkInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetMessageLinkInfo(
        @SerialName("url")
        val url: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<MessageLinkInfo> {
        override fun withRequestId(id: Long): GetMessageLinkInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a message
     * Returns the sent message
     *
     * @property chatId Target chat
     * @property replyToMessageId Identifier of the message to reply to or 0
     * @property disableNotification Pass true to disable notification for the message
     *                               Not supported in secret chats
     * @property fromBackground Pass true if the message is sent from the background
     * @property replyMarkup Markup for replying to the message
     * @property inputMessageContent The content of the message to be sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendMessage"),
        level = DeprecationLevel.WARNING
    )
    data class SendMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("reply_to_message_id")
        val replyToMessageId: Long = 0L,
        @SerialName("disable_notification")
        val disableNotification: Boolean = false,
        @SerialName("from_background")
        val fromBackground: Boolean = false,
        @SerialName("reply_markup")
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): SendMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends messages grouped together into an album
     * Currently only photo and video messages can be grouped into an album
     * Returns sent messages
     *
     * @property chatId Target chat
     * @property replyToMessageId Identifier of a message to reply to or 0
     * @property disableNotification Pass true to disable notification for the messages
     *                               Not supported in secret chats
     * @property fromBackground Pass true if the messages are sent from the background
     * @property inputMessageContents Contents of messages to be sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendMessageAlbum")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendMessageAlbum"),
        level = DeprecationLevel.WARNING
    )
    data class SendMessageAlbum(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("reply_to_message_id")
        val replyToMessageId: Long = 0L,
        @SerialName("disable_notification")
        val disableNotification: Boolean = false,
        @SerialName("from_background")
        val fromBackground: Boolean = false,
        @SerialName("input_message_contents")
        val inputMessageContents: Array<InputMessageContent> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): SendMessageAlbum {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
     * Bots can't be invited to a private chat other than the chat with the bot
     * Bots can't be invited to channels (although they can be added as admins) and secret chats
     * Returns the sent message
     *
     * @property botUserId Identifier of the bot
     * @property chatId Identifier of the target chat
     * @property parameter A hidden parameter sent to the bot for deep linking purposes (https://core.telegram.org/bots#deep-linking)
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendBotStartMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendBotStartMessage"),
        level = DeprecationLevel.WARNING
    )
    data class SendBotStartMessage(
        @SerialName("bot_user_id")
        val botUserId: Int = 0,
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("parameter")
        val parameter: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): SendBotStartMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends the result of an inline query as a message
     * Returns the sent message
     * Always clears a chat draft message
     *
     * @property chatId Target chat
     * @property replyToMessageId Identifier of a message to reply to or 0
     * @property disableNotification Pass true to disable notification for the message
     *                               Not supported in secret chats
     * @property fromBackground Pass true if the message is sent from background
     * @property queryId Identifier of the inline query
     * @property resultId Identifier of the inline result
     * @property hideViaBot If true, there will be no mention of a bot, via which the message is sent
     *                      Can be used only for bots GetOption("animation_search_bot_username"), GetOption("photo_search_bot_username") and GetOption("venue_search_bot_username")
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendInlineQueryResultMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendInlineQueryResultMessage"),
        level = DeprecationLevel.WARNING
    )
    data class SendInlineQueryResultMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("reply_to_message_id")
        val replyToMessageId: Long = 0L,
        @SerialName("disable_notification")
        val disableNotification: Boolean = false,
        @SerialName("from_background")
        val fromBackground: Boolean = false,
        @SerialName("query_id")
        val queryId: Long = 0L,
        @SerialName("result_id")
        val resultId: String? = null,
        @SerialName("hide_via_bot")
        val hideViaBot: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): SendInlineQueryResultMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Forwards previously sent messages
     * Returns the forwarded messages in the same order as the message identifiers passed in message_ids
     * If a message can't be forwarded, null will be returned instead of the message
     *
     * @property chatId Identifier of the chat to which to forward messages
     * @property fromChatId Identifier of the chat from which to forward messages
     * @property messageIds Identifiers of the messages to forward
     * @property disableNotification Pass true to disable notification for the message, doesn't work if messages are forwarded to a secret chat
     * @property fromBackground Pass true if the messages are sent from the background
     * @property asAlbum True, if the messages should be grouped into an album after forwarding
     *                   For this to work, no more than 10 messages may be forwarded, and all of them must be photo or video messages
     * @property sendCopy True, if content of the messages needs to be copied without links to the original messages
     *                    Always true if the messages are forwarded to a secret chat
     * @property removeCaption True, if media captions of message copies needs to be removed
     *                         Ignored if send_copy is false
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("forwardMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdForwardMessages"),
        level = DeprecationLevel.WARNING
    )
    data class ForwardMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("from_chat_id")
        val fromChatId: Long = 0L,
        @SerialName("message_ids")
        val messageIds: LongArray = longArrayOf(),
        @SerialName("disable_notification")
        val disableNotification: Boolean = false,
        @SerialName("from_background")
        val fromBackground: Boolean = false,
        @SerialName("as_album")
        val asAlbum: Boolean = false,
        @SerialName("send_copy")
        val sendCopy: Boolean = false,
        @SerialName("remove_caption")
        val removeCaption: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): ForwardMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Resends messages which failed to send
     * Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed
     * If a message is re-sent, the corresponding failed to send message is deleted
     * Returns the sent messages in the same order as the message identifiers passed in message_ids
     * If a message can't be re-sent, null will be returned instead of the message
     *
     * @property chatId Identifier of the chat to send messages
     * @property messageIds Identifiers of the messages to resend
     *                      Message identifiers must be in a strictly increasing order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resendMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendMessages"),
        level = DeprecationLevel.WARNING
    )
    data class ResendMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_ids")
        val messageIds: LongArray = longArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Messages> {
        override fun withRequestId(id: Long): ResendMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
     *
     * @property chatId Chat identifier
     * @property ttl New TTL value, in seconds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendChatSetTtlMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendChatSetTtlMessage"),
        level = DeprecationLevel.WARNING
    )
    data class SendChatSetTtlMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("ttl")
        val ttl: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): SendChatSetTtlMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a notification about a screenshot taken in a chat
     * Supported only in private and secret chats
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendChatScreenshotTakenNotification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendChatScreenshotTakenNotification"),
        level = DeprecationLevel.WARNING
    )
    data class SendChatScreenshotTakenNotification(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SendChatScreenshotTakenNotification {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a local message to a chat
     * The message is persistent across application restarts only if the message database is used
     * Returns the added message
     *
     * @property chatId Target chat
     * @property senderUserId Identifier of the user who will be shown as the sender of the message
     *                        May be 0 for channel posts
     * @property replyToMessageId Identifier of the message to reply to or 0
     * @property disableNotification Pass true to disable notification for the message
     * @property inputMessageContent The content of the message to be added
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addLocalMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddLocalMessage"),
        level = DeprecationLevel.WARNING
    )
    data class AddLocalMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("sender_user_id")
        val senderUserId: Int = 0,
        @SerialName("reply_to_message_id")
        val replyToMessageId: Long = 0L,
        @SerialName("disable_notification")
        val disableNotification: Boolean = false,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): AddLocalMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes messages
     *
     * @property chatId Chat identifier
     * @property messageIds Identifiers of the messages to be deleted
     * @property revoke Pass true to try to delete messages for all chat members
     *                  Always true for supergroups, channels and secret chats
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteMessages"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_ids")
        val messageIds: LongArray = longArrayOf(),
        @SerialName("revoke")
        val revoke: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes all messages sent by the specified user to a chat
     * Supported only in supergroups
     * Requires can_delete_messages administrator privileges
     *
     * @property chatId Chat identifier
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteChatMessagesFromUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteChatMessagesFromUser"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteChatMessagesFromUser(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteChatMessagesFromUser {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the text of a message (or a text of a game message)
     * Returns the edited message after the edit is completed on the server side
     *
     * @property chatId The chat the message belongs to
     * @property messageId Identifier of the message
     * @property replyMarkup The new message reply markup
     * @property inputMessageContent New text content of the message
     *                               Should be of type InputMessageText
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editMessageText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageText"),
        level = DeprecationLevel.WARNING
    )
    data class EditMessageText(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("reply_markup")
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): EditMessageText {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the message content of a live location
     * Messages can be edited for a limited period of time specified in the live location
     * Returns the edited message after the edit is completed on the server side
     *
     * @property chatId The chat the message belongs to
     * @property messageId Identifier of the message
     * @property replyMarkup The new message reply markup
     * @property location New location content of the message
     *                    Pass null to stop sharing the live location
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editMessageLiveLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageLiveLocation"),
        level = DeprecationLevel.WARNING
    )
    data class EditMessageLiveLocation(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("reply_markup")
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("location")
        val location: Location? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): EditMessageLiveLocation {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the content of a message with an animation, an audio, a document, a photo or a video
     * The media in the message can't be replaced if the message was set to self-destruct
     * Media can't be replaced by self-destructing media
     * Media in an album can be edited only to contain a photo or a video
     * Returns the edited message after the edit is completed on the server side
     *
     * @property chatId The chat the message belongs to
     * @property messageId Identifier of the message
     * @property replyMarkup The new message reply markup
     * @property inputMessageContent New content of the message
     *                               Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editMessageMedia")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageMedia"),
        level = DeprecationLevel.WARNING
    )
    data class EditMessageMedia(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("reply_markup")
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): EditMessageMedia {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the message content caption
     * Returns the edited message after the edit is completed on the server side
     *
     * @property chatId The chat the message belongs to
     * @property messageId Identifier of the message
     * @property replyMarkup The new message reply markup
     * @property caption New message content caption
     *                   0-GetOption("message_caption_length_max") characters
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editMessageCaption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageCaption"),
        level = DeprecationLevel.WARNING
    )
    data class EditMessageCaption(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("reply_markup")
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("caption")
        val caption: FormattedText? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): EditMessageCaption {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the message reply markup
     * Returns the edited message after the edit is completed on the server side
     *
     * @property chatId The chat the message belongs to
     * @property messageId Identifier of the message
     * @property replyMarkup The new message reply markup
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editMessageReplyMarkup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageReplyMarkup"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class EditMessageReplyMarkup(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): EditMessageReplyMarkup {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the text of an inline text or game message sent via a bot
     *
     * @property inlineMessageId Inline message identifier
     * @property replyMarkup The new message reply markup
     * @property inputMessageContent New text content of the message
     *                               Should be of type InputMessageText
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editInlineMessageText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageText"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class EditInlineMessageText(
        @SerialName("inline_message_id")
        val inlineMessageId: String? = null,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): EditInlineMessageText {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the content of a live location in an inline message sent via a bot
     *
     * @property inlineMessageId Inline message identifier
     * @property replyMarkup The new message reply markup
     * @property location New location content of the message
     *                    Pass null to stop sharing the live location
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editInlineMessageLiveLocation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageLiveLocation"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class EditInlineMessageLiveLocation(
        @SerialName("inline_message_id")
        val inlineMessageId: String? = null,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("location")
        val location: Location? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): EditInlineMessageLiveLocation {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot
     *
     * @property inlineMessageId Inline message identifier
     * @property replyMarkup The new message reply markup
     * @property inputMessageContent New content of the message
     *                               Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editInlineMessageMedia")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageMedia"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class EditInlineMessageMedia(
        @SerialName("inline_message_id")
        val inlineMessageId: String? = null,
        @SerialName("reply_markup")
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("input_message_content")
        val inputMessageContent: InputMessageContent? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): EditInlineMessageMedia {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the caption of an inline message sent via a bot
     *
     * @property inlineMessageId Inline message identifier
     * @property replyMarkup The new message reply markup
     * @property caption New message content caption
     *                   0-GetOption("message_caption_length_max") characters
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editInlineMessageCaption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageCaption"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class EditInlineMessageCaption(
        @SerialName("inline_message_id")
        val inlineMessageId: String? = null,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("caption")
        val caption: FormattedText? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): EditInlineMessageCaption {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits the reply markup of an inline message sent via a bot
     *
     * @property inlineMessageId Inline message identifier
     * @property replyMarkup The new message reply markup
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editInlineMessageReplyMarkup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageReplyMarkup"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class EditInlineMessageReplyMarkup(
        @SerialName("inline_message_id")
        val inlineMessageId: String? = null,
        @SerialName("reply_markup")
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): EditInlineMessageReplyMarkup {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
     * This is an offline method
     * Can be called before authorization
     *
     * @property text The text in which to look for entites
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getTextEntities")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTextEntities"),
        level = DeprecationLevel.WARNING
    )
    data class GetTextEntities(
        @SerialName("text")
        val text: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<TextEntities> {
        override fun withRequestId(id: Long): GetTextEntities {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
     * This is an offline method
     * Can be called before authorization
     *
     * @property text The text which should be parsed
     * @property parseMode Text parse mode
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("parseTextEntities")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdParseTextEntities"),
        level = DeprecationLevel.WARNING
    )
    data class ParseTextEntities(
        @SerialName("text")
        val text: String? = null,
        @SerialName("parse_mode")
        val parseMode: TextParseMode? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<FormattedText> {
        override fun withRequestId(id: Long): ParseTextEntities {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the MIME type of a file, guessed by its extension
     * Returns an empty string on failure
     * This is an offline method
     * Can be called before authorization
     *
     * @property fileName The name of the file or path to the file
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getFileMimeType")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFileMimeType"),
        level = DeprecationLevel.WARNING
    )
    data class GetFileMimeType(
        @SerialName("file_name")
        val fileName: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Text> {
        override fun withRequestId(id: Long): GetFileMimeType {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the extension of a file, guessed by its MIME type
     * Returns an empty string on failure
     * This is an offline method
     * Can be called before authorization
     *
     * @property mimeType The MIME type of the file
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getFileExtension")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFileExtension"),
        level = DeprecationLevel.WARNING
    )
    data class GetFileExtension(
        @SerialName("mime_type")
        val mimeType: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Text> {
        override fun withRequestId(id: Long): GetFileExtension {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes potentially dangerous characters from the name of a file
     * The encoding of the file name is supposed to be UTF-8
     * Returns an empty string on failure
     * This is an offline method
     * Can be called before authorization
     *
     * @property fileName File name or path to the file
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("cleanFileName")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCleanFileName"),
        level = DeprecationLevel.WARNING
    )
    data class CleanFileName(
        @SerialName("file_name")
        val fileName: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Text> {
        override fun withRequestId(id: Long): CleanFileName {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a string stored in the local database from the specified localization target and language pack by its key
     * Returns a 404 error if the string is not found
     * This is an offline method
     * Can be called before authorization
     *
     * @property languagePackDatabasePath Path to the language pack database in which strings are stored
     * @property localizationTarget Localization target to which the language pack belongs
     * @property languagePackId Language pack identifier
     * @property key Language pack key of the string to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLanguagePackString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLanguagePackString"),
        level = DeprecationLevel.WARNING
    )
    data class GetLanguagePackString(
        @SerialName("language_pack_database_path")
        val languagePackDatabasePath: String? = null,
        @SerialName("localization_target")
        val localizationTarget: String? = null,
        @SerialName("language_pack_id")
        val languagePackId: String? = null,
        @SerialName("key")
        val key: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<LanguagePackStringValue> {
        override fun withRequestId(id: Long): GetLanguagePackString {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Converts a JSON-serialized string to corresponding JsonValue object
     * This is an offline method
     * Can be called before authorization
     *
     * @property json The JSON-serialized string
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getJsonValue")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetJsonValue"),
        level = DeprecationLevel.WARNING
    )
    data class GetJsonValue(
        @SerialName("json")
        val json: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<JsonValue> {
        override fun withRequestId(id: Long): GetJsonValue {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Converts a JsonValue object to corresponding JSON-serialized string
     * This is an offline method
     * Can be called before authorization
     *
     * @property jsonValue The JsonValue object
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getJsonString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetJsonString"),
        level = DeprecationLevel.WARNING
    )
    data class GetJsonString(
        @SerialName("json_value")
        val jsonValue: JsonValue? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Text> {
        override fun withRequestId(id: Long): GetJsonString {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes user answer to a poll
     *
     * @property chatId Identifier of the chat to which the poll belongs
     * @property messageId Identifier of the message containing the poll
     * @property optionIds 0-based identifiers of options, chosen by the user
     *                     Currently user can't choose more than 1 option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setPollAnswer")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPollAnswer"),
        level = DeprecationLevel.WARNING
    )
    data class SetPollAnswer(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("option_ids")
        val optionIds: IntArray = intArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetPollAnswer {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Stops a poll
     * A poll in a message can be stopped when the message has can_be_edited flag set
     *
     * @property chatId Identifier of the chat to which the poll belongs
     * @property messageId Identifier of the message containing the poll
     * @property replyMarkup The new message reply markup
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("stopPoll")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStopPoll"),
        level = DeprecationLevel.WARNING
    )
    data class StopPoll(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("reply_markup")
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): StopPoll {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends an inline query to a bot and returns its results
     * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
     *
     * @property botUserId The identifier of the target bot
     * @property chatId Identifier of the chat, where the query was sent
     * @property userLocation Location of the user, only if needed
     * @property query Text of the query
     * @property offset Offset of the first entry to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getInlineQueryResults")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInlineQueryResults"),
        level = DeprecationLevel.WARNING
    )
    data class GetInlineQueryResults(
        @SerialName("bot_user_id")
        val botUserId: Int = 0,
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("user_location")
        val userLocation: Location? = null,
        @SerialName("query")
        val query: String? = null,
        @SerialName("offset")
        val offset: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<InlineQueryResults> {
        override fun withRequestId(id: Long): GetInlineQueryResults {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the result of an inline query
     *
     * @property inlineQueryId Identifier of the inline query
     * @property isPersonal True, if the result of the query can be cached for the specified user
     * @property results The results of the query
     * @property cacheTime Allowed time to cache the results of the query, in seconds
     * @property nextOffset Offset for the next inline query
     *                      Pass an empty string if there are no more results
     * @property switchPmText If non-empty, this text should be shown on the button that opens a private chat with the bot and sends a start message to the bot with the parameter switch_pm_parameter
     * @property switchPmParameter The parameter for the bot start message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("answerInlineQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerInlineQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class AnswerInlineQuery(
        @SerialName("inline_query_id")
        val inlineQueryId: Long = 0L,
        @SerialName("is_personal")
        val isPersonal: Boolean = false,
        @SerialName("results")
        val results: Array<InputInlineQueryResult> = emptyArray(),
        @SerialName("cache_time")
        val cacheTime: Int = 0,
        @SerialName("next_offset")
        val nextOffset: String? = null,
        @SerialName("switch_pm_text")
        val switchPmText: String? = null,
        @SerialName("switch_pm_parameter")
        val switchPmParameter: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AnswerInlineQuery {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a callback query to a bot and returns an answer
     * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
     *
     * @property chatId Identifier of the chat with the message
     * @property messageId Identifier of the message from which the query originated
     * @property payload Query payload
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getCallbackQueryAnswer")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCallbackQueryAnswer"),
        level = DeprecationLevel.WARNING
    )
    data class GetCallbackQueryAnswer(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("payload")
        val payload: CallbackQueryPayload? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<CallbackQueryAnswer> {
        override fun withRequestId(id: Long): GetCallbackQueryAnswer {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the result of a callback query
     *
     * @property callbackQueryId Identifier of the callback query
     * @property text Text of the answer
     * @property showAlert If true, an alert should be shown to the user instead of a toast notification
     * @property url URL to be opened
     * @property cacheTime Time during which the result of the query can be cached, in seconds
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("answerCallbackQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerCallbackQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class AnswerCallbackQuery(
        @SerialName("callback_query_id")
        val callbackQueryId: Long = 0L,
        @SerialName("text")
        val text: String? = null,
        @SerialName("show_alert")
        val showAlert: Boolean = false,
        @SerialName("url")
        val url: String? = null,
        @SerialName("cache_time")
        val cacheTime: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AnswerCallbackQuery {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the result of a shipping query
     *
     * @property shippingQueryId Identifier of the shipping query
     * @property shippingOptions Available shipping options
     * @property errorMessage An error message, empty on success
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("answerShippingQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerShippingQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class AnswerShippingQuery(
        @SerialName("shipping_query_id")
        val shippingQueryId: Long = 0L,
        @SerialName("shipping_options")
        val shippingOptions: Array<ShippingOption> = emptyArray(),
        @SerialName("error_message")
        val errorMessage: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AnswerShippingQuery {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the result of a pre-checkout query
     *
     * @property preCheckoutQueryId Identifier of the pre-checkout query
     * @property errorMessage An error message, empty on success
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("answerPreCheckoutQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerPreCheckoutQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class AnswerPreCheckoutQuery(
        @SerialName("pre_checkout_query_id")
        val preCheckoutQueryId: Long = 0L,
        @SerialName("error_message")
        val errorMessage: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AnswerPreCheckoutQuery {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Updates the game score of the specified user in the game
     *
     * @property chatId The chat to which the message with the game belongs
     * @property messageId Identifier of the message
     * @property editMessage True, if the message should be edited
     * @property userId User identifier
     * @property score The new score
     * @property force Pass true to update the score even if it decreases
     *                 If the score is 0, the user will be deleted from the high score table
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setGameScore")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetGameScore"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class SetGameScore(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("edit_message")
        val editMessage: Boolean = false,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("score")
        val score: Int = 0,
        @SerialName("force")
        val force: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Message> {
        override fun withRequestId(id: Long): SetGameScore {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Updates the game score of the specified user in a game
     *
     * @property inlineMessageId Inline message identifier
     * @property editMessage True, if the message should be edited
     * @property userId User identifier
     * @property score The new score
     * @property force Pass true to update the score even if it decreases
     *                 If the score is 0, the user will be deleted from the high score table
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setInlineGameScore")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetInlineGameScore"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class SetInlineGameScore(
        @SerialName("inline_message_id")
        val inlineMessageId: String? = null,
        @SerialName("edit_message")
        val editMessage: Boolean = false,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("score")
        val score: Int = 0,
        @SerialName("force")
        val force: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetInlineGameScore {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the high scores for a game and some part of the high score table in the range of the specified user
     *
     * @property chatId The chat that contains the message with the game
     * @property messageId Identifier of the message
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getGameHighScores")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetGameHighScores"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class GetGameHighScores(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<GameHighScores> {
        override fun withRequestId(id: Long): GetGameHighScores {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns game high scores and some part of the high score table in the range of the specified user
     *
     * @property inlineMessageId Inline message identifier
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getInlineGameHighScores")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInlineGameHighScores"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class GetInlineGameHighScores(
        @SerialName("inline_message_id")
        val inlineMessageId: String? = null,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<GameHighScores> {
        override fun withRequestId(id: Long): GetInlineGameHighScores {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes the default reply markup from a chat
     * Must be called after a one-time keyboard or a ForceReply reply markup has been used
     * UpdateChatReplyMarkup will be sent if the reply markup will be changed
     *
     * @property chatId Chat identifier
     * @property messageId The message identifier of the used keyboard
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteChatReplyMarkup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteChatReplyMarkup"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteChatReplyMarkup(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteChatReplyMarkup {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a notification about user activity in a chat
     *
     * @property chatId Chat identifier
     * @property action The action description
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendChatAction")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendChatAction"),
        level = DeprecationLevel.WARNING
    )
    data class SendChatAction(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("action")
        val action: ChatAction? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SendChatAction {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs TDLib that the chat is opened by the user
     * Many useful activities depend on the chat being opened or closed (e.g., in supergroups and channels all updates are received only for opened chats)
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("openChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOpenChat"),
        level = DeprecationLevel.WARNING
    )
    data class OpenChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): OpenChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs TDLib that the chat is closed by the user
     * Many useful activities depend on the chat being opened or closed
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("closeChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCloseChat"),
        level = DeprecationLevel.WARNING
    )
    data class CloseChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CloseChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs TDLib that messages are being viewed by the user
     * Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
     *
     * @property chatId Chat identifier
     * @property messageIds The identifiers of the messages being viewed
     * @property forceRead True, if messages in closed chats should be marked as read
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("viewMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdViewMessages"),
        level = DeprecationLevel.WARNING
    )
    data class ViewMessages(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_ids")
        val messageIds: LongArray = longArrayOf(),
        @SerialName("force_read")
        val forceRead: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ViewMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
     * An updateMessageContentOpened update will be generated if something has changed
     *
     * @property chatId Chat identifier of the message
     * @property messageId Identifier of the message with the opened content
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("openMessageContent")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOpenMessageContent"),
        level = DeprecationLevel.WARNING
    )
    data class OpenMessageContent(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): OpenMessageContent {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Marks all mentions in a chat as read
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("readAllChatMentions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReadAllChatMentions"),
        level = DeprecationLevel.WARNING
    )
    data class ReadAllChatMentions(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ReadAllChatMentions {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an existing chat corresponding to a given user
     *
     * @property userId User identifier
     * @property force If true, the chat will be created without network request
     *                 In this case all information about the chat except its type, title and photo can be incorrect
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createPrivateChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreatePrivateChat"),
        level = DeprecationLevel.WARNING
    )
    data class CreatePrivateChat(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("force")
        val force: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): CreatePrivateChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an existing chat corresponding to a known basic group
     *
     * @property basicGroupId Basic group identifier
     * @property force If true, the chat will be created without network request
     *                 In this case all information about the chat except its type, title and photo can be incorrect
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createBasicGroupChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateBasicGroupChat"),
        level = DeprecationLevel.WARNING
    )
    data class CreateBasicGroupChat(
        @SerialName("basic_group_id")
        val basicGroupId: Int = 0,
        @SerialName("force")
        val force: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): CreateBasicGroupChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an existing chat corresponding to a known supergroup or channel
     *
     * @property supergroupId Supergroup or channel identifier
     * @property force If true, the chat will be created without network request
     *                 In this case all information about the chat except its type, title and photo can be incorrect
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createSupergroupChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateSupergroupChat"),
        level = DeprecationLevel.WARNING
    )
    data class CreateSupergroupChat(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("force")
        val force: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): CreateSupergroupChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an existing chat corresponding to a known secret chat
     *
     * @property secretChatId Secret chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createSecretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateSecretChat"),
        level = DeprecationLevel.WARNING
    )
    data class CreateSecretChat(
        @SerialName("secret_chat_id")
        val secretChatId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): CreateSecretChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate
     * Returns the newly created chat
     *
     * @property userIds Identifiers of users to be added to the basic group
     * @property title Title of the new basic group
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createNewBasicGroupChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewBasicGroupChat"),
        level = DeprecationLevel.WARNING
    )
    data class CreateNewBasicGroupChat(
        @SerialName("user_ids")
        val userIds: IntArray = intArrayOf(),
        @SerialName("title")
        val title: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): CreateNewBasicGroupChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate
     * Returns the newly created chat
     *
     * @property title Title of the new chat
     * @property isChannel True, if a channel chat should be created
     * @property description Chat description
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createNewSupergroupChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewSupergroupChat"),
        level = DeprecationLevel.WARNING
    )
    data class CreateNewSupergroupChat(
        @SerialName("title")
        val title: String? = null,
        @SerialName("is_channel")
        val isChannel: Boolean = false,
        @SerialName("description")
        val description: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): CreateNewSupergroupChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Creates a new secret chat
     * Returns the newly created chat
     *
     * @property userId Identifier of the target user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createNewSecretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewSecretChat"),
        level = DeprecationLevel.WARNING
    )
    data class CreateNewSecretChat(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): CreateNewSecretChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom
     * Requires creator privileges
     * Deactivates the original basic group
     *
     * @property chatId Identifier of the chat to upgrade
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("upgradeBasicGroupChatToSupergroupChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpgradeBasicGroupChatToSupergroupChat"),
        level = DeprecationLevel.WARNING
    )
    data class UpgradeBasicGroupChatToSupergroupChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): UpgradeBasicGroupChatToSupergroupChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the chat title
     * Supported only for basic groups, supergroups and channels
     * Requires can_change_info rights
     * The title will not be changed until the request to the server has been completed
     *
     * @property chatId Chat identifier
     * @property title New title of the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatTitle")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatTitle"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatTitle(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("title")
        val title: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatTitle {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the photo of a chat
     * Supported only for basic groups, supergroups and channels
     * Requires can_change_info rights
     * The photo will not be changed before request to the server has been completed
     *
     * @property chatId Chat identifier
     * @property photo New chat photo
     *                 You can use a zero InputFileId to delete the chat photo
     *                 Files that are accessible only by HTTP URL are not acceptable
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatPhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatPhoto"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatPhoto(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("photo")
        val photo: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatPhoto {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the chat members permissions
     * Supported only for basic groups and supergroups
     * Requires can_restrict_members administrator right
     *
     * @property chatId Chat identifier
     * @property permissions New non-administrator members permissions in the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatPermissions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatPermissions"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatPermissions(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("permissions")
        val permissions: ChatPermissions? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatPermissions {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the draft message in a chat
     *
     * @property chatId Chat identifier
     * @property draftMessage New draft message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatDraftMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatDraftMessage"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatDraftMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("draft_message")
        val draftMessage: DraftMessage? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatDraftMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the notification settings of a chat
     *
     * @property chatId Chat identifier
     * @property notificationSettings New notification settings for the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatNotificationSettings(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("notification_settings")
        val notificationSettings: ChatNotificationSettings? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatNotificationSettings {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the pinned state of a chat
     * You can pin up to GetOption("pinned_chat_count_max") non-secret chats and the same number of secret chats
     *
     * @property chatId Chat identifier
     * @property isPinned New value of is_pinned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("toggleChatIsPinned")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleChatIsPinned"),
        level = DeprecationLevel.WARNING
    )
    data class ToggleChatIsPinned(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("is_pinned")
        val isPinned: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ToggleChatIsPinned {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the marked as unread state of a chat
     *
     * @property chatId Chat identifier
     * @property isMarkedAsUnread New value of is_marked_as_unread
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("toggleChatIsMarkedAsUnread")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleChatIsMarkedAsUnread"),
        level = DeprecationLevel.WARNING
    )
    data class ToggleChatIsMarkedAsUnread(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("is_marked_as_unread")
        val isMarkedAsUnread: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ToggleChatIsMarkedAsUnread {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
     *
     * @property chatId Chat identifier
     * @property defaultDisableNotification New value of default_disable_notification
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("toggleChatDefaultDisableNotification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleChatDefaultDisableNotification"),
        level = DeprecationLevel.WARNING
    )
    data class ToggleChatDefaultDisableNotification(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("default_disable_notification")
        val defaultDisableNotification: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ToggleChatDefaultDisableNotification {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes client data associated with a chat
     *
     * @property chatId Chat identifier
     * @property clientData New value of client_data
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatClientData")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatClientData"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatClientData(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("client_data")
        val clientData: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatClientData {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes information about a chat
     * Available for basic groups, supergroups, and channels
     * Requires can_change_info rights
     *
     * @property chatId Identifier of the chat
     * @property description New chat description
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatDescription")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatDescription"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatDescription(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("description")
        val description: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatDescription {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Pins a message in a chat
     * Requires can_pin_messages rights
     *
     * @property chatId Identifier of the chat
     * @property messageId Identifier of the new pinned message
     * @property disableNotification True, if there should be no notification about the pinned message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("pinChatMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPinChatMessage"),
        level = DeprecationLevel.WARNING
    )
    data class PinChatMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("disable_notification")
        val disableNotification: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): PinChatMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes the pinned message from a chat
     * Requires can_pin_messages rights in the group or channel
     *
     * @property chatId Identifier of the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("unpinChatMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUnpinChatMessage"),
        level = DeprecationLevel.WARNING
    )
    data class UnpinChatMessage(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): UnpinChatMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds current user as a new member to a chat
     * Private and secret chats can't be joined using this method
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("joinChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJoinChat"),
        level = DeprecationLevel.WARNING
    )
    data class JoinChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): JoinChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes current user from chat members
     * Private and secret chats can't be left using this method
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("leaveChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLeaveChat"),
        level = DeprecationLevel.WARNING
    )
    data class LeaveChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): LeaveChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a new member to a chat
     * Members can't be added to private or secret chats
     * Members will not be added until the chat state has been synchronized with the server
     *
     * @property chatId Chat identifier
     * @property userId Identifier of the user
     * @property forwardLimit The number of earlier messages from the chat to be forwarded to the new member
     *                        Ignored for supergroups and channels
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addChatMember")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddChatMember"),
        level = DeprecationLevel.WARNING
    )
    data class AddChatMember(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("forward_limit")
        val forwardLimit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AddChatMember {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds multiple new members to a chat
     * Currently this option is only available for supergroups and channels
     * This option can't be used to join a chat
     * Members can't be added to a channel if it has more than 200 members
     * Members will not be added until the chat state has been synchronized with the server
     *
     * @property chatId Chat identifier
     * @property userIds Identifiers of the users to be added to the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addChatMembers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddChatMembers"),
        level = DeprecationLevel.WARNING
    )
    data class AddChatMembers(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("user_ids")
        val userIds: IntArray = intArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AddChatMembers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the status of a chat member, needs appropriate privileges
     * This function is currently not suitable for adding new members to the chat
     * Instead, use addChatMember
     * The chat member status will not be changed until it has been synchronized with the server
     *
     * @property chatId Chat identifier
     * @property userId User identifier
     * @property status The new status of the member in the chat
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setChatMemberStatus")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatMemberStatus"),
        level = DeprecationLevel.WARNING
    )
    data class SetChatMemberStatus(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("status")
        val status: ChatMemberStatus? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetChatMemberStatus {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a single member of a chat
     *
     * @property chatId Chat identifier
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatMember")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatMember"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatMember(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ChatMember> {
        override fun withRequestId(id: Long): GetChatMember {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for a specified query in the first name, last name and username of the members of a specified chat
     * Requires administrator rights in channels
     *
     * @property chatId Chat identifier
     * @property query Query to search for
     * @property limit The maximum number of users to be returned
     * @property filter The type of users to return
     *                  By default, chatMembersFilterMembers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchChatMembers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatMembers"),
        level = DeprecationLevel.WARNING
    )
    data class SearchChatMembers(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("query")
        val query: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("filter")
        val filter: ChatMembersFilter? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ChatMembers> {
        override fun withRequestId(id: Long): SearchChatMembers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of users who are administrators of the chat
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatAdministrators")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatAdministrators"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatAdministrators(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Users> {
        override fun withRequestId(id: Long): GetChatAdministrators {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Clears draft messages in all chats
     *
     * @property excludeSecretChats If true, local draft messages in secret chats will not be cleared
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("clearAllDraftMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearAllDraftMessages"),
        level = DeprecationLevel.WARNING
    )
    data class ClearAllDraftMessages(
        @SerialName("exclude_secret_chats")
        val excludeSecretChats: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ClearAllDraftMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns list of chats with non-default notification settings
     *
     * @property scope If specified, only chats from the specified scope will be returned
     * @property compareSound If true, also chats with non-default sound will be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatNotificationSettingsExceptions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatNotificationSettingsExceptions"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatNotificationSettingsExceptions(
        @SerialName("scope")
        val scope: NotificationSettingsScope? = null,
        @SerialName("compare_sound")
        val compareSound: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chats> {
        override fun withRequestId(id: Long): GetChatNotificationSettingsExceptions {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the notification settings for chats of a given type
     *
     * @property scope Types of chats for which to return the notification settings information
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getScopeNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetScopeNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class GetScopeNotificationSettings(
        @SerialName("scope")
        val scope: NotificationSettingsScope? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ScopeNotificationSettings> {
        override fun withRequestId(id: Long): GetScopeNotificationSettings {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes notification settings for chats of a given type
     *
     * @property scope Types of chats for which to change the notification settings
     * @property notificationSettings The new notification settings for the given scope
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setScopeNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetScopeNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class SetScopeNotificationSettings(
        @SerialName("scope")
        val scope: NotificationSettingsScope? = null,
        @SerialName("notification_settings")
        val notificationSettings: ScopeNotificationSettings? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetScopeNotificationSettings {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Resets all notification settings to their default values
     * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resetAllNotificationSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResetAllNotificationSettings"),
        level = DeprecationLevel.WARNING
    )
    data class ResetAllNotificationSettings(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ResetAllNotificationSettings {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the order of pinned chats
     *
     * @property chatIds The new list of pinned chats
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setPinnedChats")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPinnedChats"),
        level = DeprecationLevel.WARNING
    )
    data class SetPinnedChats(
        @SerialName("chat_ids")
        val chatIds: LongArray = longArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetPinnedChats {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Downloads a file from the cloud
     * Download progress and completion of the download will be notified through updateFile updates
     *
     * @property fileId Identifier of the file to download
     * @property priority Priority of the download (1-32)
     *                    The higher the priority, the earlier the file will be downloaded
     *                    If the priorities of two files are equal, then the last one for which downloadFile was called will be downloaded first
     * @property offset The starting position from which the file should be downloaded
     * @property limit Number of bytes which should be downloaded starting from the "offset" position before the download will be automatically cancelled
     *                 Use 0 to download without a limit
     * @property synchronous If false, this request returns file state just after the download has been started
     *                       If true, this request returns file state only after the download has succeeded, has failed, has been cancelled or a new downloadFile request with different offset/limit parameters was sent
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("downloadFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDownloadFile"),
        level = DeprecationLevel.WARNING
    )
    data class DownloadFile(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("priority")
        val priority: Int = 0,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("synchronous")
        val synchronous: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<File> {
        override fun withRequestId(id: Long): DownloadFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns file downloaded prefix size from a given offset
     *
     * @property fileId Identifier of the file
     * @property offset Offset from which downloaded prefix size should be calculated
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getFileDownloadedPrefixSize")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFileDownloadedPrefixSize"),
        level = DeprecationLevel.WARNING
    )
    data class GetFileDownloadedPrefixSize(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Count> {
        override fun withRequestId(id: Long): GetFileDownloadedPrefixSize {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Stops the downloading of a file
     * If a file has already been downloaded, does nothing
     *
     * @property fileId Identifier of a file to stop downloading
     * @property onlyIfPending Pass true to stop downloading only if it hasn't been started, i.e
     *                         Request hasn't been sent to server
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("cancelDownloadFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCancelDownloadFile"),
        level = DeprecationLevel.WARNING
    )
    data class CancelDownloadFile(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("only_if_pending")
        val onlyIfPending: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CancelDownloadFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Asynchronously uploads a file to the cloud without sending it in a message
     * UpdateFile will be used to notify about upload progress and successful completion of the upload
     * The file will not have a persistent remote identifier until it will be sent in a message
     *
     * @property file File to upload
     * @property fileType File type
     * @property priority Priority of the upload (1-32)
     *                    The higher the priority, the earlier the file will be uploaded
     *                    If the priorities of two files are equal, then the first one for which uploadFile was called will be uploaded first
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("uploadFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUploadFile"),
        level = DeprecationLevel.WARNING
    )
    data class UploadFile(
        @SerialName("file")
        val file: InputFile? = null,
        @SerialName("file_type")
        val fileType: FileType? = null,
        @SerialName("priority")
        val priority: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<File> {
        override fun withRequestId(id: Long): UploadFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Stops the uploading of a file
     * Supported only for files uploaded by using uploadFile
     * For other files the behavior is undefined
     *
     * @property fileId Identifier of the file to stop uploading
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("cancelUploadFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCancelUploadFile"),
        level = DeprecationLevel.WARNING
    )
    data class CancelUploadFile(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CancelUploadFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Writes a part of a generated file
     * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
     *
     * @property generationId The identifier of the generation process
     * @property offset The offset from which to write the data to the file
     * @property data The data to write
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("writeGeneratedFilePart")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdWriteGeneratedFilePart"),
        level = DeprecationLevel.WARNING
    )
    data class WriteGeneratedFilePart(
        @SerialName("generation_id")
        val generationId: Long = 0L,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("data")
        val data: ByteArray = byteArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): WriteGeneratedFilePart {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs TDLib on a file generation prograss
     *
     * @property generationId The identifier of the generation process
     * @property expectedSize Expected size of the generated file, in bytes
     *                        0 if unknown
     * @property localPrefixSize The number of bytes already generated
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setFileGenerationProgress")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetFileGenerationProgress"),
        level = DeprecationLevel.WARNING
    )
    data class SetFileGenerationProgress(
        @SerialName("generation_id")
        val generationId: Long = 0L,
        @SerialName("expected_size")
        val expectedSize: Int = 0,
        @SerialName("local_prefix_size")
        val localPrefixSize: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetFileGenerationProgress {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Finishes the file generation
     *
     * @property generationId The identifier of the generation process
     * @property error If set, means that file generation has failed and should be terminated
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("finishFileGeneration")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFinishFileGeneration"),
        level = DeprecationLevel.WARNING
    )
    data class FinishFileGeneration(
        @SerialName("generation_id")
        val generationId: Long = 0L,
        @SerialName("error")
        val error: Error? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): FinishFileGeneration {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Reads a part of a file from the TDLib file cache and returns read bytes
     * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
     *
     * @property fileId Identifier of the file
     *                  The file must be located in the TDLib file cache
     * @property offset The offset from which to read the file
     * @property count Number of bytes to read
     *                 An error will be returned if there are not enough bytes available in the file from the specified position
     *                 Pass 0 to read all available data from the specified position
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("readFilePart")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReadFilePart"),
        level = DeprecationLevel.WARNING
    )
    data class ReadFilePart(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("count")
        val count: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<FilePart> {
        override fun withRequestId(id: Long): ReadFilePart {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes a file from the TDLib file cache
     *
     * @property fileId Identifier of the file to delete
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteFile"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteFile(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Generates a new invite link for a chat
     * The previously generated link is revoked
     * Available for basic groups, supergroups, and channels
     * Requires administrator privileges and can_invite_users right
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("generateChatInviteLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGenerateChatInviteLink"),
        level = DeprecationLevel.WARNING
    )
    data class GenerateChatInviteLink(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ChatInviteLink> {
        override fun withRequestId(id: Long): GenerateChatInviteLink {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the validity of an invite link for a chat and returns information about the corresponding chat
     *
     * @property inviteLink Invite link to be checked
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChatInviteLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatInviteLink"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChatInviteLink(
        @SerialName("invite_link")
        val inviteLink: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ChatInviteLinkInfo> {
        override fun withRequestId(id: Long): CheckChatInviteLink {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Uses an invite link to add the current user to the chat if possible
     * The new member will not be added until the chat state has been synchronized with the server
     *
     * @property inviteLink Invite link to import
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("joinChatByInviteLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJoinChatByInviteLink"),
        level = DeprecationLevel.WARNING
    )
    data class JoinChatByInviteLink(
        @SerialName("invite_link")
        val inviteLink: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Chat> {
        override fun withRequestId(id: Long): JoinChatByInviteLink {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Creates a new call
     *
     * @property userId Identifier of the user to be called
     * @property protocol Description of the call protocols supported by the client
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateCall"),
        level = DeprecationLevel.WARNING
    )
    data class CreateCall(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("protocol")
        val protocol: CallProtocol? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<CallId> {
        override fun withRequestId(id: Long): CreateCall {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Accepts an incoming call
     *
     * @property callId Call identifier
     * @property protocol Description of the call protocols supported by the client
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("acceptCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAcceptCall"),
        level = DeprecationLevel.WARNING
    )
    data class AcceptCall(
        @SerialName("call_id")
        val callId: Int = 0,
        @SerialName("protocol")
        val protocol: CallProtocol? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AcceptCall {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Discards a call
     *
     * @property callId Call identifier
     * @property isDisconnected True, if the user was disconnected
     * @property duration The call duration, in seconds
     * @property connectionId Identifier of the connection used during the call
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("discardCall")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDiscardCall"),
        level = DeprecationLevel.WARNING
    )
    data class DiscardCall(
        @SerialName("call_id")
        val callId: Int = 0,
        @SerialName("is_disconnected")
        val isDisconnected: Boolean = false,
        @SerialName("duration")
        val duration: Int = 0,
        @SerialName("connection_id")
        val connectionId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DiscardCall {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a call rating
     *
     * @property callId Call identifier
     * @property rating Call rating
     * @property comment An optional user comment if the rating is less than 5
     * @property problems List of the exact types of problems with the call, specified by the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendCallRating")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendCallRating"),
        level = DeprecationLevel.WARNING
    )
    data class SendCallRating(
        @SerialName("call_id")
        val callId: Int = 0,
        @SerialName("rating")
        val rating: Int = 0,
        @SerialName("comment")
        val comment: String? = null,
        @SerialName("problems")
        val problems: Array<CallProblem> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SendCallRating {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends debug information for a call
     *
     * @property callId Call identifier
     * @property debugInformation Debug information in application-specific format
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendCallDebugInformation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendCallDebugInformation"),
        level = DeprecationLevel.WARNING
    )
    data class SendCallDebugInformation(
        @SerialName("call_id")
        val callId: Int = 0,
        @SerialName("debug_information")
        val debugInformation: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SendCallDebugInformation {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a user to the blacklist
     *
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("blockUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBlockUser"),
        level = DeprecationLevel.WARNING
    )
    data class BlockUser(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): BlockUser {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a user from the blacklist
     *
     * @property userId User identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("unblockUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUnblockUser"),
        level = DeprecationLevel.WARNING
    )
    data class UnblockUser(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): UnblockUser {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns users that were blocked by the current user
     *
     * @property offset Number of users to skip in the result
     * @property limit Maximum number of users to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getBlockedUsers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBlockedUsers"),
        level = DeprecationLevel.WARNING
    )
    data class GetBlockedUsers(
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Users> {
        override fun withRequestId(id: Long): GetBlockedUsers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds new contacts or edits existing contacts
     * Contacts' user identifiers are ignored
     *
     * @property contacts The list of contacts to import or edit, contact's vCard are ignored and are not imported
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("importContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdImportContacts"),
        level = DeprecationLevel.WARNING
    )
    data class ImportContacts(
        @SerialName("contacts")
        val contacts: Array<Contact> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ImportedContacts> {
        override fun withRequestId(id: Long): ImportContacts {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns all user contacts
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetContacts"),
        level = DeprecationLevel.WARNING
    )
    data class GetContacts(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Users> {
        override fun withRequestId(id: Long): GetContacts {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for the specified query in the first names, last names and usernames of the known user contacts
     *
     * @property query Query to search for
     *                 May be empty to return all contacts
     * @property limit Maximum number of users to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchContacts"),
        level = DeprecationLevel.WARNING
    )
    data class SearchContacts(
        @SerialName("query")
        val query: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Users> {
        override fun withRequestId(id: Long): SearchContacts {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes users from the contact list
     *
     * @property userIds Identifiers of users to be deleted
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveContacts"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveContacts(
        @SerialName("user_ids")
        val userIds: IntArray = intArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveContacts {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the total number of imported contacts
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getImportedContactCount")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetImportedContactCount"),
        level = DeprecationLevel.WARNING
    )
    data class GetImportedContactCount(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Count> {
        override fun withRequestId(id: Long): GetImportedContactCount {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes imported contacts using the list of current user contacts saved on the device
     * Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts
     * Query result depends on the result of the previous query, so only one query is possible at the same time
     *
     * @property contacts The new list of contacts, contact's vCard are ignored and are not imported
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("changeImportedContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChangeImportedContacts"),
        level = DeprecationLevel.WARNING
    )
    data class ChangeImportedContacts(
        @SerialName("contacts")
        val contacts: Array<Contact> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ImportedContacts> {
        override fun withRequestId(id: Long): ChangeImportedContacts {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Clears all imported contacts, contact list remains unchanged
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("clearImportedContacts")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearImportedContacts"),
        level = DeprecationLevel.WARNING
    )
    data class ClearImportedContacts(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ClearImportedContacts {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the profile photos of a user
     * The result of this query may be outdated: some photos might have been deleted already
     *
     * @property userId User identifier
     * @property offset The number of photos to skip
     * @property limit Maximum number of photos to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getUserProfilePhotos")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUserProfilePhotos"),
        level = DeprecationLevel.WARNING
    )
    data class GetUserProfilePhotos(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<UserProfilePhotos> {
        override fun withRequestId(id: Long): GetUserProfilePhotos {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns stickers from the installed sticker sets that correspond to a given emoji
     * If the emoji is not empty, favorite and recently used stickers may also be returned
     *
     * @property emoji String representation of emoji
     *                 If empty, returns all known installed stickers
     * @property limit Maximum number of stickers to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getStickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStickers"),
        level = DeprecationLevel.WARNING
    )
    data class GetStickers(
        @SerialName("emoji")
        val emoji: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Stickers> {
        override fun withRequestId(id: Long): GetStickers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for stickers from public sticker sets that correspond to a given emoji
     *
     * @property emoji String representation of emoji
     * @property limit Maximum number of stickers to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchStickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchStickers"),
        level = DeprecationLevel.WARNING
    )
    data class SearchStickers(
        @SerialName("emoji")
        val emoji: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Stickers> {
        override fun withRequestId(id: Long): SearchStickers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of installed sticker sets
     *
     * @property isMasks Pass true to return mask sticker sets
     *                   Pass false to return ordinary sticker sets
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getInstalledStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInstalledStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class GetInstalledStickerSets(
        @SerialName("is_masks")
        val isMasks: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSets> {
        override fun withRequestId(id: Long): GetInstalledStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of archived sticker sets
     *
     * @property isMasks Pass true to return mask stickers sets
     *                   Pass false to return ordinary sticker sets
     * @property offsetStickerSetId Identifier of the sticker set from which to return the result
     * @property limit Maximum number of sticker sets to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getArchivedStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetArchivedStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class GetArchivedStickerSets(
        @SerialName("is_masks")
        val isMasks: Boolean = false,
        @SerialName("offset_sticker_set_id")
        val offsetStickerSetId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSets> {
        override fun withRequestId(id: Long): GetArchivedStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of trending sticker sets
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getTrendingStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTrendingStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class GetTrendingStickerSets(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSets> {
        override fun withRequestId(id: Long): GetTrendingStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of sticker sets attached to a file
     * Currently only photos and videos can have attached sticker sets
     *
     * @property fileId File identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getAttachedStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAttachedStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class GetAttachedStickerSets(
        @SerialName("file_id")
        val fileId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSets> {
        override fun withRequestId(id: Long): GetAttachedStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a sticker set by its identifier
     *
     * @property setId Identifier of the sticker set
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getStickerSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStickerSet"),
        level = DeprecationLevel.WARNING
    )
    data class GetStickerSet(
        @SerialName("set_id")
        val setId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSet> {
        override fun withRequestId(id: Long): GetStickerSet {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for a sticker set by its name
     *
     * @property name Name of the sticker set
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchStickerSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchStickerSet"),
        level = DeprecationLevel.WARNING
    )
    data class SearchStickerSet(
        @SerialName("name")
        val name: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSet> {
        override fun withRequestId(id: Long): SearchStickerSet {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for installed sticker sets by looking for specified query in their title and name
     *
     * @property isMasks Pass true to return mask sticker sets
     *                   Pass false to return ordinary sticker sets
     * @property query Query to search for
     * @property limit Maximum number of sticker sets to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchInstalledStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchInstalledStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class SearchInstalledStickerSets(
        @SerialName("is_masks")
        val isMasks: Boolean = false,
        @SerialName("query")
        val query: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSets> {
        override fun withRequestId(id: Long): SearchInstalledStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for ordinary sticker sets by looking for specified query in their title and name
     * Excludes installed sticker sets from the results
     *
     * @property query Query to search for
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class SearchStickerSets(
        @SerialName("query")
        val query: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSets> {
        override fun withRequestId(id: Long): SearchStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Installs/uninstalls or activates/archives a sticker set
     *
     * @property setId Identifier of the sticker set
     * @property isInstalled The new value of is_installed
     * @property isArchived The new value of is_archived
     *                      A sticker set can't be installed and archived simultaneously
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("changeStickerSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChangeStickerSet"),
        level = DeprecationLevel.WARNING
    )
    data class ChangeStickerSet(
        @SerialName("set_id")
        val setId: Long = 0L,
        @SerialName("is_installed")
        val isInstalled: Boolean = false,
        @SerialName("is_archived")
        val isArchived: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ChangeStickerSet {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs the server that some trending sticker sets have been viewed by the user
     *
     * @property stickerSetIds Identifiers of viewed trending sticker sets
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("viewTrendingStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdViewTrendingStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class ViewTrendingStickerSets(
        @SerialName("sticker_set_ids")
        val stickerSetIds: LongArray = longArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ViewTrendingStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the order of installed sticker sets
     *
     * @property isMasks Pass true to change the order of mask sticker sets
     *                   Pass false to change the order of ordinary sticker sets
     * @property stickerSetIds Identifiers of installed sticker sets in the new correct order
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("reorderInstalledStickerSets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReorderInstalledStickerSets"),
        level = DeprecationLevel.WARNING
    )
    data class ReorderInstalledStickerSets(
        @SerialName("is_masks")
        val isMasks: Boolean = false,
        @SerialName("sticker_set_ids")
        val stickerSetIds: LongArray = longArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ReorderInstalledStickerSets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of recently used stickers
     *
     * @property isAttached Pass true to return stickers and masks that were recently attached to photos or video files
     *                      Pass false to return recently sent stickers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getRecentStickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecentStickers"),
        level = DeprecationLevel.WARNING
    )
    data class GetRecentStickers(
        @SerialName("is_attached")
        val isAttached: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Stickers> {
        override fun withRequestId(id: Long): GetRecentStickers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Manually adds a new sticker to the list of recently used stickers
     * The new sticker is added to the top of the list
     * If the sticker was already in the list, it is removed from the list first
     * Only stickers belonging to a sticker set can be added to this list
     *
     * @property isAttached Pass true to add the sticker to the list of stickers recently attached to photo or video files
     *                      Pass false to add the sticker to the list of recently sent stickers
     * @property sticker Sticker file to add
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addRecentSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddRecentSticker"),
        level = DeprecationLevel.WARNING
    )
    data class AddRecentSticker(
        @SerialName("is_attached")
        val isAttached: Boolean = false,
        @SerialName("sticker")
        val sticker: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Stickers> {
        override fun withRequestId(id: Long): AddRecentSticker {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a sticker from the list of recently used stickers
     *
     * @property isAttached Pass true to remove the sticker from the list of stickers recently attached to photo or video files
     *                      Pass false to remove the sticker from the list of recently sent stickers
     * @property sticker Sticker file to delete
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeRecentSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveRecentSticker"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveRecentSticker(
        @SerialName("is_attached")
        val isAttached: Boolean = false,
        @SerialName("sticker")
        val sticker: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveRecentSticker {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Clears the list of recently used stickers
     *
     * @property isAttached Pass true to clear the list of stickers recently attached to photo or video files
     *                      Pass false to clear the list of recently sent stickers
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("clearRecentStickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearRecentStickers"),
        level = DeprecationLevel.WARNING
    )
    data class ClearRecentStickers(
        @SerialName("is_attached")
        val isAttached: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ClearRecentStickers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns favorite stickers
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getFavoriteStickers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFavoriteStickers"),
        level = DeprecationLevel.WARNING
    )
    data class GetFavoriteStickers(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Stickers> {
        override fun withRequestId(id: Long): GetFavoriteStickers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a new sticker to the list of favorite stickers
     * The new sticker is added to the top of the list
     * If the sticker was already in the list, it is removed from the list first
     * Only stickers belonging to a sticker set can be added to this list
     *
     * @property sticker Sticker file to add
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addFavoriteSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddFavoriteSticker"),
        level = DeprecationLevel.WARNING
    )
    data class AddFavoriteSticker(
        @SerialName("sticker")
        val sticker: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AddFavoriteSticker {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a sticker from the list of favorite stickers
     *
     * @property sticker Sticker file to delete from the list
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeFavoriteSticker")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveFavoriteSticker"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveFavoriteSticker(
        @SerialName("sticker")
        val sticker: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveFavoriteSticker {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns emoji corresponding to a sticker
     * The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
     *
     * @property sticker Sticker file identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getStickerEmojis")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStickerEmojis"),
        level = DeprecationLevel.WARNING
    )
    data class GetStickerEmojis(
        @SerialName("sticker")
        val sticker: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Emojis> {
        override fun withRequestId(id: Long): GetStickerEmojis {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for emojis by keywords
     * Supported only if the file database is enabled
     *
     * @property text Text to search for
     * @property exactMatch True, if only emojis, which exactly match text needs to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchEmojis")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchEmojis"),
        level = DeprecationLevel.WARNING
    )
    data class SearchEmojis(
        @SerialName("text")
        val text: String? = null,
        @SerialName("exact_match")
        val exactMatch: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Emojis> {
        override fun withRequestId(id: Long): SearchEmojis {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements
     * The URL will be valid for 30 seconds after generation
     *
     * @property languageCode Language code for which the emoji replacements will be suggested
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getEmojiSuggestionsUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetEmojiSuggestionsUrl"),
        level = DeprecationLevel.WARNING
    )
    data class GetEmojiSuggestionsUrl(
        @SerialName("language_code")
        val languageCode: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<HttpUrl> {
        override fun withRequestId(id: Long): GetEmojiSuggestionsUrl {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns saved animations
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getSavedAnimations")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSavedAnimations"),
        level = DeprecationLevel.WARNING
    )
    data class GetSavedAnimations(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Animations> {
        override fun withRequestId(id: Long): GetSavedAnimations {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Manually adds a new animation to the list of saved animations
     * The new animation is added to the beginning of the list
     * If the animation was already in the list, it is removed first
     * Only non-secret video animations with MIME type "video/mp4" can be added to the list
     *
     * @property animation The animation file to be added
     *                     Only animations known to the server (i.e
     *                     Successfully sent via a message) can be added to the list
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addSavedAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddSavedAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class AddSavedAnimation(
        @SerialName("animation")
        val animation: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AddSavedAnimation {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes an animation from the list of saved animations
     *
     * @property animation Animation file to be removed
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeSavedAnimation")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveSavedAnimation"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveSavedAnimation(
        @SerialName("animation")
        val animation: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveSavedAnimation {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns up to 20 recently used inline bots in the order of their last usage
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getRecentInlineBots")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecentInlineBots"),
        level = DeprecationLevel.WARNING
    )
    data class GetRecentInlineBots(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Users> {
        override fun withRequestId(id: Long): GetRecentInlineBots {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for recently used hashtags by their prefix
     *
     * @property prefix Hashtag prefix to search for
     * @property limit Maximum number of hashtags to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchHashtags")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchHashtags"),
        level = DeprecationLevel.WARNING
    )
    data class SearchHashtags(
        @SerialName("prefix")
        val prefix: String? = null,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Hashtags> {
        override fun withRequestId(id: Long): SearchHashtags {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a hashtag from the list of recently used hashtags
     *
     * @property hashtag Hashtag to delete
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeRecentHashtag")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveRecentHashtag"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveRecentHashtag(
        @SerialName("hashtag")
        val hashtag: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveRecentHashtag {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a web page preview by the text of the message
     * Do not call this function too often
     * Returns a 404 error if the web page has no preview
     *
     * @property text Message text with formatting
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getWebPagePreview")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetWebPagePreview"),
        level = DeprecationLevel.WARNING
    )
    data class GetWebPagePreview(
        @SerialName("text")
        val text: FormattedText? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<WebPage> {
        override fun withRequestId(id: Long): GetWebPagePreview {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an instant view version of a web page if available
     * Returns a 404 error if the web page has no instant view page
     *
     * @property url The web page URL
     * @property forceFull If true, the full instant view for the web page will be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getWebPageInstantView")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetWebPageInstantView"),
        level = DeprecationLevel.WARNING
    )
    data class GetWebPageInstantView(
        @SerialName("url")
        val url: String? = null,
        @SerialName("force_full")
        val forceFull: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<WebPageInstantView> {
        override fun withRequestId(id: Long): GetWebPageInstantView {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Uploads a new profile photo for the current user
     * If something changes, updateUser will be sent
     *
     * @property photo Profile photo to set
     *                 InputFileId and inputFileRemote may still be unsupported
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setProfilePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetProfilePhoto"),
        level = DeprecationLevel.WARNING
    )
    data class SetProfilePhoto(
        @SerialName("photo")
        val photo: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetProfilePhoto {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes a profile photo
     * If something changes, updateUser will be sent
     *
     * @property profilePhotoId Identifier of the profile photo to delete
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteProfilePhoto")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteProfilePhoto"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteProfilePhoto(
        @SerialName("profile_photo_id")
        val profilePhotoId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteProfilePhoto {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the first and last name of the current user
     * If something changes, updateUser will be sent
     *
     * @property firstName The new value of the first name for the user
     * @property lastName The new value of the optional last name for the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setName")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetName"),
        level = DeprecationLevel.WARNING
    )
    data class SetName(
        @SerialName("first_name")
        val firstName: String? = null,
        @SerialName("last_name")
        val lastName: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetName {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the bio of the current user
     *
     * @property bio The new value of the user bio
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setBio")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetBio"),
        level = DeprecationLevel.WARNING
    )
    data class SetBio(
        @SerialName("bio")
        val bio: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetBio {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the username of the current user
     * If something changes, updateUser will be sent
     *
     * @property username The new value of the username
     *                    Use an empty string to remove the username
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setUsername")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetUsername"),
        level = DeprecationLevel.WARNING
    )
    data class SetUsername(
        @SerialName("username")
        val username: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetUsername {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the phone number of the user and sends an authentication code to the user's new phone number
     * On success, returns information about the sent code
     *
     * @property phoneNumber The new phone number of the user in international format
     * @property settings Settings for the authentication of the user's phone number
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("changePhoneNumber")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChangePhoneNumber"),
        level = DeprecationLevel.WARNING
    )
    data class ChangePhoneNumber(
        @SerialName("phone_number")
        val phoneNumber: String? = null,
        @SerialName("settings")
        val settings: PhoneNumberAuthenticationSettings? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AuthenticationCodeInfo> {
        override fun withRequestId(id: Long): ChangePhoneNumber {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Re-sends the authentication code sent to confirm a new phone number for the user
     * Works only if the previously received authenticationCodeInfo next_code_type was not null
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resendChangePhoneNumberCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendChangePhoneNumberCode"),
        level = DeprecationLevel.WARNING
    )
    data class ResendChangePhoneNumberCode(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AuthenticationCodeInfo> {
        override fun withRequestId(id: Long): ResendChangePhoneNumberCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the authentication code sent to confirm a new phone number of the user
     *
     * @property code Verification code received by SMS, phone call or flash call
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkChangePhoneNumberCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChangePhoneNumberCode"),
        level = DeprecationLevel.WARNING
    )
    data class CheckChangePhoneNumberCode(
        @SerialName("code")
        val code: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckChangePhoneNumberCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns all active sessions of the current user
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getActiveSessions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetActiveSessions"),
        level = DeprecationLevel.WARNING
    )
    data class GetActiveSessions(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Sessions> {
        override fun withRequestId(id: Long): GetActiveSessions {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Terminates a session of the current user
     *
     * @property sessionId Session identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("terminateSession")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTerminateSession"),
        level = DeprecationLevel.WARNING
    )
    data class TerminateSession(
        @SerialName("session_id")
        val sessionId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): TerminateSession {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Terminates all other sessions of the current user
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("terminateAllOtherSessions")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTerminateAllOtherSessions"),
        level = DeprecationLevel.WARNING
    )
    data class TerminateAllOtherSessions(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): TerminateAllOtherSessions {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns all website where the current user used Telegram to log in
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getConnectedWebsites")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetConnectedWebsites"),
        level = DeprecationLevel.WARNING
    )
    data class GetConnectedWebsites(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ConnectedWebsites> {
        override fun withRequestId(id: Long): GetConnectedWebsites {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Disconnects website from the current user's Telegram account
     *
     * @property websiteId Website identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("disconnectWebsite")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDisconnectWebsite"),
        level = DeprecationLevel.WARNING
    )
    data class DisconnectWebsite(
        @SerialName("website_id")
        val websiteId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DisconnectWebsite {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Disconnects all websites from the current user's Telegram account
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("disconnectAllWebsites")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDisconnectAllWebsites"),
        level = DeprecationLevel.WARNING
    )
    data class DisconnectAllWebsites(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DisconnectAllWebsites {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the username of a supergroup or channel, requires creator privileges in the supergroup or channel
     *
     * @property supergroupId Identifier of the supergroup or channel
     * @property username New value of the username
     *                    Use an empty string to remove the username
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setSupergroupUsername")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetSupergroupUsername"),
        level = DeprecationLevel.WARNING
    )
    data class SetSupergroupUsername(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("username")
        val username: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetSupergroupUsername {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the sticker set of a supergroup
     * Requires can_change_info rights
     *
     * @property supergroupId Identifier of the supergroup
     * @property stickerSetId New value of the supergroup sticker set identifier
     *                        Use 0 to remove the supergroup sticker set
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setSupergroupStickerSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetSupergroupStickerSet"),
        level = DeprecationLevel.WARNING
    )
    data class SetSupergroupStickerSet(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("sticker_set_id")
        val stickerSetId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetSupergroupStickerSet {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Toggles sender signatures messages sent in a channel
     * Requires can_change_info rights
     *
     * @property supergroupId Identifier of the channel
     * @property signMessages New value of sign_messages
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("toggleSupergroupSignMessages")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleSupergroupSignMessages"),
        level = DeprecationLevel.WARNING
    )
    data class ToggleSupergroupSignMessages(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("sign_messages")
        val signMessages: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ToggleSupergroupSignMessages {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Toggles whether the message history of a supergroup is available to new members
     * Requires can_change_info rights
     *
     * @property supergroupId The identifier of the supergroup
     * @property isAllHistoryAvailable The new value of is_all_history_available
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("toggleSupergroupIsAllHistoryAvailable")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleSupergroupIsAllHistoryAvailable"),
        level = DeprecationLevel.WARNING
    )
    data class ToggleSupergroupIsAllHistoryAvailable(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("is_all_history_available")
        val isAllHistoryAvailable: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ToggleSupergroupIsAllHistoryAvailable {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Reports some messages from a user in a supergroup as spam
     * Requires administrator rights in the supergroup
     *
     * @property supergroupId Supergroup identifier
     * @property userId User identifier
     * @property messageIds Identifiers of messages sent in the supergroup by the user
     *                      This list must be non-empty
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("reportSupergroupSpam")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReportSupergroupSpam"),
        level = DeprecationLevel.WARNING
    )
    data class ReportSupergroupSpam(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("message_ids")
        val messageIds: LongArray = longArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ReportSupergroupSpam {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about members or banned users in a supergroup or channel
     * Can be used only if SupergroupFullInfo.can_get_members == true
     * Additionally, administrator privileges may be required for some filters
     *
     * @property supergroupId Identifier of the supergroup or channel
     * @property filter The type of users to return
     *                  By default, supergroupMembersRecent
     * @property offset Number of users to skip
     * @property limit The maximum number of users be returned
     *                 Up to 200
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getSupergroupMembers")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupergroupMembers"),
        level = DeprecationLevel.WARNING
    )
    data class GetSupergroupMembers(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("filter")
        val filter: SupergroupMembersFilter? = null,
        @SerialName("offset")
        val offset: Int = 0,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ChatMembers> {
        override fun withRequestId(id: Long): GetSupergroupMembers {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes a supergroup or channel along with all messages in the corresponding chat
     * This will release the supergroup or channel username and remove all members
     * Requires creator privileges in the supergroup or channel
     * Chats with more than 1000 members can't be deleted using this method
     *
     * @property supergroupId Identifier of the supergroup or channel
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteSupergroup")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteSupergroup"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteSupergroup(
        @SerialName("supergroup_id")
        val supergroupId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteSupergroup {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Closes a secret chat, effectively transfering its state to secretChatStateClosed
     *
     * @property secretChatId Secret chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("closeSecretChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCloseSecretChat"),
        level = DeprecationLevel.WARNING
    )
    data class CloseSecretChat(
        @SerialName("secret_chat_id")
        val secretChatId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CloseSecretChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a list of service actions taken by chat members and administrators in the last 48 hours
     * Available only in supergroups and channels
     * Requires administrator rights
     * Returns results in reverse chronological order (i
     * E., in order of decreasing event_id)
     *
     * @property chatId Chat identifier
     * @property query Search query by which to filter events
     * @property fromEventId Identifier of an event from which to return results
     *                       Use 0 to get results from the latest events
     * @property limit Maximum number of events to return
     * @property filters The types of events to return
     *                   By default, all types will be returned
     * @property userIds User identifiers by which to filter events
     *                   By default, events relating to all users will be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatEventLog")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatEventLog"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatEventLog(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("query")
        val query: String? = null,
        @SerialName("from_event_id")
        val fromEventId: Long = 0L,
        @SerialName("limit")
        val limit: Int = 0,
        @SerialName("filters")
        val filters: ChatEventLogFilters? = null,
        @SerialName("user_ids")
        val userIds: IntArray = intArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ChatEvents> {
        override fun withRequestId(id: Long): GetChatEventLog {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an invoice payment form
     * This method should be called when the user presses inlineKeyboardButtonBuy
     *
     * @property chatId Chat identifier of the Invoice message
     * @property messageId Message identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPaymentForm")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPaymentForm"),
        level = DeprecationLevel.WARNING
    )
    data class GetPaymentForm(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PaymentForm> {
        override fun withRequestId(id: Long): GetPaymentForm {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Validates the order information provided by a user and returns the available shipping options for a flexible invoice
     *
     * @property chatId Chat identifier of the Invoice message
     * @property messageId Message identifier
     * @property orderInfo The order information, provided by the user
     * @property allowSave True, if the order information can be saved
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("validateOrderInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdValidateOrderInfo"),
        level = DeprecationLevel.WARNING
    )
    data class ValidateOrderInfo(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("order_info")
        val orderInfo: OrderInfo? = null,
        @SerialName("allow_save")
        val allowSave: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ValidatedOrderInfo> {
        override fun withRequestId(id: Long): ValidateOrderInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a filled-out payment form to the bot for final verification
     *
     * @property chatId Chat identifier of the Invoice message
     * @property messageId Message identifier
     * @property orderInfoId Identifier returned by ValidateOrderInfo, or an empty string
     * @property shippingOptionId Identifier of a chosen shipping option, if applicable
     * @property credentials The credentials chosen by user for payment
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendPaymentForm")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPaymentForm"),
        level = DeprecationLevel.WARNING
    )
    data class SendPaymentForm(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("order_info_id")
        val orderInfoId: String? = null,
        @SerialName("shipping_option_id")
        val shippingOptionId: String? = null,
        @SerialName("credentials")
        val credentials: InputCredentials? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PaymentResult> {
        override fun withRequestId(id: Long): SendPaymentForm {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a successful payment
     *
     * @property chatId Chat identifier of the PaymentSuccessful message
     * @property messageId Message identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPaymentReceipt")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPaymentReceipt"),
        level = DeprecationLevel.WARNING
    )
    data class GetPaymentReceipt(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("message_id")
        val messageId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PaymentReceipt> {
        override fun withRequestId(id: Long): GetPaymentReceipt {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns saved order info, if any
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getSavedOrderInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSavedOrderInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetSavedOrderInfo(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<OrderInfo> {
        override fun withRequestId(id: Long): GetSavedOrderInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes saved order info
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteSavedOrderInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteSavedOrderInfo"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteSavedOrderInfo(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteSavedOrderInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes saved credentials for all payment provider bots
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteSavedCredentials")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteSavedCredentials"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteSavedCredentials(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteSavedCredentials {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a user that can be contacted to get support
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getSupportUser")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupportUser"),
        level = DeprecationLevel.WARNING
    )
    data class GetSupportUser(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<User> {
        override fun withRequestId(id: Long): GetSupportUser {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns backgrounds installed by the user
     *
     * @property forDarkTheme True, if the backgrounds needs to be ordered for dark theme
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getBackgrounds")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBackgrounds"),
        level = DeprecationLevel.WARNING
    )
    data class GetBackgrounds(
        @SerialName("for_dark_theme")
        val forDarkTheme: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Backgrounds> {
        override fun withRequestId(id: Long): GetBackgrounds {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Constructs a persistent HTTP URL for a background
     *
     * @property name Background name
     * @property type Background type
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getBackgroundUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBackgroundUrl"),
        level = DeprecationLevel.WARNING
    )
    data class GetBackgroundUrl(
        @SerialName("name")
        val name: String? = null,
        @SerialName("type")
        val type: BackgroundType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<HttpUrl> {
        override fun withRequestId(id: Long): GetBackgroundUrl {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Searches for a background by its name
     *
     * @property name The name of the background
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("searchBackground")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchBackground"),
        level = DeprecationLevel.WARNING
    )
    data class SearchBackground(
        @SerialName("name")
        val name: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Background> {
        override fun withRequestId(id: Long): SearchBackground {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the background selected by the user
     * Adds background to the list of installed backgrounds
     *
     * @property background The input background to use, null for solid backgrounds
     * @property type Background type
     *                Null for default background
     *                The method will return error 404 if type is null
     * @property forDarkTheme True, if the background is chosen for dark theme
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setBackground")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetBackground"),
        level = DeprecationLevel.WARNING
    )
    data class SetBackground(
        @SerialName("background")
        val background: InputBackground? = null,
        @SerialName("type")
        val type: BackgroundType? = null,
        @SerialName("for_dark_theme")
        val forDarkTheme: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Background> {
        override fun withRequestId(id: Long): SetBackground {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes background from the list of installed backgrounds
     *
     * @property backgroundId The background indentifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeBackground")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveBackground"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveBackground(
        @SerialName("background_id")
        val backgroundId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveBackground {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Resets list of installed backgrounds to its default value
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resetBackgrounds")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResetBackgrounds"),
        level = DeprecationLevel.WARNING
    )
    data class ResetBackgrounds(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ResetBackgrounds {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about the current localization target
     * This is an offline request if only_local is true
     * Can be called before authorization
     *
     * @property onlyLocal If true, returns only locally available information without sending network requests
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLocalizationTargetInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLocalizationTargetInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetLocalizationTargetInfo(
        @SerialName("only_local")
        val onlyLocal: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<LocalizationTargetInfo> {
        override fun withRequestId(id: Long): GetLocalizationTargetInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a language pack
     * Returned language pack identifier may be different from a provided one
     * Can be called before authorization
     *
     * @property languagePackId Language pack identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLanguagePackInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLanguagePackInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetLanguagePackInfo(
        @SerialName("language_pack_id")
        val languagePackId: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<LanguagePackInfo> {
        override fun withRequestId(id: Long): GetLanguagePackInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns strings from a language pack in the current localization target by their keys
     * Can be called before authorization
     *
     * @property languagePackId Language pack identifier of the strings to be returned
     * @property keys Language pack keys of the strings to be returned
     *                Leave empty to request all available strings
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLanguagePackStrings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLanguagePackStrings"),
        level = DeprecationLevel.WARNING
    )
    data class GetLanguagePackStrings(
        @SerialName("language_pack_id")
        val languagePackId: String? = null,
        @SerialName("keys")
        val keys: Array<String> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<LanguagePackStrings> {
        override fun withRequestId(id: Long): GetLanguagePackStrings {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Fetches the latest versions of all strings from a language pack in the current localization target from the server
     * This method doesn't need to be called explicitly for the current used/base language packs
     * Can be called before authorization
     *
     * @property languagePackId Language pack identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("synchronizeLanguagePack")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSynchronizeLanguagePack"),
        level = DeprecationLevel.WARNING
    )
    data class SynchronizeLanguagePack(
        @SerialName("language_pack_id")
        val languagePackId: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SynchronizeLanguagePack {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a custom server language pack to the list of installed language packs in current localization target
     * Can be called before authorization
     *
     * @property languagePackId Identifier of a language pack to be added
     *                          May be different from a name that is used in an "https://t.me/setlanguage/" link
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addCustomServerLanguagePack")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddCustomServerLanguagePack"),
        level = DeprecationLevel.WARNING
    )
    data class AddCustomServerLanguagePack(
        @SerialName("language_pack_id")
        val languagePackId: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AddCustomServerLanguagePack {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds or changes a custom local language pack to the current localization target
     *
     * @property info Information about the language pack
     *                Language pack ID must start with 'X', consist only of English letters, digits and hyphens, and must not exceed 64 characters
     *                Can be called before authorization
     * @property strings Strings of the new language pack
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setCustomLanguagePack")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetCustomLanguagePack"),
        level = DeprecationLevel.WARNING
    )
    data class SetCustomLanguagePack(
        @SerialName("info")
        val info: LanguagePackInfo? = null,
        @SerialName("strings")
        val strings: Array<LanguagePackString> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetCustomLanguagePack {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits information about a custom local language pack in the current localization target
     * Can be called before authorization
     *
     * @property info New information about the custom local language pack
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editCustomLanguagePackInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditCustomLanguagePackInfo"),
        level = DeprecationLevel.WARNING
    )
    data class EditCustomLanguagePackInfo(
        @SerialName("info")
        val info: LanguagePackInfo? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): EditCustomLanguagePackInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds, edits or deletes a string in a custom local language pack
     * Can be called before authorization
     *
     * @property languagePackId Identifier of a previously added custom local language pack in the current localization target
     * @property newString New language pack string
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setCustomLanguagePackString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetCustomLanguagePackString"),
        level = DeprecationLevel.WARNING
    )
    data class SetCustomLanguagePackString(
        @SerialName("language_pack_id")
        val languagePackId: String? = null,
        @SerialName("new_string")
        val newString: LanguagePackString? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetCustomLanguagePackString {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes all information about a language pack in the current localization target
     * The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted
     * Can be called before authorization
     *
     * @property languagePackId Identifier of the language pack to delete
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteLanguagePack")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteLanguagePack"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteLanguagePack(
        @SerialName("language_pack_id")
        val languagePackId: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteLanguagePack {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Registers the currently used device for receiving push notifications
     * Returns a globally unique identifier of the push notification subscription
     *
     * @property deviceToken Device token
     * @property otherUserIds List of user identifiers of other users currently using the client
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("registerDevice")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRegisterDevice"),
        level = DeprecationLevel.WARNING
    )
    data class RegisterDevice(
        @SerialName("device_token")
        val deviceToken: DeviceToken? = null,
        @SerialName("other_user_ids")
        val otherUserIds: IntArray = intArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PushReceiverId> {
        override fun withRequestId(id: Long): RegisterDevice {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Handles a push notification
     * Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data
     * Can be called before authorization
     *
     * @property payload JSON-encoded push notification payload with all fields sent by the server, and "google.sent_time" and "google.notification.sound" fields added
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("processPushNotification")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProcessPushNotification"),
        level = DeprecationLevel.WARNING
    )
    data class ProcessPushNotification(
        @SerialName("payload")
        val payload: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ProcessPushNotification {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
     * This is an offline method
     * Can be called before authorization
     *
     * @property payload JSON-encoded push notification payload
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPushReceiverId")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPushReceiverId"),
        level = DeprecationLevel.WARNING
    )
    data class GetPushReceiverId(
        @SerialName("payload")
        val payload: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<PushReceiverId> {
        override fun withRequestId(id: Long): GetPushReceiverId {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns t.me URLs recently visited by a newly registered user
     *
     * @property referrer Google Play referrer to identify the user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getRecentlyVisitedTMeUrls")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecentlyVisitedTMeUrls"),
        level = DeprecationLevel.WARNING
    )
    data class GetRecentlyVisitedTMeUrls(
        @SerialName("referrer")
        val referrer: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TMeUrls> {
        override fun withRequestId(id: Long): GetRecentlyVisitedTMeUrls {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes user privacy settings
     *
     * @property setting The privacy setting
     * @property rules The new privacy rules
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setUserPrivacySettingRules")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetUserPrivacySettingRules"),
        level = DeprecationLevel.WARNING
    )
    data class SetUserPrivacySettingRules(
        @SerialName("setting")
        val setting: UserPrivacySetting? = null,
        @SerialName("rules")
        val rules: UserPrivacySettingRules? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetUserPrivacySettingRules {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the current privacy settings
     *
     * @property setting The privacy setting
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getUserPrivacySettingRules")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUserPrivacySettingRules"),
        level = DeprecationLevel.WARNING
    )
    data class GetUserPrivacySettingRules(
        @SerialName("setting")
        val setting: UserPrivacySetting? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<UserPrivacySettingRules> {
        override fun withRequestId(id: Long): GetUserPrivacySettingRules {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the value of an option by its name
     * (Check the list of available options on https://core.telegram.org/tdlib/options.) Can be called before authorization
     *
     * @property name The name of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getOption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetOption"),
        level = DeprecationLevel.WARNING
    )
    data class GetOption(
        @SerialName("name")
        val name: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<OptionValue> {
        override fun withRequestId(id: Long): GetOption {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the value of an option
     * (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set
     * Can be called before authorization
     *
     * @property name The name of the option
     * @property value The new value of the option
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setOption")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetOption"),
        level = DeprecationLevel.WARNING
    )
    data class SetOption(
        @SerialName("name")
        val name: String? = null,
        @SerialName("value")
        val value: OptionValue? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetOption {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the period of inactivity after which the account of the current user will automatically be deleted
     *
     * @property ttl New account TTL
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setAccountTtl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAccountTtl"),
        level = DeprecationLevel.WARNING
    )
    data class SetAccountTtl(
        @SerialName("ttl")
        val ttl: AccountTtl? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetAccountTtl {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the period of inactivity after which the account of the current user will automatically be deleted
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getAccountTtl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAccountTtl"),
        level = DeprecationLevel.WARNING
    )
    data class GetAccountTtl(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AccountTtl> {
        override fun withRequestId(id: Long): GetAccountTtl {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes the account of the current user, deleting all information associated with the user from the server
     * The phone number of the account can be used to create a new account
     * Can be called before authorization when the current authorization state is authorizationStateWaitPassword
     *
     * @property reason The reason why the account was deleted
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deleteAccount")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteAccount"),
        level = DeprecationLevel.WARNING
    )
    data class DeleteAccount(
        @SerialName("reason")
        val reason: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeleteAccount {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information on whether the current chat can be reported as spam
     *
     * @property chatId Chat identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatReportSpamState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatReportSpamState"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatReportSpamState(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<ChatReportSpamState> {
        override fun withRequestId(id: Long): GetChatReportSpamState {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Reports to the server whether a chat is a spam chat or not
     * Can be used only if ChatReportSpamState.can_report_spam is true
     * After this request, ChatReportSpamState.can_report_spam becomes false forever
     *
     * @property chatId Chat identifier
     * @property isSpamChat If true, the chat will be reported as spam
     *                      Otherwise it will be marked as not spam
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("changeChatReportSpamState")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChangeChatReportSpamState"),
        level = DeprecationLevel.WARNING
    )
    data class ChangeChatReportSpamState(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("is_spam_chat")
        val isSpamChat: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ChangeChatReportSpamState {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Reports a chat to the Telegram moderators
     * Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators
     *
     * @property chatId Chat identifier
     * @property reason The reason for reporting the chat
     * @property messageIds Identifiers of reported messages, if any
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("reportChat")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReportChat"),
        level = DeprecationLevel.WARNING
    )
    data class ReportChat(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("reason")
        val reason: ChatReportReason? = null,
        @SerialName("message_ids")
        val messageIds: LongArray = longArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ReportChat {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an HTTP URL with the chat statistics
     * Currently this method can be used only for channels
     *
     * @property chatId Chat identifier
     * @property parameters Parameters from "tg://statsrefresh?params=******" link
     * @property isDark Pass true if a URL with the dark theme must be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getChatStatisticsUrl")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatStatisticsUrl"),
        level = DeprecationLevel.WARNING
    )
    data class GetChatStatisticsUrl(
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("parameters")
        val parameters: String? = null,
        @SerialName("is_dark")
        val isDark: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<HttpUrl> {
        override fun withRequestId(id: Long): GetChatStatisticsUrl {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns storage usage statistics
     * Can be called before authorization
     *
     * @property chatLimit Maximum number of chats with the largest storage usage for which separate statistics should be returned
     *                     All other chats will be grouped in entries with chat_id == 0
     *                     If the chat info database is not used, the chat_limit is ignored and is always set to 0
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getStorageStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStorageStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class GetStorageStatistics(
        @SerialName("chat_limit")
        val chatLimit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StorageStatistics> {
        override fun withRequestId(id: Long): GetStorageStatistics {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Quickly returns approximate storage usage statistics
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getStorageStatisticsFast")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStorageStatisticsFast"),
        level = DeprecationLevel.WARNING
    )
    data class GetStorageStatisticsFast(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StorageStatisticsFast> {
        override fun withRequestId(id: Long): GetStorageStatisticsFast {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns database statistics
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getDatabaseStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetDatabaseStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class GetDatabaseStatistics(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<DatabaseStatistics> {
        override fun withRequestId(id: Long): GetDatabaseStatistics {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Optimizes storage usage, i.e
     * Deletes some files and returns new storage usage statistics
     * Secret thumbnails can't be deleted
     *
     * @property size Limit on the total size of files after deletion
     *                Pass -1 to use the default limit
     * @property ttl Limit on the time that has passed since the last time a file was accessed (or creation time for some filesystems)
     *               Pass -1 to use the default limit
     * @property count Limit on the total count of files after deletion
     *                 Pass -1 to use the default limit
     * @property immunityDelay The amount of time after the creation of a file during which it can't be deleted, in seconds
     *                         Pass -1 to use the default value
     * @property fileTypes If not empty, only files with the given type(s) are considered
     *                     By default, all types except thumbnails, profile photos, stickers and wallpapers are deleted
     * @property chatIds If not empty, only files from the given chats are considered
     *                   Use 0 as chat identifier to delete files not belonging to any chat (e.g., profile photos)
     * @property excludeChatIds If not empty, files from the given chats are excluded
     *                          Use 0 as chat identifier to exclude all files not belonging to any chat (e.g., profile photos)
     * @property chatLimit Same as in getStorageStatistics
     *                     Affects only returned statistics
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("optimizeStorage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptimizeStorage"),
        level = DeprecationLevel.WARNING
    )
    data class OptimizeStorage(
        @SerialName("size")
        val size: Long = 0L,
        @SerialName("ttl")
        val ttl: Int = 0,
        @SerialName("count")
        val count: Int = 0,
        @SerialName("immunity_delay")
        val immunityDelay: Int = 0,
        @SerialName("file_types")
        val fileTypes: Array<FileType> = emptyArray(),
        @SerialName("chat_ids")
        val chatIds: LongArray = longArrayOf(),
        @SerialName("exclude_chat_ids")
        val excludeChatIds: LongArray = longArrayOf(),
        @SerialName("chat_limit")
        val chatLimit: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StorageStatistics> {
        override fun withRequestId(id: Long): OptimizeStorage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the current network type
     * Can be called before authorization
     * Calling this method forces all network connections to reopen, mitigating the delay in switching between different networks, so it should be called whenever the network is changed, even if the network type remains the same
     * Network type is used to check whether the library can use the network at all and also for collecting detailed network data usage statistics
     *
     * @property type The new network type
     *                By default, networkTypeOther
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setNetworkType")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetNetworkType"),
        level = DeprecationLevel.WARNING
    )
    data class SetNetworkType(
        @SerialName("type")
        val type: NetworkType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetNetworkType {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns network data usage statistics
     * Can be called before authorization
     *
     * @property onlyCurrent If true, returns only data for the current library launch
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getNetworkStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetNetworkStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class GetNetworkStatistics(
        @SerialName("only_current")
        val onlyCurrent: Boolean = false,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<NetworkStatistics> {
        override fun withRequestId(id: Long): GetNetworkStatistics {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds the specified data to data usage statistics
     * Can be called before authorization
     *
     * @property entry The network statistics entry with the data to be added to statistics
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addNetworkStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddNetworkStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class AddNetworkStatistics(
        @SerialName("entry")
        val entry: NetworkStatisticsEntry? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AddNetworkStatistics {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Resets all network data usage statistics to zero
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resetNetworkStatistics")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResetNetworkStatistics"),
        level = DeprecationLevel.WARNING
    )
    data class ResetNetworkStatistics(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): ResetNetworkStatistics {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns auto-download settings presets for the currently logged in user
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getAutoDownloadSettingsPresets")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAutoDownloadSettingsPresets"),
        level = DeprecationLevel.WARNING
    )
    data class GetAutoDownloadSettingsPresets(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AutoDownloadSettingsPresets> {
        override fun withRequestId(id: Long): GetAutoDownloadSettingsPresets {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets auto-download settings
     *
     * @property settings New user auto-download settings
     * @property type Type of the network for which the new settings are applied
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setAutoDownloadSettings")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAutoDownloadSettings"),
        level = DeprecationLevel.WARNING
    )
    data class SetAutoDownloadSettings(
        @SerialName("settings")
        val settings: AutoDownloadSettings? = null,
        @SerialName("type")
        val type: NetworkType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetAutoDownloadSettings {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns one of the available Telegram Passport elements
     *
     * @property type Telegram Passport element type
     * @property password Password of the current user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPassportElement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPassportElement"),
        level = DeprecationLevel.WARNING
    )
    data class GetPassportElement(
        @SerialName("type")
        val type: PassportElementType? = null,
        @SerialName("password")
        val password: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PassportElement> {
        override fun withRequestId(id: Long): GetPassportElement {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns all available Telegram Passport elements
     *
     * @property password Password of the current user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getAllPassportElements")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAllPassportElements"),
        level = DeprecationLevel.WARNING
    )
    data class GetAllPassportElements(
        @SerialName("password")
        val password: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PassportElements> {
        override fun withRequestId(id: Long): GetAllPassportElements {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds an element to the user's Telegram Passport
     * May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
     *
     * @property element Input Telegram Passport element
     * @property password Password of the current user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setPassportElement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPassportElement"),
        level = DeprecationLevel.WARNING
    )
    data class SetPassportElement(
        @SerialName("element")
        val element: InputPassportElement? = null,
        @SerialName("password")
        val password: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PassportElement> {
        override fun withRequestId(id: Long): SetPassportElement {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Deletes a Telegram Passport element
     *
     * @property type Element type
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("deletePassportElement")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeletePassportElement"),
        level = DeprecationLevel.WARNING
    )
    data class DeletePassportElement(
        @SerialName("type")
        val type: PassportElementType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DeletePassportElement {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs the user that some of the elements in their Telegram Passport contain errors
     * The user will not be able to resend the elements, until the errors are fixed
     *
     * @property userId User identifier
     * @property errors The errors
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setPassportElementErrors")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPassportElementErrors"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class SetPassportElementErrors(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("errors")
        val errors: Array<InputPassportElementError> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetPassportElementErrors {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
     * Returns a 404 error if unknown
     *
     * @property countryCode A two-letter ISO 3166-1 alpha-2 country code
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPreferredCountryLanguage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPreferredCountryLanguage"),
        level = DeprecationLevel.WARNING
    )
    data class GetPreferredCountryLanguage(
        @SerialName("country_code")
        val countryCode: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Text> {
        override fun withRequestId(id: Long): GetPreferredCountryLanguage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a code to verify a phone number to be added to a user's Telegram Passport
     *
     * @property phoneNumber The phone number of the user, in international format
     * @property settings Settings for the authentication of the user's phone number
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendPhoneNumberVerificationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPhoneNumberVerificationCode"),
        level = DeprecationLevel.WARNING
    )
    data class SendPhoneNumberVerificationCode(
        @SerialName("phone_number")
        val phoneNumber: String? = null,
        @SerialName("settings")
        val settings: PhoneNumberAuthenticationSettings? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AuthenticationCodeInfo> {
        override fun withRequestId(id: Long): SendPhoneNumberVerificationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resendPhoneNumberVerificationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendPhoneNumberVerificationCode"),
        level = DeprecationLevel.WARNING
    )
    data class ResendPhoneNumberVerificationCode(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AuthenticationCodeInfo> {
        override fun withRequestId(id: Long): ResendPhoneNumberVerificationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the phone number verification code for Telegram Passport
     *
     * @property code Verification code
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkPhoneNumberVerificationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckPhoneNumberVerificationCode"),
        level = DeprecationLevel.WARNING
    )
    data class CheckPhoneNumberVerificationCode(
        @SerialName("code")
        val code: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckPhoneNumberVerificationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a code to verify an email address to be added to a user's Telegram Passport
     *
     * @property emailAddress Email address
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendEmailAddressVerificationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendEmailAddressVerificationCode"),
        level = DeprecationLevel.WARNING
    )
    data class SendEmailAddressVerificationCode(
        @SerialName("email_address")
        val emailAddress: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<EmailAddressAuthenticationCodeInfo> {
        override fun withRequestId(id: Long): SendEmailAddressVerificationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Re-sends the code to verify an email address to be added to a user's Telegram Passport
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resendEmailAddressVerificationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendEmailAddressVerificationCode"),
        level = DeprecationLevel.WARNING
    )
    data class ResendEmailAddressVerificationCode(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<EmailAddressAuthenticationCodeInfo> {
        override fun withRequestId(id: Long): ResendEmailAddressVerificationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks the email address verification code for Telegram Passport
     *
     * @property code Verification code
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkEmailAddressVerificationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckEmailAddressVerificationCode"),
        level = DeprecationLevel.WARNING
    )
    data class CheckEmailAddressVerificationCode(
        @SerialName("code")
        val code: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckEmailAddressVerificationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns a Telegram Passport authorization form for sharing data with a service
     *
     * @property botUserId User identifier of the service's bot
     * @property scope Telegram Passport element types requested by the service
     * @property publicKey Service's public_key
     * @property nonce Authorization form nonce provided by the service
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPassportAuthorizationForm")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPassportAuthorizationForm"),
        level = DeprecationLevel.WARNING
    )
    data class GetPassportAuthorizationForm(
        @SerialName("bot_user_id")
        val botUserId: Int = 0,
        @SerialName("scope")
        val scope: String? = null,
        @SerialName("public_key")
        val publicKey: String? = null,
        @SerialName("nonce")
        val nonce: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PassportAuthorizationForm> {
        override fun withRequestId(id: Long): GetPassportAuthorizationForm {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form
     * Result can be received only once for each authorization form
     *
     * @property autorizationFormId Authorization form identifier
     * @property password Password of the current user
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getPassportAuthorizationFormAvailableElements")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPassportAuthorizationFormAvailableElements"),
        level = DeprecationLevel.WARNING
    )
    data class GetPassportAuthorizationFormAvailableElements(
        @SerialName("autorization_form_id")
        val autorizationFormId: Int = 0,
        @SerialName("password")
        val password: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<PassportElementsWithErrors> {
        override fun withRequestId(id: Long): GetPassportAuthorizationFormAvailableElements {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a Telegram Passport authorization form, effectively sharing data with the service
     * This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements need to be used
     *
     * @property autorizationFormId Authorization form identifier
     * @property types Types of Telegram Passport elements chosen by user to complete the authorization form
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendPassportAuthorizationForm")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPassportAuthorizationForm"),
        level = DeprecationLevel.WARNING
    )
    data class SendPassportAuthorizationForm(
        @SerialName("autorization_form_id")
        val autorizationFormId: Int = 0,
        @SerialName("types")
        val types: Array<PassportElementType> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SendPassportAuthorizationForm {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends phone number confirmation code
     * Should be called when user presses "https://t.me/confirmphone?phone=*******&hash=**********" or "tg://confirmphone?phone=*******&hash=**********" link
     *
     * @property hash Value of the "hash" parameter from the link
     * @property phoneNumber Value of the "phone" parameter from the link
     * @property settings Settings for the authentication of the user's phone number
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendPhoneNumberConfirmationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPhoneNumberConfirmationCode"),
        level = DeprecationLevel.WARNING
    )
    data class SendPhoneNumberConfirmationCode(
        @SerialName("hash")
        val hash: String? = null,
        @SerialName("phone_number")
        val phoneNumber: String? = null,
        @SerialName("settings")
        val settings: PhoneNumberAuthenticationSettings? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AuthenticationCodeInfo> {
        override fun withRequestId(id: Long): SendPhoneNumberConfirmationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Resends phone number confirmation code
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("resendPhoneNumberConfirmationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendPhoneNumberConfirmationCode"),
        level = DeprecationLevel.WARNING
    )
    data class ResendPhoneNumberConfirmationCode(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<AuthenticationCodeInfo> {
        override fun withRequestId(id: Long): ResendPhoneNumberConfirmationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Checks phone number confirmation code
     *
     * @property code The phone number confirmation code
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("checkPhoneNumberConfirmationCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckPhoneNumberConfirmationCode"),
        level = DeprecationLevel.WARNING
    )
    data class CheckPhoneNumberConfirmationCode(
        @SerialName("code")
        val code: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): CheckPhoneNumberConfirmationCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Informs the server about the number of pending bot updates if they haven't been processed for a long time
     *
     * @property pendingUpdateCount The number of pending updates
     * @property errorMessage The last error message
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setBotUpdatesStatus")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetBotUpdatesStatus"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class SetBotUpdatesStatus(
        @SerialName("pending_update_count")
        val pendingUpdateCount: Int = 0,
        @SerialName("error_message")
        val errorMessage: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetBotUpdatesStatus {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Uploads a PNG image with a sticker
     * Returns the uploaded file
     *
     * @property userId Sticker file owner
     * @property pngSticker PNG image with the sticker
     *                      Must be up to 512 kB in size and fit in 512x512 square
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("uploadStickerFile")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUploadStickerFile"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class UploadStickerFile(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("png_sticker")
        val pngSticker: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<File> {
        override fun withRequestId(id: Long): UploadStickerFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Creates a new sticker set
     * Returns the newly created sticker set
     *
     * @property userId Sticker set owner
     * @property title Sticker set title
     * @property name Sticker set name
     *                Can contain only English letters, digits and underscores
     *                Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive)
     * @property isMasks True, if stickers are masks
     * @property stickers List of stickers to be added to the set
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("createNewStickerSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewStickerSet"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class CreateNewStickerSet(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("title")
        val title: String? = null,
        @SerialName("name")
        val name: String? = null,
        @SerialName("is_masks")
        val isMasks: Boolean = false,
        @SerialName("stickers")
        val stickers: Array<InputSticker> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSet> {
        override fun withRequestId(id: Long): CreateNewStickerSet {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a new sticker to a set
     * Returns the sticker set
     *
     * @property userId Sticker set owner
     * @property name Sticker set name
     * @property sticker Sticker to add to the set
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addStickerToSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddStickerToSet"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class AddStickerToSet(
        @SerialName("user_id")
        val userId: Int = 0,
        @SerialName("name")
        val name: String? = null,
        @SerialName("sticker")
        val sticker: InputSticker? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<StickerSet> {
        override fun withRequestId(id: Long): AddStickerToSet {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Changes the position of a sticker in the set to which it belongs
     * The sticker set must have been created by the bot
     *
     * @property sticker Sticker
     * @property position New position of the sticker in the set, zero-based
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setStickerPositionInSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetStickerPositionInSet"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class SetStickerPositionInSet(
        @SerialName("sticker")
        val sticker: InputFile? = null,
        @SerialName("position")
        val position: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetStickerPositionInSet {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a sticker from the set to which it belongs
     * The sticker set must have been created by the bot
     *
     * @property sticker Sticker
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeStickerFromSet")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveStickerFromSet"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class RemoveStickerFromSet(
        @SerialName("sticker")
        val sticker: InputFile? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveStickerFromSet {
            return copy(extra = extra.copy(id = id))
        }
    }

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
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMapThumbnailFile"),
        level = DeprecationLevel.WARNING
    )
    data class GetMapThumbnailFile(
        @SerialName("location")
        val location: Location? = null,
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
    ) : Function(), TdRequest<File> {
        override fun withRequestId(id: Long): GetMapThumbnailFile {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Accepts Telegram terms of services
     *
     * @property termsOfServiceId Terms of service identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("acceptTermsOfService")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAcceptTermsOfService"),
        level = DeprecationLevel.WARNING
    )
    data class AcceptTermsOfService(
        @SerialName("terms_of_service_id")
        val termsOfServiceId: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AcceptTermsOfService {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a custom request
     *
     * @property method The method name
     * @property parameters JSON-serialized method parameters
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("sendCustomRequest")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendCustomRequest"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class SendCustomRequest(
        @SerialName("method")
        val method: String? = null,
        @SerialName("parameters")
        val parameters: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<CustomRequestResult> {
        override fun withRequestId(id: Long): SendCustomRequest {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Answers a custom query
     *
     * @property customQueryId Identifier of a custom query
     * @property data JSON-serialized answer to the query
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("answerCustomQuery")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerCustomQuery"),
        level = DeprecationLevel.WARNING
    )
    @TdBotsOnly
    data class AnswerCustomQuery(
        @SerialName("custom_query_id")
        val customQueryId: Long = 0L,
        @SerialName("data")
        val data: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): AnswerCustomQuery {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Succeeds after a specified amount of time has passed
     * Can be called before authorization
     * Can be called before initialization
     *
     * @property seconds Number of seconds before the function returns
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setAlarm")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAlarm"),
        level = DeprecationLevel.WARNING
    )
    data class SetAlarm(
        @SerialName("seconds")
        val seconds: Double = 0.0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SetAlarm {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Uses current user IP to found their country
     * Returns two-letter ISO 3166-1 alpha-2 country code
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getCountryCode")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCountryCode"),
        level = DeprecationLevel.WARNING
    )
    data class GetCountryCode(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Text> {
        override fun withRequestId(id: Long): GetCountryCode {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getInviteText")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInviteText"),
        level = DeprecationLevel.WARNING
    )
    data class GetInviteText(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Text> {
        override fun withRequestId(id: Long): GetInviteText {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about a tg:// deep link
     * Use "tg://need_update_for_some_feature" or "tg:some_unsupported_feature" for testing
     * Returns a 404 error for unknown links
     * Can be called before authorization
     *
     * @property link The link
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getDeepLinkInfo")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetDeepLinkInfo"),
        level = DeprecationLevel.WARNING
    )
    data class GetDeepLinkInfo(
        @SerialName("link")
        val link: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<DeepLinkInfo> {
        override fun withRequestId(id: Long): GetDeepLinkInfo {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns application config, provided by the server
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getApplicationConfig")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetApplicationConfig"),
        level = DeprecationLevel.WARNING
    )
    data class GetApplicationConfig(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<JsonValue> {
        override fun withRequestId(id: Long): GetApplicationConfig {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Saves application log event on the server
     * Can be called before authorization
     *
     * @property type Event type
     * @property chatId Optional chat identifier, associated with the event
     * @property data The log event data
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("saveApplicationLogEvent")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSaveApplicationLogEvent"),
        level = DeprecationLevel.WARNING
    )
    data class SaveApplicationLogEvent(
        @SerialName("type")
        val type: String? = null,
        @SerialName("chat_id")
        val chatId: Long = 0L,
        @SerialName("data")
        val data: JsonValue? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): SaveApplicationLogEvent {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a proxy server for network requests
     * Can be called before authorization
     *
     * @property server Proxy server IP address
     * @property port Proxy server port
     * @property enable True, if the proxy should be enabled
     * @property type Proxy type
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddProxy"),
        level = DeprecationLevel.WARNING
    )
    data class AddProxy(
        @SerialName("server")
        val server: String? = null,
        @SerialName("port")
        val port: Int = 0,
        @SerialName("enable")
        val enable: Boolean = false,
        @SerialName("type")
        val type: ProxyType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Proxy> {
        override fun withRequestId(id: Long): AddProxy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Edits an existing proxy server for network requests
     * Can be called before authorization
     *
     * @property proxyId Proxy identifier
     * @property server Proxy server IP address
     * @property port Proxy server port
     * @property enable True, if the proxy should be enabled
     * @property type Proxy type
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("editProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditProxy"),
        level = DeprecationLevel.WARNING
    )
    data class EditProxy(
        @SerialName("proxy_id")
        val proxyId: Int = 0,
        @SerialName("server")
        val server: String? = null,
        @SerialName("port")
        val port: Int = 0,
        @SerialName("enable")
        val enable: Boolean = false,
        @SerialName("type")
        val type: ProxyType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Proxy> {
        override fun withRequestId(id: Long): EditProxy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Enables a proxy
     * Only one proxy can be enabled at a time
     * Can be called before authorization
     *
     * @property proxyId Proxy identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("enableProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEnableProxy"),
        level = DeprecationLevel.WARNING
    )
    data class EnableProxy(
        @SerialName("proxy_id")
        val proxyId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): EnableProxy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Disables the currently enabled proxy
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("disableProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDisableProxy"),
        level = DeprecationLevel.WARNING
    )
    data class DisableProxy(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): DisableProxy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Removes a proxy server
     * Can be called before authorization
     *
     * @property proxyId Proxy identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("removeProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveProxy"),
        level = DeprecationLevel.WARNING
    )
    data class RemoveProxy(
        @SerialName("proxy_id")
        val proxyId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): RemoveProxy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns list of proxies that are currently set up
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getProxies")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetProxies"),
        level = DeprecationLevel.WARNING
    )
    data class GetProxies(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Proxies> {
        override fun withRequestId(id: Long): GetProxies {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns an HTTPS link, which can be used to add a proxy
     * Available only for SOCKS5 and MTProto proxies
     * Can be called before authorization
     *
     * @property proxyId Proxy identifier
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getProxyLink")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetProxyLink"),
        level = DeprecationLevel.WARNING
    )
    data class GetProxyLink(
        @SerialName("proxy_id")
        val proxyId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Text> {
        override fun withRequestId(id: Long): GetProxyLink {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Computes time needed to receive a response from a Telegram server through a proxy
     * Can be called before authorization
     *
     * @property proxyId Proxy identifier
     *                   Use 0 to ping a Telegram server without a proxy
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("pingProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPingProxy"),
        level = DeprecationLevel.WARNING
    )
    data class PingProxy(
        @SerialName("proxy_id")
        val proxyId: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Seconds> {
        override fun withRequestId(id: Long): PingProxy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets new log stream for internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     *
     * @property logStream New log stream
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setLogStream")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetLogStream"),
        level = DeprecationLevel.WARNING
    )
    data class SetLogStream(
        @SerialName("log_stream")
        val logStream: LogStream? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Ok> {
        override fun withRequestId(id: Long): SetLogStream {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns information about currently used log stream for internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLogStream")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogStream"),
        level = DeprecationLevel.WARNING
    )
    data class GetLogStream(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<LogStream> {
        override fun withRequestId(id: Long): GetLogStream {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the verbosity level of the internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     *
     * @property newVerbosityLevel New value of the verbosity level for logging
     *                             Value 0 corresponds to fatal errors, value 1 corresponds to errors, value 2 corresponds to warnings and debug warnings, value 3 corresponds to informational, value 4 corresponds to debug, value 5 corresponds to verbose debug, value greater than 5 and up to 1023 can be used to enable even more logging
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setLogVerbosityLevel")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetLogVerbosityLevel"),
        level = DeprecationLevel.WARNING
    )
    data class SetLogVerbosityLevel(
        @SerialName("new_verbosity_level")
        val newVerbosityLevel: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Ok> {
        override fun withRequestId(id: Long): SetLogVerbosityLevel {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns current verbosity level of the internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLogVerbosityLevel")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogVerbosityLevel"),
        level = DeprecationLevel.WARNING
    )
    data class GetLogVerbosityLevel(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<LogVerbosityLevel> {
        override fun withRequestId(id: Long): GetLogVerbosityLevel {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]
     * This is an offline method
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLogTags")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogTags"),
        level = DeprecationLevel.WARNING
    )
    data class GetLogTags(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<LogTags> {
        override fun withRequestId(id: Long): GetLogTags {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sets the verbosity level for a specified TDLib internal log tag
     * This is an offline method
     * Can be called before authorization
     *
     * @property tag Logging tag to change verbosity level
     * @property newVerbosityLevel New verbosity level
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("setLogTagVerbosityLevel")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetLogTagVerbosityLevel"),
        level = DeprecationLevel.WARNING
    )
    data class SetLogTagVerbosityLevel(
        @SerialName("tag")
        val tag: String? = null,
        @SerialName("new_verbosity_level")
        val newVerbosityLevel: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Ok> {
        override fun withRequestId(id: Long): SetLogTagVerbosityLevel {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns current verbosity level for a specified TDLib internal log tag
     * This is an offline method
     * Can be called before authorization
     *
     * @property tag Logging tag to change verbosity level
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("getLogTagVerbosityLevel")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogTagVerbosityLevel"),
        level = DeprecationLevel.WARNING
    )
    data class GetLogTagVerbosityLevel(
        @SerialName("tag")
        val tag: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<LogVerbosityLevel> {
        override fun withRequestId(id: Long): GetLogTagVerbosityLevel {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Adds a message to TDLib internal log
     * This is an offline method
     * Can be called before authorization
     *
     * @property verbosityLevel Minimum verbosity level needed for the message to be logged, 0-1023
     * @property text Text of a message to log
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("addLogMessage")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddLogMessage"),
        level = DeprecationLevel.WARNING
    )
    data class AddLogMessage(
        @SerialName("verbosity_level")
        val verbosityLevel: Int = 0,
        @SerialName("text")
        val text: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Ok> {
        override fun withRequestId(id: Long): AddLogMessage {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Does nothing
     * This is an offline method
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testCallEmpty")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallEmpty"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestCallEmpty(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): TestCallEmpty {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the received string
     * This is an offline method
     * Can be called before authorization
     *
     * @property x String to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testCallString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallString"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestCallString(
        @SerialName("x")
        val x: String? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TestString> {
        override fun withRequestId(id: Long): TestCallString {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the received bytes
     * This is an offline method
     * Can be called before authorization
     *
     * @property x Bytes to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testCallBytes")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallBytes"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestCallBytes(
        @SerialName("x")
        val x: ByteArray = byteArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TestBytes> {
        override fun withRequestId(id: Long): TestCallBytes {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the received vector of numbers
     * This is an offline method
     * Can be called before authorization
     *
     * @property x Vector of numbers to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testCallVectorInt")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorInt"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestCallVectorInt(
        @SerialName("x")
        val x: IntArray = intArrayOf(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TestVectorInt> {
        override fun withRequestId(id: Long): TestCallVectorInt {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the received vector of objects containing a number
     * This is an offline method
     * Can be called before authorization
     *
     * @property x Vector of objects to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testCallVectorIntObject")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorIntObject"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestCallVectorIntObject(
        @SerialName("x")
        val x: Array<TestInt> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TestVectorIntObject> {
        override fun withRequestId(id: Long): TestCallVectorIntObject {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the received vector of strings
     * This is an offline method
     * Can be called before authorization
     *
     * @property x Vector of strings to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testCallVectorString")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorString"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestCallVectorString(
        @SerialName("x")
        val x: Array<String> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TestVectorString> {
        override fun withRequestId(id: Long): TestCallVectorString {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the received vector of objects containing a string
     * This is an offline method
     * Can be called before authorization
     *
     * @property x Vector of objects to return
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testCallVectorStringObject")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorStringObject"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestCallVectorStringObject(
        @SerialName("x")
        val x: Array<TestString> = emptyArray(),
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TestVectorStringObject> {
        override fun withRequestId(id: Long): TestCallVectorStringObject {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the squared received number
     * This is an offline method
     * Can be called before authorization
     *
     * @property x Number to square
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testSquareInt")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestSquareInt"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestSquareInt(
        @SerialName("x")
        val x: Int = 0,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<TestInt> {
        override fun withRequestId(id: Long): TestSquareInt {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a simple network request to the Telegram servers
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testNetwork")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestNetwork"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestNetwork(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): TestNetwork {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Sends a simple network request to the Telegram servers via proxy
     * Can be called before authorization
     *
     * @property server Proxy server IP address
     * @property port Proxy server port
     * @property type Proxy type
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testProxy")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestProxy"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestProxy(
        @SerialName("server")
        val server: String? = null,
        @SerialName("port")
        val port: Int = 0,
        @SerialName("type")
        val type: ProxyType? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): TestProxy {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Forces an updates.getDifference call to the Telegram servers
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testGetDifference")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestGetDifference"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestGetDifference(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Ok> {
        override fun withRequestId(id: Long): TestGetDifference {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Does nothing and ensures that the Update object is used
     * This is an offline method
     * Can be called before authorization
     *
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testUseUpdate")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestUseUpdate"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestUseUpdate(
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdRequest<Update> {
        override fun withRequestId(id: Long): TestUseUpdate {
            return copy(extra = extra.copy(id = id))
        }
    }

    /**
     * Returns the specified error and ensures that the Error object is used
     * This is an offline method
     * Can be called before authorization
     *
     * @property error The error to be returned
     * @property extra Extra data shared between request and response
     */
    @Serializable
    @SerialName("testReturnError")
    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestReturnError"),
        level = DeprecationLevel.WARNING
    )
    @TdTestOnly
    data class TestReturnError(
        @SerialName("error")
        val error: Error? = null,
        @SerialName("@extra")
        override val extra: TdExtra = TdExtra.EMPTY
    ) : Function(), TdSyncRequest<Error> {
        override fun withRequestId(id: Long): TestReturnError {
            return copy(extra = extra.copy(id = id))
        }
    }
}
