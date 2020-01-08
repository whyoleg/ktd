@file:Suppress(
    "unused"
)
@file:UseExperimental(
    BotsOnly::class,
    TestingOnly::class
)

package dev.whyoleg.ktd.api.file

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a file with a map thumbnail in PNG format
 * Only map thumbnail files with size less than 1MB can be downloaded
 *
 * @location - Location of the map center
 * @zoom - Map zoom level
 * @width - Map width in pixels before applying scale
 * @height - Map height in pixels before applying scale
 * @scale - Map scale
 * @chatId - Identifier of a chat, in which the thumbnail will be shown
 *           Use 0 if unknown
 */
suspend fun TelegramClient.getMapThumbnailFile(
    location: Location? = null,
    zoom: Int = 0,
    width: Int = 0,
    height: Int = 0,
    scale: Int = 0,
    chatId: Long = 0L
): File = file(
    GetMapThumbnailFile(
        location,
        zoom,
        width,
        height,
        scale,
        chatId
    )
)

/**
 * Returns information about a file with a map thumbnail in PNG format
 * Only map thumbnail files with size less than 1MB can be downloaded
 */
suspend fun TelegramClient.file(
    f: GetMapThumbnailFile
): File = exec(f) as File
