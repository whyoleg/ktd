package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import java.io.*


fun file(name: String, block: FileSpec.Builder.() -> Unit) {
    FileSpec.builder(pcg, name).apply(block).writeDefault()
}

fun FileSpec.Builder.writeDefault() {
    indent("    ")
    addAnnotation(
        AnnotationSpec.builder(ClassName("kotlin", "UseExperimental"))
            .addMember("TdBotsOnly::class")
            .addMember("TdTestOnly::class")
            .build()
    )
    build().writeTo(File("ktd-api/src/commonMain/kotlin"))
}
