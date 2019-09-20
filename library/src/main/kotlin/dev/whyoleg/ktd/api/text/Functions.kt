@file:Suppress("unused")

package dev.whyoleg.ktd.api.text

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetTextEntities
): TextEntities = execRaw(f) as TextEntities

/**
 * Returns the MIME type of a file, guessed by its extension. Returns an empty string on failure. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetFileMimeType
): Text = execRaw(f) as Text

/**
 * Returns the extension of a file, guessed by its MIME type. Returns an empty string on failure. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetFileExtension
): Text = execRaw(f) as Text

/**
 * Removes potentially dangerous characters from the name of a file. The encoding of the file name is supposed to be UTF-8. Returns an empty string on failure. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: CleanFileName
): Text = execRaw(f) as Text

/**
 * Converts a JsonValue object to corresponding JSON-serialized string. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.text(
    f: GetJsonString
): Text = execRaw(f) as Text

/**
 * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details. Returns a 404 error if unknown
 */
suspend fun TelegramClient.text(
    f: GetPreferredCountryLanguage
): Text = execRaw(f) as Text

/**
 * Uses current user IP to found their country. Returns two-letter ISO 3166-1 alpha-2 country code. Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetCountryCode
): Text = execRaw(f) as Text

/**
 * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
 */
suspend fun TelegramClient.text(
    f: GetInviteText
): Text = execRaw(f) as Text

/**
 * Returns an HTTPS link, which can be used to add a proxy. Available only for SOCKS5 and MTProto proxies. Can be called before authorization
 */
suspend fun TelegramClient.text(
    f: GetProxyLink
): Text = execRaw(f) as Text
