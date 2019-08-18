@file:Suppress("unused")

package dev.whyoleg.ktd.api.call

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new call
 */
suspend fun TelegramClient.call(
    f: CreateCall
): CallId = execRaw(f) as CallId

/**
 * Accepts an incoming call
 */
suspend fun TelegramClient.call(
    f: AcceptCall
): Ok = execRaw(f) as Ok

/**
 * Discards a call
 */
suspend fun TelegramClient.call(
    f: DiscardCall
): Ok = execRaw(f) as Ok

/**
 * Sends a call rating
 */
suspend fun TelegramClient.call(
    f: SendCallRating
): Ok = execRaw(f) as Ok

/**
 * Sends debug information for a call
 */
suspend fun TelegramClient.call(
    f: SendCallDebugInformation
): Ok = execRaw(f) as Ok
