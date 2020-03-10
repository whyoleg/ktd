package dev.whyoleg.ktd.api

import dev.whyoleg.ktd.api.updates.*
import kotlinx.serialization.modules.*

@Suppress("DEPRECATION_ERROR")
internal val botsApiBuilder: Lazy<SerialModule> = lazy {
    coreApiBuilder.value + SerializersModule {
        polymorphic<TdApiRequest> {
            subclass(TdCheckAuthenticationBotToken.serializer())
            subclass(TdEditMessageReplyMarkup.serializer())
            subclass(TdEditInlineMessageText.serializer())
            subclass(TdEditInlineMessageLiveLocation.serializer())
            subclass(TdEditInlineMessageMedia.serializer())
            subclass(TdEditInlineMessageCaption.serializer())
            subclass(TdEditInlineMessageReplyMarkup.serializer())
            subclass(TdAnswerInlineQuery.serializer())
            subclass(TdAnswerCallbackQuery.serializer())
            subclass(TdAnswerShippingQuery.serializer())
            subclass(TdAnswerPreCheckoutQuery.serializer())
            subclass(TdSetGameScore.serializer())
            subclass(TdSetInlineGameScore.serializer())
            subclass(TdGetGameHighScores.serializer())
            subclass(TdGetInlineGameHighScores.serializer())
            subclass(TdSetPassportElementErrors.serializer())
            subclass(TdSetBotUpdatesStatus.serializer())
            subclass(TdUploadStickerFile.serializer())
            subclass(TdCreateNewStickerSet.serializer())
            subclass(TdAddStickerToSet.serializer())
            subclass(TdSetStickerPositionInSet.serializer())
            subclass(TdRemoveStickerFromSet.serializer())
            subclass(TdSendCustomRequest.serializer())
            subclass(TdAnswerCustomQuery.serializer())
        }
        polymorphic(TdApiResponse::class, TdUpdate::class) {
            subclass(TdUpdateNewInlineQuery.serializer())
            subclass(TdUpdateNewChosenInlineResult.serializer())
            subclass(TdUpdateNewCallbackQuery.serializer())
            subclass(TdUpdateNewInlineCallbackQuery.serializer())
            subclass(TdUpdateNewShippingQuery.serializer())
            subclass(TdUpdateNewPreCheckoutQuery.serializer())
            subclass(TdUpdateNewCustomEvent.serializer())
            subclass(TdUpdateNewCustomQuery.serializer())
            subclass(TdUpdatePoll.serializer())
            subclass(TdUpdatePollAnswer.serializer())
        }
    }
}

