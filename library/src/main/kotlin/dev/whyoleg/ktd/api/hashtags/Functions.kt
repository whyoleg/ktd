@file:Suppress("unused")

package dev.whyoleg.ktd.api.hashtags

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Searches for recently used hashtags by their prefix
 */
suspend fun TelegramClient.hashtags(
    f: SearchHashtags
): Hashtags = execRaw(f) as Hashtags
