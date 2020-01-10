package dev.whyoleg.ktd.cli.tdlib

import eu.jrie.jetbrains.kotlinshell.processes.process.*
import eu.jrie.jetbrains.kotlinshell.shell.*
import java.io.*
import kotlin.time.*

fun List<String>.join(): String = if (isEmpty()) "" else joinToString(" ", " ")

class Cmake(private val cmd: String) {
    suspend fun Shell.install(args: List<String>): Duration = exec("$cmd --build . --target install${args.join()}")
    suspend fun Shell.configure(args: List<String>): Duration = exec("$cmd${args.join()} ..")
}

suspend fun Shell.exec(cmd: String): Duration {
    val process = cmd.invoke()
    println(cmd)
    return process.measure()
}

fun Process.measure(): Duration {
    var duration = Duration.ZERO
    pcb.apply {
        startTime?.let { st ->
            endTime?.let { et ->
                duration = (et.toEpochMilli() - st.toEpochMilli()).milliseconds
                println("Execution time: $duration")
            }
        } ?: println("Can't measure execution time")
    }
    if (pcb.exitCode != 0) throw ExitCodeException(pcb.exitCode)
    return duration
}

suspend fun Cmake.run(buildDir: File, config: CmakeConfig): Pair<Duration, Duration> {
    var duration1: Duration? = null
    var duration2: Duration? = null
    shell(config.env, buildDir) {
        duration1 = configure(config.configureParams)
        duration2 = install(config.installParams)
    }
    return duration1!! to duration2!!
}

class CmakeExecutionResult(
    val buildConfiguration: Duration,
    val buildInstallation: Duration,
    val libConfiguration: Duration,
    val libInstallation: Duration,
    val lib: File
) {
    fun toString(target: BuildTarget): String = """
        Build for:           ${target::class.simpleName}
        Build configuration: $buildConfiguration
        Build installation:  $buildInstallation
        Lib configuration:   $libConfiguration
        Lib installation:    $libInstallation
        Lib:                 ${lib.name}
        Lib path:            ${lib.absolutePath}
        Lib size:            ${lib.mbSize()} mb
    """.trimIndent()
}

data class CmakeExecution(
    val build: CmakeConfig,
    val lib: CmakeConfig,
    val before: suspend () -> Unit = {},
    val after: suspend CmakeExecutionResult.() -> Unit = {}
)

fun CmakeExecution(
    config: CmakeConfig,
    before: suspend () -> Unit = {},
    after: suspend CmakeExecutionResult.() -> Unit = {}
): CmakeExecution = CmakeExecution(config, config, before, after)

operator fun CmakeExecution.plus(other: CmakeExecution) = CmakeExecution(
    build = CmakeConfig(
        env = build.env + other.build.env,
        configureParams = build.configureParams + other.build.configureParams,
        installParams = build.installParams + other.build.installParams
    ),
    lib = CmakeConfig(
        env = lib.env + other.lib.env,
        configureParams = lib.configureParams + other.lib.configureParams,
        installParams = lib.installParams + other.lib.installParams
    ),
    before = {
        before()
        other.before()
    },
    after = {
        after(this)
        other.after(this)
    }
)

data class CmakeConfig(
    val env: Map<String, String> = emptyMap(),
    val configureParams: List<String> = emptyList(),
    val installParams: List<String> = emptyList()
)

class ExitCodeException(exitCode: Int) : Throwable("Finished with exit code: $exitCode")


fun File.mbSize(): String = "%.2f".format(readBytes().size.toDouble() / 1024 / 1024)
