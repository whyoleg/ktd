package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.tl.*

fun oldApiFile(meta: TlSchemeMetadata) {
    val (list, responses, requests) = meta

    val tdApiSpec = TypeSpec.objectBuilder(tdApiClass).apply {
        superclass(ClassName("dev.whyoleg.ktd", "AnyTdApi"))
        addSuperclassConstructorParameter("\"1.5.0\"")
        addSuperclassConstructorParameter("apiBuilder")
        addAnnotation(AnnotationSpec.builder(ClassName("kotlin", "Suppress")).addMember("\"DEPRECATION_ERROR\"").build())
        addTypes(
            listOf(
                TypeSpec.classBuilder("Object")
                    .addModifiers(KModifier.ABSTRACT)
                    .addAnnotation(deprecated("\"Deprecated, use TdObject instead\"", "TdObject"))
                    .addSuperinterface(tdObjectClass)
                    .build(),
                TypeSpec.classBuilder("Function")
                    .addModifiers(KModifier.ABSTRACT)
                    .addAnnotation(deprecated("\"Deprecated, use TdApiRequest instead\"", "TdApiRequest"))
                    .superclass(ClassName.bestGuess("Object"))
                    .build()
            )
        )
    }

    list.forEach { data ->
        val type = data.type(responses, requests)
        val spec = if (data is TlAbstract) {
            val sealedClassName = tdApiClass.nestedClass(data.type)
            TypeSpec.classBuilder(sealedClassName)
                .addModifiers(KModifier.ABSTRACT) //TODO use sealed
                .addAnnotation(serializableAnnotation)
                .dataKdoc(data, false)
                .setParents(data, responses, requests)
                .addAnnotation(deprecated("abstractTdDeprecatedMessage", replaceWith = "Td${data.type}"))
                .build()
        } else tdDataType(data, type) {
            setParents(data, responses, requests)
            addAnnotation(deprecated("abstractTdDeprecatedMessage", replaceWith = "Td${data.type}"))
        }
        tdApiSpec.addType(spec)
    }

    file("TdApi") {
        addAnnotation(
            AnnotationSpec.builder(ClassName("kotlin", "Suppress"))
                .addMember("\"unused\"")
                .addMember("\"DEPRECATION\"")
                .build()
        )
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
                    addAnnotation(deprecated("\"Deprecated, use $newName instead\"", newName))
                }.build()
            )
        }
        addType(tdApiSpec.build())
    }
}