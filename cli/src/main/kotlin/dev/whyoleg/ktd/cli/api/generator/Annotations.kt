package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*

val serializableAnnotation = ClassName("kotlinx.serialization", "Serializable")
val serialNameAnnotation = ClassName("kotlinx.serialization", "SerialName")
fun serialName(string: String): AnnotationSpec = AnnotationSpec.builder(serialNameAnnotation).addMember("%S", string).build()

fun deprecated(
    message: String,
    replaceWith: String? = null,
    imports: List<String> = emptyList(),
    error: Boolean = false
): AnnotationSpec = AnnotationSpec.builder(ClassName("kotlin", "Deprecated"))
    .addMember("message = $message")
    .apply {
        if (replaceWith != null) addMember(
            "replaceWith = ReplaceWith(%S" + (if (imports.isNotEmpty()) imports.joinToString(", ", ", ") { "\"$it\"" } else "") + ")",
            replaceWith
        )
        addMember("level = DeprecationLevel." + if (error) "ERROR" else "WARNING")
    }.build()

fun suppress(vararg strings: String) =
    AnnotationSpec.builder(ClassName("kotlin", "Suppress")).apply {
        strings.forEach { addMember("\"$it\"") }
    }.build()

val suppressApi: AnnotationSpec = suppress("unused", "DEPRECATION")

val suppressDeprecationError = suppress("DEPRECATION_ERROR")
