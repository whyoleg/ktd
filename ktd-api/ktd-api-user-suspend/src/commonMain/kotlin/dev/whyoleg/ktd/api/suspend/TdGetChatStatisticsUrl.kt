package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns an HTTP URL with the chat statistics
 * Currently this method can be used only for channels
 * Can be used only if SupergroupFullInfo.can_view_statistics == true
 *
 * @property chatId Chat identifier
 * @property parameters Parameters from "tg://statsrefresh?params=******" link
 * @property isDark Pass true if a URL with the dark theme must be returned
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getChatStatisticsUrl(
    chatId: Long = 0L,
    parameters: String? = null,
    isDark: Boolean = false,
    extra: TdExtra = TdExtra.EMPTY
): TdHttpUrl = exec(TdGetChatStatisticsUrl(chatId, parameters, isDark, extra))
