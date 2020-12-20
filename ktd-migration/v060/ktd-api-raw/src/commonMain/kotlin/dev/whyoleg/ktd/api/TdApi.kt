@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api

private const val abstractTdDeprecatedMessage: String =
        "Classes under TdApi will be removed in 0.6.1, use Td-prefixed classes under ReplaceWith"

@Deprecated(
    message = "Deprecated, use TdObject instead",
    replaceWith = ReplaceWith("TdObject"),
    level = DeprecationLevel.ERROR
)
typealias TelegramObject = TdApi.Object

@Deprecated(
    message = "Deprecated, use TdApiRequest instead",
    replaceWith = ReplaceWith("TdApiRequest"),
    level = DeprecationLevel.ERROR
)
typealias TelegramFunction = TdApi.Function

@Deprecated(
    message = "Deprecated, use TdUpdate instead",
    replaceWith = ReplaceWith("TdUpdate"),
    level = DeprecationLevel.ERROR
)
typealias TelegramUpdate = TdApi.Update

@Deprecated(
    message = "Deprecated, use TdError instead",
    replaceWith = ReplaceWith("TdError"),
    level = DeprecationLevel.ERROR
)
typealias TelegramError = TdApi.Error

@Deprecated(
    message = "Deprecated, use one of [User,Bots,Core]TdApi instead. For user api - UserTdApi",
    level = DeprecationLevel.ERROR
)
class TdApi {
    @Deprecated(
        message = "Deprecated, use TdObject instead",
        replaceWith = ReplaceWith("TdObject"),
        level = DeprecationLevel.ERROR
    )
    abstract class Object {
        @Deprecated(
            message = "Use `is` instead",
            level = DeprecationLevel.ERROR
        )
        val constructor: Int = error("")
    }

    @Deprecated(
        message = "Deprecated, use TdApiRequest instead",
        replaceWith = ReplaceWith("TdApiRequest"),
        level = DeprecationLevel.ERROR
    )
    abstract class Function : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdError"),
        level = DeprecationLevel.ERROR
    )
    class Error(
        val code: Int,
        val message: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOk"),
        level = DeprecationLevel.ERROR
    )
    class Ok : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTdlibParameters"),
        level = DeprecationLevel.ERROR
    )
    class TdlibParameters(
        val useTestDc: Boolean,
        val databaseDirectory: String,
        val filesDirectory: String,
        val useFileDatabase: Boolean,
        val useChatInfoDatabase: Boolean,
        val useMessageDatabase: Boolean,
        val useSecretChats: Boolean,
        val apiId: Int,
        val apiHash: String,
        val systemLanguageCode: String,
        val deviceModel: String,
        val systemVersion: String,
        val applicationVersion: String,
        val enableStorageOptimizer: Boolean,
        val ignoreFileNames: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeInfo"),
        level = DeprecationLevel.ERROR
    )
    class AuthenticationCodeInfo(
        val phoneNumber: String,
        val type: AuthenticationCodeType,
        val nextType: AuthenticationCodeType?,
        val timeout: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEmailAddressAuthenticationCodeInfo"),
        level = DeprecationLevel.ERROR
    )
    class EmailAddressAuthenticationCodeInfo(
        val emailAddressPattern: String,
        val length: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntity"),
        level = DeprecationLevel.ERROR
    )
    class TextEntity(
        val offset: Int,
        val length: Int,
        val type: TextEntityType
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntities"),
        level = DeprecationLevel.ERROR
    )
    class TextEntities(
        val entities: Array<TextEntity>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFormattedText"),
        level = DeprecationLevel.ERROR
    )
    class FormattedText(
        val text: String,
        val entities: Array<TextEntity>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTermsOfService"),
        level = DeprecationLevel.ERROR
    )
    class TermsOfService(
        val text: FormattedText,
        val minUserAge: Int,
        val showPopup: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPasswordState"),
        level = DeprecationLevel.ERROR
    )
    class PasswordState(
        val hasPassword: Boolean,
        val passwordHint: String?,
        val hasRecoveryEmailAddress: Boolean,
        val hasPassportData: Boolean,
        val recoveryEmailAddressCodeInfo: EmailAddressAuthenticationCodeInfo?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRecoveryEmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class RecoveryEmailAddress(
        val recoveryEmailAddress: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTemporaryPasswordState"),
        level = DeprecationLevel.ERROR
    )
    class TemporaryPasswordState(
        val hasPassword: Boolean,
        val validFor: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLocalFile"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoteFile"),
        level = DeprecationLevel.ERROR
    )
    class RemoteFile(
        val id: String?,
        val uniqueId: String,
        val isUploadingActive: Boolean,
        val isUploadingCompleted: Boolean,
        val uploadedSize: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFile"),
        level = DeprecationLevel.ERROR
    )
    class File(
        val id: Int,
        val size: Int,
        val expectedSize: Int,
        val local: LocalFile,
        val remote: RemoteFile
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPhotoSize"),
        level = DeprecationLevel.ERROR
    )
    class PhotoSize(
        val type: String,
        val photo: File,
        val width: Int,
        val height: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMinithumbnail"),
        level = DeprecationLevel.ERROR
    )
    class Minithumbnail(
        val width: Int,
        val height: Int,
        val data: ByteArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPosition"),
        level = DeprecationLevel.ERROR
    )
    class MaskPosition(
        val point: MaskPoint,
        val xShift: Double,
        val yShift: Double,
        val scale: Double
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPollOption"),
        level = DeprecationLevel.ERROR
    )
    class PollOption(
        val text: String,
        val voterCount: Int,
        val votePercentage: Int,
        val isChosen: Boolean,
        val isBeingChosen: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnimation"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAudio"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDocument"),
        level = DeprecationLevel.ERROR
    )
    class Document(
        val fileName: String,
        val mimeType: String,
        val minithumbnail: Minithumbnail?,
        val thumbnail: PhotoSize?,
        val document: File
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPhoto"),
        level = DeprecationLevel.ERROR
    )
    class Photo(
        val hasStickers: Boolean,
        val minithumbnail: Minithumbnail?,
        val sizes: Array<PhotoSize>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSticker"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVideo"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVideoNote"),
        level = DeprecationLevel.ERROR
    )
    class VideoNote(
        val duration: Int,
        val length: Int,
        val minithumbnail: Minithumbnail?,
        val thumbnail: PhotoSize?,
        val video: File
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class VoiceNote(
        val duration: Int,
        val waveform: ByteArray,
        val mimeType: String,
        val voice: File
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdContact"),
        level = DeprecationLevel.ERROR
    )
    class Contact(
        val phoneNumber: String,
        val firstName: String,
        val lastName: String,
        val vcard: String,
        val userId: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLocation"),
        level = DeprecationLevel.ERROR
    )
    class Location(
        val latitude: Double,
        val longitude: Double
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdVenue"),
        level = DeprecationLevel.ERROR
    )
    class Venue(
        val location: Location,
        val title: String,
        val address: String,
        val provider: String,
        val id: String,
        val type: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGame"),
        level = DeprecationLevel.ERROR
    )
    class Game(
        val id: Long,
        val shortName: String,
        val title: String,
        val text: FormattedText,
        val description: String,
        val photo: Photo,
        val animation: Animation?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPoll"),
        level = DeprecationLevel.ERROR
    )
    class Poll(
        val id: Long,
        val question: String,
        val options: Array<PollOption>,
        val totalVoterCount: Int,
        val recentVoterUserIds: IntArray,
        val isAnonymous: Boolean,
        val type: PollType,
        val isClosed: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProfilePhoto"),
        level = DeprecationLevel.ERROR
    )
    class ProfilePhoto(
        val id: Long,
        val small: File,
        val big: File
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatPhoto"),
        level = DeprecationLevel.ERROR
    )
    class ChatPhoto(
        val small: File,
        val big: File
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBotCommand"),
        level = DeprecationLevel.ERROR
    )
    class BotCommand(
        val command: String,
        val description: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBotInfo"),
        level = DeprecationLevel.ERROR
    )
    class BotInfo(
        val description: String,
        val commands: Array<BotCommand>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatLocation"),
        level = DeprecationLevel.ERROR
    )
    class ChatLocation(
        val location: Location,
        val address: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUser"),
        level = DeprecationLevel.ERROR
    )
    class User(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val username: String,
        val phoneNumber: String,
        val status: UserStatus,
        val profilePhoto: ProfilePhoto?,
        val isContact: Boolean,
        val isMutualContact: Boolean,
        val isVerified: Boolean,
        val isSupport: Boolean,
        val restrictionReason: String,
        val isScam: Boolean,
        val haveAccess: Boolean,
        val type: UserType,
        @TdBotsOnly
        val languageCode: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserFullInfo"),
        level = DeprecationLevel.ERROR
    )
    class UserFullInfo(
        val isBlocked: Boolean,
        val canBeCalled: Boolean,
        val hasPrivateCalls: Boolean,
        val needPhoneNumberPrivacyException: Boolean,
        val bio: String,
        val shareText: String,
        val groupInCommonCount: Int,
        val botInfo: BotInfo?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserProfilePhoto"),
        level = DeprecationLevel.ERROR
    )
    class UserProfilePhoto(
        val id: Long,
        val addedDate: Int,
        val sizes: Array<PhotoSize>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserProfilePhotos"),
        level = DeprecationLevel.ERROR
    )
    class UserProfilePhotos(
        val totalCount: Int,
        val photos: Array<UserProfilePhoto>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUsers"),
        level = DeprecationLevel.ERROR
    )
    class Users(
        val totalCount: Int,
        val userIds: IntArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAdministrator"),
        level = DeprecationLevel.ERROR
    )
    class ChatAdministrator(
        val userId: Int,
        val customTitle: String,
        val isOwner: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAdministrators"),
        level = DeprecationLevel.ERROR
    )
    class ChatAdministrators(
        val administrators: Array<ChatAdministrator>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatPermissions"),
        level = DeprecationLevel.ERROR
    )
    class ChatPermissions(
        val canSendMessages: Boolean,
        val canSendMediaMessages: Boolean,
        val canSendPolls: Boolean,
        val canSendOtherMessages: Boolean,
        val canAddWebPagePreviews: Boolean,
        val canChangeInfo: Boolean,
        val canInviteUsers: Boolean,
        val canPinMessages: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMember"),
        level = DeprecationLevel.ERROR
    )
    class ChatMember(
        val userId: Int,
        val inviterUserId: Int,
        val joinedChatDate: Int,
        val status: ChatMemberStatus,
        val botInfo: BotInfo?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembers"),
        level = DeprecationLevel.ERROR
    )
    class ChatMembers(
        val totalCount: Int,
        val members: Array<ChatMember>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBasicGroup"),
        level = DeprecationLevel.ERROR
    )
    class BasicGroup(
        val id: Int,
        val memberCount: Int,
        val status: ChatMemberStatus,
        val isActive: Boolean,
        val upgradedToSupergroupId: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBasicGroupFullInfo"),
        level = DeprecationLevel.ERROR
    )
    class BasicGroupFullInfo(
        val description: String,
        val creatorUserId: Int,
        val members: Array<ChatMember>,
        val inviteLink: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroup"),
        level = DeprecationLevel.ERROR
    )
    class Supergroup(
        val id: Int,
        val username: String,
        val date: Int,
        val status: ChatMemberStatus,
        val memberCount: Int,
        val hasLinkedChat: Boolean,
        val hasLocation: Boolean,
        val signMessages: Boolean,
        val isSlowModeEnabled: Boolean,
        val isChannel: Boolean,
        val isVerified: Boolean,
        val restrictionReason: String,
        val isScam: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupFullInfo"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupFullInfo(
        val description: String,
        val memberCount: Int,
        val administratorCount: Int,
        val restrictedCount: Int,
        val bannedCount: Int,
        val linkedChatId: Long,
        val slowModeDelay: Int,
        val slowModeDelayExpiresIn: Double,
        val canGetMembers: Boolean,
        val canSetUsername: Boolean,
        val canSetStickerSet: Boolean,
        val canSetLocation: Boolean,
        val canViewStatistics: Boolean,
        val isAllHistoryAvailable: Boolean,
        val stickerSetId: Long,
        val location: ChatLocation?,
        val inviteLink: String,
        val upgradedFromBasicGroupId: Int,
        val upgradedFromMaxMessageId: Long
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChat"),
        level = DeprecationLevel.ERROR
    )
    class SecretChat(
        val id: Int,
        val userId: Int,
        val state: SecretChatState,
        val isOutbound: Boolean,
        val ttl: Int,
        val keyHash: ByteArray,
        val layer: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardInfo"),
        level = DeprecationLevel.ERROR
    )
    class MessageForwardInfo(
        val origin: MessageForwardOrigin,
        val date: Int,
        val fromChatId: Long,
        val fromMessageId: Long
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessage"),
        level = DeprecationLevel.ERROR
    )
    class Message(
        val id: Long,
        val senderUserId: Int,
        val chatId: Long,
        val sendingState: MessageSendingState?,
        val schedulingState: MessageSchedulingState?,
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
        val restrictionReason: String,
        val content: MessageContent,
        val replyMarkup: ReplyMarkup?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessages"),
        level = DeprecationLevel.ERROR
    )
    class Messages(
        val totalCount: Int,
        val messages: Array<Message>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFoundMessages"),
        level = DeprecationLevel.ERROR
    )
    class FoundMessages(
        val messages: Array<Message>,
        val nextFromSearchId: Long
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatNotificationSettings"),
        level = DeprecationLevel.ERROR
    )
    class ChatNotificationSettings(
        val useDefaultMuteFor: Boolean,
        val muteFor: Int,
        val useDefaultSound: Boolean,
        val sound: String,
        val useDefaultShowPreview: Boolean,
        val showPreview: Boolean,
        val useDefaultDisablePinnedMessageNotifications: Boolean,
        val disablePinnedMessageNotifications: Boolean,
        val useDefaultDisableMentionNotifications: Boolean,
        val disableMentionNotifications: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdScopeNotificationSettings"),
        level = DeprecationLevel.ERROR
    )
    class ScopeNotificationSettings(
        val muteFor: Int,
        val sound: String,
        val showPreview: Boolean,
        val disablePinnedMessageNotifications: Boolean,
        val disableMentionNotifications: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDraftMessage"),
        level = DeprecationLevel.ERROR
    )
    class DraftMessage(
        val replyToMessageId: Long,
        val inputMessageText: InputMessageContent
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChat"),
        level = DeprecationLevel.ERROR
    )
    class Chat(
        val id: Long,
        val type: ChatType,
        val chatList: ChatList?,
        val title: String,
        val photo: ChatPhoto?,
        val permissions: ChatPermissions,
        val lastMessage: Message?,
        val order: Long,
        val isPinned: Boolean,
        val isMarkedAsUnread: Boolean,
        val isSponsored: Boolean,
        val hasScheduledMessages: Boolean,
        val canBeDeletedOnlyForSelf: Boolean,
        val canBeDeletedForAllUsers: Boolean,
        val canBeReported: Boolean,
        val defaultDisableNotification: Boolean,
        val unreadCount: Int,
        val lastReadInboxMessageId: Long,
        val lastReadOutboxMessageId: Long,
        val unreadMentionCount: Int,
        val notificationSettings: ChatNotificationSettings,
        val actionBar: ChatActionBar?,
        val pinnedMessageId: Long,
        val replyMarkupMessageId: Long,
        val draftMessage: DraftMessage?,
        val clientData: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChats"),
        level = DeprecationLevel.ERROR
    )
    class Chats(
        val chatIds: LongArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatNearby"),
        level = DeprecationLevel.ERROR
    )
    class ChatNearby(
        val chatId: Long,
        val distance: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatsNearby"),
        level = DeprecationLevel.ERROR
    )
    class ChatsNearby(
        val usersNearby: Array<ChatNearby>,
        val supergroupsNearby: Array<ChatNearby>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatInviteLink"),
        level = DeprecationLevel.ERROR
    )
    class ChatInviteLink(
        val inviteLink: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatInviteLinkInfo"),
        level = DeprecationLevel.ERROR
    )
    class ChatInviteLinkInfo(
        val chatId: Long,
        val type: ChatType,
        val title: String,
        val photo: ChatPhoto?,
        val memberCount: Int,
        val memberUserIds: IntArray,
        val isPublic: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButton"),
        level = DeprecationLevel.ERROR
    )
    class KeyboardButton(
        val text: String,
        val type: KeyboardButtonType
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButton"),
        level = DeprecationLevel.ERROR
    )
    class InlineKeyboardButton(
        val text: String,
        val type: InlineKeyboardButtonType
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockCaption"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockCaption(
        val text: RichText,
        val credit: RichText
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockListItem"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockListItem(
        val label: String,
        val pageBlocks: Array<PageBlock>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockTableCell"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockTableCell(
        val text: RichText?,
        val isHeader: Boolean,
        val colspan: Int,
        val rowspan: Int,
        val align: PageBlockHorizontalAlignment,
        val valign: PageBlockVerticalAlignment
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockRelatedArticle"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockRelatedArticle(
        val url: String,
        val title: String?,
        val description: String?,
        val photo: Photo?,
        val author: String?,
        val publishDate: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdWebPageInstantView"),
        level = DeprecationLevel.ERROR
    )
    class WebPageInstantView(
        val pageBlocks: Array<PageBlock>,
        val version: Int,
        val url: String,
        val isRtl: Boolean,
        val isFull: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdWebPage"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddress"),
        level = DeprecationLevel.ERROR
    )
    class Address(
        val countryCode: String,
        val state: String,
        val city: String,
        val streetLine1: String,
        val streetLine2: String,
        val postalCode: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLabeledPricePart"),
        level = DeprecationLevel.ERROR
    )
    class LabeledPricePart(
        val label: String,
        val amount: Long
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInvoice"),
        level = DeprecationLevel.ERROR
    )
    class Invoice(
        val currency: String,
        val priceParts: Array<LabeledPricePart>,
        val isTest: Boolean,
        val needName: Boolean,
        val needPhoneNumber: Boolean,
        val needEmailAddress: Boolean,
        val needShippingAddress: Boolean,
        val sendPhoneNumberToProvider: Boolean,
        val sendEmailAddressToProvider: Boolean,
        val isFlexible: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOrderInfo"),
        level = DeprecationLevel.ERROR
    )
    class OrderInfo(
        val name: String,
        val phoneNumber: String,
        val emailAddress: String,
        val shippingAddress: Address?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdShippingOption"),
        level = DeprecationLevel.ERROR
    )
    class ShippingOption(
        val id: String,
        val title: String,
        val priceParts: Array<LabeledPricePart>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSavedCredentials"),
        level = DeprecationLevel.ERROR
    )
    class SavedCredentials(
        val id: String,
        val title: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentsProviderStripe"),
        level = DeprecationLevel.ERROR
    )
    class PaymentsProviderStripe(
        val publishableKey: String,
        val needCountry: Boolean,
        val needPostalCode: Boolean,
        val needCardholderName: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentForm"),
        level = DeprecationLevel.ERROR
    )
    class PaymentForm(
        val invoice: Invoice,
        val url: String,
        val paymentsProvider: PaymentsProviderStripe?,
        val savedOrderInfo: OrderInfo?,
        val savedCredentials: SavedCredentials?,
        val canSaveCredentials: Boolean,
        val needPassword: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdValidatedOrderInfo"),
        level = DeprecationLevel.ERROR
    )
    class ValidatedOrderInfo(
        val orderInfoId: String,
        val shippingOptions: Array<ShippingOption>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentResult"),
        level = DeprecationLevel.ERROR
    )
    class PaymentResult(
        val success: Boolean,
        val verificationUrl: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPaymentReceipt"),
        level = DeprecationLevel.ERROR
    )
    class PaymentReceipt(
        val date: Int,
        val paymentsProviderUserId: Int,
        val invoice: Invoice,
        val orderInfo: OrderInfo?,
        val shippingOption: ShippingOption?,
        val credentialsTitle: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDatedFile"),
        level = DeprecationLevel.ERROR
    )
    class DatedFile(
        val file: File,
        val date: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDate"),
        level = DeprecationLevel.ERROR
    )
    class Date(
        val day: Int,
        val month: Int,
        val year: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPersonalDetails"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdIdentityDocument"),
        level = DeprecationLevel.ERROR
    )
    class IdentityDocument(
        val number: String,
        val expiryDate: Date?,
        val frontSide: DatedFile,
        val reverseSide: DatedFile,
        val selfie: DatedFile?,
        val translation: Array<DatedFile>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputIdentityDocument"),
        level = DeprecationLevel.ERROR
    )
    class InputIdentityDocument(
        val number: String,
        val expiryDate: Date,
        val frontSide: InputFile,
        val reverseSide: InputFile,
        val selfie: InputFile,
        val translation: Array<InputFile>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPersonalDocument"),
        level = DeprecationLevel.ERROR
    )
    class PersonalDocument(
        val files: Array<DatedFile>,
        val translation: Array<DatedFile>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPersonalDocument"),
        level = DeprecationLevel.ERROR
    )
    class InputPersonalDocument(
        val files: Array<InputFile>,
        val translation: Array<InputFile>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElements"),
        level = DeprecationLevel.ERROR
    )
    class PassportElements(
        val elements: Array<PassportElement>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementError"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementError(
        val type: PassportElementType,
        val message: String,
        val source: PassportElementErrorSource
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportSuitableElement"),
        level = DeprecationLevel.ERROR
    )
    class PassportSuitableElement(
        val type: PassportElementType,
        val isSelfieRequired: Boolean,
        val isTranslationRequired: Boolean,
        val isNativeNameRequired: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportRequiredElement"),
        level = DeprecationLevel.ERROR
    )
    class PassportRequiredElement(
        val suitableElements: Array<PassportSuitableElement>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportAuthorizationForm"),
        level = DeprecationLevel.ERROR
    )
    class PassportAuthorizationForm(
        val id: Int,
        val requiredElements: Array<PassportRequiredElement>,
        val privacyPolicyUrl: String?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementsWithErrors"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementsWithErrors(
        val elements: Array<PassportElement>,
        val errors: Array<PassportElementError>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEncryptedCredentials"),
        level = DeprecationLevel.ERROR
    )
    class EncryptedCredentials(
        val data: ByteArray,
        val hash: ByteArray,
        val secret: ByteArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEncryptedPassportElement"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementError"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementError(
        val type: PassportElementType,
        val message: String,
        val source: InputPassportElementErrorSource
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputThumbnail"),
        level = DeprecationLevel.ERROR
    )
    class InputThumbnail(
        val thumbnail: InputFile,
        val width: Int,
        val height: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendMessageOptions"),
        level = DeprecationLevel.ERROR
    )
    class SendMessageOptions(
        val disableNotification: Boolean,
        val fromBackground: Boolean,
        val schedulingState: MessageSchedulingState
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickers"),
        level = DeprecationLevel.ERROR
    )
    class Stickers(
        val stickers: Array<Sticker>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEmojis"),
        level = DeprecationLevel.ERROR
    )
    class Emojis(
        val emojis: Array<String>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickerSet"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickerSetInfo"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class StickerSets(
        val totalCount: Int,
        val sets: Array<StickerSetInfo>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProtocol"),
        level = DeprecationLevel.ERROR
    )
    class CallProtocol(
        val udpP2p: Boolean,
        val udpReflector: Boolean,
        val minLayer: Int,
        val maxLayer: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallConnection"),
        level = DeprecationLevel.ERROR
    )
    class CallConnection(
        val id: Long,
        val ip: String,
        val ipv6: String,
        val port: Int,
        val peerTag: ByteArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallId"),
        level = DeprecationLevel.ERROR
    )
    class CallId(
        val id: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCall"),
        level = DeprecationLevel.ERROR
    )
    class Call(
        val id: Int,
        val userId: Int,
        val isOutgoing: Boolean,
        val state: CallState
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPhoneNumberAuthenticationSettings"),
        level = DeprecationLevel.ERROR
    )
    class PhoneNumberAuthenticationSettings(
        val allowFlashCall: Boolean,
        val isCurrentPhoneNumber: Boolean,
        val allowSmsRetrieverApi: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnimations"),
        level = DeprecationLevel.ERROR
    )
    class Animations(
        val animations: Array<Animation>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdImportedContacts"),
        level = DeprecationLevel.ERROR
    )
    class ImportedContacts(
        val userIds: IntArray,
        val importerCount: IntArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdHttpUrl"),
        level = DeprecationLevel.ERROR
    )
    class HttpUrl(
        val url: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResults"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResults(
        val inlineQueryId: Long,
        val nextOffset: String,
        val results: Array<InlineQueryResult>,
        val switchPmText: String,
        val switchPmParameter: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryAnswer"),
        level = DeprecationLevel.ERROR
    )
    class CallbackQueryAnswer(
        val text: String,
        val showAlert: Boolean,
        val url: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCustomRequestResult"),
        level = DeprecationLevel.ERROR
    )
    class CustomRequestResult(
        val result: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGameHighScore"),
        level = DeprecationLevel.ERROR
    )
    class GameHighScore(
        val position: Int,
        val userId: Int,
        val score: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGameHighScores"),
        level = DeprecationLevel.ERROR
    )
    class GameHighScores(
        val scores: Array<GameHighScore>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEvent"),
        level = DeprecationLevel.ERROR
    )
    class ChatEvent(
        val id: Long,
        val date: Int,
        val userId: Int,
        val action: ChatEventAction
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEvents"),
        level = DeprecationLevel.ERROR
    )
    class ChatEvents(
        val events: Array<ChatEvent>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventLogFilters"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventLogFilters(
        val messageEdits: Boolean,
        val messageDeletions: Boolean,
        val messagePins: Boolean,
        val memberJoins: Boolean,
        val memberLeaves: Boolean,
        val memberInvites: Boolean,
        val memberPromotions: Boolean,
        val memberRestrictions: Boolean,
        val infoChanges: Boolean,
        val settingChanges: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackString"),
        level = DeprecationLevel.ERROR
    )
    class LanguagePackString(
        val key: String,
        val value: LanguagePackStringValue
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStrings"),
        level = DeprecationLevel.ERROR
    )
    class LanguagePackStrings(
        val strings: Array<LanguagePackString>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackInfo"),
        level = DeprecationLevel.ERROR
    )
    class LanguagePackInfo(
        val id: String,
        val baseLanguagePackId: String?,
        val name: String,
        val nativeName: String,
        val pluralCode: String,
        val isOfficial: Boolean,
        val isRtl: Boolean,
        val isBeta: Boolean,
        val isInstalled: Boolean,
        val totalStringCount: Int,
        val translatedStringCount: Int,
        val localStringCount: Int,
        val translationUrl: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLocalizationTargetInfo"),
        level = DeprecationLevel.ERROR
    )
    class LocalizationTargetInfo(
        val languagePacks: Array<LanguagePackInfo>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushReceiverId"),
        level = DeprecationLevel.ERROR
    )
    class PushReceiverId(
        val id: Long
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackground"),
        level = DeprecationLevel.ERROR
    )
    class Background(
        val id: Long,
        val isDefault: Boolean,
        val isDark: Boolean,
        val name: String,
        val document: Document?,
        val type: BackgroundType
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgrounds"),
        level = DeprecationLevel.ERROR
    )
    class Backgrounds(
        val backgrounds: Array<Background>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdHashtags"),
        level = DeprecationLevel.ERROR
    )
    class Hashtags(
        val hashtags: Array<String>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotification"),
        level = DeprecationLevel.ERROR
    )
    class Notification(
        val id: Int,
        val date: Int,
        val isSilent: Boolean,
        val type: NotificationType
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroup"),
        level = DeprecationLevel.ERROR
    )
    class NotificationGroup(
        val id: Int,
        val type: NotificationGroupType,
        val chatId: Long,
        val totalCount: Int,
        val notifications: Array<Notification>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonObjectMember"),
        level = DeprecationLevel.ERROR
    )
    class JsonObjectMember(
        val key: String,
        val value: JsonValue
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRules"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRules(
        val rules: Array<UserPrivacySettingRule>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAccountTtl"),
        level = DeprecationLevel.ERROR
    )
    class AccountTtl(
        val days: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSession"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSessions"),
        level = DeprecationLevel.ERROR
    )
    class Sessions(
        val sessions: Array<Session>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectedWebsite"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectedWebsites"),
        level = DeprecationLevel.ERROR
    )
    class ConnectedWebsites(
        val websites: Array<ConnectedWebsite>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPublicMessageLink"),
        level = DeprecationLevel.ERROR
    )
    class PublicMessageLink(
        val link: String,
        val html: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageLinkInfo"),
        level = DeprecationLevel.ERROR
    )
    class MessageLinkInfo(
        val isPublic: Boolean,
        val chatId: Long,
        val message: Message?,
        val forAlbum: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFilePart"),
        level = DeprecationLevel.ERROR
    )
    class FilePart(
        val data: ByteArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatisticsByFileType"),
        level = DeprecationLevel.ERROR
    )
    class StorageStatisticsByFileType(
        val fileType: FileType,
        val size: Long,
        val count: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatisticsByChat"),
        level = DeprecationLevel.ERROR
    )
    class StorageStatisticsByChat(
        val chatId: Long,
        val size: Long,
        val count: Int,
        val byFileType: Array<StorageStatisticsByFileType>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatistics"),
        level = DeprecationLevel.ERROR
    )
    class StorageStatistics(
        val size: Long,
        val count: Int,
        val byChat: Array<StorageStatisticsByChat>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStorageStatisticsFast"),
        level = DeprecationLevel.ERROR
    )
    class StorageStatisticsFast(
        val filesSize: Long,
        val fileCount: Int,
        val databaseSize: Long,
        val languagePackDatabaseSize: Long,
        val logSize: Long
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDatabaseStatistics"),
        level = DeprecationLevel.ERROR
    )
    class DatabaseStatistics(
        val statistics: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatistics"),
        level = DeprecationLevel.ERROR
    )
    class NetworkStatistics(
        val sinceDate: Int,
        val entries: Array<NetworkStatisticsEntry>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAutoDownloadSettings"),
        level = DeprecationLevel.ERROR
    )
    class AutoDownloadSettings(
        val isAutoDownloadEnabled: Boolean,
        val maxPhotoFileSize: Int,
        val maxVideoFileSize: Int,
        val maxOtherFileSize: Int,
        val videoUploadBitrate: Int,
        val preloadLargeVideos: Boolean,
        val preloadNextAudio: Boolean,
        val useLessDataForCalls: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAutoDownloadSettingsPresets"),
        level = DeprecationLevel.ERROR
    )
    class AutoDownloadSettingsPresets(
        val low: AutoDownloadSettings,
        val medium: AutoDownloadSettings,
        val high: AutoDownloadSettings
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrl"),
        level = DeprecationLevel.ERROR
    )
    class TMeUrl(
        val url: String,
        val type: TMeUrlType
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrls"),
        level = DeprecationLevel.ERROR
    )
    class TMeUrls(
        val urls: Array<TMeUrl>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCount"),
        level = DeprecationLevel.ERROR
    )
    class Count(
        val count: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdText"),
        level = DeprecationLevel.ERROR
    )
    class Text(
        val text: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSeconds"),
        level = DeprecationLevel.ERROR
    )
    class Seconds(
        val seconds: Double
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeepLinkInfo"),
        level = DeprecationLevel.ERROR
    )
    class DeepLinkInfo(
        val text: FormattedText,
        val needUpdateApplication: Boolean
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxy"),
        level = DeprecationLevel.ERROR
    )
    class Proxy(
        val id: Int,
        val server: String,
        val port: Int,
        val lastUsedDate: Int,
        val isEnabled: Boolean,
        val type: ProxyType
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxies"),
        level = DeprecationLevel.ERROR
    )
    class Proxies(
        val proxies: Array<Proxy>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputSticker"),
        level = DeprecationLevel.ERROR
    )
    class InputSticker(
        val pngSticker: InputFile,
        val emojis: String,
        val maskPosition: MaskPosition?
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdates"),
        level = DeprecationLevel.ERROR
    )
    class Updates(
        val updates: Array<Update>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogVerbosityLevel"),
        level = DeprecationLevel.ERROR
    )
    class LogVerbosityLevel(
        val verbosityLevel: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogTags"),
        level = DeprecationLevel.ERROR
    )
    class LogTags(
        val tags: Array<String>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestInt"),
        level = DeprecationLevel.ERROR
    )
    class TestInt(
        val value: Int
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestString"),
        level = DeprecationLevel.ERROR
    )
    class TestString(
        val value: String
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestBytes"),
        level = DeprecationLevel.ERROR
    )
    class TestBytes(
        val value: ByteArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorInt"),
        level = DeprecationLevel.ERROR
    )
    class TestVectorInt(
        val value: IntArray
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorIntObject"),
        level = DeprecationLevel.ERROR
    )
    class TestVectorIntObject(
        val value: Array<TestInt>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorString"),
        level = DeprecationLevel.ERROR
    )
    class TestVectorString(
        val value: Array<String>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestVectorStringObject"),
        level = DeprecationLevel.ERROR
    )
    class TestVectorStringObject(
        val value: Array<TestString>
    ) : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAuthorizationState"),
        level = DeprecationLevel.ERROR
    )
    class GetAuthorizationState : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetTdlibParameters"),
        level = DeprecationLevel.ERROR
    )
    class SetTdlibParameters(
        val parameters: TdlibParameters? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckDatabaseEncryptionKey"),
        level = DeprecationLevel.ERROR
    )
    class CheckDatabaseEncryptionKey(
        val encryptionKey: ByteArray = byteArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAuthenticationPhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class SetAuthenticationPhoneNumber(
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendAuthenticationCode"),
        level = DeprecationLevel.ERROR
    )
    class ResendAuthenticationCode : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckAuthenticationCode"),
        level = DeprecationLevel.ERROR
    )
    class CheckAuthenticationCode(
        val code: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRequestQrCodeAuthentication"),
        level = DeprecationLevel.ERROR
    )
    class RequestQrCodeAuthentication(
        val otherUserIds: IntArray = intArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRegisterUser"),
        level = DeprecationLevel.ERROR
    )
    class RegisterUser(
        val firstName: String? = null,
        val lastName: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckAuthenticationPassword"),
        level = DeprecationLevel.ERROR
    )
    class CheckAuthenticationPassword(
        val password: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRequestAuthenticationPasswordRecovery"),
        level = DeprecationLevel.ERROR
    )
    class RequestAuthenticationPasswordRecovery : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRecoverAuthenticationPassword"),
        level = DeprecationLevel.ERROR
    )
    class RecoverAuthenticationPassword(
        val recoveryCode: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckAuthenticationBotToken"),
        level = DeprecationLevel.ERROR
    )
    class CheckAuthenticationBotToken(
        val token: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogOut"),
        level = DeprecationLevel.ERROR
    )
    class LogOut : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClose"),
        level = DeprecationLevel.ERROR
    )
    class Close : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDestroy"),
        level = DeprecationLevel.ERROR
    )
    class Destroy : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConfirmQrCodeAuthentication"),
        level = DeprecationLevel.ERROR
    )
    class ConfirmQrCodeAuthentication(
        val link: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCurrentState"),
        level = DeprecationLevel.ERROR
    )
    class GetCurrentState : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetDatabaseEncryptionKey"),
        level = DeprecationLevel.ERROR
    )
    class SetDatabaseEncryptionKey(
        val newEncryptionKey: ByteArray = byteArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPasswordState"),
        level = DeprecationLevel.ERROR
    )
    class GetPasswordState : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPassword"),
        level = DeprecationLevel.ERROR
    )
    class SetPassword(
        val oldPassword: String? = null,
        val newPassword: String? = null,
        val newHint: String? = null,
        val setRecoveryEmailAddress: Boolean = false,
        val newRecoveryEmailAddress: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecoveryEmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class GetRecoveryEmailAddress(
        val password: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetRecoveryEmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class SetRecoveryEmailAddress(
        val password: String? = null,
        val newRecoveryEmailAddress: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckRecoveryEmailAddressCode"),
        level = DeprecationLevel.ERROR
    )
    class CheckRecoveryEmailAddressCode(
        val code: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendRecoveryEmailAddressCode"),
        level = DeprecationLevel.ERROR
    )
    class ResendRecoveryEmailAddressCode : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRequestPasswordRecovery"),
        level = DeprecationLevel.ERROR
    )
    class RequestPasswordRecovery : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRecoverPassword"),
        level = DeprecationLevel.ERROR
    )
    class RecoverPassword(
        val recoveryCode: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateTemporaryPassword"),
        level = DeprecationLevel.ERROR
    )
    class CreateTemporaryPassword(
        val password: String? = null,
        val validFor: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTemporaryPasswordState"),
        level = DeprecationLevel.ERROR
    )
    class GetTemporaryPasswordState : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMe"),
        level = DeprecationLevel.ERROR
    )
    class GetMe : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUser"),
        level = DeprecationLevel.ERROR
    )
    class GetUser(
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUserFullInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetUserFullInfo(
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBasicGroup"),
        level = DeprecationLevel.ERROR
    )
    class GetBasicGroup(
        val basicGroupId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBasicGroupFullInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetBasicGroupFullInfo(
        val basicGroupId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupergroup"),
        level = DeprecationLevel.ERROR
    )
    class GetSupergroup(
        val supergroupId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupergroupFullInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetSupergroupFullInfo(
        val supergroupId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSecretChat"),
        level = DeprecationLevel.ERROR
    )
    class GetSecretChat(
        val secretChatId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChat"),
        level = DeprecationLevel.ERROR
    )
    class GetChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessage"),
        level = DeprecationLevel.ERROR
    )
    class GetMessage(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessageLocally"),
        level = DeprecationLevel.ERROR
    )
    class GetMessageLocally(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRepliedMessage"),
        level = DeprecationLevel.ERROR
    )
    class GetRepliedMessage(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatPinnedMessage"),
        level = DeprecationLevel.ERROR
    )
    class GetChatPinnedMessage(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessages"),
        level = DeprecationLevel.ERROR
    )
    class GetMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFile"),
        level = DeprecationLevel.ERROR
    )
    class GetFile(
        val fileId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRemoteFile"),
        level = DeprecationLevel.ERROR
    )
    class GetRemoteFile(
        val remoteFileId: String? = null,
        val fileType: FileType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChats"),
        level = DeprecationLevel.ERROR
    )
    class GetChats(
        val chatList: ChatList? = null,
        val offsetOrder: Long = 0L,
        val offsetChatId: Long = 0L,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchPublicChat"),
        level = DeprecationLevel.ERROR
    )
    class SearchPublicChat(
        val username: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchPublicChats"),
        level = DeprecationLevel.ERROR
    )
    class SearchPublicChats(
        val query: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChats"),
        level = DeprecationLevel.ERROR
    )
    class SearchChats(
        val query: String? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatsOnServer"),
        level = DeprecationLevel.ERROR
    )
    class SearchChatsOnServer(
        val query: String? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatsNearby"),
        level = DeprecationLevel.ERROR
    )
    class SearchChatsNearby(
        val location: Location? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTopChats"),
        level = DeprecationLevel.ERROR
    )
    class GetTopChats(
        val category: TopChatCategory? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveTopChat"),
        level = DeprecationLevel.ERROR
    )
    class RemoveTopChat(
        val category: TopChatCategory? = null,
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddRecentlyFoundChat"),
        level = DeprecationLevel.ERROR
    )
    class AddRecentlyFoundChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveRecentlyFoundChat"),
        level = DeprecationLevel.ERROR
    )
    class RemoveRecentlyFoundChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearRecentlyFoundChats"),
        level = DeprecationLevel.ERROR
    )
    class ClearRecentlyFoundChats : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsername"),
        level = DeprecationLevel.ERROR
    )
    class CheckChatUsername(
        val chatId: Long = 0L,
        val username: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCreatedPublicChats"),
        level = DeprecationLevel.ERROR
    )
    class GetCreatedPublicChats(
        val type: PublicChatType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckCreatedPublicChatsLimit"),
        level = DeprecationLevel.ERROR
    )
    class CheckCreatedPublicChatsLimit(
        val type: PublicChatType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSuitableDiscussionChats"),
        level = DeprecationLevel.ERROR
    )
    class GetSuitableDiscussionChats : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInactiveSupergroupChats"),
        level = DeprecationLevel.ERROR
    )
    class GetInactiveSupergroupChats : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetGroupsInCommon"),
        level = DeprecationLevel.ERROR
    )
    class GetGroupsInCommon(
        val userId: Int = 0,
        val offsetChatId: Long = 0L,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatHistory"),
        level = DeprecationLevel.ERROR
    )
    class GetChatHistory(
        val chatId: Long = 0L,
        val fromMessageId: Long = 0L,
        val offset: Int = 0,
        val limit: Int = 0,
        val onlyLocal: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteChatHistory"),
        level = DeprecationLevel.ERROR
    )
    class DeleteChatHistory(
        val chatId: Long = 0L,
        val removeFromChatList: Boolean = false,
        val revoke: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatMessages"),
        level = DeprecationLevel.ERROR
    )
    class SearchChatMessages(
        val chatId: Long = 0L,
        val query: String? = null,
        val senderUserId: Int = 0,
        val fromMessageId: Long = 0L,
        val offset: Int = 0,
        val limit: Int = 0,
        val filter: SearchMessagesFilter? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessages"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessages(
        val chatList: ChatList? = null,
        val query: String? = null,
        val offsetDate: Int = 0,
        val offsetChatId: Long = 0L,
        val offsetMessageId: Long = 0L,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchSecretMessages"),
        level = DeprecationLevel.ERROR
    )
    class SearchSecretMessages(
        val chatId: Long = 0L,
        val query: String? = null,
        val fromSearchId: Long = 0L,
        val limit: Int = 0,
        val filter: SearchMessagesFilter? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchCallMessages"),
        level = DeprecationLevel.ERROR
    )
    class SearchCallMessages(
        val fromMessageId: Long = 0L,
        val limit: Int = 0,
        val onlyMissed: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatRecentLocationMessages"),
        level = DeprecationLevel.ERROR
    )
    class SearchChatRecentLocationMessages(
        val chatId: Long = 0L,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetActiveLiveLocationMessages"),
        level = DeprecationLevel.ERROR
    )
    class GetActiveLiveLocationMessages : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatMessageByDate"),
        level = DeprecationLevel.ERROR
    )
    class GetChatMessageByDate(
        val chatId: Long = 0L,
        val date: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatMessageCount"),
        level = DeprecationLevel.ERROR
    )
    class GetChatMessageCount(
        val chatId: Long = 0L,
        val filter: SearchMessagesFilter? = null,
        val returnLocal: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatScheduledMessages"),
        level = DeprecationLevel.ERROR
    )
    class GetChatScheduledMessages(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveNotification"),
        level = DeprecationLevel.ERROR
    )
    class RemoveNotification(
        val notificationGroupId: Int = 0,
        val notificationId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveNotificationGroup"),
        level = DeprecationLevel.ERROR
    )
    class RemoveNotificationGroup(
        val notificationGroupId: Int = 0,
        val maxNotificationId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPublicMessageLink"),
        level = DeprecationLevel.ERROR
    )
    class GetPublicMessageLink(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val forAlbum: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessageLink"),
        level = DeprecationLevel.ERROR
    )
    class GetMessageLink(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMessageLinkInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetMessageLinkInfo(
        val url: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendMessage"),
        level = DeprecationLevel.ERROR
    )
    class SendMessage(
        val chatId: Long = 0L,
        val replyToMessageId: Long = 0L,
        val options: SendMessageOptions? = null,
        val inputMessageContent: InputMessageContent? = null,
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendMessageAlbum"),
        level = DeprecationLevel.ERROR
    )
    class SendMessageAlbum(
        val chatId: Long = 0L,
        val replyToMessageId: Long = 0L,
        val options: SendMessageOptions? = null,
        val inputMessageContents: Array<InputMessageContent> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendBotStartMessage"),
        level = DeprecationLevel.ERROR
    )
    class SendBotStartMessage(
        val botUserId: Int = 0,
        val chatId: Long = 0L,
        val parameter: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendInlineQueryResultMessage"),
        level = DeprecationLevel.ERROR
    )
    class SendInlineQueryResultMessage(
        val chatId: Long = 0L,
        val replyToMessageId: Long = 0L,
        val options: SendMessageOptions? = null,
        val queryId: Long = 0L,
        val resultId: String? = null,
        val hideViaBot: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdForwardMessages"),
        level = DeprecationLevel.ERROR
    )
    class ForwardMessages(
        val chatId: Long = 0L,
        val fromChatId: Long = 0L,
        val messageIds: LongArray = longArrayOf(),
        val options: SendMessageOptions? = null,
        val asAlbum: Boolean = false,
        val sendCopy: Boolean = false,
        val removeCaption: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendMessages"),
        level = DeprecationLevel.ERROR
    )
    class ResendMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendChatSetTtlMessage"),
        level = DeprecationLevel.ERROR
    )
    class SendChatSetTtlMessage(
        val chatId: Long = 0L,
        val ttl: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendChatScreenshotTakenNotification"),
        level = DeprecationLevel.ERROR
    )
    class SendChatScreenshotTakenNotification(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddLocalMessage"),
        level = DeprecationLevel.ERROR
    )
    class AddLocalMessage(
        val chatId: Long = 0L,
        val senderUserId: Int = 0,
        val replyToMessageId: Long = 0L,
        val disableNotification: Boolean = false,
        val inputMessageContent: InputMessageContent? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteMessages"),
        level = DeprecationLevel.ERROR
    )
    class DeleteMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf(),
        val revoke: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteChatMessagesFromUser"),
        level = DeprecationLevel.ERROR
    )
    class DeleteChatMessagesFromUser(
        val chatId: Long = 0L,
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageText"),
        level = DeprecationLevel.ERROR
    )
    class EditMessageText(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val inputMessageContent: InputMessageContent? = null,
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageLiveLocation"),
        level = DeprecationLevel.ERROR
    )
    class EditMessageLiveLocation(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val location: Location? = null,
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageMedia"),
        level = DeprecationLevel.ERROR
    )
    class EditMessageMedia(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val inputMessageContent: InputMessageContent? = null,
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageCaption"),
        level = DeprecationLevel.ERROR
    )
    class EditMessageCaption(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val caption: FormattedText? = null,
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageReplyMarkup"),
        level = DeprecationLevel.ERROR
    )
    class EditMessageReplyMarkup(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageText"),
        level = DeprecationLevel.ERROR
    )
    class EditInlineMessageText(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null,
        val inputMessageContent: InputMessageContent? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageLiveLocation"),
        level = DeprecationLevel.ERROR
    )
    class EditInlineMessageLiveLocation(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null,
        val location: Location? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageMedia"),
        level = DeprecationLevel.ERROR
    )
    class EditInlineMessageMedia(
        val inlineMessageId: String? = null,
        val inputMessageContent: InputMessageContent? = null,
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageCaption"),
        level = DeprecationLevel.ERROR
    )
    class EditInlineMessageCaption(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null,
        val caption: FormattedText? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditInlineMessageReplyMarkup"),
        level = DeprecationLevel.ERROR
    )
    class EditInlineMessageReplyMarkup(
        val inlineMessageId: String? = null,
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditMessageSchedulingState"),
        level = DeprecationLevel.ERROR
    )
    class EditMessageSchedulingState(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val schedulingState: MessageSchedulingState? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTextEntities"),
        level = DeprecationLevel.ERROR
    )
    class GetTextEntities(
        val text: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdParseTextEntities"),
        level = DeprecationLevel.ERROR
    )
    class ParseTextEntities(
        val text: String? = null,
        val parseMode: TextParseMode? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFileMimeType"),
        level = DeprecationLevel.ERROR
    )
    class GetFileMimeType(
        val fileName: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFileExtension"),
        level = DeprecationLevel.ERROR
    )
    class GetFileExtension(
        val mimeType: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCleanFileName"),
        level = DeprecationLevel.ERROR
    )
    class CleanFileName(
        val fileName: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLanguagePackString"),
        level = DeprecationLevel.ERROR
    )
    class GetLanguagePackString(
        val languagePackDatabasePath: String? = null,
        val localizationTarget: String? = null,
        val languagePackId: String? = null,
        val key: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetJsonValue"),
        level = DeprecationLevel.ERROR
    )
    class GetJsonValue(
        val json: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetJsonString"),
        level = DeprecationLevel.ERROR
    )
    class GetJsonString(
        val jsonValue: JsonValue? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPollAnswer"),
        level = DeprecationLevel.ERROR
    )
    class SetPollAnswer(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val optionIds: IntArray = intArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPollVoters"),
        level = DeprecationLevel.ERROR
    )
    class GetPollVoters(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val optionId: Int = 0,
        val offset: Int = 0,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdStopPoll"),
        level = DeprecationLevel.ERROR
    )
    class StopPoll(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        @TdBotsOnly
        val replyMarkup: ReplyMarkup? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLoginUrlInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetLoginUrlInfo(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val buttonId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLoginUrl"),
        level = DeprecationLevel.ERROR
    )
    class GetLoginUrl(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val buttonId: Int = 0,
        val allowWriteAccess: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInlineQueryResults"),
        level = DeprecationLevel.ERROR
    )
    class GetInlineQueryResults(
        val botUserId: Int = 0,
        val chatId: Long = 0L,
        val userLocation: Location? = null,
        val query: String? = null,
        val offset: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerInlineQuery"),
        level = DeprecationLevel.ERROR
    )
    class AnswerInlineQuery(
        val inlineQueryId: Long = 0L,
        val isPersonal: Boolean = false,
        val results: Array<InputInlineQueryResult> = emptyArray(),
        val cacheTime: Int = 0,
        val nextOffset: String? = null,
        val switchPmText: String? = null,
        val switchPmParameter: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCallbackQueryAnswer"),
        level = DeprecationLevel.ERROR
    )
    class GetCallbackQueryAnswer(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val payload: CallbackQueryPayload? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerCallbackQuery"),
        level = DeprecationLevel.ERROR
    )
    class AnswerCallbackQuery(
        val callbackQueryId: Long = 0L,
        val text: String? = null,
        val showAlert: Boolean = false,
        val url: String? = null,
        val cacheTime: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerShippingQuery"),
        level = DeprecationLevel.ERROR
    )
    class AnswerShippingQuery(
        val shippingQueryId: Long = 0L,
        val shippingOptions: Array<ShippingOption> = emptyArray(),
        val errorMessage: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerPreCheckoutQuery"),
        level = DeprecationLevel.ERROR
    )
    class AnswerPreCheckoutQuery(
        val preCheckoutQueryId: Long = 0L,
        val errorMessage: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetGameScore"),
        level = DeprecationLevel.ERROR
    )
    class SetGameScore(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val editMessage: Boolean = false,
        val userId: Int = 0,
        val score: Int = 0,
        val force: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetInlineGameScore"),
        level = DeprecationLevel.ERROR
    )
    class SetInlineGameScore(
        val inlineMessageId: String? = null,
        val editMessage: Boolean = false,
        val userId: Int = 0,
        val score: Int = 0,
        val force: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetGameHighScores"),
        level = DeprecationLevel.ERROR
    )
    class GetGameHighScores(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInlineGameHighScores"),
        level = DeprecationLevel.ERROR
    )
    class GetInlineGameHighScores(
        val inlineMessageId: String? = null,
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteChatReplyMarkup"),
        level = DeprecationLevel.ERROR
    )
    class DeleteChatReplyMarkup(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendChatAction"),
        level = DeprecationLevel.ERROR
    )
    class SendChatAction(
        val chatId: Long = 0L,
        val action: ChatAction? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOpenChat"),
        level = DeprecationLevel.ERROR
    )
    class OpenChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCloseChat"),
        level = DeprecationLevel.ERROR
    )
    class CloseChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdViewMessages"),
        level = DeprecationLevel.ERROR
    )
    class ViewMessages(
        val chatId: Long = 0L,
        val messageIds: LongArray = longArrayOf(),
        val forceRead: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOpenMessageContent"),
        level = DeprecationLevel.ERROR
    )
    class OpenMessageContent(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReadAllChatMentions"),
        level = DeprecationLevel.ERROR
    )
    class ReadAllChatMentions(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreatePrivateChat"),
        level = DeprecationLevel.ERROR
    )
    class CreatePrivateChat(
        val userId: Int = 0,
        val force: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateBasicGroupChat"),
        level = DeprecationLevel.ERROR
    )
    class CreateBasicGroupChat(
        val basicGroupId: Int = 0,
        val force: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateSupergroupChat"),
        level = DeprecationLevel.ERROR
    )
    class CreateSupergroupChat(
        val supergroupId: Int = 0,
        val force: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateSecretChat"),
        level = DeprecationLevel.ERROR
    )
    class CreateSecretChat(
        val secretChatId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewBasicGroupChat"),
        level = DeprecationLevel.ERROR
    )
    class CreateNewBasicGroupChat(
        val userIds: IntArray = intArrayOf(),
        val title: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewSupergroupChat"),
        level = DeprecationLevel.ERROR
    )
    class CreateNewSupergroupChat(
        val title: String? = null,
        val isChannel: Boolean = false,
        val description: String? = null,
        val location: ChatLocation? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewSecretChat"),
        level = DeprecationLevel.ERROR
    )
    class CreateNewSecretChat(
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpgradeBasicGroupChatToSupergroupChat"),
        level = DeprecationLevel.ERROR
    )
    class UpgradeBasicGroupChatToSupergroupChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatChatList"),
        level = DeprecationLevel.ERROR
    )
    class SetChatChatList(
        val chatId: Long = 0L,
        val chatList: ChatList? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatTitle"),
        level = DeprecationLevel.ERROR
    )
    class SetChatTitle(
        val chatId: Long = 0L,
        val title: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatPhoto"),
        level = DeprecationLevel.ERROR
    )
    class SetChatPhoto(
        val chatId: Long = 0L,
        val photo: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatPermissions"),
        level = DeprecationLevel.ERROR
    )
    class SetChatPermissions(
        val chatId: Long = 0L,
        val permissions: ChatPermissions? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatDraftMessage"),
        level = DeprecationLevel.ERROR
    )
    class SetChatDraftMessage(
        val chatId: Long = 0L,
        val draftMessage: DraftMessage? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatNotificationSettings"),
        level = DeprecationLevel.ERROR
    )
    class SetChatNotificationSettings(
        val chatId: Long = 0L,
        val notificationSettings: ChatNotificationSettings? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleChatIsPinned"),
        level = DeprecationLevel.ERROR
    )
    class ToggleChatIsPinned(
        val chatId: Long = 0L,
        val isPinned: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleChatIsMarkedAsUnread"),
        level = DeprecationLevel.ERROR
    )
    class ToggleChatIsMarkedAsUnread(
        val chatId: Long = 0L,
        val isMarkedAsUnread: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleChatDefaultDisableNotification"),
        level = DeprecationLevel.ERROR
    )
    class ToggleChatDefaultDisableNotification(
        val chatId: Long = 0L,
        val defaultDisableNotification: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatClientData"),
        level = DeprecationLevel.ERROR
    )
    class SetChatClientData(
        val chatId: Long = 0L,
        val clientData: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatDescription"),
        level = DeprecationLevel.ERROR
    )
    class SetChatDescription(
        val chatId: Long = 0L,
        val description: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatDiscussionGroup"),
        level = DeprecationLevel.ERROR
    )
    class SetChatDiscussionGroup(
        val chatId: Long = 0L,
        val discussionChatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatLocation"),
        level = DeprecationLevel.ERROR
    )
    class SetChatLocation(
        val chatId: Long = 0L,
        val location: ChatLocation? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatSlowModeDelay"),
        level = DeprecationLevel.ERROR
    )
    class SetChatSlowModeDelay(
        val chatId: Long = 0L,
        val slowModeDelay: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPinChatMessage"),
        level = DeprecationLevel.ERROR
    )
    class PinChatMessage(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val disableNotification: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUnpinChatMessage"),
        level = DeprecationLevel.ERROR
    )
    class UnpinChatMessage(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJoinChat"),
        level = DeprecationLevel.ERROR
    )
    class JoinChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLeaveChat"),
        level = DeprecationLevel.ERROR
    )
    class LeaveChat(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddChatMember"),
        level = DeprecationLevel.ERROR
    )
    class AddChatMember(
        val chatId: Long = 0L,
        val userId: Int = 0,
        val forwardLimit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddChatMembers"),
        level = DeprecationLevel.ERROR
    )
    class AddChatMembers(
        val chatId: Long = 0L,
        val userIds: IntArray = intArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetChatMemberStatus"),
        level = DeprecationLevel.ERROR
    )
    class SetChatMemberStatus(
        val chatId: Long = 0L,
        val userId: Int = 0,
        val status: ChatMemberStatus? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCanTransferOwnership"),
        level = DeprecationLevel.ERROR
    )
    class CanTransferOwnership : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTransferChatOwnership"),
        level = DeprecationLevel.ERROR
    )
    class TransferChatOwnership(
        val chatId: Long = 0L,
        val userId: Int = 0,
        val password: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatMember"),
        level = DeprecationLevel.ERROR
    )
    class GetChatMember(
        val chatId: Long = 0L,
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchChatMembers"),
        level = DeprecationLevel.ERROR
    )
    class SearchChatMembers(
        val chatId: Long = 0L,
        val query: String? = null,
        val limit: Int = 0,
        val filter: ChatMembersFilter? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatAdministrators"),
        level = DeprecationLevel.ERROR
    )
    class GetChatAdministrators(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearAllDraftMessages"),
        level = DeprecationLevel.ERROR
    )
    class ClearAllDraftMessages(
        val excludeSecretChats: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatNotificationSettingsExceptions"),
        level = DeprecationLevel.ERROR
    )
    class GetChatNotificationSettingsExceptions(
        val scope: NotificationSettingsScope? = null,
        val compareSound: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetScopeNotificationSettings"),
        level = DeprecationLevel.ERROR
    )
    class GetScopeNotificationSettings(
        val scope: NotificationSettingsScope? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetScopeNotificationSettings"),
        level = DeprecationLevel.ERROR
    )
    class SetScopeNotificationSettings(
        val scope: NotificationSettingsScope? = null,
        val notificationSettings: ScopeNotificationSettings? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResetAllNotificationSettings"),
        level = DeprecationLevel.ERROR
    )
    class ResetAllNotificationSettings : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPinnedChats"),
        level = DeprecationLevel.ERROR
    )
    class SetPinnedChats(
        val chatList: ChatList? = null,
        val chatIds: LongArray = longArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDownloadFile"),
        level = DeprecationLevel.ERROR
    )
    class DownloadFile(
        val fileId: Int = 0,
        val priority: Int = 0,
        val offset: Int = 0,
        val limit: Int = 0,
        val synchronous: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFileDownloadedPrefixSize"),
        level = DeprecationLevel.ERROR
    )
    class GetFileDownloadedPrefixSize(
        val fileId: Int = 0,
        val offset: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCancelDownloadFile"),
        level = DeprecationLevel.ERROR
    )
    class CancelDownloadFile(
        val fileId: Int = 0,
        val onlyIfPending: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUploadFile"),
        level = DeprecationLevel.ERROR
    )
    class UploadFile(
        val file: InputFile? = null,
        val fileType: FileType? = null,
        val priority: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCancelUploadFile"),
        level = DeprecationLevel.ERROR
    )
    class CancelUploadFile(
        val fileId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdWriteGeneratedFilePart"),
        level = DeprecationLevel.ERROR
    )
    class WriteGeneratedFilePart(
        val generationId: Long = 0L,
        val offset: Int = 0,
        val data: ByteArray = byteArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetFileGenerationProgress"),
        level = DeprecationLevel.ERROR
    )
    class SetFileGenerationProgress(
        val generationId: Long = 0L,
        val expectedSize: Int = 0,
        val localPrefixSize: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFinishFileGeneration"),
        level = DeprecationLevel.ERROR
    )
    class FinishFileGeneration(
        val generationId: Long = 0L,
        val error: Error? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReadFilePart"),
        level = DeprecationLevel.ERROR
    )
    class ReadFilePart(
        val fileId: Int = 0,
        val offset: Int = 0,
        val count: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteFile"),
        level = DeprecationLevel.ERROR
    )
    class DeleteFile(
        val fileId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGenerateChatInviteLink"),
        level = DeprecationLevel.ERROR
    )
    class GenerateChatInviteLink(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatInviteLink"),
        level = DeprecationLevel.ERROR
    )
    class CheckChatInviteLink(
        val inviteLink: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJoinChatByInviteLink"),
        level = DeprecationLevel.ERROR
    )
    class JoinChatByInviteLink(
        val inviteLink: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateCall"),
        level = DeprecationLevel.ERROR
    )
    class CreateCall(
        val userId: Int = 0,
        val protocol: CallProtocol? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAcceptCall"),
        level = DeprecationLevel.ERROR
    )
    class AcceptCall(
        val callId: Int = 0,
        val protocol: CallProtocol? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDiscardCall"),
        level = DeprecationLevel.ERROR
    )
    class DiscardCall(
        val callId: Int = 0,
        val isDisconnected: Boolean = false,
        val duration: Int = 0,
        val connectionId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendCallRating"),
        level = DeprecationLevel.ERROR
    )
    class SendCallRating(
        val callId: Int = 0,
        val rating: Int = 0,
        val comment: String? = null,
        val problems: Array<CallProblem> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendCallDebugInformation"),
        level = DeprecationLevel.ERROR
    )
    class SendCallDebugInformation(
        val callId: Int = 0,
        val debugInformation: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBlockUser"),
        level = DeprecationLevel.ERROR
    )
    class BlockUser(
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUnblockUser"),
        level = DeprecationLevel.ERROR
    )
    class UnblockUser(
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBlockedUsers"),
        level = DeprecationLevel.ERROR
    )
    class GetBlockedUsers(
        val offset: Int = 0,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddContact"),
        level = DeprecationLevel.ERROR
    )
    class AddContact(
        val contact: Contact? = null,
        val sharePhoneNumber: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdImportContacts"),
        level = DeprecationLevel.ERROR
    )
    class ImportContacts(
        val contacts: Array<Contact> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetContacts"),
        level = DeprecationLevel.ERROR
    )
    class GetContacts : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchContacts"),
        level = DeprecationLevel.ERROR
    )
    class SearchContacts(
        val query: String? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveContacts"),
        level = DeprecationLevel.ERROR
    )
    class RemoveContacts(
        val userIds: IntArray = intArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetImportedContactCount"),
        level = DeprecationLevel.ERROR
    )
    class GetImportedContactCount : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChangeImportedContacts"),
        level = DeprecationLevel.ERROR
    )
    class ChangeImportedContacts(
        val contacts: Array<Contact> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearImportedContacts"),
        level = DeprecationLevel.ERROR
    )
    class ClearImportedContacts : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSharePhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class SharePhoneNumber(
        val userId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUserProfilePhotos"),
        level = DeprecationLevel.ERROR
    )
    class GetUserProfilePhotos(
        val userId: Int = 0,
        val offset: Int = 0,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStickers"),
        level = DeprecationLevel.ERROR
    )
    class GetStickers(
        val emoji: String? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchStickers"),
        level = DeprecationLevel.ERROR
    )
    class SearchStickers(
        val emoji: String? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInstalledStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class GetInstalledStickerSets(
        val isMasks: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetArchivedStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class GetArchivedStickerSets(
        val isMasks: Boolean = false,
        val offsetStickerSetId: Long = 0L,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetTrendingStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class GetTrendingStickerSets : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAttachedStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class GetAttachedStickerSets(
        val fileId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStickerSet"),
        level = DeprecationLevel.ERROR
    )
    class GetStickerSet(
        val setId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchStickerSet"),
        level = DeprecationLevel.ERROR
    )
    class SearchStickerSet(
        val name: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchInstalledStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class SearchInstalledStickerSets(
        val isMasks: Boolean = false,
        val query: String? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class SearchStickerSets(
        val query: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChangeStickerSet"),
        level = DeprecationLevel.ERROR
    )
    class ChangeStickerSet(
        val setId: Long = 0L,
        val isInstalled: Boolean = false,
        val isArchived: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdViewTrendingStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class ViewTrendingStickerSets(
        val stickerSetIds: LongArray = longArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReorderInstalledStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class ReorderInstalledStickerSets(
        val isMasks: Boolean = false,
        val stickerSetIds: LongArray = longArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecentStickers"),
        level = DeprecationLevel.ERROR
    )
    class GetRecentStickers(
        val isAttached: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddRecentSticker"),
        level = DeprecationLevel.ERROR
    )
    class AddRecentSticker(
        val isAttached: Boolean = false,
        val sticker: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveRecentSticker"),
        level = DeprecationLevel.ERROR
    )
    class RemoveRecentSticker(
        val isAttached: Boolean = false,
        val sticker: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdClearRecentStickers"),
        level = DeprecationLevel.ERROR
    )
    class ClearRecentStickers(
        val isAttached: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetFavoriteStickers"),
        level = DeprecationLevel.ERROR
    )
    class GetFavoriteStickers : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddFavoriteSticker"),
        level = DeprecationLevel.ERROR
    )
    class AddFavoriteSticker(
        val sticker: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveFavoriteSticker"),
        level = DeprecationLevel.ERROR
    )
    class RemoveFavoriteSticker(
        val sticker: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStickerEmojis"),
        level = DeprecationLevel.ERROR
    )
    class GetStickerEmojis(
        val sticker: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchEmojis"),
        level = DeprecationLevel.ERROR
    )
    class SearchEmojis(
        val text: String? = null,
        val exactMatch: Boolean = false,
        val inputLanguageCode: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetEmojiSuggestionsUrl"),
        level = DeprecationLevel.ERROR
    )
    class GetEmojiSuggestionsUrl(
        val languageCode: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSavedAnimations"),
        level = DeprecationLevel.ERROR
    )
    class GetSavedAnimations : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddSavedAnimation"),
        level = DeprecationLevel.ERROR
    )
    class AddSavedAnimation(
        val animation: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveSavedAnimation"),
        level = DeprecationLevel.ERROR
    )
    class RemoveSavedAnimation(
        val animation: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecentInlineBots"),
        level = DeprecationLevel.ERROR
    )
    class GetRecentInlineBots : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchHashtags"),
        level = DeprecationLevel.ERROR
    )
    class SearchHashtags(
        val prefix: String? = null,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveRecentHashtag"),
        level = DeprecationLevel.ERROR
    )
    class RemoveRecentHashtag(
        val hashtag: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetWebPagePreview"),
        level = DeprecationLevel.ERROR
    )
    class GetWebPagePreview(
        val text: FormattedText? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetWebPageInstantView"),
        level = DeprecationLevel.ERROR
    )
    class GetWebPageInstantView(
        val url: String? = null,
        val forceFull: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetProfilePhoto"),
        level = DeprecationLevel.ERROR
    )
    class SetProfilePhoto(
        val photo: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteProfilePhoto"),
        level = DeprecationLevel.ERROR
    )
    class DeleteProfilePhoto(
        val profilePhotoId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetName"),
        level = DeprecationLevel.ERROR
    )
    class SetName(
        val firstName: String? = null,
        val lastName: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetBio"),
        level = DeprecationLevel.ERROR
    )
    class SetBio(
        val bio: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetUsername"),
        level = DeprecationLevel.ERROR
    )
    class SetUsername(
        val username: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChangePhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class ChangePhoneNumber(
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendChangePhoneNumberCode"),
        level = DeprecationLevel.ERROR
    )
    class ResendChangePhoneNumberCode : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChangePhoneNumberCode"),
        level = DeprecationLevel.ERROR
    )
    class CheckChangePhoneNumberCode(
        val code: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetActiveSessions"),
        level = DeprecationLevel.ERROR
    )
    class GetActiveSessions : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTerminateSession"),
        level = DeprecationLevel.ERROR
    )
    class TerminateSession(
        val sessionId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTerminateAllOtherSessions"),
        level = DeprecationLevel.ERROR
    )
    class TerminateAllOtherSessions : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetConnectedWebsites"),
        level = DeprecationLevel.ERROR
    )
    class GetConnectedWebsites : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDisconnectWebsite"),
        level = DeprecationLevel.ERROR
    )
    class DisconnectWebsite(
        val websiteId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDisconnectAllWebsites"),
        level = DeprecationLevel.ERROR
    )
    class DisconnectAllWebsites : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetSupergroupUsername"),
        level = DeprecationLevel.ERROR
    )
    class SetSupergroupUsername(
        val supergroupId: Int = 0,
        val username: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetSupergroupStickerSet"),
        level = DeprecationLevel.ERROR
    )
    class SetSupergroupStickerSet(
        val supergroupId: Int = 0,
        val stickerSetId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleSupergroupSignMessages"),
        level = DeprecationLevel.ERROR
    )
    class ToggleSupergroupSignMessages(
        val supergroupId: Int = 0,
        val signMessages: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdToggleSupergroupIsAllHistoryAvailable"),
        level = DeprecationLevel.ERROR
    )
    class ToggleSupergroupIsAllHistoryAvailable(
        val supergroupId: Int = 0,
        val isAllHistoryAvailable: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReportSupergroupSpam"),
        level = DeprecationLevel.ERROR
    )
    class ReportSupergroupSpam(
        val supergroupId: Int = 0,
        val userId: Int = 0,
        val messageIds: LongArray = longArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupergroupMembers"),
        level = DeprecationLevel.ERROR
    )
    class GetSupergroupMembers(
        val supergroupId: Int = 0,
        val filter: SupergroupMembersFilter? = null,
        val offset: Int = 0,
        val limit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteSupergroup"),
        level = DeprecationLevel.ERROR
    )
    class DeleteSupergroup(
        val supergroupId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCloseSecretChat"),
        level = DeprecationLevel.ERROR
    )
    class CloseSecretChat(
        val secretChatId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatEventLog"),
        level = DeprecationLevel.ERROR
    )
    class GetChatEventLog(
        val chatId: Long = 0L,
        val query: String? = null,
        val fromEventId: Long = 0L,
        val limit: Int = 0,
        val filters: ChatEventLogFilters? = null,
        val userIds: IntArray = intArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPaymentForm"),
        level = DeprecationLevel.ERROR
    )
    class GetPaymentForm(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdValidateOrderInfo"),
        level = DeprecationLevel.ERROR
    )
    class ValidateOrderInfo(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val orderInfo: OrderInfo? = null,
        val allowSave: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPaymentForm"),
        level = DeprecationLevel.ERROR
    )
    class SendPaymentForm(
        val chatId: Long = 0L,
        val messageId: Long = 0L,
        val orderInfoId: String? = null,
        val shippingOptionId: String? = null,
        val credentials: InputCredentials? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPaymentReceipt"),
        level = DeprecationLevel.ERROR
    )
    class GetPaymentReceipt(
        val chatId: Long = 0L,
        val messageId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSavedOrderInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetSavedOrderInfo : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteSavedOrderInfo"),
        level = DeprecationLevel.ERROR
    )
    class DeleteSavedOrderInfo : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteSavedCredentials"),
        level = DeprecationLevel.ERROR
    )
    class DeleteSavedCredentials : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetSupportUser"),
        level = DeprecationLevel.ERROR
    )
    class GetSupportUser : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBackgrounds"),
        level = DeprecationLevel.ERROR
    )
    class GetBackgrounds(
        val forDarkTheme: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetBackgroundUrl"),
        level = DeprecationLevel.ERROR
    )
    class GetBackgroundUrl(
        val name: String? = null,
        val type: BackgroundType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchBackground"),
        level = DeprecationLevel.ERROR
    )
    class SearchBackground(
        val name: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetBackground"),
        level = DeprecationLevel.ERROR
    )
    class SetBackground(
        val background: InputBackground? = null,
        val type: BackgroundType? = null,
        val forDarkTheme: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveBackground"),
        level = DeprecationLevel.ERROR
    )
    class RemoveBackground(
        val backgroundId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResetBackgrounds"),
        level = DeprecationLevel.ERROR
    )
    class ResetBackgrounds : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLocalizationTargetInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetLocalizationTargetInfo(
        val onlyLocal: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLanguagePackInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetLanguagePackInfo(
        val languagePackId: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLanguagePackStrings"),
        level = DeprecationLevel.ERROR
    )
    class GetLanguagePackStrings(
        val languagePackId: String? = null,
        val keys: Array<String> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSynchronizeLanguagePack"),
        level = DeprecationLevel.ERROR
    )
    class SynchronizeLanguagePack(
        val languagePackId: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddCustomServerLanguagePack"),
        level = DeprecationLevel.ERROR
    )
    class AddCustomServerLanguagePack(
        val languagePackId: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetCustomLanguagePack"),
        level = DeprecationLevel.ERROR
    )
    class SetCustomLanguagePack(
        val info: LanguagePackInfo? = null,
        val strings: Array<LanguagePackString> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditCustomLanguagePackInfo"),
        level = DeprecationLevel.ERROR
    )
    class EditCustomLanguagePackInfo(
        val info: LanguagePackInfo? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetCustomLanguagePackString"),
        level = DeprecationLevel.ERROR
    )
    class SetCustomLanguagePackString(
        val languagePackId: String? = null,
        val newString: LanguagePackString? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteLanguagePack"),
        level = DeprecationLevel.ERROR
    )
    class DeleteLanguagePack(
        val languagePackId: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRegisterDevice"),
        level = DeprecationLevel.ERROR
    )
    class RegisterDevice(
        val deviceToken: DeviceToken? = null,
        val otherUserIds: IntArray = intArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProcessPushNotification"),
        level = DeprecationLevel.ERROR
    )
    class ProcessPushNotification(
        val payload: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPushReceiverId"),
        level = DeprecationLevel.ERROR
    )
    class GetPushReceiverId(
        val payload: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetRecentlyVisitedTMeUrls"),
        level = DeprecationLevel.ERROR
    )
    class GetRecentlyVisitedTMeUrls(
        val referrer: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetUserPrivacySettingRules"),
        level = DeprecationLevel.ERROR
    )
    class SetUserPrivacySettingRules(
        val setting: UserPrivacySetting? = null,
        val rules: UserPrivacySettingRules? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetUserPrivacySettingRules"),
        level = DeprecationLevel.ERROR
    )
    class GetUserPrivacySettingRules(
        val setting: UserPrivacySetting? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetOption"),
        level = DeprecationLevel.ERROR
    )
    class GetOption(
        val name: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetOption"),
        level = DeprecationLevel.ERROR
    )
    class SetOption(
        val name: String? = null,
        val value: OptionValue? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAccountTtl"),
        level = DeprecationLevel.ERROR
    )
    class SetAccountTtl(
        val ttl: AccountTtl? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAccountTtl"),
        level = DeprecationLevel.ERROR
    )
    class GetAccountTtl : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeleteAccount"),
        level = DeprecationLevel.ERROR
    )
    class DeleteAccount(
        val reason: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveChatActionBar"),
        level = DeprecationLevel.ERROR
    )
    class RemoveChatActionBar(
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReportChat"),
        level = DeprecationLevel.ERROR
    )
    class ReportChat(
        val chatId: Long = 0L,
        val reason: ChatReportReason? = null,
        val messageIds: LongArray = longArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetChatStatisticsUrl"),
        level = DeprecationLevel.ERROR
    )
    class GetChatStatisticsUrl(
        val chatId: Long = 0L,
        val parameters: String? = null,
        val isDark: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStorageStatistics"),
        level = DeprecationLevel.ERROR
    )
    class GetStorageStatistics(
        val chatLimit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetStorageStatisticsFast"),
        level = DeprecationLevel.ERROR
    )
    class GetStorageStatisticsFast : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetDatabaseStatistics"),
        level = DeprecationLevel.ERROR
    )
    class GetDatabaseStatistics : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptimizeStorage"),
        level = DeprecationLevel.ERROR
    )
    class OptimizeStorage(
        val size: Long = 0L,
        val ttl: Int = 0,
        val count: Int = 0,
        val immunityDelay: Int = 0,
        val fileTypes: Array<FileType> = emptyArray(),
        val chatIds: LongArray = longArrayOf(),
        val excludeChatIds: LongArray = longArrayOf(),
        val chatLimit: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetNetworkType"),
        level = DeprecationLevel.ERROR
    )
    class SetNetworkType(
        val type: NetworkType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetNetworkStatistics"),
        level = DeprecationLevel.ERROR
    )
    class GetNetworkStatistics(
        val onlyCurrent: Boolean = false
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddNetworkStatistics"),
        level = DeprecationLevel.ERROR
    )
    class AddNetworkStatistics(
        val entry: NetworkStatisticsEntry? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResetNetworkStatistics"),
        level = DeprecationLevel.ERROR
    )
    class ResetNetworkStatistics : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAutoDownloadSettingsPresets"),
        level = DeprecationLevel.ERROR
    )
    class GetAutoDownloadSettingsPresets : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAutoDownloadSettings"),
        level = DeprecationLevel.ERROR
    )
    class SetAutoDownloadSettings(
        val settings: AutoDownloadSettings? = null,
        val type: NetworkType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPassportElement"),
        level = DeprecationLevel.ERROR
    )
    class GetPassportElement(
        val type: PassportElementType? = null,
        val password: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetAllPassportElements"),
        level = DeprecationLevel.ERROR
    )
    class GetAllPassportElements(
        val password: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPassportElement"),
        level = DeprecationLevel.ERROR
    )
    class SetPassportElement(
        val element: InputPassportElement? = null,
        val password: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeletePassportElement"),
        level = DeprecationLevel.ERROR
    )
    class DeletePassportElement(
        val type: PassportElementType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetPassportElementErrors"),
        level = DeprecationLevel.ERROR
    )
    class SetPassportElementErrors(
        val userId: Int = 0,
        val errors: Array<InputPassportElementError> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPreferredCountryLanguage"),
        level = DeprecationLevel.ERROR
    )
    class GetPreferredCountryLanguage(
        val countryCode: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPhoneNumberVerificationCode"),
        level = DeprecationLevel.ERROR
    )
    class SendPhoneNumberVerificationCode(
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendPhoneNumberVerificationCode"),
        level = DeprecationLevel.ERROR
    )
    class ResendPhoneNumberVerificationCode : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckPhoneNumberVerificationCode"),
        level = DeprecationLevel.ERROR
    )
    class CheckPhoneNumberVerificationCode(
        val code: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendEmailAddressVerificationCode"),
        level = DeprecationLevel.ERROR
    )
    class SendEmailAddressVerificationCode(
        val emailAddress: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendEmailAddressVerificationCode"),
        level = DeprecationLevel.ERROR
    )
    class ResendEmailAddressVerificationCode : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckEmailAddressVerificationCode"),
        level = DeprecationLevel.ERROR
    )
    class CheckEmailAddressVerificationCode(
        val code: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPassportAuthorizationForm"),
        level = DeprecationLevel.ERROR
    )
    class GetPassportAuthorizationForm(
        val botUserId: Int = 0,
        val scope: String? = null,
        val publicKey: String? = null,
        val nonce: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetPassportAuthorizationFormAvailableElements"),
        level = DeprecationLevel.ERROR
    )
    class GetPassportAuthorizationFormAvailableElements(
        val autorizationFormId: Int = 0,
        val password: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPassportAuthorizationForm"),
        level = DeprecationLevel.ERROR
    )
    class SendPassportAuthorizationForm(
        val autorizationFormId: Int = 0,
        val types: Array<PassportElementType> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendPhoneNumberConfirmationCode"),
        level = DeprecationLevel.ERROR
    )
    class SendPhoneNumberConfirmationCode(
        val hash: String? = null,
        val phoneNumber: String? = null,
        val settings: PhoneNumberAuthenticationSettings? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdResendPhoneNumberConfirmationCode"),
        level = DeprecationLevel.ERROR
    )
    class ResendPhoneNumberConfirmationCode : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckPhoneNumberConfirmationCode"),
        level = DeprecationLevel.ERROR
    )
    class CheckPhoneNumberConfirmationCode(
        val code: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetBotUpdatesStatus"),
        level = DeprecationLevel.ERROR
    )
    class SetBotUpdatesStatus(
        val pendingUpdateCount: Int = 0,
        val errorMessage: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUploadStickerFile"),
        level = DeprecationLevel.ERROR
    )
    class UploadStickerFile(
        val userId: Int = 0,
        val pngSticker: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCreateNewStickerSet"),
        level = DeprecationLevel.ERROR
    )
    class CreateNewStickerSet(
        val userId: Int = 0,
        val title: String? = null,
        val name: String? = null,
        val isMasks: Boolean = false,
        val stickers: Array<InputSticker> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddStickerToSet"),
        level = DeprecationLevel.ERROR
    )
    class AddStickerToSet(
        val userId: Int = 0,
        val name: String? = null,
        val sticker: InputSticker? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetStickerPositionInSet"),
        level = DeprecationLevel.ERROR
    )
    class SetStickerPositionInSet(
        val sticker: InputFile? = null,
        val position: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveStickerFromSet"),
        level = DeprecationLevel.ERROR
    )
    class RemoveStickerFromSet(
        val sticker: InputFile? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetMapThumbnailFile"),
        level = DeprecationLevel.ERROR
    )
    class GetMapThumbnailFile(
        val location: Location? = null,
        val zoom: Int = 0,
        val width: Int = 0,
        val height: Int = 0,
        val scale: Int = 0,
        val chatId: Long = 0L
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAcceptTermsOfService"),
        level = DeprecationLevel.ERROR
    )
    class AcceptTermsOfService(
        val termsOfServiceId: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSendCustomRequest"),
        level = DeprecationLevel.ERROR
    )
    class SendCustomRequest(
        val method: String? = null,
        val parameters: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAnswerCustomQuery"),
        level = DeprecationLevel.ERROR
    )
    class AnswerCustomQuery(
        val customQueryId: Long = 0L,
        val data: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetAlarm"),
        level = DeprecationLevel.ERROR
    )
    class SetAlarm(
        val seconds: Double = 0.0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetCountryCode"),
        level = DeprecationLevel.ERROR
    )
    class GetCountryCode : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetInviteText"),
        level = DeprecationLevel.ERROR
    )
    class GetInviteText : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetDeepLinkInfo"),
        level = DeprecationLevel.ERROR
    )
    class GetDeepLinkInfo(
        val link: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetApplicationConfig"),
        level = DeprecationLevel.ERROR
    )
    class GetApplicationConfig : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSaveApplicationLogEvent"),
        level = DeprecationLevel.ERROR
    )
    class SaveApplicationLogEvent(
        val type: String? = null,
        val chatId: Long = 0L,
        val data: JsonValue? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddProxy"),
        level = DeprecationLevel.ERROR
    )
    class AddProxy(
        val server: String? = null,
        val port: Int = 0,
        val enable: Boolean = false,
        val type: ProxyType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEditProxy"),
        level = DeprecationLevel.ERROR
    )
    class EditProxy(
        val proxyId: Int = 0,
        val server: String? = null,
        val port: Int = 0,
        val enable: Boolean = false,
        val type: ProxyType? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdEnableProxy"),
        level = DeprecationLevel.ERROR
    )
    class EnableProxy(
        val proxyId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDisableProxy"),
        level = DeprecationLevel.ERROR
    )
    class DisableProxy : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRemoveProxy"),
        level = DeprecationLevel.ERROR
    )
    class RemoveProxy(
        val proxyId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetProxies"),
        level = DeprecationLevel.ERROR
    )
    class GetProxies : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetProxyLink"),
        level = DeprecationLevel.ERROR
    )
    class GetProxyLink(
        val proxyId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPingProxy"),
        level = DeprecationLevel.ERROR
    )
    class PingProxy(
        val proxyId: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetLogStream"),
        level = DeprecationLevel.ERROR
    )
    class SetLogStream(
        val logStream: LogStream? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogStream"),
        level = DeprecationLevel.ERROR
    )
    class GetLogStream : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetLogVerbosityLevel"),
        level = DeprecationLevel.ERROR
    )
    class SetLogVerbosityLevel(
        val newVerbosityLevel: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogVerbosityLevel"),
        level = DeprecationLevel.ERROR
    )
    class GetLogVerbosityLevel : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogTags"),
        level = DeprecationLevel.ERROR
    )
    class GetLogTags : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSetLogTagVerbosityLevel"),
        level = DeprecationLevel.ERROR
    )
    class SetLogTagVerbosityLevel(
        val tag: String? = null,
        val newVerbosityLevel: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdGetLogTagVerbosityLevel"),
        level = DeprecationLevel.ERROR
    )
    class GetLogTagVerbosityLevel(
        val tag: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAddLogMessage"),
        level = DeprecationLevel.ERROR
    )
    class AddLogMessage(
        val verbosityLevel: Int = 0,
        val text: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallEmpty"),
        level = DeprecationLevel.ERROR
    )
    class TestCallEmpty : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallString"),
        level = DeprecationLevel.ERROR
    )
    class TestCallString(
        val x: String? = null
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallBytes"),
        level = DeprecationLevel.ERROR
    )
    class TestCallBytes(
        val x: ByteArray = byteArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorInt"),
        level = DeprecationLevel.ERROR
    )
    class TestCallVectorInt(
        val x: IntArray = intArrayOf()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorIntObject"),
        level = DeprecationLevel.ERROR
    )
    class TestCallVectorIntObject(
        val x: Array<TestInt> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorString"),
        level = DeprecationLevel.ERROR
    )
    class TestCallVectorString(
        val x: Array<String> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestCallVectorStringObject"),
        level = DeprecationLevel.ERROR
    )
    class TestCallVectorStringObject(
        val x: Array<TestString> = emptyArray()
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestSquareInt"),
        level = DeprecationLevel.ERROR
    )
    class TestSquareInt(
        val x: Int = 0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestNetwork"),
        level = DeprecationLevel.ERROR
    )
    class TestNetwork : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestProxy"),
        level = DeprecationLevel.ERROR
    )
    class TestProxy(
        val server: String? = null,
        val port: Int = 0,
        val type: ProxyType? = null,
        val dcId: Int = 0,
        val timeout: Double = 0.0
    ) : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTestGetDifference"),
        level = DeprecationLevel.ERROR
    )
    class TestGetDifference : Function()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeType"),
        level = DeprecationLevel.ERROR
    )
    abstract class AuthenticationCodeType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeType.TelegramMessage"),
        level = DeprecationLevel.ERROR
    )
    class AuthenticationCodeTypeTelegramMessage(
        val length: Int
    ) : AuthenticationCodeType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeType.Sms"),
        level = DeprecationLevel.ERROR
    )
    class AuthenticationCodeTypeSms(
        val length: Int
    ) : AuthenticationCodeType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeType.Call"),
        level = DeprecationLevel.ERROR
    )
    class AuthenticationCodeTypeCall(
        val length: Int
    ) : AuthenticationCodeType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthenticationCodeType.FlashCall"),
        level = DeprecationLevel.ERROR
    )
    class AuthenticationCodeTypeFlashCall(
        val pattern: String
    ) : AuthenticationCodeType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState"),
        level = DeprecationLevel.ERROR
    )
    abstract class AuthorizationState : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.WaitTdlibParameters"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateWaitTdlibParameters : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.WaitEncryptionKey"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateWaitEncryptionKey(
        val isEncrypted: Boolean
    ) : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.WaitPhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateWaitPhoneNumber : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.WaitCode"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateWaitCode(
        val codeInfo: AuthenticationCodeInfo
    ) : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.WaitOtherDeviceConfirmation"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateWaitOtherDeviceConfirmation(
        val link: String
    ) : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.WaitRegistration"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateWaitRegistration(
        val termsOfService: TermsOfService
    ) : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.WaitPassword"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateWaitPassword(
        val passwordHint: String?,
        val hasRecoveryEmailAddress: Boolean,
        val recoveryEmailAddressPattern: String
    ) : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.Ready"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateReady : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.LoggingOut"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateLoggingOut : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.Closing"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateClosing : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdAuthorizationState.Closed"),
        level = DeprecationLevel.ERROR
    )
    class AuthorizationStateClosed : AuthorizationState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFile"),
        level = DeprecationLevel.ERROR
    )
    abstract class InputFile : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFile.Id"),
        level = DeprecationLevel.ERROR
    )
    class InputFileId(
        val id: Int
    ) : InputFile()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFile.Remote"),
        level = DeprecationLevel.ERROR
    )
    class InputFileRemote(
        val id: String
    ) : InputFile()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFile.Local"),
        level = DeprecationLevel.ERROR
    )
    class InputFileLocal(
        val path: String
    ) : InputFile()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputFile.Generated"),
        level = DeprecationLevel.ERROR
    )
    class InputFileGenerated(
        val originalPath: String,
        val conversion: String,
        val expectedSize: Int
    ) : InputFile()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPoint"),
        level = DeprecationLevel.ERROR
    )
    abstract class MaskPoint : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPoint.Forehead"),
        level = DeprecationLevel.ERROR
    )
    class MaskPointForehead : MaskPoint()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPoint.Eyes"),
        level = DeprecationLevel.ERROR
    )
    class MaskPointEyes : MaskPoint()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPoint.Mouth"),
        level = DeprecationLevel.ERROR
    )
    class MaskPointMouth : MaskPoint()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMaskPoint.Chin"),
        level = DeprecationLevel.ERROR
    )
    class MaskPointChin : MaskPoint()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPollType"),
        level = DeprecationLevel.ERROR
    )
    abstract class PollType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPollType.Regular"),
        level = DeprecationLevel.ERROR
    )
    class PollTypeRegular(
        val allowMultipleAnswers: Boolean
    ) : PollType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPollType.Quiz"),
        level = DeprecationLevel.ERROR
    )
    class PollTypeQuiz(
        val correctOptionId: Int
    ) : PollType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserType"),
        level = DeprecationLevel.ERROR
    )
    abstract class UserType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserType.Regular"),
        level = DeprecationLevel.ERROR
    )
    class UserTypeRegular : UserType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserType.Deleted"),
        level = DeprecationLevel.ERROR
    )
    class UserTypeDeleted : UserType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserType.Bot"),
        level = DeprecationLevel.ERROR
    )
    class UserTypeBot(
        val canJoinGroups: Boolean,
        val canReadAllGroupMessages: Boolean,
        val isInline: Boolean,
        val inlineQueryPlaceholder: String,
        val needLocation: Boolean
    ) : UserType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserType.Unknown"),
        level = DeprecationLevel.ERROR
    )
    class UserTypeUnknown : UserType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatMemberStatus : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus.Creator"),
        level = DeprecationLevel.ERROR
    )
    class ChatMemberStatusCreator(
        val customTitle: String,
        val isMember: Boolean
    ) : ChatMemberStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus.Administrator"),
        level = DeprecationLevel.ERROR
    )
    class ChatMemberStatusAdministrator(
        val customTitle: String,
        val canBeEdited: Boolean,
        val canChangeInfo: Boolean,
        val canPostMessages: Boolean,
        val canEditMessages: Boolean,
        val canDeleteMessages: Boolean,
        val canInviteUsers: Boolean,
        val canRestrictMembers: Boolean,
        val canPinMessages: Boolean,
        val canPromoteMembers: Boolean
    ) : ChatMemberStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus.Member"),
        level = DeprecationLevel.ERROR
    )
    class ChatMemberStatusMember : ChatMemberStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus.Restricted"),
        level = DeprecationLevel.ERROR
    )
    class ChatMemberStatusRestricted(
        val isMember: Boolean,
        val restrictedUntilDate: Int,
        val permissions: ChatPermissions
    ) : ChatMemberStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus.Left"),
        level = DeprecationLevel.ERROR
    )
    class ChatMemberStatusLeft : ChatMemberStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMemberStatus.Banned"),
        level = DeprecationLevel.ERROR
    )
    class ChatMemberStatusBanned(
        val bannedUntilDate: Int
    ) : ChatMemberStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatMembersFilter : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter.Contacts"),
        level = DeprecationLevel.ERROR
    )
    class ChatMembersFilterContacts : ChatMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter.Administrators"),
        level = DeprecationLevel.ERROR
    )
    class ChatMembersFilterAdministrators : ChatMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter.Members"),
        level = DeprecationLevel.ERROR
    )
    class ChatMembersFilterMembers : ChatMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter.Restricted"),
        level = DeprecationLevel.ERROR
    )
    class ChatMembersFilterRestricted : ChatMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter.Banned"),
        level = DeprecationLevel.ERROR
    )
    class ChatMembersFilterBanned : ChatMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatMembersFilter.Bots"),
        level = DeprecationLevel.ERROR
    )
    class ChatMembersFilterBots : ChatMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter"),
        level = DeprecationLevel.ERROR
    )
    abstract class SupergroupMembersFilter : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter.Recent"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupMembersFilterRecent : SupergroupMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter.Contacts"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupMembersFilterContacts(
        val query: String
    ) : SupergroupMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter.Administrators"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupMembersFilterAdministrators : SupergroupMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter.Search"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupMembersFilterSearch(
        val query: String
    ) : SupergroupMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter.Restricted"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupMembersFilterRestricted(
        val query: String
    ) : SupergroupMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter.Banned"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupMembersFilterBanned(
        val query: String
    ) : SupergroupMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSupergroupMembersFilter.Bots"),
        level = DeprecationLevel.ERROR
    )
    class SupergroupMembersFilterBots : SupergroupMembersFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatState"),
        level = DeprecationLevel.ERROR
    )
    abstract class SecretChatState : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatState.Pending"),
        level = DeprecationLevel.ERROR
    )
    class SecretChatStatePending : SecretChatState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatState.Ready"),
        level = DeprecationLevel.ERROR
    )
    class SecretChatStateReady : SecretChatState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSecretChatState.Closed"),
        level = DeprecationLevel.ERROR
    )
    class SecretChatStateClosed : SecretChatState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOrigin"),
        level = DeprecationLevel.ERROR
    )
    abstract class MessageForwardOrigin : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOrigin.User"),
        level = DeprecationLevel.ERROR
    )
    class MessageForwardOriginUser(
        val senderUserId: Int
    ) : MessageForwardOrigin()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOrigin.HiddenUser"),
        level = DeprecationLevel.ERROR
    )
    class MessageForwardOriginHiddenUser(
        val senderName: String
    ) : MessageForwardOrigin()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageForwardOrigin.Channel"),
        level = DeprecationLevel.ERROR
    )
    class MessageForwardOriginChannel(
        val chatId: Long,
        val messageId: Long,
        val authorSignature: String
    ) : MessageForwardOrigin()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSendingState"),
        level = DeprecationLevel.ERROR
    )
    abstract class MessageSendingState : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSendingState.Pending"),
        level = DeprecationLevel.ERROR
    )
    class MessageSendingStatePending : MessageSendingState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSendingState.Failed"),
        level = DeprecationLevel.ERROR
    )
    class MessageSendingStateFailed(
        val errorCode: Int,
        val errorMessage: String,
        val canRetry: Boolean,
        val retryAfter: Double
    ) : MessageSendingState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScope"),
        level = DeprecationLevel.ERROR
    )
    abstract class NotificationSettingsScope : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScope.PrivateChats"),
        level = DeprecationLevel.ERROR
    )
    class NotificationSettingsScopePrivateChats : NotificationSettingsScope()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScope.GroupChats"),
        level = DeprecationLevel.ERROR
    )
    class NotificationSettingsScopeGroupChats : NotificationSettingsScope()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationSettingsScope.ChannelChats"),
        level = DeprecationLevel.ERROR
    )
    class NotificationSettingsScopeChannelChats : NotificationSettingsScope()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatType"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatType.Private"),
        level = DeprecationLevel.ERROR
    )
    class ChatTypePrivate(
        val userId: Int
    ) : ChatType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatType.BasicGroup"),
        level = DeprecationLevel.ERROR
    )
    class ChatTypeBasicGroup(
        val basicGroupId: Int
    ) : ChatType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatType.Supergroup"),
        level = DeprecationLevel.ERROR
    )
    class ChatTypeSupergroup(
        val supergroupId: Int,
        val isChannel: Boolean
    ) : ChatType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatType.Secret"),
        level = DeprecationLevel.ERROR
    )
    class ChatTypeSecret(
        val secretChatId: Int,
        val userId: Int
    ) : ChatType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatList"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatList : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatList.Main"),
        level = DeprecationLevel.ERROR
    )
    class ChatListMain : ChatList()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatList.Archive"),
        level = DeprecationLevel.ERROR
    )
    class ChatListArchive : ChatList()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPublicChatType"),
        level = DeprecationLevel.ERROR
    )
    abstract class PublicChatType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPublicChatType.HasUsername"),
        level = DeprecationLevel.ERROR
    )
    class PublicChatTypeHasUsername : PublicChatType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPublicChatType.IsLocationBased"),
        level = DeprecationLevel.ERROR
    )
    class PublicChatTypeIsLocationBased : PublicChatType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionBar"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatActionBar : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionBar.ReportSpam"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionBarReportSpam : ChatActionBar()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionBar.ReportUnrelatedLocation"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionBarReportUnrelatedLocation : ChatActionBar()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionBar.ReportAddBlock"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionBarReportAddBlock : ChatActionBar()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionBar.AddContact"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionBarAddContact : ChatActionBar()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatActionBar.SharePhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionBarSharePhoneNumber : ChatActionBar()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonType"),
        level = DeprecationLevel.ERROR
    )
    abstract class KeyboardButtonType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonType.Text"),
        level = DeprecationLevel.ERROR
    )
    class KeyboardButtonTypeText : KeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonType.RequestPhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class KeyboardButtonTypeRequestPhoneNumber : KeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonType.RequestLocation"),
        level = DeprecationLevel.ERROR
    )
    class KeyboardButtonTypeRequestLocation : KeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdKeyboardButtonType.RequestPoll"),
        level = DeprecationLevel.ERROR
    )
    class KeyboardButtonTypeRequestPoll(
        val forceRegular: Boolean,
        val forceQuiz: Boolean
    ) : KeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType"),
        level = DeprecationLevel.ERROR
    )
    abstract class InlineKeyboardButtonType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType.Url"),
        level = DeprecationLevel.ERROR
    )
    class InlineKeyboardButtonTypeUrl(
        val url: String
    ) : InlineKeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType.LoginUrl"),
        level = DeprecationLevel.ERROR
    )
    class InlineKeyboardButtonTypeLoginUrl(
        val url: String,
        val id: Int,
        val forwardText: String
    ) : InlineKeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType.Callback"),
        level = DeprecationLevel.ERROR
    )
    class InlineKeyboardButtonTypeCallback(
        val data: ByteArray
    ) : InlineKeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType.CallbackGame"),
        level = DeprecationLevel.ERROR
    )
    class InlineKeyboardButtonTypeCallbackGame : InlineKeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType.SwitchInline"),
        level = DeprecationLevel.ERROR
    )
    class InlineKeyboardButtonTypeSwitchInline(
        val query: String,
        val inCurrentChat: Boolean
    ) : InlineKeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineKeyboardButtonType.Buy"),
        level = DeprecationLevel.ERROR
    )
    class InlineKeyboardButtonTypeBuy : InlineKeyboardButtonType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkup"),
        level = DeprecationLevel.ERROR
    )
    abstract class ReplyMarkup : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkup.RemoveKeyboard"),
        level = DeprecationLevel.ERROR
    )
    class ReplyMarkupRemoveKeyboard(
        val isPersonal: Boolean
    ) : ReplyMarkup()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkup.ForceReply"),
        level = DeprecationLevel.ERROR
    )
    class ReplyMarkupForceReply(
        val isPersonal: Boolean
    ) : ReplyMarkup()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkup.ShowKeyboard"),
        level = DeprecationLevel.ERROR
    )
    class ReplyMarkupShowKeyboard(
        val rows: Array<Array<KeyboardButton>>,
        val resizeKeyboard: Boolean,
        val oneTime: Boolean,
        val isPersonal: Boolean
    ) : ReplyMarkup()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdReplyMarkup.InlineKeyboard"),
        level = DeprecationLevel.ERROR
    )
    class ReplyMarkupInlineKeyboard(
        val rows: Array<Array<InlineKeyboardButton>>
    ) : ReplyMarkup()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLoginUrlInfo"),
        level = DeprecationLevel.ERROR
    )
    abstract class LoginUrlInfo : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLoginUrlInfo.Open"),
        level = DeprecationLevel.ERROR
    )
    class LoginUrlInfoOpen(
        val url: String,
        val skipConfirm: Boolean
    ) : LoginUrlInfo()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLoginUrlInfo.RequestConfirmation"),
        level = DeprecationLevel.ERROR
    )
    class LoginUrlInfoRequestConfirmation(
        val url: String,
        val domain: String,
        val botUserId: Int,
        val requestWriteAccess: Boolean
    ) : LoginUrlInfo()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText"),
        level = DeprecationLevel.ERROR
    )
    abstract class RichText : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Plain"),
        level = DeprecationLevel.ERROR
    )
    class RichTextPlain(
        val text: String
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Bold"),
        level = DeprecationLevel.ERROR
    )
    class RichTextBold(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Italic"),
        level = DeprecationLevel.ERROR
    )
    class RichTextItalic(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Underline"),
        level = DeprecationLevel.ERROR
    )
    class RichTextUnderline(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Strikethrough"),
        level = DeprecationLevel.ERROR
    )
    class RichTextStrikethrough(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Fixed"),
        level = DeprecationLevel.ERROR
    )
    class RichTextFixed(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Url"),
        level = DeprecationLevel.ERROR
    )
    class RichTextUrl(
        val text: RichText,
        val url: String,
        val isCached: Boolean
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.EmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class RichTextEmailAddress(
        val text: RichText,
        val emailAddress: String
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Subscript"),
        level = DeprecationLevel.ERROR
    )
    class RichTextSubscript(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Superscript"),
        level = DeprecationLevel.ERROR
    )
    class RichTextSuperscript(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Marked"),
        level = DeprecationLevel.ERROR
    )
    class RichTextMarked(
        val text: RichText
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.PhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class RichTextPhoneNumber(
        val text: RichText,
        val phoneNumber: String
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Icon"),
        level = DeprecationLevel.ERROR
    )
    class RichTextIcon(
        val document: Document,
        val width: Int,
        val height: Int
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.Anchor"),
        level = DeprecationLevel.ERROR
    )
    class RichTextAnchor(
        val text: RichText,
        val name: String
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdRichText.s"),
        level = DeprecationLevel.ERROR
    )
    class RichTexts(
        val texts: Array<RichText>
    ) : RichText()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignment"),
        level = DeprecationLevel.ERROR
    )
    abstract class PageBlockHorizontalAlignment : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignment.Left"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockHorizontalAlignmentLeft : PageBlockHorizontalAlignment()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignment.Center"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockHorizontalAlignmentCenter : PageBlockHorizontalAlignment()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockHorizontalAlignment.Right"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockHorizontalAlignmentRight : PageBlockHorizontalAlignment()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignment"),
        level = DeprecationLevel.ERROR
    )
    abstract class PageBlockVerticalAlignment : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignment.Top"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockVerticalAlignmentTop : PageBlockVerticalAlignment()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignment.Middle"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockVerticalAlignmentMiddle : PageBlockVerticalAlignment()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlockVerticalAlignment.Bottom"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockVerticalAlignmentBottom : PageBlockVerticalAlignment()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock"),
        level = DeprecationLevel.ERROR
    )
    abstract class PageBlock : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Title"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockTitle(
        val title: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Subtitle"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockSubtitle(
        val subtitle: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.AuthorDate"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockAuthorDate(
        val author: RichText,
        val publishDate: Int
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Header"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockHeader(
        val header: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Subheader"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockSubheader(
        val subheader: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Kicker"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockKicker(
        val kicker: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Paragraph"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockParagraph(
        val text: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Preformatted"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockPreformatted(
        val text: RichText,
        val language: String
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Footer"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockFooter(
        val footer: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Divider"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockDivider : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Anchor"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockAnchor(
        val name: String
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.List"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockList(
        val items: Array<PageBlockListItem>
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.BlockQuote"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockBlockQuote(
        val text: RichText,
        val credit: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.PullQuote"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockPullQuote(
        val text: RichText,
        val credit: RichText
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Animation"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockAnimation(
        val animation: Animation?,
        val caption: PageBlockCaption,
        val needAutoplay: Boolean
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Audio"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockAudio(
        val audio: Audio?,
        val caption: PageBlockCaption
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Photo"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockPhoto(
        val photo: Photo?,
        val caption: PageBlockCaption,
        val url: String
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Video"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockVideo(
        val video: Video?,
        val caption: PageBlockCaption,
        val needAutoplay: Boolean,
        val isLooped: Boolean
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.VoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockVoiceNote(
        val voiceNote: VoiceNote?,
        val caption: PageBlockCaption
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Cover"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockCover(
        val cover: PageBlock
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Embedded"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.EmbeddedPost"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockEmbeddedPost(
        val url: String,
        val author: String,
        val authorPhoto: Photo?,
        val date: Int,
        val pageBlocks: Array<PageBlock>,
        val caption: PageBlockCaption
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Collage"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockCollage(
        val pageBlocks: Array<PageBlock>,
        val caption: PageBlockCaption
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Slideshow"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockSlideshow(
        val pageBlocks: Array<PageBlock>,
        val caption: PageBlockCaption
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.ChatLink"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockChatLink(
        val title: String,
        val photo: ChatPhoto?,
        val username: String
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Table"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockTable(
        val caption: RichText,
        val cells: Array<Array<PageBlockTableCell>>,
        val isBordered: Boolean,
        val isStriped: Boolean
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Details"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockDetails(
        val header: RichText,
        val pageBlocks: Array<PageBlock>,
        val isOpen: Boolean
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.RelatedArticles"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockRelatedArticles(
        val header: RichText,
        val articles: Array<PageBlockRelatedArticle>
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPageBlock.Map"),
        level = DeprecationLevel.ERROR
    )
    class PageBlockMap(
        val location: Location,
        val zoom: Int,
        val width: Int,
        val height: Int,
        val caption: PageBlockCaption
    ) : PageBlock()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentials"),
        level = DeprecationLevel.ERROR
    )
    abstract class InputCredentials : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentials.Saved"),
        level = DeprecationLevel.ERROR
    )
    class InputCredentialsSaved(
        val savedCredentialsId: String
    ) : InputCredentials()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentials.New"),
        level = DeprecationLevel.ERROR
    )
    class InputCredentialsNew(
        val data: String,
        val allowSave: Boolean
    ) : InputCredentials()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentials.AndroidPay"),
        level = DeprecationLevel.ERROR
    )
    class InputCredentialsAndroidPay(
        val data: String
    ) : InputCredentials()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputCredentials.ApplePay"),
        level = DeprecationLevel.ERROR
    )
    class InputCredentialsApplePay(
        val data: String
    ) : InputCredentials()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType"),
        level = DeprecationLevel.ERROR
    )
    abstract class PassportElementType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.PersonalDetails"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypePersonalDetails : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.Passport"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypePassport : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.DriverLicense"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeDriverLicense : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.IdentityCard"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeIdentityCard : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.InternalPassport"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeInternalPassport : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.Address"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeAddress : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.UtilityBill"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeUtilityBill : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.BankStatement"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeBankStatement : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.RentalAgreement"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeRentalAgreement : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.PassportRegistration"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypePassportRegistration : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.TemporaryRegistration"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeTemporaryRegistration : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.PhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypePhoneNumber : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementType.EmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTypeEmailAddress : PassportElementType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement"),
        level = DeprecationLevel.ERROR
    )
    abstract class PassportElement : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.PersonalDetails"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementPersonalDetails(
        val personalDetails: PersonalDetails
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.Passport"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementPassport(
        val passport: IdentityDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.DriverLicense"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementDriverLicense(
        val driverLicense: IdentityDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.IdentityCard"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementIdentityCard(
        val identityCard: IdentityDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.InternalPassport"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementInternalPassport(
        val internalPassport: IdentityDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.Address"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementAddress(
        val address: Address
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.UtilityBill"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementUtilityBill(
        val utilityBill: PersonalDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.BankStatement"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementBankStatement(
        val bankStatement: PersonalDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.RentalAgreement"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementRentalAgreement(
        val rentalAgreement: PersonalDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.PassportRegistration"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementPassportRegistration(
        val passportRegistration: PersonalDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.TemporaryRegistration"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementTemporaryRegistration(
        val temporaryRegistration: PersonalDocument
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.PhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementPhoneNumber(
        val phoneNumber: String
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElement.EmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementEmailAddress(
        val emailAddress: String
    ) : PassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement"),
        level = DeprecationLevel.ERROR
    )
    abstract class InputPassportElement : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.PersonalDetails"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementPersonalDetails(
        val personalDetails: PersonalDetails
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.Passport"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementPassport(
        val passport: InputIdentityDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.DriverLicense"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementDriverLicense(
        val driverLicense: InputIdentityDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.IdentityCard"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementIdentityCard(
        val identityCard: InputIdentityDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.InternalPassport"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementInternalPassport(
        val internalPassport: InputIdentityDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.Address"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementAddress(
        val address: Address
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.UtilityBill"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementUtilityBill(
        val utilityBill: InputPersonalDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.BankStatement"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementBankStatement(
        val bankStatement: InputPersonalDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.RentalAgreement"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementRentalAgreement(
        val rentalAgreement: InputPersonalDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.PassportRegistration"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementPassportRegistration(
        val passportRegistration: InputPersonalDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.TemporaryRegistration"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementTemporaryRegistration(
        val temporaryRegistration: InputPersonalDocument
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.PhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementPhoneNumber(
        val phoneNumber: String
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElement.EmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementEmailAddress(
        val emailAddress: String
    ) : InputPassportElement()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource"),
        level = DeprecationLevel.ERROR
    )
    abstract class PassportElementErrorSource : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.Unspecified"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceUnspecified : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.DataField"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceDataField(
        val fieldName: String
    ) : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.FrontSide"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceFrontSide : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.ReverseSide"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceReverseSide : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.Selfie"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceSelfie : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.TranslationFile"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceTranslationFile(
        val fileIndex: Int
    ) : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.TranslationFiles"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceTranslationFiles : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.File"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceFile(
        val fileIndex: Int
    ) : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPassportElementErrorSource.Files"),
        level = DeprecationLevel.ERROR
    )
    class PassportElementErrorSourceFiles : PassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource"),
        level = DeprecationLevel.ERROR
    )
    abstract class InputPassportElementErrorSource : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.Unspecified"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceUnspecified(
        val elementHash: ByteArray
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.DataField"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceDataField(
        val fieldName: String,
        val dataHash: ByteArray
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.FrontSide"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceFrontSide(
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.ReverseSide"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceReverseSide(
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.Selfie"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceSelfie(
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.TranslationFile"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceTranslationFile(
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.TranslationFiles"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceTranslationFiles(
        val fileHashes: Array<ByteArray>
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.File"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceFile(
        val fileHash: ByteArray
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputPassportElementErrorSource.Files"),
        level = DeprecationLevel.ERROR
    )
    class InputPassportElementErrorSourceFiles(
        val fileHashes: Array<ByteArray>
    ) : InputPassportElementErrorSource()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent"),
        level = DeprecationLevel.ERROR
    )
    abstract class MessageContent : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageText"),
        level = DeprecationLevel.ERROR
    )
    class MessageText(
        val text: FormattedText,
        val webPage: WebPage?
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageAnimation"),
        level = DeprecationLevel.ERROR
    )
    class MessageAnimation(
        val animation: Animation,
        val caption: FormattedText,
        val isSecret: Boolean
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageAudio"),
        level = DeprecationLevel.ERROR
    )
    class MessageAudio(
        val audio: Audio,
        val caption: FormattedText
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageDocument"),
        level = DeprecationLevel.ERROR
    )
    class MessageDocument(
        val document: Document,
        val caption: FormattedText
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessagePhoto"),
        level = DeprecationLevel.ERROR
    )
    class MessagePhoto(
        val photo: Photo,
        val caption: FormattedText,
        val isSecret: Boolean
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageExpiredPhoto"),
        level = DeprecationLevel.ERROR
    )
    class MessageExpiredPhoto : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageSticker"),
        level = DeprecationLevel.ERROR
    )
    class MessageSticker(
        val sticker: Sticker
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageVideo"),
        level = DeprecationLevel.ERROR
    )
    class MessageVideo(
        val video: Video,
        val caption: FormattedText,
        val isSecret: Boolean
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageExpiredVideo"),
        level = DeprecationLevel.ERROR
    )
    class MessageExpiredVideo : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageVideoNote"),
        level = DeprecationLevel.ERROR
    )
    class MessageVideoNote(
        val videoNote: VideoNote,
        val isViewed: Boolean,
        val isSecret: Boolean
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageVoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class MessageVoiceNote(
        val voiceNote: VoiceNote,
        val caption: FormattedText,
        val isListened: Boolean
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageLocation"),
        level = DeprecationLevel.ERROR
    )
    class MessageLocation(
        val location: Location,
        val livePeriod: Int,
        val expiresIn: Int
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageVenue"),
        level = DeprecationLevel.ERROR
    )
    class MessageVenue(
        val venue: Venue
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageContact"),
        level = DeprecationLevel.ERROR
    )
    class MessageContact(
        val contact: Contact
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageGame"),
        level = DeprecationLevel.ERROR
    )
    class MessageGame(
        val game: Game
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessagePoll"),
        level = DeprecationLevel.ERROR
    )
    class MessagePoll(
        val poll: Poll
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageInvoice"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageCall"),
        level = DeprecationLevel.ERROR
    )
    class MessageCall(
        val discardReason: CallDiscardReason,
        val duration: Int
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageBasicGroupChatCreate"),
        level = DeprecationLevel.ERROR
    )
    class MessageBasicGroupChatCreate(
        val title: String,
        val memberUserIds: IntArray
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageSupergroupChatCreate"),
        level = DeprecationLevel.ERROR
    )
    class MessageSupergroupChatCreate(
        val title: String
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatChangeTitle"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatChangeTitle(
        val title: String
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatChangePhoto"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatChangePhoto(
        val photo: Photo
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatDeletePhoto"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatDeletePhoto : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatAddMembers"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatAddMembers(
        val memberUserIds: IntArray
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatJoinByLink"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatJoinByLink : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatDeleteMember"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatDeleteMember(
        val userId: Int
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatUpgradeTo"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatUpgradeTo(
        val supergroupId: Int
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatUpgradeFrom"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatUpgradeFrom(
        val title: String,
        val basicGroupId: Int
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessagePinMessage"),
        level = DeprecationLevel.ERROR
    )
    class MessagePinMessage(
        val messageId: Long
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageScreenshotTaken"),
        level = DeprecationLevel.ERROR
    )
    class MessageScreenshotTaken : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageChatSetTtl"),
        level = DeprecationLevel.ERROR
    )
    class MessageChatSetTtl(
        val ttl: Int
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageCustomServiceAction"),
        level = DeprecationLevel.ERROR
    )
    class MessageCustomServiceAction(
        val text: String
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageGameScore"),
        level = DeprecationLevel.ERROR
    )
    class MessageGameScore(
        val gameMessageId: Long,
        val gameId: Long,
        val score: Int
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessagePaymentSuccessful"),
        level = DeprecationLevel.ERROR
    )
    class MessagePaymentSuccessful(
        val invoiceMessageId: Long,
        val currency: String,
        val totalAmount: Long
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessagePaymentSuccessfulBot"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageContactRegistered"),
        level = DeprecationLevel.ERROR
    )
    class MessageContactRegistered : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageWebsiteConnected"),
        level = DeprecationLevel.ERROR
    )
    class MessageWebsiteConnected(
        val domainName: String
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessagePassportDataSent"),
        level = DeprecationLevel.ERROR
    )
    class MessagePassportDataSent(
        val types: Array<PassportElementType>
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessagePassportDataReceived"),
        level = DeprecationLevel.ERROR
    )
    class MessagePassportDataReceived(
        val elements: Array<EncryptedPassportElement>,
        val credentials: EncryptedCredentials
    ) : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageContent.MessageUnsupported"),
        level = DeprecationLevel.ERROR
    )
    class MessageUnsupported : MessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType"),
        level = DeprecationLevel.ERROR
    )
    abstract class TextEntityType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Mention"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeMention : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Hashtag"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeHashtag : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Cashtag"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeCashtag : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.BotCommand"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeBotCommand : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Url"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeUrl : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.EmailAddress"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeEmailAddress : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.PhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypePhoneNumber : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Bold"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeBold : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Italic"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeItalic : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Underline"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeUnderline : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Strikethrough"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeStrikethrough : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Code"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeCode : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.Pre"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypePre : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.PreCode"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypePreCode(
        val language: String
    ) : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.TextUrl"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeTextUrl(
        val url: String
    ) : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextEntityType.MentionName"),
        level = DeprecationLevel.ERROR
    )
    class TextEntityTypeMentionName(
        val userId: Int
    ) : TextEntityType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSchedulingState"),
        level = DeprecationLevel.ERROR
    )
    abstract class MessageSchedulingState : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSchedulingState.SendAtDate"),
        level = DeprecationLevel.ERROR
    )
    class MessageSchedulingStateSendAtDate(
        val sendDate: Int
    ) : MessageSchedulingState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdMessageSchedulingState.SendWhenOnline"),
        level = DeprecationLevel.ERROR
    )
    class MessageSchedulingStateSendWhenOnline : MessageSchedulingState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent"),
        level = DeprecationLevel.ERROR
    )
    abstract class InputMessageContent : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageText"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageText(
        val text: FormattedText,
        val disableWebPagePreview: Boolean,
        val clearDraft: Boolean
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageAnimation"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageAnimation(
        val animation: InputFile,
        val thumbnail: InputThumbnail,
        val duration: Int,
        val width: Int,
        val height: Int,
        val caption: FormattedText
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageAudio"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageAudio(
        val audio: InputFile,
        val albumCoverThumbnail: InputThumbnail,
        val duration: Int,
        val title: String,
        val performer: String,
        val caption: FormattedText
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageDocument"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageDocument(
        val document: InputFile,
        val thumbnail: InputThumbnail,
        val caption: FormattedText
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessagePhoto"),
        level = DeprecationLevel.ERROR
    )
    class InputMessagePhoto(
        val photo: InputFile,
        val thumbnail: InputThumbnail,
        val addedStickerFileIds: IntArray,
        val width: Int,
        val height: Int,
        val caption: FormattedText,
        val ttl: Int
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageSticker"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageSticker(
        val sticker: InputFile,
        val thumbnail: InputThumbnail,
        val width: Int,
        val height: Int
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageVideo"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageVideo(
        val video: InputFile,
        val thumbnail: InputThumbnail,
        val addedStickerFileIds: IntArray,
        val duration: Int,
        val width: Int,
        val height: Int,
        val supportsStreaming: Boolean,
        val caption: FormattedText,
        val ttl: Int
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageVideoNote"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageVideoNote(
        val videoNote: InputFile,
        val thumbnail: InputThumbnail,
        val duration: Int,
        val length: Int
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageVoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageVoiceNote(
        val voiceNote: InputFile,
        val duration: Int,
        val waveform: ByteArray,
        val caption: FormattedText
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageLocation"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageLocation(
        val location: Location,
        val livePeriod: Int
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageVenue"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageVenue(
        val venue: Venue
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageContact"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageContact(
        val contact: Contact
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageGame"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageGame(
        val botUserId: Int,
        val gameShortName: String
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageInvoice"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageInvoice(
        val invoice: Invoice,
        val title: String,
        val description: String,
        val photoUrl: String?,
        val photoSize: Int,
        val photoWidth: Int,
        val photoHeight: Int,
        val payload: ByteArray,
        val providerToken: String,
        val providerData: String,
        val startParameter: String
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessagePoll"),
        level = DeprecationLevel.ERROR
    )
    class InputMessagePoll(
        val question: String,
        val options: Array<String>,
        val isAnonymous: Boolean,
        val type: PollType,
        @TdBotsOnly
        val isClosed: Boolean
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputMessageContent.InputMessageForwarded"),
        level = DeprecationLevel.ERROR
    )
    class InputMessageForwarded(
        val fromChatId: Long,
        val messageId: Long,
        val inGameShare: Boolean,
        val sendCopy: Boolean,
        val removeCaption: Boolean
    ) : InputMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter"),
        level = DeprecationLevel.ERROR
    )
    abstract class SearchMessagesFilter : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Empty"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterEmpty : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Animation"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterAnimation : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Audio"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterAudio : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Document"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterDocument : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Photo"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterPhoto : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Video"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterVideo : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.VoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterVoiceNote : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.PhotoAndVideo"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterPhotoAndVideo : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Url"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterUrl : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.ChatPhoto"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterChatPhoto : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Call"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterCall : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.MissedCall"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterMissedCall : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.VideoNote"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterVideoNote : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.VoiceAndVideoNote"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterVoiceAndVideoNote : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.Mention"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterMention : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdSearchMessagesFilter.UnreadMention"),
        level = DeprecationLevel.ERROR
    )
    class SearchMessagesFilterUnreadMention : SearchMessagesFilter()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatAction : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.Typing"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionTyping : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.RecordingVideo"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionRecordingVideo : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.UploadingVideo"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionUploadingVideo(
        val progress: Int
    ) : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.RecordingVoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionRecordingVoiceNote : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.UploadingVoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionUploadingVoiceNote(
        val progress: Int
    ) : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.UploadingPhoto"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionUploadingPhoto(
        val progress: Int
    ) : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.UploadingDocument"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionUploadingDocument(
        val progress: Int
    ) : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.ChoosingLocation"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionChoosingLocation : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.ChoosingContact"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionChoosingContact : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.StartPlayingGame"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionStartPlayingGame : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.RecordingVideoNote"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionRecordingVideoNote : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.UploadingVideoNote"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionUploadingVideoNote(
        val progress: Int
    ) : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatAction.Cancel"),
        level = DeprecationLevel.ERROR
    )
    class ChatActionCancel : ChatAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus"),
        level = DeprecationLevel.ERROR
    )
    abstract class UserStatus : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus.Empty"),
        level = DeprecationLevel.ERROR
    )
    class UserStatusEmpty : UserStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus.Online"),
        level = DeprecationLevel.ERROR
    )
    class UserStatusOnline(
        val expires: Int
    ) : UserStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus.Offline"),
        level = DeprecationLevel.ERROR
    )
    class UserStatusOffline(
        val wasOnline: Int
    ) : UserStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus.Recently"),
        level = DeprecationLevel.ERROR
    )
    class UserStatusRecently : UserStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus.LastWeek"),
        level = DeprecationLevel.ERROR
    )
    class UserStatusLastWeek : UserStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserStatus.LastMonth"),
        level = DeprecationLevel.ERROR
    )
    class UserStatusLastMonth : UserStatus()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReason"),
        level = DeprecationLevel.ERROR
    )
    abstract class CallDiscardReason : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReason.Empty"),
        level = DeprecationLevel.ERROR
    )
    class CallDiscardReasonEmpty : CallDiscardReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReason.Missed"),
        level = DeprecationLevel.ERROR
    )
    class CallDiscardReasonMissed : CallDiscardReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReason.Declined"),
        level = DeprecationLevel.ERROR
    )
    class CallDiscardReasonDeclined : CallDiscardReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReason.Disconnected"),
        level = DeprecationLevel.ERROR
    )
    class CallDiscardReasonDisconnected : CallDiscardReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallDiscardReason.HungUp"),
        level = DeprecationLevel.ERROR
    )
    class CallDiscardReasonHungUp : CallDiscardReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState"),
        level = DeprecationLevel.ERROR
    )
    abstract class CallState : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState.Pending"),
        level = DeprecationLevel.ERROR
    )
    class CallStatePending(
        val isCreated: Boolean,
        val isReceived: Boolean
    ) : CallState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState.ExchangingKeys"),
        level = DeprecationLevel.ERROR
    )
    class CallStateExchangingKeys : CallState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState.Ready"),
        level = DeprecationLevel.ERROR
    )
    class CallStateReady(
        val protocol: CallProtocol,
        val connections: Array<CallConnection>,
        val config: String,
        val encryptionKey: ByteArray,
        val emojis: Array<String>,
        val allowP2p: Boolean
    ) : CallState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState.HangingUp"),
        level = DeprecationLevel.ERROR
    )
    class CallStateHangingUp : CallState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState.Discarded"),
        level = DeprecationLevel.ERROR
    )
    class CallStateDiscarded(
        val reason: CallDiscardReason,
        val needRating: Boolean,
        val needDebugInformation: Boolean
    ) : CallState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallState.Error"),
        level = DeprecationLevel.ERROR
    )
    class CallStateError(
        val error: Error
    ) : CallState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem"),
        level = DeprecationLevel.ERROR
    )
    abstract class CallProblem : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem.Echo"),
        level = DeprecationLevel.ERROR
    )
    class CallProblemEcho : CallProblem()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem.Noise"),
        level = DeprecationLevel.ERROR
    )
    class CallProblemNoise : CallProblem()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem.Interruptions"),
        level = DeprecationLevel.ERROR
    )
    class CallProblemInterruptions : CallProblem()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem.DistortedSpeech"),
        level = DeprecationLevel.ERROR
    )
    class CallProblemDistortedSpeech : CallProblem()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem.SilentLocal"),
        level = DeprecationLevel.ERROR
    )
    class CallProblemSilentLocal : CallProblem()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem.SilentRemote"),
        level = DeprecationLevel.ERROR
    )
    class CallProblemSilentRemote : CallProblem()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallProblem.Dropped"),
        level = DeprecationLevel.ERROR
    )
    class CallProblemDropped : CallProblem()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult"),
        level = DeprecationLevel.ERROR
    )
    abstract class InputInlineQueryResult : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.AnimatedGif"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultAnimatedGif(
        val id: String,
        val title: String,
        val thumbnailUrl: String,
        val gifUrl: String,
        val gifDuration: Int,
        val gifWidth: Int,
        val gifHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.AnimatedMpeg4"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultAnimatedMpeg4(
        val id: String,
        val title: String,
        val thumbnailUrl: String,
        val mpeg4Url: String,
        val mpeg4Duration: Int,
        val mpeg4Width: Int,
        val mpeg4Height: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Article"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultArticle(
        val id: String,
        val url: String,
        val hideUrl: Boolean,
        val title: String,
        val description: String,
        val thumbnailUrl: String,
        val thumbnailWidth: Int,
        val thumbnailHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Audio"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultAudio(
        val id: String,
        val title: String,
        val performer: String,
        val audioUrl: String,
        val audioDuration: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Contact"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultContact(
        val id: String,
        val contact: Contact,
        val thumbnailUrl: String,
        val thumbnailWidth: Int,
        val thumbnailHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Document"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultDocument(
        val id: String,
        val title: String,
        val description: String,
        val documentUrl: String,
        val mimeType: String,
        val thumbnailUrl: String,
        val thumbnailWidth: Int,
        val thumbnailHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Game"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultGame(
        val id: String,
        val gameShortName: String,
        val replyMarkup: ReplyMarkup
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Location"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultLocation(
        val id: String,
        val location: Location,
        val livePeriod: Int,
        val title: String,
        val thumbnailUrl: String,
        val thumbnailWidth: Int,
        val thumbnailHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Photo"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultPhoto(
        val id: String,
        val title: String,
        val description: String,
        val thumbnailUrl: String,
        val photoUrl: String,
        val photoWidth: Int,
        val photoHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Sticker"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultSticker(
        val id: String,
        val thumbnailUrl: String,
        val stickerUrl: String,
        val stickerWidth: Int,
        val stickerHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Venue"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultVenue(
        val id: String,
        val venue: Venue,
        val thumbnailUrl: String,
        val thumbnailWidth: Int,
        val thumbnailHeight: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.Video"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultVideo(
        val id: String,
        val title: String,
        val description: String,
        val thumbnailUrl: String,
        val videoUrl: String,
        val mimeType: String,
        val videoWidth: Int,
        val videoHeight: Int,
        val videoDuration: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputInlineQueryResult.VoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class InputInlineQueryResultVoiceNote(
        val id: String,
        val title: String,
        val voiceNoteUrl: String,
        val voiceNoteDuration: Int,
        val replyMarkup: ReplyMarkup,
        val inputMessageContent: InputMessageContent
    ) : InputInlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult"),
        level = DeprecationLevel.ERROR
    )
    abstract class InlineQueryResult : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Article"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultArticle(
        val id: String,
        val url: String,
        val hideUrl: Boolean,
        val title: String,
        val description: String,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Contact"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultContact(
        val id: String,
        val contact: Contact,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Location"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultLocation(
        val id: String,
        val location: Location,
        val title: String,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Venue"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultVenue(
        val id: String,
        val venue: Venue,
        val thumbnail: PhotoSize?
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Game"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultGame(
        val id: String,
        val game: Game
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Animation"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultAnimation(
        val id: String,
        val animation: Animation,
        val title: String
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Audio"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultAudio(
        val id: String,
        val audio: Audio
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Document"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultDocument(
        val id: String,
        val document: Document,
        val title: String,
        val description: String
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Photo"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultPhoto(
        val id: String,
        val photo: Photo,
        val title: String,
        val description: String
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Sticker"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultSticker(
        val id: String,
        val sticker: Sticker
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.Video"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultVideo(
        val id: String,
        val video: Video,
        val title: String,
        val description: String
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInlineQueryResult.VoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class InlineQueryResultVoiceNote(
        val id: String,
        val voiceNote: VoiceNote,
        val title: String
    ) : InlineQueryResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryPayload"),
        level = DeprecationLevel.ERROR
    )
    abstract class CallbackQueryPayload : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryPayload.Data"),
        level = DeprecationLevel.ERROR
    )
    class CallbackQueryPayloadData(
        val data: ByteArray
    ) : CallbackQueryPayload()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCallbackQueryPayload.Game"),
        level = DeprecationLevel.ERROR
    )
    class CallbackQueryPayloadGame(
        val gameShortName: String
    ) : CallbackQueryPayload()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatEventAction : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMessageEdited"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMessageEdited(
        val oldMessage: Message,
        val newMessage: Message
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMessageDeleted"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMessageDeleted(
        val message: Message
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventPollStopped"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventPollStopped(
        val message: Message
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMessagePinned"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMessagePinned(
        val message: Message
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMessageUnpinned"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMessageUnpinned : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMemberJoined"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMemberJoined : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMemberLeft"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMemberLeft : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMemberInvited"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMemberInvited(
        val userId: Int,
        val status: ChatMemberStatus
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMemberPromoted"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMemberPromoted(
        val userId: Int,
        val oldStatus: ChatMemberStatus,
        val newStatus: ChatMemberStatus
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventMemberRestricted"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventMemberRestricted(
        val userId: Int,
        val oldStatus: ChatMemberStatus,
        val newStatus: ChatMemberStatus
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventTitleChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventTitleChanged(
        val oldTitle: String,
        val newTitle: String
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventPermissionsChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventPermissionsChanged(
        val oldPermissions: ChatPermissions,
        val newPermissions: ChatPermissions
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventDescriptionChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventDescriptionChanged(
        val oldDescription: String,
        val newDescription: String
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventUsernameChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventUsernameChanged(
        val oldUsername: String,
        val newUsername: String
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventPhotoChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventPhotoChanged(
        val oldPhoto: Photo?,
        val newPhoto: Photo?
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventInvitesToggled"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventInvitesToggled(
        val canInviteUsers: Boolean
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventLinkedChatChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventLinkedChatChanged(
        val oldLinkedChatId: Long,
        val newLinkedChatId: Long
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventSlowModeDelayChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventSlowModeDelayChanged(
        val oldSlowModeDelay: Int,
        val newSlowModeDelay: Int
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventSignMessagesToggled"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventSignMessagesToggled(
        val signMessages: Boolean
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventStickerSetChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventStickerSetChanged(
        val oldStickerSetId: Long,
        val newStickerSetId: Long
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventLocationChanged"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventLocationChanged(
        val oldLocation: ChatLocation?,
        val newLocation: ChatLocation?
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatEventAction.ChatEventIsAllHistoryAvailableToggled"),
        level = DeprecationLevel.ERROR
    )
    class ChatEventIsAllHistoryAvailableToggled(
        val isAllHistoryAvailable: Boolean
    ) : ChatEventAction()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValue"),
        level = DeprecationLevel.ERROR
    )
    abstract class LanguagePackStringValue : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValue.Ordinary"),
        level = DeprecationLevel.ERROR
    )
    class LanguagePackStringValueOrdinary(
        val value: String
    ) : LanguagePackStringValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValue.Pluralized"),
        level = DeprecationLevel.ERROR
    )
    class LanguagePackStringValuePluralized(
        val zeroValue: String,
        val oneValue: String,
        val twoValue: String,
        val fewValue: String,
        val manyValue: String,
        val otherValue: String
    ) : LanguagePackStringValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLanguagePackStringValue.Deleted"),
        level = DeprecationLevel.ERROR
    )
    class LanguagePackStringValueDeleted : LanguagePackStringValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken"),
        level = DeprecationLevel.ERROR
    )
    abstract class DeviceToken : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.FirebaseCloudMessaging"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenFirebaseCloudMessaging(
        val token: String?,
        val encrypt: Boolean
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.ApplePush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenApplePush(
        val deviceToken: String?,
        val isAppSandbox: Boolean
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.ApplePushVoIP"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenApplePushVoIP(
        val deviceToken: String?,
        val isAppSandbox: Boolean,
        val encrypt: Boolean
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.WindowsPush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenWindowsPush(
        val accessToken: String?
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.MicrosoftPush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenMicrosoftPush(
        val channelUri: String?
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.MicrosoftPushVoIP"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenMicrosoftPushVoIP(
        val channelUri: String?
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.WebPush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenWebPush(
        val endpoint: String?,
        val p256dhBase64url: String,
        val authBase64url: String
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.SimplePush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenSimplePush(
        val endpoint: String?
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.UbuntuPush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenUbuntuPush(
        val token: String?
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.BlackBerryPush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenBlackBerryPush(
        val token: String?
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdDeviceToken.TizenPush"),
        level = DeprecationLevel.ERROR
    )
    class DeviceTokenTizenPush(
        val regId: String?
    ) : DeviceToken()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundFill"),
        level = DeprecationLevel.ERROR
    )
    abstract class BackgroundFill : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundFill.Solid"),
        level = DeprecationLevel.ERROR
    )
    class BackgroundFillSolid(
        val color: Int
    ) : BackgroundFill()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundFill.Gradient"),
        level = DeprecationLevel.ERROR
    )
    class BackgroundFillGradient(
        val topColor: Int,
        val bottomColor: Int,
        val rotationAngle: Int
    ) : BackgroundFill()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundType"),
        level = DeprecationLevel.ERROR
    )
    abstract class BackgroundType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundType.Wallpaper"),
        level = DeprecationLevel.ERROR
    )
    class BackgroundTypeWallpaper(
        val isBlurred: Boolean,
        val isMoving: Boolean
    ) : BackgroundType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundType.Pattern"),
        level = DeprecationLevel.ERROR
    )
    class BackgroundTypePattern(
        val fill: BackgroundFill,
        val intensity: Int,
        val isMoving: Boolean
    ) : BackgroundType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdBackgroundType.Fill"),
        level = DeprecationLevel.ERROR
    )
    class BackgroundTypeFill(
        val fill: BackgroundFill
    ) : BackgroundType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputBackground"),
        level = DeprecationLevel.ERROR
    )
    abstract class InputBackground : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputBackground.Local"),
        level = DeprecationLevel.ERROR
    )
    class InputBackgroundLocal(
        val background: InputFile
    ) : InputBackground()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdInputBackground.Remote"),
        level = DeprecationLevel.ERROR
    )
    class InputBackgroundRemote(
        val backgroundId: Long
    ) : InputBackground()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCanTransferOwnershipResult"),
        level = DeprecationLevel.ERROR
    )
    abstract class CanTransferOwnershipResult : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCanTransferOwnershipResult.Ok"),
        level = DeprecationLevel.ERROR
    )
    class CanTransferOwnershipResultOk : CanTransferOwnershipResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCanTransferOwnershipResult.PasswordNeeded"),
        level = DeprecationLevel.ERROR
    )
    class CanTransferOwnershipResultPasswordNeeded : CanTransferOwnershipResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCanTransferOwnershipResult.PasswordTooFresh"),
        level = DeprecationLevel.ERROR
    )
    class CanTransferOwnershipResultPasswordTooFresh(
        val retryAfter: Int
    ) : CanTransferOwnershipResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCanTransferOwnershipResult.SessionTooFresh"),
        level = DeprecationLevel.ERROR
    )
    class CanTransferOwnershipResultSessionTooFresh(
        val retryAfter: Int
    ) : CanTransferOwnershipResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResult"),
        level = DeprecationLevel.ERROR
    )
    abstract class CheckChatUsernameResult : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResult.Ok"),
        level = DeprecationLevel.ERROR
    )
    class CheckChatUsernameResultOk : CheckChatUsernameResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResult.UsernameInvalid"),
        level = DeprecationLevel.ERROR
    )
    class CheckChatUsernameResultUsernameInvalid : CheckChatUsernameResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResult.UsernameOccupied"),
        level = DeprecationLevel.ERROR
    )
    class CheckChatUsernameResultUsernameOccupied : CheckChatUsernameResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResult.PublicChatsTooMuch"),
        level = DeprecationLevel.ERROR
    )
    class CheckChatUsernameResultPublicChatsTooMuch : CheckChatUsernameResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdCheckChatUsernameResult.PublicGroupsUnavailable"),
        level = DeprecationLevel.ERROR
    )
    class CheckChatUsernameResultPublicGroupsUnavailable : CheckChatUsernameResult()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent"),
        level = DeprecationLevel.ERROR
    )
    abstract class PushMessageContent : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Hidden"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentHidden(
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Animation"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentAnimation(
        val animation: Animation?,
        val caption: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Audio"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentAudio(
        val audio: Audio?,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Contact"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentContact(
        val name: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.ContactRegistered"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentContactRegistered : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Document"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentDocument(
        val document: Document?,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Game"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentGame(
        val title: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.GameScore"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentGameScore(
        val title: String,
        val score: Int,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Invoice"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentInvoice(
        val price: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Location"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentLocation(
        val isLive: Boolean,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Photo"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentPhoto(
        val photo: Photo?,
        val caption: String,
        val isSecret: Boolean,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Poll"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentPoll(
        val question: String,
        val isRegular: Boolean,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.ScreenshotTaken"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentScreenshotTaken : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Sticker"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentSticker(
        val sticker: Sticker?,
        val emoji: String?,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Text"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentText(
        val text: String,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.Video"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentVideo(
        val video: Video?,
        val caption: String,
        val isSecret: Boolean,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.VideoNote"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentVideoNote(
        val videoNote: VideoNote?,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.VoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentVoiceNote(
        val voiceNote: VoiceNote?,
        val isPinned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.BasicGroupChatCreate"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentBasicGroupChatCreate : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.ChatAddMembers"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentChatAddMembers(
        val memberName: String,
        val isCurrentUser: Boolean,
        val isReturned: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.ChatChangePhoto"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentChatChangePhoto : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.ChatChangeTitle"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentChatChangeTitle(
        val title: String
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.ChatDeleteMember"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentChatDeleteMember(
        val memberName: String,
        val isCurrentUser: Boolean,
        val isLeft: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.ChatJoinByLink"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentChatJoinByLink : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.MessageForwards"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentMessageForwards(
        val totalCount: Int
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdPushMessageContent.MediaAlbum"),
        level = DeprecationLevel.ERROR
    )
    class PushMessageContentMediaAlbum(
        val totalCount: Int,
        val hasPhotos: Boolean,
        val hasVideos: Boolean
    ) : PushMessageContent()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationType"),
        level = DeprecationLevel.ERROR
    )
    abstract class NotificationType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationType.NewMessage"),
        level = DeprecationLevel.ERROR
    )
    class NotificationTypeNewMessage(
        val message: Message
    ) : NotificationType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationType.NewSecretChat"),
        level = DeprecationLevel.ERROR
    )
    class NotificationTypeNewSecretChat : NotificationType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationType.NewCall"),
        level = DeprecationLevel.ERROR
    )
    class NotificationTypeNewCall(
        val callId: Int
    ) : NotificationType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationType.NewPushMessage"),
        level = DeprecationLevel.ERROR
    )
    class NotificationTypeNewPushMessage(
        val messageId: Long,
        val senderUserId: Int,
        val content: PushMessageContent
    ) : NotificationType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupType"),
        level = DeprecationLevel.ERROR
    )
    abstract class NotificationGroupType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupType.Messages"),
        level = DeprecationLevel.ERROR
    )
    class NotificationGroupTypeMessages : NotificationGroupType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupType.Mentions"),
        level = DeprecationLevel.ERROR
    )
    class NotificationGroupTypeMentions : NotificationGroupType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupType.SecretChat"),
        level = DeprecationLevel.ERROR
    )
    class NotificationGroupTypeSecretChat : NotificationGroupType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNotificationGroupType.Calls"),
        level = DeprecationLevel.ERROR
    )
    class NotificationGroupTypeCalls : NotificationGroupType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValue"),
        level = DeprecationLevel.ERROR
    )
    abstract class OptionValue : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValue.Boolean"),
        level = DeprecationLevel.ERROR
    )
    class OptionValueBoolean(
        val value: Boolean
    ) : OptionValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValue.Empty"),
        level = DeprecationLevel.ERROR
    )
    class OptionValueEmpty : OptionValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValue.Integer"),
        level = DeprecationLevel.ERROR
    )
    class OptionValueInteger(
        val value: Int
    ) : OptionValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdOptionValue.String"),
        level = DeprecationLevel.ERROR
    )
    class OptionValueString(
        val value: String
    ) : OptionValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue"),
        level = DeprecationLevel.ERROR
    )
    abstract class JsonValue : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue.Null"),
        level = DeprecationLevel.ERROR
    )
    class JsonValueNull : JsonValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue.Boolean"),
        level = DeprecationLevel.ERROR
    )
    class JsonValueBoolean(
        val value: Boolean
    ) : JsonValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue.Number"),
        level = DeprecationLevel.ERROR
    )
    class JsonValueNumber(
        val value: Double
    ) : JsonValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue.String"),
        level = DeprecationLevel.ERROR
    )
    class JsonValueString(
        val value: String
    ) : JsonValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue.Array"),
        level = DeprecationLevel.ERROR
    )
    class JsonValueArray(
        val values: Array<JsonValue>
    ) : JsonValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdJsonValue.Object"),
        level = DeprecationLevel.ERROR
    )
    class JsonValueObject(
        val members: Array<JsonObjectMember>
    ) : JsonValue()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule"),
        level = DeprecationLevel.ERROR
    )
    abstract class UserPrivacySettingRule : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.AllowAll"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleAllowAll : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.AllowContacts"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleAllowContacts : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.AllowUsers"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleAllowUsers(
        val userIds: IntArray
    ) : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.AllowChatMembers"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleAllowChatMembers(
        val chatIds: LongArray
    ) : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.RestrictAll"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleRestrictAll : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.RestrictContacts"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleRestrictContacts : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.RestrictUsers"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleRestrictUsers(
        val userIds: IntArray
    ) : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySettingRule.RestrictChatMembers"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingRuleRestrictChatMembers(
        val chatIds: LongArray
    ) : UserPrivacySettingRule()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting"),
        level = DeprecationLevel.ERROR
    )
    abstract class UserPrivacySetting : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.ShowStatus"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingShowStatus : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.ShowProfilePhoto"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingShowProfilePhoto : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.ShowLinkInForwardedMessages"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingShowLinkInForwardedMessages : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.ShowPhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingShowPhoneNumber : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.AllowChatInvites"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingAllowChatInvites : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.AllowCalls"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingAllowCalls : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.AllowPeerToPeerCalls"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingAllowPeerToPeerCalls : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUserPrivacySetting.AllowFindingByPhoneNumber"),
        level = DeprecationLevel.ERROR
    )
    class UserPrivacySettingAllowFindingByPhoneNumber : UserPrivacySetting()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason"),
        level = DeprecationLevel.ERROR
    )
    abstract class ChatReportReason : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason.Spam"),
        level = DeprecationLevel.ERROR
    )
    class ChatReportReasonSpam : ChatReportReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason.Violence"),
        level = DeprecationLevel.ERROR
    )
    class ChatReportReasonViolence : ChatReportReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason.Pornography"),
        level = DeprecationLevel.ERROR
    )
    class ChatReportReasonPornography : ChatReportReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason.ChildAbuse"),
        level = DeprecationLevel.ERROR
    )
    class ChatReportReasonChildAbuse : ChatReportReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason.Copyright"),
        level = DeprecationLevel.ERROR
    )
    class ChatReportReasonCopyright : ChatReportReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason.UnrelatedLocation"),
        level = DeprecationLevel.ERROR
    )
    class ChatReportReasonUnrelatedLocation : ChatReportReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdChatReportReason.Custom"),
        level = DeprecationLevel.ERROR
    )
    class ChatReportReasonCustom(
        val text: String
    ) : ChatReportReason()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType"),
        level = DeprecationLevel.ERROR
    )
    abstract class FileType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.None"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeNone : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Animation"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeAnimation : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Audio"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeAudio : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Document"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeDocument : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Photo"),
        level = DeprecationLevel.ERROR
    )
    class FileTypePhoto : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.ProfilePhoto"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeProfilePhoto : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Secret"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeSecret : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.SecretThumbnail"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeSecretThumbnail : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Secure"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeSecure : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Sticker"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeSticker : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Thumbnail"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeThumbnail : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Unknown"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeUnknown : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Video"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeVideo : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.VideoNote"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeVideoNote : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.VoiceNote"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeVoiceNote : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdFileType.Wallpaper"),
        level = DeprecationLevel.ERROR
    )
    class FileTypeWallpaper : FileType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkType"),
        level = DeprecationLevel.ERROR
    )
    abstract class NetworkType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkType.None"),
        level = DeprecationLevel.ERROR
    )
    class NetworkTypeNone : NetworkType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkType.Mobile"),
        level = DeprecationLevel.ERROR
    )
    class NetworkTypeMobile : NetworkType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkType.MobileRoaming"),
        level = DeprecationLevel.ERROR
    )
    class NetworkTypeMobileRoaming : NetworkType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkType.WiFi"),
        level = DeprecationLevel.ERROR
    )
    class NetworkTypeWiFi : NetworkType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkType.Other"),
        level = DeprecationLevel.ERROR
    )
    class NetworkTypeOther : NetworkType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatisticsEntry"),
        level = DeprecationLevel.ERROR
    )
    abstract class NetworkStatisticsEntry : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatisticsEntry.File"),
        level = DeprecationLevel.ERROR
    )
    class NetworkStatisticsEntryFile(
        val fileType: FileType,
        val networkType: NetworkType,
        val sentBytes: Long,
        val receivedBytes: Long
    ) : NetworkStatisticsEntry()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdNetworkStatisticsEntry.Call"),
        level = DeprecationLevel.ERROR
    )
    class NetworkStatisticsEntryCall(
        val networkType: NetworkType,
        val sentBytes: Long,
        val receivedBytes: Long,
        val duration: Double
    ) : NetworkStatisticsEntry()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionState"),
        level = DeprecationLevel.ERROR
    )
    abstract class ConnectionState : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionState.WaitingForNetwork"),
        level = DeprecationLevel.ERROR
    )
    class ConnectionStateWaitingForNetwork : ConnectionState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionState.ConnectingToProxy"),
        level = DeprecationLevel.ERROR
    )
    class ConnectionStateConnectingToProxy : ConnectionState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionState.Connecting"),
        level = DeprecationLevel.ERROR
    )
    class ConnectionStateConnecting : ConnectionState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionState.Updating"),
        level = DeprecationLevel.ERROR
    )
    class ConnectionStateUpdating : ConnectionState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdConnectionState.Ready"),
        level = DeprecationLevel.ERROR
    )
    class ConnectionStateReady : ConnectionState()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory"),
        level = DeprecationLevel.ERROR
    )
    abstract class TopChatCategory : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory.Users"),
        level = DeprecationLevel.ERROR
    )
    class TopChatCategoryUsers : TopChatCategory()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory.Bots"),
        level = DeprecationLevel.ERROR
    )
    class TopChatCategoryBots : TopChatCategory()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory.Groups"),
        level = DeprecationLevel.ERROR
    )
    class TopChatCategoryGroups : TopChatCategory()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory.Channels"),
        level = DeprecationLevel.ERROR
    )
    class TopChatCategoryChannels : TopChatCategory()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory.InlineBots"),
        level = DeprecationLevel.ERROR
    )
    class TopChatCategoryInlineBots : TopChatCategory()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory.Calls"),
        level = DeprecationLevel.ERROR
    )
    class TopChatCategoryCalls : TopChatCategory()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTopChatCategory.ForwardChats"),
        level = DeprecationLevel.ERROR
    )
    class TopChatCategoryForwardChats : TopChatCategory()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlType"),
        level = DeprecationLevel.ERROR
    )
    abstract class TMeUrlType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlType.User"),
        level = DeprecationLevel.ERROR
    )
    class TMeUrlTypeUser(
        val userId: Int
    ) : TMeUrlType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlType.Supergroup"),
        level = DeprecationLevel.ERROR
    )
    class TMeUrlTypeSupergroup(
        val supergroupId: Long
    ) : TMeUrlType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlType.ChatInvite"),
        level = DeprecationLevel.ERROR
    )
    class TMeUrlTypeChatInvite(
        val info: ChatInviteLinkInfo
    ) : TMeUrlType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTMeUrlType.StickerSet"),
        level = DeprecationLevel.ERROR
    )
    class TMeUrlTypeStickerSet(
        val stickerSetId: Long
    ) : TMeUrlType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextParseMode"),
        level = DeprecationLevel.ERROR
    )
    abstract class TextParseMode : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextParseMode.Markdown"),
        level = DeprecationLevel.ERROR
    )
    class TextParseModeMarkdown(
        val version: Int
    ) : TextParseMode()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdTextParseMode.HTML"),
        level = DeprecationLevel.ERROR
    )
    class TextParseModeHTML : TextParseMode()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyType"),
        level = DeprecationLevel.ERROR
    )
    abstract class ProxyType : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyType.Socks5"),
        level = DeprecationLevel.ERROR
    )
    class ProxyTypeSocks5(
        val username: String?,
        val password: String?
    ) : ProxyType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyType.Http"),
        level = DeprecationLevel.ERROR
    )
    class ProxyTypeHttp(
        val username: String?,
        val password: String?,
        val httpOnly: Boolean
    ) : ProxyType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdProxyType.Mtproto"),
        level = DeprecationLevel.ERROR
    )
    class ProxyTypeMtproto(
        val secret: String
    ) : ProxyType()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdate"),
        level = DeprecationLevel.ERROR
    )
    abstract class Update : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStream"),
        level = DeprecationLevel.ERROR
    )
    abstract class LogStream : Object()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStream.Default"),
        level = DeprecationLevel.ERROR
    )
    class LogStreamDefault : LogStream()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStream.File"),
        level = DeprecationLevel.ERROR
    )
    class LogStreamFile(
        val path: String,
        val maxFileSize: Long
    ) : LogStream()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdLogStream.Empty"),
        level = DeprecationLevel.ERROR
    )
    class LogStreamEmpty : LogStream()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUser.ChatAction",
                "dev.whyoleg.ktd.api.updates.TdUpdateUser"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUserChatAction(
        val chatId: Long,
        val userId: Int,
        val action: ChatAction
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUser.Status",
                "dev.whyoleg.ktd.api.updates.TdUpdateUser"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUserStatus(
        val userId: Int,
        val status: UserStatus
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUser.Data", "dev.whyoleg.ktd.api.updates.TdUpdateUser"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUser(
        val user: User
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUser.FullInfo",
                "dev.whyoleg.ktd.api.updates.TdUpdateUser"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUserFullInfo(
        val userId: Int,
        val userFullInfo: UserFullInfo
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUser.PrivacySettingRules",
                "dev.whyoleg.ktd.api.updates.TdUpdateUser"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUserPrivacySettingRules(
        val setting: UserPrivacySetting,
        val rules: UserPrivacySettingRules
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.Data", "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewChat(
        val chat: Chat
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.ChatList",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatChatList(
        val chatId: Long,
        val chatList: ChatList?
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.Title", "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatTitle(
        val chatId: Long,
        val title: String
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.Photo", "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatPhoto(
        val chatId: Long,
        val photo: ChatPhoto?
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.Permissions",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatPermissions(
        val chatId: Long,
        val permissions: ChatPermissions
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.LastMessage",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatLastMessage(
        val chatId: Long,
        val lastMessage: Message?,
        val order: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.Order", "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatOrder(
        val chatId: Long,
        val order: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.IsPinned",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatIsPinned(
        val chatId: Long,
        val isPinned: Boolean,
        val order: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.IsMarkedAsUnread",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatIsMarkedAsUnread(
        val chatId: Long,
        val isMarkedAsUnread: Boolean
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.IsSponsored",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatIsSponsored(
        val chatId: Long,
        val isSponsored: Boolean,
        val order: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.HasScheduledMessages",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatHasScheduledMessages(
        val chatId: Long,
        val hasScheduledMessages: Boolean
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.DefaultDisableNotification",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatDefaultDisableNotification(
        val chatId: Long,
        val defaultDisableNotification: Boolean
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.ReadInbox",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatReadInbox(
        val chatId: Long,
        val lastReadInboxMessageId: Long,
        val unreadCount: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.ReadOutbox",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatReadOutbox(
        val chatId: Long,
        val lastReadOutboxMessageId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.UnreadMentionCount",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatUnreadMentionCount(
        val chatId: Long,
        val unreadMentionCount: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.NotificationSettings",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatNotificationSettings(
        val chatId: Long,
        val notificationSettings: ChatNotificationSettings
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.ActionBar",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatActionBar(
        val chatId: Long,
        val actionBar: ChatActionBar?
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.PinnedMessage",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatPinnedMessage(
        val chatId: Long,
        val pinnedMessageId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.ReplyMarkup",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatReplyMarkup(
        val chatId: Long,
        val replyMarkupMessageId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.DraftMessage",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatDraftMessage(
        val chatId: Long,
        val draftMessage: DraftMessage?,
        val order: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateChat.OnlineMemberCount",
                "dev.whyoleg.ktd.api.updates.TdUpdateChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateChatOnlineMemberCount(
        val chatId: Long,
        val onlineMemberCount: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.Data",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewMessage(
        val message: Message
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.SendAcknowledged",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageSendAcknowledged(
        val chatId: Long,
        val messageId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.SendSucceeded",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageSendSucceeded(
        val message: Message,
        val oldMessageId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.SendFailed",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageSendFailed(
        val message: Message,
        val oldMessageId: Long,
        val errorCode: Int,
        val errorMessage: String
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.Content",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageContent(
        val chatId: Long,
        val messageId: Long,
        val newContent: MessageContent
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.Edited",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageEdited(
        val chatId: Long,
        val messageId: Long,
        val editDate: Int,
        val replyMarkup: ReplyMarkup?
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.Views",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageViews(
        val chatId: Long,
        val messageId: Long,
        val views: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.ContentOpened",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageContentOpened(
        val chatId: Long,
        val messageId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.MentionRead",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageMentionRead(
        val chatId: Long,
        val messageId: Long,
        val unreadMentionCount: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateMessage.LiveLocationViewed",
                "dev.whyoleg.ktd.api.updates.TdUpdateMessage"),
        level = DeprecationLevel.ERROR
    )
    class UpdateMessageLiveLocationViewed(
        val chatId: Long,
        val messageId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUnread.MessageCount",
                "dev.whyoleg.ktd.api.updates.TdUpdateUnread"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUnreadMessageCount(
        val chatList: ChatList,
        val unreadCount: Int,
        val unreadUnmutedCount: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUnread.ChatCount",
                "dev.whyoleg.ktd.api.updates.TdUpdateUnread"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUnreadChatCount(
        val chatList: ChatList,
        val totalCount: Int,
        val unreadCount: Int,
        val unreadUnmutedCount: Int,
        val markedAsUnreadCount: Int,
        val markedAsUnreadUnmutedCount: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSupergroup.Data",
                "dev.whyoleg.ktd.api.updates.TdUpdateSupergroup"),
        level = DeprecationLevel.ERROR
    )
    class UpdateSupergroup(
        val supergroup: Supergroup
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSupergroup.FullInfo",
                "dev.whyoleg.ktd.api.updates.TdUpdateSupergroup"),
        level = DeprecationLevel.ERROR
    )
    class UpdateSupergroupFullInfo(
        val supergroupId: Int,
        val supergroupFullInfo: SupergroupFullInfo
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateBasicGroup.Data",
                "dev.whyoleg.ktd.api.updates.TdUpdateBasicGroup"),
        level = DeprecationLevel.ERROR
    )
    class UpdateBasicGroup(
        val basicGroup: BasicGroup
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateBasicGroup.FullInfo",
                "dev.whyoleg.ktd.api.updates.TdUpdateBasicGroup"),
        level = DeprecationLevel.ERROR
    )
    class UpdateBasicGroupFullInfo(
        val basicGroupId: Int,
        val basicGroupFullInfo: BasicGroupFullInfo
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFileGeneration.Start",
                "dev.whyoleg.ktd.api.updates.TdUpdateFileGeneration"),
        level = DeprecationLevel.ERROR
    )
    class UpdateFileGenerationStart(
        val generationId: Long,
        val originalPath: String?,
        val destinationPath: String,
        val conversion: String
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFileGeneration.Stop",
                "dev.whyoleg.ktd.api.updates.TdUpdateFileGeneration"),
        level = DeprecationLevel.ERROR
    )
    class UpdateFileGenerationStop(
        val generationId: Long
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateAuthorizationState",
                "dev.whyoleg.ktd.api.updates.TdUpdateAuthorizationState"),
        level = DeprecationLevel.ERROR
    )
    class UpdateAuthorizationState(
        val authorizationState: AuthorizationState
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateScopeNotificationSettings",
                "dev.whyoleg.ktd.api.updates.TdUpdateScopeNotificationSettings"),
        level = DeprecationLevel.ERROR
    )
    class UpdateScopeNotificationSettings(
        val scope: NotificationSettingsScope,
        val notificationSettings: ScopeNotificationSettings
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNotification",
                "dev.whyoleg.ktd.api.updates.TdUpdateNotification"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNotification(
        val notificationGroupId: Int,
        val notification: Notification
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNotificationGroup",
                "dev.whyoleg.ktd.api.updates.TdUpdateNotificationGroup"),
        level = DeprecationLevel.ERROR
    )
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

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateActiveNotifications",
                "dev.whyoleg.ktd.api.updates.TdUpdateActiveNotifications"),
        level = DeprecationLevel.ERROR
    )
    class UpdateActiveNotifications(
        val groups: Array<NotificationGroup>
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateHavePendingNotifications",
                "dev.whyoleg.ktd.api.updates.TdUpdateHavePendingNotifications"),
        level = DeprecationLevel.ERROR
    )
    class UpdateHavePendingNotifications(
        val haveDelayedNotifications: Boolean,
        val haveUnreceivedNotifications: Boolean
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateDeleteMessages",
                "dev.whyoleg.ktd.api.updates.TdUpdateDeleteMessages"),
        level = DeprecationLevel.ERROR
    )
    class UpdateDeleteMessages(
        val chatId: Long,
        val messageIds: LongArray,
        val isPermanent: Boolean,
        val fromCache: Boolean
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSecretChat",
                "dev.whyoleg.ktd.api.updates.TdUpdateSecretChat"),
        level = DeprecationLevel.ERROR
    )
    class UpdateSecretChat(
        val secretChat: SecretChat
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateServiceNotification",
                "dev.whyoleg.ktd.api.updates.TdUpdateServiceNotification"),
        level = DeprecationLevel.ERROR
    )
    class UpdateServiceNotification(
        val type: String,
        val content: MessageContent
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFile", "dev.whyoleg.ktd.api.updates.TdUpdateFile"),
        level = DeprecationLevel.ERROR
    )
    class UpdateFile(
        val file: File
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateCall", "dev.whyoleg.ktd.api.updates.TdUpdateCall"),
        level = DeprecationLevel.ERROR
    )
    class UpdateCall(
        val call: Call
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateOption", "dev.whyoleg.ktd.api.updates.TdUpdateOption"),
        level = DeprecationLevel.ERROR
    )
    class UpdateOption(
        val name: String,
        val value: OptionValue
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateInstalledStickerSets",
                "dev.whyoleg.ktd.api.updates.TdUpdateInstalledStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class UpdateInstalledStickerSets(
        val isMasks: Boolean,
        val stickerSetIds: LongArray
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateTrendingStickerSets",
                "dev.whyoleg.ktd.api.updates.TdUpdateTrendingStickerSets"),
        level = DeprecationLevel.ERROR
    )
    class UpdateTrendingStickerSets(
        val stickerSets: StickerSets
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateRecentStickers",
                "dev.whyoleg.ktd.api.updates.TdUpdateRecentStickers"),
        level = DeprecationLevel.ERROR
    )
    class UpdateRecentStickers(
        val isAttached: Boolean,
        val stickerIds: IntArray
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateFavoriteStickers",
                "dev.whyoleg.ktd.api.updates.TdUpdateFavoriteStickers"),
        level = DeprecationLevel.ERROR
    )
    class UpdateFavoriteStickers(
        val stickerIds: IntArray
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSavedAnimations",
                "dev.whyoleg.ktd.api.updates.TdUpdateSavedAnimations"),
        level = DeprecationLevel.ERROR
    )
    class UpdateSavedAnimations(
        val animationIds: IntArray
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateSelectedBackground",
                "dev.whyoleg.ktd.api.updates.TdUpdateSelectedBackground"),
        level = DeprecationLevel.ERROR
    )
    class UpdateSelectedBackground(
        val forDarkTheme: Boolean,
        val background: Background?
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateLanguagePackStrings",
                "dev.whyoleg.ktd.api.updates.TdUpdateLanguagePackStrings"),
        level = DeprecationLevel.ERROR
    )
    class UpdateLanguagePackStrings(
        val localizationTarget: String,
        val languagePackId: String,
        val strings: Array<LanguagePackString>
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateConnectionState",
                "dev.whyoleg.ktd.api.updates.TdUpdateConnectionState"),
        level = DeprecationLevel.ERROR
    )
    class UpdateConnectionState(
        val state: ConnectionState
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateTermsOfService",
                "dev.whyoleg.ktd.api.updates.TdUpdateTermsOfService"),
        level = DeprecationLevel.ERROR
    )
    class UpdateTermsOfService(
        val termsOfServiceId: String,
        val termsOfService: TermsOfService
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateUsersNearby",
                "dev.whyoleg.ktd.api.updates.TdUpdateUsersNearby"),
        level = DeprecationLevel.ERROR
    )
    class UpdateUsersNearby(
        val usersNearby: Array<ChatNearby>
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewInlineQuery",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewInlineQuery"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewInlineQuery(
        val id: Long,
        val senderUserId: Int,
        val userLocation: Location?,
        val query: String,
        val offset: String
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewChosenInlineResult",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewChosenInlineResult"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewChosenInlineResult(
        val senderUserId: Int,
        val userLocation: Location?,
        val query: String,
        val resultId: String,
        val inlineMessageId: String
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewCallbackQuery",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewCallbackQuery"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewCallbackQuery(
        val id: Long,
        val senderUserId: Int,
        val chatId: Long,
        val messageId: Long,
        val chatInstance: Long,
        val payload: CallbackQueryPayload
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewInlineCallbackQuery",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewInlineCallbackQuery"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewInlineCallbackQuery(
        val id: Long,
        val senderUserId: Int,
        val inlineMessageId: String,
        val chatInstance: Long,
        val payload: CallbackQueryPayload
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewShippingQuery",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewShippingQuery"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewShippingQuery(
        val id: Long,
        val senderUserId: Int,
        val invoicePayload: String,
        val shippingAddress: Address
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewPreCheckoutQuery",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewPreCheckoutQuery"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewPreCheckoutQuery(
        val id: Long,
        val senderUserId: Int,
        val currency: String,
        val totalAmount: Long,
        val invoicePayload: ByteArray,
        val shippingOptionId: String?,
        val orderInfo: OrderInfo?
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewCustomEvent",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewCustomEvent"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewCustomEvent(
        val event: String
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdateNewCustomQuery",
                "dev.whyoleg.ktd.api.updates.TdUpdateNewCustomQuery"),
        level = DeprecationLevel.ERROR
    )
    class UpdateNewCustomQuery(
        val id: Long,
        val data: String,
        val timeout: Int
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdatePoll", "dev.whyoleg.ktd.api.updates.TdUpdatePoll"),
        level = DeprecationLevel.ERROR
    )
    class UpdatePoll(
        val poll: Poll
    ) : Update()

    @Deprecated(
        message = abstractTdDeprecatedMessage,
        replaceWith = ReplaceWith("TdUpdatePollAnswer",
                "dev.whyoleg.ktd.api.updates.TdUpdatePollAnswer"),
        level = DeprecationLevel.ERROR
    )
    class UpdatePollAnswer(
        val pollId: Long,
        val userId: Int,
        val optionIds: IntArray
    ) : Update()
}
