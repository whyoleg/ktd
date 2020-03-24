package dev.whyoleg.ktd.api.suspend

import dev.whyoleg.ktd.api.*
import dev.whyoleg.ktd.client.*

/**
 * Returns information about a file by its remote ID
 * This is an offline request
 * Can be used to register a URL as a file for further uploading, or sending as a message
 * Even the request succeeds, the file can be used only if it is still accessible to the user
 * For example, if the file is from a message, then the message must be not deleted and accessible to the user
 * If the file database is disabled, then the corresponding object with the file must be preloaded by the client
 *
 * @property remoteFileId Remote identifier of the file to get
 * @property fileType File type, if known
 * @property extra Extra data shared between request and response
 */
suspend fun SuspendTdClient.getRemoteFile(
    remoteFileId: String? = null,
    fileType: TdFileType? = null,
    extra: TdExtra = TdExtra.EMPTY
): TdFile = exec(TdGetRemoteFile(remoteFileId, fileType, extra))
