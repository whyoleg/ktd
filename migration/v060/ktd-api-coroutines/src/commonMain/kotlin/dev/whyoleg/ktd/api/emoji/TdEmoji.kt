@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.emoji

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.emoji(f: TdGetStickerEmojis): TdEmojis = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getStickerEmojis(sticker)",
            "dev.whyoleg.ktd.api.suspend.getStickerEmojis"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getStickerEmojis(sticker: TdInputFile? = null): TdEmojis =
        exec(TdGetStickerEmojis(sticker))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.emoji(f: TdSearchEmojis): TdEmojis = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchEmojis(text, exactMatch, inputLanguageCode)",
            "dev.whyoleg.ktd.api.suspend.searchEmojis"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchEmojis(
    text: String? = null,
    exactMatch: Boolean = false,
    inputLanguageCode: String? = null
): TdEmojis = exec(TdSearchEmojis(text, exactMatch, inputLanguageCode))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.emoji(f: TdGetEmojiSuggestionsUrl): TdHttpUrl = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getEmojiSuggestionsUrl(languageCode)",
            "dev.whyoleg.ktd.api.suspend.getEmojiSuggestionsUrl"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getEmojiSuggestionsUrl(languageCode: String? = null): TdHttpUrl =
        exec(TdGetEmojiSuggestionsUrl(languageCode))
