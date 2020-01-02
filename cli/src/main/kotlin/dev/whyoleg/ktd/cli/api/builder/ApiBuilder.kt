package dev.whyoleg.ktd.cli.api.builder

import dev.whyoleg.ktd.cli.builder.*
import dev.whyoleg.ktd.cli.tl.*

fun StringBuilder.buildApi(scheme: TlScheme) {
    suppress("unused")
    useExperimentalAnnotationsForFile()
    append("\n")
    buildPackage("api")
    append("\n")
    buildTypealias("TelegramObject", "TdApi.Object")
    buildTypealias("TelegramFunction", "TdApi.Function")
    buildTypealias("TelegramUpdate", "TdApi.Update")
    buildTypealias("TelegramError", "TdApi.Error")
    append("\n")
    append("class TdApi ")
    withCurlyBrackets {
        append("\n")
        append("abstract class Object ")
        withCurlyBrackets {
            append("external override fun toString(): String\n")
            append("abstract val constructor: Int")
        }
        append("\n")
        append("abstract class Function : Object() ")
        withCurlyBrackets {
            append("external override fun toString(): String")
        }
        scheme.data.forEach {
            append("\n")
            buildClass(it, scheme.metadata[it])
        }
    }
}

fun StringBuilder.useExperimentalAnnotationsForFile() {
    append("@file:UseExperimental")
    withRoundBrackets {
        TlAddition.annotations().joinTo(this, ",\n") {
            "${it.annotation}::class"
        }
    }
    append("\n")
}

fun StringBuilder.useExperimentalAnnotationForFile(annotation: TlAddition.Annotation) {
    append("@file:UseExperimental(").append(annotation.annotation).append("::class)")
}

fun StringBuilder.buildExperimentalAnnotation(annotation: TlAddition.Annotation) {
    append("@Experimental(level = Experimental.Level.WARNING)\n")
    append("annotation class ").append(annotation.annotation).append("\n")
}

fun StringBuilder.buildExperimentalAnnotations() {
    TlAddition.annotations().forEach {
        buildExperimentalAnnotation(it)
        append("\n")
    }
}

fun StringBuilder.buildExperimental() {
    buildPackage("api")
    append("\n")
    buildExperimentalAnnotations()
}
