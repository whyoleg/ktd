package dev.whyoleg.ktd.generator.tdlib

sealed class CurrentTarget<T : BuildTarget.Jvm>(val jvm: T) {
    object Linux : CurrentTarget<BuildTarget.Jvm.Linux>(BuildTarget.Jvm.Linux)
    object MacOS : CurrentTarget<BuildTarget.Jvm.MacOS>(BuildTarget.Jvm.MacOS)
    class Windows(jvm: BuildTarget.Jvm.Windows) : CurrentTarget<BuildTarget.Jvm.Windows>(jvm)
}

fun currentTarget(winArch: String? = null): CurrentTarget<*> {
    val os = System.getProperty("os.name").toLowerCase()
    return when {
        "linux" in os   -> CurrentTarget.Linux
        "mac" in os     -> CurrentTarget.MacOS
        "windows" in os -> CurrentTarget.Windows(if ("64" in winArch!!) BuildTarget.Jvm.Windows.X64 else BuildTarget.Jvm.Windows.X86)
        else            -> error("Can't build on: $os")
    }
}
