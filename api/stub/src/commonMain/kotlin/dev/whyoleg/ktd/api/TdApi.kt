package dev.whyoleg.ktd.api

typealias TelegramObject = TdApi.Object
typealias TelegramFunction = TdApi.Function
typealias TelegramUpdate = TdApi.Update
typealias TelegramError = TdApi.Error

class TdApi {
    abstract class Object {
        external override fun toString(): String
        abstract val constructor: Int
    }

    abstract class Function : Object() {
        external override fun toString(): String
    }

    class Error(val code: Int, val message: String) : Object() {
        override val constructor: Int get() = 0
    }

    abstract class Update : Object()
}
