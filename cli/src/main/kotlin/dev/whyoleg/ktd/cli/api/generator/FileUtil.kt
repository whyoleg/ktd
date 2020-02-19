package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*
import java.io.*

fun file(name: String, packageName: String, root: String, module: String, block: FileSpec.Builder.() -> Unit) {
    FileSpec.builder(packageName, name).apply(block).writeDefault(root, module)
}

fun FileSpec.Builder.writeDefault(root: String, module: String): Unit =
    indent("    ").build().writeTo(File("$root/$module/src/commonMain/kotlin"))
