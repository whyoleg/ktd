@file:Suppress("DEPRECATION_ERROR")

package dev.whyoleg.ktd.api.file

import dev.whyoleg.ktd.*
import dev.whyoleg.ktd.api.*

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdGetFile): TdFile = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getFile(fileId)", "dev.whyoleg.ktd.api.suspend.getFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getFile(fileId: Int = 0): TdFile = exec(TdGetFile(fileId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdGetRemoteFile): TdFile = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getRemoteFile(remoteFileId, fileType)",
            "dev.whyoleg.ktd.api.suspend.getRemoteFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getRemoteFile(remoteFileId: String? = null, fileType: TdFileType? =
        null): TdFile = exec(TdGetRemoteFile(remoteFileId, fileType))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdDownloadFile): TdFile = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("downloadFile(fileId, priority, offset, limit, synchronous)",
            "dev.whyoleg.ktd.api.suspend.downloadFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.downloadFile(
    fileId: Int = 0,
    priority: Int = 0,
    offset: Int = 0,
    limit: Int = 0,
    synchronous: Boolean = false
): TdFile = exec(TdDownloadFile(fileId, priority, offset, limit, synchronous))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdGetFileDownloadedPrefixSize): TdCount = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getFileDownloadedPrefixSize(fileId, offset)",
            "dev.whyoleg.ktd.api.suspend.getFileDownloadedPrefixSize"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getFileDownloadedPrefixSize(fileId: Int = 0, offset: Int = 0): TdCount =
        exec(TdGetFileDownloadedPrefixSize(fileId, offset))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdUploadFile): TdFile = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("uploadFile(file, fileType, priority)",
            "dev.whyoleg.ktd.api.suspend.uploadFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.uploadFile(
    file: TdInputFile? = null,
    fileType: TdFileType? = null,
    priority: Int = 0
): TdFile = exec(TdUploadFile(file, fileType, priority))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdWriteGeneratedFilePart): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("writeGeneratedFilePart(generationId, offset, data)",
            "dev.whyoleg.ktd.api.suspend.writeGeneratedFilePart"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.writeGeneratedFilePart(
    generationId: Long = 0L,
    offset: Int = 0,
    data: ByteArray = byteArrayOf()
): TdOk = exec(TdWriteGeneratedFilePart(generationId, offset, data))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdSetFileGenerationProgress): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith =
            ReplaceWith("setFileGenerationProgress(generationId, expectedSize, localPrefixSize)",
            "dev.whyoleg.ktd.api.suspend.setFileGenerationProgress"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.setFileGenerationProgress(
    generationId: Long = 0L,
    expectedSize: Int = 0,
    localPrefixSize: Int = 0
): TdOk = exec(TdSetFileGenerationProgress(generationId, expectedSize, localPrefixSize))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdFinishFileGeneration): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("finishFileGeneration(generationId, error)",
            "dev.whyoleg.ktd.api.suspend.finishFileGeneration"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.finishFileGeneration(generationId: Long = 0L, error: TdError? = null):
        TdOk = exec(TdFinishFileGeneration(generationId, error))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdReadFilePart): TdFilePart = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("readFilePart(fileId, offset, count)",
            "dev.whyoleg.ktd.api.suspend.readFilePart"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.readFilePart(
    fileId: Int = 0,
    offset: Int = 0,
    count: Int = 0
): TdFilePart = exec(TdReadFilePart(fileId, offset, count))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdDeleteFile): TdOk = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("deleteFile(fileId)", "dev.whyoleg.ktd.api.suspend.deleteFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.deleteFile(fileId: Int = 0): TdOk = exec(TdDeleteFile(fileId))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdUploadStickerFile): TdFile = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("uploadStickerFile(userId, pngSticker)",
            "dev.whyoleg.ktd.api.suspend.uploadStickerFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.uploadStickerFile(userId: Int = 0, pngSticker: TdInputFile? = null):
        TdFile = exec(TdUploadStickerFile(userId, pngSticker))

@Deprecated(
    message = "Use plain exec or named functions",
    replaceWith = ReplaceWith("exec(f)"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.file(f: TdGetMapThumbnailFile): TdFile = exec(f)

@Deprecated(
    message = "Use functions under `suspend` package instead. You need manually remove old import.",
    replaceWith = ReplaceWith("getMapThumbnailFile(location, zoom, width, height, scale, chatId)",
            "dev.whyoleg.ktd.api.suspend.getMapThumbnailFile"),
    level = DeprecationLevel.ERROR
)
suspend fun TelegramClient.getMapThumbnailFile(
    location: TdLocation? = null,
    zoom: Int = 0,
    width: Int = 0,
    height: Int = 0,
    scale: Int = 0,
    chatId: Long = 0L
): TdFile = exec(TdGetMapThumbnailFile(location, zoom, width, height, scale, chatId))
