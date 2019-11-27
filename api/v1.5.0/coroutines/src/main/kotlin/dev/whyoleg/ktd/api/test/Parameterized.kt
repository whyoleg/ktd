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
suspend fun TelegramClient.testCallEmpty(): Ok = test(
    TestCallEmpty()
)

/**
 * Returns the received string
 * This is an offline method
 * Can be called before authorization
 *
 * @x - String to return
 */
@TestingOnly
suspend fun TelegramClient.testCallString(
    x: String? = null
): TestString = test(
    TestCallString(
        x
    )
)

/**
 * Returns the received bytes
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Bytes to return
 */
@TestingOnly
suspend fun TelegramClient.testCallBytes(
    x: ByteArray = byteArrayOf()
): TestBytes = test(
    TestCallBytes(
        x
    )
)

/**
 * Returns the received vector of numbers
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of numbers to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorInt(
    x: IntArray = intArrayOf()
): TestVectorInt = test(
    TestCallVectorInt(
        x
    )
)

/**
 * Returns the received vector of objects containing a number
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of objects to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorIntObject(
    x: Array<TestInt> = emptyArray()
): TestVectorIntObject = test(
    TestCallVectorIntObject(
        x
    )
)

/**
 * Returns the received vector of strings
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of strings to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorString(
    x: Array<String> = emptyArray()
): TestVectorString = test(
    TestCallVectorString(
        x
    )
)

/**
 * Returns the received vector of objects containing a string
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Vector of objects to return
 */
@TestingOnly
suspend fun TelegramClient.testCallVectorStringObject(
    x: Array<TestString> = emptyArray()
): TestVectorStringObject = test(
    TestCallVectorStringObject(
        x
    )
)

/**
 * Returns the squared received number
 * This is an offline method
 * Can be called before authorization
 *
 * @x - Number to square
 */
@TestingOnly
suspend fun TelegramClient.testSquareInt(
    x: Int = 0
): TestInt = test(
    TestSquareInt(
        x
    )
)

/**
 * Sends a simple network request to the Telegram servers
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.testNetwork(): Ok = test(
    TestNetwork()
)

/**
 * Sends a simple network request to the Telegram servers via proxy
 * Can be called before authorization
 *
 * @server - Proxy server IP address
 * @port - Proxy server port
 * @type - Proxy type
 */
@TestingOnly
suspend fun TelegramClient.testProxy(
    server: String? = null,
    port: Int = 0,
    type: ProxyType? = null
): Ok = test(
    TestProxy(
        server,
        port,
        type
    )
)

/**
 * Forces an updates.getDifference call to the Telegram servers
 */
@TestingOnly
suspend fun TelegramClient.testGetDifference(): Ok = test(
    TestGetDifference()
)

/**
 * Does nothing and ensures that the Update object is used
 * This is an offline method
 * Can be called before authorization
 */
@TestingOnly
suspend fun TelegramClient.testUseUpdate(): Update = test(
    TestUseUpdate()
)

/**
 * Returns the specified error and ensures that the Error object is used
 * This is an offline method
 * Can be called before authorization
 * Can be called synchronously
 *
 * @error - The error to be returned
 */
@TestingOnly
suspend fun TelegramClient.testReturnError(
    error: Error? = null
): Error = test(
    TestReturnError(
        error
    )
)
