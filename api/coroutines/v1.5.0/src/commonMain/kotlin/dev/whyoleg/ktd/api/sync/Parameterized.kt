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
 *
 * @text - The text in which to look for entites
 */
fun TelegramClient.Companion.getTextEntities(
    text: String? = null
): TextEntities = execute(
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
 * Returns the MIME type of a file, guessed by its extension
 * Returns an empty string on failure
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @fileName - The name of the file or path to the file
 */
fun TelegramClient.Companion.getFileMimeType(
    fileName: String? = null
): Text = execute(
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
fun TelegramClient.Companion.getFileExtension(
    mimeType: String? = null
): Text = execute(
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
fun TelegramClient.Companion.cleanFileName(
    fileName: String? = null
): Text = execute(
    CleanFileName(
        fileName
    )
)

/**
 * Returns a string stored in the local database from the specified localization target and language pack by its key
 * Returns a 404 error if the string is not found
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @languagePackDatabasePath - Path to the language pack database in which strings are stored
 * @localizationTarget - Localization target to which the language pack belongs
 * @languagePackId - Language pack identifier
 * @key - Language pack key of the string to be returned
 */
fun TelegramClient.Companion.getLanguagePackString(
    languagePackDatabasePath: String? = null,
    localizationTarget: String? = null,
    languagePackId: String? = null,
    key: String? = null
): LanguagePackStringValue = execute(
    GetLanguagePackString(
        languagePackDatabasePath,
        localizationTarget,
        languagePackId,
        key
    )
)

/**
 * Converts a JSON-serialized string to corresponding JsonValue object
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @json - The JSON-serialized string
 */
fun TelegramClient.Companion.getJsonValue(
    json: String? = null
): JsonValue = execute(
    GetJsonValue(
        json
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
fun TelegramClient.Companion.getJsonString(
    jsonValue: JsonValue? = null
): Text = execute(
    GetJsonString(
        jsonValue
    )
)

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @payload - JSON-encoded push notification payload
 */
fun TelegramClient.Companion.getPushReceiverId(
    payload: String? = null
): PushReceiverId = execute(
    GetPushReceiverId(
        payload
    )
)

/**
 * Sets new log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @logStream - New log stream
 */
fun TelegramClient.Companion.setLogStream(
    logStream: LogStream? = null
): Ok = execute(
    SetLogStream(
        logStream
    )
)

/**
 * Returns information about currently used log stream for internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.getLogStream(): LogStream = execute(
    GetLogStream()
)

/**
 * Sets the verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @newVerbosityLevel - New value of the verbosity level for logging
 *                      Value 0 corresponds to fatal errors, value 1 corresponds to errors, value 2 corresponds to warnings and debug warnings, value 3 corresponds to informational, value 4 corresponds to debug, value 5 corresponds to verbose debug, value greater than 5 and up to 1023 can be used to enable even more logging
 */
fun TelegramClient.Companion.setLogVerbosityLevel(
    newVerbosityLevel: Int = 0
): Ok = execute(
    SetLogVerbosityLevel(
        newVerbosityLevel
    )
)

/**
 * Returns current verbosity level of the internal logging of TDLib
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.getLogVerbosityLevel(): LogVerbosityLevel = execute(
    GetLogVerbosityLevel()
)

/**
 * Returns list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
fun TelegramClient.Companion.getLogTags(): LogTags = execute(
    GetLogTags()
)

/**
 * Sets the verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @tag - Logging tag to change verbosity level
 * @newVerbosityLevel - New verbosity level
 */
fun TelegramClient.Companion.setLogTagVerbosityLevel(
    tag: String? = null,
    newVerbosityLevel: Int = 0
): Ok = execute(
    SetLogTagVerbosityLevel(
        tag,
        newVerbosityLevel
    )
)

/**
 * Returns current verbosity level for a specified TDLib internal log tag
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @tag - Logging tag to change verbosity level
 */
fun TelegramClient.Companion.getLogTagVerbosityLevel(
    tag: String? = null
): LogVerbosityLevel = execute(
    GetLogTagVerbosityLevel(
        tag
    )
)

/**
 * Adds a message to TDLib internal log
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @verbosityLevel - Minimum verbosity level needed for the message to be logged, 0-1023
 * @text - Text of a message to log
 */
fun TelegramClient.Companion.addLogMessage(
    verbosityLevel: Int = 0,
    text: String? = null
): Ok = execute(
    AddLogMessage(
        verbosityLevel,
        text
    )
)
