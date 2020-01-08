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
 * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
 * This is an offline method
 * Can be called before authorization
 *
 * @text - The text which should be parsed
 * @parseMode - Text parse mode
 */
suspend fun TelegramClient.parseTextEntities(
    text: String? = null,
    parseMode: TextParseMode? = null
): FormattedText = text(
    ParseTextEntities(
        text,
        parseMode
    )
)

/**
 * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
 * This is an offline method
 * Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: ParseTextEntities
): FormattedText = exec(f) as FormattedText
