@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.email

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.email(f: TdGetRecoveryEmailAddress): TdRecoveryEmailAddress = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getRecoveryEmailAddress(password)",
            "dev.whyoleg.ktd.api.suspend.getRecoveryEmailAddress"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getRecoveryEmailAddress(password: String? = null): TdRecoveryEmailAddress
        = exec(TdGetRecoveryEmailAddress(password))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.email(f: TdRequestPasswordRecovery): TdEmailAddressAuthenticationCodeInfo
        = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("requestPasswordRecovery()",
            "dev.whyoleg.ktd.api.suspend.requestPasswordRecovery"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.requestPasswordRecovery(): TdEmailAddressAuthenticationCodeInfo =
        exec(TdRequestPasswordRecovery())

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.email(f: TdSendEmailAddressVerificationCode):
        TdEmailAddressAuthenticationCodeInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("sendEmailAddressVerificationCode(emailAddress)",
            "dev.whyoleg.ktd.api.suspend.sendEmailAddressVerificationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.sendEmailAddressVerificationCode(emailAddress: String? = null):
        TdEmailAddressAuthenticationCodeInfo =
        exec(TdSendEmailAddressVerificationCode(emailAddress))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.email(f: TdResendEmailAddressVerificationCode):
        TdEmailAddressAuthenticationCodeInfo = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("resendEmailAddressVerificationCode()",
            "dev.whyoleg.ktd.api.suspend.resendEmailAddressVerificationCode"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.resendEmailAddressVerificationCode():
        TdEmailAddressAuthenticationCodeInfo = exec(TdResendEmailAddressVerificationCode())
