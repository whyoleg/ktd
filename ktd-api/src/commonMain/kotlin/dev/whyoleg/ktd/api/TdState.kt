package dev.whyoleg.ktd.api

interface UpdateTdState {
    val state: TdState
}

interface TdState
interface TdClosed : TdState
interface TdClosing : TdState
