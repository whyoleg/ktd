package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*

val serializableAnnotation = ClassName("kotlinx.serialization", "Serializable")
val serialNameAnnotation = ClassName("kotlinx.serialization", "SerialName")
fun serialName(string: String): AnnotationSpec = AnnotationSpec.builder(serialNameAnnotation).addMember("%S", string).build()

fun deprecated(
    message: String,
    replaceWith: String? = null,
    vararg imports: String,
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
