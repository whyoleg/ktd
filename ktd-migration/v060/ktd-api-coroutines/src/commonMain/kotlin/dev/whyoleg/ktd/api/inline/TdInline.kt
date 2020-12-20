@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.inline

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdEditInlineMessageText): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("editInlineMessageText(inlineMessageId, replyMarkup, inputMessageContent)",
            "dev.whyoleg.ktd.api.suspend.editInlineMessageText"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editInlineMessageText(
    inlineMessageId: String? = null,
    replyMarkup: TdReplyMarkup? = null,
    inputMessageContent: TdInputMessageContent? = null
): TdOk = exec(TdEditInlineMessageText(inlineMessageId, replyMarkup, inputMessageContent))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdEditInlineMessageLiveLocation): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("editInlineMessageLiveLocation(inlineMessageId, replyMarkup, location)",
            "dev.whyoleg.ktd.api.suspend.editInlineMessageLiveLocation"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editInlineMessageLiveLocation(
    inlineMessageId: String? = null,
    replyMarkup: TdReplyMarkup? = null,
    location: TdLocation? = null
): TdOk = exec(TdEditInlineMessageLiveLocation(inlineMessageId, replyMarkup, location))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdEditInlineMessageMedia): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("editInlineMessageMedia(inlineMessageId, inputMessageContent, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.editInlineMessageMedia"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editInlineMessageMedia(
    inlineMessageId: String? = null,
    inputMessageContent: TdInputMessageContent? = null,
    replyMarkup: TdReplyMarkup? = null
): TdOk = exec(TdEditInlineMessageMedia(inlineMessageId, inputMessageContent, replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdEditInlineMessageCaption): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editInlineMessageCaption(inlineMessageId, replyMarkup, caption)",
            "dev.whyoleg.ktd.api.suspend.editInlineMessageCaption"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editInlineMessageCaption(
    inlineMessageId: String? = null,
    replyMarkup: TdReplyMarkup? = null,
    caption: TdFormattedText? = null
): TdOk = exec(TdEditInlineMessageCaption(inlineMessageId, replyMarkup, caption))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdEditInlineMessageReplyMarkup): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("editInlineMessageReplyMarkup(inlineMessageId, replyMarkup)",
            "dev.whyoleg.ktd.api.suspend.editInlineMessageReplyMarkup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.editInlineMessageReplyMarkup(inlineMessageId: String? = null,
        replyMarkup: TdReplyMarkup? = null): TdOk =
        exec(TdEditInlineMessageReplyMarkup(inlineMessageId, replyMarkup))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdGetInlineQueryResults): TdInlineQueryResults = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("getInlineQueryResults(botUserId, chatId, userLocation, query, offset)",
            "dev.whyoleg.ktd.api.suspend.getInlineQueryResults"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getInlineQueryResults(
    botUserId: Int = 0,
    chatId: Long = 0L,
    userLocation: TdLocation? = null,
    query: String? = null,
    offset: String? = null
): TdInlineQueryResults = exec(TdGetInlineQueryResults(botUserId, chatId, userLocation, query,
        offset))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdAnswerInlineQuery): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("answerInlineQuery(inlineQueryId, isPersonal, results, cacheTime, nextOffset, switchPmText, switchPmParameter)",
            "dev.whyoleg.ktd.api.suspend.answerInlineQuery"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.answerInlineQuery(
    inlineQueryId: Long = 0L,
    isPersonal: Boolean = false,
    results: List<TdInputInlineQueryResult> = emptyList(),
    cacheTime: Int = 0,
    nextOffset: String? = null,
    switchPmText: String? = null,
    switchPmParameter: String? = null
): TdOk = exec(TdAnswerInlineQuery(inlineQueryId, isPersonal, results, cacheTime, nextOffset,
        switchPmText, switchPmParameter))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.inline(f: TdSetInlineGameScore): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("setInlineGameScore(inlineMessageId, editMessage, userId, score, force)",
            "dev.whyoleg.ktd.api.suspend.setInlineGameScore"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setInlineGameScore(
    inlineMessageId: String? = null,
    editMessage: Boolean = false,
    userId: Int = 0,
    score: Int = 0,
    force: Boolean = false
): TdOk = exec(TdSetInlineGameScore(inlineMessageId, editMessage, userId, score, force))
