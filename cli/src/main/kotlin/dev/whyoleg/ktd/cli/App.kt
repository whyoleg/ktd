package dev.whyoleg.ktd.cli

import dev.whyoleg.ktd.cli.api.*
import dev.whyoleg.ktd.cli.diff.*
import dev.whyoleg.ktd.cli.tdlib.*
import kotlinx.cli.*

@UseExperimental(ExperimentalCli::class)
fun main(args: Array<String>) {
    val cmd = "dispatch -v 1.5.0 -t tdlib"
    val args = cmd.split(' ').toTypedArray()
    val parser = ArgParser("ktd", prefixStyle = ArgParser.OPTION_PREFIX_STYLE.JVM)
    parser.subcommands(TdlibCommand, ApiCommand, DiffCommand, CopyLibsCommand, DispatchCommand())
    parser.parse(args)
}

fun main2() {
    //example commands
    val api = "api -v 1.5.4"
    val copyLibs = "copyLibs -v 1.5.4"
    val diff154 = "diff -pv 1.5.3 -nv 1.5.4"
    val dispatch = "dispatch -v 1.5.0 -t tdlib"
    val tdlibAndroid = "tdlib -v 1.5.1 -p jvm -t android-armv7"
    val tdlibLinux = "tdlib -v 1.5.1 -p jvm -t linux"
    val tdlibWindows = "tdlib -v 1.5.1 -p jvm -t win-x64"
}
