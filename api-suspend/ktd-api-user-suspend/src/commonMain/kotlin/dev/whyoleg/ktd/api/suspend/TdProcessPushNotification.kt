package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Handles a push notification
 * Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data
 * Can be called before authorization
 *
 * @property payload JSON-encoded push notification payload with all fields sent by the server, and "google.sent_time" and "google.notification.sound" fields added
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.processPushNotification(payload: String? = null, extra: TdExtra =
        TdExtra.EMPTY): TdOk = exec(TdProcessPushNotification(payload, extra))
