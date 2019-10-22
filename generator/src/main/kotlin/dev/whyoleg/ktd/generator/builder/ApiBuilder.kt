package dev.whyoleg.ktd.generator.builder

import dev.whyoleg.ktd.generator.tl.*

fun StringBuilder.buildApi(dataList: List<TlData>) {
    useExperimentalAnnotationsForFile()
    append("\n")
    buildPackage("api")
    append("\n")
    buildTypealias("TelegramObject", "TdApi.Object")
    buildTypealias("TelegramFunction", "TdApi.Function")
    buildTypealias("TelegramUpdate", "TdApi.Update")
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
        val metadata = dataList.extractMetadata()
        dataList.forEach {
            append("\n")
            buildClass(it, metadata)
        }
    }
}

fun StringBuilder.useExperimentalAnnotationsForFile() {
    append("@file:UseExperimental")
    buildParameters(TlAddition.annotations().map { it.annotation + "::class" })
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
