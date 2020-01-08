@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.text

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 *
 * @fileName - The name of the file or path to the file
 */
suspend fun TelegramClient.getFileMimeType(
    fileName: String? = null
): Text = text(
    GetFileMimeType(
        fileName
    )
)

/**
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetFileMimeType
): Text = exec(f) as Text
