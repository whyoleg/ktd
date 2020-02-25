package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Checks the authentication token of a bot
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 * Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in
 *
 * @property token The bot token
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.checkAuthenticationBotToken(token: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdCheckAuthenticationBotToken(token, extra))
