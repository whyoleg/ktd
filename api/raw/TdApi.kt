@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api

typealias TelegramObject = TdApi.Object
typealias TelegramFunction = TdApi.Function
typealias TelegramUpdate = TdApi.Update
typealias TelegramError = TdApi.Error

class TdApi {

    abstract class Object

    abstract class Function : Object()

    /**
     * An object of this type can be returned on every function call, in case of an error
     *
     * @code - Error code
     *         Subject to future changes
     *         If the error code is 406, the error message must not be processed in any way and must not be displayed to the user
     * @message - Error message
     *            Subject to future changes
     */
    class Error(
        val code: Int = 0,
        val message: String
    ) : Object()

    /**
     * An object of this type is returned on a successful function call for certain functions
     */
    class Ok : Object()

    /**
     * Contains parameters for TDLib initialization
     *
     * @useTestDc - If set to true, the Telegram test environment will be used instead of the production environment
     * @databaseDirectory - The path to the directory for the persistent database
     *                      If empty, the current working directory will be used
     * @filesDirectory - The path to the directory for storing files
     *                   If empty, database_directory will be used
     * @useFileDatabase - If set to true, information about downloaded and uploaded files will be saved between application restarts
     * @useChatInfoDatabase - If set to true, the library will maintain a cache of users, basic groups, supergroups, channels and secret chats
     *                        Implies use_file_database
     * @useMessageDatabase - If set to true, the library will maintain a cache of chats and messages
     *                       Implies use_chat_info_database
     * @useSecretChats - If set to true, support for secret chats will be enabled
     * @apiId - Application identifier for Telegram API access, which can be obtained at https://my.telegram.org
     * @apiHash - Application identifier hash for Telegram API access, which can be obtained at https://my.telegram.org
     * @systemLanguageCode - IETF language tag of the user's operating system language
     * @deviceModel - Model of the device the application is being run on
     * @systemVersion - Version of the operating system the application is being run on
     * @applicationVersion - Application version
     * @enableStorageOptimizer - If set to true, old files will automatically be deleted
     * @ignoreFileNames - If set to true, original file names will be ignored
     *                    Otherwise, downloaded files will be saved under names as close as possible to the original name
     */
    class TdlibParameters(
        val useTestDc: Boolean = false,
        val databaseDirectory: String,
        val filesDirectory: String,
        val useFileDatabase: Boolean = false,
        val useChatInfoDatabase: Boolean = false,
        val useMessageDatabase: Boolean = false,
        val useSecretChats: Boolean = false,
        val apiId: Int = 0,
        val apiHash: String,
        val systemLanguageCode: String,
        val deviceModel: String,
        val systemVersion: String,
        val applicationVersion: String,
        val enableStorageOptimizer: Boolean = false,
        val ignoreFileNames: Boolean = false
    ) : Object()

    /**
     * Provides information about the method by which an authentication code is delivered to the user
     */
    abstract class AuthenticationCodeType : null()

    /**
     * An authentication code is delivered via a private Telegram message, which can be viewed in another client
     *
     * @length - Length of the code
     */
    class AuthenticationCodeTypeTelegramMessage(
        val length: Int
    ) : AuthenticationCodeType()

    /**
     * An authentication code is delivered via an SMS message to the specified phone number
     *
     * @length - Length of the code
     */
    class AuthenticationCodeTypeSms(
        val length: Int
    ) : AuthenticationCodeType()

    /**
     * An authentication code is delivered via a phone call to the specified phone number
     *
     * @length - Length of the code
     */
    class AuthenticationCodeTypeCall(
        val length: Int
    ) : AuthenticationCodeType()

    /**
     * An authentication code is delivered by an immediately cancelled call to the specified phone number
     * The number from which the call was made is the code
     *
     * @pattern - Pattern of the phone number from which the call will be made
     */
    class AuthenticationCodeTypeFlashCall(
        val pattern: String
    ) : AuthenticationCodeType()

    /**
     * Information about the authentication code that was sent
     *
     * @phoneNumber - A phone number that is being authenticated
     * @type - Describes the way the code was sent to the user
     * @nextType - Describes the way the next code will be sent to the user
     * @timeout - Timeout before the code should be re-sent, in seconds
     */
    class AuthenticationCodeInfo(
        val phoneNumber: String,
        val type: AuthenticationCodeType,
        val nextType: AuthenticationCodeType?,
        val timeout: Int
    ) : Object()

    /**
     * Information about the email address authentication code that was sent
     *
     * @emailAddressPattern - Pattern of the email address to which an authentication code was sent
     * @length - Length of the code
     *           0 if unknown
     */
    class EmailAddressAuthenticationCodeInfo(
        val emailAddressPattern: String,
        val length: Int
    ) : Object()

    /**
     * Represents a part of the text that needs to be formatted in some unusual way
     *
     * @offset - Offset of the entity in UTF-16 code points
     * @length - Length of the entity, in UTF-16 code points
     * @type - Type of the entity
     */
    class TextEntity(
        val offset: Int = 0,
        val length: Int = 0,
        val type: TextEntityType
    ) : Object()

    /**
     * Contains a list of text entities
     *
     * @entities - List of text entities
     */
    class TextEntities(
        val entities: Array<TextEntity>
    ) : Object()

    /**
     * A text with some entities
     *
     * @text - The text
     * @entities - Entities contained in the text
     */
    class FormattedText(
        val text: String,
        val entities: Array<TextEntity> = emptyArray()
    ) : Object()

    /**
     * Contains Telegram terms of service
     *
     * @text - Text of the terms of service
     * @minUserAge - Minimum age of a user to be able to accept the terms
     *               0 if any
     * @showPopup - True, if a blocking popup with terms of service must be shown to the user
     */
    class TermsOfService(
        val text: FormattedText,
        val minUserAge: Int,
        val showPopup: Boolean
    ) : Object()

    /**
     * Represents the current authorization state of the client
     */
    abstract class AuthorizationState : null()

    /**
     * TDLib needs TdlibParameters for initialization
     */
    class AuthorizationStateWaitTdlibParameters : AuthorizationState()

    /**
     * TDLib needs an encryption key to decrypt the local database
     *
     * @isEncrypted - True, if the database is currently encrypted
     */
    class AuthorizationStateWaitEncryptionKey(
        val isEncrypted: Boolean
    ) : AuthorizationState()

    /**
     * TDLib needs the user's phone number to authorize
     */
    class AuthorizationStateWaitPhoneNumber : AuthorizationState()

    /**
     * TDLib needs the user's authentication code to authorize
     *
     * @codeInfo - Information about the authorization code that was sent
     */
    class AuthorizationStateWaitCode(
        val codeInfo: AuthenticationCodeInfo
    ) : AuthorizationState()

    /**
     * The user is unregistered and need to accept terms of service and enter their first name and last name to finish registration
     *
     * @termsOfService - Telegram terms of service
     */
    class AuthorizationStateWaitRegistration(
        val termsOfService: TermsOfService
    ) : AuthorizationState()

    /**
     * The user has been authorized, but needs to enter a password to start using the application
     *
     * @passwordHint - Hint for the password
     * @hasRecoveryEmailAddress - True, if a recovery email address has been set up
     * @recoveryEmailAddressPattern - Pattern of the email address to which the recovery email was sent
     *                                Empty until a recovery email has been sent
     */
    class AuthorizationStateWaitPassword(
        val passwordHint: String?,
        val hasRecoveryEmailAddress: Boolean,
        val recoveryEmailAddressPattern: String
    ) : AuthorizationState()

    /**
     * The user has been successfully authorized
     * TDLib is now ready to answer queries
     */
    class AuthorizationStateReady : AuthorizationState()

    /**
     * The user is currently logging out
     */
    class AuthorizationStateLoggingOut : AuthorizationState()

    /**
     * TDLib is closing, all subsequent queries will be answered with the error 500
     * Note that closing TDLib can take a while
     * All resources will be freed only after authorizationStateClosed has been received
     */
    class AuthorizationStateClosing : AuthorizationState()

    /**
     * TDLib client is in its final state
     * All databases are closed and all resources are released
     * No other updates will be received after this
     * All queries will be responded to with error code 500
     * To continue working, one should create a new instance of the TDLib client
     */
    class AuthorizationStateClosed : AuthorizationState()

    /**
     * Represents the current state of 2-step verification
     *
     * @hasPassword - True, if a 2-step verification password is set
     * @passwordHint - Hint for the password
     * @hasRecoveryEmailAddress - True, if a recovery email is set
     * @hasPassportData - True, if some Telegram Passport elements were saved
     * @recoveryEmailAddressCodeInfo - Information about the recovery email address to which the confirmation email was sent
     */
    class PasswordState(
        val hasPassword: Boolean,
        val passwordHint: String?,
        val hasRecoveryEmailAddress: Boolean,
        val hasPassportData: Boolean,
        val recoveryEmailAddressCodeInfo: EmailAddressAuthenticationCodeInfo?
    ) : Object()

    /**
     * Contains information about the current recovery email address
     *
     * @recoveryEmailAddress - Recovery email address
     */
    class RecoveryEmailAddress(
        val recoveryEmailAddress: String
    ) : Object()

    /**
     * Returns information about the availability of a temporary password, which can be used for payments
     *
     * @hasPassword - True, if a temporary password is available
     * @validFor - Time left before the temporary password expires, in seconds
     */
    class TemporaryPasswordState(
        val hasPassword: Boolean,
        val validFor: Int
    ) : Object()

    /**
     * Represents a local file
     *
     * @path - Local path to the locally available file part
     * @canBeDownloaded - True, if it is possible to try to download or generate the file
     * @canBeDeleted - True, if the file can be deleted
     * @isDownloadingActive - True, if the file is currently being downloaded (or a local copy is being generated by some other means)
     * @isDownloadingCompleted - True, if the local copy is fully available
     * @downloadOffset - Download will be started from this offset
     *                   Downloaded_prefix_size is calculated from this offset
     * @downloadedPrefixSize - If is_downloading_completed is false, then only some prefix of the file starting from download_offset is ready to be read
     *                         Downloaded_prefix_size is the size of that prefix
     * @downloadedSize - Total downloaded file bytes
     *                   Should be used only for calculating download progress
     *                   The actual file size may be bigger, and some parts of it may contain garbage
     */
    class LocalFile(
        val path: String?,
        val canBeDownloaded: Boolean,
        val canBeDeleted: Boolean,
        val isDownloadingActive: Boolean,
        val isDownloadingCompleted: Boolean,
        val downloadOffset: Int,
        val downloadedPrefixSize: Int,
        val downloadedSize: Int
    ) : Object()

    /**
     * Represents a remote file
     *
     * @id - Remote file identifier
     *       Can be used across application restarts or even from other devices for the current user
     *       If the ID starts with "http://" or "https://", it represents the HTTP URL of the file
     *       TDLib is currently unable to download files if only their URL is known
     *       If downloadFile is called on such a file or if it is sent to a secret chat, TDLib starts a file generation process by sending updateFileGenerationStart to the client with the HTTP URL in the original_path and "#url#" as the conversion string
     *       Clients should generate the file by downloading it to the specified location
     * @isUploadingActive - True, if the file is currently being uploaded (or a remote copy is being generated by some other means)
     * @isUploadingCompleted - True, if a remote copy is fully available
     * @uploadedSize - Size of the remote available part of the file
     *                 0 if unknown
     */
    class RemoteFile(
        val id: String?,
        val isUploadingActive: Boolean,
        val isUploadingCompleted: Boolean,
        val uploadedSize: Int
    ) : Object()

    /**
     * Represents a file
     *
     * @id - Unique file identifier
     * @size - File size
     *         0 if unknown
     * @expectedSize - Expected file size in case the exact file size is unknown, but an approximate size is known
     *                 Can be used to show download/upload progress
     * @local - Information about the local copy of the file
     * @remote - Information about the remote copy of the file
     */
    class File(
        val id: Int,
        val size: Int,
        val expectedSize: Int,
        val local: LocalFile,
        val remote: RemoteFile
    ) : Object()

    /**
     * Points to a file
     */
    abstract class InputFile : null()

    /**
     * A file defined by its unique ID
     *
     * @id - Unique file identifier
     */
    class InputFileId(
        val id: Int = 0
    ) : InputFile()

    /**
     * A file defined by its remote ID
     *
     * @id - Remote file identifier
     */
    class InputFileRemote(
        val id: String
    ) : InputFile()

    /**
     * A file defined by a local path
     *
     * @path - Local path to the file
     */
    class InputFileLocal(
        val path: String
    ) : InputFile()

    /**
     * A file generated by the client
     *
     * @originalPath - Local path to a file from which the file is generated
     *                 May be empty if there is no such file
     * @conversion - String specifying the conversion applied to the original file
     *               Should be persistent across application restarts
     *               Conversions beginning with '#' are reserved for internal TDLib usage
     * @expectedSize - Expected size of the generated file
     *                 0 if unknown
     */
    class InputFileGenerated(
        val originalPath: String,
        val conversion: String,
        val expectedSize: Int = 0
    ) : InputFile()

    /**
     * Photo description
     *
     * @type - Thumbnail type (see https://core.telegram.org/constructor/photoSize)
     * @photo - Information about the photo file
     * @width - Photo width
     * @height - Photo height
     */
    class PhotoSize(
        val type: String,
        val photo: File,
        val width: Int,
        val height: Int
    ) : Object()

    /**
     * Thumbnail image of a very poor quality and low resolution
     *
     * @width - Thumbnail width, usually doesn't exceed 40
     * @height - Thumbnail height, usually doesn't exceed 40
     * @data - The thumbnail in JPEG format
     */
    class Minithumbnail(
        val width: Int,
        val height: Int,
        val data: ByteArray
    ) : Object()

    /**
     * Part of the face, relative to which a mask should be placed
     */
    abstract class MaskPoint : null()

    /**
     * A mask should be placed relatively to the forehead
     */
    class MaskPointForehead : MaskPoint()

    /**
     * A mask should be placed relatively to the eyes
     */
    class MaskPointEyes : MaskPoint()

    /**
     * A mask should be placed relatively to the mouth
     */
    class MaskPointMouth : MaskPoint()

    /**
     * A mask should be placed relatively to the chin
     */
    class MaskPointChin : MaskPoint()

    /**
     * Position on a photo where a mask should be placed
     *
     * @point - Part of the face, relative to which the mask should be placed
     * @xShift - Shift by X-axis measured in widths of the mask scaled to the face size, from left to right
     *           (For example, -1.0 will place the mask just to the left of the default mask position)
     * @yShift - Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom
     *           (For example, 1.0 will place the mask just below the default mask position)
     * @scale - Mask scaling coefficient
     *          (For example, 2.0 means a doubled size)
     */
    class MaskPosition(
        val point: MaskPoint,
        val xShift: Double = 0.0,
        val yShift: Double = 0.0,
        val scale: Double = 0.0
    ) : Object()

    /**
     * Describes one answer option of a poll
     *
     * @text - Option text, 1-100 characters
     * @voterCount - Number of voters for this option, available only for closed or voted polls
     * @votePercentage - The percentage of votes for this option, 0-100
     * @isChosen - True, if the option was chosen by the user
     * @isBeingChosen - True, if the option is being chosen by a pending setPollAnswer request
     */
    class PollOption(
        val text: String,
        val voterCount: Int,
        val votePercentage: Int,
        val isChosen: Boolean,
        val isBeingChosen: Boolean
    ) : Object()

    /**
     * Describes an animation file
     * The animation must be encoded in GIF or MPEG4 format
     *
     * @duration - Duration of the animation, in seconds
     *             As defined by the sender
     * @width - Width of the animation
     * @height - Height of the animation
     * @fileName - Original name of the file
     *             As defined by the sender
     * @mimeType - MIME type of the file, usually "image/gif" or "video/mp4"
     * @minithumbnail - Animation minithumbnail
     * @thumbnail - Animation thumbnail
     * @animation - File containing the animation
     */
    class Animation(
        val duration: Int,
        val width: Int,
        val height: Int,
        val fileName: String,
        val mimeType: String,
        val minithumbnail: Minithumbnail?,
        val thumbnail: PhotoSize?,
        val animation: File
    ) : Object()

    /**
     * Describes an audio file
     * Audio is usually in MP3 format
     *
     * @duration - Duration of the audio, in seconds
     *             As defined by the sender
     * @title - Title of the audio
     *          As defined by the sender
     * @performer - Performer of the audio
     *              As defined by the sender
     * @fileName - Original name of the file
     *             As defined by the sender
     * @mimeType - The MIME type of the file
     *             As defined by the sender
     * @albumCoverMinithumbnail - The minithumbnail of the album cover
     * @albumCoverThumbnail - The thumbnail of the album cover
     *                        As defined by the sender
     *                        The full size thumbnail should be extracted from the downloaded file
     * @audio - File containing the audio
     */
    class Audio(
        val duration: Int,
        val title: String,
        val performer: String,
        val fileName: String,
        val mimeType: String,
        val albumCoverMinithumbnail: Minithumbnail?,
        val albumCoverThumbnail: PhotoSize?,
        val audio: File
    ) : Object()

    /**
     * Describes a document of any type
     *
     * @fileName - Original name of the file
     *             As defined by the sender
     * @mimeType - MIME type of the file
     *             As defined by the sender
     * @minithumbnail - Document minithumbnail
     * @thumbnail - Document thumbnail in JPEG or PNG format (PNG will be used only for background patterns)
     *              As defined by the sender
     * @document - File containing the document
     */
    class Document(
        val fileName: String,
        val mimeType: String,
        val minithumbnail: Minithumbnail?,
        val thumbnail: PhotoSize?,
        val document: File
    ) : Object()

    /**
     * Describes a photo
     *
     * @hasStickers - True, if stickers were added to the photo
     * @minithumbnail - Photo minithumbnail
     * @sizes - Available variants of the photo, in different sizes
     */
    class Photo(
        val hasStickers: Boolean,
        val minithumbnail: Minithumbnail?,
        val sizes: Array<PhotoSize>
    ) : Object()

    /**
     * Describes a sticker
     *
     * @setId - The identifier of the sticker set to which the sticker belongs
     *          0 if none
     * @width - Sticker width
     *          As defined by the sender
     * @height - Sticker height
     *           As defined by the sender
     * @emoji - Emoji corresponding to the sticker
     * @isAnimated - True, if the sticker is an animated sticker in TGS format
     * @isMask - True, if the sticker is a mask
     * @maskPosition - Position where the mask should be placed
     * @thumbnail - Sticker thumbnail in WEBP or JPEG format
     * @sticker - File containing the sticker
     */
    class Sticker(
        val setId: Long,
        val width: Int,
        val height: Int,
        val emoji: String,
        val isAnimated: Boolean,
        val isMask: Boolean,
        val maskPosition: MaskPosition?,
        val thumbnail: PhotoSize?,
        val sticker: File
    ) : Object()

    /**
     * Describes a video file
     *
     * @duration - Duration of the video, in seconds
     *             As defined by the sender
     * @width - Video width
     *          As defined by the sender
     * @height - Video height
     *           As defined by the sender
     * @fileName - Original name of the file
     *             As defined by the sender
     * @mimeType - MIME type of the file
     *             As defined by the sender
     * @hasStickers - True, if stickers were added to the photo
     * @supportsStreaming - True, if the video should be tried to be streamed
     * @minithumbnail - Video minithumbnail
     * @thumbnail - Video thumbnail
     *              As defined by the sender
     * @video - File containing the video
     */
    class Video(
        val duration: Int,
        val width: Int,
        val height: Int,
        val fileName: String,
        val mimeType: String,
        val hasStickers: Boolean,
        val supportsStreaming: Boolean,
        val minithumbnail: Minithumbnail?,
        val thumbnail: PhotoSize?,
        val video: File
    ) : Object()

    /**
     * Describes a video note
     * The video must be equal in width and height, cropped to a circle, and stored in MPEG4 format
     *
     * @duration - Duration of the video, in seconds
     *             As defined by the sender
     * @length - Video width and height
     *           As defined by the sender
     * @minithumbnail - Video minithumbnail
     * @thumbnail - Video thumbnail
     *              As defined by the sender
     * @video - File containing the video
     */
    class VideoNote(
        val duration: Int,
        val length: Int,
        val minithumbnail: Minithumbnail?,
        val thumbnail: PhotoSize?,
        val video: File
    ) : Object()

    /**
     * Describes a voice note
     * The voice note must be encoded with the Opus codec, and stored inside an OGG container
     * Voice notes can have only a single audio channel
     *
     * @duration - Duration of the voice note, in seconds
     *             As defined by the sender
     * @waveform - A waveform representation of the voice note in 5-bit format
     * @mimeType - MIME type of the file
     *             As defined by the sender
     * @voice - File containing the voice note
     */
    class VoiceNote(
        val duration: Int,
        val waveform: ByteArray,
        val mimeType: String,
        val voice: File
    ) : Object()

    /**
     * Describes a user contact
     *
     * @phoneNumber - Phone number of the user
     * @firstName - First name of the user
     * @lastName - Last name of the user
     * @vcard - Additional data about the user in a form of vCard
     * @userId - Identifier of the user, if known
     *           Otherwise 0
     */
    class Contact(
        val phoneNumber: String,
        val firstName: String,
        val lastName: String,
        val vcard: String,
        val userId: Int = 0
    ) : Object()

    /**
     * Describes a location on planet Earth
     *
     * @latitude - Latitude of the location in degrees
     *             As defined by the sender
     * @longitude - Longitude of the location, in degrees
     *              As defined by the sender
     */
    class Location(
        val latitude: Double = 0.0,
        val longitude: Double = 0.0
    ) : Object()

    /**
     * Describes a venue
     *
     * @location - Venue location
     *             As defined by the sender
     * @title - Venue name
     *          As defined by the sender
     * @address - Venue address
     *            As defined by the sender
     * @provider - Provider of the venue database
     *             As defined by the sender
     *             Currently only "foursquare" needs to be supported
     * @id - Identifier of the venue in the provider database
     *       As defined by the sender
     * @type - Type of the venue in the provider database
     *         As defined by the sender
     */
    class Venue(
        val location: Location,
        val title: String,
        val address: String,
        val provider: String,
        val id: String,
        val type: String
    ) : Object()

    /**
     * Describes a game
     *
     * @id - Game ID
     * @shortName - Game short name
     *              To share a game use the URL https://t.me/{bot_username}?game={game_short_name}
     * @title - Game title
     * @text - Game text, usually containing scoreboards for a game
     * @description - Game description
     * @photo - Game photo
     * @animation - Game animation
     */
    class Game(
        val id: Long,
        val shortName: String,
        val title: String,
        val text: FormattedText,
        val description: String,
        val photo: Photo,
        val animation: Animation?
    ) : Object()

    /**
     * Describes a poll
     *
     * @id - Unique poll identifier
     * @question - Poll question, 1-255 characters
     * @options - List of poll answer options
     * @totalVoterCount - Total number of voters, participating in the poll
     * @isClosed - True, if the poll is closed
     */
    class Poll(
        val id: Long,
        val question: String,
        val options: Array<PollOption>,
        val totalVoterCount: Int,
        val isClosed: Boolean
    ) : Object()

    /**
     * Describes a user profile photo
     *
     * @id - Photo identifier
     *       0 for an empty photo
     *       Can be used to find a photo in a list of userProfilePhotos
     * @small - A small (160x160) user profile photo
     *          The file can be downloaded only before the photo is changed
     * @big - A big (640x640) user profile photo
     *        The file can be downloaded only before the photo is changed
     */
    class ProfilePhoto(
        val id: Long,
        val small: File,
        val big: File
    ) : Object()

    /**
     * Describes the photo of a chat
     *
     * @small - A small (160x160) chat photo
     *          The file can be downloaded only before the photo is changed
     * @big - A big (640x640) chat photo
     *        The file can be downloaded only before the photo is changed
     */
    class ChatPhoto(
        val small: File,
        val big: File
    ) : Object()

    /**
     * Represents the relationship between user A and user B
     * For incoming_link, user A is the current user
     * For outgoing_link, user B is the current user
     */
    abstract class LinkState : null()

    /**
     * The phone number of user A is not known to user B
     */
    class LinkStateNone : LinkState()

    /**
     * The phone number of user A is known but that number has not been saved to the contact list of user B
     */
    class LinkStateKnowsPhoneNumber : LinkState()

    /**
     * The phone number of user A has been saved to the contact list of user B
     */
    class LinkStateIsContact : LinkState()

    /**
     * Represents the type of the user
     * The following types are possible: regular users, deleted users and bots
     */
    abstract class UserType : null()

    /**
     * A regular user
     */
    class UserTypeRegular : UserType()

    /**
     * A deleted user or deleted bot
     * No information on the user besides the user_id is available
     * It is not possible to perform any active actions on this type of user
     */
    class UserTypeDeleted : UserType()

    /**
     * A bot (see https://core.telegram.org/bots)
     *
     * @canJoinGroups - True, if the bot can be invited to basic group and supergroup chats
     * @canReadAllGroupMessages - True, if the bot can read all messages in basic group or supergroup chats and not just those addressed to the bot
     *                            In private and channel chats a bot can always read all messages
     * @isInline - True, if the bot supports inline queries
     * @inlineQueryPlaceholder - Placeholder for inline queries (displayed on the client input field)
     * @needLocation - True, if the location of the user should be sent with every inline query to this bot
     */
    class UserTypeBot(
        val canJoinGroups: Boolean,
        val canReadAllGroupMessages: Boolean,
        val isInline: Boolean,
        val inlineQueryPlaceholder: String,
        val needLocation: Boolean
    ) : UserType()

    /**
     * No information on the user besides the user_id is available, yet this user has not been deleted
     * This object is extremely rare and must be handled like a deleted user
     * It is not possible to perform any actions on users of this type
     */
    class UserTypeUnknown : UserType()

    /**
     * Represents commands supported by a bot
     *
     * @command - Text of the bot command
     * @description - Description of the bot command
     */
    class BotCommand(
        val command: String,
        val description: String
    ) : Object()

    /**
     * Provides information about a bot and its supported commands
     *
     * @description - Long description shown on the user info page
     * @commands - A list of commands supported by the bot
     */
    class BotInfo(
        val description: String,
        val commands: Array<BotCommand>
    ) : Object()

    /**
     * Represents a user
     *
     * @id - User identifier
     * @firstName - First name of the user
     * @lastName - Last name of the user
     * @username - Username of the user
     * @phoneNumber - Phone number of the user
     * @status - Current online status of the user
     * @profilePhoto - Profile photo of the user
     * @outgoingLink - Relationship from the current user to the other user
     * @incomingLink - Relationship from the other user to the current user
     * @isVerified - True, if the user is verified
     * @isSupport - True, if the user is Telegram support account
     * @restrictionReason - If non-empty, it contains the reason why access to this user must be restricted
     *                      The format of the string is "{type}: {description}"
     *                      {type} contains the type of the restriction and at least one of the suffixes "-all", "-ios", "-android", or "-wp", which describe the platforms on which access should be restricted
     *                      (For example, "terms-ios-android"
     *                      {description} contains a human-readable description of the restriction, which can be shown to the user)
     * @isScam - True, if many users reported this user as a scam
     * @haveAccess - If false, the user is inaccessible, and the only information known about the user is inside this class
     *               It can't be passed to any method except GetUser
     * @type - Type of the user
     * @languageCode - IETF language tag of the user's language
     */
    class User(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val username: String,
        val phoneNumber: String,
        val status: UserStatus,
        val profilePhoto: ProfilePhoto?,
        val outgoingLink: LinkState,
        val incomingLink: LinkState,
        val isVerified: Boolean,
        val isSupport: Boolean,
        val restrictionReason: String,
        val isScam: Boolean,
        val haveAccess: Boolean,
        val type: UserType,
        @BotsOnly val languageCode: String
    ) : Object()

    /**
     * Contains full information about a user (except the full list of profile photos)
     *
     * @isBlocked - True, if the user is blacklisted by the current user
     * @canBeCalled - True, if the user can be called
     * @hasPrivateCalls - True, if the user can't be called due to their privacy settings
     * @bio - A short user bio
     * @shareText - For bots, the text that is included with the link when users share the bot
     * @groupInCommonCount - Number of group chats where both the other user and the current user are a member
     *                       0 for the current user
     * @botInfo - If the user is a bot, information about the bot
     */
    class UserFullInfo(
        val isBlocked: Boolean,
        val canBeCalled: Boolean,
        val hasPrivateCalls: Boolean,
        val bio: String,
        val shareText: String,
        val groupInCommonCount: Int,
        val botInfo: BotInfo?
    ) : Object()

    /**
     * Contains full information about a user profile photo
     *
     * @id - Unique user profile photo identifier
     * @addedDate - Point in time (Unix timestamp) when the photo has been added
     * @sizes - Available variants of the user photo, in different sizes
     */
    class UserProfilePhoto(
        val id: Long,
        val addedDate: Int,
        val sizes: Array<PhotoSize>
    ) : Object()

    /**
     * Contains part of the list of user photos
     *
     * @totalCount - Total number of user profile photos
     * @photos - A list of photos
     */
    class UserProfilePhotos(
        val totalCount: Int,
        val photos: Array<UserProfilePhoto>
    ) : Object()

    /**
     * Represents a list of users
     *
     * @totalCount - Approximate total count of users found
     * @userIds - A list of user identifiers
     */
    class Users(
        val totalCount: Int,
        val userIds: IntArray
    ) : Object()

    /**
     * Describes actions that a user is allowed to take in a chat
     *
     * @canSendMessages - True, if the user can send text messages, contacts, locations, and venues
     * @canSendMediaMessages - True, if the user can send audio files, documents, photos, videos, video notes, and voice notes
     *                         Implies can_send_messages permissions
     * @canSendPolls - True, if the user can send polls
     *                 Implies can_send_messages permissions
     * @canSendOtherMessages - True, if the user can send animations, games, and stickers and use inline bots
     *                         Implies can_send_messages permissions
     * @canAddWebPagePreviews - True, if the user may add a web page preview to their messages
     *                          Implies can_send_messages permissions
     * @canChangeInfo - True, if the user can change the chat title, photo, and other settings
     * @canInviteUsers - True, if the user can invite new users to the chat
     * @canPinMessages - True, if the user can pin messages
     */
    class ChatPermissions(
        val canSendMessages: Boolean = false,
        val canSendMediaMessages: Boolean = false,
        val canSendPolls: Boolean = false,
        val canSendOtherMessages: Boolean = false,
        val canAddWebPagePreviews: Boolean = false,
        val canChangeInfo: Boolean = false,
        val canInviteUsers: Boolean = false,
        val canPinMessages: Boolean = false
    ) : Object()

    /**
     * Provides information about the status of a member in a chat
     */
    abstract class ChatMemberStatus : null()

    /**
     * The user is the creator of a chat and has all the administrator privileges
     *
     * @isMember - True, if the user is a member of the chat
     */
    class ChatMemberStatusCreator(
        val isMember: Boolean = false
    ) : ChatMemberStatus()

    /**
     * The user is a member of a chat and has some additional privileges
     * In basic groups, administrators can edit and delete messages sent by others, add new members, and ban unprivileged members
     * In supergroups and channels, there are more detailed options for administrator privileges
     *
     * @canBeEdited - True, if the current user can edit the administrator privileges for the called user
     * @canChangeInfo - True, if the administrator can change the chat title, photo, and other settings
     * @canPostMessages - True, if the administrator can create channel posts
     *                    Applicable to channels only
     * @canEditMessages - True, if the administrator can edit messages of other users and pin messages
     *                    Applicable to channels only
     * @canDeleteMessages - True, if the administrator can delete messages of other users
     * @canInviteUsers - True, if the administrator can invite new users to the chat
     * @canRestrictMembers - True, if the administrator can restrict, ban, or unban chat members
     * @canPinMessages - True, if the administrator can pin messages
     *                   Applicable to groups only
     * @canPromoteMembers - True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that were directly or indirectly promoted by him
     */
    class ChatMemberStatusAdministrator(
        val canBeEdited: Boolean = false,
        val canChangeInfo: Boolean = false,
        val canPostMessages: Boolean = false,
        val canEditMessages: Boolean = false,
        val canDeleteMessages: Boolean = false,
        val canInviteUsers: Boolean = false,
        val canRestrictMembers: Boolean = false,
        val canPinMessages: Boolean = false,
        val canPromoteMembers: Boolean = false
    ) : ChatMemberStatus()

    /**
     * The user is a member of a chat, without any additional privileges or restrictions
     */
    class ChatMemberStatusMember : ChatMemberStatus()

    /**
     * The user is under certain restrictions in the chat
     * Not supported in basic groups and channels
     *
     * @isMember - True, if the user is a member of the chat
     * @restrictedUntilDate - Point in time (Unix timestamp) when restrictions will be lifted from the user
     *                        0 if never
     *                        If the user is restricted for more than 366 days or for less than 30 seconds from the current time, the user is considered to be restricted forever
     * @permissions - User permissions in the chat
     */
    class ChatMemberStatusRestricted(
        val isMember: Boolean = false,
        val restrictedUntilDate: Int = 0,
        val permissions: ChatPermissions
    ) : ChatMemberStatus()

    /**
     * The user is not a chat member
     */
    class ChatMemberStatusLeft : ChatMemberStatus()

    /**
     * The user was banned (and hence is not a member of the chat)
     * Implies the user can't return to the chat or view messages
     *
     * @bannedUntilDate - Point in time (Unix timestamp) when the user will be unbanned
     *                    0 if never
     *                    If the user is banned for more than 366 days or for less than 30 seconds from the current time, the user is considered to be banned forever
     */
    class ChatMemberStatusBanned(
        val bannedUntilDate: Int = 0
    ) : ChatMemberStatus()

    /**
     * A user with information about joining/leaving a chat
     *
     * @userId - User identifier of the chat member
     * @inviterUserId - Identifier of a user that invited/promoted/banned this member in the chat
     *                  0 if unknown
     * @joinedChatDate - Point in time (Unix timestamp) when the user joined a chat
     * @status - Status of the member in the chat
     * @botInfo - If the user is a bot, information about the bot
     *            Can be null even for a bot if the bot is not a chat member
     */
    class ChatMember(
        val userId: Int,
        val inviterUserId: Int,
        val joinedChatDate: Int,
        val status: ChatMemberStatus,
        val botInfo: BotInfo?
    ) : Object()

    /**
     * Contains a list of chat members
     *
     * @totalCount - Approximate total count of chat members found
     * @members - A list of chat members
     */
    class ChatMembers(
        val totalCount: Int,
        val members: Array<ChatMember>
    ) : Object()

    /**
     * Specifies the kind of chat members to return in searchChatMembers
     */
    abstract class ChatMembersFilter : null()

    /**
     * Returns contacts of the user
     */
    class ChatMembersFilterContacts : ChatMembersFilter()

    /**
     * Returns the creator and administrators
     */
    class ChatMembersFilterAdministrators : ChatMembersFilter()

    /**
     * Returns all chat members, including restricted chat members
     */
    class ChatMembersFilterMembers : ChatMembersFilter()

    /**
     * Returns users under certain restrictions in the chat
     * Can be used only by administrators in a supergroup
     */
    class ChatMembersFilterRestricted : ChatMembersFilter()

    /**
     * Returns users banned from the chat
     * Can be used only by administrators in a supergroup or in a channel
     */
    class ChatMembersFilterBanned : ChatMembersFilter()

    /**
     * Returns bot members of the chat
     */
    class ChatMembersFilterBots : ChatMembersFilter()

    /**
     * Specifies the kind of chat members to return in getSupergroupMembers
     */
    abstract class SupergroupMembersFilter : null()

    /**
     * Returns recently active users in reverse chronological order
     */
    class SupergroupMembersFilterRecent : SupergroupMembersFilter()

    /**
     * Returns contacts of the user, which are members of the supergroup or channel
     *
     * @query - Query to search for
     */
    class SupergroupMembersFilterContacts(
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns the creator and administrators
     */
    class SupergroupMembersFilterAdministrators : SupergroupMembersFilter()

    /**
     * Used to search for supergroup or channel members via a (string) query
     *
     * @query - Query to search for
     */
    class SupergroupMembersFilterSearch(
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns restricted supergroup members
     * Can be used only by administrators
     *
     * @query - Query to search for
     */
    class SupergroupMembersFilterRestricted(
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns users banned from the supergroup or channel
     * Can be used only by administrators
     *
     * @query - Query to search for
     */
    class SupergroupMembersFilterBanned(
        val query: String
    ) : SupergroupMembersFilter()

    /**
     * Returns bot members of the supergroup or channel
     */
    class SupergroupMembersFilterBots : SupergroupMembersFilter()

    /**
     * Represents a basic group of 0-200 users (must be upgraded to a supergroup to accommodate more than 200 users)
     *
     * @id - Group identifier
     * @memberCount - Number of members in the group
     * @status - Status of the current user in the group
     * @isActive - True, if the group is active
     * @upgradedToSupergroupId - Identifier of the supergroup to which this group was upgraded
     *                           0 if none
     */
    class BasicGroup(
        val id: Int,
        val memberCount: Int,
        val status: ChatMemberStatus,
        val isActive: Boolean,
        val upgradedToSupergroupId: Int
    ) : Object()

    /**
     * Contains full information about a basic group
     *
     * @description - Group description
     * @creatorUserId - User identifier of the creator of the group
     *                  0 if unknown
     * @members - Group members
     * @inviteLink - Invite link for this group
     *               Available only for the group creator and only after it has been generated at least once
     */
    class BasicGroupFullInfo(
        val description: String,
        val creatorUserId: Int,
        val members: Array<ChatMember>,
        val inviteLink: String
    ) : Object()

    /**
     * Represents a supergroup or channel with zero or more members (subscribers in the case of channels)
     * From the point of view of the system, a channel is a special kind of a supergroup: only administrators can post and see the list of members, and posts from all administrators use the name and photo of the channel instead of individual names and profile photos
     * Unlike supergroups, channels can have an unlimited number of subscribers
     *
     * @id - Supergroup or channel identifier
     * @username - Username of the supergroup or channel
     *             Empty for private supergroups or channels
     * @date - Point in time (Unix timestamp) when the current user joined, or the point in time when the supergroup or channel was created, in case the user is not a member
     * @status - Status of the current user in the supergroup or channel
     * @memberCount - Member count
     *                0 if unknown
     *                Currently it is guaranteed to be known only if the supergroup or channel was found through SearchPublicChats
     * @signMessages - True, if messages sent to the channel should contain information about the sender
     *                 This field is only applicable to channels
     * @isChannel - True, if the supergroup is a channel
     * @isVerified - True, if the supergroup or channel is verified
     * @restrictionReason - If non-empty, contains the reason why access to this supergroup or channel must be restricted
     *                      Format of the string is "{type}: {description}"
     *                      {type} Contains the type of the restriction and at least one of the suffixes "-all", "-ios", "-android", or "-wp", which describe the platforms on which access should be restricted
     *                      (For example, "terms-ios-android"
     *                      {description} contains a human-readable description of the restriction, which can be shown to the user)
     * @isScam - True, if many users reported this supergroup as a scam
     */
    class Supergroup(
        val id: Int,
        val username: String,
        val date: Int,
        val status: ChatMemberStatus,
        val memberCount: Int,
        val signMessages: Boolean,
        val isChannel: Boolean,
        val isVerified: Boolean,
        val restrictionReason: String,
        val isScam: Boolean
    ) : Object()

    /**
     * Contains full information about a supergroup or channel
     *
     * @description - Supergroup or channel description
     * @memberCount - Number of members in the supergroup or channel
     *                0 if unknown
     * @administratorCount - Number of privileged users in the supergroup or channel
     *                       0 if unknown
     * @restrictedCount - Number of restricted users in the supergroup
     *                    0 if unknown
     * @bannedCount - Number of users banned from chat
     *                0 if unknown
     * @canGetMembers - True, if members of the chat can be retrieved
     * @canSetUsername - True, if the chat can be made public
     * @canSetStickerSet - True, if the supergroup sticker set can be changed
     * @canViewStatistics - True, if the channel statistics is available through getChatStatisticsUrl
     * @isAllHistoryAvailable - True, if new chat members will have access to old messages
     *                          In public supergroups and both public and private channels, old messages are always available, so this option affects only private supergroups
     *                          The value of this field is only available for chat administrators
     * @stickerSetId - Identifier of the supergroup sticker set
     *                 0 if none
     * @inviteLink - Invite link for this chat
     * @upgradedFromBasicGroupId - Identifier of the basic group from which supergroup was upgraded
     *                             0 if none
     * @upgradedFromMaxMessageId - Identifier of the last message in the basic group from which supergroup was upgraded
     *                             0 if none
     */
    class SupergroupFullInfo(
        val description: String,
        val memberCount: Int,
        val administratorCount: Int,
        val restrictedCount: Int,
        val bannedCount: Int,
        val canGetMembers: Boolean,
        val canSetUsername: Boolean,
        val canSetStickerSet: Boolean,
        val canViewStatistics: Boolean,
        val isAllHistoryAvailable: Boolean,
        val stickerSetId: Long,
        val inviteLink: String,
        val upgradedFromBasicGroupId: Int,
        val upgradedFromMaxMessageId: Long
    ) : Object()

    /**
     * Describes the current secret chat state
     */
    abstract class SecretChatState : null()

    /**
     * The secret chat is not yet created
     * Waiting for the other user to get online
     */
    class SecretChatStatePending : SecretChatState()

    /**
     * The secret chat is ready to use
     */
    class SecretChatStateReady : SecretChatState()

    /**
     * The secret chat is closed
     */
    class SecretChatStateClosed : SecretChatState()

    /**
     * Represents a secret chat
     *
     * @id - Secret chat identifier
     * @userId - Identifier of the chat partner
     * @state - State of the secret chat
     * @isOutbound - True, if the chat was created by the current user
     *               Otherwise false
     * @ttl - Current message Time To Live setting (self-destruct timer) for the chat, in seconds
     * @keyHash - Hash of the currently used key for comparison with the hash of the chat partner's key
     *            This is a string of 36 bytes, which must be used to make a 12x12 square image with a color depth of 4
     *            The first 16 bytes should be used to make a central 8x8 square, while the remaining 20 bytes should be used to construct a 2-pixel-wide border around that square
     *            Alternatively, the first 32 bytes of the hash can be converted to the hexadecimal format and printed as 32 2-digit hex numbers
     * @layer - Secret chat layer
     *          Determines features supported by the other client
     *          Video notes are supported if the layer >= 66
     */
    class SecretChat(
        val id: Int,
        val userId: Int,
        val state: SecretChatState,
        val isOutbound: Boolean,
        val ttl: Int,
        val keyHash: ByteArray,
        val layer: Int
    ) : Object()

    /**
     * Contains information about the origin of a forwarded message
     */
    abstract class MessageForwardOrigin : null()

    /**
     * The message was originally written by a known user
     *
     * @senderUserId - Identifier of the user that originally sent the message
     */
    class MessageForwardOriginUser(
        val senderUserId: Int
    ) : MessageForwardOrigin()

    /**
     * The message was originally written by a user, which is hidden by their privacy settings
     *
     * @senderName - Name of the sender
     */
    class MessageForwardOriginHiddenUser(
        val senderName: String
    ) : MessageForwardOrigin()

    /**
     * The message was originally a post in a channel
     *
     * @chatId - Identifier of the chat from which the message was originally forwarded
     * @messageId - Message identifier of the original message
     *              0 if unknown
     * @authorSignature - Original post author signature
     */
    class MessageForwardOriginChannel(
        val chatId: Long,
        val messageId: Long,
        val authorSignature: String
    ) : MessageForwardOrigin()

    /**
     * Contains information about a forwarded message
     *
     * @origin - Origin of a forwarded message
     * @date - Point in time (Unix timestamp) when the message was originally sent
     * @fromChatId - For messages forwarded to the chat with the current user (saved messages) or to the channel discussion supergroup, the identifier of the chat from which the message was forwarded last time
     *               0 if unknown
     * @fromMessageId - For messages forwarded to the chat with the current user (saved messages) or to the channel discussion supergroup, the identifier of the original message from which the new message was forwarded last time
     *                  0 if unknown
     */
    class MessageForwardInfo(
        val origin: MessageForwardOrigin,
        val date: Int,
        val fromChatId: Long,
        val fromMessageId: Long
    ) : Object()

    /**
     * Contains information about the sending state of the message
     */
    abstract class MessageSendingState : null()

    /**
     * The message is being sent now, but has not yet been delivered to the server
     */
    class MessageSendingStatePending : MessageSendingState()

    /**
     * The message failed to be sent
     *
     * @errorCode - An error code
     *              0 if unknown
     * @errorMessage - Error message
     * @canRetry - True, if the message can be re-sent
     * @retryAfter - Time left before the message can be re-sent, in seconds
     *               No update is sent when this field changes
     */
    class MessageSendingStateFailed(
        val errorCode: Int,
        val errorMessage: String,
        val canRetry: Boolean,
        val retryAfter: Double
    ) : MessageSendingState()

    /**
     * Describes a message
     *
     * @id - Message identifier, unique for the chat to which the message belongs
     * @senderUserId - Identifier of the user who sent the message
     *                 0 if unknown
     *                 Currently, it is unknown for channel posts and for channel posts automatically forwarded to discussion group
     * @chatId - Chat identifier
     * @sendingState - Information about the sending state of the message
     * @isOutgoing - True, if the message is outgoing
     * @canBeEdited - True, if the message can be edited
     *                For live location and poll messages this fields shows, whether editMessageLiveLocation or stopPoll can be used with this message by the client
     * @canBeForwarded - True, if the message can be forwarded
     * @canBeDeletedOnlyForSelf - True, if the message can be deleted only for the current user while other users will continue to see it
     * @canBeDeletedForAllUsers - True, if the message can be deleted for all users
     * @isChannelPost - True, if the message is a channel post
     *                  All messages to channels are channel posts, all other messages are not channel posts
     * @containsUnreadMention - True, if the message contains an unread mention for the current user
     * @date - Point in time (Unix timestamp) when the message was sent
     * @editDate - Point in time (Unix timestamp) when the message was last edited
     * @forwardInfo - Information about the initial message sender
     * @replyToMessageId - If non-zero, the identifier of the message this message is replying to
     *                     Can be the identifier of a deleted message
     * @ttl - For self-destructing messages, the message's TTL (Time To Live), in seconds
     *        0 if none
     *        TDLib will send updateDeleteMessages or updateMessageContent once the TTL expires
     * @ttlExpiresIn - Time left before the message expires, in seconds
     * @viaBotUserId - If non-zero, the user identifier of the bot through which this message was sent
     * @authorSignature - For channel posts, optional author signature
     * @views - Number of times this message was viewed
     * @mediaAlbumId - Unique identifier of an album this message belongs to
     *                 Only photos and videos can be grouped together in albums
     * @content - Content of the message
     * @replyMarkup - Reply markup for the message
     */
    class Message(
        val id: Long,
        val senderUserId: Int,
        val chatId: Long,
        val sendingState: MessageSendingState?,
        val isOutgoing: Boolean,
        val canBeEdited: Boolean,
        val canBeForwarded: Boolean,
        val canBeDeletedOnlyForSelf: Boolean,
        val canBeDeletedForAllUsers: Boolean,
        val isChannelPost: Boolean,
        val containsUnreadMention: Boolean,
        val date: Int,
        val editDate: Int,
        val forwardInfo: MessageForwardInfo?,
        val replyToMessageId: Long,
        val ttl: Int,
        val ttlExpiresIn: Double,
        val viaBotUserId: Int,
        val authorSignature: String,
        val views: Int,
        val mediaAlbumId: Long,
        val content: MessageContent,
        val replyMarkup: ReplyMarkup?
    ) : Object()

    /**
     * Contains a list of messages
     *
     * @totalCount - Approximate total count of messages found
     * @messages - List of messages
     *             Messages may be null
     */
    class Messages(
        val totalCount: Int,
        val messages: Array<Message>
    ) : Object()

    /**
     * Contains a list of messages found by a search
     *
     * @messages - List of messages
     * @nextFromSearchId - Value to pass as from_search_id to get more results
     */
    class FoundMessages(
        val messages: Array<Message>,
        val nextFromSearchId: Long
    ) : Object()

    /**
     * Describes the types of chats to which notification settings are applied
     */
    abstract class NotificationSettingsScope : null()

    /**
     * Notification settings applied to all private and secret chats when the corresponding chat setting has a default value
     */
    class NotificationSettingsScopePrivateChats : NotificationSettingsScope()

    /**
     * Notification settings applied to all basic groups and supergroups when the corresponding chat setting has a default value
     */
    class NotificationSettingsScopeGroupChats : NotificationSettingsScope()

    /**
     * Notification settings applied to all channels when the corresponding chat setting has a default value
     */
    class NotificationSettingsScopeChannelChats : NotificationSettingsScope()

    /**
     * Contains information about notification settings for a chat
     *
     * @useDefaultMuteFor - If true, mute_for is ignored and the value for the relevant type of chat is used instead
     * @muteFor - Time left before notifications will be unmuted, in seconds
     * @useDefaultSound - If true, sound is ignored and the value for the relevant type of chat is used instead
     * @sound - The name of an audio file to be used for notification sounds
     *          Only applies to iOS applications
     * @useDefaultShowPreview - If true, show_preview is ignored and the value for the relevant type of chat is used instead
     * @showPreview - True, if message content should be displayed in notifications
     * @useDefaultDisablePinnedMessageNotifications - If true, disable_pinned_message_notifications is ignored and the value for the relevant type of chat is used instead
     * @disablePinnedMessageNotifications - If true, notifications for incoming pinned messages will be created as for an ordinary unread message
     * @useDefaultDisableMentionNotifications - If true, disable_mention_notifications is ignored and the value for the relevant type of chat is used instead
     * @disableMentionNotifications - If true, notifications for messages with mentions will be created as for an ordinary unread message
     */
    class ChatNotificationSettings(
        val useDefaultMuteFor: Boolean = false,
        val muteFor: Int = 0,
        val useDefaultSound: Boolean = false,
        val sound: String,
        val useDefaultShowPreview: Boolean = false,
        val showPreview: Boolean = false,
        val useDefaultDisablePinnedMessageNotifications: Boolean = false,
        val disablePinnedMessageNotifications: Boolean = false,
        val useDefaultDisableMentionNotifications: Boolean = false,
        val disableMentionNotifications: Boolean = false
    ) : Object()

    /**
     * Contains information about notification settings for several chats
     *
     * @muteFor - Time left before notifications will be unmuted, in seconds
     * @sound - The name of an audio file to be used for notification sounds
     *          Only applies to iOS applications
     * @showPreview - True, if message content should be displayed in notifications
     * @disablePinnedMessageNotifications - True, if notifications for incoming pinned messages will be created as for an ordinary unread message
     * @disableMentionNotifications - True, if notifications for messages with mentions will be created as for an ordinary unread message
     */
    class ScopeNotificationSettings(
        val muteFor: Int = 0,
        val sound: String,
        val showPreview: Boolean = false,
        val disablePinnedMessageNotifications: Boolean = false,
        val disableMentionNotifications: Boolean = false
    ) : Object()

    /**
     * Contains information about a message draft
     *
     * @replyToMessageId - Identifier of the message to reply to
     *                     0 if none
     * @inputMessageText - Content of the message draft
     *                     This should always be of type inputMessageText
     */
    class DraftMessage(
        val replyToMessageId: Long = 0L,
        val inputMessageText: InputMessageContent
    ) : Object()

    /**
     * Describes the type of a chat
     */
    abstract class ChatType : null()

    /**
     * An ordinary chat with a user
     *
     * @userId - User identifier
     */
    class ChatTypePrivate(
        val userId: Int
    ) : ChatType()

    /**
     * A basic group (i.e., a chat with 0-200 other users)
     *
     * @basicGroupId - Basic group identifier
     */
    class ChatTypeBasicGroup(
        val basicGroupId: Int
    ) : ChatType()

    /**
     * A supergroup (i.e
     * A chat with up to GetOption("supergroup_max_size") other users), or channel (with unlimited members)
     *
     * @supergroupId - Supergroup or channel identifier
     * @isChannel - True, if the supergroup is a channel
     */
    class ChatTypeSupergroup(
        val supergroupId: Int,
        val isChannel: Boolean
    ) : ChatType()

    /**
     * A secret chat with a user
     *
     * @secretChatId - Secret chat identifier
     * @userId - User identifier of the secret chat peer
     */
    class ChatTypeSecret(
        val secretChatId: Int,
        val userId: Int
    ) : ChatType()

    /**
     * A chat
     * (Can be a private chat, basic group, supergroup, or secret chat)
     *
     * @id - Chat unique identifier
     * @type - Type of the chat
     * @title - Chat title
     * @photo - Chat photo
     * @permissions - Actions that non-administrator chat members are allowed to take in the chat
     * @lastMessage - Last message in the chat
     * @order - Descending parameter by which chats are sorted in the main chat list
     *          If the order number of two chats is the same, they must be sorted in descending order by ID
     *          If 0, the position of the chat in the list is undetermined
     * @isPinned - True, if the chat is pinned
     * @isMarkedAsUnread - True, if the chat is marked as unread
     * @isSponsored - True, if the chat is sponsored by the user's MTProxy server
     * @canBeDeletedOnlyForSelf - True, if the chat messages can be deleted only for the current user while other users will continue to see the messages
     * @canBeDeletedForAllUsers - True, if the chat messages can be deleted for all users
     * @canBeReported - True, if the chat can be reported to Telegram moderators through reportChat
     * @defaultDisableNotification - Default value of the disable_notification parameter, used when a message is sent to the chat
     * @unreadCount - Number of unread messages in the chat
     * @lastReadInboxMessageId - Identifier of the last read incoming message
     * @lastReadOutboxMessageId - Identifier of the last read outgoing message
     * @unreadMentionCount - Number of unread messages with a mention/reply in the chat
     * @notificationSettings - Notification settings for this chat
     * @pinnedMessageId - Identifier of the pinned message in the chat
     *                    0 if none
     * @replyMarkupMessageId - Identifier of the message from which reply markup needs to be used
     *                         0 if there is no default custom reply markup in the chat
     * @draftMessage - A draft of a message in the chat
     * @clientData - Contains client-specific data associated with the chat
     *               (For example, the chat position or local chat notification settings can be stored here.) Persistent if a message database is used
     */
    class Chat(
        val id: Long,
        val type: ChatType,
        val title: String,
        val photo: ChatPhoto?,
        val permissions: ChatPermissions,
        val lastMessage: Message?,
        val order: Long,
        val isPinned: Boolean,
        val isMarkedAsUnread: Boolean,
        val isSponsored: Boolean,
        val canBeDeletedOnlyForSelf: Boolean,
        val canBeDeletedForAllUsers: Boolean,
        val canBeReported: Boolean,
        val defaultDisableNotification: Boolean,
        val unreadCount: Int,
        val lastReadInboxMessageId: Long,
        val lastReadOutboxMessageId: Long,
        val unreadMentionCount: Int,
        val notificationSettings: ChatNotificationSettings,
        val pinnedMessageId: Long,
        val replyMarkupMessageId: Long,
        val draftMessage: DraftMessage?,
        val clientData: String
    ) : Object()

    /**
     * Represents a list of chats
     *
     * @chatIds - List of chat identifiers
     */
    class Chats(
        val chatIds: LongArray
    ) : Object()

    /**
     * Contains a chat invite link
     *
     * @inviteLink - Chat invite link
     */
    class ChatInviteLink(
        val inviteLink: String
    ) : Object()

    /**
     * Contains information about a chat invite link
     *
     * @chatId - Chat identifier of the invite link
     *           0 if the user is not a member of this chat
     * @type - Contains information about the type of the chat
     * @title - Title of the chat
     * @photo - Chat photo
     * @memberCount - Number of members
     * @memberUserIds - User identifiers of some chat members that may be known to the current user
     * @isPublic - True, if the chat is a public supergroup or a channel with a username
     */
    class ChatInviteLinkInfo(
        val chatId: Long,
        val type: ChatType,
        val title: String,
        val photo: ChatPhoto?,
        val memberCount: Int,
        val memberUserIds: IntArray,
        val isPublic: Boolean
    ) : Object()

    /**
     * Describes a keyboard button type
     */
    abstract class KeyboardButtonType : null()

    /**
     * A simple button, with text that should be sent when the button is pressed
     */
    class KeyboardButtonTypeText : KeyboardButtonType()

    /**
     * A button that sends the user's phone number when pressed
     * Available only in private chats
     */
    class KeyboardButtonTypeRequestPhoneNumber : KeyboardButtonType()

    /**
     * A button that sends the user's location when pressed
     * Available only in private chats
     */
    class KeyboardButtonTypeRequestLocation : KeyboardButtonType()

    /**
     * Represents a single button in a bot keyboard
     *
     * @text - Text of the button
     * @type - Type of the button
     */
    class KeyboardButton(
        val text: String,
        val type: KeyboardButtonType
    ) : Object()

    /**
     * Describes the type of an inline keyboard button
     */
    abstract class InlineKeyboardButtonType : null()

    /**
     * A button that opens a specified URL
     *
     * @url - HTTP or tg:// URL to open
     */
    class InlineKeyboardButtonTypeUrl(
        val url: String
    ) : InlineKeyboardButtonType()

    /**
     * A button that opens a specified URL and automatically logs in in current user if they allowed to do that
     *
     * @url - HTTP URL to open
     * @id - Unique button identifier
     * @forwardText - If non-empty, new text of the button in forwarded messages
     */
    class InlineKeyboardButtonTypeLoginUrl(
        val url: String,
        val id: Int,
        val forwardText: String
    ) : InlineKeyboardButtonType()

    /**
     * A button that sends a special callback query to a bot
     *
     * @data - Data to be sent to the bot via a callback query
     */
    class InlineKeyboardButtonTypeCallback(
        val data: ByteArray
    ) : InlineKeyboardButtonType()

    /**
     * A button with a game that sends a special callback query to a bot
     * This button must be in the first column and row of the keyboard and can be attached only to a message with content of the type messageGame
     */
    class InlineKeyboardButtonTypeCallbackGame : InlineKeyboardButtonType()

    /**
     * A button that forces an inline query to the bot to be inserted in the input field
     *
     * @query - Inline query to be sent to the bot
     * @inCurrentChat - True, if the inline query should be sent from the current chat
     */
    class InlineKeyboardButtonTypeSwitchInline(
        val query: String,
        val inCurrentChat: Boolean
    ) : InlineKeyboardButtonType()

    /**
     * A button to buy something
     * This button must be in the first column and row of the keyboard and can be attached only to a message with content of the type messageInvoice
     */
    class InlineKeyboardButtonTypeBuy : InlineKeyboardButtonType()

    /**
     * Represents a single button in an inline keyboard
     *
     * @text - Text of the button
     * @type - Type of the button
     */
    class InlineKeyboardButton(
        val text: String,
        val type: InlineKeyboardButtonType
    ) : Object()

    /**
     * Contains a description of a custom keyboard and actions that can be done with it to quickly reply to bots
     */
    abstract class ReplyMarkup : null()

    /**
     * Instructs clients to remove the keyboard once this message has been received
     * This kind of keyboard can't be received in an incoming message
     * Instead, UpdateChatReplyMarkup with message_id == 0 will be sent
     *
     * @isPersonal - True, if the keyboard is removed only for the mentioned users or the target user of a reply
     */
    class ReplyMarkupRemoveKeyboard(
        val isPersonal: Boolean = false
    ) : ReplyMarkup()

    /**
     * Instructs clients to force a reply to this message
     *
     * @isPersonal - True, if a forced reply must automatically be shown to the current user
     *               For outgoing messages, specify true to show the forced reply only for the mentioned users and for the target user of a reply
     */
    class ReplyMarkupForceReply(
        val isPersonal: Boolean = false
    ) : ReplyMarkup()

    /**
     * Contains a custom keyboard layout to quickly reply to bots
     *
     * @rows - A list of rows of bot keyboard buttons
     * @resizeKeyboard - True, if the client needs to resize the keyboard vertically
     * @oneTime - True, if the client needs to hide the keyboard after use
     * @isPersonal - True, if the keyboard must automatically be shown to the current user
     *               For outgoing messages, specify true to show the keyboard only for the mentioned users and for the target user of a reply
     */
    class ReplyMarkupShowKeyboard(
        val rows: Array<Array<KeyboardButton>> = emptyArray(),
        val resizeKeyboard: Boolean = false,
        val oneTime: Boolean = false,
        val isPersonal: Boolean = false
    ) : ReplyMarkup()

    /**
     * Contains an inline keyboard layout
     *
     * @rows - A list of rows of inline keyboard buttons
     */
    class ReplyMarkupInlineKeyboard(
        val rows: Array<Array<InlineKeyboardButton>> = emptyArray()
    ) : ReplyMarkup()

    /**
     * Describes a text object inside an instant-view web page
     */
    abstract class RichText : null()

    /**
     * A plain text
     *
     * @text - Text
     */
    class RichTextPlain(
        val text: String
    ) : RichText()

    /**
     * A bold rich text
     *
     * @text - Text
     */
    class RichTextBold(
        val text: RichText
    ) : RichText()

    /**
     * An italicized rich text
     *
     * @text - Text
     */
    class RichTextItalic(
        val text: RichText
    ) : RichText()

    /**
     * An underlined rich text
     *
     * @text - Text
     */
    class RichTextUnderline(
        val text: RichText
    ) : RichText()

    /**
     * A strike-through rich text
     *
     * @text - Text
     */
    class RichTextStrikethrough(
        val text: RichText
    ) : RichText()

    /**
     * A fixed-width rich text
     *
     * @text - Text
     */
    class RichTextFixed(
        val text: RichText
    ) : RichText()

    /**
     * A rich text URL link
     *
     * @text - Text
     * @url - URL
     */
    class RichTextUrl(
        val text: RichText,
        val url: String
    ) : RichText()

    /**
     * A rich text email link
     *
     * @text - Text
     * @emailAddress - Email address
     */
    class RichTextEmailAddress(
        val text: RichText,
        val emailAddress: String
    ) : RichText()

    /**
     * A subscript rich text
     *
     * @text - Text
     */
    class RichTextSubscript(
        val text: RichText
    ) : RichText()

    /**
     * A superscript rich text
     *
     * @text - Text
     */
    class RichTextSuperscript(
        val text: RichText
    ) : RichText()

    /**
     * A marked rich text
     *
     * @text - Text
     */
    class RichTextMarked(
        val text: RichText
    ) : RichText()

    /**
     * A rich text phone number
     *
     * @text - Text
     * @phoneNumber - Phone number
     */
    class RichTextPhoneNumber(
        val text: RichText,
        val phoneNumber: String
    ) : RichText()

    /**
     * A small image inside the text
     *
     * @document - The image represented as a document
     *             The image can be in GIF, JPEG or PNG format
     * @width - Width of a bounding box in which the image should be shown
     *          0 if unknown
     * @height - Height of a bounding box in which the image should be shown
     *           0 if unknown
     */
    class RichTextIcon(
        val document: Document,
        val width: Int,
        val height: Int
    ) : RichText()

    /**
     * A rich text anchor
     *
     * @text - Text
     * @name - Anchor name
     */
    class RichTextAnchor(
        val text: RichText,
        val name: String
    ) : RichText()

    /**
     * A concatenation of rich texts
     *
     * @texts - Texts
     */
    class RichTexts(
        val texts: Array<RichText>
    ) : RichText()

    /**
     * Contains a caption of an instant view web page block, consisting of a text and a trailing credit
     *
     * @text - Content of the caption
     * @credit - Block credit (like HTML tag <cite>)
     */
    class PageBlockCaption(
        val text: RichText,
        val credit: RichText
    ) : Object()

    /**
     * Describes an item of a list page block
     *
     * @label - Item label
     * @pageBlocks - Item blocks
     */
    class PageBlockListItem(
        val label: String,
        val pageBlocks: Array<PageBlock>
    ) : Object()

    /**
     * Describes a horizontal alignment of a table cell content
     */
    abstract class PageBlockHorizontalAlignment : null()

    /**
     * The content should be left-aligned
     */
    class PageBlockHorizontalAlignmentLeft : PageBlockHorizontalAlignment()

    /**
     * The content should be center-aligned
     */
    class PageBlockHorizontalAlignmentCenter : PageBlockHorizontalAlignment()

    /**
     * The content should be right-aligned
     */
    class PageBlockHorizontalAlignmentRight : PageBlockHorizontalAlignment()

    /**
     * Describes a Vertical alignment of a table cell content
     */
    abstract class PageBlockVerticalAlignment : null()

    /**
     * The content should be top-aligned
     */
    class PageBlockVerticalAlignmentTop : PageBlockVerticalAlignment()

    /**
     * The content should be middle-aligned
     */
    class PageBlockVerticalAlignmentMiddle : PageBlockVerticalAlignment()

    /**
     * The content should be bottom-aligned
     */
    class PageBlockVerticalAlignmentBottom : PageBlockVerticalAlignment()

    /**
     * Represents a cell of a table
     *
     * @text - Cell text
     * @isHeader - True, if it is a header cell
     * @colspan - The number of columns the cell should span
     * @rowspan - The number of rows the cell should span
     * @align - Horizontal cell content alignment
     * @valign - Vertical cell content alignment
     */
    class PageBlockTableCell(
        val text: RichText,
        val isHeader: Boolean,
        val colspan: Int,
        val rowspan: Int,
        val align: PageBlockHorizontalAlignment,
        val valign: PageBlockVerticalAlignment
    ) : Object()

    /**
     * Contains information about a related article
     *
     * @url - Related article URL
     * @title - Article title
     * @description - Article description
     * @photo - Article photo
     * @author - Article author
     * @publishDate - Point in time (Unix timestamp) when the article was published
     *                0 if unknown
     */
    class PageBlockRelatedArticle(
        val url: String,
        val title: String?,
        val description: String?,
        val photo: Photo?,
        val author: String?,
        val publishDate: Int
    ) : Object()

    /**
     * Describes a block of an instant view web page
     */
    abstract class PageBlock : null()

    /**
     * The title of a page
     *
     * @title - Title
     */
    class PageBlockTitle(
        val title: RichText
    ) : PageBlock()

    /**
     * The subtitle of a page
     *
     * @subtitle - Subtitle
     */
    class PageBlockSubtitle(
        val subtitle: RichText
    ) : PageBlock()

    /**
     * The author and publishing date of a page
     *
     * @author - Author
     * @publishDate - Point in time (Unix timestamp) when the article was published
     *                0 if unknown
     */
    class PageBlockAuthorDate(
        val author: RichText,
        val publishDate: Int
    ) : PageBlock()

    /**
     * A header
     *
     * @header - Header
     */
    class PageBlockHeader(
        val header: RichText
    ) : PageBlock()

    /**
     * A subheader
     *
     * @subheader - Subheader
     */
    class PageBlockSubheader(
        val subheader: RichText
    ) : PageBlock()

    /**
     * A kicker
     *
     * @kicker - Kicker
     */
    class PageBlockKicker(
        val kicker: RichText
    ) : PageBlock()

    /**
     * A text paragraph
     *
     * @text - Paragraph text
     */
    class PageBlockParagraph(
        val text: RichText
    ) : PageBlock()

    /**
     * A preformatted text paragraph
     *
     * @text - Paragraph text
     * @language - Programming language for which the text should be formatted
     */
    class PageBlockPreformatted(
        val text: RichText,
        val language: String
    ) : PageBlock()

    /**
     * The footer of a page
     *
     * @footer - Footer
     */
    class PageBlockFooter(
        val footer: RichText
    ) : PageBlock()

    /**
     * An empty block separating a page
     */
    class PageBlockDivider : PageBlock()

    /**
     * An invisible anchor on a page, which can be used in a URL to open the page from the specified anchor
     *
     * @name - Name of the anchor
     */
    class PageBlockAnchor(
        val name: String
    ) : PageBlock()

    /**
     * A list of data blocks
     *
     * @items - The items of the list
     */
    class PageBlockList(
        val items: Array<PageBlockListItem>
    ) : PageBlock()

    /**
     * A block quote
     *
     * @text - Quote text
     * @credit - Quote credit
     */
    class PageBlockBlockQuote(
        val text: RichText,
        val credit: RichText
    ) : PageBlock()

    /**
     * A pull quote
     *
     * @text - Quote text
     * @credit - Quote credit
     */
    class PageBlockPullQuote(
        val text: RichText,
        val credit: RichText
    ) : PageBlock()

    /**
     * An animation
     *
     * @animation - Animation file
     * @caption - Animation caption
     * @needAutoplay - True, if the animation should be played automatically
     */
    class PageBlockAnimation(
        val animation: Animation?,
        val caption: PageBlockCaption,
        val needAutoplay: Boolean
    ) : PageBlock()

    /**
     * An audio file
     *
     * @audio - Audio file
     * @caption - Audio file caption
     */
    class PageBlockAudio(
        val audio: Audio?,
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A photo
     *
     * @photo - Photo file
     * @caption - Photo caption
     * @url - URL that needs to be opened when the photo is clicked
     */
    class PageBlockPhoto(
        val photo: Photo?,
        val caption: PageBlockCaption,
        val url: String
    ) : PageBlock()

    /**
     * A video
     *
     * @video - Video file
     * @caption - Video caption
     * @needAutoplay - True, if the video should be played automatically
     * @isLooped - True, if the video should be looped
     */
    class PageBlockVideo(
        val video: Video?,
        val caption: PageBlockCaption,
        val needAutoplay: Boolean,
        val isLooped: Boolean
    ) : PageBlock()

    /**
     * A page cover
     *
     * @cover - Cover
     */
    class PageBlockCover(
        val cover: PageBlock
    ) : PageBlock()

    /**
     * An embedded web page
     *
     * @url - Web page URL, if available
     * @html - HTML-markup of the embedded page
     * @posterPhoto - Poster photo, if available
     * @width - Block width
     *          0 if unknown
     * @height - Block height
     *           0 if unknown
     * @caption - Block caption
     * @isFullWidth - True, if the block should be full width
     * @allowScrolling - True, if scrolling should be allowed
     */
    class PageBlockEmbedded(
        val url: String,
        val html: String,
        val posterPhoto: Photo?,
        val width: Int,
        val height: Int,
        val caption: PageBlockCaption,
        val isFullWidth: Boolean,
        val allowScrolling: Boolean
    ) : PageBlock()

    /**
     * An embedded post
     *
     * @url - Web page URL
     * @author - Post author
     * @authorPhoto - Post author photo
     * @date - Point in time (Unix timestamp) when the post was created
     *         0 if unknown
     * @pageBlocks - Post content
     * @caption - Post caption
     */
    class PageBlockEmbeddedPost(
        val url: String,
        val author: String,
        val authorPhoto: Photo?,
        val date: Int,
        val pageBlocks: Array<PageBlock>,
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A collage
     *
     * @pageBlocks - Collage item contents
     * @caption - Block caption
     */
    class PageBlockCollage(
        val pageBlocks: Array<PageBlock>,
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A slideshow
     *
     * @pageBlocks - Slideshow item contents
     * @caption - Block caption
     */
    class PageBlockSlideshow(
        val pageBlocks: Array<PageBlock>,
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * A link to a chat
     *
     * @title - Chat title
     * @photo - Chat photo
     * @username - Chat username, by which all other information about the chat should be resolved
     */
    class PageBlockChatLink(
        val title: String,
        val photo: ChatPhoto?,
        val username: String
    ) : PageBlock()

    /**
     * A table
     *
     * @caption - Table caption
     * @cells - Table cells
     * @isBordered - True, if the table is bordered
     * @isStriped - True, if the table is striped
     */
    class PageBlockTable(
        val caption: RichText,
        val cells: Array<Array<PageBlockTableCell>>,
        val isBordered: Boolean,
        val isStriped: Boolean
    ) : PageBlock()

    /**
     * A collapsible block
     *
     * @header - Always visible heading for the block
     * @pageBlocks - Block contents
     * @isOpen - True, if the block is open by default
     */
    class PageBlockDetails(
        val header: RichText,
        val pageBlocks: Array<PageBlock>,
        val isOpen: Boolean
    ) : PageBlock()

    /**
     * Related articles
     *
     * @header - Block header
     * @articles - List of related articles
     */
    class PageBlockRelatedArticles(
        val header: RichText,
        val articles: Array<PageBlockRelatedArticle>
    ) : PageBlock()

    /**
     * A map
     *
     * @location - Location of the map center
     * @zoom - Map zoom level
     * @width - Map width
     * @height - Map height
     * @caption - Block caption
     */
    class PageBlockMap(
        val location: Location,
        val zoom: Int,
        val width: Int,
        val height: Int,
        val caption: PageBlockCaption
    ) : PageBlock()

    /**
     * Describes an instant view page for a web page
     *
     * @pageBlocks - Content of the web page
     * @version - Version of the instant view, currently can be 1 or 2
     * @url - Instant view URL
     *        May be different from WebPage.url and must be used for the correct anchors handling
     * @isRtl - True, if the instant view must be shown from right to left
     * @isFull - True, if the instant view contains the full page
     *           A network request might be needed to get the full web page instant view
     */
    class WebPageInstantView(
        val pageBlocks: Array<PageBlock>,
        val version: Int,
        val url: String,
        val isRtl: Boolean,
        val isFull: Boolean
    ) : Object()

    /**
     * Describes a web page preview
     *
     * @url - Original URL of the link
     * @displayUrl - URL to display
     * @type - Type of the web page
     *         Can be: article, photo, audio, video, document, profile, app, or something else
     * @siteName - Short name of the site (e.g., Google Docs, App Store)
     * @title - Title of the content
     * @description - Description of the content
     * @photo - Image representing the content
     * @embedUrl - URL to show in the embedded preview
     * @embedType - MIME type of the embedded preview, (e.g., text/html or video/mp4)
     * @embedWidth - Width of the embedded preview
     * @embedHeight - Height of the embedded preview
     * @duration - Duration of the content, in seconds
     * @author - Author of the content
     * @animation - Preview of the content as an animation, if available
     * @audio - Preview of the content as an audio file, if available
     * @document - Preview of the content as a document, if available (currently only available for small PDF files and ZIP archives)
     * @sticker - Preview of the content as a sticker for small WEBP files, if available
     * @video - Preview of the content as a video, if available
     * @videoNote - Preview of the content as a video note, if available
     * @voiceNote - Preview of the content as a voice note, if available
     * @instantViewVersion - Version of instant view, available for the web page (currently can be 1 or 2), 0 if none
     */
    class WebPage(
        val url: String,
        val displayUrl: String,
        val type: String,
        val siteName: String,
        val title: String,
        val description: String,
        val photo: Photo?,
        val embedUrl: String,
        val embedType: String,
        val embedWidth: Int,
        val embedHeight: Int,
        val duration: Int,
        val author: String,
        val animation: Animation?,
        val audio: Audio?,
        val document: Document?,
        val sticker: Sticker?,
        val video: Video?,
        val videoNote: VideoNote?,
        val voiceNote: VoiceNote?,
        val instantViewVersion: Int
    ) : Object()

    /**
     * Describes an address
     *
     * @countryCode - A two-letter ISO 3166-1 alpha-2 country code
     * @state - State, if applicable
     * @city - City
     * @streetLine1 - First line of the address
     * @streetLine2 - Second line of the address
     * @postalCode - Address postal code
     */
    class Address(
        val countryCode: String,
        val state: String,
        val city: String,
        val streetLine1: String,
        val streetLine2: String,
        val postalCode: String
    ) : Object()

    /**
     * Portion of the price of a product (e.g., "delivery cost", "tax amount")
     *
     * @label - Label for this portion of the product price
     * @amount - Currency amount in minimal quantity of the currency
     */
    class LabeledPricePart(
        val label: String,
        val amount: Long = 0L
    ) : Object()

    /**
     * Product invoice
     *
     * @currency - ISO 4217 currency code
     * @priceParts - A list of objects used to calculate the total price of the product
     * @isTest - True, if the payment is a test payment
     * @needName - True, if the user's name is needed for payment
     * @needPhoneNumber - True, if the user's phone number is needed for payment
     * @needEmailAddress - True, if the user's email address is needed for payment
     * @needShippingAddress - True, if the user's shipping address is needed for payment
     * @sendPhoneNumberToProvider - True, if the user's phone number will be sent to the provider
     * @sendEmailAddressToProvider - True, if the user's email address will be sent to the provider
     * @isFlexible - True, if the total price depends on the shipping method
     */
    class Invoice(
        val currency: String,
        val priceParts: Array<LabeledPricePart> = emptyArray(),
        val isTest: Boolean = false,
        val needName: Boolean = false,
        val needPhoneNumber: Boolean = false,
        val needEmailAddress: Boolean = false,
        val needShippingAddress: Boolean = false,
        val sendPhoneNumberToProvider: Boolean = false,
        val sendEmailAddressToProvider: Boolean = false,
        val isFlexible: Boolean = false
    ) : Object()

    /**
     * Order information
     *
     * @name - Name of the user
     * @phoneNumber - Phone number of the user
     * @emailAddress - Email address of the user
     * @shippingAddress - Shipping address for this order
     */
    class OrderInfo(
        val name: String,
        val phoneNumber: String,
        val emailAddress: String,
        val shippingAddress: Address? = null
    ) : Object()

    /**
     * One shipping option
     *
     * @id - Shipping option identifier
     * @title - Option title
     * @priceParts - A list of objects used to calculate the total shipping costs
     */
    class ShippingOption(
        val id: String,
        val title: String,
        val priceParts: Array<LabeledPricePart> = emptyArray()
    ) : Object()

    /**
     * Contains information about saved card credentials
     *
     * @id - Unique identifier of the saved credentials
     * @title - Title of the saved credentials
     */
    class SavedCredentials(
        val id: String,
        val title: String
    ) : Object()

    /**
     * Contains information about the payment method chosen by the user
     */
    abstract class InputCredentials : null()

    /**
     * Applies if a user chooses some previously saved payment credentials
     * To use their previously saved credentials, the user must have a valid temporary password
     *
     * @savedCredentialsId - Identifier of the saved credentials
     */
    class InputCredentialsSaved(
        val savedCredentialsId: String
    ) : InputCredentials()

    /**
     * Applies if a user enters new credentials on a payment provider website
     *
     * @data - Contains JSON-encoded data with a credential identifier from the payment provider
     * @allowSave - True, if the credential identifier can be saved on the server side
     */
    class InputCredentialsNew(
        val data: String,
        val allowSave: Boolean = false
    ) : InputCredentials()

    /**
     * Applies if a user enters new credentials using Android Pay
     *
     * @data - JSON-encoded data with the credential identifier
     */
    class InputCredentialsAndroidPay(
        val data: String
    ) : InputCredentials()

    /**
     * Applies if a user enters new credentials using Apple Pay
     *
     * @data - JSON-encoded data with the credential identifier
     */
    class InputCredentialsApplePay(
        val data: String
    ) : InputCredentials()

    /**
     * Stripe payment provider
     *
     * @publishableKey - Stripe API publishable key
     * @needCountry - True, if the user country must be provided
     * @needPostalCode - True, if the user ZIP/postal code must be provided
     * @needCardholderName - True, if the cardholder name must be provided
     */
    class PaymentsProviderStripe(
        val publishableKey: String,
        val needCountry: Boolean,
        val needPostalCode: Boolean,
        val needCardholderName: Boolean
    ) : Object()

    /**
     * Contains information about an invoice payment form
     *
     * @invoice - Full information of the invoice
     * @url - Payment form URL
     * @paymentsProvider - Contains information about the payment provider, if available, to support it natively without the need for opening the URL
     * @savedOrderInfo - Saved server-side order information
     * @savedCredentials - Contains information about saved card credentials
     * @canSaveCredentials - True, if the user can choose to save credentials
     * @needPassword - True, if the user will be able to save credentials protected by a password they set up
     */
    class PaymentForm(
        val invoice: Invoice,
        val url: String,
        val paymentsProvider: PaymentsProviderStripe?,
        val savedOrderInfo: OrderInfo?,
        val savedCredentials: SavedCredentials?,
        val canSaveCredentials: Boolean,
        val needPassword: Boolean
    ) : Object()

    /**
     * Contains a temporary identifier of validated order information, which is stored for one hour
     * Also contains the available shipping options
     *
     * @orderInfoId - Temporary identifier of the order information
     * @shippingOptions - Available shipping options
     */
    class ValidatedOrderInfo(
        val orderInfoId: String,
        val shippingOptions: Array<ShippingOption>
    ) : Object()

    /**
     * Contains the result of a payment request
     *
     * @success - True, if the payment request was successful
     *            Otherwise the verification_url will be not empty
     * @verificationUrl - URL for additional payment credentials verification
     */
    class PaymentResult(
        val success: Boolean,
        val verificationUrl: String
    ) : Object()

    /**
     * Contains information about a successful payment
     *
     * @date - Point in time (Unix timestamp) when the payment was made
     * @paymentsProviderUserId - User identifier of the payment provider bot
     * @invoice - Contains information about the invoice
     * @orderInfo - Contains order information
     * @shippingOption - Chosen shipping option
     * @credentialsTitle - Title of the saved credentials
     */
    class PaymentReceipt(
        val date: Int,
        val paymentsProviderUserId: Int,
        val invoice: Invoice,
        val orderInfo: OrderInfo?,
        val shippingOption: ShippingOption?,
        val credentialsTitle: String
    ) : Object()

    /**
     * File with the date it was uploaded
     *
     * @file - The file
     * @date - Point in time (Unix timestamp) when the file was uploaded
     */
    class DatedFile(
        val file: File,
        val date: Int
    ) : Object()

    /**
     * Contains the type of a Telegram Passport element
     */
    abstract class PassportElementType : null()

    /**
     * A Telegram Passport element containing the user's personal details
     */
    class PassportElementTypePersonalDetails : PassportElementType()

    /**
     * A Telegram Passport element containing the user's passport
     */
    class PassportElementTypePassport : PassportElementType()

    /**
     * A Telegram Passport element containing the user's driver license
     */
    class PassportElementTypeDriverLicense : PassportElementType()

    /**
     * A Telegram Passport element containing the user's identity card
     */
    class PassportElementTypeIdentityCard : PassportElementType()

    /**
     * A Telegram Passport element containing the user's internal passport
     */
    class PassportElementTypeInternalPassport : PassportElementType()

    /**
     * A Telegram Passport element containing the user's address
     */
    class PassportElementTypeAddress : PassportElementType()

    /**
     * A Telegram Passport element containing the user's utility bill
     */
    class PassportElementTypeUtilityBill : PassportElementType()

    /**
     * A Telegram Passport element containing the user's bank statement
     */
    class PassportElementTypeBankStatement : PassportElementType()

    /**
     * A Telegram Passport element containing the user's rental agreement
     */
    class PassportElementTypeRentalAgreement : PassportElementType()

    /**
     * A Telegram Passport element containing the registration page of the user's passport
     */
    class PassportElementTypePassportRegistration : PassportElementType()

    /**
     * A Telegram Passport element containing the user's temporary registration
     */
    class PassportElementTypeTemporaryRegistration : PassportElementType()

    /**
     * A Telegram Passport element containing the user's phone number
     */
    class PassportElementTypePhoneNumber : PassportElementType()

    /**
     * A Telegram Passport element containing the user's email address
     */
    class PassportElementTypeEmailAddress : PassportElementType()

    /**
     * Represents a date according to the Gregorian calendar
     *
     * @day - Day of the month, 1-31
     * @month - Month, 1-12
     * @year - Year, 1-9999
     */
    class Date(
        val day: Int = 0,
        val month: Int = 0,
        val year: Int = 0
    ) : Object()

    /**
     * Contains the user's personal details
     *
     * @firstName - First name of the user written in English
     * @middleName - Middle name of the user written in English
     * @lastName - Last name of the user written in English
     * @nativeFirstName - Native first name of the user
     * @nativeMiddleName - Native middle name of the user
     * @nativeLastName - Native last name of the user
     * @birthdate - Birthdate of the user
     * @gender - Gender of the user, "male" or "female"
     * @countryCode - A two-letter ISO 3166-1 alpha-2 country code of the user's country
     * @residenceCountryCode - A two-letter ISO 3166-1 alpha-2 country code of the user's residence country
     */
    class PersonalDetails(
        val firstName: String,
        val middleName: String,
        val lastName: String,
        val nativeFirstName: String,
        val nativeMiddleName: String,
        val nativeLastName: String,
        val birthdate: Date,
        val gender: String,
        val countryCode: String,
        val residenceCountryCode: String
    ) : Object()

    /**
     * An identity document
     *
     * @number - Document number
     * @expiryDate - Document expiry date
     * @frontSide - Front side of the document
     * @reverseSide - Reverse side of the document
     *                Only for driver license and identity card
     * @selfie - Selfie with the document
     * @translation - List of files containing a certified English translation of the document
     */
    class IdentityDocument(
        val number: String,
        val expiryDate: Date?,
        val frontSide: DatedFile,
        val reverseSide: DatedFile,
        val selfie: DatedFile?,
        val translation: Array<DatedFile>
    ) : Object()

    /**
     * An identity document to be saved to Telegram Passport
     *
     * @number - Document number
     * @expiryDate - Document expiry date, if available
     * @frontSide - Front side of the document
     * @reverseSide - Reverse side of the document
     *                Only for driver license and identity card
     * @selfie - Selfie with the document, if available
     * @translation - List of files containing a certified English translation of the document
     */
    class InputIdentityDocument(
        val number: String,
        val expiryDate: Date,
        val frontSide: InputFile,
        val reverseSide: InputFile,
        val selfie: InputFile,
        val translation: Array<InputFile> = emptyArray()
    ) : Object()

    /**
     * A personal document, containing some information about a user
     *
     * @files - List of files containing the pages of the document
     * @translation - List of files containing a certified English translation of the document
     */
    class PersonalDocument(
        val files: Array<DatedFile>,
        val translation: Array<DatedFile>
    ) : Object()

    /**
     * A personal document to be saved to Telegram Passport
     *
     * @files - List of files containing the pages of the document
     * @translation - List of files containing a certified English translation of the document
     */
    class InputPersonalDocument(
        val files: Array<InputFile> = emptyArray(),
        val translation: Array<InputFile> = emptyArray()
    ) : Object()

    /**
     * Contains information about a Telegram Passport element
     */
    abstract class PassportElement : null()

    /**
     * A Telegram Passport element containing the user's personal details
     *
     * @personalDetails - Personal details of the user
     */
    class PassportElementPersonalDetails(
        val personalDetails: PersonalDetails
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's passport
     *
     * @passport - Passport
     */
    class PassportElementPassport(
        val passport: IdentityDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's driver license
     *
     * @driverLicense - Driver license
     */
    class PassportElementDriverLicense(
        val driverLicense: IdentityDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's identity card
     *
     * @identityCard - Identity card
     */
    class PassportElementIdentityCard(
        val identityCard: IdentityDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's internal passport
     *
     * @internalPassport - Internal passport
     */
    class PassportElementInternalPassport(
        val internalPassport: IdentityDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's address
     *
     * @address - Address
     */
    class PassportElementAddress(
        val address: Address
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's utility bill
     *
     * @utilityBill - Utility bill
     */
    class PassportElementUtilityBill(
        val utilityBill: PersonalDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's bank statement
     *
     * @bankStatement - Bank statement
     */
    class PassportElementBankStatement(
        val bankStatement: PersonalDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's rental agreement
     *
     * @rentalAgreement - Rental agreement
     */
    class PassportElementRentalAgreement(
        val rentalAgreement: PersonalDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's passport registration pages
     *
     * @passportRegistration - Passport registration pages
     */
    class PassportElementPassportRegistration(
        val passportRegistration: PersonalDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's temporary registration
     *
     * @temporaryRegistration - Temporary registration
     */
    class PassportElementTemporaryRegistration(
        val temporaryRegistration: PersonalDocument
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's phone number
     *
     * @phoneNumber - Phone number
     */
    class PassportElementPhoneNumber(
        val phoneNumber: String
    ) : PassportElement()

    /**
     * A Telegram Passport element containing the user's email address
     *
     * @emailAddress - Email address
     */
    class PassportElementEmailAddress(
        val emailAddress: String
    ) : PassportElement()

    /**
     * Contains information about a Telegram Passport element to be saved
     */
    abstract class InputPassportElement : null()

    /**
     * A Telegram Passport element to be saved containing the user's personal details
     *
     * @personalDetails - Personal details of the user
     */
    class InputPassportElementPersonalDetails(
        val personalDetails: PersonalDetails
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's passport
     *
     * @passport - The passport to be saved
     */
    class InputPassportElementPassport(
        val passport: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's driver license
     *
     * @driverLicense - The driver license to be saved
     */
    class InputPassportElementDriverLicense(
        val driverLicense: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's identity card
     *
     * @identityCard - The identity card to be saved
     */
    class InputPassportElementIdentityCard(
        val identityCard: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's internal passport
     *
     * @internalPassport - The internal passport to be saved
     */
    class InputPassportElementInternalPassport(
        val internalPassport: InputIdentityDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's address
     *
     * @address - The address to be saved
     */
    class InputPassportElementAddress(
        val address: Address
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's utility bill
     *
     * @utilityBill - The utility bill to be saved
     */
    class InputPassportElementUtilityBill(
        val utilityBill: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's bank statement
     *
     * @bankStatement - The bank statement to be saved
     */
    class InputPassportElementBankStatement(
        val bankStatement: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's rental agreement
     *
     * @rentalAgreement - The rental agreement to be saved
     */
    class InputPassportElementRentalAgreement(
        val rentalAgreement: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's passport registration
     *
     * @passportRegistration - The passport registration page to be saved
     */
    class InputPassportElementPassportRegistration(
        val passportRegistration: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's temporary registration
     *
     * @temporaryRegistration - The temporary registration document to be saved
     */
    class InputPassportElementTemporaryRegistration(
        val temporaryRegistration: InputPersonalDocument
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's phone number
     *
     * @phoneNumber - The phone number to be saved
     */
    class InputPassportElementPhoneNumber(
        val phoneNumber: String
    ) : InputPassportElement()

    /**
     * A Telegram Passport element to be saved containing the user's email address
     *
     * @emailAddress - The email address to be saved
     */
    class InputPassportElementEmailAddress(
        val emailAddress: String
    ) : InputPassportElement()

    /**
     * Contains information about saved Telegram Passport elements
     *
     * @elements - Telegram Passport elements
     */
    class PassportElements(
        val elements: Array<PassportElement>
    ) : Object()

    /**
     * Contains the description of an error in a Telegram Passport element
     */
    abstract class PassportElementErrorSource : null()

    /**
     * The element contains an error in an unspecified place
     * The error will be considered resolved when new data is added
     */
    class PassportElementErrorSourceUnspecified : PassportElementErrorSource()

    /**
     * One of the data fields contains an error
     * The error will be considered resolved when the value of the field changes
     *
     * @fieldName - Field name
     */
    class PassportElementErrorSourceDataField(
        val fieldName: String
    ) : PassportElementErrorSource()

    /**
     * The front side of the document contains an error
     * The error will be considered resolved when the file with the front side changes
     */
    class PassportElementErrorSourceFrontSide : PassportElementErrorSource()

    /**
     * The reverse side of the document contains an error
     * The error will be considered resolved when the file with the reverse side changes
     */
    class PassportElementErrorSourceReverseSide : PassportElementErrorSource()

    /**
     * The selfie with the document contains an error
     * The error will be considered resolved when the file with the selfie changes
     */
    class PassportElementErrorSourceSelfie : PassportElementErrorSource()

    /**
     * One of files with the translation of the document contains an error
     * The error will be considered resolved when the file changes
     *
     * @fileIndex - Index of a file with the error
     */
    class PassportElementErrorSourceTranslationFile(
        val fileIndex: Int
    ) : PassportElementErrorSource()

    /**
     * The translation of the document contains an error
     * The error will be considered resolved when the list of translation files changes
     */
    class PassportElementErrorSourceTranslationFiles : PassportElementErrorSource()

    /**
     * The file contains an error
     * The error will be considered resolved when the file changes
     *
     * @fileIndex - Index of a file with the error
     */
    class PassportElementErrorSourceFile(
        val fileIndex: Int
    ) : PassportElementErrorSource()

    /**
     * The list of attached files contains an error
     * The error will be considered resolved when the list of files changes
     */
    class PassportElementErrorSourceFiles : PassportElementErrorSource()

    /**
     * Contains the description of an error in a Telegram Passport element
     *
     * @type - Type of the Telegram Passport element which has the error
     * @message - Error message
     * @source - Error source
     */
    class PassportElementError(
        val type: PassportElementType,
        val message: String,
        val source: PassportElementErrorSource
    ) : Object()

    /**
     * Contains information about a Telegram Passport element that was requested by a service
     *
     * @type - Type of the element
     * @isSelfieRequired - True, if a selfie is required with the identity document
     * @isTranslationRequired - True, if a certified English translation is required with the document
     * @isNativeNameRequired - True, if personal details must include the user's name in the language of their country of residence
     */
    class PassportSuitableElement(
        val type: PassportElementType,
        val isSelfieRequired: Boolean,
        val isTranslationRequired: Boolean,
        val isNativeNameRequired: Boolean
    ) : Object()

    /**
     * Contains a description of the required Telegram Passport element that was requested by a service
     *
     * @suitableElements - List of Telegram Passport elements any of which is enough to provide
     */
    class PassportRequiredElement(
        val suitableElements: Array<PassportSuitableElement>
    ) : Object()

    /**
     * Contains information about a Telegram Passport authorization form that was requested
     *
     * @id - Unique identifier of the authorization form
     * @requiredElements - Information about the Telegram Passport elements that need to be provided to complete the form
     * @privacyPolicyUrl - URL for the privacy policy of the service
     */
    class PassportAuthorizationForm(
        val id: Int,
        val requiredElements: Array<PassportRequiredElement>,
        val privacyPolicyUrl: String?
    ) : Object()

    /**
     * Contains information about a Telegram Passport elements and corresponding errors
     *
     * @elements - Telegram Passport elements
     * @errors - Errors in the elements that are already available
     */
    class PassportElementsWithErrors(
        val elements: Array<PassportElement>,
        val errors: Array<PassportElementError>
    ) : Object()

    /**
     * Contains encrypted Telegram Passport data credentials
     *
     * @data - The encrypted credentials
     * @hash - The decrypted data hash
     * @secret - Secret for data decryption, encrypted with the service's public key
     */
    class EncryptedCredentials(
        val data: ByteArray,
        val hash: ByteArray,
        val secret: ByteArray
    ) : Object()

    /**
     * Contains information about an encrypted Telegram Passport element
     *
     * @type - Type of Telegram Passport element
     * @data - Encrypted JSON-encoded data about the user
     * @frontSide - The front side of an identity document
     * @reverseSide - The reverse side of an identity document
     * @selfie - Selfie with the document
     * @translation - List of files containing a certified English translation of the document
     * @files - List of attached files
     * @value - Unencrypted data, phone number or email address
     * @hash - Hash of the entire element
     */
    @BotsOnly
    class EncryptedPassportElement(
        val type: PassportElementType,
        val data: ByteArray,
        val frontSide: DatedFile,
        val reverseSide: DatedFile?,
        val selfie: DatedFile?,
        val translation: Array<DatedFile>,
        val files: Array<DatedFile>,
        val value: String,
        val hash: String
    ) : Object()

    /**
     * Contains the description of an error in a Telegram Passport element
     */
    @BotsOnly
    abstract class InputPassportElementErrorSource : null()

    /**
     * The element contains an error in an unspecified place
     * The error will be considered resolved when new data is added
     *
     * @elementHash - Current hash of the entire element
     */
    class InputPassportElementErrorSourceUnspecified(
        val elementHash: ByteArray = byteArrayOf()
    ) : InputPassportElementErrorSource()

    /**
     * A data field contains an error
     * The error is considered resolved when the field's value changes
     *
     * @fieldName - Field name
     * @dataHash - Current data hash
     */
    class InputPassportElementErrorSourceDataField(
        val fieldName: String,
        val dataHash: ByteArray = byteArrayOf()
    ) : InputPassportElementErrorSource()

    /**
     * The front side of the document contains an error
     * The error is considered resolved when the file with the front side of the document changes
     *
     * @fileHash - Current hash of the file containing the front side
     */
    class InputPassportElementErrorSourceFrontSide(
        val fileHash: ByteArray = byteArrayOf()
    ) : InputPassportElementErrorSource()

    /**
     * The reverse side of the document contains an error
     * The error is considered resolved when the file with the reverse side of the document changes
     *
     * @fileHash - Current hash of the file containing the reverse side
     */
    class InputPassportElementErrorSourceReverseSide(
        val fileHash: ByteArray = byteArrayOf()
    ) : InputPassportElementErrorSource()

    /**
     * The selfie contains an error
     * The error is considered resolved when the file with the selfie changes
     *
     * @fileHash - Current hash of the file containing the selfie
     */
    class InputPassportElementErrorSourceSelfie(
        val fileHash: ByteArray = byteArrayOf()
    ) : InputPassportElementErrorSource()

    /**
     * One of the files containing the translation of the document contains an error
     * The error is considered resolved when the file with the translation changes
     *
     * @fileHash - Current hash of the file containing the translation
     */
    class InputPassportElementErrorSourceTranslationFile(
        val fileHash: ByteArray = byteArrayOf()
    ) : InputPassportElementErrorSource()

    /**
     * The translation of the document contains an error
     * The error is considered resolved when the list of files changes
     *
     * @fileHashes - Current hashes of all files with the translation
     */
    class InputPassportElementErrorSourceTranslationFiles(
        val fileHashes: Array<ByteArray> = emptyArray()
    ) : InputPassportElementErrorSource()

    /**
     * The file contains an error
     * The error is considered resolved when the file changes
     *
     * @fileHash - Current hash of the file which has the error
     */
    class InputPassportElementErrorSourceFile(
        val fileHash: ByteArray = byteArrayOf()
    ) : InputPassportElementErrorSource()

    /**
     * The list of attached files contains an error
     * The error is considered resolved when the file list changes
     *
     * @fileHashes - Current hashes of all attached files
     */
    class InputPassportElementErrorSourceFiles(
        val fileHashes: Array<ByteArray> = emptyArray()
    ) : InputPassportElementErrorSource()

    /**
     * Contains the description of an error in a Telegram Passport element
     *
     * @type - Type of Telegram Passport element that has the error
     * @message - Error message
     * @source - Error source
     */
    @BotsOnly
    class InputPassportElementError(
        val type: PassportElementType,
        val message: String,
        val source: InputPassportElementErrorSource
    ) : Object()

    /**
     * Contains the content of a message
     */
    abstract class MessageContent : null()

    /**
     * A text message
     *
     * @text - Text of the message
     * @webPage - A preview of the web page that's mentioned in the text
     */
    class MessageText(
        val text: FormattedText,
        val webPage: WebPage?
    ) : MessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @animation - Message content
     * @caption - Animation caption
     * @isSecret - True, if the animation thumbnail must be blurred and the animation must be shown only while tapped
     */
    class MessageAnimation(
        val animation: Animation,
        val caption: FormattedText,
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * An audio message
     *
     * @audio - Message content
     * @caption - Audio caption
     */
    class MessageAudio(
        val audio: Audio,
        val caption: FormattedText
    ) : MessageContent()

    /**
     * A document message (general file)
     *
     * @document - Message content
     * @caption - Document caption
     */
    class MessageDocument(
        val document: Document,
        val caption: FormattedText
    ) : MessageContent()

    /**
     * A photo message
     *
     * @photo - Message content
     * @caption - Photo caption
     * @isSecret - True, if the photo must be blurred and must be shown only while tapped
     */
    class MessagePhoto(
        val photo: Photo,
        val caption: FormattedText,
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * An expired photo message (self-destructed after TTL has elapsed)
     */
    class MessageExpiredPhoto : MessageContent()

    /**
     * A sticker message
     *
     * @sticker - Message content
     */
    class MessageSticker(
        val sticker: Sticker
    ) : MessageContent()

    /**
     * A video message
     *
     * @video - Message content
     * @caption - Video caption
     * @isSecret - True, if the video thumbnail must be blurred and the video must be shown only while tapped
     */
    class MessageVideo(
        val video: Video,
        val caption: FormattedText,
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * An expired video message (self-destructed after TTL has elapsed)
     */
    class MessageExpiredVideo : MessageContent()

    /**
     * A video note message
     *
     * @videoNote - Message content
     * @isViewed - True, if at least one of the recipients has viewed the video note
     * @isSecret - True, if the video note thumbnail must be blurred and the video note must be shown only while tapped
     */
    class MessageVideoNote(
        val videoNote: VideoNote,
        val isViewed: Boolean,
        val isSecret: Boolean
    ) : MessageContent()

    /**
     * A voice note message
     *
     * @voiceNote - Message content
     * @caption - Voice note caption
     * @isListened - True, if at least one of the recipients has listened to the voice note
     */
    class MessageVoiceNote(
        val voiceNote: VoiceNote,
        val caption: FormattedText,
        val isListened: Boolean
    ) : MessageContent()

    /**
     * A message with a location
     *
     * @location - Message content
     * @livePeriod - Time relative to the message sent date until which the location can be updated, in seconds
     * @expiresIn - Left time for which the location can be updated, in seconds
     *              UpdateMessageContent is not sent when this field changes
     */
    class MessageLocation(
        val location: Location,
        val livePeriod: Int,
        val expiresIn: Int
    ) : MessageContent()

    /**
     * A message with information about a venue
     *
     * @venue - Message content
     */
    class MessageVenue(
        val venue: Venue
    ) : MessageContent()

    /**
     * A message with a user contact
     *
     * @contact - Message content
     */
    class MessageContact(
        val contact: Contact
    ) : MessageContent()

    /**
     * A message with a game
     *
     * @game - Game
     */
    class MessageGame(
        val game: Game
    ) : MessageContent()

    /**
     * A message with a poll
     *
     * @poll - Poll
     */
    class MessagePoll(
        val poll: Poll
    ) : MessageContent()

    /**
     * A message with an invoice from a bot
     *
     * @title - Product title
     * @description - Product description
     * @photo - Product photo
     * @currency - Currency for the product price
     * @totalAmount - Product total price in the minimal quantity of the currency
     * @startParameter - Unique invoice bot start_parameter
     *                   To share an invoice use the URL https://t.me/{bot_username}?start={start_parameter}
     * @isTest - True, if the invoice is a test invoice
     * @needShippingAddress - True, if the shipping address should be specified
     * @receiptMessageId - The identifier of the message with the receipt, after the product has been purchased
     */
    class MessageInvoice(
        val title: String,
        val description: String,
        val photo: Photo?,
        val currency: String,
        val totalAmount: Long,
        val startParameter: String,
        val isTest: Boolean,
        val needShippingAddress: Boolean,
        val receiptMessageId: Long
    ) : MessageContent()

    /**
     * A message with information about an ended call
     *
     * @discardReason - Reason why the call was discarded
     * @duration - Call duration, in seconds
     */
    class MessageCall(
        val discardReason: CallDiscardReason,
        val duration: Int
    ) : MessageContent()

    /**
     * A newly created basic group
     *
     * @title - Title of the basic group
     * @memberUserIds - User identifiers of members in the basic group
     */
    class MessageBasicGroupChatCreate(
        val title: String,
        val memberUserIds: IntArray
    ) : MessageContent()

    /**
     * A newly created supergroup or channel
     *
     * @title - Title of the supergroup or channel
     */
    class MessageSupergroupChatCreate(
        val title: String
    ) : MessageContent()

    /**
     * An updated chat title
     *
     * @title - New chat title
     */
    class MessageChatChangeTitle(
        val title: String
    ) : MessageContent()

    /**
     * An updated chat photo
     *
     * @photo - New chat photo
     */
    class MessageChatChangePhoto(
        val photo: Photo
    ) : MessageContent()

    /**
     * A deleted chat photo
     */
    class MessageChatDeletePhoto : MessageContent()

    /**
     * New chat members were added
     *
     * @memberUserIds - User identifiers of the new members
     */
    class MessageChatAddMembers(
        val memberUserIds: IntArray
    ) : MessageContent()

    /**
     * A new member joined the chat by invite link
     */
    class MessageChatJoinByLink : MessageContent()

    /**
     * A chat member was deleted
     *
     * @userId - User identifier of the deleted chat member
     */
    class MessageChatDeleteMember(
        val userId: Int
    ) : MessageContent()

    /**
     * A basic group was upgraded to a supergroup and was deactivated as the result
     *
     * @supergroupId - Identifier of the supergroup to which the basic group was upgraded
     */
    class MessageChatUpgradeTo(
        val supergroupId: Int
    ) : MessageContent()

    /**
     * A supergroup has been created from a basic group
     *
     * @title - Title of the newly created supergroup
     * @basicGroupId - The identifier of the original basic group
     */
    class MessageChatUpgradeFrom(
        val title: String,
        val basicGroupId: Int
    ) : MessageContent()

    /**
     * A message has been pinned
     *
     * @messageId - Identifier of the pinned message, can be an identifier of a deleted message or 0
     */
    class MessagePinMessage(
        val messageId: Long
    ) : MessageContent()

    /**
     * A screenshot of a message in the chat has been taken
     */
    class MessageScreenshotTaken : MessageContent()

    /**
     * The TTL (Time To Live) setting messages in a secret chat has been changed
     *
     * @ttl - New TTL
     */
    class MessageChatSetTtl(
        val ttl: Int
    ) : MessageContent()

    /**
     * A non-standard action has happened in the chat
     *
     * @text - Message text to be shown in the chat
     */
    class MessageCustomServiceAction(
        val text: String
    ) : MessageContent()

    /**
     * A new high score was achieved in a game
     *
     * @gameMessageId - Identifier of the message with the game, can be an identifier of a deleted message
     * @gameId - Identifier of the game
     *           May be different from the games presented in the message with the game
     * @score - New score
     */
    class MessageGameScore(
        val gameMessageId: Long,
        val gameId: Long,
        val score: Int
    ) : MessageContent()

    /**
     * A payment has been completed
     *
     * @invoiceMessageId - Identifier of the message with the corresponding invoice
     *                     Can be an identifier of a deleted message
     * @currency - Currency for the price of the product
     * @totalAmount - Total price for the product, in the minimal quantity of the currency
     */
    class MessagePaymentSuccessful(
        val invoiceMessageId: Long,
        val currency: String,
        val totalAmount: Long
    ) : MessageContent()

    /**
     * A payment has been completed
     *
     * @invoiceMessageId - Identifier of the message with the corresponding invoice
     *                     Can be an identifier of a deleted message
     * @currency - Currency for price of the product
     * @totalAmount - Total price for the product, in the minimal quantity of the currency
     * @invoicePayload - Invoice payload
     * @shippingOptionId - Identifier of the shipping option chosen by the user
     *                     May be empty if not applicable
     * @orderInfo - Information about the order
     * @telegramPaymentChargeId - Telegram payment identifier
     * @providerPaymentChargeId - Provider payment identifier
     */
    @BotsOnly
    class MessagePaymentSuccessfulBot(
        val invoiceMessageId: Long,
        val currency: String,
        val totalAmount: Long,
        val invoicePayload: ByteArray,
        val shippingOptionId: String?,
        val orderInfo: OrderInfo?,
        val telegramPaymentChargeId: String,
        val providerPaymentChargeId: String
    ) : MessageContent()

    /**
     * A contact has registered with Telegram
     */
    class MessageContactRegistered : MessageContent()

    /**
     * The current user has connected a website by logging in using Telegram Login Widget on it
     *
     * @domainName - Domain name of the connected website
     */
    class MessageWebsiteConnected(
        val domainName: String
    ) : MessageContent()

    /**
     * Telegram Passport data has been sent
     *
     * @types - List of Telegram Passport element types sent
     */
    class MessagePassportDataSent(
        val types: Array<PassportElementType>
    ) : MessageContent()

    /**
     * Telegram Passport data has been received
     *
     * @elements - List of received Telegram Passport elements
     * @credentials - Encrypted data credentials
     */
    @BotsOnly
    class MessagePassportDataReceived(
        val elements: Array<EncryptedPassportElement>,
        val credentials: EncryptedCredentials
    ) : MessageContent()

    /**
     * Message content that is not supported by the client
     */
    class MessageUnsupported : MessageContent()

    /**
     * Represents a part of the text which must be formatted differently
     */
    abstract class TextEntityType : null()

    /**
     * A mention of a user by their username
     */
    class TextEntityTypeMention : TextEntityType()

    /**
     * A hashtag text, beginning with "#"
     */
    class TextEntityTypeHashtag : TextEntityType()

    /**
     * A cashtag text, beginning with "$" and consisting of capital english letters (i.e
     * "$USD")
     */
    class TextEntityTypeCashtag : TextEntityType()

    /**
     * A bot command, beginning with "/"
     * This shouldn't be highlighted if there are no bots in the chat
     */
    class TextEntityTypeBotCommand : TextEntityType()

    /**
     * An HTTP URL
     */
    class TextEntityTypeUrl : TextEntityType()

    /**
     * An email address
     */
    class TextEntityTypeEmailAddress : TextEntityType()

    /**
     * A bold text
     */
    class TextEntityTypeBold : TextEntityType()

    /**
     * An italic text
     */
    class TextEntityTypeItalic : TextEntityType()

    /**
     * Text that must be formatted as if inside a code HTML tag
     */
    class TextEntityTypeCode : TextEntityType()

    /**
     * Text that must be formatted as if inside a pre HTML tag
     */
    class TextEntityTypePre : TextEntityType()

    /**
     * Text that must be formatted as if inside pre, and code HTML tags
     *
     * @language - Programming language of the code
     *             As defined by the sender
     */
    class TextEntityTypePreCode(
        val language: String
    ) : TextEntityType()

    /**
     * A text description shown instead of a raw URL
     *
     * @url - HTTP or tg:// URL to be opened when the link is clicked
     */
    class TextEntityTypeTextUrl(
        val url: String
    ) : TextEntityType()

    /**
     * A text shows instead of a raw mention of the user (e.g., when the user has no username)
     *
     * @userId - Identifier of the mentioned user
     */
    class TextEntityTypeMentionName(
        val userId: Int = 0
    ) : TextEntityType()

    /**
     * A phone number
     */
    class TextEntityTypePhoneNumber : TextEntityType()

    /**
     * A thumbnail to be sent along with a file
     * Should be in JPEG or WEBP format for stickers, and less than 200 kB in size
     *
     * @thumbnail - Thumbnail file to send
     *              Sending thumbnails by file_id is currently not supported
     * @width - Thumbnail width, usually shouldn't exceed 320
     *          Use 0 if unknown
     * @height - Thumbnail height, usually shouldn't exceed 320
     *           Use 0 if unknown
     */
    class InputThumbnail(
        val thumbnail: InputFile,
        val width: Int = 0,
        val height: Int = 0
    ) : Object()

    /**
     * The content of a message to send
     */
    abstract class InputMessageContent : null()

    /**
     * A text message
     *
     * @text - Formatted text to be sent
     *         1-GetOption("message_text_length_max") characters
     *         Only Bold, Italic, Code, Pre, PreCode and TextUrl entities are allowed to be specified manually
     * @disableWebPagePreview - True, if rich web page previews for URLs in the message text should be disabled
     * @clearDraft - True, if a chat message draft should be deleted
     */
    class InputMessageText(
        val text: FormattedText,
        val disableWebPagePreview: Boolean = false,
        val clearDraft: Boolean = false
    ) : InputMessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @animation - Animation file to be sent
     * @thumbnail - Animation thumbnail, if available
     * @duration - Duration of the animation, in seconds
     * @width - Width of the animation
     *          May be replaced by the server
     * @height - Height of the animation
     *           May be replaced by the server
     * @caption - Animation caption
     *            0-GetOption("message_caption_length_max") characters
     */
    class InputMessageAnimation(
        val animation: InputFile,
        val thumbnail: InputThumbnail,
        val duration: Int = 0,
        val width: Int = 0,
        val height: Int = 0,
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * An audio message
     *
     * @audio - Audio file to be sent
     * @albumCoverThumbnail - Thumbnail of the cover for the album, if available
     * @duration - Duration of the audio, in seconds
     *             May be replaced by the server
     * @title - Title of the audio
     *          May be replaced by the server
     * @performer - Performer of the audio
     * @caption - Audio caption
     *            0-GetOption("message_caption_length_max") characters
     */
    class InputMessageAudio(
        val audio: InputFile,
        val albumCoverThumbnail: InputThumbnail,
        val duration: Int = 0,
        val title: String,
        val performer: String,
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * A document message (general file)
     *
     * @document - Document to be sent
     * @thumbnail - Document thumbnail, if available
     * @caption - Document caption
     *            0-GetOption("message_caption_length_max") characters
     */
    class InputMessageDocument(
        val document: InputFile,
        val thumbnail: InputThumbnail,
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * A photo message
     *
     * @photo - Photo to send
     * @thumbnail - Photo thumbnail to be sent, this is sent to the other party in secret chats only
     * @addedStickerFileIds - File identifiers of the stickers added to the photo, if applicable
     * @width - Photo width
     * @height - Photo height
     * @caption - Photo caption
     *            0-GetOption("message_caption_length_max") characters
     * @ttl - Photo TTL (Time To Live), in seconds (0-60)
     *        A non-zero TTL can be specified only in private chats
     */
    class InputMessagePhoto(
        val photo: InputFile,
        val thumbnail: InputThumbnail,
        val addedStickerFileIds: IntArray = intArrayOf(),
        val width: Int = 0,
        val height: Int = 0,
        val caption: FormattedText,
        val ttl: Int = 0
    ) : InputMessageContent()

    /**
     * A sticker message
     *
     * @sticker - Sticker to be sent
     * @thumbnail - Sticker thumbnail, if available
     * @width - Sticker width
     * @height - Sticker height
     */
    class InputMessageSticker(
        val sticker: InputFile,
        val thumbnail: InputThumbnail,
        val width: Int = 0,
        val height: Int = 0
    ) : InputMessageContent()

    /**
     * A video message
     *
     * @video - Video to be sent
     * @thumbnail - Video thumbnail, if available
     * @addedStickerFileIds - File identifiers of the stickers added to the video, if applicable
     * @duration - Duration of the video, in seconds
     * @width - Video width
     * @height - Video height
     * @supportsStreaming - True, if the video should be tried to be streamed
     * @caption - Video caption
     *            0-GetOption("message_caption_length_max") characters
     * @ttl - Video TTL (Time To Live), in seconds (0-60)
     *        A non-zero TTL can be specified only in private chats
     */
    class InputMessageVideo(
        val video: InputFile,
        val thumbnail: InputThumbnail,
        val addedStickerFileIds: IntArray = intArrayOf(),
        val duration: Int = 0,
        val width: Int = 0,
        val height: Int = 0,
        val supportsStreaming: Boolean = false,
        val caption: FormattedText,
        val ttl: Int = 0
    ) : InputMessageContent()

    /**
     * A video note message
     *
     * @videoNote - Video note to be sent
     * @thumbnail - Video thumbnail, if available
     * @duration - Duration of the video, in seconds
     * @length - Video width and height
     *           Must be positive and not greater than 640
     */
    class InputMessageVideoNote(
        val videoNote: InputFile,
        val thumbnail: InputThumbnail,
        val duration: Int = 0,
        val length: Int = 0
    ) : InputMessageContent()

    /**
     * A voice note message
     *
     * @voiceNote - Voice note to be sent
     * @duration - Duration of the voice note, in seconds
     * @waveform - Waveform representation of the voice note, in 5-bit format
     * @caption - Voice note caption
     *            0-GetOption("message_caption_length_max") characters
     */
    class InputMessageVoiceNote(
        val voiceNote: InputFile,
        val duration: Int = 0,
        val waveform: ByteArray = byteArrayOf(),
        val caption: FormattedText
    ) : InputMessageContent()

    /**
     * A message with a location
     *
     * @location - Location to be sent
     * @livePeriod - Period for which the location can be updated, in seconds
     *               Should bebetween 60 and 86400 for a live location and 0 otherwise
     */
    class InputMessageLocation(
        val location: Location,
        val livePeriod: Int = 0
    ) : InputMessageContent()

    /**
     * A message with information about a venue
     *
     * @venue - Venue to send
     */
    class InputMessageVenue(
        val venue: Venue
    ) : InputMessageContent()

    /**
     * A message containing a user contact
     *
     * @contact - Contact to send
     */
    class InputMessageContact(
        val contact: Contact
    ) : InputMessageContent()

    /**
     * A message with a game
     * Not supported for channels or secret chats
     *
     * @botUserId - User identifier of the bot that owns the game
     * @gameShortName - Short name of the game
     */
    class InputMessageGame(
        val botUserId: Int = 0,
        val gameShortName: String
    ) : InputMessageContent()

    /**
     * A message with an invoice
     *
     * @invoice - Invoice
     * @title - Product title
     * @description - Product description
     * @photoUrl - Product photo URL
     * @photoSize - Product photo size
     * @photoWidth - Product photo width
     * @photoHeight - Product photo height
     * @payload - The invoice payload
     * @providerToken - Payment provider token
     * @providerData - JSON-encoded data about the invoice, which will be shared with the payment provider
     * @startParameter - Unique invoice bot start_parameter for the generation of this invoice
     */
    @BotsOnly
    class InputMessageInvoice(
        val invoice: Invoice,
        val title: String,
        val description: String,
        val photoUrl: String? = null,
        val photoSize: Int = 0,
        val photoWidth: Int = 0,
        val photoHeight: Int = 0,
        val payload: ByteArray = byteArrayOf(),
        val providerToken: String,
        val providerData: String,
        val startParameter: String
    ) : InputMessageContent()

    /**
     * A message with a poll
     * Polls can't be sent to private or secret chats
     *
     * @question - Poll question, 1-255 characters
     * @options - List of poll answer options, 2-10 strings 1-100 characters each
     */
    class InputMessagePoll(
        val question: String,
        val options: Array<String> = emptyArray()
    ) : InputMessageContent()

    /**
     * A forwarded message
     *
     * @fromChatId - Identifier for the chat this forwarded message came from
     * @messageId - Identifier of the message to forward
     * @inGameShare - True, if a game message should be shared within a launched game
     *                Applies only to game messages
     * @sendCopy - True, if content of the message needs to be copied without a link to the original message
     *             Always true if the message is forwarded to a secret chat
     * @removeCaption - True, if media caption of the message copy needs to be removed
     *                  Ignored if send_copy is false
     */
    class InputMessageForwarded(
        val fromChatId: Long = 0L,
        val messageId: Long = 0L,
        val inGameShare: Boolean = false,
        val sendCopy: Boolean = false,
        val removeCaption: Boolean = false
    ) : InputMessageContent()

    /**
     * Represents a filter for message search results
     */
    abstract class SearchMessagesFilter : null()

    /**
     * Returns all found messages, no filter is applied
     */
    class SearchMessagesFilterEmpty : SearchMessagesFilter()

    /**
     * Returns only animation messages
     */
    class SearchMessagesFilterAnimation : SearchMessagesFilter()

    /**
     * Returns only audio messages
     */
    class SearchMessagesFilterAudio : SearchMessagesFilter()

    /**
     * Returns only document messages
     */
    class SearchMessagesFilterDocument : SearchMessagesFilter()

    /**
     * Returns only photo messages
     */
    class SearchMessagesFilterPhoto : SearchMessagesFilter()

    /**
     * Returns only video messages
     */
    class SearchMessagesFilterVideo : SearchMessagesFilter()

    /**
     * Returns only voice note messages
     */
    class SearchMessagesFilterVoiceNote : SearchMessagesFilter()

    /**
     * Returns only photo and video messages
     */
    class SearchMessagesFilterPhotoAndVideo : SearchMessagesFilter()

    /**
     * Returns only messages containing URLs
     */
    class SearchMessagesFilterUrl : SearchMessagesFilter()

    /**
     * Returns only messages containing chat photos
     */
    class SearchMessagesFilterChatPhoto : SearchMessagesFilter()

    /**
     * Returns only call messages
     */
    class SearchMessagesFilterCall : SearchMessagesFilter()

    /**
     * Returns only incoming call messages with missed/declined discard reasons
     */
    class SearchMessagesFilterMissedCall : SearchMessagesFilter()

    /**
     * Returns only video note messages
     */
    class SearchMessagesFilterVideoNote : SearchMessagesFilter()

    /**
     * Returns only voice and video note messages
     */
    class SearchMessagesFilterVoiceAndVideoNote : SearchMessagesFilter()

    /**
     * Returns only messages with mentions of the current user, or messages that are replies to their messages
     */
    class SearchMessagesFilterMention : SearchMessagesFilter()

    /**
     * Returns only messages with unread mentions of the current user, or messages that are replies to their messages
     * When using this filter the results can't be additionally filtered by a query or by the sending user
     */
    class SearchMessagesFilterUnreadMention : SearchMessagesFilter()

    /**
     * Describes the different types of activity in a chat
     */
    abstract class ChatAction : null()

    /**
     * The user is typing a message
     */
    class ChatActionTyping : ChatAction()

    /**
     * The user is recording a video
     */
    class ChatActionRecordingVideo : ChatAction()

    /**
     * The user is uploading a video
     *
     * @progress - Upload progress, as a percentage
     */
    class ChatActionUploadingVideo(
        val progress: Int = 0
    ) : ChatAction()

    /**
     * The user is recording a voice note
     */
    class ChatActionRecordingVoiceNote : ChatAction()

    /**
     * The user is uploading a voice note
     *
     * @progress - Upload progress, as a percentage
     */
    class ChatActionUploadingVoiceNote(
        val progress: Int = 0
    ) : ChatAction()

    /**
     * The user is uploading a photo
     *
     * @progress - Upload progress, as a percentage
     */
    class ChatActionUploadingPhoto(
        val progress: Int = 0
    ) : ChatAction()

    /**
     * The user is uploading a document
     *
     * @progress - Upload progress, as a percentage
     */
    class ChatActionUploadingDocument(
        val progress: Int = 0
    ) : ChatAction()

    /**
     * The user is picking a location or venue to send
     */
    class ChatActionChoosingLocation : ChatAction()

    /**
     * The user is picking a contact to send
     */
    class ChatActionChoosingContact : ChatAction()

    /**
     * The user has started to play a game
     */
    class ChatActionStartPlayingGame : ChatAction()

    /**
     * The user is recording a video note
     */
    class ChatActionRecordingVideoNote : ChatAction()

    /**
     * The user is uploading a video note
     *
     * @progress - Upload progress, as a percentage
     */
    class ChatActionUploadingVideoNote(
        val progress: Int = 0
    ) : ChatAction()

    /**
     * The user has cancelled the previous action
     */
    class ChatActionCancel : ChatAction()

    /**
     * Describes the last time the user was online
     */
    abstract class UserStatus : null()

    /**
     * The user status was never changed
     */
    class UserStatusEmpty : UserStatus()

    /**
     * The user is online
     *
     * @expires - Point in time (Unix timestamp) when the user's online status will expire
     */
    class UserStatusOnline(
        val expires: Int
    ) : UserStatus()

    /**
     * The user is offline
     *
     * @wasOnline - Point in time (Unix timestamp) when the user was last online
     */
    class UserStatusOffline(
        val wasOnline: Int
    ) : UserStatus()

    /**
     * The user was online recently
     */
    class UserStatusRecently : UserStatus()

    /**
     * The user is offline, but was online last week
     */
    class UserStatusLastWeek : UserStatus()

    /**
     * The user is offline, but was online last month
     */
    class UserStatusLastMonth : UserStatus()

    /**
     * Represents a list of stickers
     *
     * @stickers - List of stickers
     */
    class Stickers(
        val stickers: Array<Sticker>
    ) : Object()

    /**
     * Represents a list of emoji
     *
     * @emojis - List of emojis
     */
    class Emojis(
        val emojis: Array<String>
    ) : Object()

    /**
     * Represents a sticker set
     *
     * @id - Identifier of the sticker set
     * @title - Title of the sticker set
     * @name - Name of the sticker set
     * @thumbnail - Sticker set thumbnail in WEBP format with width and height 100
     *              The file can be downloaded only before the thumbnail is changed
     * @isInstalled - True, if the sticker set has been installed by the current user
     * @isArchived - True, if the sticker set has been archived
     *               A sticker set can't be installed and archived simultaneously
     * @isOfficial - True, if the sticker set is official
     * @isAnimated - True, is the stickers in the set are animated
     * @isMasks - True, if the stickers in the set are masks
     * @isViewed - True for already viewed trending sticker sets
     * @stickers - List of stickers in this set
     * @emojis - A list of emoji corresponding to the stickers in the same order
     *           The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
     */
    class StickerSet(
        val id: Long,
        val title: String,
        val name: String,
        val thumbnail: PhotoSize?,
        val isInstalled: Boolean,
        val isArchived: Boolean,
        val isOfficial: Boolean,
        val isAnimated: Boolean,
        val isMasks: Boolean,
        val isViewed: Boolean,
        val stickers: Array<Sticker>,
        val emojis: Array<Emojis>
    ) : Object()

    /**
     * Represents short information about a sticker set
     *
     * @id - Identifier of the sticker set
     * @title - Title of the sticker set
     * @name - Name of the sticker set
     * @thumbnail - Sticker set thumbnail in WEBP format with width and height 100
     * @isInstalled - True, if the sticker set has been installed by current user
     * @isArchived - True, if the sticker set has been archived
     *               A sticker set can't be installed and archived simultaneously
     * @isOfficial - True, if the sticker set is official
     * @isAnimated - True, is the stickers in the set are animated
     * @isMasks - True, if the stickers in the set are masks
     * @isViewed - True for already viewed trending sticker sets
     * @size - Total number of stickers in the set
     * @covers - Contains up to the first 5 stickers from the set, depending on the context
     *           If the client needs more stickers the full set should be requested
     */
    class StickerSetInfo(
        val id: Long,
        val title: String,
        val name: String,
        val thumbnail: PhotoSize?,
        val isInstalled: Boolean,
        val isArchived: Boolean,
        val isOfficial: Boolean,
        val isAnimated: Boolean,
        val isMasks: Boolean,
        val isViewed: Boolean,
        val size: Int,
        val covers: Array<Sticker>
    ) : Object()

    /**
     * Represents a list of sticker sets
     *
     * @totalCount - Approximate total number of sticker sets found
     * @sets - List of sticker sets
     */
    class StickerSets(
        val totalCount: Int,
        val sets: Array<StickerSetInfo>
    ) : Object()

    /**
     * Describes the reason why a call was discarded
     */
    abstract class CallDiscardReason : null()

    /**
     * The call wasn't discarded, or the reason is unknown
     */
    class CallDiscardReasonEmpty : CallDiscardReason()

    /**
     * The call was ended before the conversation started
     * It was cancelled by the caller or missed by the other party
     */
    class CallDiscardReasonMissed : CallDiscardReason()

    /**
     * The call was ended before the conversation started
     * It was declined by the other party
     */
    class CallDiscardReasonDeclined : CallDiscardReason()

    /**
     * The call was ended during the conversation because the users were disconnected
     */
    class CallDiscardReasonDisconnected : CallDiscardReason()

    /**
     * The call was ended because one of the parties hung up
     */
    class CallDiscardReasonHungUp : CallDiscardReason()

    /**
     * Specifies the supported call protocols
     *
     * @udpP2p - True, if UDP peer-to-peer connections are supported
     * @udpReflector - True, if connection through UDP reflectors is supported
     * @minLayer - Minimum supported API layer
     * @maxLayer - Maximum supported API layer
     */
    class CallProtocol(
        val udpP2p: Boolean = false,
        val udpReflector: Boolean = false,
        val minLayer: Int = 0,
        val maxLayer: Int = 0
    ) : Object()

    /**
     * Describes the address of UDP reflectors
     *
     * @id - Reflector identifier
     * @ip - IPv4 reflector address
     * @ipv6 - IPv6 reflector address
     * @port - Reflector port number
     * @peerTag - Connection peer tag
     */
    class CallConnection(
        val id: Long,
        val ip: String,
        val ipv6: String,
        val port: Int,
        val peerTag: ByteArray
    ) : Object()

    /**
     * Contains the call identifier
     *
     * @id - Call identifier
     */
    class CallId(
        val id: Int
    ) : Object()

    /**
     * Describes the current call state
     */
    abstract class CallState : null()

    /**
     * The call is pending, waiting to be accepted by a user
     *
     * @isCreated - True, if the call has already been created by the server
     * @isReceived - True, if the call has already been received by the other party
     */
    class CallStatePending(
        val isCreated: Boolean,
        val isReceived: Boolean
    ) : CallState()

    /**
     * The call has been answered and encryption keys are being exchanged
     */
    class CallStateExchangingKeys : CallState()

    /**
     * The call is ready to use
     *
     * @protocol - Call protocols supported by the peer
     * @connections - Available UDP reflectors
     * @config - A JSON-encoded call config
     * @encryptionKey - Call encryption key
     * @emojis - Encryption key emojis fingerprint
     * @allowP2p - True, if peer-to-peer connection is allowed by users privacy settings
     */
    class CallStateReady(
        val protocol: CallProtocol,
        val connections: Array<CallConnection>,
        val config: String,
        val encryptionKey: ByteArray,
        val emojis: Array<String>,
        val allowP2p: Boolean
    ) : CallState()

    /**
     * The call is hanging up after discardCall has been called
     */
    class CallStateHangingUp : CallState()

    /**
     * The call has ended successfully
     *
     * @reason - The reason, why the call has ended
     * @needRating - True, if the call rating should be sent to the server
     * @needDebugInformation - True, if the call debug information should be sent to the server
     */
    class CallStateDiscarded(
        val reason: CallDiscardReason,
        val needRating: Boolean,
        val needDebugInformation: Boolean
    ) : CallState()

    /**
     * The call has ended with an error
     *
     * @error - Error
     *          An error with the code 4005000 will be returned if an outgoing call is missed because of an expired timeout
     */
    class CallStateError(
        val error: Error
    ) : CallState()

    /**
     * Describes the exact type of a problem with a call
     */
    abstract class CallProblem : null()

    /**
     * The user heard their own voice
     */
    class CallProblemEcho : CallProblem()

    /**
     * The user heard background noise
     */
    class CallProblemNoise : CallProblem()

    /**
     * The other side kept disappearing
     */
    class CallProblemInterruptions : CallProblem()

    /**
     * The speech was distorted
     */
    class CallProblemDistortedSpeech : CallProblem()

    /**
     * The user couldn't hear the other side
     */
    class CallProblemSilentLocal : CallProblem()

    /**
     * The other side couldn't hear the user
     */
    class CallProblemSilentRemote : CallProblem()

    /**
     * The call ended unexpectedly
     */
    class CallProblemDropped : CallProblem()

    /**
     * Describes a call
     *
     * @id - Call identifier, not persistent
     * @userId - Peer user identifier
     * @isOutgoing - True, if the call is outgoing
     * @state - Call state
     */
    class Call(
        val id: Int,
        val userId: Int,
        val isOutgoing: Boolean,
        val state: CallState
    ) : Object()

    /**
     * Contains settings for the authentication of the user's phone number
     *
     * @allowFlashCall - Pass true if the authentication code may be sent via flash call to the specified phone number
     * @isCurrentPhoneNumber - Pass true if the authenticated phone number is used on the current device
     * @allowSmsRetrieverApi - For official applications only
     *                         True, if the app can use Android SMS Retriever API (requires Google Play Services >= 10.2) to automatically receive the authentication code from the SMS
     *                         See https://developers.google.com/identity/sms-retriever/ for more details
     */
    class PhoneNumberAuthenticationSettings(
        val allowFlashCall: Boolean = false,
        val isCurrentPhoneNumber: Boolean = false,
        val allowSmsRetrieverApi: Boolean = false
    ) : Object()

    /**
     * Represents a list of animations
     *
     * @animations - List of animations
     */
    class Animations(
        val animations: Array<Animation>
    ) : Object()

    /**
     * Represents the result of an ImportContacts request
     *
     * @userIds - User identifiers of the imported contacts in the same order as they were specified in the request
     *            0 if the contact is not yet a registered user
     * @importerCount - The number of users that imported the corresponding contact
     *                  0 for already registered users or if unavailable
     */
    class ImportedContacts(
        val userIds: IntArray,
        val importerCount: IntArray
    ) : Object()

    /**
     * Contains an HTTP URL
     *
     * @url - The URL
     */
    class HttpUrl(
        val url: String
    ) : Object()

    /**
     * Represents a single result of an inline query
     */
    @BotsOnly
    abstract class InputInlineQueryResult : null()

    /**
     * Represents a link to an animated GIF
     *
     * @id - Unique identifier of the query result
     * @title - Title of the query result
     * @thumbnailUrl - URL of the static result thumbnail (JPEG or GIF), if it exists
     * @gifUrl - The URL of the GIF-file (file size must not exceed 1MB)
     * @gifDuration - Duration of the GIF, in seconds
     * @gifWidth - Width of the GIF
     * @gifHeight - Height of the GIF
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageAnimation, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultAnimatedGif(
        val id: String,
        val title: String,
        val thumbnailUrl: String,
        val gifUrl: String,
        val gifDuration: Int = 0,
        val gifWidth: Int = 0,
        val gifHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an animated (i.e
     * Without sound) H.264/MPEG-4 AVC video
     *
     * @id - Unique identifier of the query result
     * @title - Title of the result
     * @thumbnailUrl - URL of the static result thumbnail (JPEG or GIF), if it exists
     * @mpeg4Url - The URL of the MPEG4-file (file size must not exceed 1MB)
     * @mpeg4Duration - Duration of the video, in seconds
     * @mpeg4Width - Width of the video
     * @mpeg4Height - Height of the video
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageAnimation, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultAnimatedMpeg4(
        val id: String,
        val title: String,
        val thumbnailUrl: String,
        val mpeg4Url: String,
        val mpeg4Duration: Int = 0,
        val mpeg4Width: Int = 0,
        val mpeg4Height: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an article or web page
     *
     * @id - Unique identifier of the query result
     * @url - URL of the result, if it exists
     * @hideUrl - True, if the URL must be not shown
     * @title - Title of the result
     * @description - A short description of the result
     * @thumbnailUrl - URL of the result thumbnail, if it exists
     * @thumbnailWidth - Thumbnail width, if known
     * @thumbnailHeight - Thumbnail height, if known
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultArticle(
        val id: String,
        val url: String,
        val hideUrl: Boolean = false,
        val title: String,
        val description: String,
        val thumbnailUrl: String,
        val thumbnailWidth: Int = 0,
        val thumbnailHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an MP3 audio file
     *
     * @id - Unique identifier of the query result
     * @title - Title of the audio file
     * @performer - Performer of the audio file
     * @audioUrl - The URL of the audio file
     * @audioDuration - Audio file duration, in seconds
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageAudio, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultAudio(
        val id: String,
        val title: String,
        val performer: String,
        val audioUrl: String,
        val audioDuration: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a user contact
     *
     * @id - Unique identifier of the query result
     * @contact - User contact
     * @thumbnailUrl - URL of the result thumbnail, if it exists
     * @thumbnailWidth - Thumbnail width, if known
     * @thumbnailHeight - Thumbnail height, if known
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultContact(
        val id: String,
        val contact: Contact,
        val thumbnailUrl: String,
        val thumbnailWidth: Int = 0,
        val thumbnailHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to a file
     *
     * @id - Unique identifier of the query result
     * @title - Title of the resulting file
     * @description - Short description of the result, if known
     * @documentUrl - URL of the file
     * @mimeType - MIME type of the file content
     *             Only "application/pdf" and "application/zip" are currently allowed
     * @thumbnailUrl - The URL of the file thumbnail, if it exists
     * @thumbnailWidth - Width of the thumbnail
     * @thumbnailHeight - Height of the thumbnail
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageDocument, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultDocument(
        val id: String,
        val title: String,
        val description: String,
        val documentUrl: String,
        val mimeType: String,
        val thumbnailUrl: String,
        val thumbnailWidth: Int = 0,
        val thumbnailHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a game
     *
     * @id - Unique identifier of the query result
     * @gameShortName - Short name of the game
     * @replyMarkup - Message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     */
    class InputInlineQueryResultGame(
        val id: String,
        val gameShortName: String,
        val replyMarkup: ReplyMarkup
    ) : InputInlineQueryResult()

    /**
     * Represents a point on the map
     *
     * @id - Unique identifier of the query result
     * @location - Location result
     * @livePeriod - Amount of time relative to the message sent time until the location can be updated, in seconds
     * @title - Title of the result
     * @thumbnailUrl - URL of the result thumbnail, if it exists
     * @thumbnailWidth - Thumbnail width, if known
     * @thumbnailHeight - Thumbnail height, if known
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultLocation(
        val id: String,
        val location: Location,
        val livePeriod: Int = 0,
        val title: String,
        val thumbnailUrl: String,
        val thumbnailWidth: Int = 0,
        val thumbnailHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents link to a JPEG image
     *
     * @id - Unique identifier of the query result
     * @title - Title of the result, if known
     * @description - A short description of the result, if known
     * @thumbnailUrl - URL of the photo thumbnail, if it exists
     * @photoUrl - The URL of the JPEG photo (photo size must not exceed 5MB)
     * @photoWidth - Width of the photo
     * @photoHeight - Height of the photo
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessagePhoto, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultPhoto(
        val id: String,
        val title: String,
        val description: String,
        val thumbnailUrl: String,
        val photoUrl: String,
        val photoWidth: Int = 0,
        val photoHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to a WEBP or a TGS sticker
     *
     * @id - Unique identifier of the query result
     * @thumbnailUrl - URL of the sticker thumbnail, if it exists
     * @stickerUrl - The URL of the WEBP or a TGS sticker (sticker file size must not exceed 5MB)
     * @stickerWidth - Width of the sticker
     * @stickerHeight - Height of the sticker
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, inputMessageSticker, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultSticker(
        val id: String,
        val thumbnailUrl: String,
        val stickerUrl: String,
        val stickerWidth: Int = 0,
        val stickerHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents information about a venue
     *
     * @id - Unique identifier of the query result
     * @venue - Venue result
     * @thumbnailUrl - URL of the result thumbnail, if it exists
     * @thumbnailWidth - Thumbnail width, if known
     * @thumbnailHeight - Thumbnail height, if known
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultVenue(
        val id: String,
        val venue: Venue,
        val thumbnailUrl: String,
        val thumbnailWidth: Int = 0,
        val thumbnailHeight: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to a page containing an embedded video player or a video file
     *
     * @id - Unique identifier of the query result
     * @title - Title of the result
     * @description - A short description of the result, if known
     * @thumbnailUrl - The URL of the video thumbnail (JPEG), if it exists
     * @videoUrl - URL of the embedded video player or video file
     * @mimeType - MIME type of the content of the video URL, only "text/html" or "video/mp4" are currently supported
     * @videoWidth - Width of the video
     * @videoHeight - Height of the video
     * @videoDuration - Video duration, in seconds
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageVideo, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultVideo(
        val id: String,
        val title: String,
        val description: String,
        val thumbnailUrl: String,
        val videoUrl: String,
        val mimeType: String,
        val videoWidth: Int = 0,
        val videoHeight: Int = 0,
        val videoDuration: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a link to an opus-encoded audio file within an OGG container, single channel audio
     *
     * @id - Unique identifier of the query result
     * @title - Title of the voice note
     * @voiceNoteUrl - The URL of the voice note file
     * @voiceNoteDuration - Duration of the voice note, in seconds
     * @replyMarkup - The message reply markup
     *                Must be of type replyMarkupInlineKeyboard or null
     * @inputMessageContent - The content of the message to be sent
     *                        Must be one of the following types: InputMessageText, InputMessageVoiceNote, InputMessageLocation, InputMessageVenue or InputMessageContact
     */
    class InputInlineQueryResultVoiceNote(
        val id: String,
        val title: String,
        val voiceNoteUrl: String,
        val voiceNoteDuration: Int = 0,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    /**
     * Represents a single result of an inline query
     */
    abstract class InlineQueryResult : null()

    /**
     * Represents a link to an article or web page
     *
     * @id - Unique identifier of the query result
     * @url - URL of the result, if it exists
     * @hideUrl - True, if the URL must be not shown
     * @title - Title of the result
     * @description - A short description of the result
     * @thumbnail - Result thumbnail
     */
    class InlineQueryResultArticle(
        val id: String,
        val url: String,
        val hideUrl: Boolean,
        val title: String,
        val description: String,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents a user contact
     *
     * @id - Unique identifier of the query result
     * @contact - A user contact
     * @thumbnail - Result thumbnail
     */
    class InlineQueryResultContact(
        val id: String,
        val contact: Contact,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents a point on the map
     *
     * @id - Unique identifier of the query result
     * @location - Location result
     * @title - Title of the result
     * @thumbnail - Result thumbnail
     */
    class InlineQueryResultLocation(
        val id: String,
        val location: Location,
        val title: String,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents information about a venue
     *
     * @id - Unique identifier of the query result
     * @venue - Venue result
     * @thumbnail - Result thumbnail
     */
    class InlineQueryResultVenue(
        val id: String,
        val venue: Venue,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    /**
     * Represents information about a game
     *
     * @id - Unique identifier of the query result
     * @game - Game result
     */
    class InlineQueryResultGame(
        val id: String,
        val game: Game
    ) : InlineQueryResult()

    /**
     * Represents an animation file
     *
     * @id - Unique identifier of the query result
     * @animation - Animation file
     * @title - Animation title
     */
    class InlineQueryResultAnimation(
        val id: String,
        val animation: Animation,
        val title: String
    ) : InlineQueryResult()

    /**
     * Represents an audio file
     *
     * @id - Unique identifier of the query result
     * @audio - Audio file
     */
    class InlineQueryResultAudio(
        val id: String,
        val audio: Audio
    ) : InlineQueryResult()

    /**
     * Represents a document
     *
     * @id - Unique identifier of the query result
     * @document - Document
     * @title - Document title
     * @description - Document description
     */
    class InlineQueryResultDocument(
        val id: String,
        val document: Document,
        val title: String,
        val description: String
    ) : InlineQueryResult()

    /**
     * Represents a photo
     *
     * @id - Unique identifier of the query result
     * @photo - Photo
     * @title - Title of the result, if known
     * @description - A short description of the result, if known
     */
    class InlineQueryResultPhoto(
        val id: String,
        val photo: Photo,
        val title: String,
        val description: String
    ) : InlineQueryResult()

    /**
     * Represents a sticker
     *
     * @id - Unique identifier of the query result
     * @sticker - Sticker
     */
    class InlineQueryResultSticker(
        val id: String,
        val sticker: Sticker
    ) : InlineQueryResult()

    /**
     * Represents a video
     *
     * @id - Unique identifier of the query result
     * @video - Video
     * @title - Title of the video
     * @description - Description of the video
     */
    class InlineQueryResultVideo(
        val id: String,
        val video: Video,
        val title: String,
        val description: String
    ) : InlineQueryResult()

    /**
     * Represents a voice note
     *
     * @id - Unique identifier of the query result
     * @voiceNote - Voice note
     * @title - Title of the voice note
     */
    class InlineQueryResultVoiceNote(
        val id: String,
        val voiceNote: VoiceNote,
        val title: String
    ) : InlineQueryResult()

    /**
     * Represents the results of the inline query
     * Use sendInlineQueryResultMessage to send the result of the query
     *
     * @inlineQueryId - Unique identifier of the inline query
     * @nextOffset - The offset for the next request
     *               If empty, there are no more results
     * @results - Results of the query
     * @switchPmText - If non-empty, this text should be shown on the button, which opens a private chat with the bot and sends the bot a start message with the switch_pm_parameter
     * @switchPmParameter - Parameter for the bot start message
     */
    class InlineQueryResults(
        val inlineQueryId: Long,
        val nextOffset: String,
        val results: Array<InlineQueryResult>,
        val switchPmText: String,
        val switchPmParameter: String
    ) : Object()

    /**
     * Represents a payload of a callback query
     */
    abstract class CallbackQueryPayload : null()

    /**
     * The payload from a general callback button
     *
     * @data - Data that was attached to the callback button
     */
    class CallbackQueryPayloadData(
        val data: ByteArray = byteArrayOf()
    ) : CallbackQueryPayload()

    /**
     * The payload from a game callback button
     *
     * @gameShortName - A short name of the game that was attached to the callback button
     */
    class CallbackQueryPayloadGame(
        val gameShortName: String
    ) : CallbackQueryPayload()

    /**
     * Contains a bot's answer to a callback query
     *
     * @text - Text of the answer
     * @showAlert - True, if an alert should be shown to the user instead of a toast notification
     * @url - URL to be opened
     */
    class CallbackQueryAnswer(
        val text: String,
        val showAlert: Boolean,
        val url: String
    ) : Object()

    /**
     * Contains the result of a custom request
     *
     * @result - A JSON-serialized result
     */
    class CustomRequestResult(
        val result: String
    ) : Object()

    /**
     * Contains one row of the game high score table
     *
     * @position - Position in the high score table
     * @userId - User identifier
     * @score - User score
     */
    class GameHighScore(
        val position: Int,
        val userId: Int,
        val score: Int
    ) : Object()

    /**
     * Contains a list of game high scores
     *
     * @scores - A list of game high scores
     */
    class GameHighScores(
        val scores: Array<GameHighScore>
    ) : Object()

    /**
     * Represents a chat event
     */
    abstract class ChatEventAction : null()

    /**
     * A message was edited
     *
     * @oldMessage - The original message before the edit
     * @newMessage - The message after it was edited
     */
    class ChatEventMessageEdited(
        val oldMessage: Message,
        val newMessage: Message
    ) : ChatEventAction()

    /**
     * A message was deleted
     *
     * @message - Deleted message
     */
    class ChatEventMessageDeleted(
        val message: Message
    ) : ChatEventAction()

    /**
     * A poll in a message was stopped
     *
     * @message - The message with the poll
     */
    class ChatEventPollStopped(
        val message: Message
    ) : ChatEventAction()

    /**
     * A message was pinned
     *
     * @message - Pinned message
     */
    class ChatEventMessagePinned(
        val message: Message
    ) : ChatEventAction()

    /**
     * A message was unpinned
     */
    class ChatEventMessageUnpinned : ChatEventAction()

    /**
     * A new member joined the chat
     */
    class ChatEventMemberJoined : ChatEventAction()

    /**
     * A member left the chat
     */
    class ChatEventMemberLeft : ChatEventAction()

    /**
     * A new chat member was invited
     *
     * @userId - New member user identifier
     * @status - New member status
     */
    class ChatEventMemberInvited(
        val userId: Int,
        val status: ChatMemberStatus
    ) : ChatEventAction()

    /**
     * A chat member has gained/lost administrator status, or the list of their administrator privileges has changed
     *
     * @userId - Chat member user identifier
     * @oldStatus - Previous status of the chat member
     * @newStatus - New status of the chat member
     */
    class ChatEventMemberPromoted(
        val userId: Int,
        val oldStatus: ChatMemberStatus,
        val newStatus: ChatMemberStatus
    ) : ChatEventAction()

    /**
     * A chat member was restricted/unrestricted or banned/unbanned, or the list of their restrictions has changed
     *
     * @userId - Chat member user identifier
     * @oldStatus - Previous status of the chat member
     * @newStatus - New status of the chat member
     */
    class ChatEventMemberRestricted(
        val userId: Int,
        val oldStatus: ChatMemberStatus,
        val newStatus: ChatMemberStatus
    ) : ChatEventAction()

    /**
     * The chat title was changed
     *
     * @oldTitle - Previous chat title
     * @newTitle - New chat title
     */
    class ChatEventTitleChanged(
        val oldTitle: String,
        val newTitle: String
    ) : ChatEventAction()

    /**
     * The chat permissions was changed
     *
     * @oldPermissions - Previous chat permissions
     * @newPermissions - New chat permissions
     */
    class ChatEventPermissionsChanged(
        val oldPermissions: ChatPermissions,
        val newPermissions: ChatPermissions
    ) : ChatEventAction()

    /**
     * The chat description was changed
     *
     * @oldDescription - Previous chat description
     * @newDescription - New chat description
     */
    class ChatEventDescriptionChanged(
        val oldDescription: String,
        val newDescription: String
    ) : ChatEventAction()

    /**
     * The chat username was changed
     *
     * @oldUsername - Previous chat username
     * @newUsername - New chat username
     */
    class ChatEventUsernameChanged(
        val oldUsername: String,
        val newUsername: String
    ) : ChatEventAction()

    /**
     * The chat photo was changed
     *
     * @oldPhoto - Previous chat photo value
     * @newPhoto - New chat photo value
     */
    class ChatEventPhotoChanged(
        val oldPhoto: Photo?,
        val newPhoto: Photo?
    ) : ChatEventAction()

    /**
     * The can_invite_users permission of a supergroup chat was toggled
     *
     * @canInviteUsers - New value of can_invite_users permission
     */
    class ChatEventInvitesToggled(
        val canInviteUsers: Boolean
    ) : ChatEventAction()

    /**
     * The sign_messages setting of a channel was toggled
     *
     * @signMessages - New value of sign_messages
     */
    class ChatEventSignMessagesToggled(
        val signMessages: Boolean
    ) : ChatEventAction()

    /**
     * The supergroup sticker set was changed
     *
     * @oldStickerSetId - Previous identifier of the chat sticker set
     *                    0 if none
     * @newStickerSetId - New identifier of the chat sticker set
     *                    0 if none
     */
    class ChatEventStickerSetChanged(
        val oldStickerSetId: Long,
        val newStickerSetId: Long
    ) : ChatEventAction()

    /**
     * The is_all_history_available setting of a supergroup was toggled
     *
     * @isAllHistoryAvailable - New value of is_all_history_available
     */
    class ChatEventIsAllHistoryAvailableToggled(
        val isAllHistoryAvailable: Boolean
    ) : ChatEventAction()

    /**
     * Represents a chat event
     *
     * @id - Chat event identifier
     * @date - Point in time (Unix timestamp) when the event happened
     * @userId - Identifier of the user who performed the action that triggered the event
     * @action - Action performed by the user
     */
    class ChatEvent(
        val id: Long,
        val date: Int,
        val userId: Int,
        val action: ChatEventAction
    ) : Object()

    /**
     * Contains a list of chat events
     *
     * @events - List of events
     */
    class ChatEvents(
        val events: Array<ChatEvent>
    ) : Object()

    /**
     * Represents a set of filters used to obtain a chat event log
     *
     * @messageEdits - True, if message edits should be returned
     * @messageDeletions - True, if message deletions should be returned
     * @messagePins - True, if pin/unpin events should be returned
     * @memberJoins - True, if members joining events should be returned
     * @memberLeaves - True, if members leaving events should be returned
     * @memberInvites - True, if invited member events should be returned
     * @memberPromotions - True, if member promotion/demotion events should be returned
     * @memberRestrictions - True, if member restricted/unrestricted/banned/unbanned events should be returned
     * @infoChanges - True, if changes in chat information should be returned
     * @settingChanges - True, if changes in chat settings should be returned
     */
    class ChatEventLogFilters(
        val messageEdits: Boolean = false,
        val messageDeletions: Boolean = false,
        val messagePins: Boolean = false,
        val memberJoins: Boolean = false,
        val memberLeaves: Boolean = false,
        val memberInvites: Boolean = false,
        val memberPromotions: Boolean = false,
        val memberRestrictions: Boolean = false,
        val infoChanges: Boolean = false,
        val settingChanges: Boolean = false
    ) : Object()

    /**
     * Represents the value of a string in a language pack
     */
    abstract class LanguagePackStringValue : null()

    /**
     * An ordinary language pack string
     *
     * @value - String value
     */
    class LanguagePackStringValueOrdinary(
        val value: String
    ) : LanguagePackStringValue()

    /**
     * A language pack string which has different forms based on the number of some object it mentions
     * See https://www.unicode.org/cldr/charts/latest/supplemental/language_plural_rules.html for more info
     *
     * @zeroValue - Value for zero objects
     * @oneValue - Value for one object
     * @twoValue - Value for two objects
     * @fewValue - Value for few objects
     * @manyValue - Value for many objects
     * @otherValue - Default value
     */
    class LanguagePackStringValuePluralized(
        val zeroValue: String,
        val oneValue: String,
        val twoValue: String,
        val fewValue: String,
        val manyValue: String,
        val otherValue: String
    ) : LanguagePackStringValue()

    /**
     * A deleted language pack string, the value should be taken from the built-in english language pack
     */
    class LanguagePackStringValueDeleted : LanguagePackStringValue()

    /**
     * Represents one language pack string
     *
     * @key - String key
     * @value - String value
     */
    class LanguagePackString(
        val key: String,
        val value: LanguagePackStringValue
    ) : Object()

    /**
     * Contains a list of language pack strings
     *
     * @strings - A list of language pack strings
     */
    class LanguagePackStrings(
        val strings: Array<LanguagePackString>
    ) : Object()

    /**
     * Contains information about a language pack
     *
     * @id - Unique language pack identifier
     * @baseLanguagePackId - Identifier of a base language pack
     *                       If a string is missed in the language pack, then it should be fetched from base language pack
     *                       Unsupported in custom language packs
     * @name - Language name
     * @nativeName - Name of the language in that language
     * @pluralCode - A language code to be used to apply plural forms
     *               See https://www.unicode.org/cldr/charts/latest/supplemental/language_plural_rules.html for more info
     * @isOfficial - True, if the language pack is official
     * @isRtl - True, if the language pack strings are RTL
     * @isBeta - True, if the language pack is a beta language pack
     * @isInstalled - True, if the language pack is installed by the current user
     * @totalStringCount - Total number of non-deleted strings from the language pack
     * @translatedStringCount - Total number of translated strings from the language pack
     * @localStringCount - Total number of non-deleted strings from the language pack available locally
     * @translationUrl - Link to language translation interface
     *                   Empty for custom local language packs
     */
    class LanguagePackInfo(
        val id: String,
        val baseLanguagePackId: String? = null,
        val name: String,
        val nativeName: String,
        val pluralCode: String,
        val isOfficial: Boolean = false,
        val isRtl: Boolean = false,
        val isBeta: Boolean = false,
        val isInstalled: Boolean = false,
        val totalStringCount: Int = 0,
        val translatedStringCount: Int = 0,
        val localStringCount: Int = 0,
        val translationUrl: String
    ) : Object()

    /**
     * Contains information about the current localization target
     *
     * @languagePacks - List of available language packs for this application
     */
    class LocalizationTargetInfo(
        val languagePacks: Array<LanguagePackInfo>
    ) : Object()

    /**
     * Represents a data needed to subscribe for push notifications through registerDevice method
     * To use specific push notification service, you must specify the correct application platform and upload valid server authentication data at https://my.telegram.org
     */
    abstract class DeviceToken : null()

    /**
     * A token for Firebase Cloud Messaging
     *
     * @token - Device registration token
     *          May be empty to de-register a device
     * @encrypt - True, if push notifications should be additionally encrypted
     */
    class DeviceTokenFirebaseCloudMessaging(
        val token: String? = null,
        val encrypt: Boolean = false
    ) : DeviceToken()

    /**
     * A token for Apple Push Notification service
     *
     * @deviceToken - Device token
     *                May be empty to de-register a device
     * @isAppSandbox - True, if App Sandbox is enabled
     */
    class DeviceTokenApplePush(
        val deviceToken: String? = null,
        val isAppSandbox: Boolean = false
    ) : DeviceToken()

    /**
     * A token for Apple Push Notification service VoIP notifications
     *
     * @deviceToken - Device token
     *                May be empty to de-register a device
     * @isAppSandbox - True, if App Sandbox is enabled
     * @encrypt - True, if push notifications should be additionally encrypted
     */
    class DeviceTokenApplePushVoIP(
        val deviceToken: String? = null,
        val isAppSandbox: Boolean = false,
        val encrypt: Boolean = false
    ) : DeviceToken()

    /**
     * A token for Windows Push Notification Services
     *
     * @accessToken - The access token that will be used to send notifications
     *                May be empty to de-register a device
     */
    class DeviceTokenWindowsPush(
        val accessToken: String? = null
    ) : DeviceToken()

    /**
     * A token for Microsoft Push Notification Service
     *
     * @channelUri - Push notification channel URI
     *               May be empty to de-register a device
     */
    class DeviceTokenMicrosoftPush(
        val channelUri: String? = null
    ) : DeviceToken()

    /**
     * A token for Microsoft Push Notification Service VoIP channel
     *
     * @channelUri - Push notification channel URI
     *               May be empty to de-register a device
     */
    class DeviceTokenMicrosoftPushVoIP(
        val channelUri: String? = null
    ) : DeviceToken()

    /**
     * A token for web Push API
     *
     * @endpoint - Absolute URL exposed by the push service where the application server can send push messages
     *             May be empty to de-register a device
     * @p256dhBase64url - Base64url-encoded P-256 elliptic curve Diffie-Hellman public key
     * @authBase64url - Base64url-encoded authentication secret
     */
    class DeviceTokenWebPush(
        val endpoint: String? = null,
        val p256dhBase64url: String,
        val authBase64url: String
    ) : DeviceToken()

    /**
     * A token for Simple Push API for Firefox OS
     *
     * @endpoint - Absolute URL exposed by the push service where the application server can send push messages
     *             May be empty to de-register a device
     */
    class DeviceTokenSimplePush(
        val endpoint: String? = null
    ) : DeviceToken()

    /**
     * A token for Ubuntu Push Client service
     *
     * @token - Token
     *          May be empty to de-register a device
     */
    class DeviceTokenUbuntuPush(
        val token: String? = null
    ) : DeviceToken()

    /**
     * A token for BlackBerry Push Service
     *
     * @token - Token
     *          May be empty to de-register a device
     */
    class DeviceTokenBlackBerryPush(
        val token: String? = null
    ) : DeviceToken()

    /**
     * A token for Tizen Push Service
     *
     * @regId - Push service registration identifier
     *          May be empty to de-register a device
     */
    class DeviceTokenTizenPush(
        val regId: String? = null
    ) : DeviceToken()

    /**
     * Contains a globally unique push receiver identifier, which can be used to identify which account has received a push notification
     *
     * @id - The globally unique identifier of push notification subscription
     */
    class PushReceiverId(
        val id: Long
    ) : Object()

    /**
     * Describes a type of a background
     */
    abstract class BackgroundType : null()

    /**
     * A wallpaper in JPEG format
     *
     * @isBlurred - True, if the wallpaper must be downscaled to fit in 450x450 square and then box-blurred with radius 12
     * @isMoving - True, if the background needs to be slightly moved when device is rotated
     */
    class BackgroundTypeWallpaper(
        val isBlurred: Boolean = false,
        val isMoving: Boolean = false
    ) : BackgroundType()

    /**
     * A PNG pattern to be combined with the color chosen by the user
     *
     * @isMoving - True, if the background needs to be slightly moved when device is rotated
     * @color - Main color of the background in RGB24 format
     * @intensity - Intensity of the pattern when it is shown above the main background color, 0-100
     */
    class BackgroundTypePattern(
        val isMoving: Boolean = false,
        val color: Int = 0,
        val intensity: Int = 0
    ) : BackgroundType()

    /**
     * A solid background
     *
     * @color - A color of the background in RGB24 format
     */
    class BackgroundTypeSolid(
        val color: Int = 0
    ) : BackgroundType()

    /**
     * Describes a chat background
     *
     * @id - Unique background identifier
     * @isDefault - True, if this is one of default backgrounds
     * @isDark - True, if the background is dark and is recommended to be used with dark theme
     * @name - Unique background name
     * @document - Document with the background
     *             Null only for solid backgrounds
     * @type - Type of the background
     */
    class Background(
        val id: Long,
        val isDefault: Boolean,
        val isDark: Boolean,
        val name: String,
        val document: Document?,
        val type: BackgroundType
    ) : Object()

    /**
     * Contains a list of backgrounds
     *
     * @backgrounds - A list of backgrounds
     */
    class Backgrounds(
        val backgrounds: Array<Background>
    ) : Object()

    /**
     * Contains information about background to set
     */
    abstract class InputBackground : null()

    /**
     * A background from a local file
     *
     * @background - Background file to use
     *               Only inputFileLocal and inputFileGenerated are supported
     *               The file nust be in JPEG format for wallpapers and in PNG format for patterns
     */
    class InputBackgroundLocal(
        val background: InputFile
    ) : InputBackground()

    /**
     * A background from the server
     *
     * @backgroundId - The background identifier
     */
    class InputBackgroundRemote(
        val backgroundId: Long = 0L
    ) : InputBackground()

    /**
     * Contains a list of hashtags
     *
     * @hashtags - A list of hashtags
     */
    class Hashtags(
        val hashtags: Array<String>
    ) : Object()

    /**
     * Represents result of checking whether a username can be set for a chat
     */
    abstract class CheckChatUsernameResult : null()

    /**
     * The username can be set
     */
    class CheckChatUsernameResultOk : CheckChatUsernameResult()

    /**
     * The username is invalid
     */
    class CheckChatUsernameResultUsernameInvalid : CheckChatUsernameResult()

    /**
     * The username is occupied
     */
    class CheckChatUsernameResultUsernameOccupied : CheckChatUsernameResult()

    /**
     * The user has too much chats with username, one of them should be made private first
     */
    class CheckChatUsernameResultPublicChatsTooMuch : CheckChatUsernameResult()

    /**
     * The user can't be a member of a public supergroup
     */
    class CheckChatUsernameResultPublicGroupsUnavailable : CheckChatUsernameResult()

    /**
     * Contains content of a push message notification
     */
    abstract class PushMessageContent : null()

    /**
     * A general message with hidden content
     *
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentHidden(
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * An animation message (GIF-style).
     *
     * @animation - Message content
     * @caption - Animation caption
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentAnimation(
        val animation: Animation?,
        val caption: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * An audio message
     *
     * @audio - Message content
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentAudio(
        val audio: Audio?,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a user contact
     *
     * @name - Contact's name
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentContact(
        val name: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A contact has registered with Telegram
     */
    class PushMessageContentContactRegistered : PushMessageContent()

    /**
     * A document message (a general file)
     *
     * @document - Message content
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentDocument(
        val document: Document?,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a game
     *
     * @title - Game title, empty for pinned game message
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentGame(
        val title: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A new high score was achieved in a game
     *
     * @title - Game title, empty for pinned message
     * @score - New score, 0 for pinned message
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentGameScore(
        val title: String,
        val score: Int,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with an invoice from a bot
     *
     * @price - Product price
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentInvoice(
        val price: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a location
     *
     * @isLive - True, if the location is live
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentLocation(
        val isLive: Boolean,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A photo message
     *
     * @photo - Message content
     * @caption - Photo caption
     * @isSecret - True, if the photo is secret
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentPhoto(
        val photo: Photo?,
        val caption: String,
        val isSecret: Boolean,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A message with a poll
     *
     * @question - Poll question
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentPoll(
        val question: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A screenshot of a message in the chat has been taken
     */
    class PushMessageContentScreenshotTaken : PushMessageContent()

    /**
     * A message with a sticker
     *
     * @sticker - Message content
     * @emoji - Emoji corresponding to the sticker
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentSticker(
        val sticker: Sticker?,
        val emoji: String?,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A text message
     *
     * @text - Message text
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentText(
        val text: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A video message
     *
     * @video - Message content
     * @caption - Video caption
     * @isSecret - True, if the video is secret
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentVideo(
        val video: Video?,
        val caption: String,
        val isSecret: Boolean,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A video note message
     *
     * @videoNote - Message content
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentVideoNote(
        val videoNote: VideoNote?,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A voice note message
     *
     * @voiceNote - Message content
     * @isPinned - True, if the message is a pinned message with the specified content
     */
    class PushMessageContentVoiceNote(
        val voiceNote: VoiceNote?,
        val isPinned: Boolean
    ) : PushMessageContent()

    /**
     * A newly created basic group
     */
    class PushMessageContentBasicGroupChatCreate : PushMessageContent()

    /**
     * New chat members were invited to a group
     *
     * @memberName - Name of the added member
     * @isCurrentUser - True, if the current user was added to the group
     * @isReturned - True, if the user has returned to the group himself
     */
    class PushMessageContentChatAddMembers(
        val memberName: String,
        val isCurrentUser: Boolean,
        val isReturned: Boolean
    ) : PushMessageContent()

    /**
     * A chat photo was edited
     */
    class PushMessageContentChatChangePhoto : PushMessageContent()

    /**
     * A chat title was edited
     *
     * @title - New chat title
     */
    class PushMessageContentChatChangeTitle(
        val title: String
    ) : PushMessageContent()

    /**
     * A chat member was deleted
     *
     * @memberName - Name of the deleted member
     * @isCurrentUser - True, if the current user was deleted from the group
     * @isLeft - True, if the user has left the group himself
     */
    class PushMessageContentChatDeleteMember(
        val memberName: String,
        val isCurrentUser: Boolean,
        val isLeft: Boolean
    ) : PushMessageContent()

    /**
     * A new member joined the chat by invite link
     */
    class PushMessageContentChatJoinByLink : PushMessageContent()

    /**
     * A forwarded messages
     *
     * @totalCount - Number of forwarded messages
     */
    class PushMessageContentMessageForwards(
        val totalCount: Int
    ) : PushMessageContent()

    /**
     * A media album
     *
     * @totalCount - Number of messages in the album
     * @hasPhotos - True, if the album has at least one photo
     * @hasVideos - True, if the album has at least one video
     */
    class PushMessageContentMediaAlbum(
        val totalCount: Int,
        val hasPhotos: Boolean,
        val hasVideos: Boolean
    ) : PushMessageContent()

    /**
     * Contains detailed information about a notification
     */
    abstract class NotificationType : null()

    /**
     * New message was received
     *
     * @message - The message
     */
    class NotificationTypeNewMessage(
        val message: Message
    ) : NotificationType()

    /**
     * New secret chat was created
     */
    class NotificationTypeNewSecretChat : NotificationType()

    /**
     * New call was received
     *
     * @callId - Call identifier
     */
    class NotificationTypeNewCall(
        val callId: Int
    ) : NotificationType()

    /**
     * New message was received through a push notification
     *
     * @messageId - The message identifier
     *              The message will not be available in the chat history, but the ID can be used in viewMessages and as reply_to_message_id
     * @senderUserId - Sender of the message
     *                 Corresponding user may be inaccessible
     * @content - Push message content
     */
    class NotificationTypeNewPushMessage(
        val messageId: Long,
        val senderUserId: Int,
        val content: PushMessageContent
    ) : NotificationType()

    /**
     * Describes type of notifications in the group
     */
    abstract class NotificationGroupType : null()

    /**
     * A group containing notifications of type notificationTypeNewMessage and notificationTypeNewPushMessage with ordinary unread messages
     */
    class NotificationGroupTypeMessages : NotificationGroupType()

    /**
     * A group containing notifications of type notificationTypeNewMessage and notificationTypeNewPushMessage with unread mentions of the current user, replies to their messages, or a pinned message
     */
    class NotificationGroupTypeMentions : NotificationGroupType()

    /**
     * A group containing a notification of type notificationTypeNewSecretChat
     */
    class NotificationGroupTypeSecretChat : NotificationGroupType()

    /**
     * A group containing notifications of type notificationTypeNewCall
     */
    class NotificationGroupTypeCalls : NotificationGroupType()

    /**
     * Contains information about a notification
     *
     * @id - Unique persistent identifier of this notification
     * @date - Notification date
     * @type - Notification type
     */
    class Notification(
        val id: Int,
        val date: Int,
        val type: NotificationType
    ) : Object()

    /**
     * Describes a group of notifications
     *
     * @id - Unique persistent auto-incremented from 1 identifier of the notification group
     * @type - Type of the group
     * @chatId - Identifier of a chat to which all notifications in the group belong
     * @totalCount - Total number of active notifications in the group
     * @notifications - The list of active notifications
     */
    class NotificationGroup(
        val id: Int,
        val type: NotificationGroupType,
        val chatId: Long,
        val totalCount: Int,
        val notifications: Array<Notification>
    ) : Object()

    /**
     * Represents the value of an option
     */
    abstract class OptionValue : null()

    /**
     * Represents a boolean option
     *
     * @value - The value of the option
     */
    class OptionValueBoolean(
        val value: Boolean = false
    ) : OptionValue()

    /**
     * Represents an unknown option or an option which has a default value
     */
    class OptionValueEmpty : OptionValue()

    /**
     * Represents an integer option
     *
     * @value - The value of the option
     */
    class OptionValueInteger(
        val value: Int = 0
    ) : OptionValue()

    /**
     * Represents a string option
     *
     * @value - The value of the option
     */
    class OptionValueString(
        val value: String
    ) : OptionValue()

    /**
     * Represents one member of a JSON object
     *
     * @key - Member's key
     * @value - Member's value
     */
    class JsonObjectMember(
        val key: String,
        val value: JsonValue
    ) : Object()

    /**
     * Represents a JSON value
     */
    abstract class JsonValue : null()

    /**
     * Represents a null JSON value
     */
    class JsonValueNull : JsonValue()

    /**
     * Represents a boolean JSON value
     *
     * @value - The value
     */
    class JsonValueBoolean(
        val value: Boolean = false
    ) : JsonValue()

    /**
     * Represents a numeric JSON value
     *
     * @value - The value
     */
    class JsonValueNumber(
        val value: Double = 0.0
    ) : JsonValue()

    /**
     * Represents a string JSON value
     *
     * @value - The value
     */
    class JsonValueString(
        val value: String
    ) : JsonValue()

    /**
     * Represents a JSON array
     *
     * @values - The list of array elements
     */
    class JsonValueArray(
        val values: Array<JsonValue> = emptyArray()
    ) : JsonValue()

    /**
     * Represents a JSON object
     *
     * @members - The list of object members
     */
    class JsonValueObject(
        val members: Array<JsonObjectMember> = emptyArray()
    ) : JsonValue()

    /**
     * Represents a single rule for managing privacy settings
     */
    abstract class UserPrivacySettingRule : null()

    /**
     * A rule to allow all users to do something
     */
    class UserPrivacySettingRuleAllowAll : UserPrivacySettingRule()

    /**
     * A rule to allow all of a user's contacts to do something
     */
    class UserPrivacySettingRuleAllowContacts : UserPrivacySettingRule()

    /**
     * A rule to allow certain specified users to do something
     *
     * @userIds - The user identifiers
     */
    class UserPrivacySettingRuleAllowUsers(
        val userIds: IntArray = intArrayOf()
    ) : UserPrivacySettingRule()

    /**
     * A rule to restrict all users from doing something
     */
    class UserPrivacySettingRuleRestrictAll : UserPrivacySettingRule()

    /**
     * A rule to restrict all contacts of a user from doing something
     */
    class UserPrivacySettingRuleRestrictContacts : UserPrivacySettingRule()

    /**
     * A rule to restrict all specified users from doing something
     *
     * @userIds - The user identifiers
     */
    class UserPrivacySettingRuleRestrictUsers(
        val userIds: IntArray = intArrayOf()
    ) : UserPrivacySettingRule()

    /**
     * A list of privacy rules
     * Rules are matched in the specified order
     * The first matched rule defines the privacy setting for a given user
     * If no rule matches, the action is not allowed
     *
     * @rules - A list of rules
     */
    class UserPrivacySettingRules(
        val rules: Array<UserPrivacySettingRule> = emptyArray()
    ) : Object()

    /**
     * Describes available user privacy settings
     */
    abstract class UserPrivacySetting : null()

    /**
     * A privacy setting for managing whether the user's online status is visible
     */
    class UserPrivacySettingShowStatus : UserPrivacySetting()

    /**
     * A privacy setting for managing whether the user's profile photo is visible
     */
    class UserPrivacySettingShowProfilePhoto : UserPrivacySetting()

    /**
     * A privacy setting for managing whether a link to the user's account is included in forwarded messages
     */
    class UserPrivacySettingShowLinkInForwardedMessages : UserPrivacySetting()

    /**
     * A privacy setting for managing whether the user can be invited to chats
     */
    class UserPrivacySettingAllowChatInvites : UserPrivacySetting()

    /**
     * A privacy setting for managing whether the user can be called
     */
    class UserPrivacySettingAllowCalls : UserPrivacySetting()

    /**
     * A privacy setting for managing whether peer-to-peer connections can be used for calls
     */
    class UserPrivacySettingAllowPeerToPeerCalls : UserPrivacySetting()

    /**
     * Contains information about the period of inactivity after which the current user's account will automatically be deleted
     *
     * @days - Number of days of inactivity before the account will be flagged for deletion
     *         Should range from 30-366 days
     */
    class AccountTtl(
        val days: Int = 0
    ) : Object()

    /**
     * Contains information about one session in a Telegram application used by the current user
     * Sessions should be shown to the user in the returned order
     *
     * @id - Session identifier
     * @isCurrent - True, if this session is the current session
     * @isPasswordPending - True, if a password is needed to complete authorization of the session
     * @apiId - Telegram API identifier, as provided by the application
     * @applicationName - Name of the application, as provided by the application
     * @applicationVersion - The version of the application, as provided by the application
     * @isOfficialApplication - True, if the application is an official application or uses the api_id of an official application
     * @deviceModel - Model of the device the application has been run or is running on, as provided by the application
     * @platform - Operating system the application has been run or is running on, as provided by the application
     * @systemVersion - Version of the operating system the application has been run or is running on, as provided by the application
     * @logInDate - Point in time (Unix timestamp) when the user has logged in
     * @lastActiveDate - Point in time (Unix timestamp) when the session was last used
     * @ip - IP address from which the session was created, in human-readable format
     * @country - A two-letter country code for the country from which the session was created, based on the IP address
     * @region - Region code from which the session was created, based on the IP address
     */
    class Session(
        val id: Long,
        val isCurrent: Boolean,
        val isPasswordPending: Boolean,
        val apiId: Int,
        val applicationName: String,
        val applicationVersion: String,
        val isOfficialApplication: Boolean,
        val deviceModel: String,
        val platform: String,
        val systemVersion: String,
        val logInDate: Int,
        val lastActiveDate: Int,
        val ip: String,
        val country: String,
        val region: String
    ) : Object()

    /**
     * Contains a list of sessions
     *
     * @sessions - List of sessions
     */
    class Sessions(
        val sessions: Array<Session>
    ) : Object()

    /**
     * Contains information about one website the current user is logged in with Telegram
     *
     * @id - Website identifier
     * @domainName - The domain name of the website
     * @botUserId - User identifier of a bot linked with the website
     * @browser - The version of a browser used to log in
     * @platform - Operating system the browser is running on
     * @logInDate - Point in time (Unix timestamp) when the user was logged in
     * @lastActiveDate - Point in time (Unix timestamp) when obtained authorization was last used
     * @ip - IP address from which the user was logged in, in human-readable format
     * @location - Human-readable description of a country and a region, from which the user was logged in, based on the IP address
     */
    class ConnectedWebsite(
        val id: Long,
        val domainName: String,
        val botUserId: Int,
        val browser: String,
        val platform: String,
        val logInDate: Int,
        val lastActiveDate: Int,
        val ip: String,
        val location: String
    ) : Object()

    /**
     * Contains a list of websites the current user is logged in with Telegram
     *
     * @websites - List of connected websites
     */
    class ConnectedWebsites(
        val websites: Array<ConnectedWebsite>
    ) : Object()

    /**
     * Contains information about the availability of the "Report spam" action for a chat
     *
     * @canReportSpam - True, if a prompt with the "Report spam" action should be shown to the user
     */
    class ChatReportSpamState(
        val canReportSpam: Boolean
    ) : Object()

    /**
     * Describes the reason why a chat is reported
     */
    abstract class ChatReportReason : null()

    /**
     * The chat contains spam messages
     */
    class ChatReportReasonSpam : ChatReportReason()

    /**
     * The chat promotes violence
     */
    class ChatReportReasonViolence : ChatReportReason()

    /**
     * The chat contains pornographic messages
     */
    class ChatReportReasonPornography : ChatReportReason()

    /**
     * The chat has child abuse related content
     */
    class ChatReportReasonChildAbuse : ChatReportReason()

    /**
     * The chat contains copyrighted content
     */
    class ChatReportReasonCopyright : ChatReportReason()

    /**
     * A custom reason provided by the user
     *
     * @text - Report text
     */
    class ChatReportReasonCustom(
        val text: String
    ) : ChatReportReason()

    /**
     * Contains a public HTTPS link to a message in a public supergroup or channel with a username
     *
     * @link - Message link
     * @html - HTML-code for embedding the message
     */
    class PublicMessageLink(
        val link: String,
        val html: String
    ) : Object()

    /**
     * Contains information about a link to a message in a chat
     *
     * @isPublic - True, if the link is a public link for a message in a chat
     * @chatId - If found, identifier of the chat to which the message belongs, 0 otherwise
     * @message - If found, the linked message
     * @forAlbum - True, if the whole media album to which the message belongs is linked
     */
    class MessageLinkInfo(
        val isPublic: Boolean,
        val chatId: Long,
        val message: Message?,
        val forAlbum: Boolean
    ) : Object()

    /**
     * Contains a part of a file
     *
     * @data - File bytes
     */
    class FilePart(
        val data: ByteArray
    ) : Object()

    /**
     * Represents the type of a file
     */
    abstract class FileType : null()

    /**
     * The data is not a file
     */
    class FileTypeNone : FileType()

    /**
     * The file is an animation
     */
    class FileTypeAnimation : FileType()

    /**
     * The file is an audio file
     */
    class FileTypeAudio : FileType()

    /**
     * The file is a document
     */
    class FileTypeDocument : FileType()

    /**
     * The file is a photo
     */
    class FileTypePhoto : FileType()

    /**
     * The file is a profile photo
     */
    class FileTypeProfilePhoto : FileType()

    /**
     * The file was sent to a secret chat (the file type is not known to the server)
     */
    class FileTypeSecret : FileType()

    /**
     * The file is a thumbnail of a file from a secret chat
     */
    class FileTypeSecretThumbnail : FileType()

    /**
     * The file is a file from Secure storage used for storing Telegram Passport files
     */
    class FileTypeSecure : FileType()

    /**
     * The file is a sticker
     */
    class FileTypeSticker : FileType()

    /**
     * The file is a thumbnail of another file
     */
    class FileTypeThumbnail : FileType()

    /**
     * The file type is not yet known
     */
    class FileTypeUnknown : FileType()

    /**
     * The file is a video
     */
    class FileTypeVideo : FileType()

    /**
     * The file is a video note
     */
    class FileTypeVideoNote : FileType()

    /**
     * The file is a voice note
     */
    class FileTypeVoiceNote : FileType()

    /**
     * The file is a wallpaper or a background pattern
     */
    class FileTypeWallpaper : FileType()

    /**
     * Contains the storage usage statistics for a specific file type
     *
     * @fileType - File type
     * @size - Total size of the files
     * @count - Total number of files
     */
    class StorageStatisticsByFileType(
        val fileType: FileType,
        val size: Long,
        val count: Int
    ) : Object()

    /**
     * Contains the storage usage statistics for a specific chat
     *
     * @chatId - Chat identifier
     *           0 if none
     * @size - Total size of the files in the chat
     * @count - Total number of files in the chat
     * @byFileType - Statistics split by file types
     */
    class StorageStatisticsByChat(
        val chatId: Long,
        val size: Long,
        val count: Int,
        val byFileType: Array<StorageStatisticsByFileType>
    ) : Object()

    /**
     * Contains the exact storage usage statistics split by chats and file type
     *
     * @size - Total size of files
     * @count - Total number of files
     * @byChat - Statistics split by chats
     */
    class StorageStatistics(
        val size: Long,
        val count: Int,
        val byChat: Array<StorageStatisticsByChat>
    ) : Object()

    /**
     * Contains approximate storage usage statistics, excluding files of unknown file type
     *
     * @filesSize - Approximate total size of files
     * @fileCount - Approximate number of files
     * @databaseSize - Size of the database
     * @languagePackDatabaseSize - Size of the language pack database
     * @logSize - Size of the TDLib internal log
     */
    class StorageStatisticsFast(
        val filesSize: Long,
        val fileCount: Int,
        val databaseSize: Long,
        val languagePackDatabaseSize: Long,
        val logSize: Long
    ) : Object()

    /**
     * Contains database statistics
     *
     * @statistics - Database statistics in an unspecified human-readable format
     */
    class DatabaseStatistics(
        val statistics: String
    ) : Object()

    /**
     * Represents the type of a network
     */
    abstract class NetworkType : null()

    /**
     * The network is not available
     */
    class NetworkTypeNone : NetworkType()

    /**
     * A mobile network
     */
    class NetworkTypeMobile : NetworkType()

    /**
     * A mobile roaming network
     */
    class NetworkTypeMobileRoaming : NetworkType()

    /**
     * A Wi-Fi network
     */
    class NetworkTypeWiFi : NetworkType()

    /**
     * A different network type (e.g., Ethernet network)
     */
    class NetworkTypeOther : NetworkType()

    /**
     * Contains statistics about network usage
     */
    abstract class NetworkStatisticsEntry : null()

    /**
     * Contains information about the total amount of data that was used to send and receive files
     *
     * @fileType - Type of the file the data is part of
     * @networkType - Type of the network the data was sent through
     *                Call setNetworkType to maintain the actual network type
     * @sentBytes - Total number of bytes sent
     * @receivedBytes - Total number of bytes received
     */
    class NetworkStatisticsEntryFile(
        val fileType: FileType,
        val networkType: NetworkType,
        val sentBytes: Long = 0L,
        val receivedBytes: Long = 0L
    ) : NetworkStatisticsEntry()

    /**
     * Contains information about the total amount of data that was used for calls
     *
     * @networkType - Type of the network the data was sent through
     *                Call setNetworkType to maintain the actual network type
     * @sentBytes - Total number of bytes sent
     * @receivedBytes - Total number of bytes received
     * @duration - Total call duration, in seconds
     */
    class NetworkStatisticsEntryCall(
        val networkType: NetworkType,
        val sentBytes: Long = 0L,
        val receivedBytes: Long = 0L,
        val duration: Double = 0.0
    ) : NetworkStatisticsEntry()

    /**
     * A full list of available network statistic entries
     *
     * @sinceDate - Point in time (Unix timestamp) when the app began collecting statistics
     * @entries - Network statistics entries
     */
    class NetworkStatistics(
        val sinceDate: Int,
        val entries: Array<NetworkStatisticsEntry>
    ) : Object()

    /**
     * Contains auto-download settings
     *
     * @isAutoDownloadEnabled - True, if the auto-download is enabled
     * @maxPhotoFileSize - Maximum size of a photo file to be auto-downloaded
     * @maxVideoFileSize - Maximum size of a video file to be auto-downloaded
     * @maxOtherFileSize - Maximum size of other file types to be auto-downloaded
     * @preloadLargeVideos - True, if the beginning of videos needs to be preloaded for instant playback
     * @preloadNextAudio - True, if the next audio track needs to be preloaded while the user is listening to an audio file
     * @useLessDataForCalls - True, if "use less data for calls" option needs to be enabled
     */
    class AutoDownloadSettings(
        val isAutoDownloadEnabled: Boolean = false,
        val maxPhotoFileSize: Int = 0,
        val maxVideoFileSize: Int = 0,
        val maxOtherFileSize: Int = 0,
        val preloadLargeVideos: Boolean = false,
        val preloadNextAudio: Boolean = false,
        val useLessDataForCalls: Boolean = false
    ) : Object()

    /**
     * Contains auto-download settings presets for the user
     *
     * @low - Preset with lowest settings
     *        Supposed to be used by default when roaming
     * @medium - Preset with medium settings
     *           Supposed to be used by default when using mobile data
     * @high - Preset with highest settings
     *         Supposed to be used by default when connected on Wi-Fi
     */
    class AutoDownloadSettingsPresets(
        val low: AutoDownloadSettings,
        val medium: AutoDownloadSettings,
        val high: AutoDownloadSettings
    ) : Object()

    /**
     * Describes the current state of the connection to Telegram servers
     */
    abstract class ConnectionState : null()

    /**
     * Currently waiting for the network to become available
     * Use setNetworkType to change the available network type
     */
    class ConnectionStateWaitingForNetwork : ConnectionState()

    /**
     * Currently establishing a connection with a proxy server
     */
    class ConnectionStateConnectingToProxy : ConnectionState()

    /**
     * Currently establishing a connection to the Telegram servers
     */
    class ConnectionStateConnecting : ConnectionState()

    /**
     * Downloading data received while the client was offline
     */
    class ConnectionStateUpdating : ConnectionState()

    /**
     * There is a working connection to the Telegram servers
     */
    class ConnectionStateReady : ConnectionState()

    /**
     * Represents the categories of chats for which a list of frequently used chats can be retrieved
     */
    abstract class TopChatCategory : null()

    /**
     * A category containing frequently used private chats with non-bot users
     */
    class TopChatCategoryUsers : TopChatCategory()

    /**
     * A category containing frequently used private chats with bot users
     */
    class TopChatCategoryBots : TopChatCategory()

    /**
     * A category containing frequently used basic groups and supergroups
     */
    class TopChatCategoryGroups : TopChatCategory()

    /**
     * A category containing frequently used channels
     */
    class TopChatCategoryChannels : TopChatCategory()

    /**
     * A category containing frequently used chats with inline bots sorted by their usage in inline mode
     */
    class TopChatCategoryInlineBots : TopChatCategory()

    /**
     * A category containing frequently used chats used for calls
     */
    class TopChatCategoryCalls : TopChatCategory()

    /**
     * Describes the type of a URL linking to an internal Telegram entity
     */
    abstract class TMeUrlType : null()

    /**
     * A URL linking to a user
     *
     * @userId - Identifier of the user
     */
    class TMeUrlTypeUser(
        val userId: Int
    ) : TMeUrlType()

    /**
     * A URL linking to a public supergroup or channel
     *
     * @supergroupId - Identifier of the supergroup or channel
     */
    class TMeUrlTypeSupergroup(
        val supergroupId: Long
    ) : TMeUrlType()

    /**
     * A chat invite link
     *
     * @info - Chat invite link info
     */
    class TMeUrlTypeChatInvite(
        val info: ChatInviteLinkInfo
    ) : TMeUrlType()

    /**
     * A URL linking to a sticker set
     *
     * @stickerSetId - Identifier of the sticker set
     */
    class TMeUrlTypeStickerSet(
        val stickerSetId: Long
    ) : TMeUrlType()

    /**
     * Represents a URL linking to an internal Telegram entity
     *
     * @url - URL
     * @type - Type of the URL
     */
    class TMeUrl(
        val url: String,
        val type: TMeUrlType
    ) : Object()

    /**
     * Contains a list of t.me URLs
     *
     * @urls - List of URLs
     */
    class TMeUrls(
        val urls: Array<TMeUrl>
    ) : Object()

    /**
     * Contains a counter
     *
     * @count - Count
     */
    class Count(
        val count: Int
    ) : Object()

    /**
     * Contains some text
     *
     * @text - Text
     */
    class Text(
        val text: String
    ) : Object()

    /**
     * Contains a value representing a number of seconds
     *
     * @seconds - Number of seconds
     */
    class Seconds(
        val seconds: Double
    ) : Object()

    /**
     * Contains information about a tg:// deep link
     *
     * @text - Text to be shown to the user
     * @needUpdateApplication - True, if user should be asked to update the application
     */
    class DeepLinkInfo(
        val text: FormattedText,
        val needUpdateApplication: Boolean
    ) : Object()

    /**
     * Describes the way the text should be parsed for TextEntities
     */
    abstract class TextParseMode : null()

    /**
     * The text should be parsed in markdown-style
     */
    class TextParseModeMarkdown : TextParseMode()

    /**
     * The text should be parsed in HTML-style
     */
    class TextParseModeHTML : TextParseMode()

    /**
     * Describes the type of the proxy server
     */
    abstract class ProxyType : null()

    /**
     * A SOCKS5 proxy server
     *
     * @username - Username for logging in
     * @password - Password for logging in
     */
    class ProxyTypeSocks5(
        val username: String? = null,
        val password: String? = null
    ) : ProxyType()

    /**
     * A HTTP transparent proxy server
     *
     * @username - Username for logging in
     * @password - Password for logging in
     * @httpOnly - Pass true, if the proxy supports only HTTP requests and doesn't support transparent TCP connections via HTTP CONNECT method
     */
    class ProxyTypeHttp(
        val username: String? = null,
        val password: String? = null,
        val httpOnly: Boolean = false
    ) : ProxyType()

    /**
     * An MTProto proxy server
     *
     * @secret - The proxy's secret in hexadecimal encoding
     */
    class ProxyTypeMtproto(
        val secret: String
    ) : ProxyType()

    /**
     * Contains information about a proxy server
     *
     * @id - Unique identifier of the proxy
     * @server - Proxy server IP address
     * @port - Proxy server port
     * @lastUsedDate - Point in time (Unix timestamp) when the proxy was last used
     *                 0 if never
     * @isEnabled - True, if the proxy is enabled now
     * @type - Type of the proxy
     */
    class Proxy(
        val id: Int,
        val server: String,
        val port: Int,
        val lastUsedDate: Int,
        val isEnabled: Boolean,
        val type: ProxyType
    ) : Object()

    /**
     * Represents a list of proxy servers
     *
     * @proxies - List of proxy servers
     */
    class Proxies(
        val proxies: Array<Proxy>
    ) : Object()

    /**
     * Describes a sticker that should be added to a sticker set
     *
     * @pngSticker - PNG image with the sticker
     *               Must be up to 512 kB in size and fit in a 512x512 square
     * @emojis - Emoji corresponding to the sticker
     * @maskPosition - For masks, position where the mask should be placed
     */
    class InputSticker(
        val pngSticker: InputFile,
        val emojis: String,
        val maskPosition: MaskPosition? = null
    ) : Object()

    /**
     * Contains notifications about data changes
     */
    abstract class Update : null()

    /**
     * The user authorization state has changed
     *
     * @authorizationState - New authorization state
     */
    class UpdateAuthorizationState(
        val authorizationState: AuthorizationState
    ) : Update()

    /**
     * A new message was received
     * Can also be an outgoing message
     *
     * @message - The new message
     */
    class UpdateNewMessage(
        val message: Message
    ) : Update()

    /**
     * A request to send a message has reached the Telegram server
     * This doesn't mean that the message will be sent successfully or even that the send message request will be processed
     * This update will be sent only if the option "use_quick_ack" is set to true
     * This update may be sent multiple times for the same message
     *
     * @chatId - The chat identifier of the sent message
     * @messageId - A temporary message identifier
     */
    class UpdateMessageSendAcknowledged(
        val chatId: Long,
        val messageId: Long
    ) : Update()

    /**
     * A message has been successfully sent
     *
     * @message - Information about the sent message
     *            Usually only the message identifier, date, and content are changed, but almost all other fields can also change
     * @oldMessageId - The previous temporary message identifier
     */
    class UpdateMessageSendSucceeded(
        val message: Message,
        val oldMessageId: Long
    ) : Update()

    /**
     * A message failed to send
     * Be aware that some messages being sent can be irrecoverably deleted, in which case updateDeleteMessages will be received instead of this update
     *
     * @message - Contains information about the message which failed to send
     * @oldMessageId - The previous temporary message identifier
     * @errorCode - An error code
     * @errorMessage - Error message
     */
    class UpdateMessageSendFailed(
        val message: Message,
        val oldMessageId: Long,
        val errorCode: Int,
        val errorMessage: String
    ) : Update()

    /**
     * The message content has changed
     *
     * @chatId - Chat identifier
     * @messageId - Message identifier
     * @newContent - New message content
     */
    class UpdateMessageContent(
        val chatId: Long,
        val messageId: Long,
        val newContent: MessageContent
    ) : Update()

    /**
     * A message was edited
     * Changes in the message content will come in a separate updateMessageContent
     *
     * @chatId - Chat identifier
     * @messageId - Message identifier
     * @editDate - Point in time (Unix timestamp) when the message was edited
     * @replyMarkup - New message reply markup
     */
    class UpdateMessageEdited(
        val chatId: Long,
        val messageId: Long,
        val editDate: Int,
        val replyMarkup: ReplyMarkup?
    ) : Update()

    /**
     * The view count of the message has changed
     *
     * @chatId - Chat identifier
     * @messageId - Message identifier
     * @views - New value of the view count
     */
    class UpdateMessageViews(
        val chatId: Long,
        val messageId: Long,
        val views: Int
    ) : Update()

    /**
     * The message content was opened
     * Updates voice note messages to "listened", video note messages to "viewed" and starts the TTL timer for self-destructing messages
     *
     * @chatId - Chat identifier
     * @messageId - Message identifier
     */
    class UpdateMessageContentOpened(
        val chatId: Long,
        val messageId: Long
    ) : Update()

    /**
     * A message with an unread mention was read
     *
     * @chatId - Chat identifier
     * @messageId - Message identifier
     * @unreadMentionCount - The new number of unread mention messages left in the chat
     */
    class UpdateMessageMentionRead(
        val chatId: Long,
        val messageId: Long,
        val unreadMentionCount: Int
    ) : Update()

    /**
     * A new chat has been loaded/created
     * This update is guaranteed to come before the chat identifier is returned to the client
     * The chat field changes will be reported through separate updates
     *
     * @chat - The chat
     */
    class UpdateNewChat(
        val chat: Chat
    ) : Update()

    /**
     * The title of a chat was changed
     *
     * @chatId - Chat identifier
     * @title - The new chat title
     */
    class UpdateChatTitle(
        val chatId: Long,
        val title: String
    ) : Update()

    /**
     * A chat photo was changed
     *
     * @chatId - Chat identifier
     * @photo - The new chat photo
     */
    class UpdateChatPhoto(
        val chatId: Long,
        val photo: ChatPhoto?
    ) : Update()

    /**
     * Chat permissions was changed
     *
     * @chatId - Chat identifier
     * @permissions - The new chat permissions
     */
    class UpdateChatPermissions(
        val chatId: Long,
        val permissions: ChatPermissions
    ) : Update()

    /**
     * The last message of a chat was changed
     * If last_message is null then the last message in the chat became unknown
     * Some new unknown messages might be added to the chat in this case
     *
     * @chatId - Chat identifier
     * @lastMessage - The new last message in the chat
     * @order - New value of the chat order
     */
    class UpdateChatLastMessage(
        val chatId: Long,
        val lastMessage: Message?,
        val order: Long
    ) : Update()

    /**
     * The order of the chat in the chat list has changed
     * Instead of this update updateChatLastMessage, updateChatIsPinned or updateChatDraftMessage might be sent
     *
     * @chatId - Chat identifier
     * @order - New value of the order
     */
    class UpdateChatOrder(
        val chatId: Long,
        val order: Long
    ) : Update()

    /**
     * A chat was pinned or unpinned
     *
     * @chatId - Chat identifier
     * @isPinned - New value of is_pinned
     * @order - New value of the chat order
     */
    class UpdateChatIsPinned(
        val chatId: Long,
        val isPinned: Boolean,
        val order: Long
    ) : Update()

    /**
     * A chat was marked as unread or was read
     *
     * @chatId - Chat identifier
     * @isMarkedAsUnread - New value of is_marked_as_unread
     */
    class UpdateChatIsMarkedAsUnread(
        val chatId: Long,
        val isMarkedAsUnread: Boolean
    ) : Update()

    /**
     * A chat's is_sponsored field has changed
     *
     * @chatId - Chat identifier
     * @isSponsored - New value of is_sponsored
     * @order - New value of chat order
     */
    class UpdateChatIsSponsored(
        val chatId: Long,
        val isSponsored: Boolean,
        val order: Long
    ) : Update()

    /**
     * The value of the default disable_notification parameter, used when a message is sent to the chat, was changed
     *
     * @chatId - Chat identifier
     * @defaultDisableNotification - The new default_disable_notification value
     */
    class UpdateChatDefaultDisableNotification(
        val chatId: Long,
        val defaultDisableNotification: Boolean
    ) : Update()

    /**
     * Incoming messages were read or number of unread messages has been changed
     *
     * @chatId - Chat identifier
     * @lastReadInboxMessageId - Identifier of the last read incoming message
     * @unreadCount - The number of unread messages left in the chat
     */
    class UpdateChatReadInbox(
        val chatId: Long,
        val lastReadInboxMessageId: Long,
        val unreadCount: Int
    ) : Update()

    /**
     * Outgoing messages were read
     *
     * @chatId - Chat identifier
     * @lastReadOutboxMessageId - Identifier of last read outgoing message
     */
    class UpdateChatReadOutbox(
        val chatId: Long,
        val lastReadOutboxMessageId: Long
    ) : Update()

    /**
     * The chat unread_mention_count has changed
     *
     * @chatId - Chat identifier
     * @unreadMentionCount - The number of unread mention messages left in the chat
     */
    class UpdateChatUnreadMentionCount(
        val chatId: Long,
        val unreadMentionCount: Int
    ) : Update()

    /**
     * Notification settings for a chat were changed
     *
     * @chatId - Chat identifier
     * @notificationSettings - The new notification settings
     */
    class UpdateChatNotificationSettings(
        val chatId: Long,
        val notificationSettings: ChatNotificationSettings
    ) : Update()

    /**
     * Notification settings for some type of chats were updated
     *
     * @scope - Types of chats for which notification settings were updated
     * @notificationSettings - The new notification settings
     */
    class UpdateScopeNotificationSettings(
        val scope: NotificationSettingsScope,
        val notificationSettings: ScopeNotificationSettings
    ) : Update()

    /**
     * The chat pinned message was changed
     *
     * @chatId - Chat identifier
     * @pinnedMessageId - The new identifier of the pinned message
     *                    0 if there is no pinned message in the chat
     */
    class UpdateChatPinnedMessage(
        val chatId: Long,
        val pinnedMessageId: Long
    ) : Update()

    /**
     * The default chat reply markup was changed
     * Can occur because new messages with reply markup were received or because an old reply markup was hidden by the user
     *
     * @chatId - Chat identifier
     * @replyMarkupMessageId - Identifier of the message from which reply markup needs to be used
     *                         0 if there is no default custom reply markup in the chat
     */
    class UpdateChatReplyMarkup(
        val chatId: Long,
        val replyMarkupMessageId: Long
    ) : Update()

    /**
     * A chat draft has changed
     * Be aware that the update may come in the currently opened chat but with old content of the draft
     * If the user has changed the content of the draft, this update shouldn't be applied
     *
     * @chatId - Chat identifier
     * @draftMessage - The new draft message
     * @order - New value of the chat order
     */
    class UpdateChatDraftMessage(
        val chatId: Long,
        val draftMessage: DraftMessage?,
        val order: Long
    ) : Update()

    /**
     * The number of online group members has changed
     * This update with non-zero count is sent only for currently opened chats
     * There is no guarantee that it will be sent just after the count has changed
     *
     * @chatId - Identifier of the chat
     * @onlineMemberCount - New number of online members in the chat, or 0 if unknown
     */
    class UpdateChatOnlineMemberCount(
        val chatId: Long,
        val onlineMemberCount: Int
    ) : Update()

    /**
     * A notification was changed
     *
     * @notificationGroupId - Unique notification group identifier
     * @notification - Changed notification
     */
    class UpdateNotification(
        val notificationGroupId: Int,
        val notification: Notification
    ) : Update()

    /**
     * A list of active notifications in a notification group has changed
     *
     * @notificationGroupId - Unique notification group identifier
     * @type - New type of the notification group
     * @chatId - Identifier of a chat to which all notifications in the group belong
     * @notificationSettingsChatId - Chat identifier, which notification settings must be applied to the added notifications
     * @isSilent - True, if the notifications should be shown without sound
     * @totalCount - Total number of unread notifications in the group, can be bigger than number of active notifications
     * @addedNotifications - List of added group notifications, sorted by notification ID
     * @removedNotificationIds - Identifiers of removed group notifications, sorted by notification ID
     */
    class UpdateNotificationGroup(
        val notificationGroupId: Int,
        val type: NotificationGroupType,
        val chatId: Long,
        val notificationSettingsChatId: Long,
        val isSilent: Boolean,
        val totalCount: Int,
        val addedNotifications: Array<Notification>,
        val removedNotificationIds: IntArray
    ) : Update()

    /**
     * Contains active notifications that was shown on previous application launches
     * This update is sent only if a message database is used
     * In that case it comes once before any updateNotification and updateNotificationGroup update
     *
     * @groups - Lists of active notification groups
     */
    class UpdateActiveNotifications(
        val groups: Array<NotificationGroup>
    ) : Update()

    /**
     * Describes, whether there are some pending notification updates
     * Can be used to prevent application from killing, while there are some pending notifications
     *
     * @haveDelayedNotifications - True, if there are some delayed notification updates, which will be sent soon
     * @haveUnreceivedNotifications - True, if there can be some yet unreceived notifications, which are being fetched from the server
     */
    class UpdateHavePendingNotifications(
        val haveDelayedNotifications: Boolean,
        val haveUnreceivedNotifications: Boolean
    ) : Update()

    /**
     * Some messages were deleted
     *
     * @chatId - Chat identifier
     * @messageIds - Identifiers of the deleted messages
     * @isPermanent - True, if the messages are permanently deleted by a user (as opposed to just becoming inaccessible)
     * @fromCache - True, if the messages are deleted only from the cache and can possibly be retrieved again in the future
     */
    class UpdateDeleteMessages(
        val chatId: Long,
        val messageIds: LongArray,
        val isPermanent: Boolean,
        val fromCache: Boolean
    ) : Update()

    /**
     * User activity in the chat has changed
     *
     * @chatId - Chat identifier
     * @userId - Identifier of a user performing an action
     * @action - The action description
     */
    class UpdateUserChatAction(
        val chatId: Long,
        val userId: Int,
        val action: ChatAction
    ) : Update()

    /**
     * The user went online or offline
     *
     * @userId - User identifier
     * @status - New status of the user
     */
    class UpdateUserStatus(
        val userId: Int,
        val status: UserStatus
    ) : Update()

    /**
     * Some data of a user has changed
     * This update is guaranteed to come before the user identifier is returned to the client
     *
     * @user - New data about the user
     */
    class UpdateUser(
        val user: User
    ) : Update()

    /**
     * Some data of a basic group has changed
     * This update is guaranteed to come before the basic group identifier is returned to the client
     *
     * @basicGroup - New data about the group
     */
    class UpdateBasicGroup(
        val basicGroup: BasicGroup
    ) : Update()

    /**
     * Some data of a supergroup or a channel has changed
     * This update is guaranteed to come before the supergroup identifier is returned to the client
     *
     * @supergroup - New data about the supergroup
     */
    class UpdateSupergroup(
        val supergroup: Supergroup
    ) : Update()

    /**
     * Some data of a secret chat has changed
     * This update is guaranteed to come before the secret chat identifier is returned to the client
     *
     * @secretChat - New data about the secret chat
     */
    class UpdateSecretChat(
        val secretChat: SecretChat
    ) : Update()

    /**
     * Some data from userFullInfo has been changed
     *
     * @userId - User identifier
     * @userFullInfo - New full information about the user
     */
    class UpdateUserFullInfo(
        val userId: Int,
        val userFullInfo: UserFullInfo
    ) : Update()

    /**
     * Some data from basicGroupFullInfo has been changed
     *
     * @basicGroupId - Identifier of a basic group
     * @basicGroupFullInfo - New full information about the group
     */
    class UpdateBasicGroupFullInfo(
        val basicGroupId: Int,
        val basicGroupFullInfo: BasicGroupFullInfo
    ) : Update()

    /**
     * Some data from supergroupFullInfo has been changed
     *
     * @supergroupId - Identifier of the supergroup or channel
     * @supergroupFullInfo - New full information about the supergroup
     */
    class UpdateSupergroupFullInfo(
        val supergroupId: Int,
        val supergroupFullInfo: SupergroupFullInfo
    ) : Update()

    /**
     * Service notification from the server
     * Upon receiving this the client must show a popup with the content of the notification
     *
     * @type - Notification type
     *         If type begins with "AUTH_KEY_DROP_", then two buttons "Cancel" and "Log out" should be shown under notification
     *         If user presses the second, all local data should be destroyed using Destroy method
     * @content - Notification content
     */
    class UpdateServiceNotification(
        val type: String,
        val content: MessageContent
    ) : Update()

    /**
     * Information about a file was updated
     *
     * @file - New data about the file
     */
    class UpdateFile(
        val file: File
    ) : Update()

    /**
     * The file generation process needs to be started by the client
     *
     * @generationId - Unique identifier for the generation process
     * @originalPath - The path to a file from which a new file is generated
     * @destinationPath - The path to a file that should be created and where the new file should be generated
     * @conversion - String specifying the conversion applied to the original file
     *               If conversion is "#url#" than original_path contains an HTTP/HTTPS URL of a file, which should be downloaded by the client
     */
    class UpdateFileGenerationStart(
        val generationId: Long,
        val originalPath: String?,
        val destinationPath: String,
        val conversion: String
    ) : Update()

    /**
     * File generation is no longer needed
     *
     * @generationId - Unique identifier for the generation process
     */
    class UpdateFileGenerationStop(
        val generationId: Long
    ) : Update()

    /**
     * New call was created or information about a call was updated
     *
     * @call - New data about a call
     */
    class UpdateCall(
        val call: Call
    ) : Update()

    /**
     * Some privacy setting rules have been changed
     *
     * @setting - The privacy setting
     * @rules - New privacy rules
     */
    class UpdateUserPrivacySettingRules(
        val setting: UserPrivacySetting,
        val rules: UserPrivacySettingRules
    ) : Update()

    /**
     * Number of unread messages has changed
     * This update is sent only if a message database is used
     *
     * @unreadCount - Total number of unread messages
     * @unreadUnmutedCount - Total number of unread messages in unmuted chats
     */
    class UpdateUnreadMessageCount(
        val unreadCount: Int,
        val unreadUnmutedCount: Int
    ) : Update()

    /**
     * Number of unread chats, i.e
     * With unread messages or marked as unread, has changed
     * This update is sent only if a message database is used
     *
     * @unreadCount - Total number of unread chats
     * @unreadUnmutedCount - Total number of unread unmuted chats
     * @markedAsUnreadCount - Total number of chats marked as unread
     * @markedAsUnreadUnmutedCount - Total number of unmuted chats marked as unread
     */
    class UpdateUnreadChatCount(
        val unreadCount: Int,
        val unreadUnmutedCount: Int,
        val markedAsUnreadCount: Int,
        val markedAsUnreadUnmutedCount: Int
    ) : Update()

    /**
     * An option changed its value
     *
     * @name - The option name
     * @value - The new option value
     */
    class UpdateOption(
        val name: String,
        val value: OptionValue
    ) : Update()

    /**
     * The list of installed sticker sets was updated
     *
     * @isMasks - True, if the list of installed mask sticker sets was updated
     * @stickerSetIds - The new list of installed ordinary sticker sets
     */
    class UpdateInstalledStickerSets(
        val isMasks: Boolean,
        val stickerSetIds: LongArray
    ) : Update()

    /**
     * The list of trending sticker sets was updated or some of them were viewed
     *
     * @stickerSets - The new list of trending sticker sets
     */
    class UpdateTrendingStickerSets(
        val stickerSets: StickerSets
    ) : Update()

    /**
     * The list of recently used stickers was updated
     *
     * @isAttached - True, if the list of stickers attached to photo or video files was updated, otherwise the list of sent stickers is updated
     * @stickerIds - The new list of file identifiers of recently used stickers
     */
    class UpdateRecentStickers(
        val isAttached: Boolean,
        val stickerIds: IntArray
    ) : Update()

    /**
     * The list of favorite stickers was updated
     *
     * @stickerIds - The new list of file identifiers of favorite stickers
     */
    class UpdateFavoriteStickers(
        val stickerIds: IntArray
    ) : Update()

    /**
     * The list of saved animations was updated
     *
     * @animationIds - The new list of file identifiers of saved animations
     */
    class UpdateSavedAnimations(
        val animationIds: IntArray
    ) : Update()

    /**
     * The selected background has changed
     *
     * @forDarkTheme - True, if background for dark theme has changed
     * @background - The new selected background
     */
    class UpdateSelectedBackground(
        val forDarkTheme: Boolean,
        val background: Background?
    ) : Update()

    /**
     * Some language pack strings have been updated
     *
     * @localizationTarget - Localization target to which the language pack belongs
     * @languagePackId - Identifier of the updated language pack
     * @strings - List of changed language pack strings
     */
    class UpdateLanguagePackStrings(
        val localizationTarget: String,
        val languagePackId: String,
        val strings: Array<LanguagePackString>
    ) : Update()

    /**
     * The connection state has changed
     *
     * @state - The new connection state
     */
    class UpdateConnectionState(
        val state: ConnectionState
    ) : Update()

    /**
     * New terms of service must be accepted by the user
     * If the terms of service are declined, then the deleteAccount method should be called with the reason "Decline ToS update"
     *
     * @termsOfServiceId - Identifier of the terms of service
     * @termsOfService - The new terms of service
     */
    class UpdateTermsOfService(
        val termsOfServiceId: String,
        val termsOfService: TermsOfService
    ) : Update()

    /**
     * A new incoming inline query
     *
     * @id - Unique query identifier
     * @senderUserId - Identifier of the user who sent the query
     * @userLocation - User location, provided by the client
     * @query - Text of the query
     * @offset - Offset of the first entry to return
     */
    @BotsOnly
    class UpdateNewInlineQuery(
        val id: Long,
        val senderUserId: Int,
        val userLocation: Location?,
        val query: String,
        val offset: String
    ) : Update()

    /**
     * The user has chosen a result of an inline query
     *
     * @senderUserId - Identifier of the user who sent the query
     * @userLocation - User location, provided by the client
     * @query - Text of the query
     * @resultId - Identifier of the chosen result
     * @inlineMessageId - Identifier of the sent inline message, if known
     */
    @BotsOnly
    class UpdateNewChosenInlineResult(
        val senderUserId: Int,
        val userLocation: Location?,
        val query: String,
        val resultId: String,
        val inlineMessageId: String
    ) : Update()

    /**
     * A new incoming callback query
     *
     * @id - Unique query identifier
     * @senderUserId - Identifier of the user who sent the query
     * @chatId - Identifier of the chat, in which the query was sent
     * @messageId - Identifier of the message, from which the query originated
     * @chatInstance - Identifier that uniquely corresponds to the chat to which the message was sent
     * @payload - Query payload
     */
    @BotsOnly
    class UpdateNewCallbackQuery(
        val id: Long,
        val senderUserId: Int,
        val chatId: Long,
        val messageId: Long,
        val chatInstance: Long,
        val payload: CallbackQueryPayload
    ) : Update()

    /**
     * A new incoming callback query from a message sent via a bot
     *
     * @id - Unique query identifier
     * @senderUserId - Identifier of the user who sent the query
     * @inlineMessageId - Identifier of the inline message, from which the query originated
     * @chatInstance - An identifier uniquely corresponding to the chat a message was sent to
     * @payload - Query payload
     */
    @BotsOnly
    class UpdateNewInlineCallbackQuery(
        val id: Long,
        val senderUserId: Int,
        val inlineMessageId: String,
        val chatInstance: Long,
        val payload: CallbackQueryPayload
    ) : Update()

    /**
     * A new incoming shipping query
     * Only for invoices with flexible price
     *
     * @id - Unique query identifier
     * @senderUserId - Identifier of the user who sent the query
     * @invoicePayload - Invoice payload
     * @shippingAddress - User shipping address
     */
    @BotsOnly
    class UpdateNewShippingQuery(
        val id: Long,
        val senderUserId: Int,
        val invoicePayload: String,
        val shippingAddress: Address
    ) : Update()

    /**
     * A new incoming pre-checkout query
     * Contains full information about a checkout
     *
     * @id - Unique query identifier
     * @senderUserId - Identifier of the user who sent the query
     * @currency - Currency for the product price
     * @totalAmount - Total price for the product, in the minimal quantity of the currency
     * @invoicePayload - Invoice payload
     * @shippingOptionId - Identifier of a shipping option chosen by the user
     *                     May be empty if not applicable
     * @orderInfo - Information about the order
     */
    @BotsOnly
    class UpdateNewPreCheckoutQuery(
        val id: Long,
        val senderUserId: Int,
        val currency: String,
        val totalAmount: Long,
        val invoicePayload: ByteArray,
        val shippingOptionId: String?,
        val orderInfo: OrderInfo?
    ) : Update()

    /**
     * A new incoming event
     *
     * @event - A JSON-serialized event
     */
    @BotsOnly
    class UpdateNewCustomEvent(
        val event: String
    ) : Update()

    /**
     * A new incoming query
     *
     * @id - The query identifier
     * @data - JSON-serialized query data
     * @timeout - Query timeout
     */
    @BotsOnly
    class UpdateNewCustomQuery(
        val id: Long,
        val data: String,
        val timeout: Int
    ) : Update()

    /**
     * Information about a poll was updated
     *
     * @poll - New data about the poll
     */
    @BotsOnly
    class UpdatePoll(
        val poll: Poll
    ) : Update()

    /**
     * Contains a list of updates
     *
     * @updates - List of updates
     */
    class Updates(
        val updates: Array<Update>
    ) : Object()

    /**
     * Describes a stream to which TDLib internal log is written
     */
    abstract class LogStream : null()

    /**
     * The log is written to stderr or an OS specific log
     */
    class LogStreamDefault : LogStream()

    /**
     * The log is written to a file
     *
     * @path - Path to the file to where the internal TDLib log will be written
     * @maxFileSize - Maximum size of the file to where the internal TDLib log is written before the file will be auto-rotated
     */
    class LogStreamFile(
        val path: String,
        val maxFileSize: Long = 0L
    ) : LogStream()

    /**
     * The log is written nowhere
     */
    class LogStreamEmpty : LogStream()

    /**
     * Contains a TDLib internal log verbosity level
     *
     * @verbosityLevel - Log verbosity level
     */
    class LogVerbosityLevel(
        val verbosityLevel: Int
    ) : Object()

    /**
     * Contains a list of available TDLib internal log tags
     *
     * @tags - List of log tags
     */
    class LogTags(
        val tags: Array<String>
    ) : Object()

    /**
     * A simple object containing a number
     *
     * @value - Number
     */
    @TestingOnly
    class TestInt(
        val value: Int = 0
    ) : Object()

    /**
     * A simple object containing a string
     *
     * @value - String
     */
    @TestingOnly
    class TestString(
        val value: String
    ) : Object()

    /**
     * A simple object containing a sequence of bytes
     *
     * @value - Bytes
     */
    @TestingOnly
    class TestBytes(
        val value: ByteArray
    ) : Object()

    /**
     * A simple object containing a vector of numbers
     *
     * @value - Vector of numbers
     */
    @TestingOnly
    class TestVectorInt(
        val value: IntArray
    ) : Object()

    /**
     * A simple object containing a vector of objects that hold a number
     *
     * @value - Vector of objects
     */
    @TestingOnly
    class TestVectorIntObject(
        val value: Array<TestInt>
    ) : Object()

    /**
     * A simple object containing a vector of strings
     *
     * @value - Vector of strings
     */
    @TestingOnly
    class TestVectorString(
        val value: Array<String>
    ) : Object()

    /**
     * A simple object containing a vector of objects that hold a string
     *
     * @value - Vector of objects
     */
    @TestingOnly
    class TestVectorStringObject(
        val value: Array<TestString>
    ) : Object()

    /**
     * Returns the current authorization state
     * This is an offline request
     * For informational purposes only
     * Use updateAuthorizationState instead to maintain the current authorization state
     */
    class GetAuthorizationState : null()

    /**
     * Sets the parameters for TDLib initialization
     * Works only when the current authorization state is authorizationStateWaitTdlibParameters
     *
     * @parameters - Parameters
     */
    class SetTdlibParameters(
        val parameters: TdlibParameters? = null
    ) : null()

    /**
     * Checks the database encryption key for correctness
     * Works only when the current authorization state is authorizationStateWaitEncryptionKey
     *
     * @encryptionKey - Encryption key to check or set up
     */
    class CheckDatabaseEncryptionKey(
        val encryptionKey: ByteArray = byteArrayOf()
    ) : null()

    /**
     * Sets the phone number of the user and sends an authentication code to the user
     * Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitCode or authorizationStateWaitPassword
     *
     * @phoneNumber - The phone number of the user, in international format
     * @settings - Settings for the authentication of the user's phone number
     */
    class SetAuthenticationPhoneNumber(
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : null()

    /**
     * Re-sends an authentication code to the user
     * Works only when the current authorization state is authorizationStateWaitCode and the next_code_type of the result is not null
     */
    class ResendAuthenticationCode : null()

    /**
     * Checks the authentication code
     * Works only when the current authorization state is authorizationStateWaitCode
     *
     * @code - The verification code received via SMS, Telegram message, phone call, or flash call
     */
    class CheckAuthenticationCode(
        val code: String? = null
    ) : null()

    /**
     * Finishes user registration
     * Works only when the current authorization state is authorizationStateWaitRegistration
     *
     * @firstName - The first name of the user
     * @lastName - The last name of the user
     */
    class RegisterUser(
        val firstName: String? = null,
        val lastName: String? = null
    ) : null()

    /**
     * Checks the authentication password for correctness
     * Works only when the current authorization state is authorizationStateWaitPassword
     *
     * @password - The password to check
     */
    class CheckAuthenticationPassword(
        val password: String? = null
    ) : null()

    /**
     * Requests to send a password recovery code to an email address that was previously set up
     * Works only when the current authorization state is authorizationStateWaitPassword
     */
    class RequestAuthenticationPasswordRecovery : null()

    /**
     * Recovers the password with a password recovery code sent to an email address that was previously set up
     * Works only when the current authorization state is authorizationStateWaitPassword
     *
     * @recoveryCode - Recovery code to check
     */
    class RecoverAuthenticationPassword(
        val recoveryCode: String? = null
    ) : null()

    /**
     * Checks the authentication token of a bot
     * Works only when the current authorization state is authorizationStateWaitPhoneNumber
     * Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in
     *
     * @token - The bot token
     */
    @BotsOnly
    class CheckAuthenticationBotToken(
        val token: String? = null
    ) : null()

    /**
     * Closes the TDLib instance after a proper logout
     * Requires an available network connection
     * All local data will be destroyed
     * After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
     */
    class LogOut : null()

    /**
     * Closes the TDLib instance
     * All databases will be flushed to disk and properly closed
     * After the close completes, updateAuthorizationState with authorizationStateClosed will be sent
     */
    class Close : null()

    /**
     * Closes the TDLib instance, destroying all local data without a proper logout
     * The current user session will remain in the list of all active sessions
     * All local data will be destroyed
     * After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent
     */
    class Destroy : null()

    /**
     * Returns all updates needed to restore current TDLib state, i.e
     * All actual UpdateAuthorizationState/UpdateUser/UpdateNewChat and others
     * This is especially usefull if TDLib is run in a separate process
     * This is an offline method
     * Can be called before authorization
     */
    class GetCurrentState : null()

    /**
     * Changes the database encryption key
     * Usually the encryption key is never changed and is stored in some OS keychain
     *
     * @newEncryptionKey - New encryption key
     */
    class SetDatabaseEncryptionKey(
        val newEncryptionKey: ByteArray = byteArrayOf()
    ) : null()

    /**
     * Returns the current state of 2-step verification
     */
    class GetPasswordState : null()

    /**
     * Changes the password for the user
     * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
     *
     * @oldPassword - Previous password of the user
     * @newPassword - New password of the user
     *                May be empty to remove the password
     * @newHint - New password hint
     * @setRecoveryEmailAddress - Pass true if the recovery email address should be changed
     * @newRecoveryEmailAddress - New recovery email address
     */
    class SetPassword(
        val oldPassword: String? = null,
        val newPassword: String? = null,
        val newHint: String? = null,
        val setRecoveryEmailAddress: Boolean = false,
        val newRecoveryEmailAddress: String? = null
    ) : null()

    /**
     * Returns a 2-step verification recovery email address that was previously set up
     * This method can be used to verify a password provided by the user
     *
     * @password - The password for the current user
     */
    class GetRecoveryEmailAddress(
        val password: String? = null
    ) : null()

    /**
     * Changes the 2-step verification recovery email address of the user
     * If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
     * If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
     *
     * @password - Password of the current user
     * @newRecoveryEmailAddress - New recovery email address
     */
    class SetRecoveryEmailAddress(
        val password: String? = null,
        val newRecoveryEmailAddress: String? = null
    ) : null()

    /**
     * Checks the 2-step verification recovery email address verification code
     *
     * @code - Verification code
     */
    class CheckRecoveryEmailAddressCode(
        val code: String? = null
    ) : null()

    /**
     * Resends the 2-step verification recovery email address verification code
     */
    class ResendRecoveryEmailAddressCode : null()

    /**
     * Requests to send a password recovery code to an email address that was previously set up
     */
    class RequestPasswordRecovery : null()

    /**
     * Recovers the password using a recovery code sent to an email address that was previously set up
     *
     * @recoveryCode - Recovery code to check
     */
    class RecoverPassword(
        val recoveryCode: String? = null
    ) : null()

    /**
     * Creates a new temporary password for processing payments
     *
     * @password - Persistent user password
     * @validFor - Time during which the temporary password will be valid, in seconds
     *             Should be between 60 and 86400
     */
    class CreateTemporaryPassword(
        val password: String? = null,
        val validFor: Int = 0
    ) : null()

    /**
     * Returns information about the current temporary password
     */
    class GetTemporaryPasswordState : null()

    /**
     * Returns the current user
     */
    class GetMe : null()

    /**
     * Returns information about a user by their identifier
     * This is an offline request if the current user is not a bot
     *
     * @userId - User identifier
     */
    class GetUser(
        val userId: Int = 0
    ) : null()

    /**
     * Returns full information about a user by their identifier
     *
     * @userId - User identifier
     */
    class GetUserFullInfo(
        val userId: Int = 0
    ) : null()

    /**
     * Returns information about a basic group by its identifier
     * This is an offline request if the current user is not a bot
     *
     * @basicGroupId - Basic group identifier
     */
    class GetBasicGroup(
        val basicGroupId: Int = 0
    ) : null()

    /**
     * Returns full information about a basic group by its identifier
     *
     * @basicGroupId - Basic group identifier
     */
    class GetBasicGroupFullInfo(
        val basicGroupId: Int = 0
    ) : null()

    /**
     * Returns information about a supergroup or channel by its identifier
     * This is an offline request if the current user is not a bot
     *
     * @supergroupId - Supergroup or channel identifier
     */
    class GetSupergroup(
        val supergroupId: Int = 0
    ) : null()

    /**
     * Returns full information about a supergroup or channel by its identifier, cached for up to 1 minute
     *
     * @supergroupId - Supergroup or channel identifier
     */
    class GetSupergroupFullInfo(
        val supergroupId: Int = 0
    ) : null()

    /**
     * Returns information about a secret chat by its identifier
     * This is an offline request
     *
     * @secretChatId - Secret chat identifier
     */
    class GetSecretChat(
        val secretChatId: Int = 0
    ) : null()

    /**
     * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
     *
     * @chatId - Chat identifier
     */
    class GetChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Returns information about a message
     *
     * @chatId - Identifier of the chat the message belongs to
     * @messageId - Identifier of the message to get
     */
    class GetMessage(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Returns information about a message, if it is available locally without sending network request
     * This is an offline request
     *
     * @chatId - Identifier of the chat the message belongs to
     * @messageId - Identifier of the message to get
     */
    class GetMessageLocally(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Returns information about a message that is replied by given message
     *
     * @chatId - Identifier of the chat the message belongs to
     * @messageId - Identifier of the message reply to which get
     */
    class GetRepliedMessage(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Returns information about a pinned chat message
     *
     * @chatId - Identifier of the chat the message belongs to
     */
    class GetChatPinnedMessage(
        val chatId: Long = 0L
    ) : null()

    /**
     * Returns information about messages
     * If a message is not found, returns null on the corresponding position of the result
     *
     * @chatId - Identifier of the chat the messages belong to
     * @messageIds - Identifiers of the messages to get
     */
    class GetMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf()
    ) : null()

    /**
     * Returns information about a file
     * This is an offline request
     *
     * @fileId - Identifier of the file to get
     */
    class GetFile(
        val fileId: Int = 0
    ) : null()

    /**
     * Returns information about a file by its remote ID
     * This is an offline request
     * Can be used to register a URL as a file for further uploading, or sending as a message
     *
     * @remoteFileId - Remote identifier of the file to get
     * @fileType - File type, if known
     */
    class GetRemoteFile(
        val remoteFileId: String? = null,
        val fileType: FileType? = null
    ) : null()

    /**
     * Returns an ordered list of chats
     * Chats are sorted by the pair (order, chat_id) in decreasing order
     * (For example, to get a list of chats from the beginning, the offset_order should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1)
     * For optimal performance the number of returned chats is chosen by the library
     *
     * @offsetOrder - Chat order to return chats from
     * @offsetChatId - Chat identifier to return chats from
     * @limit - The maximum number of chats to be returned
     *          It is possible that fewer chats than the limit are returned even if the end of the list is not reached
     */
    class GetChats(
        val offsetOrder: Long = 0L,
        val offsetChatId: Long = 0L,
        val limit: Int = 0
    ) : null()

    /**
     * Searches a public chat by its username
     * Currently only private chats, supergroups and channels can be public
     * Returns the chat if found
     * Otherwise an error is returned
     *
     * @username - Username to be resolved
     */
    class SearchPublicChat(
        val username: String? = null
    ) : null()

    /**
     * Searches public chats by looking for specified query in their username and title
     * Currently only private chats, supergroups and channels can be public
     * Returns a meaningful number of results
     * Returns nothing if the length of the searched username prefix is less than 5
     * Excludes private chats with contacts and chats from the chat list from the results
     *
     * @query - Query to search for
     */
    class SearchPublicChats(
        val query: String? = null
    ) : null()

    /**
     * Searches for the specified query in the title and username of already known chats, this is an offline request
     * Returns chats in the order seen in the chat list
     *
     * @query - Query to search for
     *          If the query is empty, returns up to 20 recently found chats
     * @limit - Maximum number of chats to be returned
     */
    class SearchChats(
        val query: String? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Searches for the specified query in the title and username of already known chats via request to the server
     * Returns chats in the order seen in the chat list
     *
     * @query - Query to search for
     * @limit - Maximum number of chats to be returned
     */
    class SearchChatsOnServer(
        val query: String? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Returns a list of frequently used chats
     * Supported only if the chat info database is enabled
     *
     * @category - Category of chats to be returned
     * @limit - Maximum number of chats to be returned
     *          Up to 30
     */
    class GetTopChats(
        val category: TopChatCategory? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Removes a chat from the list of frequently used chats
     * Supported only if the chat info database is enabled
     *
     * @category - Category of frequently used chats
     * @chatId - Chat identifier
     */
    class RemoveTopChat(
        val category: TopChatCategory? = null,
        val chatId: Long = 0L
    ) : null()

    /**
     * Adds a chat to the list of recently found chats
     * The chat is added to the beginning of the list
     * If the chat is already in the list, it will be removed from the list first
     *
     * @chatId - Identifier of the chat to add
     */
    class AddRecentlyFoundChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Removes a chat from the list of recently found chats
     *
     * @chatId - Identifier of the chat to be removed
     */
    class RemoveRecentlyFoundChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Clears the list of recently found chats
     */
    class ClearRecentlyFoundChats : null()

    /**
     * Checks whether a username can be set for a chat
     *
     * @chatId - Chat identifier
     *           Should be identifier of a supergroup chat, or a channel chat, or a private chat with self, or zero if chat is being created
     * @username - Username to be checked
     */
    class CheckChatUsername(
        val chatId: Long = 0L,
        val username: String? = null
    ) : null()

    /**
     * Returns a list of public chats with username created by the user
     */
    class GetCreatedPublicChats : null()

    /**
     * Returns a list of common group chats with a given user
     * Chats are sorted by their type and creation date
     *
     * @userId - User identifier
     * @offsetChatId - Chat identifier starting from which to return chats
     *                 Use 0 for the first request
     * @limit - Maximum number of chats to be returned
     */
    class GetGroupsInCommon(
        val userId: Int = 0,
        val offsetChatId: Long = 0L,
        val limit: Int = 0
    ) : null()

    /**
     * Returns messages in a chat
     * The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
     * For optimal performance the number of returned messages is chosen by the library
     * This is an offline request if only_local is true
     *
     * @chatId - Chat identifier
     * @fromMessageId - Identifier of the message starting from which history must be fetched
     *                  Use 0 to get results from the last message
     * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset up to 99 to get additionally some newer messages
     * @limit - The maximum number of messages to be returned
     *          Must be positive and can't be greater than 100
     *          If the offset is negative, the limit must be greater or equal to -offset
     *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @onlyLocal - If true, returns only messages that are available locally without sending network requests
     */
    class GetChatHistory(
        val chatId: Long = 0L,
        val fromMessageId: Long = 0L,
        val offset: Int = 0,
        val limit: Int = 0,
        val onlyLocal: Boolean = false
    ) : null()

    /**
     * Deletes all messages in the chat
     * Use Chat.can_be_deleted_only_for_self and Chat.can_be_deleted_for_all_users fields to find whether and how the method can be applied to the chat
     *
     * @chatId - Chat identifier
     * @removeFromChatList - Pass true if the chat should be removed from the chat list
     * @revoke - Pass true to try to delete chat history for all users
     */
    class DeleteChatHistory(
        val chatId: Long = 0L,
        val removeFromChatList: Boolean = false,
        val revoke: Boolean = false
    ) : null()

    /**
     * Searches for messages with given words in the chat
     * Returns the results in reverse chronological order, i.e
     * In order of decreasing message_id
     * Cannot be used in secret chats with a non-empty query (searchSecretMessages should be used instead), or without an enabled message database
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @chatId - Identifier of the chat in which to search messages
     * @query - Query to search for
     * @senderUserId - If not 0, only messages sent by the specified user will be returned
     *                 Not supported in secret chats
     * @fromMessageId - Identifier of the message starting from which history must be fetched
     *                  Use 0 to get results from the last message
     * @offset - Specify 0 to get results from exactly the from_message_id or a negative offset to get the specified message and some newer messages
     * @limit - The maximum number of messages to be returned
     *          Must be positive and can't be greater than 100
     *          If the offset is negative, the limit must be greater than -offset
     *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @filter - Filter for message content in the search results
     */
    class SearchChatMessages(
        val chatId: Long = 0L,
        val query: String? = null,
        val senderUserId: Int = 0,
        val fromMessageId: Long = 0L,
        val offset: Int = 0,
        val limit: Int = 0,
        val filter: SearchMessagesFilter? = null
    ) : null()

    /**
     * Searches for messages in all chats except secret chats
     * Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id))
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @query - Query to search for
     * @offsetDate - The date of the message starting from which the results should be fetched
     *               Use 0 or any date in the future to get results from the last message
     * @offsetChatId - The chat identifier of the last found message, or 0 for the first request
     * @offsetMessageId - The message identifier of the last found message, or 0 for the first request
     * @limit - The maximum number of messages to be returned, up to 100
     *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     */
    class SearchMessages(
        val query: String? = null,
        val offsetDate: Int = 0,
        val offsetChatId: Long = 0L,
        val offsetMessageId: Long = 0L,
        val limit: Int = 0
    ) : null()

    /**
     * Searches for messages in secret chats
     * Returns the results in reverse chronological order
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @chatId - Identifier of the chat in which to search
     *           Specify 0 to search in all secret chats
     * @query - Query to search for
     *          If empty, searchChatMessages should be used instead
     * @fromSearchId - The identifier from the result of a previous request, use 0 to get results from the last message
     * @limit - Maximum number of messages to be returned
     *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @filter - A filter for the content of messages in the search results
     */
    class SearchSecretMessages(
        val chatId: Long = 0L,
        val query: String? = null,
        val fromSearchId: Long = 0L,
        val limit: Int = 0,
        val filter: SearchMessagesFilter? = null
    ) : null()

    /**
     * Searches for call messages
     * Returns the results in reverse chronological order (i
     * E., in order of decreasing message_id)
     * For optimal performance the number of returned messages is chosen by the library
     *
     * @fromMessageId - Identifier of the message from which to search
     *                  Use 0 to get results from the last message
     * @limit - The maximum number of messages to be returned
     *          Fewer messages may be returned than specified by the limit, even if the end of the message history has not been reached
     * @onlyMissed - If true, returns only messages with missed calls
     */
    class SearchCallMessages(
        val fromMessageId: Long = 0L,
        val limit: Int = 0,
        val onlyMissed: Boolean = false
    ) : null()

    /**
     * Returns information about the recent locations of chat members that were sent to the chat
     * Returns up to 1 location message per user
     *
     * @chatId - Chat identifier
     * @limit - Maximum number of messages to be returned
     */
    class SearchChatRecentLocationMessages(
        val chatId: Long = 0L,
        val limit: Int = 0
    ) : null()

    /**
     * Returns all active live locations that should be updated by the client
     * The list is persistent across application restarts only if the message database is used
     */
    class GetActiveLiveLocationMessages : null()

    /**
     * Returns the last message sent in a chat no later than the specified date
     *
     * @chatId - Chat identifier
     * @date - Point in time (Unix timestamp) relative to which to search for messages
     */
    class GetChatMessageByDate(
        val chatId: Long = 0L,
        val date: Int = 0
    ) : null()

    /**
     * Returns approximate number of messages of the specified type in the chat
     *
     * @chatId - Identifier of the chat in which to count messages
     * @filter - Filter for message content
     *           SearchMessagesFilterEmpty is unsupported in this function
     * @returnLocal - If true, returns count that is available locally without sending network requests, returning -1 if the number of messages is unknown
     */
    class GetChatMessageCount(
        val chatId: Long = 0L,
        val filter: SearchMessagesFilter? = null,
        val returnLocal: Boolean = false
    ) : null()

    /**
     * Removes an active notification from notification list
     * Needs to be called only if the notification is removed by the current user
     *
     * @notificationGroupId - Identifier of notification group to which the notification belongs
     * @notificationId - Identifier of removed notification
     */
    class RemoveNotification(
        val notificationGroupId: Int = 0,
        val notificationId: Int = 0
    ) : null()

    /**
     * Removes a group of active notifications
     * Needs to be called only if the notification group is removed by the current user
     *
     * @notificationGroupId - Notification group identifier
     * @maxNotificationId - Maximum identifier of removed notifications
     */
    class RemoveNotificationGroup(
        val notificationGroupId: Int = 0,
        val maxNotificationId: Int = 0
    ) : null()

    /**
     * Returns a public HTTPS link to a message
     * Available only for messages in supergroups and channels with username
     *
     * @chatId - Identifier of the chat to which the message belongs
     * @messageId - Identifier of the message
     * @forAlbum - Pass true if a link for a whole media album should be returned
     */
    class GetPublicMessageLink(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val forAlbum: Boolean = false
    ) : null()

    /**
     * Returns a private HTTPS link to a message in a chat
     * Available only for already sent messages in supergroups and channels
     * The link will work only for members of the chat
     *
     * @chatId - Identifier of the chat to which the message belongs
     * @messageId - Identifier of the message
     */
    class GetMessageLink(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Returns information about a public or private message link
     *
     * @url - The message link in the format "https://t.me/c/...", or "tg://privatepost?...", or "https://t.me/username/...", or "tg://resolve?..."
     */
    class GetMessageLinkInfo(
        val url: String? = null
    ) : null()

    /**
     * Sends a message
     * Returns the sent message
     *
     * @chatId - Target chat
     * @replyToMessageId - Identifier of the message to reply to or 0
     * @disableNotification - Pass true to disable notification for the message
     *                        Not supported in secret chats
     * @fromBackground - Pass true if the message is sent from the background
     * @replyMarkup - Markup for replying to the message
     * @inputMessageContent - The content of the message to be sent
     */
    class SendMessage(
        val chatId: Long = 0L,
        val replyToMessageId: Long = 0L,
        val disableNotification: Boolean = false,
        val fromBackground: Boolean = false,
        @BotsOnly val replyMarkup: ReplyMarkup? = null,
        val inputMessageContent: InputMessageContent? = null
    ) : null()

    /**
     * Sends messages grouped together into an album
     * Currently only photo and video messages can be grouped into an album
     * Returns sent messages
     *
     * @chatId - Target chat
     * @replyToMessageId - Identifier of a message to reply to or 0
     * @disableNotification - Pass true to disable notification for the messages
     *                        Not supported in secret chats
     * @fromBackground - Pass true if the messages are sent from the background
     * @inputMessageContents - Contents of messages to be sent
     */
    class SendMessageAlbum(
        val chatId: Long = 0L,
        val replyToMessageId: Long = 0L,
        val disableNotification: Boolean = false,
        val fromBackground: Boolean = false,
        val inputMessageContents: Array<InputMessageContent> = emptyArray()
    ) : null()

    /**
     * Invites a bot to a chat (if it is not yet a member) and sends it the /start command
     * Bots can't be invited to a private chat other than the chat with the bot
     * Bots can't be invited to channels (although they can be added as admins) and secret chats
     * Returns the sent message
     *
     * @botUserId - Identifier of the bot
     * @chatId - Identifier of the target chat
     * @parameter - A hidden parameter sent to the bot for deep linking purposes (https://core.telegram.org/bots#deep-linking)
     */
    class SendBotStartMessage(
        val botUserId: Int = 0,
        val chatId: Long = 0L,
        val parameter: String? = null
    ) : null()

    /**
     * Sends the result of an inline query as a message
     * Returns the sent message
     * Always clears a chat draft message
     *
     * @chatId - Target chat
     * @replyToMessageId - Identifier of a message to reply to or 0
     * @disableNotification - Pass true to disable notification for the message
     *                        Not supported in secret chats
     * @fromBackground - Pass true if the message is sent from background
     * @queryId - Identifier of the inline query
     * @resultId - Identifier of the inline result
     * @hideViaBot - If true, there will be no mention of a bot, via which the message is sent
     *               Can be used only for bots GetOption("animation_search_bot_username"), GetOption("photo_search_bot_username") and GetOption("venue_search_bot_username")
     */
    class SendInlineQueryResultMessage(
        val chatId: Long = 0L,
        val replyToMessageId: Long = 0L,
        val disableNotification: Boolean = false,
        val fromBackground: Boolean = false,
        val queryId: Long = 0L,
        val resultId: String? = null,
        val hideViaBot: Boolean = false
    ) : null()

    /**
     * Forwards previously sent messages
     * Returns the forwarded messages in the same order as the message identifiers passed in message_ids
     * If a message can't be forwarded, null will be returned instead of the message
     *
     * @chatId - Identifier of the chat to which to forward messages
     * @fromChatId - Identifier of the chat from which to forward messages
     * @messageIds - Identifiers of the messages to forward
     * @disableNotification - Pass true to disable notification for the message, doesn't work if messages are forwarded to a secret chat
     * @fromBackground - Pass true if the messages are sent from the background
     * @asAlbum - True, if the messages should be grouped into an album after forwarding
     *            For this to work, no more than 10 messages may be forwarded, and all of them must be photo or video messages
     * @sendCopy - True, if content of the messages needs to be copied without links to the original messages
     *             Always true if the messages are forwarded to a secret chat
     * @removeCaption - True, if media captions of message copies needs to be removed
     *                  Ignored if send_copy is false
     */
    class ForwardMessages(
        val chatId: Long = 0L,
        val fromChatId: Long = 0L,
        val messageIds: LongArray = longArrayOf(),
        val disableNotification: Boolean = false,
        val fromBackground: Boolean = false,
        val asAlbum: Boolean = false,
        val sendCopy: Boolean = false,
        val removeCaption: Boolean = false
    ) : null()

    /**
     * Resends messages which failed to send
     * Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed
     * If a message is re-sent, the corresponding failed to send message is deleted
     * Returns the sent messages in the same order as the message identifiers passed in message_ids
     * If a message can't be re-sent, null will be returned instead of the message
     *
     * @chatId - Identifier of the chat to send messages
     * @messageIds - Identifiers of the messages to resend
     *               Message identifiers must be in a strictly increasing order
     */
    class ResendMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf()
    ) : null()

    /**
     * Changes the current TTL setting (sets a new self-destruct timer) in a secret chat and sends the corresponding message
     *
     * @chatId - Chat identifier
     * @ttl - New TTL value, in seconds
     */
    class SendChatSetTtlMessage(
        val chatId: Long = 0L,
        val ttl: Int = 0
    ) : null()

    /**
     * Sends a notification about a screenshot taken in a chat
     * Supported only in private and secret chats
     *
     * @chatId - Chat identifier
     */
    class SendChatScreenshotTakenNotification(
        val chatId: Long = 0L
    ) : null()

    /**
     * Adds a local message to a chat
     * The message is persistent across application restarts only if the message database is used
     * Returns the added message
     *
     * @chatId - Target chat
     * @senderUserId - Identifier of the user who will be shown as the sender of the message
     *                 May be 0 for channel posts
     * @replyToMessageId - Identifier of the message to reply to or 0
     * @disableNotification - Pass true to disable notification for the message
     * @inputMessageContent - The content of the message to be added
     */
    class AddLocalMessage(
        val chatId: Long = 0L,
        val senderUserId: Int = 0,
        val replyToMessageId: Long = 0L,
        val disableNotification: Boolean = false,
        val inputMessageContent: InputMessageContent? = null
    ) : null()

    /**
     * Deletes messages
     *
     * @chatId - Chat identifier
     * @messageIds - Identifiers of the messages to be deleted
     * @revoke - Pass true to try to delete messages for all chat members
     *           Always true for supergroups, channels and secret chats
     */
    class DeleteMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf(),
        val revoke: Boolean = false
    ) : null()

    /**
     * Deletes all messages sent by the specified user to a chat
     * Supported only in supergroups
     * Requires can_delete_messages administrator privileges
     *
     * @chatId - Chat identifier
     * @userId - User identifier
     */
    class DeleteChatMessagesFromUser(
        val chatId: Long = 0L,
        val userId: Int = 0
    ) : null()

    /**
     * Edits the text of a message (or a text of a game message)
     * Returns the edited message after the edit is completed on the server side
     *
     * @chatId - The chat the message belongs to
     * @messageId - Identifier of the message
     * @replyMarkup - The new message reply markup
     * @inputMessageContent - New text content of the message
     *                        Should be of type InputMessageText
     */
    class EditMessageText(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        @BotsOnly val replyMarkup: ReplyMarkup? = null,
        val inputMessageContent: InputMessageContent? = null
    ) : null()

    /**
     * Edits the message content of a live location
     * Messages can be edited for a limited period of time specified in the live location
     * Returns the edited message after the edit is completed on the server side
     *
     * @chatId - The chat the message belongs to
     * @messageId - Identifier of the message
     * @replyMarkup - The new message reply markup
     * @location - New location content of the message
     *             Pass null to stop sharing the live location
     */
    class EditMessageLiveLocation(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        @BotsOnly val replyMarkup: ReplyMarkup? = null,
        val location: Location? = null
    ) : null()

    /**
     * Edits the content of a message with an animation, an audio, a document, a photo or a video
     * The media in the message can't be replaced if the message was set to self-destruct
     * Media can't be replaced by self-destructing media
     * Media in an album can be edited only to contain a photo or a video
     * Returns the edited message after the edit is completed on the server side
     *
     * @chatId - The chat the message belongs to
     * @messageId - Identifier of the message
     * @replyMarkup - The new message reply markup
     * @inputMessageContent - New content of the message
     *                        Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
     */
    class EditMessageMedia(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        @BotsOnly val replyMarkup: ReplyMarkup? = null,
        val inputMessageContent: InputMessageContent? = null
    ) : null()

    /**
     * Edits the message content caption
     * Returns the edited message after the edit is completed on the server side
     *
     * @chatId - The chat the message belongs to
     * @messageId - Identifier of the message
     * @replyMarkup - The new message reply markup
     * @caption - New message content caption
     *            0-GetOption("message_caption_length_max") characters
     */
    class EditMessageCaption(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        @BotsOnly val replyMarkup: ReplyMarkup? = null,
        val caption: FormattedText? = null
    ) : null()

    /**
     * Edits the message reply markup
     * Returns the edited message after the edit is completed on the server side
     *
     * @chatId - The chat the message belongs to
     * @messageId - Identifier of the message
     * @replyMarkup - The new message reply markup
     */
    @BotsOnly
    class EditMessageReplyMarkup(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val replyMarkup: ReplyMarkup? = null
    ) : null()

    /**
     * Edits the text of an inline text or game message sent via a bot
     *
     * @inlineMessageId - Inline message identifier
     * @replyMarkup - The new message reply markup
     * @inputMessageContent - New text content of the message
     *                        Should be of type InputMessageText
     */
    @BotsOnly
    class EditInlineMessageText(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null,
        val inputMessageContent: InputMessageContent? = null
    ) : null()

    /**
     * Edits the content of a live location in an inline message sent via a bot
     *
     * @inlineMessageId - Inline message identifier
     * @replyMarkup - The new message reply markup
     * @location - New location content of the message
     *             Pass null to stop sharing the live location
     */
    @BotsOnly
    class EditInlineMessageLiveLocation(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null,
        val location: Location? = null
    ) : null()

    /**
     * Edits the content of a message with an animation, an audio, a document, a photo or a video in an inline message sent via a bot
     *
     * @inlineMessageId - Inline message identifier
     * @replyMarkup - The new message reply markup
     * @inputMessageContent - New content of the message
     *                        Must be one of the following types: InputMessageAnimation, InputMessageAudio, InputMessageDocument, InputMessagePhoto or InputMessageVideo
     */
    @BotsOnly
    class EditInlineMessageMedia(
        val inlineMessageId: String? = null,
        @BotsOnly val replyMarkup: ReplyMarkup? = null,
        val inputMessageContent: InputMessageContent? = null
    ) : null()

    /**
     * Edits the caption of an inline message sent via a bot
     *
     * @inlineMessageId - Inline message identifier
     * @replyMarkup - The new message reply markup
     * @caption - New message content caption
     *            0-GetOption("message_caption_length_max") characters
     */
    @BotsOnly
    class EditInlineMessageCaption(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null,
        val caption: FormattedText? = null
    ) : null()

    /**
     * Edits the reply markup of an inline message sent via a bot
     *
     * @inlineMessageId - Inline message identifier
     * @replyMarkup - The new message reply markup
     */
    @BotsOnly
    class EditInlineMessageReplyMarkup(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null
    ) : null()

    /**
     * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
     * This is an offline method
     * Can be called before authorization
     *
     * @text - The text in which to look for entites
     */
    class GetTextEntities(
        val text: String? = null
    ) : null()

    /**
     * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
     * This is an offline method
     * Can be called before authorization
     *
     * @text - The text which should be parsed
     * @parseMode - Text parse mode
     */
    class ParseTextEntities(
        val text: String? = null,
        val parseMode: TextParseMode? = null
    ) : null()

    /**
     * Returns the MIME type of a file, guessed by its extension
     * Returns an empty string on failure
     * This is an offline method
     * Can be called before authorization
     *
     * @fileName - The name of the file or path to the file
     */
    class GetFileMimeType(
        val fileName: String? = null
    ) : null()

    /**
     * Returns the extension of a file, guessed by its MIME type
     * Returns an empty string on failure
     * This is an offline method
     * Can be called before authorization
     *
     * @mimeType - The MIME type of the file
     */
    class GetFileExtension(
        val mimeType: String? = null
    ) : null()

    /**
     * Removes potentially dangerous characters from the name of a file
     * The encoding of the file name is supposed to be UTF-8
     * Returns an empty string on failure
     * This is an offline method
     * Can be called before authorization
     *
     * @fileName - File name or path to the file
     */
    class CleanFileName(
        val fileName: String? = null
    ) : null()

    /**
     * Returns a string stored in the local database from the specified localization target and language pack by its key
     * Returns a 404 error if the string is not found
     * This is an offline method
     * Can be called before authorization
     *
     * @languagePackDatabasePath - Path to the language pack database in which strings are stored
     * @localizationTarget - Localization target to which the language pack belongs
     * @languagePackId - Language pack identifier
     * @key - Language pack key of the string to be returned
     */
    class GetLanguagePackString(
        val languagePackDatabasePath: String? = null,
        val localizationTarget: String? = null,
        val languagePackId: String? = null,
        val key: String? = null
    ) : null()

    /**
     * Converts a JSON-serialized string to corresponding JsonValue object
     * This is an offline method
     * Can be called before authorization
     *
     * @json - The JSON-serialized string
     */
    class GetJsonValue(
        val json: String? = null
    ) : null()

    /**
     * Converts a JsonValue object to corresponding JSON-serialized string
     * This is an offline method
     * Can be called before authorization
     *
     * @jsonValue - The JsonValue object
     */
    class GetJsonString(
        val jsonValue: JsonValue? = null
    ) : null()

    /**
     * Changes user answer to a poll
     *
     * @chatId - Identifier of the chat to which the poll belongs
     * @messageId - Identifier of the message containing the poll
     * @optionIds - 0-based identifiers of options, chosen by the user
     *              Currently user can't choose more than 1 option
     */
    class SetPollAnswer(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val optionIds: IntArray = intArrayOf()
    ) : null()

    /**
     * Stops a poll
     * A poll in a message can be stopped when the message has can_be_edited flag set
     *
     * @chatId - Identifier of the chat to which the poll belongs
     * @messageId - Identifier of the message containing the poll
     * @replyMarkup - The new message reply markup
     */
    class StopPoll(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        @BotsOnly val replyMarkup: ReplyMarkup? = null
    ) : null()

    /**
     * Sends an inline query to a bot and returns its results
     * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
     *
     * @botUserId - The identifier of the target bot
     * @chatId - Identifier of the chat, where the query was sent
     * @userLocation - Location of the user, only if needed
     * @query - Text of the query
     * @offset - Offset of the first entry to return
     */
    class GetInlineQueryResults(
        val botUserId: Int = 0,
        val chatId: Long = 0L,
        val userLocation: Location? = null,
        val query: String? = null,
        val offset: String? = null
    ) : null()

    /**
     * Sets the result of an inline query
     *
     * @inlineQueryId - Identifier of the inline query
     * @isPersonal - True, if the result of the query can be cached for the specified user
     * @results - The results of the query
     * @cacheTime - Allowed time to cache the results of the query, in seconds
     * @nextOffset - Offset for the next inline query
     *               Pass an empty string if there are no more results
     * @switchPmText - If non-empty, this text should be shown on the button that opens a private chat with the bot and sends a start message to the bot with the parameter switch_pm_parameter
     * @switchPmParameter - The parameter for the bot start message
     */
    @BotsOnly
    class AnswerInlineQuery(
        val inlineQueryId: Long = 0L,
        val isPersonal: Boolean = false,
        val results: Array<InputInlineQueryResult> = emptyArray(),
        val cacheTime: Int = 0,
        val nextOffset: String? = null,
        val switchPmText: String? = null,
        val switchPmParameter: String? = null
    ) : null()

    /**
     * Sends a callback query to a bot and returns an answer
     * Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
     *
     * @chatId - Identifier of the chat with the message
     * @messageId - Identifier of the message from which the query originated
     * @payload - Query payload
     */
    class GetCallbackQueryAnswer(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val payload: CallbackQueryPayload? = null
    ) : null()

    /**
     * Sets the result of a callback query
     *
     * @callbackQueryId - Identifier of the callback query
     * @text - Text of the answer
     * @showAlert - If true, an alert should be shown to the user instead of a toast notification
     * @url - URL to be opened
     * @cacheTime - Time during which the result of the query can be cached, in seconds
     */
    @BotsOnly
    class AnswerCallbackQuery(
        val callbackQueryId: Long = 0L,
        val text: String? = null,
        val showAlert: Boolean = false,
        val url: String? = null,
        val cacheTime: Int = 0
    ) : null()

    /**
     * Sets the result of a shipping query
     *
     * @shippingQueryId - Identifier of the shipping query
     * @shippingOptions - Available shipping options
     * @errorMessage - An error message, empty on success
     */
    @BotsOnly
    class AnswerShippingQuery(
        val shippingQueryId: Long = 0L,
        val shippingOptions: Array<ShippingOption> = emptyArray(),
        val errorMessage: String? = null
    ) : null()

    /**
     * Sets the result of a pre-checkout query
     *
     * @preCheckoutQueryId - Identifier of the pre-checkout query
     * @errorMessage - An error message, empty on success
     */
    @BotsOnly
    class AnswerPreCheckoutQuery(
        val preCheckoutQueryId: Long = 0L,
        val errorMessage: String? = null
    ) : null()

    /**
     * Updates the game score of the specified user in the game
     *
     * @chatId - The chat to which the message with the game belongs
     * @messageId - Identifier of the message
     * @editMessage - True, if the message should be edited
     * @userId - User identifier
     * @score - The new score
     * @force - Pass true to update the score even if it decreases
     *          If the score is 0, the user will be deleted from the high score table
     */
    @BotsOnly
    class SetGameScore(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val editMessage: Boolean = false,
        val userId: Int = 0,
        val score: Int = 0,
        val force: Boolean = false
    ) : null()

    /**
     * Updates the game score of the specified user in a game
     *
     * @inlineMessageId - Inline message identifier
     * @editMessage - True, if the message should be edited
     * @userId - User identifier
     * @score - The new score
     * @force - Pass true to update the score even if it decreases
     *          If the score is 0, the user will be deleted from the high score table
     */
    @BotsOnly
    class SetInlineGameScore(
        val inlineMessageId: String? = null,
        val editMessage: Boolean = false,
        val userId: Int = 0,
        val score: Int = 0,
        val force: Boolean = false
    ) : null()

    /**
     * Returns the high scores for a game and some part of the high score table in the range of the specified user
     *
     * @chatId - The chat that contains the message with the game
     * @messageId - Identifier of the message
     * @userId - User identifier
     */
    @BotsOnly
    class GetGameHighScores(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val userId: Int = 0
    ) : null()

    /**
     * Returns game high scores and some part of the high score table in the range of the specified user
     *
     * @inlineMessageId - Inline message identifier
     * @userId - User identifier
     */
    @BotsOnly
    class GetInlineGameHighScores(
        val inlineMessageId: String? = null,
        val userId: Int = 0
    ) : null()

    /**
     * Deletes the default reply markup from a chat
     * Must be called after a one-time keyboard or a ForceReply reply markup has been used
     * UpdateChatReplyMarkup will be sent if the reply markup will be changed
     *
     * @chatId - Chat identifier
     * @messageId - The message identifier of the used keyboard
     */
    class DeleteChatReplyMarkup(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Sends a notification about user activity in a chat
     *
     * @chatId - Chat identifier
     * @action - The action description
     */
    class SendChatAction(
        val chatId: Long = 0L,
        val action: ChatAction? = null
    ) : null()

    /**
     * Informs TDLib that the chat is opened by the user
     * Many useful activities depend on the chat being opened or closed (e.g., in supergroups and channels all updates are received only for opened chats)
     *
     * @chatId - Chat identifier
     */
    class OpenChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Informs TDLib that the chat is closed by the user
     * Many useful activities depend on the chat being opened or closed
     *
     * @chatId - Chat identifier
     */
    class CloseChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Informs TDLib that messages are being viewed by the user
     * Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
     *
     * @chatId - Chat identifier
     * @messageIds - The identifiers of the messages being viewed
     * @forceRead - True, if messages in closed chats should be marked as read
     */
    class ViewMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf(),
        val forceRead: Boolean = false
    ) : null()

    /**
     * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message)
     * An updateMessageContentOpened update will be generated if something has changed
     *
     * @chatId - Chat identifier of the message
     * @messageId - Identifier of the message with the opened content
     */
    class OpenMessageContent(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Marks all mentions in a chat as read
     *
     * @chatId - Chat identifier
     */
    class ReadAllChatMentions(
        val chatId: Long = 0L
    ) : null()

    /**
     * Returns an existing chat corresponding to a given user
     *
     * @userId - User identifier
     * @force - If true, the chat will be created without network request
     *          In this case all information about the chat except its type, title and photo can be incorrect
     */
    class CreatePrivateChat(
        val userId: Int = 0,
        val force: Boolean = false
    ) : null()

    /**
     * Returns an existing chat corresponding to a known basic group
     *
     * @basicGroupId - Basic group identifier
     * @force - If true, the chat will be created without network request
     *          In this case all information about the chat except its type, title and photo can be incorrect
     */
    class CreateBasicGroupChat(
        val basicGroupId: Int = 0,
        val force: Boolean = false
    ) : null()

    /**
     * Returns an existing chat corresponding to a known supergroup or channel
     *
     * @supergroupId - Supergroup or channel identifier
     * @force - If true, the chat will be created without network request
     *          In this case all information about the chat except its type, title and photo can be incorrect
     */
    class CreateSupergroupChat(
        val supergroupId: Int = 0,
        val force: Boolean = false
    ) : null()

    /**
     * Returns an existing chat corresponding to a known secret chat
     *
     * @secretChatId - Secret chat identifier
     */
    class CreateSecretChat(
        val secretChatId: Int = 0
    ) : null()

    /**
     * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate
     * Returns the newly created chat
     *
     * @userIds - Identifiers of users to be added to the basic group
     * @title - Title of the new basic group
     */
    class CreateNewBasicGroupChat(
        val userIds: IntArray = intArrayOf(),
        val title: String? = null
    ) : null()

    /**
     * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate
     * Returns the newly created chat
     *
     * @title - Title of the new chat
     * @isChannel - True, if a channel chat should be created
     * @description - Chat description
     */
    class CreateNewSupergroupChat(
        val title: String? = null,
        val isChannel: Boolean = false,
        val description: String? = null
    ) : null()

    /**
     * Creates a new secret chat
     * Returns the newly created chat
     *
     * @userId - Identifier of the target user
     */
    class CreateNewSecretChat(
        val userId: Int = 0
    ) : null()

    /**
     * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom
     * Requires creator privileges
     * Deactivates the original basic group
     *
     * @chatId - Identifier of the chat to upgrade
     */
    class UpgradeBasicGroupChatToSupergroupChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Changes the chat title
     * Supported only for basic groups, supergroups and channels
     * Requires can_change_info rights
     * The title will not be changed until the request to the server has been completed
     *
     * @chatId - Chat identifier
     * @title - New title of the chat
     */
    class SetChatTitle(
        val chatId: Long = 0L,
        val title: String? = null
    ) : null()

    /**
     * Changes the photo of a chat
     * Supported only for basic groups, supergroups and channels
     * Requires can_change_info rights
     * The photo will not be changed before request to the server has been completed
     *
     * @chatId - Chat identifier
     * @photo - New chat photo
     *          You can use a zero InputFileId to delete the chat photo
     *          Files that are accessible only by HTTP URL are not acceptable
     */
    class SetChatPhoto(
        val chatId: Long = 0L,
        val photo: InputFile? = null
    ) : null()

    /**
     * Changes the chat members permissions
     * Supported only for basic groups and supergroups
     * Requires can_restrict_members administrator right
     *
     * @chatId - Chat identifier
     * @permissions - New non-administrator members permissions in the chat
     */
    class SetChatPermissions(
        val chatId: Long = 0L,
        val permissions: ChatPermissions? = null
    ) : null()

    /**
     * Changes the draft message in a chat
     *
     * @chatId - Chat identifier
     * @draftMessage - New draft message
     */
    class SetChatDraftMessage(
        val chatId: Long = 0L,
        val draftMessage: DraftMessage? = null
    ) : null()

    /**
     * Changes the notification settings of a chat
     *
     * @chatId - Chat identifier
     * @notificationSettings - New notification settings for the chat
     */
    class SetChatNotificationSettings(
        val chatId: Long = 0L,
        val notificationSettings: ChatNotificationSettings? = null
    ) : null()

    /**
     * Changes the pinned state of a chat
     * You can pin up to GetOption("pinned_chat_count_max") non-secret chats and the same number of secret chats
     *
     * @chatId - Chat identifier
     * @isPinned - New value of is_pinned
     */
    class ToggleChatIsPinned(
        val chatId: Long = 0L,
        val isPinned: Boolean = false
    ) : null()

    /**
     * Changes the marked as unread state of a chat
     *
     * @chatId - Chat identifier
     * @isMarkedAsUnread - New value of is_marked_as_unread
     */
    class ToggleChatIsMarkedAsUnread(
        val chatId: Long = 0L,
        val isMarkedAsUnread: Boolean = false
    ) : null()

    /**
     * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
     *
     * @chatId - Chat identifier
     * @defaultDisableNotification - New value of default_disable_notification
     */
    class ToggleChatDefaultDisableNotification(
        val chatId: Long = 0L,
        val defaultDisableNotification: Boolean = false
    ) : null()

    /**
     * Changes client data associated with a chat
     *
     * @chatId - Chat identifier
     * @clientData - New value of client_data
     */
    class SetChatClientData(
        val chatId: Long = 0L,
        val clientData: String? = null
    ) : null()

    /**
     * Changes information about a chat
     * Available for basic groups, supergroups, and channels
     * Requires can_change_info rights
     *
     * @chatId - Identifier of the chat
     * @description - New chat description
     */
    class SetChatDescription(
        val chatId: Long = 0L,
        val description: String? = null
    ) : null()

    /**
     * Pins a message in a chat
     * Requires can_pin_messages rights
     *
     * @chatId - Identifier of the chat
     * @messageId - Identifier of the new pinned message
     * @disableNotification - True, if there should be no notification about the pinned message
     */
    class PinChatMessage(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val disableNotification: Boolean = false
    ) : null()

    /**
     * Removes the pinned message from a chat
     * Requires can_pin_messages rights in the group or channel
     *
     * @chatId - Identifier of the chat
     */
    class UnpinChatMessage(
        val chatId: Long = 0L
    ) : null()

    /**
     * Adds current user as a new member to a chat
     * Private and secret chats can't be joined using this method
     *
     * @chatId - Chat identifier
     */
    class JoinChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Removes current user from chat members
     * Private and secret chats can't be left using this method
     *
     * @chatId - Chat identifier
     */
    class LeaveChat(
        val chatId: Long = 0L
    ) : null()

    /**
     * Adds a new member to a chat
     * Members can't be added to private or secret chats
     * Members will not be added until the chat state has been synchronized with the server
     *
     * @chatId - Chat identifier
     * @userId - Identifier of the user
     * @forwardLimit - The number of earlier messages from the chat to be forwarded to the new member
     *                 Ignored for supergroups and channels
     */
    class AddChatMember(
        val chatId: Long = 0L,
        val userId: Int = 0,
        val forwardLimit: Int = 0
    ) : null()

    /**
     * Adds multiple new members to a chat
     * Currently this option is only available for supergroups and channels
     * This option can't be used to join a chat
     * Members can't be added to a channel if it has more than 200 members
     * Members will not be added until the chat state has been synchronized with the server
     *
     * @chatId - Chat identifier
     * @userIds - Identifiers of the users to be added to the chat
     */
    class AddChatMembers(
        val chatId: Long = 0L,
        val userIds: IntArray = intArrayOf()
    ) : null()

    /**
     * Changes the status of a chat member, needs appropriate privileges
     * This function is currently not suitable for adding new members to the chat
     * Instead, use addChatMember
     * The chat member status will not be changed until it has been synchronized with the server
     *
     * @chatId - Chat identifier
     * @userId - User identifier
     * @status - The new status of the member in the chat
     */
    class SetChatMemberStatus(
        val chatId: Long = 0L,
        val userId: Int = 0,
        val status: ChatMemberStatus? = null
    ) : null()

    /**
     * Returns information about a single member of a chat
     *
     * @chatId - Chat identifier
     * @userId - User identifier
     */
    class GetChatMember(
        val chatId: Long = 0L,
        val userId: Int = 0
    ) : null()

    /**
     * Searches for a specified query in the first name, last name and username of the members of a specified chat
     * Requires administrator rights in channels
     *
     * @chatId - Chat identifier
     * @query - Query to search for
     * @limit - The maximum number of users to be returned
     * @filter - The type of users to return
     *           By default, chatMembersFilterMembers
     */
    class SearchChatMembers(
        val chatId: Long = 0L,
        val query: String? = null,
        val limit: Int = 0,
        val filter: ChatMembersFilter? = null
    ) : null()

    /**
     * Returns a list of users who are administrators of the chat
     *
     * @chatId - Chat identifier
     */
    class GetChatAdministrators(
        val chatId: Long = 0L
    ) : null()

    /**
     * Clears draft messages in all chats
     *
     * @excludeSecretChats - If true, local draft messages in secret chats will not be cleared
     */
    class ClearAllDraftMessages(
        val excludeSecretChats: Boolean = false
    ) : null()

    /**
     * Returns list of chats with non-default notification settings
     *
     * @scope - If specified, only chats from the specified scope will be returned
     * @compareSound - If true, also chats with non-default sound will be returned
     */
    class GetChatNotificationSettingsExceptions(
        val scope: NotificationSettingsScope? = null,
        val compareSound: Boolean = false
    ) : null()

    /**
     * Returns the notification settings for chats of a given type
     *
     * @scope - Types of chats for which to return the notification settings information
     */
    class GetScopeNotificationSettings(
        val scope: NotificationSettingsScope? = null
    ) : null()

    /**
     * Changes notification settings for chats of a given type
     *
     * @scope - Types of chats for which to change the notification settings
     * @notificationSettings - The new notification settings for the given scope
     */
    class SetScopeNotificationSettings(
        val scope: NotificationSettingsScope? = null,
        val notificationSettings: ScopeNotificationSettings? = null
    ) : null()

    /**
     * Resets all notification settings to their default values
     * By default, all chats are unmuted, the sound is set to "default" and message previews are shown
     */
    class ResetAllNotificationSettings : null()

    /**
     * Changes the order of pinned chats
     *
     * @chatIds - The new list of pinned chats
     */
    class SetPinnedChats(
        val chatIds: LongArray = longArrayOf()
    ) : null()

    /**
     * Downloads a file from the cloud
     * Download progress and completion of the download will be notified through updateFile updates
     *
     * @fileId - Identifier of the file to download
     * @priority - Priority of the download (1-32)
     *             The higher the priority, the earlier the file will be downloaded
     *             If the priorities of two files are equal, then the last one for which downloadFile was called will be downloaded first
     * @offset - The starting position from which the file should be downloaded
     * @limit - Number of bytes which should be downloaded starting from the "offset" position before the download will be automatically cancelled
     *          Use 0 to download without a limit
     * @synchronous - If false, this request returns file state just after the download has been started
     *                If true, this request returns file state only after the download has succeeded, has failed, has been cancelled or a new downloadFile request with different offset/limit parameters was sent
     */
    class DownloadFile(
        val fileId: Int = 0,
        val priority: Int = 0,
        val offset: Int = 0,
        val limit: Int = 0,
        val synchronous: Boolean = false
    ) : null()

    /**
     * Returns file downloaded prefix size from a given offset
     *
     * @fileId - Identifier of the file
     * @offset - Offset from which downloaded prefix size should be calculated
     */
    class GetFileDownloadedPrefixSize(
        val fileId: Int = 0,
        val offset: Int = 0
    ) : null()

    /**
     * Stops the downloading of a file
     * If a file has already been downloaded, does nothing
     *
     * @fileId - Identifier of a file to stop downloading
     * @onlyIfPending - Pass true to stop downloading only if it hasn't been started, i.e
     *                  Request hasn't been sent to server
     */
    class CancelDownloadFile(
        val fileId: Int = 0,
        val onlyIfPending: Boolean = false
    ) : null()

    /**
     * Asynchronously uploads a file to the cloud without sending it in a message
     * UpdateFile will be used to notify about upload progress and successful completion of the upload
     * The file will not have a persistent remote identifier until it will be sent in a message
     *
     * @file - File to upload
     * @fileType - File type
     * @priority - Priority of the upload (1-32)
     *             The higher the priority, the earlier the file will be uploaded
     *             If the priorities of two files are equal, then the first one for which uploadFile was called will be uploaded first
     */
    class UploadFile(
        val file: InputFile? = null,
        val fileType: FileType? = null,
        val priority: Int = 0
    ) : null()

    /**
     * Stops the uploading of a file
     * Supported only for files uploaded by using uploadFile
     * For other files the behavior is undefined
     *
     * @fileId - Identifier of the file to stop uploading
     */
    class CancelUploadFile(
        val fileId: Int = 0
    ) : null()

    /**
     * Writes a part of a generated file
     * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
     *
     * @generationId - The identifier of the generation process
     * @offset - The offset from which to write the data to the file
     * @data - The data to write
     */
    class WriteGeneratedFilePart(
        val generationId: Long = 0L,
        val offset: Int = 0,
        val data: ByteArray = byteArrayOf()
    ) : null()

    /**
     * Informs TDLib on a file generation prograss
     *
     * @generationId - The identifier of the generation process
     * @expectedSize - Expected size of the generated file, in bytes
     *                 0 if unknown
     * @localPrefixSize - The number of bytes already generated
     */
    class SetFileGenerationProgress(
        val generationId: Long = 0L,
        val expectedSize: Int = 0,
        val localPrefixSize: Int = 0
    ) : null()

    /**
     * Finishes the file generation
     *
     * @generationId - The identifier of the generation process
     * @error - If set, means that file generation has failed and should be terminated
     */
    class FinishFileGeneration(
        val generationId: Long = 0L,
        val error: Error? = null
    ) : null()

    /**
     * Reads a part of a file from the TDLib file cache and returns read bytes
     * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
     *
     * @fileId - Identifier of the file
     *           The file must be located in the TDLib file cache
     * @offset - The offset from which to read the file
     * @count - Number of bytes to read
     *          An error will be returned if there are not enough bytes available in the file from the specified position
     *          Pass 0 to read all available data from the specified position
     */
    class ReadFilePart(
        val fileId: Int = 0,
        val offset: Int = 0,
        val count: Int = 0
    ) : null()

    /**
     * Deletes a file from the TDLib file cache
     *
     * @fileId - Identifier of the file to delete
     */
    class DeleteFile(
        val fileId: Int = 0
    ) : null()

    /**
     * Generates a new invite link for a chat
     * The previously generated link is revoked
     * Available for basic groups, supergroups, and channels
     * Requires administrator privileges and can_invite_users right
     *
     * @chatId - Chat identifier
     */
    class GenerateChatInviteLink(
        val chatId: Long = 0L
    ) : null()

    /**
     * Checks the validity of an invite link for a chat and returns information about the corresponding chat
     *
     * @inviteLink - Invite link to be checked
     */
    class CheckChatInviteLink(
        val inviteLink: String? = null
    ) : null()

    /**
     * Uses an invite link to add the current user to the chat if possible
     * The new member will not be added until the chat state has been synchronized with the server
     *
     * @inviteLink - Invite link to import
     */
    class JoinChatByInviteLink(
        val inviteLink: String? = null
    ) : null()

    /**
     * Creates a new call
     *
     * @userId - Identifier of the user to be called
     * @protocol - Description of the call protocols supported by the client
     */
    class CreateCall(
        val userId: Int = 0,
        val protocol: CallProtocol? = null
    ) : null()

    /**
     * Accepts an incoming call
     *
     * @callId - Call identifier
     * @protocol - Description of the call protocols supported by the client
     */
    class AcceptCall(
        val callId: Int = 0,
        val protocol: CallProtocol? = null
    ) : null()

    /**
     * Discards a call
     *
     * @callId - Call identifier
     * @isDisconnected - True, if the user was disconnected
     * @duration - The call duration, in seconds
     * @connectionId - Identifier of the connection used during the call
     */
    class DiscardCall(
        val callId: Int = 0,
        val isDisconnected: Boolean = false,
        val duration: Int = 0,
        val connectionId: Long = 0L
    ) : null()

    /**
     * Sends a call rating
     *
     * @callId - Call identifier
     * @rating - Call rating
     * @comment - An optional user comment if the rating is less than 5
     * @problems - List of the exact types of problems with the call, specified by the user
     */
    class SendCallRating(
        val callId: Int = 0,
        val rating: Int = 0,
        val comment: String? = null,
        val problems: Array<CallProblem> = emptyArray()
    ) : null()

    /**
     * Sends debug information for a call
     *
     * @callId - Call identifier
     * @debugInformation - Debug information in application-specific format
     */
    class SendCallDebugInformation(
        val callId: Int = 0,
        val debugInformation: String? = null
    ) : null()

    /**
     * Adds a user to the blacklist
     *
     * @userId - User identifier
     */
    class BlockUser(
        val userId: Int = 0
    ) : null()

    /**
     * Removes a user from the blacklist
     *
     * @userId - User identifier
     */
    class UnblockUser(
        val userId: Int = 0
    ) : null()

    /**
     * Returns users that were blocked by the current user
     *
     * @offset - Number of users to skip in the result
     * @limit - Maximum number of users to return
     */
    class GetBlockedUsers(
        val offset: Int = 0,
        val limit: Int = 0
    ) : null()

    /**
     * Adds new contacts or edits existing contacts
     * Contacts' user identifiers are ignored
     *
     * @contacts - The list of contacts to import or edit, contact's vCard are ignored and are not imported
     */
    class ImportContacts(
        val contacts: Array<Contact> = emptyArray()
    ) : null()

    /**
     * Returns all user contacts
     */
    class GetContacts : null()

    /**
     * Searches for the specified query in the first names, last names and usernames of the known user contacts
     *
     * @query - Query to search for
     *          May be empty to return all contacts
     * @limit - Maximum number of users to be returned
     */
    class SearchContacts(
        val query: String? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Removes users from the contact list
     *
     * @userIds - Identifiers of users to be deleted
     */
    class RemoveContacts(
        val userIds: IntArray = intArrayOf()
    ) : null()

    /**
     * Returns the total number of imported contacts
     */
    class GetImportedContactCount : null()

    /**
     * Changes imported contacts using the list of current user contacts saved on the device
     * Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts
     * Query result depends on the result of the previous query, so only one query is possible at the same time
     *
     * @contacts - The new list of contacts, contact's vCard are ignored and are not imported
     */
    class ChangeImportedContacts(
        val contacts: Array<Contact> = emptyArray()
    ) : null()

    /**
     * Clears all imported contacts, contact list remains unchanged
     */
    class ClearImportedContacts : null()

    /**
     * Returns the profile photos of a user
     * The result of this query may be outdated: some photos might have been deleted already
     *
     * @userId - User identifier
     * @offset - The number of photos to skip
     * @limit - Maximum number of photos to be returned
     */
    class GetUserProfilePhotos(
        val userId: Int = 0,
        val offset: Int = 0,
        val limit: Int = 0
    ) : null()

    /**
     * Returns stickers from the installed sticker sets that correspond to a given emoji
     * If the emoji is not empty, favorite and recently used stickers may also be returned
     *
     * @emoji - String representation of emoji
     *          If empty, returns all known installed stickers
     * @limit - Maximum number of stickers to be returned
     */
    class GetStickers(
        val emoji: String? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Searches for stickers from public sticker sets that correspond to a given emoji
     *
     * @emoji - String representation of emoji
     * @limit - Maximum number of stickers to be returned
     */
    class SearchStickers(
        val emoji: String? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Returns a list of installed sticker sets
     *
     * @isMasks - Pass true to return mask sticker sets
     *            Pass false to return ordinary sticker sets
     */
    class GetInstalledStickerSets(
        val isMasks: Boolean = false
    ) : null()

    /**
     * Returns a list of archived sticker sets
     *
     * @isMasks - Pass true to return mask stickers sets
     *            Pass false to return ordinary sticker sets
     * @offsetStickerSetId - Identifier of the sticker set from which to return the result
     * @limit - Maximum number of sticker sets to return
     */
    class GetArchivedStickerSets(
        val isMasks: Boolean = false,
        val offsetStickerSetId: Long = 0L,
        val limit: Int = 0
    ) : null()

    /**
     * Returns a list of trending sticker sets
     */
    class GetTrendingStickerSets : null()

    /**
     * Returns a list of sticker sets attached to a file
     * Currently only photos and videos can have attached sticker sets
     *
     * @fileId - File identifier
     */
    class GetAttachedStickerSets(
        val fileId: Int = 0
    ) : null()

    /**
     * Returns information about a sticker set by its identifier
     *
     * @setId - Identifier of the sticker set
     */
    class GetStickerSet(
        val setId: Long = 0L
    ) : null()

    /**
     * Searches for a sticker set by its name
     *
     * @name - Name of the sticker set
     */
    class SearchStickerSet(
        val name: String? = null
    ) : null()

    /**
     * Searches for installed sticker sets by looking for specified query in their title and name
     *
     * @isMasks - Pass true to return mask sticker sets
     *            Pass false to return ordinary sticker sets
     * @query - Query to search for
     * @limit - Maximum number of sticker sets to return
     */
    class SearchInstalledStickerSets(
        val isMasks: Boolean = false,
        val query: String? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Searches for ordinary sticker sets by looking for specified query in their title and name
     * Excludes installed sticker sets from the results
     *
     * @query - Query to search for
     */
    class SearchStickerSets(
        val query: String? = null
    ) : null()

    /**
     * Installs/uninstalls or activates/archives a sticker set
     *
     * @setId - Identifier of the sticker set
     * @isInstalled - The new value of is_installed
     * @isArchived - The new value of is_archived
     *               A sticker set can't be installed and archived simultaneously
     */
    class ChangeStickerSet(
        val setId: Long = 0L,
        val isInstalled: Boolean = false,
        val isArchived: Boolean = false
    ) : null()

    /**
     * Informs the server that some trending sticker sets have been viewed by the user
     *
     * @stickerSetIds - Identifiers of viewed trending sticker sets
     */
    class ViewTrendingStickerSets(
        val stickerSetIds: LongArray = longArrayOf()
    ) : null()

    /**
     * Changes the order of installed sticker sets
     *
     * @isMasks - Pass true to change the order of mask sticker sets
     *            Pass false to change the order of ordinary sticker sets
     * @stickerSetIds - Identifiers of installed sticker sets in the new correct order
     */
    class ReorderInstalledStickerSets(
        val isMasks: Boolean = false,
        val stickerSetIds: LongArray = longArrayOf()
    ) : null()

    /**
     * Returns a list of recently used stickers
     *
     * @isAttached - Pass true to return stickers and masks that were recently attached to photos or video files
     *               Pass false to return recently sent stickers
     */
    class GetRecentStickers(
        val isAttached: Boolean = false
    ) : null()

    /**
     * Manually adds a new sticker to the list of recently used stickers
     * The new sticker is added to the top of the list
     * If the sticker was already in the list, it is removed from the list first
     * Only stickers belonging to a sticker set can be added to this list
     *
     * @isAttached - Pass true to add the sticker to the list of stickers recently attached to photo or video files
     *               Pass false to add the sticker to the list of recently sent stickers
     * @sticker - Sticker file to add
     */
    class AddRecentSticker(
        val isAttached: Boolean = false,
        val sticker: InputFile? = null
    ) : null()

    /**
     * Removes a sticker from the list of recently used stickers
     *
     * @isAttached - Pass true to remove the sticker from the list of stickers recently attached to photo or video files
     *               Pass false to remove the sticker from the list of recently sent stickers
     * @sticker - Sticker file to delete
     */
    class RemoveRecentSticker(
        val isAttached: Boolean = false,
        val sticker: InputFile? = null
    ) : null()

    /**
     * Clears the list of recently used stickers
     *
     * @isAttached - Pass true to clear the list of stickers recently attached to photo or video files
     *               Pass false to clear the list of recently sent stickers
     */
    class ClearRecentStickers(
        val isAttached: Boolean = false
    ) : null()

    /**
     * Returns favorite stickers
     */
    class GetFavoriteStickers : null()

    /**
     * Adds a new sticker to the list of favorite stickers
     * The new sticker is added to the top of the list
     * If the sticker was already in the list, it is removed from the list first
     * Only stickers belonging to a sticker set can be added to this list
     *
     * @sticker - Sticker file to add
     */
    class AddFavoriteSticker(
        val sticker: InputFile? = null
    ) : null()

    /**
     * Removes a sticker from the list of favorite stickers
     *
     * @sticker - Sticker file to delete from the list
     */
    class RemoveFavoriteSticker(
        val sticker: InputFile? = null
    ) : null()

    /**
     * Returns emoji corresponding to a sticker
     * The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object
     *
     * @sticker - Sticker file identifier
     */
    class GetStickerEmojis(
        val sticker: InputFile? = null
    ) : null()

    /**
     * Searches for emojis by keywords
     * Supported only if the file database is enabled
     *
     * @text - Text to search for
     * @exactMatch - True, if only emojis, which exactly match text needs to be returned
     */
    class SearchEmojis(
        val text: String? = null,
        val exactMatch: Boolean = false
    ) : null()

    /**
     * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements
     * The URL will be valid for 30 seconds after generation
     *
     * @languageCode - Language code for which the emoji replacements will be suggested
     */
    class GetEmojiSuggestionsUrl(
        val languageCode: String? = null
    ) : null()

    /**
     * Returns saved animations
     */
    class GetSavedAnimations : null()

    /**
     * Manually adds a new animation to the list of saved animations
     * The new animation is added to the beginning of the list
     * If the animation was already in the list, it is removed first
     * Only non-secret video animations with MIME type "video/mp4" can be added to the list
     *
     * @animation - The animation file to be added
     *              Only animations known to the server (i.e
     *              Successfully sent via a message) can be added to the list
     */
    class AddSavedAnimation(
        val animation: InputFile? = null
    ) : null()

    /**
     * Removes an animation from the list of saved animations
     *
     * @animation - Animation file to be removed
     */
    class RemoveSavedAnimation(
        val animation: InputFile? = null
    ) : null()

    /**
     * Returns up to 20 recently used inline bots in the order of their last usage
     */
    class GetRecentInlineBots : null()

    /**
     * Searches for recently used hashtags by their prefix
     *
     * @prefix - Hashtag prefix to search for
     * @limit - Maximum number of hashtags to be returned
     */
    class SearchHashtags(
        val prefix: String? = null,
        val limit: Int = 0
    ) : null()

    /**
     * Removes a hashtag from the list of recently used hashtags
     *
     * @hashtag - Hashtag to delete
     */
    class RemoveRecentHashtag(
        val hashtag: String? = null
    ) : null()

    /**
     * Returns a web page preview by the text of the message
     * Do not call this function too often
     * Returns a 404 error if the web page has no preview
     *
     * @text - Message text with formatting
     */
    class GetWebPagePreview(
        val text: FormattedText? = null
    ) : null()

    /**
     * Returns an instant view version of a web page if available
     * Returns a 404 error if the web page has no instant view page
     *
     * @url - The web page URL
     * @forceFull - If true, the full instant view for the web page will be returned
     */
    class GetWebPageInstantView(
        val url: String? = null,
        val forceFull: Boolean = false
    ) : null()

    /**
     * Uploads a new profile photo for the current user
     * If something changes, updateUser will be sent
     *
     * @photo - Profile photo to set
     *          InputFileId and inputFileRemote may still be unsupported
     */
    class SetProfilePhoto(
        val photo: InputFile? = null
    ) : null()

    /**
     * Deletes a profile photo
     * If something changes, updateUser will be sent
     *
     * @profilePhotoId - Identifier of the profile photo to delete
     */
    class DeleteProfilePhoto(
        val profilePhotoId: Long = 0L
    ) : null()

    /**
     * Changes the first and last name of the current user
     * If something changes, updateUser will be sent
     *
     * @firstName - The new value of the first name for the user
     * @lastName - The new value of the optional last name for the user
     */
    class SetName(
        val firstName: String? = null,
        val lastName: String? = null
    ) : null()

    /**
     * Changes the bio of the current user
     *
     * @bio - The new value of the user bio
     */
    class SetBio(
        val bio: String? = null
    ) : null()

    /**
     * Changes the username of the current user
     * If something changes, updateUser will be sent
     *
     * @username - The new value of the username
     *             Use an empty string to remove the username
     */
    class SetUsername(
        val username: String? = null
    ) : null()

    /**
     * Changes the phone number of the user and sends an authentication code to the user's new phone number
     * On success, returns information about the sent code
     *
     * @phoneNumber - The new phone number of the user in international format
     * @settings - Settings for the authentication of the user's phone number
     */
    class ChangePhoneNumber(
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : null()

    /**
     * Re-sends the authentication code sent to confirm a new phone number for the user
     * Works only if the previously received authenticationCodeInfo next_code_type was not null
     */
    class ResendChangePhoneNumberCode : null()

    /**
     * Checks the authentication code sent to confirm a new phone number of the user
     *
     * @code - Verification code received by SMS, phone call or flash call
     */
    class CheckChangePhoneNumberCode(
        val code: String? = null
    ) : null()

    /**
     * Returns all active sessions of the current user
     */
    class GetActiveSessions : null()

    /**
     * Terminates a session of the current user
     *
     * @sessionId - Session identifier
     */
    class TerminateSession(
        val sessionId: Long = 0L
    ) : null()

    /**
     * Terminates all other sessions of the current user
     */
    class TerminateAllOtherSessions : null()

    /**
     * Returns all website where the current user used Telegram to log in
     */
    class GetConnectedWebsites : null()

    /**
     * Disconnects website from the current user's Telegram account
     *
     * @websiteId - Website identifier
     */
    class DisconnectWebsite(
        val websiteId: Long = 0L
    ) : null()

    /**
     * Disconnects all websites from the current user's Telegram account
     */
    class DisconnectAllWebsites : null()

    /**
     * Changes the username of a supergroup or channel, requires creator privileges in the supergroup or channel
     *
     * @supergroupId - Identifier of the supergroup or channel
     * @username - New value of the username
     *             Use an empty string to remove the username
     */
    class SetSupergroupUsername(
        val supergroupId: Int = 0,
        val username: String? = null
    ) : null()

    /**
     * Changes the sticker set of a supergroup
     * Requires can_change_info rights
     *
     * @supergroupId - Identifier of the supergroup
     * @stickerSetId - New value of the supergroup sticker set identifier
     *                 Use 0 to remove the supergroup sticker set
     */
    class SetSupergroupStickerSet(
        val supergroupId: Int = 0,
        val stickerSetId: Long = 0L
    ) : null()

    /**
     * Toggles sender signatures messages sent in a channel
     * Requires can_change_info rights
     *
     * @supergroupId - Identifier of the channel
     * @signMessages - New value of sign_messages
     */
    class ToggleSupergroupSignMessages(
        val supergroupId: Int = 0,
        val signMessages: Boolean = false
    ) : null()

    /**
     * Toggles whether the message history of a supergroup is available to new members
     * Requires can_change_info rights
     *
     * @supergroupId - The identifier of the supergroup
     * @isAllHistoryAvailable - The new value of is_all_history_available
     */
    class ToggleSupergroupIsAllHistoryAvailable(
        val supergroupId: Int = 0,
        val isAllHistoryAvailable: Boolean = false
    ) : null()

    /**
     * Reports some messages from a user in a supergroup as spam
     * Requires administrator rights in the supergroup
     *
     * @supergroupId - Supergroup identifier
     * @userId - User identifier
     * @messageIds - Identifiers of messages sent in the supergroup by the user
     *               This list must be non-empty
     */
    class ReportSupergroupSpam(
        val supergroupId: Int = 0,
        val userId: Int = 0,
        val messageIds: LongArray = longArrayOf()
    ) : null()

    /**
     * Returns information about members or banned users in a supergroup or channel
     * Can be used only if SupergroupFullInfo.can_get_members == true
     * Additionally, administrator privileges may be required for some filters
     *
     * @supergroupId - Identifier of the supergroup or channel
     * @filter - The type of users to return
     *           By default, supergroupMembersRecent
     * @offset - Number of users to skip
     * @limit - The maximum number of users be returned
     *          Up to 200
     */
    class GetSupergroupMembers(
        val supergroupId: Int = 0,
        val filter: SupergroupMembersFilter? = null,
        val offset: Int = 0,
        val limit: Int = 0
    ) : null()

    /**
     * Deletes a supergroup or channel along with all messages in the corresponding chat
     * This will release the supergroup or channel username and remove all members
     * Requires creator privileges in the supergroup or channel
     * Chats with more than 1000 members can't be deleted using this method
     *
     * @supergroupId - Identifier of the supergroup or channel
     */
    class DeleteSupergroup(
        val supergroupId: Int = 0
    ) : null()

    /**
     * Closes a secret chat, effectively transfering its state to secretChatStateClosed
     *
     * @secretChatId - Secret chat identifier
     */
    class CloseSecretChat(
        val secretChatId: Int = 0
    ) : null()

    /**
     * Returns a list of service actions taken by chat members and administrators in the last 48 hours
     * Available only in supergroups and channels
     * Requires administrator rights
     * Returns results in reverse chronological order (i
     * E., in order of decreasing event_id)
     *
     * @chatId - Chat identifier
     * @query - Search query by which to filter events
     * @fromEventId - Identifier of an event from which to return results
     *                Use 0 to get results from the latest events
     * @limit - Maximum number of events to return
     * @filters - The types of events to return
     *            By default, all types will be returned
     * @userIds - User identifiers by which to filter events
     *            By default, events relating to all users will be returned
     */
    class GetChatEventLog(
        val chatId: Long = 0L,
        val query: String? = null,
        val fromEventId: Long = 0L,
        val limit: Int = 0,
        val filters: ChatEventLogFilters? = null,
        val userIds: IntArray = intArrayOf()
    ) : null()

    /**
     * Returns an invoice payment form
     * This method should be called when the user presses inlineKeyboardButtonBuy
     *
     * @chatId - Chat identifier of the Invoice message
     * @messageId - Message identifier
     */
    class GetPaymentForm(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Validates the order information provided by a user and returns the available shipping options for a flexible invoice
     *
     * @chatId - Chat identifier of the Invoice message
     * @messageId - Message identifier
     * @orderInfo - The order information, provided by the user
     * @allowSave - True, if the order information can be saved
     */
    class ValidateOrderInfo(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val orderInfo: OrderInfo? = null,
        val allowSave: Boolean = false
    ) : null()

    /**
     * Sends a filled-out payment form to the bot for final verification
     *
     * @chatId - Chat identifier of the Invoice message
     * @messageId - Message identifier
     * @orderInfoId - Identifier returned by ValidateOrderInfo, or an empty string
     * @shippingOptionId - Identifier of a chosen shipping option, if applicable
     * @credentials - The credentials chosen by user for payment
     */
    class SendPaymentForm(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val orderInfoId: String? = null,
        val shippingOptionId: String? = null,
        val credentials: InputCredentials? = null
    ) : null()

    /**
     * Returns information about a successful payment
     *
     * @chatId - Chat identifier of the PaymentSuccessful message
     * @messageId - Message identifier
     */
    class GetPaymentReceipt(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : null()

    /**
     * Returns saved order info, if any
     */
    class GetSavedOrderInfo : null()

    /**
     * Deletes saved order info
     */
    class DeleteSavedOrderInfo : null()

    /**
     * Deletes saved credentials for all payment provider bots
     */
    class DeleteSavedCredentials : null()

    /**
     * Returns a user that can be contacted to get support
     */
    class GetSupportUser : null()

    /**
     * Returns backgrounds installed by the user
     *
     * @forDarkTheme - True, if the backgrounds needs to be ordered for dark theme
     */
    class GetBackgrounds(
        val forDarkTheme: Boolean = false
    ) : null()

    /**
     * Constructs a persistent HTTP URL for a background
     *
     * @name - Background name
     * @type - Background type
     */
    class GetBackgroundUrl(
        val name: String? = null,
        val type: BackgroundType? = null
    ) : null()

    /**
     * Searches for a background by its name
     *
     * @name - The name of the background
     */
    class SearchBackground(
        val name: String? = null
    ) : null()

    /**
     * Changes the background selected by the user
     * Adds background to the list of installed backgrounds
     *
     * @background - The input background to use, null for solid backgrounds
     * @type - Background type
     *         Null for default background
     *         The method will return error 404 if type is null
     * @forDarkTheme - True, if the background is chosen for dark theme
     */
    class SetBackground(
        val background: InputBackground? = null,
        val type: BackgroundType? = null,
        val forDarkTheme: Boolean = false
    ) : null()

    /**
     * Removes background from the list of installed backgrounds
     *
     * @backgroundId - The background indentifier
     */
    class RemoveBackground(
        val backgroundId: Long = 0L
    ) : null()

    /**
     * Resets list of installed backgrounds to its default value
     */
    class ResetBackgrounds : null()

    /**
     * Returns information about the current localization target
     * This is an offline request if only_local is true
     * Can be called before authorization
     *
     * @onlyLocal - If true, returns only locally available information without sending network requests
     */
    class GetLocalizationTargetInfo(
        val onlyLocal: Boolean = false
    ) : null()

    /**
     * Returns information about a language pack
     * Returned language pack identifier may be different from a provided one
     * Can be called before authorization
     *
     * @languagePackId - Language pack identifier
     */
    class GetLanguagePackInfo(
        val languagePackId: String? = null
    ) : null()

    /**
     * Returns strings from a language pack in the current localization target by their keys
     * Can be called before authorization
     *
     * @languagePackId - Language pack identifier of the strings to be returned
     * @keys - Language pack keys of the strings to be returned
     *         Leave empty to request all available strings
     */
    class GetLanguagePackStrings(
        val languagePackId: String? = null,
        val keys: Array<String> = emptyArray()
    ) : null()

    /**
     * Fetches the latest versions of all strings from a language pack in the current localization target from the server
     * This method doesn't need to be called explicitly for the current used/base language packs
     * Can be called before authorization
     *
     * @languagePackId - Language pack identifier
     */
    class SynchronizeLanguagePack(
        val languagePackId: String? = null
    ) : null()

    /**
     * Adds a custom server language pack to the list of installed language packs in current localization target
     * Can be called before authorization
     *
     * @languagePackId - Identifier of a language pack to be added
     *                   May be different from a name that is used in an "https://t.me/setlanguage/" link
     */
    class AddCustomServerLanguagePack(
        val languagePackId: String? = null
    ) : null()

    /**
     * Adds or changes a custom local language pack to the current localization target
     *
     * @info - Information about the language pack
     *         Language pack ID must start with 'X', consist only of English letters, digits and hyphens, and must not exceed 64 characters
     *         Can be called before authorization
     * @strings - Strings of the new language pack
     */
    class SetCustomLanguagePack(
        val info: LanguagePackInfo? = null,
        val strings: Array<LanguagePackString> = emptyArray()
    ) : null()

    /**
     * Edits information about a custom local language pack in the current localization target
     * Can be called before authorization
     *
     * @info - New information about the custom local language pack
     */
    class EditCustomLanguagePackInfo(
        val info: LanguagePackInfo? = null
    ) : null()

    /**
     * Adds, edits or deletes a string in a custom local language pack
     * Can be called before authorization
     *
     * @languagePackId - Identifier of a previously added custom local language pack in the current localization target
     * @newString - New language pack string
     */
    class SetCustomLanguagePackString(
        val languagePackId: String? = null,
        val newString: LanguagePackString? = null
    ) : null()

    /**
     * Deletes all information about a language pack in the current localization target
     * The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted
     * Can be called before authorization
     *
     * @languagePackId - Identifier of the language pack to delete
     */
    class DeleteLanguagePack(
        val languagePackId: String? = null
    ) : null()

    /**
     * Registers the currently used device for receiving push notifications
     * Returns a globally unique identifier of the push notification subscription
     *
     * @deviceToken - Device token
     * @otherUserIds - List of user identifiers of other users currently using the client
     */
    class RegisterDevice(
        val deviceToken: DeviceToken? = null,
        val otherUserIds: IntArray = intArrayOf()
    ) : null()

    /**
     * Handles a push notification
     * Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data
     * Can be called before authorization
     *
     * @payload - JSON-encoded push notification payload with all fields sent by the server, and "google.sent_time" and "google.notification.sound" fields added
     */
    class ProcessPushNotification(
        val payload: String? = null
    ) : null()

    /**
     * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
     * This is an offline method
     * Can be called before authorization
     *
     * @payload - JSON-encoded push notification payload
     */
    class GetPushReceiverId(
        val payload: String? = null
    ) : null()

    /**
     * Returns t.me URLs recently visited by a newly registered user
     *
     * @referrer - Google Play referrer to identify the user
     */
    class GetRecentlyVisitedTMeUrls(
        val referrer: String? = null
    ) : null()

    /**
     * Changes user privacy settings
     *
     * @setting - The privacy setting
     * @rules - The new privacy rules
     */
    class SetUserPrivacySettingRules(
        val setting: UserPrivacySetting? = null,
        val rules: UserPrivacySettingRules? = null
    ) : null()

    /**
     * Returns the current privacy settings
     *
     * @setting - The privacy setting
     */
    class GetUserPrivacySettingRules(
        val setting: UserPrivacySetting? = null
    ) : null()

    /**
     * Returns the value of an option by its name
     * (Check the list of available options on https://core.telegram.org/tdlib/options.) Can be called before authorization
     *
     * @name - The name of the option
     */
    class GetOption(
        val name: String? = null
    ) : null()

    /**
     * Sets the value of an option
     * (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set
     * Can be called before authorization
     *
     * @name - The name of the option
     * @value - The new value of the option
     */
    class SetOption(
        val name: String? = null,
        val value: OptionValue? = null
    ) : null()

    /**
     * Changes the period of inactivity after which the account of the current user will automatically be deleted
     *
     * @ttl - New account TTL
     */
    class SetAccountTtl(
        val ttl: AccountTtl? = null
    ) : null()

    /**
     * Returns the period of inactivity after which the account of the current user will automatically be deleted
     */
    class GetAccountTtl : null()

    /**
     * Deletes the account of the current user, deleting all information associated with the user from the server
     * The phone number of the account can be used to create a new account
     * Can be called before authorization when the current authorization state is authorizationStateWaitPassword
     *
     * @reason - The reason why the account was deleted
     */
    class DeleteAccount(
        val reason: String? = null
    ) : null()

    /**
     * Returns information on whether the current chat can be reported as spam
     *
     * @chatId - Chat identifier
     */
    class GetChatReportSpamState(
        val chatId: Long = 0L
    ) : null()

    /**
     * Reports to the server whether a chat is a spam chat or not
     * Can be used only if ChatReportSpamState.can_report_spam is true
     * After this request, ChatReportSpamState.can_report_spam becomes false forever
     *
     * @chatId - Chat identifier
     * @isSpamChat - If true, the chat will be reported as spam
     *               Otherwise it will be marked as not spam
     */
    class ChangeChatReportSpamState(
        val chatId: Long = 0L,
        val isSpamChat: Boolean = false
    ) : null()

    /**
     * Reports a chat to the Telegram moderators
     * Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators
     *
     * @chatId - Chat identifier
     * @reason - The reason for reporting the chat
     * @messageIds - Identifiers of reported messages, if any
     */
    class ReportChat(
        val chatId: Long = 0L,
        val reason: ChatReportReason? = null,
        val messageIds: LongArray = longArrayOf()
    ) : null()

    /**
     * Returns an HTTP URL with the chat statistics
     * Currently this method can be used only for channels
     *
     * @chatId - Chat identifier
     * @parameters - Parameters from "tg://statsrefresh?params=******" link
     * @isDark - Pass true if a URL with the dark theme must be returned
     */
    class GetChatStatisticsUrl(
        val chatId: Long = 0L,
        val parameters: String? = null,
        val isDark: Boolean = false
    ) : null()

    /**
     * Returns storage usage statistics
     * Can be called before authorization
     *
     * @chatLimit - Maximum number of chats with the largest storage usage for which separate statistics should be returned
     *              All other chats will be grouped in entries with chat_id == 0
     *              If the chat info database is not used, the chat_limit is ignored and is always set to 0
     */
    class GetStorageStatistics(
        val chatLimit: Int = 0
    ) : null()

    /**
     * Quickly returns approximate storage usage statistics
     * Can be called before authorization
     */
    class GetStorageStatisticsFast : null()

    /**
     * Returns database statistics
     */
    class GetDatabaseStatistics : null()

    /**
     * Optimizes storage usage, i.e
     * Deletes some files and returns new storage usage statistics
     * Secret thumbnails can't be deleted
     *
     * @size - Limit on the total size of files after deletion
     *         Pass -1 to use the default limit
     * @ttl - Limit on the time that has passed since the last time a file was accessed (or creation time for some filesystems)
     *        Pass -1 to use the default limit
     * @count - Limit on the total count of files after deletion
     *          Pass -1 to use the default limit
     * @immunityDelay - The amount of time after the creation of a file during which it can't be deleted, in seconds
     *                  Pass -1 to use the default value
     * @fileTypes - If not empty, only files with the given type(s) are considered
     *              By default, all types except thumbnails, profile photos, stickers and wallpapers are deleted
     * @chatIds - If not empty, only files from the given chats are considered
     *            Use 0 as chat identifier to delete files not belonging to any chat (e.g., profile photos)
     * @excludeChatIds - If not empty, files from the given chats are excluded
     *                   Use 0 as chat identifier to exclude all files not belonging to any chat (e.g., profile photos)
     * @chatLimit - Same as in getStorageStatistics
     *              Affects only returned statistics
     */
    class OptimizeStorage(
        val size: Long = 0L,
        val ttl: Int = 0,
        val count: Int = 0,
        val immunityDelay: Int = 0,
        val fileTypes: Array<FileType> = emptyArray(),
        val chatIds: LongArray = longArrayOf(),
        val excludeChatIds: LongArray = longArrayOf(),
        val chatLimit: Int = 0
    ) : null()

    /**
     * Sets the current network type
     * Can be called before authorization
     * Calling this method forces all network connections to reopen, mitigating the delay in switching between different networks, so it should be called whenever the network is changed, even if the network type remains the same
     * Network type is used to check whether the library can use the network at all and also for collecting detailed network data usage statistics
     *
     * @type - The new network type
     *         By default, networkTypeOther
     */
    class SetNetworkType(
        val type: NetworkType? = null
    ) : null()

    /**
     * Returns network data usage statistics
     * Can be called before authorization
     *
     * @onlyCurrent - If true, returns only data for the current library launch
     */
    class GetNetworkStatistics(
        val onlyCurrent: Boolean = false
    ) : null()

    /**
     * Adds the specified data to data usage statistics
     * Can be called before authorization
     *
     * @entry - The network statistics entry with the data to be added to statistics
     */
    class AddNetworkStatistics(
        val entry: NetworkStatisticsEntry? = null
    ) : null()

    /**
     * Resets all network data usage statistics to zero
     * Can be called before authorization
     */
    class ResetNetworkStatistics : null()

    /**
     * Returns auto-download settings presets for the currently logged in user
     */
    class GetAutoDownloadSettingsPresets : null()

    /**
     * Sets auto-download settings
     *
     * @settings - New user auto-download settings
     * @type - Type of the network for which the new settings are applied
     */
    class SetAutoDownloadSettings(
        val settings: AutoDownloadSettings? = null,
        val type: NetworkType? = null
    ) : null()

    /**
     * Returns one of the available Telegram Passport elements
     *
     * @type - Telegram Passport element type
     * @password - Password of the current user
     */
    class GetPassportElement(
        val type: PassportElementType? = null,
        val password: String? = null
    ) : null()

    /**
     * Returns all available Telegram Passport elements
     *
     * @password - Password of the current user
     */
    class GetAllPassportElements(
        val password: String? = null
    ) : null()

    /**
     * Adds an element to the user's Telegram Passport
     * May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
     *
     * @element - Input Telegram Passport element
     * @password - Password of the current user
     */
    class SetPassportElement(
        val element: InputPassportElement? = null,
        val password: String? = null
    ) : null()

    /**
     * Deletes a Telegram Passport element
     *
     * @type - Element type
     */
    class DeletePassportElement(
        val type: PassportElementType? = null
    ) : null()

    /**
     * Informs the user that some of the elements in their Telegram Passport contain errors
     * The user will not be able to resend the elements, until the errors are fixed
     *
     * @userId - User identifier
     * @errors - The errors
     */
    @BotsOnly
    class SetPassportElementErrors(
        val userId: Int = 0,
        val errors: Array<InputPassportElementError> = emptyArray()
    ) : null()

    /**
     * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
     * Returns a 404 error if unknown
     *
     * @countryCode - A two-letter ISO 3166-1 alpha-2 country code
     */
    class GetPreferredCountryLanguage(
        val countryCode: String? = null
    ) : null()

    /**
     * Sends a code to verify a phone number to be added to a user's Telegram Passport
     *
     * @phoneNumber - The phone number of the user, in international format
     * @settings - Settings for the authentication of the user's phone number
     */
    class SendPhoneNumberVerificationCode(
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : null()

    /**
     * Re-sends the code to verify a phone number to be added to a user's Telegram Passport
     */
    class ResendPhoneNumberVerificationCode : null()

    /**
     * Checks the phone number verification code for Telegram Passport
     *
     * @code - Verification code
     */
    class CheckPhoneNumberVerificationCode(
        val code: String? = null
    ) : null()

    /**
     * Sends a code to verify an email address to be added to a user's Telegram Passport
     *
     * @emailAddress - Email address
     */
    class SendEmailAddressVerificationCode(
        val emailAddress: String? = null
    ) : null()

    /**
     * Re-sends the code to verify an email address to be added to a user's Telegram Passport
     */
    class ResendEmailAddressVerificationCode : null()

    /**
     * Checks the email address verification code for Telegram Passport
     *
     * @code - Verification code
     */
    class CheckEmailAddressVerificationCode(
        val code: String? = null
    ) : null()

    /**
     * Returns a Telegram Passport authorization form for sharing data with a service
     *
     * @botUserId - User identifier of the service's bot
     * @scope - Telegram Passport element types requested by the service
     * @publicKey - Service's public_key
     * @nonce - Authorization form nonce provided by the service
     */
    class GetPassportAuthorizationForm(
        val botUserId: Int = 0,
        val scope: String? = null,
        val publicKey: String? = null,
        val nonce: String? = null
    ) : null()

    /**
     * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form
     * Result can be received only once for each authorization form
     *
     * @autorizationFormId - Authorization form identifier
     * @password - Password of the current user
     */
    class GetPassportAuthorizationFormAvailableElements(
        val autorizationFormId: Int = 0,
        val password: String? = null
    ) : null()

    /**
     * Sends a Telegram Passport authorization form, effectively sharing data with the service
     * This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements need to be used
     *
     * @autorizationFormId - Authorization form identifier
     * @types - Types of Telegram Passport elements chosen by user to complete the authorization form
     */
    class SendPassportAuthorizationForm(
        val autorizationFormId: Int = 0,
        val types: Array<PassportElementType> = emptyArray()
    ) : null()

    /**
     * Sends phone number confirmation code
     * Should be called when user presses "https://t.me/confirmphone?phone=*******&hash=**********" or "tg://confirmphone?phone=*******&hash=**********" link
     *
     * @hash - Value of the "hash" parameter from the link
     * @phoneNumber - Value of the "phone" parameter from the link
     * @settings - Settings for the authentication of the user's phone number
     */
    class SendPhoneNumberConfirmationCode(
        val hash: String? = null,
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : null()

    /**
     * Resends phone number confirmation code
     */
    class ResendPhoneNumberConfirmationCode : null()

    /**
     * Checks phone number confirmation code
     *
     * @code - The phone number confirmation code
     */
    class CheckPhoneNumberConfirmationCode(
        val code: String? = null
    ) : null()

    /**
     * Informs the server about the number of pending bot updates if they haven't been processed for a long time
     *
     * @pendingUpdateCount - The number of pending updates
     * @errorMessage - The last error message
     */
    @BotsOnly
    class SetBotUpdatesStatus(
        val pendingUpdateCount: Int = 0,
        val errorMessage: String? = null
    ) : null()

    /**
     * Uploads a PNG image with a sticker
     * Returns the uploaded file
     *
     * @userId - Sticker file owner
     * @pngSticker - PNG image with the sticker
     *               Must be up to 512 kB in size and fit in 512x512 square
     */
    @BotsOnly
    class UploadStickerFile(
        val userId: Int = 0,
        val pngSticker: InputFile? = null
    ) : null()

    /**
     * Creates a new sticker set
     * Returns the newly created sticker set
     *
     * @userId - Sticker set owner
     * @title - Sticker set title
     * @name - Sticker set name
     *         Can contain only English letters, digits and underscores
     *         Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive)
     * @isMasks - True, if stickers are masks
     * @stickers - List of stickers to be added to the set
     */
    @BotsOnly
    class CreateNewStickerSet(
        val userId: Int = 0,
        val title: String? = null,
        val name: String? = null,
        val isMasks: Boolean = false,
        val stickers: Array<InputSticker> = emptyArray()
    ) : null()

    /**
     * Adds a new sticker to a set
     * Returns the sticker set
     *
     * @userId - Sticker set owner
     * @name - Sticker set name
     * @sticker - Sticker to add to the set
     */
    @BotsOnly
    class AddStickerToSet(
        val userId: Int = 0,
        val name: String? = null,
        val sticker: InputSticker? = null
    ) : null()

    /**
     * Changes the position of a sticker in the set to which it belongs
     * The sticker set must have been created by the bot
     *
     * @sticker - Sticker
     * @position - New position of the sticker in the set, zero-based
     */
    @BotsOnly
    class SetStickerPositionInSet(
        val sticker: InputFile? = null,
        val position: Int = 0
    ) : null()

    /**
     * Removes a sticker from the set to which it belongs
     * The sticker set must have been created by the bot
     *
     * @sticker - Sticker
     */
    @BotsOnly
    class RemoveStickerFromSet(
        val sticker: InputFile? = null
    ) : null()

    /**
     * Returns information about a file with a map thumbnail in PNG format
     * Only map thumbnail files with size less than 1MB can be downloaded
     *
     * @location - Location of the map center
     * @zoom - Map zoom level
     * @width - Map width in pixels before applying scale
     * @height - Map height in pixels before applying scale
     * @scale - Map scale
     * @chatId - Identifier of a chat, in which the thumbnail will be shown
     *           Use 0 if unknown
     */
    class GetMapThumbnailFile(
        val location: Location? = null,
        val zoom: Int = 0,
        val width: Int = 0,
        val height: Int = 0,
        val scale: Int = 0,
        val chatId: Long = 0L
    ) : null()

    /**
     * Accepts Telegram terms of services
     *
     * @termsOfServiceId - Terms of service identifier
     */
    class AcceptTermsOfService(
        val termsOfServiceId: String? = null
    ) : null()

    /**
     * Sends a custom request
     *
     * @method - The method name
     * @parameters - JSON-serialized method parameters
     */
    @BotsOnly
    class SendCustomRequest(
        val method: String? = null,
        val parameters: String? = null
    ) : null()

    /**
     * Answers a custom query
     *
     * @customQueryId - Identifier of a custom query
     * @data - JSON-serialized answer to the query
     */
    @BotsOnly
    class AnswerCustomQuery(
        val customQueryId: Long = 0L,
        val data: String? = null
    ) : null()

    /**
     * Succeeds after a specified amount of time has passed
     * Can be called before authorization
     * Can be called before initialization
     *
     * @seconds - Number of seconds before the function returns
     */
    class SetAlarm(
        val seconds: Double = 0.0
    ) : null()

    /**
     * Uses current user IP to found their country
     * Returns two-letter ISO 3166-1 alpha-2 country code
     * Can be called before authorization
     */
    class GetCountryCode : null()

    /**
     * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
     */
    class GetInviteText : null()

    /**
     * Returns information about a tg:// deep link
     * Use "tg://need_update_for_some_feature" or "tg:some_unsupported_feature" for testing
     * Returns a 404 error for unknown links
     * Can be called before authorization
     *
     * @link - The link
     */
    class GetDeepLinkInfo(
        val link: String? = null
    ) : null()

    /**
     * Returns application config, provided by the server
     * Can be called before authorization
     */
    class GetApplicationConfig : null()

    /**
     * Saves application log event on the server
     * Can be called before authorization
     *
     * @type - Event type
     * @chatId - Optional chat identifier, associated with the event
     * @data - The log event data
     */
    class SaveApplicationLogEvent(
        val type: String? = null,
        val chatId: Long = 0L,
        val data: JsonValue? = null
    ) : null()

    /**
     * Adds a proxy server for network requests
     * Can be called before authorization
     *
     * @server - Proxy server IP address
     * @port - Proxy server port
     * @enable - True, if the proxy should be enabled
     * @type - Proxy type
     */
    class AddProxy(
        val server: String? = null,
        val port: Int = 0,
        val enable: Boolean = false,
        val type: ProxyType? = null
    ) : null()

    /**
     * Edits an existing proxy server for network requests
     * Can be called before authorization
     *
     * @proxyId - Proxy identifier
     * @server - Proxy server IP address
     * @port - Proxy server port
     * @enable - True, if the proxy should be enabled
     * @type - Proxy type
     */
    class EditProxy(
        val proxyId: Int = 0,
        val server: String? = null,
        val port: Int = 0,
        val enable: Boolean = false,
        val type: ProxyType? = null
    ) : null()

    /**
     * Enables a proxy
     * Only one proxy can be enabled at a time
     * Can be called before authorization
     *
     * @proxyId - Proxy identifier
     */
    class EnableProxy(
        val proxyId: Int = 0
    ) : null()

    /**
     * Disables the currently enabled proxy
     * Can be called before authorization
     */
    class DisableProxy : null()

    /**
     * Removes a proxy server
     * Can be called before authorization
     *
     * @proxyId - Proxy identifier
     */
    class RemoveProxy(
        val proxyId: Int = 0
    ) : null()

    /**
     * Returns list of proxies that are currently set up
     * Can be called before authorization
     */
    class GetProxies : null()

    /**
     * Returns an HTTPS link, which can be used to add a proxy
     * Available only for SOCKS5 and MTProto proxies
     * Can be called before authorization
     *
     * @proxyId - Proxy identifier
     */
    class GetProxyLink(
        val proxyId: Int = 0
    ) : null()

    /**
     * Computes time needed to receive a response from a Telegram server through a proxy
     * Can be called before authorization
     *
     * @proxyId - Proxy identifier
     *            Use 0 to ping a Telegram server without a proxy
     */
    class PingProxy(
        val proxyId: Int = 0
    ) : null()

    /**
     * Sets new log stream for internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     *
     * @logStream - New log stream
     */
    class SetLogStream(
        val logStream: LogStream? = null
    ) : null()

    /**
     * Returns information about currently used log stream for internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     */
    class GetLogStream : null()

    /**
     * Sets the verbosity level of the internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     *
     * @newVerbosityLevel - New value of the verbosity level for logging
     *                      Value 0 corresponds to fatal errors, value 1 corresponds to errors, value 2 corresponds to warnings and debug warnings, value 3 corresponds to informational, value 4 corresponds to debug, value 5 corresponds to verbose debug, value greater than 5 and up to 1023 can be used to enable even more logging
     */
    class SetLogVerbosityLevel(
        val newVerbosityLevel: Int = 0
    ) : null()

    /**
     * Returns current verbosity level of the internal logging of TDLib
     * This is an offline method
     * Can be called before authorization
     */
    class GetLogVerbosityLevel : null()

    /**
     * Returns list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]
     * This is an offline method
     * Can be called before authorization
     */
    class GetLogTags : null()

    /**
     * Sets the verbosity level for a specified TDLib internal log tag
     * This is an offline method
     * Can be called before authorization
     *
     * @tag - Logging tag to change verbosity level
     * @newVerbosityLevel - New verbosity level
     */
    class SetLogTagVerbosityLevel(
        val tag: String? = null,
        val newVerbosityLevel: Int = 0
    ) : null()

    /**
     * Returns current verbosity level for a specified TDLib internal log tag
     * This is an offline method
     * Can be called before authorization
     *
     * @tag - Logging tag to change verbosity level
     */
    class GetLogTagVerbosityLevel(
        val tag: String? = null
    ) : null()

    /**
     * Adds a message to TDLib internal log
     * This is an offline method
     * Can be called before authorization
     *
     * @verbosityLevel - Minimum verbosity level needed for the message to be logged, 0-1023
     * @text - Text of a message to log
     */
    class AddLogMessage(
        val verbosityLevel: Int = 0,
        val text: String? = null
    ) : null()

    /**
     * Does nothing
     * This is an offline method
     * Can be called before authorization
     */
    @TestingOnly
    class TestCallEmpty : null()

    /**
     * Returns the received string
     * This is an offline method
     * Can be called before authorization
     *
     * @x - String to return
     */
    @TestingOnly
    class TestCallString(
        val x: String? = null
    ) : null()

    /**
     * Returns the received bytes
     * This is an offline method
     * Can be called before authorization
     *
     * @x - Bytes to return
     */
    @TestingOnly
    class TestCallBytes(
        val x: ByteArray = byteArrayOf()
    ) : null()

    /**
     * Returns the received vector of numbers
     * This is an offline method
     * Can be called before authorization
     *
     * @x - Vector of numbers to return
     */
    @TestingOnly
    class TestCallVectorInt(
        val x: IntArray = intArrayOf()
    ) : null()

    /**
     * Returns the received vector of objects containing a number
     * This is an offline method
     * Can be called before authorization
     *
     * @x - Vector of objects to return
     */
    @TestingOnly
    class TestCallVectorIntObject(
        val x: Array<TestInt> = emptyArray()
    ) : null()

    /**
     * Returns the received vector of strings
     * This is an offline method
     * Can be called before authorization
     *
     * @x - Vector of strings to return
     */
    @TestingOnly
    class TestCallVectorString(
        val x: Array<String> = emptyArray()
    ) : null()

    /**
     * Returns the received vector of objects containing a string
     * This is an offline method
     * Can be called before authorization
     *
     * @x - Vector of objects to return
     */
    @TestingOnly
    class TestCallVectorStringObject(
        val x: Array<TestString> = emptyArray()
    ) : null()

    /**
     * Returns the squared received number
     * This is an offline method
     * Can be called before authorization
     *
     * @x - Number to square
     */
    @TestingOnly
    class TestSquareInt(
        val x: Int = 0
    ) : null()

    /**
     * Sends a simple network request to the Telegram servers
     * Can be called before authorization
     */
    @TestingOnly
    class TestNetwork : null()

    /**
     * Sends a simple network request to the Telegram servers via proxy
     * Can be called before authorization
     *
     * @server - Proxy server IP address
     * @port - Proxy server port
     * @type - Proxy type
     */
    @TestingOnly
    class TestProxy(
        val server: String? = null,
        val port: Int = 0,
        val type: ProxyType? = null
    ) : null()

    /**
     * Forces an updates.getDifference call to the Telegram servers
     */
    @TestingOnly
    class TestGetDifference : null()

    /**
     * Does nothing and ensures that the Update object is used
     * This is an offline method
     * Can be called before authorization
     */
    @TestingOnly
    class TestUseUpdate : null()

    /**
     * Returns the specified error and ensures that the Error object is used
     * This is an offline method
     * Can be called before authorization
     *
     * @error - The error to be returned
     */
    @TestingOnly
    class TestReturnError(
        val error: Error? = null
    ) : null()

}
