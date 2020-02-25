@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.group

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.group(f: TdGetBasicGroup): TdBasicGroup = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getBasicGroup(basicGroupId)",
            "dev.whyoleg.ktd.api.suspend.getBasicGroup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getBasicGroup(basicGroupId: Int = 0): TdBasicGroup =
        exec(TdGetBasicGroup(basicGroupId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.group(f: TdGetBasicGroupFullInfo): TdBasicGroupFullInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getBasicGroupFullInfo(basicGroupId)",
            "dev.whyoleg.ktd.api.suspend.getBasicGroupFullInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getBasicGroupFullInfo(basicGroupId: Int = 0): TdBasicGroupFullInfo =
        exec(TdGetBasicGroupFullInfo(basicGroupId))
