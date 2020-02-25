@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.user

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdRegisterUser): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("registerUser(firstName, lastName)",
            "dev.whyoleg.ktd.api.suspend.registerUser"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.registerUser(firstName: String? = null, lastName: String? = null): TdOk =
        exec(TdRegisterUser(firstName, lastName))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetMe): TdUser = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getMe()", "dev.whyoleg.ktd.api.suspend.getMe"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getMe(): TdUser = exec(TdGetMe())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetUser): TdUser = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getUser(userId)", "dev.whyoleg.ktd.api.suspend.getUser"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getUser(userId: Int = 0): TdUser = exec(TdGetUser(userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetUserFullInfo): TdUserFullInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getUserFullInfo(userId)",
            "dev.whyoleg.ktd.api.suspend.getUserFullInfo"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getUserFullInfo(userId: Int = 0): TdUserFullInfo =
        exec(TdGetUserFullInfo(userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetPollVoters): TdUsers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getPollVoters(chatId, messageId, optionId, offset, limit)",
            "dev.whyoleg.ktd.api.suspend.getPollVoters"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getPollVoters(
    chatId: Long = 0L,
    messageId: Long = 0L,
    optionId: Int = 0,
    offset: Int = 0,
    limit: Int = 0
): TdUsers = exec(TdGetPollVoters(chatId, messageId, optionId, offset, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdBlockUser): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("blockUser(userId)", "dev.whyoleg.ktd.api.suspend.blockUser"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.blockUser(userId: Int = 0): TdOk = exec(TdBlockUser(userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdUnblockUser): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("unblockUser(userId)", "dev.whyoleg.ktd.api.suspend.unblockUser"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.unblockUser(userId: Int = 0): TdOk = exec(TdUnblockUser(userId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetBlockedUsers): TdUsers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getBlockedUsers(offset, limit)",
            "dev.whyoleg.ktd.api.suspend.getBlockedUsers"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getBlockedUsers(offset: Int = 0, limit: Int = 0): TdUsers =
        exec(TdGetBlockedUsers(offset, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetContacts): TdUsers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getContacts()", "dev.whyoleg.ktd.api.suspend.getContacts"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getContacts(): TdUsers = exec(TdGetContacts())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdSearchContacts): TdUsers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("searchContacts(query, limit)",
            "dev.whyoleg.ktd.api.suspend.searchContacts"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.searchContacts(query: String? = null, limit: Int = 0): TdUsers =
        exec(TdSearchContacts(query, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetUserProfilePhotos): TdUserProfilePhotos = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getUserProfilePhotos(userId, offset, limit)",
            "dev.whyoleg.ktd.api.suspend.getUserProfilePhotos"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getUserProfilePhotos(
    userId: Int = 0,
    offset: Int = 0,
    limit: Int = 0
): TdUserProfilePhotos = exec(TdGetUserProfilePhotos(userId, offset, limit))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetRecentInlineBots): TdUsers = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getRecentInlineBots()",
            "dev.whyoleg.ktd.api.suspend.getRecentInlineBots"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getRecentInlineBots(): TdUsers = exec(TdGetRecentInlineBots())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdSetName): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setName(firstName, lastName)",
            "dev.whyoleg.ktd.api.suspend.setName"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setName(firstName: String? = null, lastName: String? = null): TdOk =
        exec(TdSetName(firstName, lastName))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdSetBio): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setBio(bio)", "dev.whyoleg.ktd.api.suspend.setBio"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setBio(bio: String? = null): TdOk = exec(TdSetBio(bio))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdSetUsername): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setUsername(username)", "dev.whyoleg.ktd.api.suspend.setUsername"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setUsername(username: String? = null): TdOk =
        exec(TdSetUsername(username))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetSupportUser): TdUser = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getSupportUser()", "dev.whyoleg.ktd.api.suspend.getSupportUser"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getSupportUser(): TdUser = exec(TdGetSupportUser())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdSetUserPrivacySettingRules): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setUserPrivacySettingRules(setting, rules)",
            "dev.whyoleg.ktd.api.suspend.setUserPrivacySettingRules"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setUserPrivacySettingRules(setting: TdUserPrivacySetting? = null,
        rules: TdUserPrivacySettingRules? = null): TdOk = exec(TdSetUserPrivacySettingRules(setting,
        rules))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.user(f: TdGetUserPrivacySettingRules): TdUserPrivacySettingRules =
        exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getUserPrivacySettingRules(setting)",
            "dev.whyoleg.ktd.api.suspend.getUserPrivacySettingRules"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getUserPrivacySettingRules(setting: TdUserPrivacySetting? = null):
        TdUserPrivacySettingRules = exec(TdGetUserPrivacySettingRules(setting))
