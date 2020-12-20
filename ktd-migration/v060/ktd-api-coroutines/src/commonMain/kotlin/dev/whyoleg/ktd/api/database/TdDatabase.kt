@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.database

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.database(f: TdSetDatabaseEncryptionKey): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setDatabaseEncryptionKey(newEncryptionKey)",
            "dev.whyoleg.ktd.api.suspend.setDatabaseEncryptionKey"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setDatabaseEncryptionKey(newEncryptionKey: ByteArray = byteArrayOf()):
        TdOk = exec(TdSetDatabaseEncryptionKey(newEncryptionKey))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.database(f: TdGetDatabaseStatistics): TdDatabaseStatistics = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getDatabaseStatistics()",
            "dev.whyoleg.ktd.api.suspend.getDatabaseStatistics"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getDatabaseStatistics(): TdDatabaseStatistics =
        exec(TdGetDatabaseStatistics())
