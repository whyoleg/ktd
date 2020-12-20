@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.test

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestCallEmpty): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testCallEmpty()", "dev.whyoleg.ktd.api.suspend.testCallEmpty"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testCallEmpty(): TdOk = exec(TdTestCallEmpty())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestCallString): TdTestString = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testCallString(x)", "dev.whyoleg.ktd.api.suspend.testCallString"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testCallString(x: String? = null): TdTestString =
        exec(TdTestCallString(x))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestCallBytes): TdTestBytes = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testCallBytes(x)", "dev.whyoleg.ktd.api.suspend.testCallBytes"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testCallBytes(x: ByteArray = byteArrayOf()): TdTestBytes =
        exec(TdTestCallBytes(x))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestCallVectorInt): TdTestVectorInt = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testCallVectorInt(x)",
            "dev.whyoleg.ktd.api.suspend.testCallVectorInt"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testCallVectorInt(x: IntArray = intArrayOf()): TdTestVectorInt =
        exec(TdTestCallVectorInt(x))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestCallVectorIntObject): TdTestVectorIntObject = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testCallVectorIntObject(x)",
            "dev.whyoleg.ktd.api.suspend.testCallVectorIntObject"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testCallVectorIntObject(x: List<TdTestInt> = emptyList()):
        TdTestVectorIntObject = exec(TdTestCallVectorIntObject(x))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestCallVectorString): TdTestVectorString = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testCallVectorString(x)",
            "dev.whyoleg.ktd.api.suspend.testCallVectorString"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testCallVectorString(x: List<String> = emptyList()): TdTestVectorString =
        exec(TdTestCallVectorString(x))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestCallVectorStringObject): TdTestVectorStringObject = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testCallVectorStringObject(x)",
            "dev.whyoleg.ktd.api.suspend.testCallVectorStringObject"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testCallVectorStringObject(x: List<TdTestString> = emptyList()):
        TdTestVectorStringObject = exec(TdTestCallVectorStringObject(x))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestSquareInt): TdTestInt = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testSquareInt(x)", "dev.whyoleg.ktd.api.suspend.testSquareInt"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testSquareInt(x: Int = 0): TdTestInt = exec(TdTestSquareInt(x))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestNetwork): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testNetwork()", "dev.whyoleg.ktd.api.suspend.testNetwork"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testNetwork(): TdOk = exec(TdTestNetwork())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestProxy): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testProxy(server, port, type, dcId, timeout)",
            "dev.whyoleg.ktd.api.suspend.testProxy"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testProxy(
    server: String? = null,
    port: Int = 0,
    type: TdProxyType? = null,
    dcId: Int = 0,
    timeout: Double = 0.0
): TdOk = exec(TdTestProxy(server, port, type, dcId, timeout))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.test(f: TdTestGetDifference): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("testGetDifference()",
            "dev.whyoleg.ktd.api.suspend.testGetDifference"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.testGetDifference(): TdOk = exec(TdTestGetDifference())
