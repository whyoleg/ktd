@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
 */
suspend fun TelegramClient.chat(
    f: GetChat
): Chat = exec(f) as Chat

/**
 * Returns an ordered list of chats
 * Chats are sorted by the pair (order, chat_id) in decreasing order
 * (For example, to get a list of chats from the beginning, the offset_order should be equal to a biggest signed 64-bit number 9223372036854775807 == 2^63 - 1)
 * For optimal performance the number of returned chats is chosen by the library.
 */
suspend fun TelegramClient.chat(
    f: GetChats
): Chats = exec(f) as Chats

/**
 * Searches a public chat by its username
 * Currently only private chats, supergroups and channels can be public
 * Returns the chat if found
 * Otherwise an error is returned
 */
suspend fun TelegramClient.chat(
    f: SearchPublicChat
): Chat = exec(f) as Chat

/**
 * Searches public chats by looking for specified query in their username and title
 * Currently only private chats, supergroups and channels can be public
 * Returns a meaningful number of results
 * Returns nothing if the length of the searched username prefix is less than 5
 * Excludes private chats with contacts and chats from the chat list from the results
 */
suspend fun TelegramClient.chat(
    f: SearchPublicChats
): Chats = exec(f) as Chats

/**
 * Searches for the specified query in the title and username of already known chats, this is an offline request
 * Returns chats in the order seen in the chat list
 */
suspend fun TelegramClient.chat(
    f: SearchChats
): Chats = exec(f) as Chats

/**
 * Searches for the specified query in the title and username of already known chats via request to the server
 * Returns chats in the order seen in the chat list
 */
suspend fun TelegramClient.chat(
    f: SearchChatsOnServer
): Chats = exec(f) as Chats

/**
 * Returns a list of frequently used chats
 * Supported only if the chat info database is enabled
 */
suspend fun TelegramClient.chat(
    f: GetTopChats
): Chats = exec(f) as Chats

/**
 * Removes a chat from the list of frequently used chats
 * Supported only if the chat info database is enabled
 */
suspend fun TelegramClient.chat(
    f: RemoveTopChat
): Ok = exec(f) as Ok

/**
 * Adds a chat to the list of recently found chats
 * The chat is added to the beginning of the list
 * If the chat is already in the list, it will be removed from the list first
 */
suspend fun TelegramClient.chat(
    f: AddRecentlyFoundChat
): Ok = exec(f) as Ok

/**
 * Removes a chat from the list of recently found chats
 */
suspend fun TelegramClient.chat(
    f: RemoveRecentlyFoundChat
): Ok = exec(f) as Ok

/**
 * Clears the list of recently found chats
 */
suspend fun TelegramClient.chat(
    f: ClearRecentlyFoundChats
): Ok = exec(f) as Ok

/**
 * Returns a list of public chats created by the user
 */
suspend fun TelegramClient.chat(
    f: GetCreatedPublicChats
): Chats = exec(f) as Chats

/**
 * Returns a list of common group chats with a given user
 * Chats are sorted by their type and creation date
 */
suspend fun TelegramClient.chat(
    f: GetGroupsInCommon
): Chats = exec(f) as Chats

/**
 * Deletes all messages in the chat
 * Use Chat.can_be_deleted_only_for_self and Chat.can_be_deleted_for_all_users fields to find whether and how the method can be applied to the chat
 */
suspend fun TelegramClient.chat(
    f: DeleteChatHistory
): Ok = exec(f) as Ok

/**
 * Returns approximate number of messages of the specified type in the chat
 */
suspend fun TelegramClient.chat(
    f: GetChatMessageCount
): Count = exec(f) as Count

/**
 * Sends a notification about a screenshot taken in a chat
 * Supported only in private and secret chats
 */
suspend fun TelegramClient.chat(
    f: SendChatScreenshotTakenNotification
): Ok = exec(f) as Ok

/**
 * Deletes all messages sent by the specified user to a chat
 * Supported only in supergroups
 * Requires can_delete_messages administrator privileges
 */
suspend fun TelegramClient.chat(
    f: DeleteChatMessagesFromUser
): Ok = exec(f) as Ok

/**
 * Deletes the default reply markup from a chat
 * Must be called after a one-time keyboard or a ForceReply reply markup has been used
 * UpdateChatReplyMarkup will be sent if the reply markup will be changed
 */
suspend fun TelegramClient.chat(
    f: DeleteChatReplyMarkup
): Ok = exec(f) as Ok

/**
 * Sends a notification about user activity in a chat
 */
suspend fun TelegramClient.chat(
    f: SendChatAction
): Ok = exec(f) as Ok

/**
 * Informs TDLib that the chat is opened by the user
 * Many useful activities depend on the chat being opened or closed (e.g., in supergroups and channels all updates are received only for opened chats)
 */
suspend fun TelegramClient.chat(
    f: OpenChat
): Ok = exec(f) as Ok

/**
 * Informs TDLib that the chat is closed by the user
 * Many useful activities depend on the chat being opened or closed
 */
suspend fun TelegramClient.chat(
    f: CloseChat
): Ok = exec(f) as Ok

/**
 * Marks all mentions in a chat as read
 */
suspend fun TelegramClient.chat(
    f: ReadAllChatMentions
): Ok = exec(f) as Ok

/**
 * Returns an existing chat corresponding to a given user
 */
suspend fun TelegramClient.chat(
    f: CreatePrivateChat
): Chat = exec(f) as Chat

/**
 * Returns an existing chat corresponding to a known basic group
 */
suspend fun TelegramClient.chat(
    f: CreateBasicGroupChat
): Chat = exec(f) as Chat

/**
 * Returns an existing chat corresponding to a known supergroup or channel
 */
suspend fun TelegramClient.chat(
    f: CreateSupergroupChat
): Chat = exec(f) as Chat

/**
 * Returns an existing chat corresponding to a known secret chat
 */
suspend fun TelegramClient.chat(
    f: CreateSecretChat
): Chat = exec(f) as Chat

/**
 * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate
 * Returns the newly created chat
 */
suspend fun TelegramClient.chat(
    f: CreateNewBasicGroupChat
): Chat = exec(f) as Chat

/**
 * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate
 * Returns the newly created chat
 */
suspend fun TelegramClient.chat(
    f: CreateNewSupergroupChat
): Chat = exec(f) as Chat

/**
 * Creates a new secret chat
 * Returns the newly created chat
 */
suspend fun TelegramClient.chat(
    f: CreateNewSecretChat
): Chat = exec(f) as Chat

/**
 * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom
 * Deactivates the original basic group
 */
suspend fun TelegramClient.chat(
    f: UpgradeBasicGroupChatToSupergroupChat
): Chat = exec(f) as Chat

/**
 * Changes the chat title
 * Supported only for basic groups, supergroups and channels
 * Requires administrator rights in basic groups and the appropriate administrator rights in supergroups and channels
 * The title will not be changed until the request to the server has been completed
 */
suspend fun TelegramClient.chat(
    f: SetChatTitle
): Ok = exec(f) as Ok

/**
 * Changes the photo of a chat
 * Supported only for basic groups, supergroups and channels
 * Requires administrator rights in basic groups and the appropriate administrator rights in supergroups and channels
 * The photo will not be changed before request to the server has been completed
 */
suspend fun TelegramClient.chat(
    f: SetChatPhoto
): Ok = exec(f) as Ok

/**
 * Changes the draft message in a chat
 */
suspend fun TelegramClient.chat(
    f: SetChatDraftMessage
): Ok = exec(f) as Ok

/**
 * Changes the notification settings of a chat
 */
suspend fun TelegramClient.chat(
    f: SetChatNotificationSettings
): Ok = exec(f) as Ok

/**
 * Changes the pinned state of a chat
 * You can pin up to GetOption("pinned_chat_count_max") non-secret chats and the same number of secret chats
 */
suspend fun TelegramClient.chat(
    f: ToggleChatIsPinned
): Ok = exec(f) as Ok

/**
 * Changes the marked as unread state of a chat
 */
suspend fun TelegramClient.chat(
    f: ToggleChatIsMarkedAsUnread
): Ok = exec(f) as Ok

/**
 * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
 */
suspend fun TelegramClient.chat(
    f: ToggleChatDefaultDisableNotification
): Ok = exec(f) as Ok

/**
 * Changes client data associated with a chat
 */
suspend fun TelegramClient.chat(
    f: SetChatClientData
): Ok = exec(f) as Ok

/**
 * Pins a message in a chat
 * Requires appropriate administrator rights in the group or channel
 */
suspend fun TelegramClient.chat(
    f: PinChatMessage
): Ok = exec(f) as Ok

/**
 * Removes the pinned message from a chat
 * Requires appropriate administrator rights in the group or channel
 */
suspend fun TelegramClient.chat(
    f: UnpinChatMessage
): Ok = exec(f) as Ok

/**
 * Adds current user as a new member to a chat
 * Private and secret chats can't be joined using this method
 */
suspend fun TelegramClient.chat(
    f: JoinChat
): Ok = exec(f) as Ok

/**
 * Removes current user from chat members
 * Private and secret chats can't be left using this method
 */
suspend fun TelegramClient.chat(
    f: LeaveChat
): Ok = exec(f) as Ok

/**
 * Adds a new member to a chat
 * Members can't be added to private or secret chats
 * Members will not be added until the chat state has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: AddChatMember
): Ok = exec(f) as Ok

/**
 * Adds multiple new members to a chat
 * Currently this option is only available for supergroups and channels
 * This option can't be used to join a chat
 * Members can't be added to a channel if it has more than 200 members
 * Members will not be added until the chat state has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: AddChatMembers
): Ok = exec(f) as Ok

/**
 * Changes the status of a chat member, needs appropriate privileges
 * This function is currently not suitable for adding new members to the chat
 * Instead, use addChatMember
 * The chat member status will not be changed until it has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: SetChatMemberStatus
): Ok = exec(f) as Ok

/**
 * Returns information about a single member of a chat
 */
suspend fun TelegramClient.chat(
    f: GetChatMember
): ChatMember = exec(f) as ChatMember

/**
 * Searches for a specified query in the first name, last name and username of the members of a specified chat
 * Requires administrator rights in channels
 */
suspend fun TelegramClient.chat(
    f: SearchChatMembers
): ChatMembers = exec(f) as ChatMembers

/**
 * Returns list of chats with non-default notification settings
 */
suspend fun TelegramClient.chat(
    f: GetChatNotificationSettingsExceptions
): Chats = exec(f) as Chats

/**
 * Changes the order of pinned chats
 */
suspend fun TelegramClient.chat(
    f: SetPinnedChats
): Ok = exec(f) as Ok

/**
 * Generates a new invite link for a chat
 * The previously generated link is revoked
 * Available for basic groups, supergroups, and channels
 * In basic groups this can be called only by the group's creator
 * In supergroups and channels this requires appropriate administrator rights
 */
suspend fun TelegramClient.chat(
    f: GenerateChatInviteLink
): ChatInviteLink = exec(f) as ChatInviteLink

/**
 * Checks the validity of an invite link for a chat and returns information about the corresponding chat
 */
suspend fun TelegramClient.chat(
    f: CheckChatInviteLink
): ChatInviteLinkInfo = exec(f) as ChatInviteLinkInfo

/**
 * Uses an invite link to add the current user to the chat if possible
 * The new member will not be added until the chat state has been synchronized with the server
 */
suspend fun TelegramClient.chat(
    f: JoinChatByInviteLink
): Chat = exec(f) as Chat

/**
 * Returns information about members or banned users in a supergroup or channel
 * Can be used only if SupergroupFullInfo.can_get_members == true
 * Additionally, administrator privileges may be required for some filters
 */
suspend fun TelegramClient.chat(
    f: GetSupergroupMembers
): ChatMembers = exec(f) as ChatMembers

/**
 * Returns a list of service actions taken by chat members and administrators in the last 48 hours
 * Available only in supergroups and channels
 * Requires administrator rights
 * Returns results in reverse chronological order (i
 * E., in order of decreasing event_id)
 */
suspend fun TelegramClient.chat(
    f: GetChatEventLog
): ChatEvents = exec(f) as ChatEvents

/**
 * Returns information on whether the current chat can be reported as spam
 */
suspend fun TelegramClient.chat(
    f: GetChatReportSpamState
): ChatReportSpamState = exec(f) as ChatReportSpamState

/**
 * Reports to the server whether a chat is a spam chat or not
 * Can be used only if ChatReportSpamState.can_report_spam is true
 * After this request, ChatReportSpamState.can_report_spam becomes false forever
 */
suspend fun TelegramClient.chat(
    f: ChangeChatReportSpamState
): Ok = exec(f) as Ok

/**
 * Reports a chat to the Telegram moderators
 * Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators
 */
suspend fun TelegramClient.chat(
    f: ReportChat
): Ok = exec(f) as Ok

/**
 * Returns URL with the chat statistics
 * Currently this method can be used only for channels
 */
suspend fun TelegramClient.chat(
    f: GetChatStatisticsUrl
): HttpUrl = exec(f) as HttpUrl
