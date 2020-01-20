package dev.whyoleg.ktd.cli

import dev.whyoleg.ktd.cli.api.*
import dev.whyoleg.ktd.cli.diff.*
import dev.whyoleg.ktd.cli.tdlib.*
import kotlinx.cli.*

fun main(args: Array<String>) {
    parser().parse(args)
}

@UseExperimental(ExperimentalCli::class)
private fun parser() = ArgParser("ktd", prefixStyle = ArgParser.OPTION_PREFIX_STYLE.JVM).apply {
    subcommands(
        TdlibCommand(),
        ApiCommand(),
        DiffCommand(),
        CopyLibsCommand(),
        DispatchCommand()
    )
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
    val cmd = api
    val args = cmd.split(' ').toTypedArray()
    forEachVersion("dispatch -t tdlib")
    forEachVersion("api")
}

private fun String.cmd(): Array<String> = split(' ').toTypedArray()
private fun forEachVersion(cmd: String) {
    tdVersions.forEach {
        parser().parse("$cmd -v $it".cmd())
    }
}