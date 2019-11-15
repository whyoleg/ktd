@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.log

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Closes the TDLib instance after a proper logout
 * Requires an available network connection
 * All local data will be destroyed
 * After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.logOut(): Ok = log(
    LogOut()
)

/**
 * Saves application log event on the server
 * Can be called before authorization
 *
 * @type - Event type
 * @chatId - Optional chat identifier, associated with the event
 * @data - The log event data
 */
suspend fun TelegramClient.saveApplicationLogEvent(
    type: String,
    chatId: Long = 0L,
    data: JsonValue
): Ok = log(
    SaveApplicationLogEvent(
        type,
        chatId,
        data
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
suspend fun TelegramClient.setLogStream(
    logStream: LogStream
): Ok = log(
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
suspend fun TelegramClient.getLogStream(): LogStream = log(
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
suspend fun TelegramClient.setLogVerbosityLevel(
    newVerbosityLevel: Int = 0
): Ok = log(
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
suspend fun TelegramClient.getLogVerbosityLevel(): LogVerbosityLevel = log(
    GetLogVerbosityLevel()
)

/**
 * Returns list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
suspend fun TelegramClient.getLogTags(): LogTags = log(
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
suspend fun TelegramClient.setLogTagVerbosityLevel(
    tag: String,
    newVerbosityLevel: Int = 0
): Ok = log(
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
suspend fun TelegramClient.getLogTagVerbosityLevel(
    tag: String
): LogVerbosityLevel = log(
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
suspend fun TelegramClient.addLogMessage(
    verbosityLevel: Int = 0,
    text: String
): Ok = log(
    AddLogMessage(
        verbosityLevel,
        text
    )
)
