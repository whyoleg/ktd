@file:UseSerializers(FileFromStringSerializer::class)

package dev.whyoleg.ktd.cli.tdlib.jvm

import kotlinx.serialization.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.internal.*
import java.io.*

@Serializable
data class TdConfig(
    val buildType: TdBuildType,
    val buildPath: File,
    val jniPath: File
)

enum class TdBuildType() {
    MinSizeRel,
    Release,
    Debug;

    fun windowsCmake(): String = " --config $name"
    fun dCmake(): String = "-DCMAKE_BUILD_TYPE=$name"
}

@Serializable
data class JniConfig(
    val cmakePath: String,
    val td: TdConfig,
    val linux: LinuxJniConfig?,
    val macos: MacosJniConfig?,
    val windows: WindowsJniConfig?,
    val android: AndroidJniConfig?
)

@Serializable
data class LinuxJniConfig(
    val llvmPath: File,
    val clangPath: File,
    val clangPlusPlusPath: File
)

@Serializable
data class MacosJniConfig(
    val opensslPath: File
)

@Serializable
data class WindowsJniConfig(
    val gperfPath: File,
    val vcpkgPath: File
)

@Serializable
data class AndroidJniConfig(
    val androidSdkPath: File,
    val opensslPath: File,
    val apiLevel: Int,
    val jdkPath: File,
    val ndkVersion: String?
)

@Serializer(File::class)
object FileFromStringSerializer : KSerializer<File> {
    override val descriptor: SerialDescriptor = SerialClassDescImpl("java.io.file")
    override fun deserialize(decoder: Decoder): File = File(decoder.decodeString())
    override fun serialize(encoder: Encoder, obj: File) {
        error("not needed")
    }
}
