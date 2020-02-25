package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.api.updates.*
import kotlinx.serialization.modules.*

@Suppress("DEPRECATION_ERROR")
internal val botsApiBuilder: Lazy<SerialModule> = lazy {
    coreApiBuilder.value + SerializersModule {
        polymorphic<TdApiRequest> {
            addSubclass(TdCheckAuthenticationBotToken.serializer())
            addSubclass(TdEditMessageReplyMarkup.serializer())
            addSubclass(TdEditInlineMessageText.serializer())
            addSubclass(TdEditInlineMessageLiveLocation.serializer())
            addSubclass(TdEditInlineMessageMedia.serializer())
            addSubclass(TdEditInlineMessageCaption.serializer())
            addSubclass(TdEditInlineMessageReplyMarkup.serializer())
            addSubclass(TdAnswerInlineQuery.serializer())
            addSubclass(TdAnswerCallbackQuery.serializer())
            addSubclass(TdAnswerShippingQuery.serializer())
            addSubclass(TdAnswerPreCheckoutQuery.serializer())
            addSubclass(TdSetGameScore.serializer())
            addSubclass(TdSetInlineGameScore.serializer())
            addSubclass(TdGetGameHighScores.serializer())
            addSubclass(TdGetInlineGameHighScores.serializer())
            addSubclass(TdSetPassportElementErrors.serializer())
            addSubclass(TdSetBotUpdatesStatus.serializer())
            addSubclass(TdUploadStickerFile.serializer())
            addSubclass(TdCreateNewStickerSet.serializer())
            addSubclass(TdAddStickerToSet.serializer())
            addSubclass(TdSetStickerPositionInSet.serializer())
            addSubclass(TdRemoveStickerFromSet.serializer())
            addSubclass(TdSendCustomRequest.serializer())
            addSubclass(TdAnswerCustomQuery.serializer())
        }
        polymorphic(TdApiResponse::class, TdUpdate::class) {
            addSubclass(TdUpdateNewInlineQuery.serializer())
            addSubclass(TdUpdateNewChosenInlineResult.serializer())
            addSubclass(TdUpdateNewCallbackQuery.serializer())
            addSubclass(TdUpdateNewInlineCallbackQuery.serializer())
            addSubclass(TdUpdateNewShippingQuery.serializer())
            addSubclass(TdUpdateNewPreCheckoutQuery.serializer())
            addSubclass(TdUpdateNewCustomEvent.serializer())
            addSubclass(TdUpdateNewCustomQuery.serializer())
            addSubclass(TdUpdatePoll.serializer())
            addSubclass(TdUpdatePollAnswer.serializer())
        }
    }
}

