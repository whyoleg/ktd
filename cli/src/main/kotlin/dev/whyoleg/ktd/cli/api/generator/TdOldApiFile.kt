package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.tl.*

fun oldApiFile(typedScheme: TlTypedScheme) {
    file("TdApi", pcg, "migration/v060", "ktd-api-raw") {
        addAnnotation(AnnotationSpec.builder(ClassName("kotlin", "Suppress")).addMember("\"DEPRECATION_ERROR\"").build())
        //        addAnnotation(
        //            AnnotationSpec.builder(ClassName("kotlin", "Suppress"))
        //                .addMember("\"unused\"")
        //                .addMember("\"DEPRECATION\"")
        //                .build()
        //        )
        addProperty(
            PropertySpec.builder("abstractTdDeprecatedMessage", ClassName("kotlin", "String"))
                .addModifiers(KModifier.CONST)
                .initializer("%S", "Classes under TdApi will be removed in 0.6.1, use Td-prefixed typealises")
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
        addType(TypeSpec.objectBuilder(tdApiClass).apply {
            addAnnotation(
                deprecated(
                    "\"Deprecated, use one of [User,Bots,Core]TdApi instead. For user api - UserTdApi\"",
                    "UserTdApi",
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
            typedScheme.data.forEach { data ->
                val type = data.type(typedScheme)
                val spec = if (data is TlSealed) {
                    val sealedClassName = tdApiClass.nestedClass(data.type)
                    TypeSpec.classBuilder(sealedClassName)
                        .addModifiers(KModifier.ABSTRACT)
                        .setParents(data, typedScheme, old = true)
                        .addAnnotation(deprecated("abstractTdDeprecatedMessage", replaceWith = "Td${data.type}", error = true))
                        .build()
                } else tdDataType(data, type, old = true) {
                    setParents(data, typedScheme, old = true)
                    addAnnotation(deprecated("abstractTdDeprecatedMessage", replaceWith = "Td${data.type}", error = true))
                }
                addType(spec)
            }
        }.build())
    }
}

