package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Requests QR code authentication by scanning a QR code on another logged in device
 * Works only when the current authorization state is authorizationStateWaitPhoneNumber
 *
 * @property otherUserIds List of user identifiers of other users currently using the client
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.requestQrCodeAuthentication(otherUserIds: IntArray = intArrayOf(),
        extra: TdExtra = TdExtra.EMPTY): TdOk = exec(TdRequestQrCodeAuthentication(otherUserIds,
        extra))
