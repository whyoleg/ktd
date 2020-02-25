@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.check

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckDatabaseEncryptionKey): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkDatabaseEncryptionKey(encryptionKey)",
            "dev.whyoleg.ktd.api.suspend.checkDatabaseEncryptionKey"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkDatabaseEncryptionKey(encryptionKey: ByteArray = byteArrayOf()):
        TdOk = exec(TdCheckDatabaseEncryptionKey(encryptionKey))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckAuthenticationCode): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkAuthenticationCode(code)",
            "dev.whyoleg.ktd.api.suspend.checkAuthenticationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkAuthenticationCode(code: String? = null): TdOk =
        exec(TdCheckAuthenticationCode(code))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckAuthenticationPassword): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkAuthenticationPassword(password)",
            "dev.whyoleg.ktd.api.suspend.checkAuthenticationPassword"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkAuthenticationPassword(password: String? = null): TdOk =
        exec(TdCheckAuthenticationPassword(password))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckAuthenticationBotToken): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkAuthenticationBotToken(token)",
            "dev.whyoleg.ktd.api.suspend.checkAuthenticationBotToken"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkAuthenticationBotToken(token: String? = null): TdOk =
        exec(TdCheckAuthenticationBotToken(token))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckChatUsername): TdCheckChatUsernameResult = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkChatUsername(chatId, username)",
            "dev.whyoleg.ktd.api.suspend.checkChatUsername"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkChatUsername(chatId: Long = 0L, username: String? = null):
        TdCheckChatUsernameResult = exec(TdCheckChatUsername(chatId, username))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckCreatedPublicChatsLimit): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkCreatedPublicChatsLimit(type)",
            "dev.whyoleg.ktd.api.suspend.checkCreatedPublicChatsLimit"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkCreatedPublicChatsLimit(type: TdPublicChatType? = null): TdOk =
        exec(TdCheckCreatedPublicChatsLimit(type))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdAnswerPreCheckoutQuery): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("answerPreCheckoutQuery(preCheckoutQueryId, errorMessage)",
            "dev.whyoleg.ktd.api.suspend.answerPreCheckoutQuery"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.answerPreCheckoutQuery(preCheckoutQueryId: Long = 0L,
        errorMessage: String? = null): TdOk = exec(TdAnswerPreCheckoutQuery(preCheckoutQueryId,
        errorMessage))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckChangePhoneNumberCode): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkChangePhoneNumberCode(code)",
            "dev.whyoleg.ktd.api.suspend.checkChangePhoneNumberCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkChangePhoneNumberCode(code: String? = null): TdOk =
        exec(TdCheckChangePhoneNumberCode(code))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckPhoneNumberVerificationCode): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkPhoneNumberVerificationCode(code)",
            "dev.whyoleg.ktd.api.suspend.checkPhoneNumberVerificationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkPhoneNumberVerificationCode(code: String? = null): TdOk =
        exec(TdCheckPhoneNumberVerificationCode(code))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckEmailAddressVerificationCode): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkEmailAddressVerificationCode(code)",
            "dev.whyoleg.ktd.api.suspend.checkEmailAddressVerificationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkEmailAddressVerificationCode(code: String? = null): TdOk =
        exec(TdCheckEmailAddressVerificationCode(code))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.check(f: TdCheckPhoneNumberConfirmationCode): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("checkPhoneNumberConfirmationCode(code)",
            "dev.whyoleg.ktd.api.suspend.checkPhoneNumberConfirmationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.checkPhoneNumberConfirmationCode(code: String? = null): TdOk =
        exec(TdCheckPhoneNumberConfirmationCode(code))
