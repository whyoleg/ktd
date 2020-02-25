@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.chat

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChat(chatId)", "dev.whyoleg.ktd.api.suspend.getChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChat(chatId: Long = 0L): TdChat = exec(TdGetChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChats): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChats(chatList, offsetOrder, offsetChatId, limit)",
            "dev.whyoleg.ktd.api.suspend.getChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChats(
    chatList: TdChatList? = null,
    offsetOrder: Long = 0L,
    offsetChatId: Long = 0L,
    limit: Int = 0
): TdChats = exec(TdGetChats(chatList, offsetOrder, offsetChatId, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSearchPublicChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchPublicChat(username)",
            "dev.whyoleg.ktd.api.suspend.searchPublicChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchPublicChat(username: String? = null): TdChat =
        exec(TdSearchPublicChat(username))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSearchPublicChats): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchPublicChats(query)",
            "dev.whyoleg.ktd.api.suspend.searchPublicChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchPublicChats(query: String? = null): TdChats =
        exec(TdSearchPublicChats(query))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSearchChats): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchChats(query, limit)",
            "dev.whyoleg.ktd.api.suspend.searchChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchChats(query: String? = null, limit: Int = 0): TdChats =
        exec(TdSearchChats(query, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSearchChatsOnServer): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchChatsOnServer(query, limit)",
            "dev.whyoleg.ktd.api.suspend.searchChatsOnServer"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchChatsOnServer(query: String? = null, limit: Int = 0): TdChats =
        exec(TdSearchChatsOnServer(query, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSearchChatsNearby): TdChatsNearby = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchChatsNearby(location)",
            "dev.whyoleg.ktd.api.suspend.searchChatsNearby"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchChatsNearby(location: TdLocation? = null): TdChatsNearby =
        exec(TdSearchChatsNearby(location))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetTopChats): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getTopChats(category, limit)",
            "dev.whyoleg.ktd.api.suspend.getTopChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getTopChats(category: TdTopChatCategory? = null, limit: Int = 0): TdChats
        = exec(TdGetTopChats(category, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdRemoveTopChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeTopChat(category, chatId)",
            "dev.whyoleg.ktd.api.suspend.removeTopChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeTopChat(category: TdTopChatCategory? = null, chatId: Long = 0L):
        TdOk = exec(TdRemoveTopChat(category, chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdAddRecentlyFoundChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addRecentlyFoundChat(chatId)",
            "dev.whyoleg.ktd.api.suspend.addRecentlyFoundChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addRecentlyFoundChat(chatId: Long = 0L): TdOk =
        exec(TdAddRecentlyFoundChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdRemoveRecentlyFoundChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeRecentlyFoundChat(chatId)",
            "dev.whyoleg.ktd.api.suspend.removeRecentlyFoundChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeRecentlyFoundChat(chatId: Long = 0L): TdOk =
        exec(TdRemoveRecentlyFoundChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdClearRecentlyFoundChats): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("clearRecentlyFoundChats()",
            "dev.whyoleg.ktd.api.suspend.clearRecentlyFoundChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.clearRecentlyFoundChats(): TdOk = exec(TdClearRecentlyFoundChats())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetCreatedPublicChats): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getCreatedPublicChats(type)",
            "dev.whyoleg.ktd.api.suspend.getCreatedPublicChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getCreatedPublicChats(type: TdPublicChatType? = null): TdChats =
        exec(TdGetCreatedPublicChats(type))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetSuitableDiscussionChats): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSuitableDiscussionChats()",
            "dev.whyoleg.ktd.api.suspend.getSuitableDiscussionChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSuitableDiscussionChats(): TdChats =
        exec(TdGetSuitableDiscussionChats())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetInactiveSupergroupChats): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getInactiveSupergroupChats()",
            "dev.whyoleg.ktd.api.suspend.getInactiveSupergroupChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getInactiveSupergroupChats(): TdChats =
        exec(TdGetInactiveSupergroupChats())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetGroupsInCommon): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getGroupsInCommon(userId, offsetChatId, limit)",
            "dev.whyoleg.ktd.api.suspend.getGroupsInCommon"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getGroupsInCommon(
    userId: Int = 0,
    offsetChatId: Long = 0L,
    limit: Int = 0
): TdChats = exec(TdGetGroupsInCommon(userId, offsetChatId, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdDeleteChatHistory): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteChatHistory(chatId, removeFromChatList, revoke)",
            "dev.whyoleg.ktd.api.suspend.deleteChatHistory"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteChatHistory(
    chatId: Long = 0L,
    removeFromChatList: Boolean = false,
    revoke: Boolean = false
): TdOk = exec(TdDeleteChatHistory(chatId, removeFromChatList, revoke))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChatMessageCount): TdCount = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatMessageCount(chatId, filter, returnLocal)",
            "dev.whyoleg.ktd.api.suspend.getChatMessageCount"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatMessageCount(
    chatId: Long = 0L,
    filter: TdSearchMessagesFilter? = null,
    returnLocal: Boolean = false
): TdCount = exec(TdGetChatMessageCount(chatId, filter, returnLocal))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSendChatScreenshotTakenNotification): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendChatScreenshotTakenNotification(chatId)",
            "dev.whyoleg.ktd.api.suspend.sendChatScreenshotTakenNotification"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendChatScreenshotTakenNotification(chatId: Long = 0L): TdOk =
        exec(TdSendChatScreenshotTakenNotification(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdDeleteChatMessagesFromUser): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteChatMessagesFromUser(chatId, userId)",
            "dev.whyoleg.ktd.api.suspend.deleteChatMessagesFromUser"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteChatMessagesFromUser(chatId: Long = 0L, userId: Int = 0): TdOk =
        exec(TdDeleteChatMessagesFromUser(chatId, userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdDeleteChatReplyMarkup): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteChatReplyMarkup(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.deleteChatReplyMarkup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteChatReplyMarkup(chatId: Long = 0L, messageId: Long = 0L): TdOk =
        exec(TdDeleteChatReplyMarkup(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSendChatAction): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendChatAction(chatId, action)",
            "dev.whyoleg.ktd.api.suspend.sendChatAction"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendChatAction(chatId: Long = 0L, action: TdChatAction? = null): TdOk =
        exec(TdSendChatAction(chatId, action))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdOpenChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("openChat(chatId)", "dev.whyoleg.ktd.api.suspend.openChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.openChat(chatId: Long = 0L): TdOk = exec(TdOpenChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCloseChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("closeChat(chatId)", "dev.whyoleg.ktd.api.suspend.closeChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.closeChat(chatId: Long = 0L): TdOk = exec(TdCloseChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdReadAllChatMentions): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("readAllChatMentions(chatId)",
            "dev.whyoleg.ktd.api.suspend.readAllChatMentions"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.readAllChatMentions(chatId: Long = 0L): TdOk =
        exec(TdReadAllChatMentions(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCreatePrivateChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createPrivateChat(userId, force)",
            "dev.whyoleg.ktd.api.suspend.createPrivateChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createPrivateChat(userId: Int = 0, force: Boolean = false): TdChat =
        exec(TdCreatePrivateChat(userId, force))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCreateBasicGroupChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createBasicGroupChat(basicGroupId, force)",
            "dev.whyoleg.ktd.api.suspend.createBasicGroupChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createBasicGroupChat(basicGroupId: Int = 0, force: Boolean = false):
        TdChat = exec(TdCreateBasicGroupChat(basicGroupId, force))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCreateSupergroupChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createSupergroupChat(supergroupId, force)",
            "dev.whyoleg.ktd.api.suspend.createSupergroupChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createSupergroupChat(supergroupId: Int = 0, force: Boolean = false):
        TdChat = exec(TdCreateSupergroupChat(supergroupId, force))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCreateSecretChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createSecretChat(secretChatId)",
            "dev.whyoleg.ktd.api.suspend.createSecretChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createSecretChat(secretChatId: Int = 0): TdChat =
        exec(TdCreateSecretChat(secretChatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCreateNewBasicGroupChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createNewBasicGroupChat(userIds, title)",
            "dev.whyoleg.ktd.api.suspend.createNewBasicGroupChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createNewBasicGroupChat(userIds: IntArray = intArrayOf(), title: String?
        = null): TdChat = exec(TdCreateNewBasicGroupChat(userIds, title))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCreateNewSupergroupChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createNewSupergroupChat(title, isChannel, description, location)",
            "dev.whyoleg.ktd.api.suspend.createNewSupergroupChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createNewSupergroupChat(
    title: String? = null,
    isChannel: Boolean = false,
    description: String? = null,
    location: TdChatLocation? = null
): TdChat = exec(TdCreateNewSupergroupChat(title, isChannel, description, location))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCreateNewSecretChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("createNewSecretChat(userId)",
            "dev.whyoleg.ktd.api.suspend.createNewSecretChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.createNewSecretChat(userId: Int = 0): TdChat =
        exec(TdCreateNewSecretChat(userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdUpgradeBasicGroupChatToSupergroupChat): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("upgradeBasicGroupChatToSupergroupChat(chatId)",
            "dev.whyoleg.ktd.api.suspend.upgradeBasicGroupChatToSupergroupChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.upgradeBasicGroupChatToSupergroupChat(chatId: Long = 0L): TdChat =
        exec(TdUpgradeBasicGroupChatToSupergroupChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatChatList): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatChatList(chatId, chatList)",
            "dev.whyoleg.ktd.api.suspend.setChatChatList"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatChatList(chatId: Long = 0L, chatList: TdChatList? = null): TdOk =
        exec(TdSetChatChatList(chatId, chatList))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatTitle): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatTitle(chatId, title)",
            "dev.whyoleg.ktd.api.suspend.setChatTitle"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatTitle(chatId: Long = 0L, title: String? = null): TdOk =
        exec(TdSetChatTitle(chatId, title))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatPhoto): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatPhoto(chatId, photo)",
            "dev.whyoleg.ktd.api.suspend.setChatPhoto"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatPhoto(chatId: Long = 0L, photo: TdInputFile? = null): TdOk =
        exec(TdSetChatPhoto(chatId, photo))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatPermissions): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatPermissions(chatId, permissions)",
            "dev.whyoleg.ktd.api.suspend.setChatPermissions"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatPermissions(chatId: Long = 0L, permissions: TdChatPermissions? =
        null): TdOk = exec(TdSetChatPermissions(chatId, permissions))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatDraftMessage): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatDraftMessage(chatId, draftMessage)",
            "dev.whyoleg.ktd.api.suspend.setChatDraftMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatDraftMessage(chatId: Long = 0L, draftMessage: TdDraftMessage? =
        null): TdOk = exec(TdSetChatDraftMessage(chatId, draftMessage))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatNotificationSettings): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatNotificationSettings(chatId, notificationSettings)",
            "dev.whyoleg.ktd.api.suspend.setChatNotificationSettings"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatNotificationSettings(chatId: Long = 0L,
        notificationSettings: TdChatNotificationSettings? = null): TdOk =
        exec(TdSetChatNotificationSettings(chatId, notificationSettings))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdToggleChatIsPinned): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("toggleChatIsPinned(chatId, isPinned)",
            "dev.whyoleg.ktd.api.suspend.toggleChatIsPinned"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.toggleChatIsPinned(chatId: Long = 0L, isPinned: Boolean = false): TdOk =
        exec(TdToggleChatIsPinned(chatId, isPinned))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdToggleChatIsMarkedAsUnread): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("toggleChatIsMarkedAsUnread(chatId, isMarkedAsUnread)",
            "dev.whyoleg.ktd.api.suspend.toggleChatIsMarkedAsUnread"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.toggleChatIsMarkedAsUnread(chatId: Long = 0L, isMarkedAsUnread: Boolean =
        false): TdOk = exec(TdToggleChatIsMarkedAsUnread(chatId, isMarkedAsUnread))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdToggleChatDefaultDisableNotification): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("toggleChatDefaultDisableNotification(chatId, defaultDisableNotification)",
            "dev.whyoleg.ktd.api.suspend.toggleChatDefaultDisableNotification"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.toggleChatDefaultDisableNotification(chatId: Long = 0L,
        defaultDisableNotification: Boolean = false): TdOk =
        exec(TdToggleChatDefaultDisableNotification(chatId, defaultDisableNotification))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatClientData): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatClientData(chatId, clientData)",
            "dev.whyoleg.ktd.api.suspend.setChatClientData"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatClientData(chatId: Long = 0L, clientData: String? = null): TdOk =
        exec(TdSetChatClientData(chatId, clientData))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatDescription): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatDescription(chatId, description)",
            "dev.whyoleg.ktd.api.suspend.setChatDescription"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatDescription(chatId: Long = 0L, description: String? = null): TdOk
        = exec(TdSetChatDescription(chatId, description))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatDiscussionGroup): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatDiscussionGroup(chatId, discussionChatId)",
            "dev.whyoleg.ktd.api.suspend.setChatDiscussionGroup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatDiscussionGroup(chatId: Long = 0L, discussionChatId: Long = 0L):
        TdOk = exec(TdSetChatDiscussionGroup(chatId, discussionChatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatLocation): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatLocation(chatId, location)",
            "dev.whyoleg.ktd.api.suspend.setChatLocation"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatLocation(chatId: Long = 0L, location: TdChatLocation? = null):
        TdOk = exec(TdSetChatLocation(chatId, location))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatSlowModeDelay): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatSlowModeDelay(chatId, slowModeDelay)",
            "dev.whyoleg.ktd.api.suspend.setChatSlowModeDelay"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatSlowModeDelay(chatId: Long = 0L, slowModeDelay: Int = 0): TdOk =
        exec(TdSetChatSlowModeDelay(chatId, slowModeDelay))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdPinChatMessage): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("pinChatMessage(chatId, messageId, disableNotification)",
            "dev.whyoleg.ktd.api.suspend.pinChatMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.pinChatMessage(
    chatId: Long = 0L,
    messageId: Long = 0L,
    disableNotification: Boolean = false
): TdOk = exec(TdPinChatMessage(chatId, messageId, disableNotification))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdUnpinChatMessage): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("unpinChatMessage(chatId)",
            "dev.whyoleg.ktd.api.suspend.unpinChatMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.unpinChatMessage(chatId: Long = 0L): TdOk =
        exec(TdUnpinChatMessage(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdJoinChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("joinChat(chatId)", "dev.whyoleg.ktd.api.suspend.joinChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.joinChat(chatId: Long = 0L): TdOk = exec(TdJoinChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdLeaveChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("leaveChat(chatId)", "dev.whyoleg.ktd.api.suspend.leaveChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.leaveChat(chatId: Long = 0L): TdOk = exec(TdLeaveChat(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdAddChatMember): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addChatMember(chatId, userId, forwardLimit)",
            "dev.whyoleg.ktd.api.suspend.addChatMember"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addChatMember(
    chatId: Long = 0L,
    userId: Int = 0,
    forwardLimit: Int = 0
): TdOk = exec(TdAddChatMember(chatId, userId, forwardLimit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdAddChatMembers): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("addChatMembers(chatId, userIds)",
            "dev.whyoleg.ktd.api.suspend.addChatMembers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addChatMembers(chatId: Long = 0L, userIds: IntArray = intArrayOf()): TdOk
        = exec(TdAddChatMembers(chatId, userIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetChatMemberStatus): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setChatMemberStatus(chatId, userId, status)",
            "dev.whyoleg.ktd.api.suspend.setChatMemberStatus"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setChatMemberStatus(
    chatId: Long = 0L,
    userId: Int = 0,
    status: TdChatMemberStatus? = null
): TdOk = exec(TdSetChatMemberStatus(chatId, userId, status))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdTransferChatOwnership): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("transferChatOwnership(chatId, userId, password)",
            "dev.whyoleg.ktd.api.suspend.transferChatOwnership"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.transferChatOwnership(
    chatId: Long = 0L,
    userId: Int = 0,
    password: String? = null
): TdOk = exec(TdTransferChatOwnership(chatId, userId, password))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChatMember): TdChatMember = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatMember(chatId, userId)",
            "dev.whyoleg.ktd.api.suspend.getChatMember"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatMember(chatId: Long = 0L, userId: Int = 0): TdChatMember =
        exec(TdGetChatMember(chatId, userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSearchChatMembers): TdChatMembers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchChatMembers(chatId, query, limit, filter)",
            "dev.whyoleg.ktd.api.suspend.searchChatMembers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchChatMembers(
    chatId: Long = 0L,
    query: String? = null,
    limit: Int = 0,
    filter: TdChatMembersFilter? = null
): TdChatMembers = exec(TdSearchChatMembers(chatId, query, limit, filter))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChatAdministrators): TdChatAdministrators = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatAdministrators(chatId)",
            "dev.whyoleg.ktd.api.suspend.getChatAdministrators"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatAdministrators(chatId: Long = 0L): TdChatAdministrators =
        exec(TdGetChatAdministrators(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChatNotificationSettingsExceptions): TdChats = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatNotificationSettingsExceptions(scope, compareSound)",
            "dev.whyoleg.ktd.api.suspend.getChatNotificationSettingsExceptions"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatNotificationSettingsExceptions(scope: TdNotificationSettingsScope?
        = null, compareSound: Boolean = false): TdChats =
        exec(TdGetChatNotificationSettingsExceptions(scope, compareSound))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdSetPinnedChats): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setPinnedChats(chatList, chatIds)",
            "dev.whyoleg.ktd.api.suspend.setPinnedChats"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setPinnedChats(chatList: TdChatList? = null, chatIds: LongArray =
        longArrayOf()): TdOk = exec(TdSetPinnedChats(chatList, chatIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGenerateChatInviteLink): TdChatInviteLink = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("generateChatInviteLink(chatId)",
            "dev.whyoleg.ktd.api.suspend.generateChatInviteLink"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.generateChatInviteLink(chatId: Long = 0L): TdChatInviteLink =
        exec(TdGenerateChatInviteLink(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdCheckChatInviteLink): TdChatInviteLinkInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkChatInviteLink(inviteLink)",
            "dev.whyoleg.ktd.api.suspend.checkChatInviteLink"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkChatInviteLink(inviteLink: String? = null): TdChatInviteLinkInfo =
        exec(TdCheckChatInviteLink(inviteLink))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdJoinChatByInviteLink): TdChat = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("joinChatByInviteLink(inviteLink)",
            "dev.whyoleg.ktd.api.suspend.joinChatByInviteLink"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.joinChatByInviteLink(inviteLink: String? = null): TdChat =
        exec(TdJoinChatByInviteLink(inviteLink))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetSupergroupMembers): TdChatMembers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSupergroupMembers(supergroupId, filter, offset, limit)",
            "dev.whyoleg.ktd.api.suspend.getSupergroupMembers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSupergroupMembers(
    supergroupId: Int = 0,
    filter: TdSupergroupMembersFilter? = null,
    offset: Int = 0,
    limit: Int = 0
): TdChatMembers = exec(TdGetSupergroupMembers(supergroupId, filter, offset, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChatEventLog): TdChatEvents = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("getChatEventLog(chatId, query, fromEventId, limit, filters, userIds)",
            "dev.whyoleg.ktd.api.suspend.getChatEventLog"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatEventLog(
    chatId: Long = 0L,
    query: String? = null,
    fromEventId: Long = 0L,
    limit: Int = 0,
    filters: TdChatEventLogFilters? = null,
    userIds: IntArray = intArrayOf()
): TdChatEvents = exec(TdGetChatEventLog(chatId, query, fromEventId, limit, filters, userIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdRemoveChatActionBar): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeChatActionBar(chatId)",
            "dev.whyoleg.ktd.api.suspend.removeChatActionBar"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeChatActionBar(chatId: Long = 0L): TdOk =
        exec(TdRemoveChatActionBar(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdReportChat): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("reportChat(chatId, reason, messageIds)",
            "dev.whyoleg.ktd.api.suspend.reportChat"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.reportChat(
    chatId: Long = 0L,
    reason: TdChatReportReason? = null,
    messageIds: LongArray = longArrayOf()
): TdOk = exec(TdReportChat(chatId, reason, messageIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.chat(f: TdGetChatStatisticsUrl): TdHttpUrl = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatStatisticsUrl(chatId, parameters, isDark)",
            "dev.whyoleg.ktd.api.suspend.getChatStatisticsUrl"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatStatisticsUrl(
    chatId: Long = 0L,
    parameters: String? = null,
    isDark: Boolean = false
): TdHttpUrl = exec(TdGetChatStatisticsUrl(chatId, parameters, isDark))
