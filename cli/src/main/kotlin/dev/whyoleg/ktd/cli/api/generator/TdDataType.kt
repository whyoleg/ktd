package dev.whyoleg.ktd.cli.api.generator

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import dev.whyoleg.ktd.cli.tl.*

enum class TdDataType {
    Object,
    Response,
    Request,
    SyncRequest
}

fun TlData.type(typedScheme: TlTypedScheme): TdDataType = when {
    type in typedScheme.requestTypes.keys                                                                    -> when {
        TlAddition.Sync in metadata.additions -> TdDataType.SyncRequest
        else                                  -> TdDataType.Request
    }
    parentType != "Update" && (type in typedScheme.responseTypes || parentType in typedScheme.responseTypes) -> TdDataType.Response
    else                                                                                                     -> TdDataType.Object
}

fun TlType.className(nullable: Boolean, old: Boolean = false): TypeName = when (this) {
    is TlRefType       -> when (kotlinType) {
        "String" -> ClassName("kotlin", "String").copy(nullable = nullable)
        else     -> when (old) {
            true  -> tdApiClass.nestedClass(kotlinType).copy(nullable = nullable)
            false -> ClassName(pcg, "Td${kotlinType}").copy(nullable = nullable)
        }
    }
    is TlPrimitiveType -> ClassName("kotlin", kotlinType)
    is TlArrayType     -> when (type) {
        is TlPrimitiveType -> ClassName("kotlin", kotlinType)
        else               -> when (old) {
            true  -> ClassName("kotlin", "Array")
            false -> ClassName("kotlin.collections", "List")
        }.parameterizedBy(type.className(false, old))
    }
}
