@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.background

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Constructs a persistent HTTP URL for a background
 *
 * @name - Background name
 * @type - Background type
 */
suspend fun TelegramClient.getBackgroundUrl(
    name: String? = null,
    type: BackgroundType? = null
): HttpUrl = background(
    GetBackgroundUrl(
        name,
        type
    )
)

/**
 * Constructs a persistent HTTP URL for a background
 */
suspend fun TelegramClient.background(
    f: GetBackgroundUrl
): HttpUrl = exec(f) as HttpUrl
