package dev.whyoleg.ktd.api

interface TdState
interface TdClosed : TdState
interface TdClosing : TdState

interface TdUpdateState {
    val state: TdState
}
