@file:Suppress("unused")

package dev.whyoleg.ktd.api.formatted

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text. This is an offline method. Can be called before authorization. Can be called synchronously
 *
 * @text - The text which should be parsed
 * @parseMode - Text parse mode
 */
suspend fun TelegramClient.parseTextEntities(
    text: String,
    parseMode: TextParseMode
): FormattedText = formatted(
    ParseTextEntities(
        text,
        parseMode
    )
)
