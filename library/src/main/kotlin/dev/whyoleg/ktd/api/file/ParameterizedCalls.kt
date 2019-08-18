@file:Suppress("unused")

package dev.whyoleg.ktd.api.file

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.TdApi.*

/**
 * Returns information about a file; this is an offline request
 *
 * @fileId - Identifier of the file to get
 */
suspend fun TelegramClient.getFile(
    fileId: Int
): File = file(
    GetFile(
        fileId
    )
)

/**
 * Returns information about a file by its remote ID; this is an offline request. Can be used to register a URL as a file for further uploading, or sending as a message
 *
 * @remoteFileId - Remote identifier of the file to get
 * @fileType - File type, if known
 */
suspend fun TelegramClient.getRemoteFile(
    remoteFileId: String,
    fileType: FileType
): File = file(
    GetRemoteFile(
        remoteFileId,
        fileType
    )
)

/**
 * Downloads a file from the cloud. Download progress and completion of the download will be notified through updateFile updates
 *
 * @fileId - Identifier of the file to download
 * @priority - Priority of the download (1-32). The higher the priority, the earlier the file will be downloaded. If the priorities of two files are equal, then the last one for which downloadFile was called will be downloaded first
 * @offset - The starting position from which the file should be downloaded
 * @limit - Number of bytes which should be downloaded starting from the "offset" position before the download will be automatically cancelled; use 0 to download without a limit
 * @synchronous - If false, this request returns file state just after the download has been started. If true, this request returns file state only after
 * @the - download has succeeded, has failed, has been cancelled or a new downloadFile request with different offset/limit parameters was sent
 */
suspend fun TelegramClient.downloadFile(
    fileId: Int,
    priority: Int,
    offset: Int,
    limit: Int,
    synchronous: Boolean
): File = file(
    DownloadFile(
        fileId,
        priority,
        offset,
        limit,
        synchronous
    )
)

/**
 * Stops the downloading of a file. If a file has already been downloaded, does nothing
 *
 * @fileId - Identifier of a file to stop downloading
 * @onlyIfPending - Pass true to stop downloading only if it hasn't been started, i.e. request hasn't been sent to server
 */
suspend fun TelegramClient.cancelDownloadFile(
    fileId: Int,
    onlyIfPending: Boolean
): Ok = file(
    CancelDownloadFile(
        fileId,
        onlyIfPending
    )
)

/**
 * Asynchronously uploads a file to the cloud without sending it in a message. updateFile will be used to notify about upload progress and successful completion of the upload. The file will not have a persistent remote identifier until it will be sent in a message
 *
 * @file - File to upload
 * @fileType - File type
 * @priority - Priority of the upload (1-32). The higher the priority, the earlier the file will be uploaded. If the priorities of two files are equal, then the first one for which uploadFile was called will be uploaded first
 */
suspend fun TelegramClient.uploadFile(
    file: InputFile,
    fileType: FileType,
    priority: Int
): File = file(
    UploadFile(
        file,
        fileType,
        priority
    )
)

/**
 * Stops the uploading of a file. Supported only for files uploaded by using uploadFile. For other files the behavior is undefined
 *
 * @fileId - Identifier of the file to stop uploading
 */
suspend fun TelegramClient.cancelUploadFile(
    fileId: Int
): Ok = file(
    CancelUploadFile(
        fileId
    )
)

/**
 * Writes a part of a generated file. This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
 *
 * @generationId - The identifier of the generation process
 * @offset - The offset from which to write the data to the file
 * @data - The data to write
 */
suspend fun TelegramClient.writeGeneratedFilePart(
    generationId: Long,
    offset: Int,
    data: ByteArray
): Ok = file(
    WriteGeneratedFilePart(
        generationId,
        offset,
        data
    )
)

/**
 * Informs TDLib on a file generation prograss
 *
 * @generationId - The identifier of the generation process
 * @expectedSize - Expected size of the generated file, in bytes; 0 if unknown
 * @localPrefixSize - The number of bytes already generated
 */
suspend fun TelegramClient.setFileGenerationProgress(
    generationId: Long,
    expectedSize: Int,
    localPrefixSize: Int
): Ok = file(
    SetFileGenerationProgress(
        generationId,
        expectedSize,
        localPrefixSize
    )
)

/**
 * Finishes the file generation
 *
 * @generationId - The identifier of the generation process
 * @error - If set, means that file generation has failed and should be terminated
 */
suspend fun TelegramClient.finishFileGeneration(
    generationId: Long,
    error: Error
): Ok = file(
    FinishFileGeneration(
        generationId,
        error
    )
)

/**
 * Reads a part of a file from the TDLib file cache and returns read bytes. This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
 *
 * @fileId - Identifier of the file. The file must be located in the TDLib file cache
 * @offset - The offset from which to read the file
 * @count - Number of bytes to read. An error will be returned if there are not enough bytes available in the file from the specified position. Pass 0 to read all available data from the specified position
 */
suspend fun TelegramClient.readFilePart(
    fileId: Int,
    offset: Int,
    count: Int
): FilePart = file(
    ReadFilePart(
        fileId,
        offset,
        count
    )
)

/**
 * Deletes a file from the TDLib file cache
 *
 * @fileId - Identifier of the file to delete
 */
suspend fun TelegramClient.deleteFile(
    fileId: Int
): Ok = file(
    DeleteFile(
        fileId
    )
)

/**
 * Uploads a PNG image with a sticker; for bots only; returns the uploaded file
 *
 * @userId - Sticker file owner
 * @pngSticker - PNG image with the sticker; must be up to 512 kB in size and fit in 512x512 square
 */
suspend fun TelegramClient.uploadStickerFile(
    userId: Int,
    pngSticker: InputFile
): File = file(
    UploadStickerFile(
        userId,
        pngSticker
    )
)

/**
 * Returns information about a file with a map thumbnail in PNG format. Only map thumbnail files with size less than 1MB can be downloaded
 *
 * @location - Location of the map center
 * @zoom - Map zoom level; 13-20
 * @width - Map width in pixels before applying scale; 16-1024
 * @height - Map height in pixels before applying scale; 16-1024
 * @scale - Map scale; 1-3
 * @chatId - Identifier of a chat, in which the thumbnail will be shown. Use 0 if unknown
 */
suspend fun TelegramClient.getMapThumbnailFile(
    location: Location,
    zoom: Int,
    width: Int,
    height: Int,
    scale: Int,
    chatId: Long
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
