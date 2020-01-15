package dev.whyoleg.ktd.cli

import dev.whyoleg.ktd.cli.api.*
import dev.whyoleg.ktd.cli.diff.*
import dev.whyoleg.ktd.cli.tdlib.*
import kotlinx.cli.*

@UseExperimental(ExperimentalCli::class)
fun main(args: Array<String>) {
    val parser = ArgParser("ktd", prefixStyle = ArgParser.OPTION_PREFIX_STYLE.JVM)
    parser.subcommands(TdlibCommand, ApiCommand, DiffCommand)
    parser.parse(args)
}

fun main2() {
    //example commands
    val api = arrayOf("api", "-v", "1.5.4", "-c", "config/api")
    val tdlibAndroid = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "android-armv7", "-c", "config/tdlib")
    val tdlibLinux = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "linux", "-c", "config/tdlib")
    val diff154 = arrayOf("diff", "-pv", "1.5.3", "-nv", "1.5.4", "-c", "config/tdlib")
    val tdlibWindows = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "win-x64", "-c", "cli/config/tdlib.default.conf")
    val args = tdlibWindows
}
