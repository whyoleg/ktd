package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Parses Bold, Italic, Underline, Strikethrough, Code, Pre, PreCode, TextUrl and MentionName entities contained in the text
 * This is an offline method
 * Can be called before authorization
 *
 * @property text The text which should be parsed
 * @property parseMode Text parse mode
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.parseTextEntities(
    text: String? = null,
    parseMode: TdTextParseMode? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdFormattedText = exec(TdParseTextEntities(text, parseMode, extra))
