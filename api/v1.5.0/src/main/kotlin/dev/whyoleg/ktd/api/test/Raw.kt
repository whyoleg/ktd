@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.test

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Does nothing
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallEmpty
): Ok = exec(f) as Ok

/**
 * Returns the received string
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallString
): TestString = exec(f) as TestString

/**
 * Returns the received bytes
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallBytes
): TestBytes = exec(f) as TestBytes

/**
 * Returns the received vector of numbers
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorInt
): TestVectorInt = exec(f) as TestVectorInt

/**
 * Returns the received vector of objects containing a number
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorIntObject
): TestVectorIntObject = exec(f) as TestVectorIntObject

/**
 * Returns the received vector of strings
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorString
): TestVectorString = exec(f) as TestVectorString

/**
 * Returns the received vector of objects containing a string
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestCallVectorStringObject
): TestVectorStringObject = exec(f) as TestVectorStringObject

/**
 * Returns the squared received number
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestSquareInt
): TestInt = exec(f) as TestInt

/**
 * Sends a simple network request to the Telegram servers
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestNetwork
): Ok = exec(f) as Ok

/**
 * Sends a simple network request to the Telegram servers via proxy
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestProxy
): Ok = exec(f) as Ok

/**
 * Forces an updates.getDifference call to the Telegram servers
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestGetDifference
): Ok = exec(f) as Ok

/**
 * Does nothing and ensures that the Update object is used
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestUseUpdate
): Update = exec(f) as Update

/**
 * Returns the specified error and ensures that the Error object is used
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 */
@TestingOnly
suspend fun TelegramClient.test(
    f: TestReturnError
): Error = exec(f) as Error
