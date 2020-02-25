@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.can

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.can(f: TdCanTransferOwnership): TdCanTransferOwnershipResult = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("canTransferOwnership()",
            "dev.whyoleg.ktd.api.suspend.canTransferOwnership"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.canTransferOwnership(): TdCanTransferOwnershipResult =
        exec(TdCanTransferOwnership())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.can(f: TdCancelDownloadFile): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("cancelDownloadFile(fileId, onlyIfPending)",
            "dev.whyoleg.ktd.api.suspend.cancelDownloadFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.cancelDownloadFile(fileId: Int = 0, onlyIfPending: Boolean = false): TdOk
        = exec(TdCancelDownloadFile(fileId, onlyIfPending))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.can(f: TdCancelUploadFile): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("cancelUploadFile(fileId)",
            "dev.whyoleg.ktd.api.suspend.cancelUploadFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.cancelUploadFile(fileId: Int = 0): TdOk =
        exec(TdCancelUploadFile(fileId))
