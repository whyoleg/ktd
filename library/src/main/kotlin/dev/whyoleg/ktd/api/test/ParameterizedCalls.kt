@file:Suppress("unused")

package dev.whyoleg.ktd.api.test

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Does nothing; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TelegramClient.testCallEmpty(): Ok = test(
    TestCallEmpty()
)

/**
 * Returns the received string; for testing only. This is an offline method. Can be called before authorization
 *
 * @x - String to return
 */
suspend fun TelegramClient.testCallString(
    x: String
): TestString = test(
    TestCallString(
        x
    )
)

/**
 * Returns the received bytes; for testing only. This is an offline method. Can be called before authorization
 *
 * @x - Bytes to return
 */
suspend fun TelegramClient.testCallBytes(
    x: ByteArray
): TestBytes = test(
    TestCallBytes(
        x
    )
)

/**
 * Returns the received vector of numbers; for testing only. This is an offline method. Can be called before authorization
 *
 * @x - Vector of numbers to return
 */
suspend fun TelegramClient.testCallVectorInt(
    x: IntArray
): TestVectorInt = test(
    TestCallVectorInt(
        x
    )
)

/**
 * Returns the received vector of objects containing a number; for testing only. This is an offline method. Can be called before authorization
 *
 * @x - Vector of objects to return
 */
suspend fun TelegramClient.testCallVectorIntObject(
    x: Array<TestInt>
): TestVectorIntObject = test(
    TestCallVectorIntObject(
        x
    )
)

/**
 * Returns the received vector of strings; for testing only. This is an offline method. Can be called before authorization
 *
 * @x - Vector of strings to return
 */
suspend fun TelegramClient.testCallVectorString(
    x: Array<String>
): TestVectorString = test(
    TestCallVectorString(
        x
    )
)

/**
 * Returns the received vector of objects containing a string; for testing only. This is an offline method. Can be called before authorization
 *
 * @x - Vector of objects to return
 */
suspend fun TelegramClient.testCallVectorStringObject(
    x: Array<TestString>
): TestVectorStringObject = test(
    TestCallVectorStringObject(
        x
    )
)

/**
 * Returns the squared received number; for testing only. This is an offline method. Can be called before authorization
 *
 * @x - Number to square
 */
suspend fun TelegramClient.testSquareInt(
    x: Int
): TestInt = test(
    TestSquareInt(
        x
    )
)

/**
 * Sends a simple network request to the Telegram servers; for testing only. Can be called before authorization
 */
suspend fun TelegramClient.testNetwork(): Ok = test(
    TestNetwork()
)

/**
 * Sends a simple network request to the Telegram servers via proxy; for testing only. Can be called before authorization
 *
 * @server - Proxy server IP address
 * @port - Proxy server port
 * @type - Proxy type
 */
suspend fun TelegramClient.testProxy(
    server: String,
    port: Int,
    type: ProxyType
): Ok = test(
    TestProxy(
        server,
        port,
        type
    )
)

/**
 * Forces an updates.getDifference call to the Telegram servers; for testing only
 */
suspend fun TelegramClient.testGetDifference(): Ok = test(
    TestGetDifference()
)
