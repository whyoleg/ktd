package dev.whyoleg.ktd.cli.api.builder.old

import com.squareup.kotlinpoet.*
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy

val tdApiClass = ClassName(pcg, "TdApi")
val tdResponseClass = ClassName(pcg, "TdResponse")
val tdUpdateClass = ClassName(pcg, "TdUpdate")
val tdObjectClass = ClassName(pcg, "TdObject")
val tdRequestClass = ClassName(pcg, "TdRequest")
val tdSyncRequestClass = ClassName(pcg, "TdSyncRequest")
fun tdRequestParameterized(t: String) = tdRequestClass.parameterizedBy(ClassName("", t))
fun tdSyncRequestParameterized(t: String) = tdSyncRequestClass.parameterizedBy(ClassName("", t))
