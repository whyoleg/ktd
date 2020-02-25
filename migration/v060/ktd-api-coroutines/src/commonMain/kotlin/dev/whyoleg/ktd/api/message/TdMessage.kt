@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.message

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getMessage(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.getMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getMessage(chatId: Long = 0L, messageId: Long = 0L): TdMessage =
        exec(TdGetMessage(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetMessageLocally): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getMessageLocally(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.getMessageLocally"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getMessageLocally(chatId: Long = 0L, messageId: Long = 0L): TdMessage =
        exec(TdGetMessageLocally(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetRepliedMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getRepliedMessage(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.getRepliedMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getRepliedMessage(chatId: Long = 0L, messageId: Long = 0L): TdMessage =
        exec(TdGetRepliedMessage(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetChatPinnedMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatPinnedMessage(chatId)",
            "dev.whyoleg.ktd.api.suspend.getChatPinnedMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatPinnedMessage(chatId: Long = 0L): TdMessage =
        exec(TdGetChatPinnedMessage(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getMessages(chatId, messageIds)",
            "dev.whyoleg.ktd.api.suspend.getMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getMessages(chatId: Long = 0L, messageIds: LongArray = longArrayOf()):
        TdMessages = exec(TdGetMessages(chatId, messageIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetChatHistory): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatHistory(chatId, fromMessageId, offset, limit, onlyLocal)",
            "dev.whyoleg.ktd.api.suspend.getChatHistory"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatHistory(
    chatId: Long = 0L,
    fromMessageId: Long = 0L,
    offset: Int = 0,
    limit: Int = 0,
    onlyLocal: Boolean = false
): TdMessages = exec(TdGetChatHistory(chatId, fromMessageId, offset, limit, onlyLocal))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSearchChatMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("searchChatMessages(chatId, query, senderUserId, fromMessageId, offset, limit, filter)",
            "dev.whyoleg.ktd.api.suspend.searchChatMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchChatMessages(
    chatId: Long = 0L,
    query: String? = null,
    senderUserId: Int = 0,
    fromMessageId: Long = 0L,
    offset: Int = 0,
    limit: Int = 0,
    filter: TdSearchMessagesFilter? = null
): TdMessages = exec(TdSearchChatMessages(chatId, query, senderUserId, fromMessageId, offset, limit,
        filter))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSearchMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("searchMessages(chatList, query, offsetDate, offsetChatId, offsetMessageId, limit)",
            "dev.whyoleg.ktd.api.suspend.searchMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchMessages(
    chatList: TdChatList? = null,
    query: String? = null,
    offsetDate: Int = 0,
    offsetChatId: Long = 0L,
    offsetMessageId: Long = 0L,
    limit: Int = 0
): TdMessages = exec(TdSearchMessages(chatList, query, offsetDate, offsetChatId, offsetMessageId,
        limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSearchSecretMessages): TdFoundMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchSecretMessages(chatId, query, fromSearchId, limit, filter)",
            "dev.whyoleg.ktd.api.suspend.searchSecretMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchSecretMessages(
    chatId: Long = 0L,
    query: String? = null,
    fromSearchId: Long = 0L,
    limit: Int = 0,
    filter: TdSearchMessagesFilter? = null
): TdFoundMessages = exec(TdSearchSecretMessages(chatId, query, fromSearchId, limit, filter))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSearchCallMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchCallMessages(fromMessageId, limit, onlyMissed)",
            "dev.whyoleg.ktd.api.suspend.searchCallMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchCallMessages(
    fromMessageId: Long = 0L,
    limit: Int = 0,
    onlyMissed: Boolean = false
): TdMessages = exec(TdSearchCallMessages(fromMessageId, limit, onlyMissed))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSearchChatRecentLocationMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchChatRecentLocationMessages(chatId, limit)",
            "dev.whyoleg.ktd.api.suspend.searchChatRecentLocationMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchChatRecentLocationMessages(chatId: Long = 0L, limit: Int = 0):
        TdMessages = exec(TdSearchChatRecentLocationMessages(chatId, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetActiveLiveLocationMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getActiveLiveLocationMessages()",
            "dev.whyoleg.ktd.api.suspend.getActiveLiveLocationMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getActiveLiveLocationMessages(): TdMessages =
        exec(TdGetActiveLiveLocationMessages())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetChatMessageByDate): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatMessageByDate(chatId, date)",
            "dev.whyoleg.ktd.api.suspend.getChatMessageByDate"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatMessageByDate(chatId: Long = 0L, date: Int = 0): TdMessage =
        exec(TdGetChatMessageByDate(chatId, date))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetChatScheduledMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getChatScheduledMessages(chatId)",
            "dev.whyoleg.ktd.api.suspend.getChatScheduledMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getChatScheduledMessages(chatId: Long = 0L): TdMessages =
        exec(TdGetChatScheduledMessages(chatId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetPublicMessageLink): TdPublicMessageLink = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPublicMessageLink(chatId, messageId, forAlbum)",
            "dev.whyoleg.ktd.api.suspend.getPublicMessageLink"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPublicMessageLink(
    chatId: Long = 0L,
    messageId: Long = 0L,
    forAlbum: Boolean = false
): TdPublicMessageLink = exec(TdGetPublicMessageLink(chatId, messageId, forAlbum))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetMessageLink): TdHttpUrl = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getMessageLink(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.getMessageLink"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getMessageLink(chatId: Long = 0L, messageId: Long = 0L): TdHttpUrl =
        exec(TdGetMessageLink(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdGetMessageLinkInfo): TdMessageLinkInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getMessageLinkInfo(url)",
            "dev.whyoleg.ktd.api.suspend.getMessageLinkInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getMessageLinkInfo(url: String? = null): TdMessageLinkInfo =
        exec(TdGetMessageLinkInfo(url))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSendMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("sendMessage(chatId, replyToMessageId, options, inputMessageContent, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.sendMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: TdSendMessageOptions? = null,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null
): TdMessage = exec(TdSendMessage(chatId, replyToMessageId, options, inputMessageContent,
        replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSendMessageAlbum): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("sendMessageAlbum(chatId, replyToMessageId, options, inputMessageContents)",
            "dev.whyoleg.ktd.api.suspend.sendMessageAlbum"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendMessageAlbum(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: TdSendMessageOptions? = null,
    inputMessageContents: List<TdInputMessageContent> = emptyList()
): TdMessages = exec(TdSendMessageAlbum(chatId, replyToMessageId, options, inputMessageContents))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSendBotStartMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendBotStartMessage(botUserId, chatId, parameter)",
            "dev.whyoleg.ktd.api.suspend.sendBotStartMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendBotStartMessage(
    botUserId: Int = 0,
    chatId: Long = 0L,
    parameter: String? = null
): TdMessage = exec(TdSendBotStartMessage(botUserId, chatId, parameter))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSendInlineQueryResultMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("sendInlineQueryResultMessage(chatId, replyToMessageId, options, queryId, resultId, hideViaBot)",
            "dev.whyoleg.ktd.api.suspend.sendInlineQueryResultMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendInlineQueryResultMessage(
    chatId: Long = 0L,
    replyToMessageId: Long = 0L,
    options: TdSendMessageOptions? = null,
    queryId: Long = 0L,
    resultId: String? = null,
    hideViaBot: Boolean = false
): TdMessage = exec(TdSendInlineQueryResultMessage(chatId, replyToMessageId, options, queryId,
        resultId, hideViaBot))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdForwardMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("forwardMessages(chatId, fromChatId, messageIds, options, asAlbum, sendCopy, removeCaption)",
            "dev.whyoleg.ktd.api.suspend.forwardMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.forwardMessages(
    chatId: Long = 0L,
    fromChatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    options: TdSendMessageOptions? = null,
    asAlbum: Boolean = false,
    sendCopy: Boolean = false,
    removeCaption: Boolean = false
): TdMessages = exec(TdForwardMessages(chatId, fromChatId, messageIds, options, asAlbum, sendCopy,
        removeCaption))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdResendMessages): TdMessages = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resendMessages(chatId, messageIds)",
            "dev.whyoleg.ktd.api.suspend.resendMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resendMessages(chatId: Long = 0L, messageIds: LongArray = longArrayOf()):
        TdMessages = exec(TdResendMessages(chatId, messageIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSendChatSetTtlMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendChatSetTtlMessage(chatId, ttl)",
            "dev.whyoleg.ktd.api.suspend.sendChatSetTtlMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendChatSetTtlMessage(chatId: Long = 0L, ttl: Int = 0): TdMessage =
        exec(TdSendChatSetTtlMessage(chatId, ttl))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdAddLocalMessage): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("addLocalMessage(chatId, senderUserId, replyToMessageId, disableNotification, inputMessageContent)",
            "dev.whyoleg.ktd.api.suspend.addLocalMessage"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.addLocalMessage(
    chatId: Long = 0L,
    senderUserId: Int = 0,
    replyToMessageId: Long = 0L,
    disableNotification: Boolean = false,
    inputMessageContent: TdInputMessageContent? = null
): TdMessage = exec(TdAddLocalMessage(chatId, senderUserId, replyToMessageId, disableNotification,
        inputMessageContent))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdDeleteMessages): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteMessages(chatId, messageIds, revoke)",
            "dev.whyoleg.ktd.api.suspend.deleteMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    revoke: Boolean = false
): TdOk = exec(TdDeleteMessages(chatId, messageIds, revoke))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdEditMessageText): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("editMessageText(chatId, messageId, inputMessageContent, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.editMessageText"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editMessageText(
    chatId: Long = 0L,
    messageId: Long = 0L,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null
): TdMessage = exec(TdEditMessageText(chatId, messageId, inputMessageContent, replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdEditMessageLiveLocation): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editMessageLiveLocation(chatId, messageId, location, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.editMessageLiveLocation"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editMessageLiveLocation(
    chatId: Long = 0L,
    messageId: Long = 0L,
    location: TdLocation? = null,
    replyMarkup: TdReplyMarkup? = null
): TdMessage = exec(TdEditMessageLiveLocation(chatId, messageId, location, replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdEditMessageMedia): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("editMessageMedia(chatId, messageId, inputMessageContent, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.editMessageMedia"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editMessageMedia(
    chatId: Long = 0L,
    messageId: Long = 0L,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null
): TdMessage = exec(TdEditMessageMedia(chatId, messageId, inputMessageContent, replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdEditMessageCaption): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editMessageCaption(chatId, messageId, caption, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.editMessageCaption"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editMessageCaption(
    chatId: Long = 0L,
    messageId: Long = 0L,
    caption: TdFormattedText? = null,
    replyMarkup: TdReplyMarkup? = null
): TdMessage = exec(TdEditMessageCaption(chatId, messageId, caption, replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdEditMessageReplyMarkup): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editMessageReplyMarkup(chatId, messageId, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.editMessageReplyMarkup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editMessageReplyMarkup(
    chatId: Long = 0L,
    messageId: Long = 0L,
    replyMarkup: TdReplyMarkup? = null
): TdMessage = exec(TdEditMessageReplyMarkup(chatId, messageId, replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdEditMessageSchedulingState): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editMessageSchedulingState(chatId, messageId, schedulingState)",
            "dev.whyoleg.ktd.api.suspend.editMessageSchedulingState"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editMessageSchedulingState(
    chatId: Long = 0L,
    messageId: Long = 0L,
    schedulingState: TdMessageSchedulingState? = null
): TdOk = exec(TdEditMessageSchedulingState(chatId, messageId, schedulingState))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdSetGameScore): TdMessage = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setGameScore(chatId, messageId, editMessage, userId, score, force)",
            "dev.whyoleg.ktd.api.suspend.setGameScore"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setGameScore(
    chatId: Long = 0L,
    messageId: Long = 0L,
    editMessage: Boolean = false,
    userId: Int = 0,
    score: Int = 0,
    force: Boolean = false
): TdMessage = exec(TdSetGameScore(chatId, messageId, editMessage, userId, score, force))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdViewMessages): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("viewMessages(chatId, messageIds, forceRead)",
            "dev.whyoleg.ktd.api.suspend.viewMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.viewMessages(
    chatId: Long = 0L,
    messageIds: LongArray = longArrayOf(),
    forceRead: Boolean = false
): TdOk = exec(TdViewMessages(chatId, messageIds, forceRead))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdOpenMessageContent): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("openMessageContent(chatId, messageId)",
            "dev.whyoleg.ktd.api.suspend.openMessageContent"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.openMessageContent(chatId: Long = 0L, messageId: Long = 0L): TdOk =
        exec(TdOpenMessageContent(chatId, messageId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.message(f: TdClearAllDraftMessages): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("clearAllDraftMessages(excludeSecretChats)",
            "dev.whyoleg.ktd.api.suspend.clearAllDraftMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.clearAllDraftMessages(excludeSecretChats: Boolean = false): TdOk =
        exec(TdClearAllDraftMessages(excludeSecretChats))
