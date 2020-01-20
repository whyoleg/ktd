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
 * Searches for a background by its name
 *
 * @name - The name of the background
 */
suspend fun TelegramClient.searchBackground(
    name: String? = null
): Background = background(
    SearchBackground(
        name
    )
)

/**
 * Searches for a background by its name
 */
suspend fun TelegramClient.background(
    f: SearchBackground
): Background = exec(f) as Background
