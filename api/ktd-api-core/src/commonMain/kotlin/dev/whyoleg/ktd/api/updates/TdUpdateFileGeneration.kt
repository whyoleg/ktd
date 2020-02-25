package dev.whyoleg.ktd.api.updates

import dev.whyoleg.ktd.api.*
import kotlinx.serialization.*

@Serializable
sealed class TdUpdateFileGeneration : TdUpdate {
    /**
     * The file generation process needs to be started by the client
     *
     * @property generationId Unique identifier for the generation process
     * @property originalPath The path to a file from which a new file is generated
     * @property destinationPath The path to a file that should be created and where the new file should be generated
     * @property conversion String specifying the conversion applied to the original file
     *                      If conversion is "#url#" than original_path contains an HTTP/HTTPS URL of a file, which should be downloaded by the client
     */
    @Serializable
    @SerialName("updateFileGenerationStart")
    data class Start(
        @SerialName("generation_id")
        val generationId: Long,
        @SerialName("original_path")
        val originalPath: String?,
        @SerialName("destination_path")
        val destinationPath: String,
        @SerialName("conversion")
        val conversion: String
    ) : TdUpdateFileGeneration()

    /**
     * File generation is no longer needed
     *
     * @property generationId Unique identifier for the generation process
     */
    @Serializable
    @SerialName("updateFileGenerationStop")
    data class Stop(
        @SerialName("generation_id")
        val generationId: Long
    ) : TdUpdateFileGeneration()
}
