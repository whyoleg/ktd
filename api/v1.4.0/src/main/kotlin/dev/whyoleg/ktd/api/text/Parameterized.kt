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
 *
 * @text - The text in which to look for entites
 */
suspend fun TelegramClient.getTextEntities(
    text: String
): TextEntities = text(
    GetTextEntities(
        text
    )
)

/**
 * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @text - The text which should be parsed
 * @parseMode - Text parse mode
 */
suspend fun TelegramClient.parseTextEntities(
    text: String,
    parseMode: TextParseMode
): FormattedText = text(
    ParseTextEntities(
        text,
        parseMode
    )
)

/**
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @fileName - The name of the file or path to the file
 */
suspend fun TelegramClient.getFileMimeType(
    fileName: String
): Text = text(
    GetFileMimeType(
        fileName
    )
)

/**
 * Returns the extension of a file, guessed by its MIME type
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @mimeType - The MIME type of the file
 */
suspend fun TelegramClient.getFileExtension(
    mimeType: String
): Text = text(
    GetFileExtension(
        mimeType
    )
)

/**
 * Removes potentially dangerous characters from the name of a file
 * The encoding of the file name is supposed to be UTF-8
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @fileName - File name or path to the file
 */
suspend fun TelegramClient.cleanFileName(
    fileName: String
): Text = text(
    CleanFileName(
        fileName
    )
)

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @jsonValue - The JsonValue object
 */
suspend fun TelegramClient.getJsonString(
    jsonValue: JsonValue
): Text = text(
    GetJsonString(
        jsonValue
    )
)

/**
 * Returns an IETF language tag of the language preferred in the country, which should be used to fill native fields in Telegram Passport personal details
 * Returns a 404 error if unknown
 *
 * @countryCode - A two-letter ISO 3166-1 alpha-2 country code
 */
suspend fun TelegramClient.getPreferredCountryLanguage(
    countryCode: String
): Text = text(
    GetPreferredCountryLanguage(
        countryCode
    )
)

/**
 * Uses current user IP to found his country
 * Returns two-letter ISO 3166-1 alpha-2 country code
 * Can be called before authorization
 */
suspend fun TelegramClient.getCountryCode(): Text = text(
    GetCountryCode()
)

/**
 * Returns the default text for invitation messages to be used as a placeholder when the current user invites friends to Telegram
 */
suspend fun TelegramClient.getInviteText(): Text = text(
    GetInviteText()
)

/**
 * Returns an HTTPS link, which can be used to add a proxy
 * Available only for SOCKS5 and MTProto proxies
 * Can be called before authorization
 *
 * @proxyId - Proxy identifier
 */
suspend fun TelegramClient.getProxyLink(
    proxyId: Int = 0
): Text = text(
    GetProxyLink(
        proxyId
    )
)
