@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.hashtag

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.hashtag(f: TdSearchHashtags): TdHashtags = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchHashtags(prefix, limit)",
            "dev.whyoleg.ktd.api.suspend.searchHashtags"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchHashtags(prefix: String? = null, limit: Int = 0): TdHashtags =
        exec(TdSearchHashtags(prefix, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.hashtag(f: TdRemoveRecentHashtag): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeRecentHashtag(hashtag)",
            "dev.whyoleg.ktd.api.suspend.removeRecentHashtag"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeRecentHashtag(hashtag: String? = null): TdOk =
        exec(TdRemoveRecentHashtag(hashtag))
