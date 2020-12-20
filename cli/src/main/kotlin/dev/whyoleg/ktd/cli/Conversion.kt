package dev.whyoleg.ktd.cli

fun String.snakeToCamel(): String = split("_").joinToString("") { it.capitalize() }.decapitalize()

fun <T : Any> List<T>.takeIfIsNotEmpty(): List<T>? = takeIf(List<T>::isNotEmpty)
