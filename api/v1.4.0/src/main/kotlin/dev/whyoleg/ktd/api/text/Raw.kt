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
 * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetTextEntities
): TextEntities = exec(f) as TextEntities

/**
 * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: ParseTextEntities
): FormattedText = exec(f) as FormattedText

/**
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetFileMimeType
): Text = exec(f) as Text

/**
 * Returns the extension of a file, guessed by its MIME type
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetFileExtension
): Text = exec(f) as Text

/**
 * Removes potentially dangerous characters from the name of a file
 * The encoding of the file name is supposed to be UTF-8
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: CleanFileName
): Text = exec(f) as Text

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetJsonString
): Text = exec(f) as Text

/**
 * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
 * Returns a 404 error if unknown
 */
suspend fun TelegramClient.text(
    f: GetPreferredCountryLanguage
): Text = exec(f) as Text

/**
 * Uses current user IP to found his country
 * Returns two-letter ISO 3166-1 alpha-2 country code
 * Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetCountryCode
): Text = exec(f) as Text

/**
 * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
 */
suspend fun TelegramClient.text(
    f: GetInviteText
): Text = exec(f) as Text

/**
 * Returns an HTTPS link, which can be used to add a proxy
 * Available only for SOCKS5 and MTProto proxies
 * Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetProxyLink
): Text = exec(f) as Text
