@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.supergroup

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdGetSupergroup): TdSupergroup = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSupergroup(supergroupId)",
            "dev.whyoleg.ktd.api.suspend.getSupergroup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSupergroup(supergroupId: Int = 0): TdSupergroup =
        exec(TdGetSupergroup(supergroupId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdGetSupergroupFullInfo): TdSupergroupFullInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSupergroupFullInfo(supergroupId)",
            "dev.whyoleg.ktd.api.suspend.getSupergroupFullInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSupergroupFullInfo(supergroupId: Int = 0): TdSupergroupFullInfo =
        exec(TdGetSupergroupFullInfo(supergroupId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdSetSupergroupUsername): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setSupergroupUsername(supergroupId, username)",
            "dev.whyoleg.ktd.api.suspend.setSupergroupUsername"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setSupergroupUsername(supergroupId: Int = 0, username: String? = null):
        TdOk = exec(TdSetSupergroupUsername(supergroupId, username))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdSetSupergroupStickerSet): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setSupergroupStickerSet(supergroupId, stickerSetId)",
            "dev.whyoleg.ktd.api.suspend.setSupergroupStickerSet"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setSupergroupStickerSet(supergroupId: Int = 0, stickerSetId: Long = 0L):
        TdOk = exec(TdSetSupergroupStickerSet(supergroupId, stickerSetId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdToggleSupergroupSignMessages): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("toggleSupergroupSignMessages(supergroupId, signMessages)",
            "dev.whyoleg.ktd.api.suspend.toggleSupergroupSignMessages"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.toggleSupergroupSignMessages(supergroupId: Int = 0, signMessages: Boolean
        = false): TdOk = exec(TdToggleSupergroupSignMessages(supergroupId, signMessages))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdToggleSupergroupIsAllHistoryAvailable): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("toggleSupergroupIsAllHistoryAvailable(supergroupId, isAllHistoryAvailable)",
            "dev.whyoleg.ktd.api.suspend.toggleSupergroupIsAllHistoryAvailable"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.toggleSupergroupIsAllHistoryAvailable(supergroupId: Int = 0,
        isAllHistoryAvailable: Boolean = false): TdOk =
        exec(TdToggleSupergroupIsAllHistoryAvailable(supergroupId, isAllHistoryAvailable))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdReportSupergroupSpam): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("reportSupergroupSpam(supergroupId, userId, messageIds)",
            "dev.whyoleg.ktd.api.suspend.reportSupergroupSpam"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.reportSupergroupSpam(
    supergroupId: Int = 0,
    userId: Int = 0,
    messageIds: LongArray = longArrayOf()
): TdOk = exec(TdReportSupergroupSpam(supergroupId, userId, messageIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.supergroup(f: TdDeleteSupergroup): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteSupergroup(supergroupId)",
            "dev.whyoleg.ktd.api.suspend.deleteSupergroup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteSupergroup(supergroupId: Int = 0): TdOk =
        exec(TdDeleteSupergroup(supergroupId))
