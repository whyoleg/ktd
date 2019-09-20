@file:Suppress("unused")

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a chat by its identifier, this is an offline request if the current user is not a bot
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChat(
    chatId: Long
): Chat = chat(
    GetChat(
        chatId
    )
)

/**
 * Searches a public chat by its username. Currently only private chats, supergroups and channels can be public. Returns the chat if found; otherwise an error is returned
 *
 * @username - Username to be resolved
 */
suspend fun TelegramClient.searchPublicChat(
    username: String
): Chat = chat(
    SearchPublicChat(
        username
    )
)

/**
 * Removes a chat from the list of frequently used chats. Supported only if the chat info database is enabled
 *
 * @category - Category of frequently used chats
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.removeTopChat(
    category: TopChatCategory,
    chatId: Long
): Ok = chat(
    RemoveTopChat(
        category,
        chatId
    )
)

/**
 * Deletes all messages in the chat. Use Chat.can_be_deleted_only_for_self and Chat.can_be_deleted_for_all_users fields to find whether and how the method can be applied to the chat
 *
 * @chatId - Chat identifier
 * @removeFromChatList - Pass true if the chat should be removed from the chat list
 * @revoke - Pass true to try to delete chat history for all users
 */
suspend fun TelegramClient.deleteChatHistory(
    chatId: Long,
    removeFromChatList: Boolean,
    revoke: Boolean
): Ok = chat(
    DeleteChatHistory(
        chatId,
        removeFromChatList,
        revoke
    )
)

/**
 * Sends a notification about a screenshot taken in a chat. Supported only in private and secret chats
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.sendChatScreenshotTakenNotification(
    chatId: Long
): Ok = chat(
    SendChatScreenshotTakenNotification(
        chatId
    )
)

/**
 * Deletes all messages sent by the specified user to a chat. Supported only in supergroups; requires can_delete_messages administrator privileges
 *
 * @chatId - Chat identifier
 * @userId - User identifier
 */
suspend fun TelegramClient.deleteChatMessagesFromUser(
    chatId: Long,
    userId: Int
): Ok = chat(
    DeleteChatMessagesFromUser(
        chatId,
        userId
    )
)

/**
 * Deletes the default reply markup from a chat. Must be called after a one-time keyboard or a ForceReply reply markup has been used. UpdateChatReplyMarkup will be sent if the reply markup will be changed
 *
 * @chatId - Chat identifier
 * @messageId - The message identifier of the used keyboard
 */
suspend fun TelegramClient.deleteChatReplyMarkup(
    chatId: Long,
    messageId: Long
): Ok = chat(
    DeleteChatReplyMarkup(
        chatId,
        messageId
    )
)

/**
 * Sends a notification about user activity in a chat
 *
 * @chatId - Chat identifier
 * @action - The action description
 */
suspend fun TelegramClient.sendChatAction(
    chatId: Long,
    action: ChatAction
): Ok = chat(
    SendChatAction(
        chatId,
        action
    )
)

/**
 * Informs TDLib that the chat is opened by the user. Many useful activities depend on the chat being opened or closed (e.g., in supergroups and channels all updates are received only for opened chats)
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.openChat(
    chatId: Long
): Ok = chat(
    OpenChat(
        chatId
    )
)

/**
 * Informs TDLib that the chat is closed by the user. Many useful activities depend on the chat being opened or closed
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.closeChat(
    chatId: Long
): Ok = chat(
    CloseChat(
        chatId
    )
)

/**
 * Marks all mentions in a chat as read
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.readAllChatMentions(
    chatId: Long
): Ok = chat(
    ReadAllChatMentions(
        chatId
    )
)

/**
 * Returns an existing chat corresponding to a given user
 *
 * @userId - User identifier
 * @force - If true, the chat will be created without network request. In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TelegramClient.createPrivateChat(
    userId: Int,
    force: Boolean
): Chat = chat(
    CreatePrivateChat(
        userId,
        force
    )
)

/**
 * Returns an existing chat corresponding to a known basic group
 *
 * @basicGroupId - Basic group identifier
 * @force - If true, the chat will be created without network request. In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TelegramClient.createBasicGroupChat(
    basicGroupId: Int,
    force: Boolean
): Chat = chat(
    CreateBasicGroupChat(
        basicGroupId,
        force
    )
)

/**
 * Returns an existing chat corresponding to a known supergroup or channel
 *
 * @supergroupId - Supergroup or channel identifier
 * @force - If true, the chat will be created without network request. In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TelegramClient.createSupergroupChat(
    supergroupId: Int,
    force: Boolean
): Chat = chat(
    CreateSupergroupChat(
        supergroupId,
        force
    )
)

/**
 * Returns an existing chat corresponding to a known secret chat
 *
 * @secretChatId - Secret chat identifier
 */
suspend fun TelegramClient.createSecretChat(
    secretChatId: Int
): Chat = chat(
    CreateSecretChat(
        secretChatId
    )
)

/**
 * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate. Returns the newly created chat
 *
 * @userIds - Identifiers of users to be added to the basic group
 * @title - Title of the new basic group; 1-128 characters
 */
suspend fun TelegramClient.createNewBasicGroupChat(
    userIds: IntArray,
    title: String
): Chat = chat(
    CreateNewBasicGroupChat(
        userIds,
        title
    )
)

/**
 * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate. Returns the newly created chat
 *
 * @title - Title of the new chat; 1-128 characters
 * @isChannel - True, if a channel chat should be created
 * @paramDescription - Chat description; 0-255 characters
 */
suspend fun TelegramClient.createNewSupergroupChat(
    title: String,
    isChannel: Boolean,
    description: String
): Chat = chat(
    CreateNewSupergroupChat(
        title,
        isChannel,
        description
    )
)

/**
 * Creates a new secret chat. Returns the newly created chat
 *
 * @userId - Identifier of the target user
 */
suspend fun TelegramClient.createNewSecretChat(
    userId: Int
): Chat = chat(
    CreateNewSecretChat(
        userId
    )
)

/**
 * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom; requires creator privileges. Deactivates the original basic group
 *
 * @chatId - Identifier of the chat to upgrade
 */
suspend fun TelegramClient.upgradeBasicGroupChatToSupergroupChat(
    chatId: Long
): Chat = chat(
    UpgradeBasicGroupChatToSupergroupChat(
        chatId
    )
)

/**
 * Changes the chat title. Supported only for basic groups, supergroups and channels. Requires can_change_info rights. The title will not be changed until the request to the server has been completed
 *
 * @chatId - Chat identifier
 * @title - New title of the chat; 1-128 characters
 */
suspend fun TelegramClient.setChatTitle(
    chatId: Long,
    title: String
): Ok = chat(
    SetChatTitle(
        chatId,
        title
    )
)

/**
 * Changes the photo of a chat. Supported only for basic groups, supergroups and channels. Requires can_change_info rights. The photo will not be changed before request to the server has been completed
 *
 * @chatId - Chat identifier
 * @photo - New chat photo. You can use a zero InputFileId to delete the chat photo. Files that are accessible only by HTTP URL are not acceptable
 */
suspend fun TelegramClient.setChatPhoto(
    chatId: Long,
    photo: InputFile
): Ok = chat(
    SetChatPhoto(
        chatId,
        photo
    )
)

/**
 * Changes the chat members permissions. Supported only for basic groups and supergroups. Requires can_restrict_members administrator right
 *
 * @chatId - Chat identifier
 * @permissions - New non-administrator members permissions in the chat
 */
suspend fun TelegramClient.setChatPermissions(
    chatId: Long,
    permissions: ChatPermissions
): Ok = chat(
    SetChatPermissions(
        chatId,
        permissions
    )
)

/**
 * Changes the draft message in a chat
 *
 * @chatId - Chat identifier
 * @draftMessage - New draft message; may be null
 */
suspend fun TelegramClient.setChatDraftMessage(
    chatId: Long,
    draftMessage: DraftMessage
): Ok = chat(
    SetChatDraftMessage(
        chatId,
        draftMessage
    )
)

/**
 * Changes the notification settings of a chat
 *
 * @chatId - Chat identifier
 * @notificationSettings - New notification settings for the chat
 */
suspend fun TelegramClient.setChatNotificationSettings(
    chatId: Long,
    notificationSettings: ChatNotificationSettings
): Ok = chat(
    SetChatNotificationSettings(
        chatId,
        notificationSettings
    )
)

/**
 * Changes the pinned state of a chat. You can pin up to GetOption("pinned_chat_count_max") non-secret chats and the same number of secret chats
 *
 * @chatId - Chat identifier
 * @isPinned - New value of isPinned
 */
suspend fun TelegramClient.toggleChatIsPinned(
    chatId: Long,
    isPinned: Boolean
): Ok = chat(
    ToggleChatIsPinned(
        chatId,
        isPinned
    )
)

/**
 * Changes the marked as unread state of a chat
 *
 * @chatId - Chat identifier
 * @isMarkedAsUnread - New value of isMarkedAsUnread
 */
suspend fun TelegramClient.toggleChatIsMarkedAsUnread(
    chatId: Long,
    isMarkedAsUnread: Boolean
): Ok = chat(
    ToggleChatIsMarkedAsUnread(
        chatId,
        isMarkedAsUnread
    )
)

/**
 * Changes the value of the default disable_notification parameter, used when a message is sent to a chat
 *
 * @chatId - Chat identifier
 * @defaultDisableNotification - New value of defaultDisableNotification
 */
suspend fun TelegramClient.toggleChatDefaultDisableNotification(
    chatId: Long,
    defaultDisableNotification: Boolean
): Ok = chat(
    ToggleChatDefaultDisableNotification(
        chatId,
        defaultDisableNotification
    )
)

/**
 * Changes client data associated with a chat
 *
 * @chatId - Chat identifier
 * @clientData - New value of clientData
 */
suspend fun TelegramClient.setChatClientData(
    chatId: Long,
    clientData: String
): Ok = chat(
    SetChatClientData(
        chatId,
        clientData
    )
)

/**
 * Changes information about a chat. Available for basic groups, supergroups, and channels. Requires can_change_info rights
 *
 * @chatId - Identifier of the chat
 * @paramDescription - New chat description; 0-255 characters
 */
suspend fun TelegramClient.setChatDescription(
    chatId: Long,
    description: String
): Ok = chat(
    SetChatDescription(
        chatId,
        description
    )
)

/**
 * Pins a message in a chat; requires can_pin_messages rights
 *
 * @chatId - Identifier of the chat
 * @messageId - Identifier of the new pinned message
 * @disableNotification - True, if there should be no notification about the pinned message
 */
suspend fun TelegramClient.pinChatMessage(
    chatId: Long,
    messageId: Long,
    disableNotification: Boolean
): Ok = chat(
    PinChatMessage(
        chatId,
        messageId,
        disableNotification
    )
)

/**
 * Removes the pinned message from a chat; requires can_pin_messages rights in the group or channel
 *
 * @chatId - Identifier of the chat
 */
suspend fun TelegramClient.unpinChatMessage(
    chatId: Long
): Ok = chat(
    UnpinChatMessage(
        chatId
    )
)

/**
 * Adds current user as a new member to a chat. Private and secret chats can't be joined using this method
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.joinChat(
    chatId: Long
): Ok = chat(
    JoinChat(
        chatId
    )
)

/**
 * Removes current user from chat members. Private and secret chats can't be left using this method
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.leaveChat(
    chatId: Long
): Ok = chat(
    LeaveChat(
        chatId
    )
)

/**
 * Adds a new member to a chat. Members can't be added to private or secret chats. Members will not be added until the chat state has been synchronized with the server
 *
 * @chatId - Chat identifier
 * @userId - Identifier of the user
 * @forwardLimit - The number of earlier messages from the chat to be forwarded to the new member; up to 100. Ignored for supergroups and channels
 */
suspend fun TelegramClient.addChatMember(
    chatId: Long,
    userId: Int,
    forwardLimit: Int
): Ok = chat(
    AddChatMember(
        chatId,
        userId,
        forwardLimit
    )
)

/**
 * Adds multiple new members to a chat. Currently this option is only available for supergroups and channels. This option can't be used to join a chat. Members can't be added to a channel if it has more than 200 members. Members will not be added until the chat state has been synchronized with the server
 *
 * @chatId - Chat identifier
 * @userIds - Identifiers of the users to be added to the chat
 */
suspend fun TelegramClient.addChatMembers(
    chatId: Long,
    userIds: IntArray
): Ok = chat(
    AddChatMembers(
        chatId,
        userIds
    )
)

/**
 * Changes the status of a chat member, needs appropriate privileges. This function is currently not suitable for adding new members to the chat; instead, use addChatMember. The chat member status will not be changed until it has been synchronized with the server
 *
 * @chatId - Chat identifier
 * @userId - User identifier
 * @status - The new status of the member in the chat
 */
suspend fun TelegramClient.setChatMemberStatus(
    chatId: Long,
    userId: Int,
    status: ChatMemberStatus
): Ok = chat(
    SetChatMemberStatus(
        chatId,
        userId,
        status
    )
)

/**
 * Returns information about a single member of a chat
 *
 * @chatId - Chat identifier
 * @userId - User identifier
 */
suspend fun TelegramClient.getChatMember(
    chatId: Long,
    userId: Int
): ChatMember = chat(
    GetChatMember(
        chatId,
        userId
    )
)

/**
 * Searches for a specified query in the first name, last name and username of the members of a specified chat. Requires administrator rights in channels
 *
 * @chatId - Chat identifier
 * @query - Query to search for
 * @limit - The maximum number of users to be returned
 * @filter - The type of users to return. By default, chatMembersFilterMembers
 */
suspend fun TelegramClient.searchChatMembers(
    chatId: Long,
    query: String,
    limit: Int,
    filter: ChatMembersFilter
): ChatMembers = chat(
    SearchChatMembers(
        chatId,
        query,
        limit,
        filter
    )
)

/**
 * Generates a new invite link for a chat; the previously generated link is revoked. Available for basic groups, supergroups, and channels. Requires administrator privileges and can_invite_users right
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.generateChatInviteLink(
    chatId: Long
): ChatInviteLink = chat(
    GenerateChatInviteLink(
        chatId
    )
)

/**
 * Checks the validity of an invite link for a chat and returns information about the corresponding chat
 *
 * @inviteLink - Invite link to be checked; should begin with "https:t.me/joinchat/", "https:telegram.me/joinchat/", or "https:telegram.dog/joinchat/"
 */
suspend fun TelegramClient.checkChatInviteLink(
    inviteLink: String
): ChatInviteLinkInfo = chat(
    CheckChatInviteLink(
        inviteLink
    )
)

/**
 * Uses an invite link to add the current user to the chat if possible. The new member will not be added until the chat state has been synchronized with the server
 *
 * @inviteLink - Invite link to import; should begin with "https:t.me/joinchat/", "https:telegram.me/joinchat/", or "https:telegram.dog/joinchat/"
 */
suspend fun TelegramClient.joinChatByInviteLink(
    inviteLink: String
): Chat = chat(
    JoinChatByInviteLink(
        inviteLink
    )
)

/**
 * Returns information about members or banned users in a supergroup or channel. Can be used only if SupergroupFullInfo.can_get_members == true; additionally, administrator privileges may be required for some filters
 *
 * @supergroupId - Identifier of the supergroup or channel
 * @filter - The type of users to return. By default, supergroupMembersRecent
 * @offset - Number of users to skip
 * @limit - The maximum number of users be returned; up to 200
 */
suspend fun TelegramClient.getSupergroupMembers(
    supergroupId: Int,
    filter: SupergroupMembersFilter,
    offset: Int,
    limit: Int
): ChatMembers = chat(
    GetSupergroupMembers(
        supergroupId,
        filter,
        offset,
        limit
    )
)

/**
 * Returns a list of service actions taken by chat members and administrators in the last 48 hours. Available only in supergroups and channels. Requires administrator rights. Returns results in reverse chronological order (i. e., in order of decreasing event_id)
 *
 * @chatId - Chat identifier
 * @query - Search query by which to filter events
 * @fromEventId - Identifier of an event from which to return results. Use 0 to get results from the latest events
 * @limit - Maximum number of events to return; up to 100
 * @filters - The types of events to return. By default, all types will be returned
 * @userIds - User identifiers by which to filter events. By default, events relating to all users will be returned
 */
suspend fun TelegramClient.getChatEventLog(
    chatId: Long,
    query: String,
    fromEventId: Long,
    limit: Int,
    filters: ChatEventLogFilters,
    userIds: IntArray
): ChatEvents = chat(
    GetChatEventLog(
        chatId,
        query,
        fromEventId,
        limit,
        filters,
        userIds
    )
)

/**
 * Returns information on whether the current chat can be reported as spam
 *
 * @chatId - Chat identifier
 */
suspend fun TelegramClient.getChatReportSpamState(
    chatId: Long
): ChatReportSpamState = chat(
    GetChatReportSpamState(
        chatId
    )
)

/**
 * Reports to the server whether a chat is a spam chat or not. Can be used only if ChatReportSpamState.can_report_spam is true. After this request, ChatReportSpamState.can_report_spam becomes false forever
 *
 * @chatId - Chat identifier
 * @isSpamChat - If true, the chat will be reported as spam; otherwise it will be marked as not spam
 */
suspend fun TelegramClient.changeChatReportSpamState(
    chatId: Long,
    isSpamChat: Boolean
): Ok = chat(
    ChangeChatReportSpamState(
        chatId,
        isSpamChat
    )
)

/**
 * Reports a chat to the Telegram moderators. Supported only for supergroups, channels, or private chats with bots, since other chats can't be checked by moderators
 *
 * @chatId - Chat identifier
 * @reason - The reason for reporting the chat
 * @messageIds - Identifiers of reported messages, if any
 */
suspend fun TelegramClient.reportChat(
    chatId: Long,
    reason: ChatReportReason,
    messageIds: LongArray
): Ok = chat(
    ReportChat(
        chatId,
        reason,
        messageIds
    )
)
