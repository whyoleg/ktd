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
 * Returns all entities (mentions, hashtags, cashtags, bot commands, URLs, and email addresses) contained in the text
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetTextEntities
): TextEntities = exec(f) as TextEntities

/**
 * Parses Bold, Italic, Code, Pre, PreCode and TextUrl entities contained in the text
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: ParseTextEntities
): FormattedText = exec(f) as FormattedText

/**
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetFileMimeType
): Text = exec(f) as Text

/**
 * Returns the extension of a file, guessed by its MIME type
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
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
fun TelegramClient.Companion.execute(
    f: CleanFileName
): Text = exec(f) as Text

/**
 * Returns a string stored in the local database from the specified localization target and language pack by its key
 * Returns a 404 error if the string is not found
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetLanguagePackString
): LanguagePackStringValue = exec(f) as LanguagePackStringValue

/**
 * Converts a JSON-serialized string to corresponding JsonValue object
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetJsonValue
): JsonValue = exec(f) as JsonValue

/**
 * Converts a JsonValue object to corresponding JSON-serialized string
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetJsonString
): Text = exec(f) as Text

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetPushReceiverId
): PushReceiverId = exec(f) as PushReceiverId

/**
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: SetLogStream
): Ok = exec(f) as Ok

/**
 * Returns information about currently used log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetLogStream
): LogStream = exec(f) as LogStream

/**
 * Sets the verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: SetLogVerbosityLevel
): Ok = exec(f) as Ok

/**
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetLogVerbosityLevel
): LogVerbosityLevel = exec(f) as LogVerbosityLevel

/**
 * Returns list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetLogTags
): LogTags = exec(f) as LogTags

/**
 * Sets the verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: SetLogTagVerbosityLevel
): Ok = exec(f) as Ok

/**
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: GetLogTagVerbosityLevel
): LogVerbosityLevel = exec(f) as LogVerbosityLevel

/**
 * Adds a message to TDLib internal log
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.execute(
    f: AddLogMessage
): Ok = exec(f) as Ok
