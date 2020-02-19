package dev.whyoleg.ktd.cli

fun String.snakeToCamel(): String = split("_").joinToString("") { it.capitalize() }.decapitalize()
