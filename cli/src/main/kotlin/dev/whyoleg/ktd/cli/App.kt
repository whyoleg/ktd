package dev.whyoleg.ktd.cli

import dev.whyoleg.ktd.cli.api.*
import dev.whyoleg.ktd.cli.diff.*
import dev.whyoleg.ktd.cli.tdlib.*
import kotlinx.cli.*

@UseExperimental(ExperimentalCli::class)
fun main(args: Array<String>) {
    //example commands
    val api = arrayOf("api", "-v", "1.5.4", "-e", "config/api")
    val tdlibAndroid = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "android-armv7", "-e", "config/tdlib")
    val tdlibLinux = arrayOf("tdlib", "-v", "1.5.1", "-p", "jvm", "-t", "linux", "-e", "config/tdlib")
    val diff154 = arrayOf("diff", "-pv", "1.5.3", "-nv", "1.5.4", "-e", "config/tdlib")
//    val args = diff154

    val parser = ArgParser("ktd", prefixStyle = ArgParser.OPTION_PREFIX_STYLE.JVM)
    parser.subcommands(TdlibCommand, ApiCommand, DiffCommand)
    parser.parse(args)
}
