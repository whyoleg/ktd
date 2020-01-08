@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.sync

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
 * This is an offline method
 * Can be called before authorization
 *
 * @text - The text in which to look for entites
 */
suspend fun TelegramClient.getTextEntities(
    text: String? = null
): TextEntities = sync(
    GetTextEntities(
        text
    )
)

/**
 * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: GetTextEntities
): TextEntities = exec(f) as TextEntities
