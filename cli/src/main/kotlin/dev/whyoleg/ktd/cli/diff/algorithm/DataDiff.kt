package dev.whyoleg.ktd.cli.diff.algorithm

import dev.whyoleg.ktd.cli.diff.data.*
import dev.whyoleg.ktd.cli.tl.*

infix fun List<TlAddition>.diff(new: List<TlAddition>): TlAdditionListDiff? = constructorDiff(
    new listDiff this,
    this listDiff new,
    ::TlAdditionListDiff
)

infix fun TlObject.diff(new: TlObject): TlObjectDiff? = constructorDiff(
    this.parentType typeDiff new.parentType,
    this.metadata diff new.metadata,
    ::TlObjectDiff,
    type
)

infix fun TlFunction.diff(new: TlFunction): TlFunctionDiff? = constructorDiff(
    this.returnType typeDiff new.returnType,
    this.metadata diff new.metadata,
    ::TlFunctionDiff,
    type
)

infix fun TlSealed.diff(new: TlSealed): TlSealedDiff? = constructorDiff(
    this.metadata diff new.metadata,
    ::TlSealedDiff,
    type
)

infix fun TlMetadata.diff(new: TlMetadata): TlMetadataDiff? = constructorDiff(
    this.descriptions diff new.descriptions,
    this.additions diff new.additions,
    this.properties diff new.properties,
    ::TlMetadataDiff
)

infix fun TlProperty.diff(new: TlProperty): TlPropertyDiff? = constructorDiff(
    this.type.kotlinType typeDiff new.type.kotlinType,
    this.descriptions diff new.descriptions,
    this.additions diff new.additions,
    ::TlPropertyDiff,
    name
)
