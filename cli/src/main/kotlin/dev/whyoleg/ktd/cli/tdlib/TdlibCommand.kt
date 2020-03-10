package dev.whyoleg.ktd.cli.tdlib

import com.typesafe.config.*
import dev.whyoleg.ktd.cli.tdlib.jvm.*
import kotlinx.cli.*
import kotlinx.coroutines.*
import kotlinx.serialization.config.*
import java.io.*

@OptIn(ExperimentalCli::class)
class TdlibCommand : Subcommand("tdlib", "Generate tdlib") {
    private val platform by option(BuildPlatformArgType, "platform", "p", "Platform for build").required()
    private val target by option(BuildTargetArgType, "target", "t", "Target for build").required()
    private val configPath by option(ArgType.String, "config", "c", "Path to .conf file").default("cli/tdlib.conf")

    override fun execute(): Unit = runBlocking {
        println("Start build TdLib for $platform/$target ")
        if (target !in platform.targets) error("Can't build TdLib for $platform/$target")
        when (platform) {
            BuildPlatform.Jvm -> {
                val config = config<JniConfig>("jni").also(::println)
                val execution = when (val t = target) {
                    BuildTarget.Linux      -> config.linux?.execution(config.td.buildType)
                    BuildTarget.MacOS      -> config.macos?.execution(config.td.buildType)
                    is BuildTarget.Windows -> config.windows?.execution(config.td.buildType, t)
                    is BuildTarget.Android -> config.android?.execution(config.td.buildType, t, config.linux)
                    else                   -> null
                }
                requireNotNull(execution) { "No config for $platform/$target" }
                val result = config.buildJni(execution)
                result.toString(target).also(::println)
            }
            BuildPlatform.Js     -> TODO()
            BuildPlatform.Native -> TODO()
        }
    }

    private inline fun <reified T> config(path: String): T = ConfigParser.parse(ConfigFactory.parseFile(File(configPath)).getConfig(path))
}

object BuildPlatformArgType : ArgType<BuildPlatform>(true) {
    override val description: kotlin.String = "{ PlatformTarget }"
    override fun convert(value: kotlin.String, name: kotlin.String): BuildPlatform =
        BuildPlatform.values().find { it.name.contains(value, ignoreCase = true) } ?: error("Platform '$value' isn't supported")
}

object BuildTargetArgType : ArgType<BuildTarget>(true) {
    private val allTargets = BuildPlatform.values().flatMap(BuildPlatform::targets).distinct()
    override val description: kotlin.String = "{ BuildTarget }"
    override fun convert(value: kotlin.String, name: kotlin.String): BuildTarget =
        allTargets.find { it.targetName.contains(value, ignoreCase = true) } ?: error("Target '$value' isn't supported")
}
