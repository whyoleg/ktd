package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.tl.*

fun oldApiFile(typedScheme: TlTypedScheme) {
    file("TdApi", pcg, "migration/v060", "ktd-api-raw") {
        addAnnotation(AnnotationSpec.builder(ClassName("kotlin", "Suppress")).addMember("\"DEPRECATION_ERROR\"").build())
        addProperty(
            PropertySpec.builder("abstractTdDeprecatedMessage", ClassName("kotlin", "String"), KModifier.CONST, KModifier.PRIVATE)
                .initializer("%S", "Classes under TdApi will be removed in 0.6.1, use Td-prefixed classes under ReplaceWith")
                .build()
        )
        listOf("Object", "Function", "Update", "Error").forEach {
            addTypeAlias(
                TypeAliasSpec.builder("Telegram$it", ClassName(pcg, "TdApi.$it")).apply {
                    val newName = if (it == "Function") "TdApiRequest" else "Td$it"
                    addAnnotation(deprecated("\"Deprecated, use $newName instead\"", newName, error = true))
                }.build()
            )
        }
        addType(TypeSpec.classBuilder(tdApiClass).apply {
            addAnnotation(
                deprecated(
                    "\"Deprecated, use one of [User,Bots,Core]TdApi instead. For user api - UserTdApi\"",
                    error = true
                )
            )
            addTypes(
                listOf(
                    TypeSpec.classBuilder("Object")
                        .addModifiers(KModifier.ABSTRACT)
                        .addAnnotation(deprecated("\"Deprecated, use TdObject instead\"", "TdObject", error = true))
                        .addProperty(
                            PropertySpec.builder("constructor", ClassName("kotlin", "Int"))
                                .initializer("error(\"\")")
                                .addAnnotation(deprecated("\"Use `is` instead\"", error = true))
                                .build()
                        )
                        .build(),
                    TypeSpec.classBuilder("Function")
                        .addModifiers(KModifier.ABSTRACT)
                        .addAnnotation(deprecated("\"Deprecated, use TdApiRequest instead\"", "TdApiRequest", error = true))
                        .superclass(ClassName.bestGuess("Object"))
                        .build()
                )
            )
            typedScheme.run { objects + functions }.forEach { data ->
                tdDataType(data, data.type(typedScheme), old = true) {
                    setParents(data, typedScheme, old = true)
                    addAnnotation(deprecated("abstractTdDeprecatedMessage", replaceWith = "Td${data.type}", error = true))
                }.also(::addType)
            }
            typedScheme.sealed.forEach { (sealed, children) ->
                val sealedClassName = tdApiClass.nestedClass(sealed.type)
                TypeSpec.classBuilder(sealedClassName)
                    .addModifiers(KModifier.ABSTRACT)
                    .setParents(sealed, typedScheme, old = true)
                    .addAnnotation(deprecated("abstractTdDeprecatedMessage", replaceWith = "Td${sealed.type}", error = true))
                    .build()
                    .also(::addType)
                if (sealed.type == "Update") return@forEach
                children.forEach { child ->
                    tdDataType(child, child.type(typedScheme), old = true) {
                        setParents(child, typedScheme, old = true)
                        val newName = "Td${sealed.type}.${child.type.substringAfter(child.parentType)}"
                        addAnnotation(deprecated("abstractTdDeprecatedMessage", replaceWith = newName, error = true))
                    }.also(::addType)
                }
            }
            typedScheme.updates.forEach { (group, children) ->
                children.forEach { child ->
                    tdDataType(child, child.type(typedScheme), old = true) {
                        setParents(child, typedScheme, old = true)
                        val (updateName, newName) = if (group == null) {
                            "Td${child.type}" to "Td${child.type}"
                        } else {
                            val newType = child.type.substringAfter("Update")
                            val overrideName = when {
                                newType.startsWith("New") || newType.substringAfter(group).isBlank() -> "Data"
                                else                                                                 -> newType.substringAfter(group)
                            }
                            "TdUpdate$group" to "TdUpdate$group.${overrideName}"
                        }
                        addAnnotation(
                            deprecated(
                                "abstractTdDeprecatedMessage",
                                replaceWith = newName,
                                imports = listOf("$pcg.updates.${updateName}"),
                                error = true
                            )
                        )
                    }.also(::addType)
                }
            }
        }.build())
    }
}

