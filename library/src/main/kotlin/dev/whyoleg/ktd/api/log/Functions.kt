@file:Suppress("unused")

package dev.whyoleg.ktd.api.log

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Closes the TDLib instance after a proper logout. Requires an available network connection. All local data will be destroyed. After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TelegramClient.log(
    f: LogOut
): Ok = execRaw(f) as Ok

/**
 * Saves application log event on the server. Can be called before authorization
 */
suspend fun TelegramClient.log(
    f: SaveApplicationLogEvent
): Ok = execRaw(f) as Ok

/**
 * Sets new log stream for internal logging of TDLib. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: SetLogStream
): Ok = execRaw(f) as Ok

/**
 * Returns information about currently used log stream for internal logging of TDLib. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: GetLogStream
): LogStream = execRaw(f) as LogStream

/**
 * Sets the verbosity level of the internal logging of TDLib. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: SetLogVerbosityLevel
): Ok = execRaw(f) as Ok

/**
 * Returns current verbosity level of the internal logging of TDLib. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: GetLogVerbosityLevel
): LogVerbosityLevel = execRaw(f) as LogVerbosityLevel

/**
 * Returns list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: GetLogTags
): LogTags = execRaw(f) as LogTags

/**
 * Sets the verbosity level for a specified TDLib internal log tag. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: SetLogTagVerbosityLevel
): Ok = execRaw(f) as Ok

/**
 * Returns current verbosity level for a specified TDLib internal log tag. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: GetLogTagVerbosityLevel
): LogVerbosityLevel = execRaw(f) as LogVerbosityLevel

/**
 * Adds a message to TDLib internal log. This is an offline method. Can be called before authorization. Can be called synchronously
 */
suspend fun TelegramClient.log(
    f: AddLogMessage
): Ok = execRaw(f) as Ok
