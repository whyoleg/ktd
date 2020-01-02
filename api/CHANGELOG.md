# TD API Changelog (from 1.5.0)

## API Versions supported
- [1.5.4](#154)
- [1.5.3](#153)
- [1.5.2](#152)
- [1.5.1](#151)

## 1.5.4

```diff
Abstract classes:
+ MessageSchedulingState
+   Description:
+     Contains information about the time when a scheduled message will be sent
Objects:
- TextEntityTypeBlockQuote : TextEntityType
+ AuthorizationStateWaitOtherDeviceConfirmation : AuthorizationState
+   Description:
+     The user needs to confirm authorization on another logged in device by scanning a QR code with the provided link
+   Properties:
+     link: String
+       Description:
+         A tg:// URL for the QR code
+         The link will be updated frequently
+ MessageSchedulingStateSendAtDate : MessageSchedulingState
+   Description:
+     The message will be sent at the specified date
+   Properties:
+     sendDate: Int
+       Description:
+         Date the message will be sent
+         The date must be within 367 days in the future
+ MessageSchedulingStateSendWhenOnline : MessageSchedulingState
+   Description:
+     The message will be sent when the peer will be online
+     Applicable to private chats only and when the exact online status of the peer is known
+ SendMessageOptions
+   Description:
+     Options to be used when a message is send
+   Properties:
+     disableNotification: Boolean
+       Description:
+         Pass true to disable notification for the message
+         Must be false if the message is sent to a secret chat
+     fromBackground: Boolean
+       Description:
+         Pass true if the message is sent from the background
+     schedulingState: MessageSchedulingState
+       Description:
+         Message scheduling state
+         Messages sent to a secret chat, live location messages and self-destructing messages can't be scheduled
+ UpdateMessageLiveLocationViewed : Update
+   Description:
+     A message with a live location was viewed
+     When the update is received, the client is supposed to update the live location
+   Properties:
+     chatId: Long
+       Description:
+         Identifier of the chat with the live location message
+     messageId: Long
+       Description:
+         Identifier of the message with live location
  FormattedText
    Properties:
      entities
        Description:
          Entities contained in the text
          Entities can be nested, but must not mutually intersect each other
          Pre, Code and PreCode entities can't contain other entities
-         Bold, Italic, Underline, Strikethrough and BlockQuote entities can contain and to be contained in any other entities
+         Bold, Italic, Underline and Strikethrough entities can contain and to be contained in any other entities
          All other entities can't contain each other
  AuthorizationStateWaitPhoneNumber
    Description:
      TDLib needs the user's phone number to authorize
+     Call `setAuthenticationPhoneNumber` to provide the phone number, or use `requestQrCodeAuthentication`, or `checkAuthenticationBotToken` for other authentication options
  UserTypeDeleted
    Description:
      A deleted user or deleted bot
-     No information on the user besides the user_id is available
+     No information on the user besides the user identifier is available
      It is not possible to perform any active actions on this type of user
  UserTypeUnknown
    Description:
-     No information on the user besides the user_id is available, yet this user has not been deleted
+     No information on the user besides the user identifier is available, yet this user has not been deleted
      This object is extremely rare and must be handled like a deleted user
      It is not possible to perform any actions on users of this type
  ChatAdministrator
    Properties:
+     isOwner: Boolean
+       Description:
+         True, if the user is the owner of the chat
  Message
    Properties:
+     schedulingState: MessageSchedulingState
+       Description:
+         Information about the scheduling state of the message
+       Additions:
+         Nullable
  RichTextStrikethrough
    Description:
-     A strike-through rich text
+     A strikethrough rich text
  TextEntityTypeStrikethrough
    Description:
-     A strike-through text
+     A strikethrough text
  ChatEventLinkedChatChanged
    Description:
-     The linked_chat_id of a supergroup was changed
+     The linked chat of a supergroup was changed
  ChatEventSlowModeDelayChanged
    Description:
-     The slow_mode_delay of a supergroup was changed
+     The slow_mode_delay setting of a supergroup was changed
Functions:
+ RequestQrCodeAuthentication
+   Returns: Ok
+   Description:
+     Requests QR code authentication by scanning a QR code on another logged in device
+     Works only when the current authorization state is authorizationStateWaitPhoneNumber
+   Properties:
+     otherUserIds: IntArray
+       Description:
+         List of user identifiers of other users currently using the client
+ ConfirmQrCodeAuthentication
+   Returns: Session
+   Description:
+     Confirms QR code authentication on another device
+     Returns created session on success
+   Properties:
+     link: String
+       Description:
+         A link from a QR code
+         The link must be scanned by the in-app camera
+ GetInactiveSupergroupChats
+   Returns: Chats
+   Description:
+     Returns a list of recently inactive supergroups and channels
+     Can be used when user reaches limit on the number of joined supergroups and channels and receives CHANNELS_TOO_MUCH error
+ GetChatScheduledMessages
+   Returns: Messages
+   Description:
+     Returns all scheduled messages in a chat
+     The messages are returned in a reverse chronological order (i.e., in order of decreasing message_id)
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+ EditMessageSchedulingState
+   Returns: Ok
+   Description:
+     Edits the time when a scheduled message will be sent
+   Properties:
+     chatId: Long
+       Description:
+         The chat the message belongs to
+     messageId: Long
+       Description:
+         Identifier of the message
+     schedulingState: MessageSchedulingState
+       Description:
+         The new message scheduling state
+         Pass null to send the message immediately
  SendMessage
    Properties:
-     disableNotification: Boolean
-     fromBackground: Boolean
+     options: SendMessageOptions
+       Description:
+         Options to be used to send the message
  SendMessageAlbum
    Properties:
-     disableNotification: Boolean
-     fromBackground: Boolean
+     options: SendMessageOptions
+       Description:
+         Options to be used to send the messages
  SendInlineQueryResultMessage
    Properties:
-     disableNotification: Boolean
-     fromBackground: Boolean
+     options: SendMessageOptions
+       Description:
+         Options to be used to send the message
  ForwardMessages
    Properties:
-     disableNotification: Boolean
-     fromBackground: Boolean
+     options: SendMessageOptions
+       Description:
+         Options to be used to send the messages
  TransferChatOwnership
    Description:
-     Changes owner of a chat
+     Changes the owner of a chat
      The current user must be a current owner of the chat
      Use the method canTransferOwnership to check whether the ownership can be transferred from the current session
      Available only for supergroups and channel chats
  AddContact
    Description:
-     Adds a user to the contact list or edits an existing contact by their user_id
+     Adds a user to the contact list or edits an existing contact by their user identifiers
  SendTonLiteServerRequest
    Description:
      Sends a request to TON lite server through Telegram servers
+     Can be called before authorization
```

## 1.5.3

```diff
Objects:
+ ChatAdministrator
+   Description:
+     Contains information about a chat administrator
+   Properties:
+     userId: Int
+       Description:
+         User identifier of the administrator
+     customTitle: String
+       Description:
+         Custom title of the administrator
+ ChatAdministrators
+   Description:
+     Represents a list of chat administrators
+   Properties:
+     administrators: Array<ChatAdministrator>
+       Description:
+         A list of chat administrators
+ ChatEventSlowModeDelayChanged : ChatEventAction
+   Description:
+     The slow_mode_delay of a supergroup was changed
+   Properties:
+     oldSlowModeDelay: Int
+       Description:
+         Previous value of slow_mode_delay
+     newSlowModeDelay: Int
+       Description:
+         New value of slow_mode_delay
+ UserPrivacySettingAllowFindingByPhoneNumber : UserPrivacySetting
+   Description:
+     A privacy setting for managing whether the user can be found by its phone number
+     Checked only if the phone number is not known to the other user
+     Can be set only to "Allow contacts" or "Allow all"
+ UpdateChatHasScheduledMessages : Update
+   Description:
+     A chat's has_scheduled_messages field has changed
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     hasScheduledMessages: Boolean
+       Description:
+         New value of has_scheduled_messages
  RemoteFile
    Properties:
+     uniqueId: String
+       Description:
+         Unique file identifier
+         May be empty if unknown
+         The unique file identifier which is the same for the same file even for different users and is persistent over time
      id
        Description:
          Remote file identifier
          Can be used across application restarts or even from other devices for the current user
+         Uniquely identifies a file, but a file can have a lot of different valid identifiers
          If the ID starts with "http://" or "https://", it represents the HTTP URL of the file
          TDLib is currently unable to download files if only their URL is known
          If downloadFile is called on such a file or if it is sent to a secret chat, TDLib starts a file generation process by sending updateFileGenerationStart to the client with the HTTP URL in the original_path and "#url#" as the conversion string
          Clients should generate the file by downloading it to the specified location
  User
    Properties:
      restrictionReason
        Description:
-         If non-empty, it contains the reason why access to this user must be restricted
+         If non-empty, it contains a human-readable description of the reason why access to this user must be restricted
-         The format of the string is "{type}: {description}"
-         {type} contains the type of the restriction and at least one of the suffixes "-all", "-ios", "-android", or "-wp", which describe the platforms on which access should be restricted
-         (For example, "terms-ios-android"
-         {description} contains a human-readable description of the restriction, which can be shown to the user)
  UserFullInfo
    Properties:
      needPhoneNumberPrivacyException
        Description:
-         True, if the current user needs to explicitly allow to share his phone number with the user when the method addContact is used
+         True, if the current user needs to explicitly allow to share their phone number with the user when the method addContact is used
  ChatMemberStatusCreator
    Properties:
+     customTitle: String
+       Description:
+         A custom title of the owner
+         Applicable to supergroups only
+       Additions:
+         SizeRequired - must be in range [0, 16]
  ChatMemberStatusAdministrator
    Properties:
+     customTitle: String
+       Description:
+         A custom title of the administrator
+         Applicable to supergroups only
+       Additions:
+         SizeRequired - must be in range [0, 16]
  Supergroup
    Properties:
+     isSlowModeEnabled: Boolean
+       Description:
+         True, if the slow mode is enabled in the supergroup
      status
        Description:
          Status of the current user in the supergroup or channel
+         Custom title will be always empty
      restrictionReason
        Description:
-         If non-empty, contains the reason why access to this supergroup or channel must be restricted
+         If non-empty, contains a human-readable description of the reason why access to this supergroup or channel must be restricted
-         Format of the string is "{type}: {description}"
-         {type} Contains the type of the restriction and at least one of the suffixes "-all", "-ios", "-android", or "-wp", which describe the platforms on which access should be restricted
-         (For example, "terms-ios-android"
-         {description} contains a human-readable description of the restriction, which can be shown to the user)
  SupergroupFullInfo
    Properties:
+     slowModeDelay: Int
+       Description:
+         Delay between consecutive sent messages for non-administrator supergroup members, in seconds
+     slowModeDelayExpiresIn: Double
+       Description:
+         Time left before next message can be sent in the supergroup, in seconds
+         An updateSupergroupFullInfo update is not triggered when value of this field changes, but both new and old values are non-zero
  Message
    Properties:
+     restrictionReason: String
+       Description:
+         If non-empty, contains a human-readable description of the reason why access to this message must be restricted
  ChatListMain
    Description:
      A main list of chats
-     Can contain ordinary chats and other lists of chats as folders
  Chat
    Properties:
+     hasScheduledMessages: Boolean
+       Description:
+         True, if the chat has scheduled messages
  InputMessageText
    Properties:
      text
        Description:
          Formatted text to be sent
          1-GetOption("message_text_length_max") characters
-         Only Bold, Italic, Code, Pre, PreCode and TextUrl entities are allowed to be specified manually
+         Only Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode, TextUrl and MentionName entities are allowed to be specified manually
  UpdateChatChatList
    Properties:
      chatList
        Description:
-         The new chat's list
+         The new chat's chat list
Functions:
+ SetChatSlowModeDelay
+   Returns: Ok
+   Description:
+     Changes the slow mode delay of a chat
+     Available only for supergroups
+     Requires can_restrict_members rights
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     slowModeDelay: Int
+       Description:
+         New slow mode delay for the chat
+         Must be one of 0, 10, 30, 60, 300, 900, 3600
  ParseTextEntities
    Description:
-     Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
+     Parses Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode, TextUrl and MentionName entities contained in the text
      This is an offline method
      Can be called before authorization
  GetChatAdministrators
    Returns:
-     Users
+     ChatAdministrators
    Description:
-     Returns a list of users who are administrators of the chat
+     Returns a list of administrators of the chat with their custom titles
  AddContact
    Description:
-     Adds a user to the contacts list or edits an existing contact by their user_id
+     Adds a user to the contact list or edits an existing contact by their user_id
    Properties:
      sharePhoneNumber
        Description:
          True, if the new contact needs to be allowed to see current user's phone number
          A corresponding rule to userPrivacySettingShowPhoneNumber will be added if needed
-         Use the field UserFullInfo.need_phone_number_privacy_exception to check whether the current user needs to be asked to share his phone number
+         Use the field UserFullInfo.need_phone_number_privacy_exception to check whether the current user needs to be asked to share their phone number
  GetChatStatisticsUrl
    Description:
      Returns an HTTP URL with the chat statistics
      Currently this method can be used only for channels
+     Can be used only if SupergroupFullInfo.can_view_statistics == true
```

## 1.5.2

```diff
Abstract classes:
- LinkState
+ ChatList
+   Description:
+     Describes a list of chats
+ PublicChatType
+   Description:
+     Describes a type of public chats
+ ChatActionBar
+   Description:
+     Describes actions which should be possible to do through a chat action bar
+ LoginUrlInfo
+   Description:
+     Contains information about an inline button of type inlineKeyboardButtonTypeLoginUrl returned by the method getLoginUrlInfo
+ CanTransferOwnershipResult
+   Description:
+     Represents result of checking whether the current session can be used to transfer a chat ownership to another user
Objects:
- LinkStateNone : LinkState
- LinkStateKnowsPhoneNumber : LinkState
- LinkStateIsContact : LinkState
- ChatReportSpamState
+ ChatLocation
+   Description:
+     Represents a location of a chat
+   Properties:
+     location: Location
+       Description:
+         The location
+     address: String
+       Description:
+         Location address
+       Additions:
+         SizeRequired - must be in range [1, 64]
+ ChatListMain : ChatList
+   Description:
+     A main list of chats
+     Can contain ordinary chats and other lists of chats as folders
+ ChatListArchive : ChatList
+   Description:
+     A list of chats usually located at the top of the main chat list
+     Unmuted chats are automatically moved from the Archive to the Main chat list when a new message arrives
+ ChatNearby
+   Description:
+     Describes a chat located nearby
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     distance: Int
+       Description:
+         Distance to the chat location in meters
+ ChatsNearby
+   Description:
+     Represents a list of chats located nearby
+   Properties:
+     usersNearby: Array<ChatNearby>
+       Description:
+         List of users nearby
+     supergroupsNearby: Array<ChatNearby>
+       Description:
+         List of location-based supergroups nearby
+ PublicChatTypeHasUsername : PublicChatType
+   Description:
+     The chat is public, because it has username
+ PublicChatTypeIsLocationBased : PublicChatType
+   Description:
+     The chat is public, because it is a location-based supergroup
+ ChatActionBarReportSpam : ChatActionBar
+   Description:
+     The chat can be reported as spam using the method reportChat with the reason chatReportReasonSpam
+ ChatActionBarReportUnrelatedLocation : ChatActionBar
+   Description:
+     The chat is a location-based supergroup, which can be reported as having unrelated location using the method reportChat with the reason chatReportReasonUnrelatedLocation
+ ChatActionBarReportAddBlock : ChatActionBar
+   Description:
+     The chat is a private or secret chat, which can be reported using the method reportChat, or the other user can be added to the contact list using the method addContact, or the other user can be blocked using the method blockUser
+ ChatActionBarAddContact : ChatActionBar
+   Description:
+     The chat is a private or secret chat and the other user can be added to the contact list using the method addContact
+ ChatActionBarSharePhoneNumber : ChatActionBar
+   Description:
+     The chat is a private or secret chat with a mutual contact and the user's phone number can be shared with the other user using the method sharePhoneNumber
+ LoginUrlInfoOpen : LoginUrlInfo
+   Description:
+     An HTTP url needs to be open
+   Properties:
+     url: String
+       Description:
+         The URL to open
+     skipConfirm: Boolean
+       Description:
+         True, if there is no need to show an ordinary open URL confirm
+ LoginUrlInfoRequestConfirmation : LoginUrlInfo
+   Description:
+     An authorization confirmation dialog needs to be shown to the user
+   Properties:
+     url: String
+       Description:
+         An HTTP URL to be opened
+     domain: String
+       Description:
+         A domain of the URL
+     botUserId: Int
+       Description:
+         User identifier of a bot linked with the website
+     requestWriteAccess: Boolean
+       Description:
+         True, if the user needs to be requested to give the permission to the bot to send them messages
+ PageBlockVoiceNote : PageBlock
+   Description:
+     A voice note
+   Properties:
+     voiceNote: VoiceNote
+       Description:
+         Voice note
+       Additions:
+         Nullable
+     caption: PageBlockCaption
+       Description:
+         Voice note caption
+ TextEntityTypeUnderline : TextEntityType
+   Description:
+     An underlined text
+ TextEntityTypeStrikethrough : TextEntityType
+   Description:
+     A strike-through text
+ TextEntityTypeBlockQuote : TextEntityType
+   Description:
+     A block quote
+     This entity can't be sent for now
+ ChatEventLinkedChatChanged : ChatEventAction
+   Description:
+     The linked_chat_id of a supergroup was changed
+   Properties:
+     oldLinkedChatId: Long
+       Description:
+         Previous supergroup linked chat identifier
+     newLinkedChatId: Long
+       Description:
+         New supergroup linked chat identifier
+ ChatEventLocationChanged : ChatEventAction
+   Description:
+     The supergroup location was changed
+   Properties:
+     oldLocation: ChatLocation
+       Description:
+         Previous location
+       Additions:
+         Nullable
+     newLocation: ChatLocation
+       Description:
+         New location
+       Additions:
+         Nullable
+ CanTransferOwnershipResultOk : CanTransferOwnershipResult
+   Description:
+     The session can be used
+ CanTransferOwnershipResultPasswordNeeded : CanTransferOwnershipResult
+   Description:
+     The 2-step verification needs to be enabled first
+ CanTransferOwnershipResultPasswordTooFresh : CanTransferOwnershipResult
+   Description:
+     The 2-step verification was enabled recently, user needs to wait
+   Properties:
+     retryAfter: Int
+       Description:
+         Time left before the session can be used to transfer ownership of a chat, in seconds
+ CanTransferOwnershipResultSessionTooFresh : CanTransferOwnershipResult
+   Description:
+     The session was created recently, user needs to wait
+   Properties:
+     retryAfter: Int
+       Description:
+         Time left before the session can be used to transfer ownership of a chat, in seconds
+ UserPrivacySettingRuleAllowChatMembers : UserPrivacySettingRule
+   Description:
+     A rule to allow all members of certain specified basic groups and supergroups to doing something
+   Properties:
+     chatIds: LongArray
+       Description:
+         The chat identifiers, total number of chats in all rules must not exceed 20
+ UserPrivacySettingRuleRestrictChatMembers : UserPrivacySettingRule
+   Description:
+     A rule to restrict all members of specified basic groups and supergroups from doing something
+   Properties:
+     chatIds: LongArray
+       Description:
+         The chat identifiers, total number of chats in all rules must not exceed 20
+ UserPrivacySettingShowPhoneNumber : UserPrivacySetting
+   Description:
+     A privacy setting for managing whether the user's phone number is visible
+ ChatReportReasonUnrelatedLocation : ChatReportReason
+   Description:
+     The chat has unrelated location
+ TopChatCategoryForwardChats : TopChatCategory
+   Description:
+     A category containing frequently used chats used to forward messages
+ UpdateChatChatList : Update
+   Description:
+     The list to which the chat belongs was changed
+     This update is guaranteed to be sent only when chat.order == 0 and the current or the new chat list is null
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     chatList: ChatList
+       Description:
+         The new chat's list
+       Additions:
+         Nullable
+ UpdateChatActionBar : Update
+   Description:
+     The chat action bar was changed
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     actionBar: ChatActionBar
+       Description:
+         The new value of the action bar
+       Additions:
+         Nullable
+ UpdateUsersNearby : Update
+   Description:
+     List of users nearby has changed
+     The update is sent only 60 seconds after a successful searchChatsNearby request
+   Properties:
+     usersNearby: Array<ChatNearby>
+       Description:
+         The new list of users nearby
  FormattedText
    Properties:
      entities
        Description:
          Entities contained in the text
+         Entities can be nested, but must not mutually intersect each other
+         Pre, Code and PreCode entities can't contain other entities
+         Bold, Italic, Underline, Strikethrough and BlockQuote entities can contain and to be contained in any other entities
+         All other entities can't contain each other
  InputFileRemote
    Description:
      A file defined by its remote ID
+     The remote ID is guaranteed to work only if it was received after TDLib launch and the corresponding file is still accessible to the user
+     For example, if the file is from a message, then the message must be not deleted and accessible to the user
+     If a file database is disabled, then the corresponding object with the file must be preloaded by the client
  Audio
    Description:
      Describes an audio file
-     Audio is usually in MP3 format
+     Audio is usually in MP3 or M4A format
  Video
    Properties:
      hasStickers
        Description:
-         True, if stickers were added to the photo
+         True, if stickers were added to the video
  User
    Properties:
-     outgoingLink: LinkState
-     incomingLink: LinkState
+     isContact: Boolean
+       Description:
+         The user is a contact of the current user
+     isMutualContact: Boolean
+       Description:
+         The user is a contact of the current user and the current user is a contact of the user
  UserFullInfo
    Properties:
+     needPhoneNumberPrivacyException: Boolean
+       Description:
+         True, if the current user needs to explicitly allow to share his phone number with the user when the method addContact is used
  ChatMemberStatusCreator
    Description:
-     The user is the creator of a chat and has all the administrator privileges
+     The user is the owner of a chat and has all the administrator privileges
  ChatMemberStatusAdministrator
    Properties:
      canPromoteMembers
        Description:
-         True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that were directly or indirectly promoted by him
+         True, if the administrator can add new administrators with a subset of their own privileges or demote administrators that were directly or indirectly promoted by them
  ChatMembersFilterAdministrators
    Description:
-     Returns the creator and administrators
+     Returns the owner and administrators
  SupergroupMembersFilterAdministrators
    Description:
-     Returns the creator and administrators
+     Returns the owner and administrators
  BasicGroupFullInfo
    Properties:
      inviteLink
        Description:
          Invite link for this group
-         Available only for the group creator and only after it has been generated at least once
+         Available only after it has been generated at least once and only for the group creator
  Supergroup
    Properties:
+     hasLinkedChat: Boolean
+       Description:
+         True, if the channel has a discussion group, or the supergroup is a discussion group for a channel
+     hasLocation: Boolean
+       Description:
+         True, if the supergroup has a chat location
  SupergroupFullInfo
    Properties:
+     linkedChatId: Long
+       Description:
+         Chat identifier of a discussion group for the channel, or a channel, for which the supergroup is a discussion group
+         0 if none or unknown
+     canSetLocation: Boolean
+       Description:
+         True, if the supergroup location can be changed
+     location: ChatLocation
+       Description:
+         Location of the supergroup
+       Additions:
+         Nullable
      canSetUsername
        Description:
-         True, if the chat can be made public
+         True, if the chat username can be changed
      isAllHistoryAvailable
        Description:
          True, if new chat members will have access to old messages
-         In public supergroups and both public and private channels, old messages are always available, so this option affects only private supergroups
+         In public or discussion groups and both public and private channels, old messages are always available, so this option affects only private supergroups without a linked chat
          The value of this field is only available for chat administrators
  SecretChat
    Properties:
      layer
        Description:
          Secret chat layer
          Determines features supported by the other client
          Video notes are supported if the layer >= 66
+         Nested text entities and underline and strikethrough entities are supported if the layer >= 101
  MessageForwardInfo
    Properties:
      fromChatId
        Description:
-         For messages forwarded to the chat with the current user (saved messages) or to the channel discussion supergroup, the identifier of the chat from which the message was forwarded last time
+         For messages forwarded to the chat with the current user (saved messages) or to the channel's discussion group, the identifier of the chat from which the message was forwarded last time
          0 if unknown
      fromMessageId
        Description:
-         For messages forwarded to the chat with the current user (saved messages) or to the channel discussion supergroup, the identifier of the original message from which the new message was forwarded last time
+         For messages forwarded to the chat with the current user (saved messages) or to the channel's discussion group, the identifier of the original message from which the new message was forwarded last time
          0 if unknown
  Message
    Properties:
      canBeEdited
        Description:
          True, if the message can be edited
-         For live location and poll messages this fields shows, whether editMessageLiveLocation or stopPoll can be used with this message by the client
+         For live location and poll messages this fields shows whether editMessageLiveLocation or stopPoll can be used with this message by the client
  Chat
    Properties:
+     chatList: ChatList
+       Description:
+         A chat list to which the chat belongs
+       Additions:
+         Nullable
+     actionBar: ChatActionBar
+       Description:
+         Describes actions which should be possible to do through a chat action bar
+       Additions:
+         Nullable
  ChatInviteLinkInfo
    Properties:
      isPublic
        Description:
-         True, if the chat is a public supergroup or a channel with a username
+         True, if the chat is a public supergroup or channel, i.e
+         It has a username or it is a location-based supergroup
  InlineKeyboardButtonTypeLoginUrl
    Properties:
      url
        Description:
-         HTTP URL to open
+         An HTTP URL to open
  RichTextUrl
    Properties:
+     isCached: Boolean
+       Description:
+         True, if the URL has cached instant view server-side
  PageBlockTableCell
    Properties:
      text
        Description:
          Cell text
+         If the text is null, then the cell should be invisible
        Additions:
+         Nullable
  InputInlineQueryResultSticker
    Description:
-     Represents a link to a WEBP or a TGS sticker
+     Represents a link to a WEBP or TGS sticker
    Properties:
      stickerUrl
        Description:
-         The URL of the WEBP or a TGS sticker (sticker file size must not exceed 5MB)
+         The URL of the WEBP or TGS sticker (sticker file size must not exceed 5MB)
  PushMessageContentChatAddMembers
    Properties:
      isReturned
        Description:
-         True, if the user has returned to the group himself
+         True, if the user has returned to the group themself
  PushMessageContentChatDeleteMember
    Properties:
      isLeft
        Description:
-         True, if the user has left the group himself
+         True, if the user has left the group themself
  Notification
    Properties:
+     isSilent: Boolean
+       Description:
+         True, if the notification was initially silent
  UserPrivacySettingRuleAllowUsers
    Properties:
      userIds
        Description:
-         The user identifiers
+         The user identifiers, total number of users in all rules must not exceed 1000
  UserPrivacySettingRuleRestrictUsers
    Properties:
      userIds
        Description:
-         The user identifiers
+         The user identifiers, total number of users in all rules must not exceed 1000
  PublicMessageLink
    Description:
-     Contains a public HTTPS link to a message in a public supergroup or channel with a username
+     Contains a public HTTPS link to a message in a supergroup or channel with a username
  TextParseModeMarkdown
    Properties:
+     version: Int
+       Description:
+         Version of the parser, 0 - Bot API 1.0 parser, 1 - Bot API 4.5 rules with underline, strikethrough and nested entities support
  UpdateChatLastMessage
    Description:
      The last message of a chat was changed
-     If last_message is null then the last message in the chat became unknown
+     If last_message is null, then the last message in the chat became unknown
      Some new unknown messages might be added to the chat in this case
  UpdateHavePendingNotifications
    Description:
-     Describes, whether there are some pending notification updates
+     Describes whether there are some pending notification updates
      Can be used to prevent application from killing, while there are some pending notifications
  UpdateUnreadMessageCount
    Description:
-     Number of unread messages has changed
+     Number of unread messages in a chat list has changed
      This update is sent only if a message database is used
    Properties:
+     chatList: ChatList
+       Description:
+         The chat list with changed number of unread messages
  UpdateUnreadChatCount
    Properties:
+     chatList: ChatList
+       Description:
+         The chat list with changed number of unread messages
  UpdateNewCallbackQuery
    Properties:
      chatId
        Description:
-         Identifier of the chat, in which the query was sent
+         Identifier of the chat where the query was sent
Functions:
- GetChatReportSpamState
- ChangeChatReportSpamState
+ SearchChatsNearby
+   Returns: ChatsNearby
+   Description:
+     Returns a list of users and location-based supergroups nearby
+     The list of users nearby will be updated for 60 seconds after the request by the updates updateUsersNearby
+     The request should be sent again every 25 seconds with adjusted location to not miss new chats
+   Properties:
+     location: Location
+       Description:
+         Current user location
+ CheckCreatedPublicChatsLimit
+   Returns: Ok
+   Description:
+     Checks whether a maximum number of owned public chats is reached
+     Returns corresponding error if the limit was reached
+   Properties:
+     type: PublicChatType
+       Description:
+         Type of the public chats, for which to check the limit
+ GetSuitableDiscussionChats
+   Returns: Chats
+   Description:
+     Returns a list of basic group and supergroup chats, which can be used as a discussion group for a channel
+     Basic group chats need to be first upgraded to supergroups before they can be set as a discussion group
+ GetLoginUrlInfo
+   Returns: LoginUrlInfo
+   Description:
+     Returns information about a button of type inlineKeyboardButtonTypeLoginUrl
+     The method needs to be called when the user presses the button
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier of the message with the button
+     messageId: Long
+       Description:
+         Message identifier of the message with the button
+     buttonId: Int
+       Description:
+         Button identifier
+ GetLoginUrl
+   Returns: HttpUrl
+   Description:
+     Returns an HTTP URL which can be used to automatically authorize the user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl
+     Use the method getLoginUrlInfo to find whether a prior user confirmation is needed
+     If an error is returned, then the button must be handled as an ordinary URL button
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier of the message with the button
+     messageId: Long
+       Description:
+         Message identifier of the message with the button
+     buttonId: Int
+       Description:
+         Button identifier
+     allowWriteAccess: Boolean
+       Description:
+         True, if the user allowed the bot to send them messages
+ SetChatChatList
+   Returns: Ok
+   Description:
+     Moves a chat to a different chat list
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     chatList: ChatList
+       Description:
+         New chat list of the chat
+ SetChatDiscussionGroup
+   Returns: Ok
+   Description:
+     Changes the discussion group of a channel chat
+     Requires can_change_info rights
+   Properties:
+     chatId: Long
+       Description:
+         Identifier of the channel chat
+     discussionChatId: Long
+       Description:
+         Identifier of a new channel's discussion group
+         Use 0 to remove the discussion group
+         If new chat members don't have access to old messages in the supergroup, then toggleSupergroupIsAllHistoryAvailable needs to be used first to change that
+ SetChatLocation
+   Returns: Ok
+   Description:
+     Changes the location of a chat
+     Available only for some location-based supergroups, use supergroupFullInfo.can_set_location to check whether the method is allowed to use
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     location: ChatLocation
+       Description:
+         New location for the chat
+         Must be valid and not null
+ CanTransferOwnership
+   Returns: CanTransferOwnershipResult
+   Description:
+     Checks whether the current session can be used to transfer a chat ownership to another user
+ TransferChatOwnership
+   Returns: Ok
+   Description:
+     Changes owner of a chat
+     The current user must be a current owner of the chat
+     Use the method canTransferOwnership to check whether the ownership can be transferred from the current session
+     Available only for supergroups and channel chats
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
+     userId: Int
+       Description:
+         Identifier of the user to which transfer the ownership
+         The ownership can't be transferred to a bot or to a deleted user
+     password: String
+       Description:
+         The password of the current user
+ AddContact
+   Returns: Ok
+   Description:
+     Adds a user to the contacts list or edits an existing contact by their user_id
+   Properties:
+     contact: Contact
+       Description:
+         The contact to add or edit
+         Phone number can be empty and needs to be specified only if known, vCard is ignored
+     sharePhoneNumber: Boolean
+       Description:
+         True, if the new contact needs to be allowed to see current user's phone number
+         A corresponding rule to userPrivacySettingShowPhoneNumber will be added if needed
+         Use the field UserFullInfo.need_phone_number_privacy_exception to check whether the current user needs to be asked to share his phone number
+ SharePhoneNumber
+   Returns: Ok
+   Description:
+     Shares a phone number of the current user with a mutual contact
+     Supposed to be called when the user clicks on chatActionBarSharePhoneNumber
+   Properties:
+     userId: Int
+       Description:
+         Identifier of the user with whom to share the phone number
+         The user must be a mutual contact
+ RemoveChatActionBar
+   Returns: Ok
+   Description:
+     Removes a chat action bar without any other action
+   Properties:
+     chatId: Long
+       Description:
+         Chat identifier
  GetSupergroup
    Description:
-     Returns information about a supergroup or channel by its identifier
+     Returns information about a supergroup or a channel by its identifier
      This is an offline request if the current user is not a bot
  GetSupergroupFullInfo
    Description:
-     Returns full information about a supergroup or channel by its identifier, cached for up to 1 minute
+     Returns full information about a supergroup or a channel by its identifier, cached for up to 1 minute
  GetRemoteFile
    Description:
      Returns information about a file by its remote ID
      This is an offline request
      Can be used to register a URL as a file for further uploading, or sending as a message
+     Even the request succeeds, the file can be used only if it is still accessible to the user
+     For example, if the file is from a message, then the message must be not deleted and accessible to the user
+     If a file database is disabled, then the corresponding object with the file must be preloaded by the client
  GetChats
    Description:
-     Returns an ordered list of chats
+     Returns an ordered list of chats in a chat list
      Chats are sorted by the pair (order, chat_id) in decreasing order
      (For example, to get a list of chats from the beginning, the offset_order should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1)
      For optimal performance the number of returned chats is chosen by the library
    Properties:
+     chatList: ChatList
+       Description:
+         The chat list in which to return chats
  GetCreatedPublicChats
    Description:
-     Returns a list of public chats with username created by the user
+     Returns a list of public chats of the specified type, owned by the user
    Properties:
+     type: PublicChatType
+       Description:
+         Type of the public chats to return
  SearchMessages
    Properties:
+     chatList: ChatList
+       Description:
+         Chat list in which to search messages
+         Pass null to search in all chats regardless of their chat list
  GetPublicMessageLink
    Description:
      Returns a public HTTPS link to a message
-     Available only for messages in supergroups and channels with username
+     Available only for messages in supergroups and channels with a username
  DeleteChatMessagesFromUser
    Description:
      Deletes all messages sent by the specified user to a chat
-     Supported only in supergroups
+     Supported only for supergroups
      Requires can_delete_messages administrator privileges
  GetInlineQueryResults
    Properties:
      chatId
        Description:
-         Identifier of the chat, where the query was sent
+         Identifier of the chat where the query was sent
  CreateNewSupergroupChat
    Properties:
+     location: ChatLocation
+       Description:
+         Chat location if a location-based supergroup is being created
  ToggleChatIsPinned
    Description:
      Changes the pinned state of a chat
-     You can pin up to GetOption("pinned_chat_count_max") non-secret chats and the same number of secret chats
+     You can pin up to GetOption("pinned_chat_count_max")/GetOption("pinned_archived_chat_count_max") non-secret chats and the same number of secret chats in the main/archive chat list
  SetChatMemberStatus
    Description:
      Changes the status of a chat member, needs appropriate privileges
-     This function is currently not suitable for adding new members to the chat
+     This function is currently not suitable for adding new members to the chat and transferring chat ownership
-     Instead, use addChatMember
+     Instead, use addChatMember or transferChatOwnership
      The chat member status will not be changed until it has been synchronized with the server
  SetPinnedChats
    Properties:
+     chatList: ChatList
+       Description:
+         Chat list in which to change the order of pinned chats
  ImportContacts
    Description:
-     Adds new contacts or edits existing contacts
+     Adds new contacts or edits existing contacts by their phone numbers
      Contacts' user identifiers are ignored
    Properties:
      contacts
        Description:
-         The list of contacts to import or edit, contact's vCard are ignored and are not imported
+         The list of contacts to import or edit
+         Contacts' vCard are ignored and are not imported
  SetSupergroupUsername
    Description:
-     Changes the username of a supergroup or channel, requires creator privileges in the supergroup or channel
+     Changes the username of a supergroup or channel, requires owner privileges in the supergroup or channel
  DeleteSupergroup
    Description:
      Deletes a supergroup or channel along with all messages in the corresponding chat
      This will release the supergroup or channel username and remove all members
-     Requires creator privileges in the supergroup or channel
+     Requires owner privileges in the supergroup or channel
      Chats with more than 1000 members can't be deleted using this method
  GetChatEventLog
    Description:
      Returns a list of service actions taken by chat members and administrators in the last 48 hours
-     Available only in supergroups and channels
+     Available only for supergroups and channels
      Requires administrator rights
      Returns results in reverse chronological order (i
      E., in order of decreasing event_id)
  ReportChat
    Description:
      Reports a chat to the Telegram moderators
-     Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators
+     Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators, or when the report is done from the chat action bar
```

## 1.5.1

```diff
Objects:
+ TonLiteServerResponse
+   Description:
+     Contains the response of a request to TON lite server
+   Properties:
+     response: ByteArray
+       Description:
+         The response
+ TonWalletPasswordSalt
+   Description:
+     Contains the salt to be used with locally stored password to access a local TON-based wallet
+   Properties:
+     salt: ByteArray
+       Description:
+         The salt
Functions:
+ SendTonLiteServerRequest
+   Returns: TonLiteServerResponse
+   Description:
+     Sends a request to TON lite server through Telegram servers
+   Properties:
+     request: ByteArray
+       Description:
+         The request
+ GetTonWalletPasswordSalt
+   Returns: TonWalletPasswordSalt
+   Description:
+     Returns a salt to be used with locally stored password to access a local TON-based wallet
  TestProxy
    Properties:
+     dcId: Int
+       Description:
+         Identifier of a datacenter, with which to test connection
+     timeout: Double
+       Description:
+         Maximum overall timeout for the request
```
