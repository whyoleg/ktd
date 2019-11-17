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
 * Returns information about a file
 * This is an offline request
 */
suspend fun TelegramClient.file(
    f: GetFile
): File = exec(f) as File

/**
 * Returns information about a file by its remote ID
 * This is an offline request
 * Can be used to register a URL as a file for further uploading, or sending as a message
 */
suspend fun TelegramClient.file(
    f: GetRemoteFile
): File = exec(f) as File

/**
 * Downloads a file from the cloud
 * Download progress and completion of the download will be notified through updateFile updates
 */
suspend fun TelegramClient.file(
    f: DownloadFile
): File = exec(f) as File

/**
 * Returns file downloaded prefix size from a given offset
 */
suspend fun TelegramClient.file(
    f: GetFileDownloadedPrefixSize
): Count = exec(f) as Count

/**
 * Stops the downloading of a file
 * If a file has already been downloaded, does nothing
 */
suspend fun TelegramClient.file(
    f: CancelDownloadFile
): Ok = exec(f) as Ok

/**
 * Asynchronously uploads a file to the cloud without sending it in a message
 * UpdateFile will be used to notify about upload progress and successful completion of the upload
 * The file will not have a persistent remote identifier until it will be sent in a message
 */
suspend fun TelegramClient.file(
    f: UploadFile
): File = exec(f) as File

/**
 * Stops the uploading of a file
 * Supported only for files uploaded by using uploadFile
 * For other files the behavior is undefined
 */
suspend fun TelegramClient.file(
    f: CancelUploadFile
): Ok = exec(f) as Ok

/**
 * Writes a part of a generated file
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
 */
suspend fun TelegramClient.file(
    f: WriteGeneratedFilePart
): Ok = exec(f) as Ok

/**
 * Informs TDLib on a file generation prograss
 */
suspend fun TelegramClient.file(
    f: SetFileGenerationProgress
): Ok = exec(f) as Ok

/**
 * Finishes the file generation
 */
suspend fun TelegramClient.file(
    f: FinishFileGeneration
): Ok = exec(f) as Ok

/**
 * Reads a part of a file from the TDLib file cache and returns read bytes
 * This method is intended to be used only if the client has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
 */
suspend fun TelegramClient.file(
    f: ReadFilePart
): FilePart = exec(f) as FilePart

/**
 * Deletes a file from the TDLib file cache
 */
suspend fun TelegramClient.file(
    f: DeleteFile
): Ok = exec(f) as Ok

/**
 * Uploads a PNG image with a sticker
 * Returns the uploaded file
 */
@BotsOnly
suspend fun TelegramClient.file(
    f: UploadStickerFile
): File = exec(f) as File

/**
 * Returns information about a file with a map thumbnail in PNG format
 * Only map thumbnail files with size less than 1MB can be downloaded
 */
suspend fun TelegramClient.file(
    f: GetMapThumbnailFile
): File = exec(f) as File
