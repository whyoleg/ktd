package dev.whyoleg.ktd.cli.builder

fun String.snakeToCamel(): String = split("_").joinToString("") { it.capitalize() }.decapitalize()
