@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.notification

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.notification(f: TdRemoveNotification): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeNotification(notificationGroupId, notificationId)",
            "dev.whyoleg.ktd.api.suspend.removeNotification"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeNotification(notificationGroupId: Int = 0, notificationId: Int =
        0): TdOk = exec(TdRemoveNotification(notificationGroupId, notificationId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.notification(f: TdRemoveNotificationGroup): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("removeNotificationGroup(notificationGroupId, maxNotificationId)",
            "dev.whyoleg.ktd.api.suspend.removeNotificationGroup"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.removeNotificationGroup(notificationGroupId: Int = 0,
        maxNotificationId: Int = 0): TdOk = exec(TdRemoveNotificationGroup(notificationGroupId,
        maxNotificationId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.notification(f: TdGetScopeNotificationSettings):
        TdScopeNotificationSettings = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getScopeNotificationSettings(scope)",
            "dev.whyoleg.ktd.api.suspend.getScopeNotificationSettings"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getScopeNotificationSettings(scope: TdNotificationSettingsScope? = null):
        TdScopeNotificationSettings = exec(TdGetScopeNotificationSettings(scope))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.notification(f: TdSetScopeNotificationSettings): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setScopeNotificationSettings(scope, notificationSettings)",
            "dev.whyoleg.ktd.api.suspend.setScopeNotificationSettings"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setScopeNotificationSettings(scope: TdNotificationSettingsScope? = null,
        notificationSettings: TdScopeNotificationSettings? = null): TdOk =
        exec(TdSetScopeNotificationSettings(scope, notificationSettings))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.notification(f: TdResetAllNotificationSettings): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resetAllNotificationSettings()",
            "dev.whyoleg.ktd.api.suspend.resetAllNotificationSettings"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resetAllNotificationSettings(): TdOk =
        exec(TdResetAllNotificationSettings())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.notification(f: TdProcessPushNotification): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("processPushNotification(payload)",
            "dev.whyoleg.ktd.api.suspend.processPushNotification"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.processPushNotification(payload: String? = null): TdOk =
        exec(TdProcessPushNotification(payload))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.notification(f: TdGetPushReceiverId): TdPushReceiverId = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPushReceiverId(payload)",
            "dev.whyoleg.ktd.api.suspend.getPushReceiverId"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPushReceiverId(payload: String? = null): TdPushReceiverId =
        exec(TdGetPushReceiverId(payload))
