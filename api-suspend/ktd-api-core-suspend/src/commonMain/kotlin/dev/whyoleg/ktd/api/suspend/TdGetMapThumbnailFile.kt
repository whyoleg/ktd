package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a file with a map thumbnail in PNG format
 * Only map thumbnail files with size less than 1MB can be downloaded
 *
 * @property location Location of the map center
 * @property zoom Map zoom level
 * @property width Map width in pixels before applying scale
 * @property height Map height in pixels before applying scale
 * @property scale Map scale
 * @property chatId Identifier of a chat, in which the thumbnail will be shown
 *                  Use 0 if unknown
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getMapThumbnailFile(
    location: TdLocation? = null,
    zoom: Int = 0,
    width: Int = 0,
    height: Int = 0,
    scale: Int = 0,
    chatId: Long = 0L,
    extra: TdExtra = TdExtra.EMPTY
): TdFile = exec(TdGetMapThumbnailFile(location, zoom, width, height, scale, chatId, extra))
