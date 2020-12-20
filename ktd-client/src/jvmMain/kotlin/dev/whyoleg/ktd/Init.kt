package dev.whyoleg.ktd

import dev.whyoleg.ktd.json.*
import java.io.*

internal actual fun initTdlib() {
    val os = System.getProperty("os.name")!!
    val arch = System.getProperty("os.arch")!!
    val vendor = System.getProperty("java.vendor")!!
    val target = "Target(os='$os', arch='$arch', vendor='$vendor')"

    when (vendor.contains("android", true)) {
        true -> runCatching { System.loadLibrary("tdjni") }
        else -> {
            val folder: String
            val libName: String
            val ext: String
            when {
                os.contains("linux", true)   -> {
                    folder = "linux"
                    libName = "libtdjni"
                    ext = "so"
                }
                os.contains("mac", true)     -> {
                    folder = "macos"
                    libName = "libtdjni"
                    ext = "dylib"
                }
                os.contains("windows", true) -> {
                    folder = if ("64" in arch) "win64" else "win86"
                    libName = "tdjni"
                    ext = "dll"
                }
                else                         -> error("$target is not supported")
            }
            val path = "libs/$folder/$libName.$ext"

            runCatching {
                when (System.getProperty("dew.whyoleg.ktd.loadTdlibFromFile")?.toBoolean()) {
                    true -> File(path)
                    else -> TdJson::class.java.getResourceAsStream(path).use { lib ->
                        File.createTempFile(libName, ".$ext").apply(File::deleteOnExit).apply {
                            outputStream().use { lib.copyTo(it) }
                        }
                    }
                }.absolutePath.let(System::load)
            }
        }
    }.onFailure {
        throw IllegalStateException("Can't load tdlib for $target", it)
    }
}
