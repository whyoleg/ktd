package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import dev.whyoleg.ktd.cli.tl.*

fun newApi(meta: TlSchemeMetadata) {
    val (list, responses, requests) = meta

    val tdApiTypeAliasSpec = FileSpec.builder(pcg, "TdApiTypeAlias")

    list.forEach { data ->
        if (data.type !in existed && data.type != "Update") {
            tdApiTypeAliasSpec.addTypeAlias(
                TypeAliasSpec.builder("Td${data.type}", tdApiClass.nestedClass(data.type)).build()
            )
        }
    }
    tdApiTypeAliasSpec.writeDefault()
}
//Sealed
//val spec = if (data is TlAbstract) {
//                val sealedClasses = sealedResponses.getValue(data.type)
//                val sealedClassName = tdApiClass.nestedClass(data.type)
//                TypeSpec.classBuilder(sealedClassName)
//                    .addModifiers(KModifier.SEALED).apply {
//                        sealedClasses.forEach { sealedData ->
//                            addType(tdDataClass(sealedData) {
//                                constructor(sealedData.metadata)
//                                superclass(sealedClassName)
//                            })
//                        }
//                        when (data.type) {
//                            in responseTypes -> addSuperinterface(tdResponseClass)
//                            in requestsTypes -> addSuperinterface(tdRequestParameterized(requestsTypes.getValue(data.type)))
//                            else             -> addSuperinterface(tdObjectClass)
//                        }
//                    }.build()
//            }
