package dev.whyoleg.ktd.api

/**
 * Base interface for overall tdlib client state
 */
interface TdState

/**
 * Closing state of tdlib client.
 * All subsequent requests will return [TdError].
 * Soon tdlib client will become closed with state [TdClosed]
 */
interface TdClosing : TdState

/**
 * Closed state of tdlib client.
 * Resources of tdlib client will be cleared soon
 */
interface TdClosed : TdState

/**
 * Such update appeared when tdlib client state changed
 *
 * @property state state of tdlib client state
 */
interface TdUpdateState {
    val state: TdState
}
