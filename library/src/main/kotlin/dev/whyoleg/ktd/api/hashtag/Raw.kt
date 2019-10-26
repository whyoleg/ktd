@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.hashtag

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for recently used hashtags by their prefix
 */
suspend fun TelegramClient.hashtag(
    f: SearchHashtags
): Hashtags = exec(f) as Hashtags

/**
 * Removes a hashtag from the list of recently used hashtags
 */
suspend fun TelegramClient.hashtag(
    f: RemoveRecentHashtag
): Ok = exec(f) as Ok
