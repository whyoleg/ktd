@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.call

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Creates a new call
 */
suspend fun TelegramClient.call(
    f: CreateCall
): CallId = exec(f) as CallId

/**
 * Accepts an incoming call
 */
suspend fun TelegramClient.call(
    f: AcceptCall
): Ok = exec(f) as Ok

/**
 * Discards a call
 */
suspend fun TelegramClient.call(
    f: DiscardCall
): Ok = exec(f) as Ok

/**
 * Sends a call rating
 */
suspend fun TelegramClient.call(
    f: SendCallRating
): Ok = exec(f) as Ok

/**
 * Sends debug information for a call
 */
suspend fun TelegramClient.call(
    f: SendCallDebugInformation
): Ok = exec(f) as Ok
