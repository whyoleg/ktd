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
 * Returns the extension of a file, guessed by its MIME type
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @mimeType - The MIME type of the file
 */
suspend fun TelegramClient.getFileExtension(
    mimeType: String? = null
): Text = sync(
    GetFileExtension(
        mimeType
    )
)

/**
 * Returns the extension of a file, guessed by its MIME type
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.sync(
    f: GetFileExtension
): Text = exec(f) as Text
