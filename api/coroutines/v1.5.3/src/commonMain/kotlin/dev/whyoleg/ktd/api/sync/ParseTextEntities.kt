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
 * Parses Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode, TextUrl and MentionName entities contained in the text
 * This is an offline method
 * Can be called before authorization
 *
 * @text - The text which should be parsed
 * @parseMode - Text parse mode
 */
fun TelegramClient.Companion.parseTextEntities(
    text: String? = null,
    parseMode: TextParseMode? = null
): FormattedText = execute(
    ParseTextEntities(
        text,
        parseMode
    )
)

/**
 * Parses Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode, TextUrl and MentionName entities contained in the text
 * This is an offline method
 * Can be called before authorization
 */
fun TelegramClient.Companion.execute(
    f: ParseTextEntities
): FormattedText = exec(f) as FormattedText
