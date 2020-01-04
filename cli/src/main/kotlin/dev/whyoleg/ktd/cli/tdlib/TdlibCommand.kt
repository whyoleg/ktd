package dev.whyoleg.ktd.cli.tdlib

import dev.whyoleg.ktd.cli.*
import dev.whyoleg.ktd.cli.tdlib.jvm.*
import io.github.cdimascio.dotenv.*
import kotlinx.cli.*
import java.io.*

//object Env {
//    val env: Map<String, String> = System.getenv()
//    val BUILD_TYPE by env.
//}

//BUILD_TYPE
//cmake
//ninja
//tdrepo
//jnidir
//output
//

object BuildPlatformArgType : ArgType<BuildPlatform>(true) {
    override val description: kotlin.String = "{ PlatformTarget }"
    override val conversion: (value: kotlin.String, name: kotlin.String) -> BuildPlatform = { value, _ ->
        BuildPlatform.values().find { it.name.contains(value, ignoreCase = true) } ?: error("Platform '$value' isn't supported")
    }
}

object BuildTargetArgType : ArgType<BuildTarget>(true) {
    private val allTargets = BuildPlatform.values().flatMap(BuildPlatform::targets).distinct()
    override val description: kotlin.String = "{ BuildTarget }"
    override val conversion: (value: kotlin.String, name: kotlin.String) -> BuildTarget = { value, _ ->
        allTargets.find { it.targetName.contains(value, ignoreCase = true) } ?: error("Target '$value' isn't supported")
    }
}

@UseExperimental(ExperimentalCli::class)
object TdlibCommand : DotenvCommand("tdlib") {
    private val platform by option(BuildPlatformArgType, "platform", "p", "Platform for build").required()
    private val target by option(BuildTargetArgType, "target", "t", "Target for build").required()
    private val version by option(ArgType.String, "version", "v", "Version of tdlib").required()

    override suspend fun execute(dotenv: Dotenv) {
        println("Start build tdlib $version for $platform/$target ")
        checkoutVersion(version)
        if (target !in platform.targets) error("Can't build tdlib for $platform/$target")
        val result = when (platform) {
            BuildPlatform.Jvm    -> {
                when (val t = target) {
                    BuildTarget.Linux      -> buildLinuxJni()
                    BuildTarget.MacOS      -> buildMacOSJni()
                    is BuildTarget.Windows -> buildWindowsJni(t)
                    is BuildTarget.Android -> {
                        val home = File("/home/whyme")
                        buildAndroid(
                            androidSdkPath = home.resolve("Android/Sdk"),
                            opensslPath = home.resolve("IdeaProjects/ktd/android-openssl"),
                            target = t
                        )
                    }
                    else                   -> null
                }
            }
            BuildPlatform.Js     -> TODO()
            BuildPlatform.Native -> TODO()
        }
        result?.toString(target)?.also(::println)
    }
}
