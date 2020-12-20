@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.authentication

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdSetAuthenticationPhoneNumber): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("setAuthenticationPhoneNumber(phoneNumber, settings)",
            "dev.whyoleg.ktd.api.suspend.setAuthenticationPhoneNumber"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setAuthenticationPhoneNumber(phoneNumber: String? = null,
        settings: TdPhoneNumberAuthenticationSettings? = null): TdOk =
        exec(TdSetAuthenticationPhoneNumber(phoneNumber, settings))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdResendAuthenticationCode): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resendAuthenticationCode()",
            "dev.whyoleg.ktd.api.suspend.resendAuthenticationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resendAuthenticationCode(): TdOk = exec(TdResendAuthenticationCode())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdRequestQrCodeAuthentication): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("requestQrCodeAuthentication(otherUserIds)",
            "dev.whyoleg.ktd.api.suspend.requestQrCodeAuthentication"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.requestQrCodeAuthentication(otherUserIds: IntArray = intArrayOf()): TdOk
        = exec(TdRequestQrCodeAuthentication(otherUserIds))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdRequestAuthenticationPasswordRecovery): TdOk =
        exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("requestAuthenticationPasswordRecovery()",
            "dev.whyoleg.ktd.api.suspend.requestAuthenticationPasswordRecovery"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.requestAuthenticationPasswordRecovery(): TdOk =
        exec(TdRequestAuthenticationPasswordRecovery())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdRecoverAuthenticationPassword): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("recoverAuthenticationPassword(recoveryCode)",
            "dev.whyoleg.ktd.api.suspend.recoverAuthenticationPassword"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.recoverAuthenticationPassword(recoveryCode: String? = null): TdOk =
        exec(TdRecoverAuthenticationPassword(recoveryCode))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdChangePhoneNumber): TdAuthenticationCodeInfo =
        exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("changePhoneNumber(phoneNumber, settings)",
            "dev.whyoleg.ktd.api.suspend.changePhoneNumber"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.changePhoneNumber(phoneNumber: String? = null,
        settings: TdPhoneNumberAuthenticationSettings? = null): TdAuthenticationCodeInfo =
        exec(TdChangePhoneNumber(phoneNumber, settings))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdResendChangePhoneNumberCode):
        TdAuthenticationCodeInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resendChangePhoneNumberCode()",
            "dev.whyoleg.ktd.api.suspend.resendChangePhoneNumberCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resendChangePhoneNumberCode(): TdAuthenticationCodeInfo =
        exec(TdResendChangePhoneNumberCode())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdSendPhoneNumberVerificationCode):
        TdAuthenticationCodeInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendPhoneNumberVerificationCode(phoneNumber, settings)",
            "dev.whyoleg.ktd.api.suspend.sendPhoneNumberVerificationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendPhoneNumberVerificationCode(phoneNumber: String? = null,
        settings: TdPhoneNumberAuthenticationSettings? = null): TdAuthenticationCodeInfo =
        exec(TdSendPhoneNumberVerificationCode(phoneNumber, settings))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdResendPhoneNumberVerificationCode):
        TdAuthenticationCodeInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resendPhoneNumberVerificationCode()",
            "dev.whyoleg.ktd.api.suspend.resendPhoneNumberVerificationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resendPhoneNumberVerificationCode(): TdAuthenticationCodeInfo =
        exec(TdResendPhoneNumberVerificationCode())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdSendPhoneNumberConfirmationCode):
        TdAuthenticationCodeInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendPhoneNumberConfirmationCode(hash, phoneNumber, settings)",
            "dev.whyoleg.ktd.api.suspend.sendPhoneNumberConfirmationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendPhoneNumberConfirmationCode(
    hash: String? = null,
    phoneNumber: String? = null,
    settings: TdPhoneNumberAuthenticationSettings? = null
): TdAuthenticationCodeInfo = exec(TdSendPhoneNumberConfirmationCode(hash, phoneNumber, settings))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.authentication(f: TdResendPhoneNumberConfirmationCode):
        TdAuthenticationCodeInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resendPhoneNumberConfirmationCode()",
            "dev.whyoleg.ktd.api.suspend.resendPhoneNumberConfirmationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resendPhoneNumberConfirmationCode(): TdAuthenticationCodeInfo =
        exec(TdResendPhoneNumberConfirmationCode())
