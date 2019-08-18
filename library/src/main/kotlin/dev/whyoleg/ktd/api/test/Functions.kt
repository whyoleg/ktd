@file:Suppress("unused")

package dev.whyoleg.ktd.api.test

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Does nothing; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestCallEmpty
): Ok = execRaw(f) as Ok

/**
 * Returns the received string; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestCallString
): TestString = execRaw(f) as TestString

/**
 * Returns the received bytes; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestCallBytes
): TestBytes = execRaw(f) as TestBytes

/**
 * Returns the received vector of numbers; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestCallVectorInt
): TestVectorInt = execRaw(f) as TestVectorInt

/**
 * Returns the received vector of objects containing a number; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestCallVectorIntObject
): TestVectorIntObject = execRaw(f) as TestVectorIntObject

/**
 * Returns the received vector of strings; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestCallVectorString
): TestVectorString = execRaw(f) as TestVectorString

/**
 * Returns the received vector of objects containing a string; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestCallVectorStringObject
): TestVectorStringObject = execRaw(f) as TestVectorStringObject

/**
 * Returns the squared received number; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestSquareInt
): TestInt = execRaw(f) as TestInt

/**
 * Sends a simple network request to the Telegram servers; for testing only. Can be called before authorization
 */
suspend fun TelegramClient.test(
    f: TestNetwork
): Ok = execRaw(f) as Ok

/**
 * Forces an updates.getDifference call to the Telegram servers; for testing only
 */
suspend fun TelegramClient.test(
    f: TestGetDifference
): Ok = execRaw(f) as Ok
