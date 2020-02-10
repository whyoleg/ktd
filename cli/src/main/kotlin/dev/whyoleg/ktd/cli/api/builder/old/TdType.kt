package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import dev.whyoleg.ktd.cli.tl.*

enum class TdType {
    Object,
    Response,
    Request,
    SyncRequest,
    Update
}

fun TlData.type(
    responseTypes: Set<String>,
    requestsTypes: Map<String, String>
): TdType = when {
    type == "Update"                                     -> TdType.Update
    type in requestsTypes.keys                           -> when {
        TlAddition.Sync in metadata.additions -> TdType.SyncRequest
        else                                  -> TdType.Request
    }
    type in responseTypes || parentType in responseTypes -> TdType.Response
    else                                                 -> TdType.Object
}

fun TlType.className(nullable: Boolean): TypeName = when (this) {
    is TlRefType       -> ClassName(kotlinType.takeIf { it == "String" }?.let { "kotlin" } ?: "", kotlinType).copy(nullable = nullable)
    is TlPrimitiveType -> ClassName("kotlin", kotlinType)
    is TlArrayType     -> when (type) { //TODO use lists
        is TlPrimitiveType -> ClassName("kotlin", kotlinType)
        else               -> ClassName("kotlin", "Array").parameterizedBy(type.className(false))
    }
}
