package dev.whyoleg.ktd.cli.tdlib

import kotlinx.cli.*
import java.io.*

@UseExperimental(ExperimentalCli::class)
class CopyLibsCommand : Subcommand("copyLibs") {
    private val version by option(ArgType.String, "version", "v", "Version of TdLib").required()
    private val libsFolder by option(ArgType.String, "libsFolder", "lf", "Folder with generated libs").default("libs")

    override fun execute() {
        val libs = File(libsFolder).listFiles()!!.associateBy { it.name.toLowerCase() }
        val sourceFolder = File("api/lib/v$version/src")

        copyLibs(
            libs,
            sourceFolder.resolve("jvmMain/jniLibs"),
            listOf(BuildTarget.Linux, BuildTarget.MacOS) + BuildTarget.Windows.values(),
            jvmBindings
        )

        copyLibs(
            libs,
            sourceFolder.resolve("androidMain/jniLibs"),
            BuildTarget.Android.values().toList(),
            androidBindings
        )

    }

    private fun copyLibs(libs: Map<String, File>, outputFolder: File, targets: List<BuildTarget>, bindings: Map<out BuildTarget, String>) {
        val targetLibs = targets.associateWith { libs.getValue(it.targetName.toLowerCase()) }
        targetLibs.forEach { (target, folder) ->
            val libFile = folder.listFiles()!!.first()
            val targetFile = outputFolder.resolve(bindings[target]!!).resolve(libFile.name)
            libFile.copyTo(targetFile)
        }
    }

    private val jvmBindings = mapOf(
        BuildTarget.Linux to "linux",
        BuildTarget.MacOS to "macos",
        BuildTarget.Windows.X86 to "win86",
        BuildTarget.Windows.X64 to "win64"
    )
    private val androidBindings = BuildTarget.Android.values().toList().associateWith(BuildTarget.Android::archName)
}
