package dev.whyoleg.ktd.api

interface TdState
interface TdClosed : TdState
interface TdClosing : TdState

interface TdStateUpdated {
    val state: TdState
}
