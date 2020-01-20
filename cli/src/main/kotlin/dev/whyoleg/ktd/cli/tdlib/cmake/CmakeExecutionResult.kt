package dev.whyoleg.ktd.cli.tdlib.cmake

import dev.whyoleg.ktd.cli.tdlib.*
import java.io.*
import kotlin.time.*

class CmakeExecutionResult(
    val crossCompileConfiguration: Duration?,
    val crossCompileInstallation: Duration?,
    val buildConfiguration: Duration,
    val buildInstallation: Duration,
    val libConfiguration: Duration,
    val libInstallation: Duration,
    val lib: File
) {
    fun toString(target: BuildTarget): String = """
        Build for:                   ${target.targetName}
        Cross compile configuration: $crossCompileConfiguration
        Cross compile installation:  $crossCompileInstallation
        Build configuration:         $buildConfiguration
        Build installation:          $buildInstallation
        Lib configuration:           $libConfiguration
        Lib installation:            $libInstallation
        Lib:                         ${lib.name}
        Lib path:                    ${lib.absolutePath}
        Lib size:                    ${lib.mbSize()} mb
    """.trimIndent()
}

private fun File.mbSize(): String = "%.2f".format(readBytes().size.toDouble() / 1024 / 1024)
