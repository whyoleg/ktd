package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import java.io.*


fun file(name: String, packageName: String = pcg, module: String, block: FileSpec.Builder.() -> Unit) {
    FileSpec.builder(packageName, name).apply(block).writeDefault(module)
}

fun FileSpec.Builder.writeDefault(module: String): Unit =
    indent("    ").build().writeTo(File("api/$module/src/commonMain/kotlin"))
