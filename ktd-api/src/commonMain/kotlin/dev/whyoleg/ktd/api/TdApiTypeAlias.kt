@file:UseExperimental(
    TdBotsOnly::class,
    TdTestOnly::class
)

package dev.whyoleg.ktd.api

typealias TdTdlibParameters = TdApi.TdlibParameters

typealias TdAuthenticationCodeType = TdApi.AuthenticationCodeType

typealias TdAuthenticationCodeTypeTelegramMessage = TdApi.AuthenticationCodeTypeTelegramMessage

typealias TdAuthenticationCodeTypeSms = TdApi.AuthenticationCodeTypeSms

typealias TdAuthenticationCodeTypeCall = TdApi.AuthenticationCodeTypeCall

typealias TdAuthenticationCodeTypeFlashCall = TdApi.AuthenticationCodeTypeFlashCall

typealias TdAuthenticationCodeInfo = TdApi.AuthenticationCodeInfo

typealias TdEmailAddressAuthenticationCodeInfo = TdApi.EmailAddressAuthenticationCodeInfo

typealias TdTextEntity = TdApi.TextEntity

typealias TdTextEntities = TdApi.TextEntities

typealias TdFormattedText = TdApi.FormattedText

typealias TdTermsOfService = TdApi.TermsOfService

typealias TdAuthorizationState = TdApi.AuthorizationState

typealias TdAuthorizationStateWaitTdlibParameters = TdApi.AuthorizationStateWaitTdlibParameters

typealias TdAuthorizationStateWaitEncryptionKey = TdApi.AuthorizationStateWaitEncryptionKey

typealias TdAuthorizationStateWaitPhoneNumber = TdApi.AuthorizationStateWaitPhoneNumber

typealias TdAuthorizationStateWaitCode = TdApi.AuthorizationStateWaitCode

typealias TdAuthorizationStateWaitRegistration = TdApi.AuthorizationStateWaitRegistration

typealias TdAuthorizationStateWaitPassword = TdApi.AuthorizationStateWaitPassword

typealias TdAuthorizationStateReady = TdApi.AuthorizationStateReady

typealias TdAuthorizationStateLoggingOut = TdApi.AuthorizationStateLoggingOut

typealias TdAuthorizationStateClosing = TdApi.AuthorizationStateClosing

typealias TdAuthorizationStateClosed = TdApi.AuthorizationStateClosed

typealias TdPasswordState = TdApi.PasswordState

typealias TdRecoveryEmailAddress = TdApi.RecoveryEmailAddress

typealias TdTemporaryPasswordState = TdApi.TemporaryPasswordState

typealias TdLocalFile = TdApi.LocalFile

typealias TdRemoteFile = TdApi.RemoteFile

typealias TdFile = TdApi.File

typealias TdInputFile = TdApi.InputFile

typealias TdInputFileId = TdApi.InputFileId

typealias TdInputFileRemote = TdApi.InputFileRemote

typealias TdInputFileLocal = TdApi.InputFileLocal

typealias TdInputFileGenerated = TdApi.InputFileGenerated

typealias TdPhotoSize = TdApi.PhotoSize

typealias TdMinithumbnail = TdApi.Minithumbnail

typealias TdMaskPoint = TdApi.MaskPoint

typealias TdMaskPointForehead = TdApi.MaskPointForehead

typealias TdMaskPointEyes = TdApi.MaskPointEyes

typealias TdMaskPointMouth = TdApi.MaskPointMouth

typealias TdMaskPointChin = TdApi.MaskPointChin

typealias TdMaskPosition = TdApi.MaskPosition

typealias TdPollOption = TdApi.PollOption

typealias TdAnimation = TdApi.Animation

typealias TdAudio = TdApi.Audio

typealias TdDocument = TdApi.Document

typealias TdPhoto = TdApi.Photo

typealias TdSticker = TdApi.Sticker

typealias TdVideo = TdApi.Video

typealias TdVideoNote = TdApi.VideoNote

typealias TdVoiceNote = TdApi.VoiceNote

typealias TdContact = TdApi.Contact

typealias TdLocation = TdApi.Location

typealias TdVenue = TdApi.Venue

typealias TdGame = TdApi.Game

typealias TdPoll = TdApi.Poll

typealias TdProfilePhoto = TdApi.ProfilePhoto

typealias TdChatPhoto = TdApi.ChatPhoto

typealias TdLinkState = TdApi.LinkState

typealias TdLinkStateNone = TdApi.LinkStateNone

typealias TdLinkStateKnowsPhoneNumber = TdApi.LinkStateKnowsPhoneNumber

typealias TdLinkStateIsContact = TdApi.LinkStateIsContact

typealias TdUserType = TdApi.UserType

typealias TdUserTypeRegular = TdApi.UserTypeRegular

typealias TdUserTypeDeleted = TdApi.UserTypeDeleted

typealias TdUserTypeBot = TdApi.UserTypeBot

typealias TdUserTypeUnknown = TdApi.UserTypeUnknown

typealias TdBotCommand = TdApi.BotCommand

typealias TdBotInfo = TdApi.BotInfo

typealias TdUser = TdApi.User

typealias TdUserFullInfo = TdApi.UserFullInfo

typealias TdUserProfilePhoto = TdApi.UserProfilePhoto

typealias TdUserProfilePhotos = TdApi.UserProfilePhotos

typealias TdUsers = TdApi.Users

typealias TdChatPermissions = TdApi.ChatPermissions

typealias TdChatMemberStatus = TdApi.ChatMemberStatus

typealias TdChatMemberStatusCreator = TdApi.ChatMemberStatusCreator

typealias TdChatMemberStatusAdministrator = TdApi.ChatMemberStatusAdministrator

typealias TdChatMemberStatusMember = TdApi.ChatMemberStatusMember

typealias TdChatMemberStatusRestricted = TdApi.ChatMemberStatusRestricted

typealias TdChatMemberStatusLeft = TdApi.ChatMemberStatusLeft

typealias TdChatMemberStatusBanned = TdApi.ChatMemberStatusBanned

typealias TdChatMember = TdApi.ChatMember

typealias TdChatMembers = TdApi.ChatMembers

typealias TdChatMembersFilter = TdApi.ChatMembersFilter

typealias TdChatMembersFilterContacts = TdApi.ChatMembersFilterContacts

typealias TdChatMembersFilterAdministrators = TdApi.ChatMembersFilterAdministrators

typealias TdChatMembersFilterMembers = TdApi.ChatMembersFilterMembers

typealias TdChatMembersFilterRestricted = TdApi.ChatMembersFilterRestricted

typealias TdChatMembersFilterBanned = TdApi.ChatMembersFilterBanned

typealias TdChatMembersFilterBots = TdApi.ChatMembersFilterBots

typealias TdSupergroupMembersFilter = TdApi.SupergroupMembersFilter

typealias TdSupergroupMembersFilterRecent = TdApi.SupergroupMembersFilterRecent

typealias TdSupergroupMembersFilterContacts = TdApi.SupergroupMembersFilterContacts

typealias TdSupergroupMembersFilterAdministrators = TdApi.SupergroupMembersFilterAdministrators

typealias TdSupergroupMembersFilterSearch = TdApi.SupergroupMembersFilterSearch

typealias TdSupergroupMembersFilterRestricted = TdApi.SupergroupMembersFilterRestricted

typealias TdSupergroupMembersFilterBanned = TdApi.SupergroupMembersFilterBanned

typealias TdSupergroupMembersFilterBots = TdApi.SupergroupMembersFilterBots

typealias TdBasicGroup = TdApi.BasicGroup

typealias TdBasicGroupFullInfo = TdApi.BasicGroupFullInfo

typealias TdSupergroup = TdApi.Supergroup

typealias TdSupergroupFullInfo = TdApi.SupergroupFullInfo

typealias TdSecretChatState = TdApi.SecretChatState

typealias TdSecretChatStatePending = TdApi.SecretChatStatePending

typealias TdSecretChatStateReady = TdApi.SecretChatStateReady

typealias TdSecretChatStateClosed = TdApi.SecretChatStateClosed

typealias TdSecretChat = TdApi.SecretChat

typealias TdMessageForwardOrigin = TdApi.MessageForwardOrigin

typealias TdMessageForwardOriginUser = TdApi.MessageForwardOriginUser

typealias TdMessageForwardOriginHiddenUser = TdApi.MessageForwardOriginHiddenUser

typealias TdMessageForwardOriginChannel = TdApi.MessageForwardOriginChannel

typealias TdMessageForwardInfo = TdApi.MessageForwardInfo

typealias TdMessageSendingState = TdApi.MessageSendingState

typealias TdMessageSendingStatePending = TdApi.MessageSendingStatePending

typealias TdMessageSendingStateFailed = TdApi.MessageSendingStateFailed

typealias TdMessage = TdApi.Message

typealias TdMessages = TdApi.Messages

typealias TdFoundMessages = TdApi.FoundMessages

typealias TdNotificationSettingsScope = TdApi.NotificationSettingsScope

typealias TdNotificationSettingsScopePrivateChats = TdApi.NotificationSettingsScopePrivateChats

typealias TdNotificationSettingsScopeGroupChats = TdApi.NotificationSettingsScopeGroupChats

typealias TdNotificationSettingsScopeChannelChats = TdApi.NotificationSettingsScopeChannelChats

typealias TdChatNotificationSettings = TdApi.ChatNotificationSettings

typealias TdScopeNotificationSettings = TdApi.ScopeNotificationSettings

typealias TdDraftMessage = TdApi.DraftMessage

typealias TdChatType = TdApi.ChatType

typealias TdChatTypePrivate = TdApi.ChatTypePrivate

typealias TdChatTypeBasicGroup = TdApi.ChatTypeBasicGroup

typealias TdChatTypeSupergroup = TdApi.ChatTypeSupergroup

typealias TdChatTypeSecret = TdApi.ChatTypeSecret

typealias TdChat = TdApi.Chat

typealias TdChats = TdApi.Chats

typealias TdChatInviteLink = TdApi.ChatInviteLink

typealias TdChatInviteLinkInfo = TdApi.ChatInviteLinkInfo

typealias TdKeyboardButtonType = TdApi.KeyboardButtonType

typealias TdKeyboardButtonTypeText = TdApi.KeyboardButtonTypeText

typealias TdKeyboardButtonTypeRequestPhoneNumber = TdApi.KeyboardButtonTypeRequestPhoneNumber

typealias TdKeyboardButtonTypeRequestLocation = TdApi.KeyboardButtonTypeRequestLocation

typealias TdKeyboardButton = TdApi.KeyboardButton

typealias TdInlineKeyboardButtonType = TdApi.InlineKeyboardButtonType

typealias TdInlineKeyboardButtonTypeUrl = TdApi.InlineKeyboardButtonTypeUrl

typealias TdInlineKeyboardButtonTypeLoginUrl = TdApi.InlineKeyboardButtonTypeLoginUrl

typealias TdInlineKeyboardButtonTypeCallback = TdApi.InlineKeyboardButtonTypeCallback

typealias TdInlineKeyboardButtonTypeCallbackGame = TdApi.InlineKeyboardButtonTypeCallbackGame

typealias TdInlineKeyboardButtonTypeSwitchInline = TdApi.InlineKeyboardButtonTypeSwitchInline

typealias TdInlineKeyboardButtonTypeBuy = TdApi.InlineKeyboardButtonTypeBuy

typealias TdInlineKeyboardButton = TdApi.InlineKeyboardButton

typealias TdReplyMarkup = TdApi.ReplyMarkup

typealias TdReplyMarkupRemoveKeyboard = TdApi.ReplyMarkupRemoveKeyboard

typealias TdReplyMarkupForceReply = TdApi.ReplyMarkupForceReply

typealias TdReplyMarkupShowKeyboard = TdApi.ReplyMarkupShowKeyboard

typealias TdReplyMarkupInlineKeyboard = TdApi.ReplyMarkupInlineKeyboard

typealias TdRichText = TdApi.RichText

typealias TdRichTextPlain = TdApi.RichTextPlain

typealias TdRichTextBold = TdApi.RichTextBold

typealias TdRichTextItalic = TdApi.RichTextItalic

typealias TdRichTextUnderline = TdApi.RichTextUnderline

typealias TdRichTextStrikethrough = TdApi.RichTextStrikethrough

typealias TdRichTextFixed = TdApi.RichTextFixed

typealias TdRichTextUrl = TdApi.RichTextUrl

typealias TdRichTextEmailAddress = TdApi.RichTextEmailAddress

typealias TdRichTextSubscript = TdApi.RichTextSubscript

typealias TdRichTextSuperscript = TdApi.RichTextSuperscript

typealias TdRichTextMarked = TdApi.RichTextMarked

typealias TdRichTextPhoneNumber = TdApi.RichTextPhoneNumber

typealias TdRichTextIcon = TdApi.RichTextIcon

typealias TdRichTextAnchor = TdApi.RichTextAnchor

typealias TdRichTexts = TdApi.RichTexts

typealias TdPageBlockCaption = TdApi.PageBlockCaption

typealias TdPageBlockListItem = TdApi.PageBlockListItem

typealias TdPageBlockHorizontalAlignment = TdApi.PageBlockHorizontalAlignment

typealias TdPageBlockHorizontalAlignmentLeft = TdApi.PageBlockHorizontalAlignmentLeft

typealias TdPageBlockHorizontalAlignmentCenter = TdApi.PageBlockHorizontalAlignmentCenter

typealias TdPageBlockHorizontalAlignmentRight = TdApi.PageBlockHorizontalAlignmentRight

typealias TdPageBlockVerticalAlignment = TdApi.PageBlockVerticalAlignment

typealias TdPageBlockVerticalAlignmentTop = TdApi.PageBlockVerticalAlignmentTop

typealias TdPageBlockVerticalAlignmentMiddle = TdApi.PageBlockVerticalAlignmentMiddle

typealias TdPageBlockVerticalAlignmentBottom = TdApi.PageBlockVerticalAlignmentBottom

typealias TdPageBlockTableCell = TdApi.PageBlockTableCell

typealias TdPageBlockRelatedArticle = TdApi.PageBlockRelatedArticle

typealias TdPageBlock = TdApi.PageBlock

typealias TdPageBlockTitle = TdApi.PageBlockTitle

typealias TdPageBlockSubtitle = TdApi.PageBlockSubtitle

typealias TdPageBlockAuthorDate = TdApi.PageBlockAuthorDate

typealias TdPageBlockHeader = TdApi.PageBlockHeader

typealias TdPageBlockSubheader = TdApi.PageBlockSubheader

typealias TdPageBlockKicker = TdApi.PageBlockKicker

typealias TdPageBlockParagraph = TdApi.PageBlockParagraph

typealias TdPageBlockPreformatted = TdApi.PageBlockPreformatted

typealias TdPageBlockFooter = TdApi.PageBlockFooter

typealias TdPageBlockDivider = TdApi.PageBlockDivider

typealias TdPageBlockAnchor = TdApi.PageBlockAnchor

typealias TdPageBlockList = TdApi.PageBlockList

typealias TdPageBlockBlockQuote = TdApi.PageBlockBlockQuote

typealias TdPageBlockPullQuote = TdApi.PageBlockPullQuote

typealias TdPageBlockAnimation = TdApi.PageBlockAnimation

typealias TdPageBlockAudio = TdApi.PageBlockAudio

typealias TdPageBlockPhoto = TdApi.PageBlockPhoto

typealias TdPageBlockVideo = TdApi.PageBlockVideo

typealias TdPageBlockCover = TdApi.PageBlockCover

typealias TdPageBlockEmbedded = TdApi.PageBlockEmbedded

typealias TdPageBlockEmbeddedPost = TdApi.PageBlockEmbeddedPost

typealias TdPageBlockCollage = TdApi.PageBlockCollage

typealias TdPageBlockSlideshow = TdApi.PageBlockSlideshow

typealias TdPageBlockChatLink = TdApi.PageBlockChatLink

typealias TdPageBlockTable = TdApi.PageBlockTable

typealias TdPageBlockDetails = TdApi.PageBlockDetails

typealias TdPageBlockRelatedArticles = TdApi.PageBlockRelatedArticles

typealias TdPageBlockMap = TdApi.PageBlockMap

typealias TdWebPageInstantView = TdApi.WebPageInstantView

typealias TdWebPage = TdApi.WebPage

typealias TdAddress = TdApi.Address

typealias TdLabeledPricePart = TdApi.LabeledPricePart

typealias TdInvoice = TdApi.Invoice

typealias TdOrderInfo = TdApi.OrderInfo

typealias TdShippingOption = TdApi.ShippingOption

typealias TdSavedCredentials = TdApi.SavedCredentials

typealias TdInputCredentials = TdApi.InputCredentials

typealias TdInputCredentialsSaved = TdApi.InputCredentialsSaved

typealias TdInputCredentialsNew = TdApi.InputCredentialsNew

typealias TdInputCredentialsAndroidPay = TdApi.InputCredentialsAndroidPay

typealias TdInputCredentialsApplePay = TdApi.InputCredentialsApplePay

typealias TdPaymentsProviderStripe = TdApi.PaymentsProviderStripe

typealias TdPaymentForm = TdApi.PaymentForm

typealias TdValidatedOrderInfo = TdApi.ValidatedOrderInfo

typealias TdPaymentResult = TdApi.PaymentResult

typealias TdPaymentReceipt = TdApi.PaymentReceipt

typealias TdDatedFile = TdApi.DatedFile

typealias TdPassportElementType = TdApi.PassportElementType

typealias TdPassportElementTypePersonalDetails = TdApi.PassportElementTypePersonalDetails

typealias TdPassportElementTypePassport = TdApi.PassportElementTypePassport

typealias TdPassportElementTypeDriverLicense = TdApi.PassportElementTypeDriverLicense

typealias TdPassportElementTypeIdentityCard = TdApi.PassportElementTypeIdentityCard

typealias TdPassportElementTypeInternalPassport = TdApi.PassportElementTypeInternalPassport

typealias TdPassportElementTypeAddress = TdApi.PassportElementTypeAddress

typealias TdPassportElementTypeUtilityBill = TdApi.PassportElementTypeUtilityBill

typealias TdPassportElementTypeBankStatement = TdApi.PassportElementTypeBankStatement

typealias TdPassportElementTypeRentalAgreement = TdApi.PassportElementTypeRentalAgreement

typealias TdPassportElementTypePassportRegistration = TdApi.PassportElementTypePassportRegistration

typealias TdPassportElementTypeTemporaryRegistration =
        TdApi.PassportElementTypeTemporaryRegistration

typealias TdPassportElementTypePhoneNumber = TdApi.PassportElementTypePhoneNumber

typealias TdPassportElementTypeEmailAddress = TdApi.PassportElementTypeEmailAddress

typealias TdDate = TdApi.Date

typealias TdPersonalDetails = TdApi.PersonalDetails

typealias TdIdentityDocument = TdApi.IdentityDocument

typealias TdInputIdentityDocument = TdApi.InputIdentityDocument

typealias TdPersonalDocument = TdApi.PersonalDocument

typealias TdInputPersonalDocument = TdApi.InputPersonalDocument

typealias TdPassportElement = TdApi.PassportElement

typealias TdPassportElementPersonalDetails = TdApi.PassportElementPersonalDetails

typealias TdPassportElementPassport = TdApi.PassportElementPassport

typealias TdPassportElementDriverLicense = TdApi.PassportElementDriverLicense

typealias TdPassportElementIdentityCard = TdApi.PassportElementIdentityCard

typealias TdPassportElementInternalPassport = TdApi.PassportElementInternalPassport

typealias TdPassportElementAddress = TdApi.PassportElementAddress

typealias TdPassportElementUtilityBill = TdApi.PassportElementUtilityBill

typealias TdPassportElementBankStatement = TdApi.PassportElementBankStatement

typealias TdPassportElementRentalAgreement = TdApi.PassportElementRentalAgreement

typealias TdPassportElementPassportRegistration = TdApi.PassportElementPassportRegistration

typealias TdPassportElementTemporaryRegistration = TdApi.PassportElementTemporaryRegistration

typealias TdPassportElementPhoneNumber = TdApi.PassportElementPhoneNumber

typealias TdPassportElementEmailAddress = TdApi.PassportElementEmailAddress

typealias TdInputPassportElement = TdApi.InputPassportElement

typealias TdInputPassportElementPersonalDetails = TdApi.InputPassportElementPersonalDetails

typealias TdInputPassportElementPassport = TdApi.InputPassportElementPassport

typealias TdInputPassportElementDriverLicense = TdApi.InputPassportElementDriverLicense

typealias TdInputPassportElementIdentityCard = TdApi.InputPassportElementIdentityCard

typealias TdInputPassportElementInternalPassport = TdApi.InputPassportElementInternalPassport

typealias TdInputPassportElementAddress = TdApi.InputPassportElementAddress

typealias TdInputPassportElementUtilityBill = TdApi.InputPassportElementUtilityBill

typealias TdInputPassportElementBankStatement = TdApi.InputPassportElementBankStatement

typealias TdInputPassportElementRentalAgreement = TdApi.InputPassportElementRentalAgreement

typealias TdInputPassportElementPassportRegistration =
        TdApi.InputPassportElementPassportRegistration

typealias TdInputPassportElementTemporaryRegistration =
        TdApi.InputPassportElementTemporaryRegistration

typealias TdInputPassportElementPhoneNumber = TdApi.InputPassportElementPhoneNumber

typealias TdInputPassportElementEmailAddress = TdApi.InputPassportElementEmailAddress

typealias TdPassportElements = TdApi.PassportElements

typealias TdPassportElementErrorSource = TdApi.PassportElementErrorSource

typealias TdPassportElementErrorSourceUnspecified = TdApi.PassportElementErrorSourceUnspecified

typealias TdPassportElementErrorSourceDataField = TdApi.PassportElementErrorSourceDataField

typealias TdPassportElementErrorSourceFrontSide = TdApi.PassportElementErrorSourceFrontSide

typealias TdPassportElementErrorSourceReverseSide = TdApi.PassportElementErrorSourceReverseSide

typealias TdPassportElementErrorSourceSelfie = TdApi.PassportElementErrorSourceSelfie

typealias TdPassportElementErrorSourceTranslationFile =
        TdApi.PassportElementErrorSourceTranslationFile

typealias TdPassportElementErrorSourceTranslationFiles =
        TdApi.PassportElementErrorSourceTranslationFiles

typealias TdPassportElementErrorSourceFile = TdApi.PassportElementErrorSourceFile

typealias TdPassportElementErrorSourceFiles = TdApi.PassportElementErrorSourceFiles

typealias TdPassportElementError = TdApi.PassportElementError

typealias TdPassportSuitableElement = TdApi.PassportSuitableElement

typealias TdPassportRequiredElement = TdApi.PassportRequiredElement

typealias TdPassportAuthorizationForm = TdApi.PassportAuthorizationForm

typealias TdPassportElementsWithErrors = TdApi.PassportElementsWithErrors

typealias TdEncryptedCredentials = TdApi.EncryptedCredentials

typealias TdEncryptedPassportElement = TdApi.EncryptedPassportElement

typealias TdInputPassportElementErrorSource = TdApi.InputPassportElementErrorSource

typealias TdInputPassportElementErrorSourceUnspecified =
        TdApi.InputPassportElementErrorSourceUnspecified

typealias TdInputPassportElementErrorSourceDataField =
        TdApi.InputPassportElementErrorSourceDataField

typealias TdInputPassportElementErrorSourceFrontSide =
        TdApi.InputPassportElementErrorSourceFrontSide

typealias TdInputPassportElementErrorSourceReverseSide =
        TdApi.InputPassportElementErrorSourceReverseSide

typealias TdInputPassportElementErrorSourceSelfie = TdApi.InputPassportElementErrorSourceSelfie

typealias TdInputPassportElementErrorSourceTranslationFile =
        TdApi.InputPassportElementErrorSourceTranslationFile

typealias TdInputPassportElementErrorSourceTranslationFiles =
        TdApi.InputPassportElementErrorSourceTranslationFiles

typealias TdInputPassportElementErrorSourceFile = TdApi.InputPassportElementErrorSourceFile

typealias TdInputPassportElementErrorSourceFiles = TdApi.InputPassportElementErrorSourceFiles

typealias TdInputPassportElementError = TdApi.InputPassportElementError

typealias TdMessageContent = TdApi.MessageContent

typealias TdMessageText = TdApi.MessageText

typealias TdMessageAnimation = TdApi.MessageAnimation

typealias TdMessageAudio = TdApi.MessageAudio

typealias TdMessageDocument = TdApi.MessageDocument

typealias TdMessagePhoto = TdApi.MessagePhoto

typealias TdMessageExpiredPhoto = TdApi.MessageExpiredPhoto

typealias TdMessageSticker = TdApi.MessageSticker

typealias TdMessageVideo = TdApi.MessageVideo

typealias TdMessageExpiredVideo = TdApi.MessageExpiredVideo

typealias TdMessageVideoNote = TdApi.MessageVideoNote

typealias TdMessageVoiceNote = TdApi.MessageVoiceNote

typealias TdMessageLocation = TdApi.MessageLocation

typealias TdMessageVenue = TdApi.MessageVenue

typealias TdMessageContact = TdApi.MessageContact

typealias TdMessageGame = TdApi.MessageGame

typealias TdMessagePoll = TdApi.MessagePoll

typealias TdMessageInvoice = TdApi.MessageInvoice

typealias TdMessageCall = TdApi.MessageCall

typealias TdMessageBasicGroupChatCreate = TdApi.MessageBasicGroupChatCreate

typealias TdMessageSupergroupChatCreate = TdApi.MessageSupergroupChatCreate

typealias TdMessageChatChangeTitle = TdApi.MessageChatChangeTitle

typealias TdMessageChatChangePhoto = TdApi.MessageChatChangePhoto

typealias TdMessageChatDeletePhoto = TdApi.MessageChatDeletePhoto

typealias TdMessageChatAddMembers = TdApi.MessageChatAddMembers

typealias TdMessageChatJoinByLink = TdApi.MessageChatJoinByLink

typealias TdMessageChatDeleteMember = TdApi.MessageChatDeleteMember

typealias TdMessageChatUpgradeTo = TdApi.MessageChatUpgradeTo

typealias TdMessageChatUpgradeFrom = TdApi.MessageChatUpgradeFrom

typealias TdMessagePinMessage = TdApi.MessagePinMessage

typealias TdMessageScreenshotTaken = TdApi.MessageScreenshotTaken

typealias TdMessageChatSetTtl = TdApi.MessageChatSetTtl

typealias TdMessageCustomServiceAction = TdApi.MessageCustomServiceAction

typealias TdMessageGameScore = TdApi.MessageGameScore

typealias TdMessagePaymentSuccessful = TdApi.MessagePaymentSuccessful

typealias TdMessagePaymentSuccessfulBot = TdApi.MessagePaymentSuccessfulBot

typealias TdMessageContactRegistered = TdApi.MessageContactRegistered

typealias TdMessageWebsiteConnected = TdApi.MessageWebsiteConnected

typealias TdMessagePassportDataSent = TdApi.MessagePassportDataSent

typealias TdMessagePassportDataReceived = TdApi.MessagePassportDataReceived

typealias TdMessageUnsupported = TdApi.MessageUnsupported

typealias TdTextEntityType = TdApi.TextEntityType

typealias TdTextEntityTypeMention = TdApi.TextEntityTypeMention

typealias TdTextEntityTypeHashtag = TdApi.TextEntityTypeHashtag

typealias TdTextEntityTypeCashtag = TdApi.TextEntityTypeCashtag

typealias TdTextEntityTypeBotCommand = TdApi.TextEntityTypeBotCommand

typealias TdTextEntityTypeUrl = TdApi.TextEntityTypeUrl

typealias TdTextEntityTypeEmailAddress = TdApi.TextEntityTypeEmailAddress

typealias TdTextEntityTypeBold = TdApi.TextEntityTypeBold

typealias TdTextEntityTypeItalic = TdApi.TextEntityTypeItalic

typealias TdTextEntityTypeCode = TdApi.TextEntityTypeCode

typealias TdTextEntityTypePre = TdApi.TextEntityTypePre

typealias TdTextEntityTypePreCode = TdApi.TextEntityTypePreCode

typealias TdTextEntityTypeTextUrl = TdApi.TextEntityTypeTextUrl

typealias TdTextEntityTypeMentionName = TdApi.TextEntityTypeMentionName

typealias TdTextEntityTypePhoneNumber = TdApi.TextEntityTypePhoneNumber

typealias TdInputThumbnail = TdApi.InputThumbnail

typealias TdInputMessageContent = TdApi.InputMessageContent

typealias TdInputMessageText = TdApi.InputMessageText

typealias TdInputMessageAnimation = TdApi.InputMessageAnimation

typealias TdInputMessageAudio = TdApi.InputMessageAudio

typealias TdInputMessageDocument = TdApi.InputMessageDocument

typealias TdInputMessagePhoto = TdApi.InputMessagePhoto

typealias TdInputMessageSticker = TdApi.InputMessageSticker

typealias TdInputMessageVideo = TdApi.InputMessageVideo

typealias TdInputMessageVideoNote = TdApi.InputMessageVideoNote

typealias TdInputMessageVoiceNote = TdApi.InputMessageVoiceNote

typealias TdInputMessageLocation = TdApi.InputMessageLocation

typealias TdInputMessageVenue = TdApi.InputMessageVenue

typealias TdInputMessageContact = TdApi.InputMessageContact

typealias TdInputMessageGame = TdApi.InputMessageGame

typealias TdInputMessageInvoice = TdApi.InputMessageInvoice

typealias TdInputMessagePoll = TdApi.InputMessagePoll

typealias TdInputMessageForwarded = TdApi.InputMessageForwarded

typealias TdSearchMessagesFilter = TdApi.SearchMessagesFilter

typealias TdSearchMessagesFilterEmpty = TdApi.SearchMessagesFilterEmpty

typealias TdSearchMessagesFilterAnimation = TdApi.SearchMessagesFilterAnimation

typealias TdSearchMessagesFilterAudio = TdApi.SearchMessagesFilterAudio

typealias TdSearchMessagesFilterDocument = TdApi.SearchMessagesFilterDocument

typealias TdSearchMessagesFilterPhoto = TdApi.SearchMessagesFilterPhoto

typealias TdSearchMessagesFilterVideo = TdApi.SearchMessagesFilterVideo

typealias TdSearchMessagesFilterVoiceNote = TdApi.SearchMessagesFilterVoiceNote

typealias TdSearchMessagesFilterPhotoAndVideo = TdApi.SearchMessagesFilterPhotoAndVideo

typealias TdSearchMessagesFilterUrl = TdApi.SearchMessagesFilterUrl

typealias TdSearchMessagesFilterChatPhoto = TdApi.SearchMessagesFilterChatPhoto

typealias TdSearchMessagesFilterCall = TdApi.SearchMessagesFilterCall

typealias TdSearchMessagesFilterMissedCall = TdApi.SearchMessagesFilterMissedCall

typealias TdSearchMessagesFilterVideoNote = TdApi.SearchMessagesFilterVideoNote

typealias TdSearchMessagesFilterVoiceAndVideoNote = TdApi.SearchMessagesFilterVoiceAndVideoNote

typealias TdSearchMessagesFilterMention = TdApi.SearchMessagesFilterMention

typealias TdSearchMessagesFilterUnreadMention = TdApi.SearchMessagesFilterUnreadMention

typealias TdChatAction = TdApi.ChatAction

typealias TdChatActionTyping = TdApi.ChatActionTyping

typealias TdChatActionRecordingVideo = TdApi.ChatActionRecordingVideo

typealias TdChatActionUploadingVideo = TdApi.ChatActionUploadingVideo

typealias TdChatActionRecordingVoiceNote = TdApi.ChatActionRecordingVoiceNote

typealias TdChatActionUploadingVoiceNote = TdApi.ChatActionUploadingVoiceNote

typealias TdChatActionUploadingPhoto = TdApi.ChatActionUploadingPhoto

typealias TdChatActionUploadingDocument = TdApi.ChatActionUploadingDocument

typealias TdChatActionChoosingLocation = TdApi.ChatActionChoosingLocation

typealias TdChatActionChoosingContact = TdApi.ChatActionChoosingContact

typealias TdChatActionStartPlayingGame = TdApi.ChatActionStartPlayingGame

typealias TdChatActionRecordingVideoNote = TdApi.ChatActionRecordingVideoNote

typealias TdChatActionUploadingVideoNote = TdApi.ChatActionUploadingVideoNote

typealias TdChatActionCancel = TdApi.ChatActionCancel

typealias TdUserStatus = TdApi.UserStatus

typealias TdUserStatusEmpty = TdApi.UserStatusEmpty

typealias TdUserStatusOnline = TdApi.UserStatusOnline

typealias TdUserStatusOffline = TdApi.UserStatusOffline

typealias TdUserStatusRecently = TdApi.UserStatusRecently

typealias TdUserStatusLastWeek = TdApi.UserStatusLastWeek

typealias TdUserStatusLastMonth = TdApi.UserStatusLastMonth

typealias TdStickers = TdApi.Stickers

typealias TdEmojis = TdApi.Emojis

typealias TdStickerSet = TdApi.StickerSet

typealias TdStickerSetInfo = TdApi.StickerSetInfo

typealias TdStickerSets = TdApi.StickerSets

typealias TdCallDiscardReason = TdApi.CallDiscardReason

typealias TdCallDiscardReasonEmpty = TdApi.CallDiscardReasonEmpty

typealias TdCallDiscardReasonMissed = TdApi.CallDiscardReasonMissed

typealias TdCallDiscardReasonDeclined = TdApi.CallDiscardReasonDeclined

typealias TdCallDiscardReasonDisconnected = TdApi.CallDiscardReasonDisconnected

typealias TdCallDiscardReasonHungUp = TdApi.CallDiscardReasonHungUp

typealias TdCallProtocol = TdApi.CallProtocol

typealias TdCallConnection = TdApi.CallConnection

typealias TdCallId = TdApi.CallId

typealias TdCallState = TdApi.CallState

typealias TdCallStatePending = TdApi.CallStatePending

typealias TdCallStateExchangingKeys = TdApi.CallStateExchangingKeys

typealias TdCallStateReady = TdApi.CallStateReady

typealias TdCallStateHangingUp = TdApi.CallStateHangingUp

typealias TdCallStateDiscarded = TdApi.CallStateDiscarded

typealias TdCallStateError = TdApi.CallStateError

typealias TdCallProblem = TdApi.CallProblem

typealias TdCallProblemEcho = TdApi.CallProblemEcho

typealias TdCallProblemNoise = TdApi.CallProblemNoise

typealias TdCallProblemInterruptions = TdApi.CallProblemInterruptions

typealias TdCallProblemDistortedSpeech = TdApi.CallProblemDistortedSpeech

typealias TdCallProblemSilentLocal = TdApi.CallProblemSilentLocal

typealias TdCallProblemSilentRemote = TdApi.CallProblemSilentRemote

typealias TdCallProblemDropped = TdApi.CallProblemDropped

typealias TdCall = TdApi.Call

typealias TdPhoneNumberAuthenticationSettings = TdApi.PhoneNumberAuthenticationSettings

typealias TdAnimations = TdApi.Animations

typealias TdImportedContacts = TdApi.ImportedContacts

typealias TdHttpUrl = TdApi.HttpUrl

typealias TdInputInlineQueryResult = TdApi.InputInlineQueryResult

typealias TdInputInlineQueryResultAnimatedGif = TdApi.InputInlineQueryResultAnimatedGif

typealias TdInputInlineQueryResultAnimatedMpeg4 = TdApi.InputInlineQueryResultAnimatedMpeg4

typealias TdInputInlineQueryResultArticle = TdApi.InputInlineQueryResultArticle

typealias TdInputInlineQueryResultAudio = TdApi.InputInlineQueryResultAudio

typealias TdInputInlineQueryResultContact = TdApi.InputInlineQueryResultContact

typealias TdInputInlineQueryResultDocument = TdApi.InputInlineQueryResultDocument

typealias TdInputInlineQueryResultGame = TdApi.InputInlineQueryResultGame

typealias TdInputInlineQueryResultLocation = TdApi.InputInlineQueryResultLocation

typealias TdInputInlineQueryResultPhoto = TdApi.InputInlineQueryResultPhoto

typealias TdInputInlineQueryResultSticker = TdApi.InputInlineQueryResultSticker

typealias TdInputInlineQueryResultVenue = TdApi.InputInlineQueryResultVenue

typealias TdInputInlineQueryResultVideo = TdApi.InputInlineQueryResultVideo

typealias TdInputInlineQueryResultVoiceNote = TdApi.InputInlineQueryResultVoiceNote

typealias TdInlineQueryResult = TdApi.InlineQueryResult

typealias TdInlineQueryResultArticle = TdApi.InlineQueryResultArticle

typealias TdInlineQueryResultContact = TdApi.InlineQueryResultContact

typealias TdInlineQueryResultLocation = TdApi.InlineQueryResultLocation

typealias TdInlineQueryResultVenue = TdApi.InlineQueryResultVenue

typealias TdInlineQueryResultGame = TdApi.InlineQueryResultGame

typealias TdInlineQueryResultAnimation = TdApi.InlineQueryResultAnimation

typealias TdInlineQueryResultAudio = TdApi.InlineQueryResultAudio

typealias TdInlineQueryResultDocument = TdApi.InlineQueryResultDocument

typealias TdInlineQueryResultPhoto = TdApi.InlineQueryResultPhoto

typealias TdInlineQueryResultSticker = TdApi.InlineQueryResultSticker

typealias TdInlineQueryResultVideo = TdApi.InlineQueryResultVideo

typealias TdInlineQueryResultVoiceNote = TdApi.InlineQueryResultVoiceNote

typealias TdInlineQueryResults = TdApi.InlineQueryResults

typealias TdCallbackQueryPayload = TdApi.CallbackQueryPayload

typealias TdCallbackQueryPayloadData = TdApi.CallbackQueryPayloadData

typealias TdCallbackQueryPayloadGame = TdApi.CallbackQueryPayloadGame

typealias TdCallbackQueryAnswer = TdApi.CallbackQueryAnswer

typealias TdCustomRequestResult = TdApi.CustomRequestResult

typealias TdGameHighScore = TdApi.GameHighScore

typealias TdGameHighScores = TdApi.GameHighScores

typealias TdChatEventAction = TdApi.ChatEventAction

typealias TdChatEventMessageEdited = TdApi.ChatEventMessageEdited

typealias TdChatEventMessageDeleted = TdApi.ChatEventMessageDeleted

typealias TdChatEventPollStopped = TdApi.ChatEventPollStopped

typealias TdChatEventMessagePinned = TdApi.ChatEventMessagePinned

typealias TdChatEventMessageUnpinned = TdApi.ChatEventMessageUnpinned

typealias TdChatEventMemberJoined = TdApi.ChatEventMemberJoined

typealias TdChatEventMemberLeft = TdApi.ChatEventMemberLeft

typealias TdChatEventMemberInvited = TdApi.ChatEventMemberInvited

typealias TdChatEventMemberPromoted = TdApi.ChatEventMemberPromoted

typealias TdChatEventMemberRestricted = TdApi.ChatEventMemberRestricted

typealias TdChatEventTitleChanged = TdApi.ChatEventTitleChanged

typealias TdChatEventPermissionsChanged = TdApi.ChatEventPermissionsChanged

typealias TdChatEventDescriptionChanged = TdApi.ChatEventDescriptionChanged

typealias TdChatEventUsernameChanged = TdApi.ChatEventUsernameChanged

typealias TdChatEventPhotoChanged = TdApi.ChatEventPhotoChanged

typealias TdChatEventInvitesToggled = TdApi.ChatEventInvitesToggled

typealias TdChatEventSignMessagesToggled = TdApi.ChatEventSignMessagesToggled

typealias TdChatEventStickerSetChanged = TdApi.ChatEventStickerSetChanged

typealias TdChatEventIsAllHistoryAvailableToggled = TdApi.ChatEventIsAllHistoryAvailableToggled

typealias TdChatEvent = TdApi.ChatEvent

typealias TdChatEvents = TdApi.ChatEvents

typealias TdChatEventLogFilters = TdApi.ChatEventLogFilters

typealias TdLanguagePackStringValue = TdApi.LanguagePackStringValue

typealias TdLanguagePackStringValueOrdinary = TdApi.LanguagePackStringValueOrdinary

typealias TdLanguagePackStringValuePluralized = TdApi.LanguagePackStringValuePluralized

typealias TdLanguagePackStringValueDeleted = TdApi.LanguagePackStringValueDeleted

typealias TdLanguagePackString = TdApi.LanguagePackString

typealias TdLanguagePackStrings = TdApi.LanguagePackStrings

typealias TdLanguagePackInfo = TdApi.LanguagePackInfo

typealias TdLocalizationTargetInfo = TdApi.LocalizationTargetInfo

typealias TdDeviceToken = TdApi.DeviceToken

typealias TdDeviceTokenFirebaseCloudMessaging = TdApi.DeviceTokenFirebaseCloudMessaging

typealias TdDeviceTokenApplePush = TdApi.DeviceTokenApplePush

typealias TdDeviceTokenApplePushVoIP = TdApi.DeviceTokenApplePushVoIP

typealias TdDeviceTokenWindowsPush = TdApi.DeviceTokenWindowsPush

typealias TdDeviceTokenMicrosoftPush = TdApi.DeviceTokenMicrosoftPush

typealias TdDeviceTokenMicrosoftPushVoIP = TdApi.DeviceTokenMicrosoftPushVoIP

typealias TdDeviceTokenWebPush = TdApi.DeviceTokenWebPush

typealias TdDeviceTokenSimplePush = TdApi.DeviceTokenSimplePush

typealias TdDeviceTokenUbuntuPush = TdApi.DeviceTokenUbuntuPush

typealias TdDeviceTokenBlackBerryPush = TdApi.DeviceTokenBlackBerryPush

typealias TdDeviceTokenTizenPush = TdApi.DeviceTokenTizenPush

typealias TdPushReceiverId = TdApi.PushReceiverId

typealias TdBackgroundType = TdApi.BackgroundType

typealias TdBackgroundTypeWallpaper = TdApi.BackgroundTypeWallpaper

typealias TdBackgroundTypePattern = TdApi.BackgroundTypePattern

typealias TdBackgroundTypeSolid = TdApi.BackgroundTypeSolid

typealias TdBackground = TdApi.Background

typealias TdBackgrounds = TdApi.Backgrounds

typealias TdInputBackground = TdApi.InputBackground

typealias TdInputBackgroundLocal = TdApi.InputBackgroundLocal

typealias TdInputBackgroundRemote = TdApi.InputBackgroundRemote

typealias TdHashtags = TdApi.Hashtags

typealias TdCheckChatUsernameResult = TdApi.CheckChatUsernameResult

typealias TdCheckChatUsernameResultOk = TdApi.CheckChatUsernameResultOk

typealias TdCheckChatUsernameResultUsernameInvalid = TdApi.CheckChatUsernameResultUsernameInvalid

typealias TdCheckChatUsernameResultUsernameOccupied = TdApi.CheckChatUsernameResultUsernameOccupied

typealias TdCheckChatUsernameResultPublicChatsTooMuch =
        TdApi.CheckChatUsernameResultPublicChatsTooMuch

typealias TdCheckChatUsernameResultPublicGroupsUnavailable =
        TdApi.CheckChatUsernameResultPublicGroupsUnavailable

typealias TdPushMessageContent = TdApi.PushMessageContent

typealias TdPushMessageContentHidden = TdApi.PushMessageContentHidden

typealias TdPushMessageContentAnimation = TdApi.PushMessageContentAnimation

typealias TdPushMessageContentAudio = TdApi.PushMessageContentAudio

typealias TdPushMessageContentContact = TdApi.PushMessageContentContact

typealias TdPushMessageContentContactRegistered = TdApi.PushMessageContentContactRegistered

typealias TdPushMessageContentDocument = TdApi.PushMessageContentDocument

typealias TdPushMessageContentGame = TdApi.PushMessageContentGame

typealias TdPushMessageContentGameScore = TdApi.PushMessageContentGameScore

typealias TdPushMessageContentInvoice = TdApi.PushMessageContentInvoice

typealias TdPushMessageContentLocation = TdApi.PushMessageContentLocation

typealias TdPushMessageContentPhoto = TdApi.PushMessageContentPhoto

typealias TdPushMessageContentPoll = TdApi.PushMessageContentPoll

typealias TdPushMessageContentScreenshotTaken = TdApi.PushMessageContentScreenshotTaken

typealias TdPushMessageContentSticker = TdApi.PushMessageContentSticker

typealias TdPushMessageContentText = TdApi.PushMessageContentText

typealias TdPushMessageContentVideo = TdApi.PushMessageContentVideo

typealias TdPushMessageContentVideoNote = TdApi.PushMessageContentVideoNote

typealias TdPushMessageContentVoiceNote = TdApi.PushMessageContentVoiceNote

typealias TdPushMessageContentBasicGroupChatCreate = TdApi.PushMessageContentBasicGroupChatCreate

typealias TdPushMessageContentChatAddMembers = TdApi.PushMessageContentChatAddMembers

typealias TdPushMessageContentChatChangePhoto = TdApi.PushMessageContentChatChangePhoto

typealias TdPushMessageContentChatChangeTitle = TdApi.PushMessageContentChatChangeTitle

typealias TdPushMessageContentChatDeleteMember = TdApi.PushMessageContentChatDeleteMember

typealias TdPushMessageContentChatJoinByLink = TdApi.PushMessageContentChatJoinByLink

typealias TdPushMessageContentMessageForwards = TdApi.PushMessageContentMessageForwards

typealias TdPushMessageContentMediaAlbum = TdApi.PushMessageContentMediaAlbum

typealias TdNotificationType = TdApi.NotificationType

typealias TdNotificationTypeNewMessage = TdApi.NotificationTypeNewMessage

typealias TdNotificationTypeNewSecretChat = TdApi.NotificationTypeNewSecretChat

typealias TdNotificationTypeNewCall = TdApi.NotificationTypeNewCall

typealias TdNotificationTypeNewPushMessage = TdApi.NotificationTypeNewPushMessage

typealias TdNotificationGroupType = TdApi.NotificationGroupType

typealias TdNotificationGroupTypeMessages = TdApi.NotificationGroupTypeMessages

typealias TdNotificationGroupTypeMentions = TdApi.NotificationGroupTypeMentions

typealias TdNotificationGroupTypeSecretChat = TdApi.NotificationGroupTypeSecretChat

typealias TdNotificationGroupTypeCalls = TdApi.NotificationGroupTypeCalls

typealias TdNotification = TdApi.Notification

typealias TdNotificationGroup = TdApi.NotificationGroup

typealias TdOptionValue = TdApi.OptionValue

typealias TdOptionValueBoolean = TdApi.OptionValueBoolean

typealias TdOptionValueEmpty = TdApi.OptionValueEmpty

typealias TdOptionValueInteger = TdApi.OptionValueInteger

typealias TdOptionValueString = TdApi.OptionValueString

typealias TdJsonObjectMember = TdApi.JsonObjectMember

typealias TdJsonValue = TdApi.JsonValue

typealias TdJsonValueNull = TdApi.JsonValueNull

typealias TdJsonValueBoolean = TdApi.JsonValueBoolean

typealias TdJsonValueNumber = TdApi.JsonValueNumber

typealias TdJsonValueString = TdApi.JsonValueString

typealias TdJsonValueArray = TdApi.JsonValueArray

typealias TdJsonValueObject = TdApi.JsonValueObject

typealias TdUserPrivacySettingRule = TdApi.UserPrivacySettingRule

typealias TdUserPrivacySettingRuleAllowAll = TdApi.UserPrivacySettingRuleAllowAll

typealias TdUserPrivacySettingRuleAllowContacts = TdApi.UserPrivacySettingRuleAllowContacts

typealias TdUserPrivacySettingRuleAllowUsers = TdApi.UserPrivacySettingRuleAllowUsers

typealias TdUserPrivacySettingRuleRestrictAll = TdApi.UserPrivacySettingRuleRestrictAll

typealias TdUserPrivacySettingRuleRestrictContacts = TdApi.UserPrivacySettingRuleRestrictContacts

typealias TdUserPrivacySettingRuleRestrictUsers = TdApi.UserPrivacySettingRuleRestrictUsers

typealias TdUserPrivacySettingRules = TdApi.UserPrivacySettingRules

typealias TdUserPrivacySetting = TdApi.UserPrivacySetting

typealias TdUserPrivacySettingShowStatus = TdApi.UserPrivacySettingShowStatus

typealias TdUserPrivacySettingShowProfilePhoto = TdApi.UserPrivacySettingShowProfilePhoto

typealias TdUserPrivacySettingShowLinkInForwardedMessages =
        TdApi.UserPrivacySettingShowLinkInForwardedMessages

typealias TdUserPrivacySettingAllowChatInvites = TdApi.UserPrivacySettingAllowChatInvites

typealias TdUserPrivacySettingAllowCalls = TdApi.UserPrivacySettingAllowCalls

typealias TdUserPrivacySettingAllowPeerToPeerCalls = TdApi.UserPrivacySettingAllowPeerToPeerCalls

typealias TdAccountTtl = TdApi.AccountTtl

typealias TdSession = TdApi.Session

typealias TdSessions = TdApi.Sessions

typealias TdConnectedWebsite = TdApi.ConnectedWebsite

typealias TdConnectedWebsites = TdApi.ConnectedWebsites

typealias TdChatReportSpamState = TdApi.ChatReportSpamState

typealias TdChatReportReason = TdApi.ChatReportReason

typealias TdChatReportReasonSpam = TdApi.ChatReportReasonSpam

typealias TdChatReportReasonViolence = TdApi.ChatReportReasonViolence

typealias TdChatReportReasonPornography = TdApi.ChatReportReasonPornography

typealias TdChatReportReasonChildAbuse = TdApi.ChatReportReasonChildAbuse

typealias TdChatReportReasonCopyright = TdApi.ChatReportReasonCopyright

typealias TdChatReportReasonCustom = TdApi.ChatReportReasonCustom

typealias TdPublicMessageLink = TdApi.PublicMessageLink

typealias TdMessageLinkInfo = TdApi.MessageLinkInfo

typealias TdFilePart = TdApi.FilePart

typealias TdFileType = TdApi.FileType

typealias TdFileTypeNone = TdApi.FileTypeNone

typealias TdFileTypeAnimation = TdApi.FileTypeAnimation

typealias TdFileTypeAudio = TdApi.FileTypeAudio

typealias TdFileTypeDocument = TdApi.FileTypeDocument

typealias TdFileTypePhoto = TdApi.FileTypePhoto

typealias TdFileTypeProfilePhoto = TdApi.FileTypeProfilePhoto

typealias TdFileTypeSecret = TdApi.FileTypeSecret

typealias TdFileTypeSecretThumbnail = TdApi.FileTypeSecretThumbnail

typealias TdFileTypeSecure = TdApi.FileTypeSecure

typealias TdFileTypeSticker = TdApi.FileTypeSticker

typealias TdFileTypeThumbnail = TdApi.FileTypeThumbnail

typealias TdFileTypeUnknown = TdApi.FileTypeUnknown

typealias TdFileTypeVideo = TdApi.FileTypeVideo

typealias TdFileTypeVideoNote = TdApi.FileTypeVideoNote

typealias TdFileTypeVoiceNote = TdApi.FileTypeVoiceNote

typealias TdFileTypeWallpaper = TdApi.FileTypeWallpaper

typealias TdStorageStatisticsByFileType = TdApi.StorageStatisticsByFileType

typealias TdStorageStatisticsByChat = TdApi.StorageStatisticsByChat

typealias TdStorageStatistics = TdApi.StorageStatistics

typealias TdStorageStatisticsFast = TdApi.StorageStatisticsFast

typealias TdDatabaseStatistics = TdApi.DatabaseStatistics

typealias TdNetworkType = TdApi.NetworkType

typealias TdNetworkTypeNone = TdApi.NetworkTypeNone

typealias TdNetworkTypeMobile = TdApi.NetworkTypeMobile

typealias TdNetworkTypeMobileRoaming = TdApi.NetworkTypeMobileRoaming

typealias TdNetworkTypeWiFi = TdApi.NetworkTypeWiFi

typealias TdNetworkTypeOther = TdApi.NetworkTypeOther

typealias TdNetworkStatisticsEntry = TdApi.NetworkStatisticsEntry

typealias TdNetworkStatisticsEntryFile = TdApi.NetworkStatisticsEntryFile

typealias TdNetworkStatisticsEntryCall = TdApi.NetworkStatisticsEntryCall

typealias TdNetworkStatistics = TdApi.NetworkStatistics

typealias TdAutoDownloadSettings = TdApi.AutoDownloadSettings

typealias TdAutoDownloadSettingsPresets = TdApi.AutoDownloadSettingsPresets

typealias TdConnectionState = TdApi.ConnectionState

typealias TdConnectionStateWaitingForNetwork = TdApi.ConnectionStateWaitingForNetwork

typealias TdConnectionStateConnectingToProxy = TdApi.ConnectionStateConnectingToProxy

typealias TdConnectionStateConnecting = TdApi.ConnectionStateConnecting

typealias TdConnectionStateUpdating = TdApi.ConnectionStateUpdating

typealias TdConnectionStateReady = TdApi.ConnectionStateReady

typealias TdTopChatCategory = TdApi.TopChatCategory

typealias TdTopChatCategoryUsers = TdApi.TopChatCategoryUsers

typealias TdTopChatCategoryBots = TdApi.TopChatCategoryBots

typealias TdTopChatCategoryGroups = TdApi.TopChatCategoryGroups

typealias TdTopChatCategoryChannels = TdApi.TopChatCategoryChannels

typealias TdTopChatCategoryInlineBots = TdApi.TopChatCategoryInlineBots

typealias TdTopChatCategoryCalls = TdApi.TopChatCategoryCalls

typealias TdTMeUrlType = TdApi.TMeUrlType

typealias TdTMeUrlTypeUser = TdApi.TMeUrlTypeUser

typealias TdTMeUrlTypeSupergroup = TdApi.TMeUrlTypeSupergroup

typealias TdTMeUrlTypeChatInvite = TdApi.TMeUrlTypeChatInvite

typealias TdTMeUrlTypeStickerSet = TdApi.TMeUrlTypeStickerSet

typealias TdTMeUrl = TdApi.TMeUrl

typealias TdTMeUrls = TdApi.TMeUrls

typealias TdCount = TdApi.Count

typealias TdText = TdApi.Text

typealias TdSeconds = TdApi.Seconds

typealias TdDeepLinkInfo = TdApi.DeepLinkInfo

typealias TdTextParseMode = TdApi.TextParseMode

typealias TdTextParseModeMarkdown = TdApi.TextParseModeMarkdown

typealias TdTextParseModeHTML = TdApi.TextParseModeHTML

typealias TdProxyType = TdApi.ProxyType

typealias TdProxyTypeSocks5 = TdApi.ProxyTypeSocks5

typealias TdProxyTypeHttp = TdApi.ProxyTypeHttp

typealias TdProxyTypeMtproto = TdApi.ProxyTypeMtproto

typealias TdProxy = TdApi.Proxy

typealias TdProxies = TdApi.Proxies

typealias TdInputSticker = TdApi.InputSticker

typealias TdUpdateAuthorizationState = TdApi.UpdateAuthorizationState

typealias TdUpdateNewMessage = TdApi.UpdateNewMessage

typealias TdUpdateMessageSendAcknowledged = TdApi.UpdateMessageSendAcknowledged

typealias TdUpdateMessageSendSucceeded = TdApi.UpdateMessageSendSucceeded

typealias TdUpdateMessageSendFailed = TdApi.UpdateMessageSendFailed

typealias TdUpdateMessageContent = TdApi.UpdateMessageContent

typealias TdUpdateMessageEdited = TdApi.UpdateMessageEdited

typealias TdUpdateMessageViews = TdApi.UpdateMessageViews

typealias TdUpdateMessageContentOpened = TdApi.UpdateMessageContentOpened

typealias TdUpdateMessageMentionRead = TdApi.UpdateMessageMentionRead

typealias TdUpdateNewChat = TdApi.UpdateNewChat

typealias TdUpdateChatTitle = TdApi.UpdateChatTitle

typealias TdUpdateChatPhoto = TdApi.UpdateChatPhoto

typealias TdUpdateChatPermissions = TdApi.UpdateChatPermissions

typealias TdUpdateChatLastMessage = TdApi.UpdateChatLastMessage

typealias TdUpdateChatOrder = TdApi.UpdateChatOrder

typealias TdUpdateChatIsPinned = TdApi.UpdateChatIsPinned

typealias TdUpdateChatIsMarkedAsUnread = TdApi.UpdateChatIsMarkedAsUnread

typealias TdUpdateChatIsSponsored = TdApi.UpdateChatIsSponsored

typealias TdUpdateChatDefaultDisableNotification = TdApi.UpdateChatDefaultDisableNotification

typealias TdUpdateChatReadInbox = TdApi.UpdateChatReadInbox

typealias TdUpdateChatReadOutbox = TdApi.UpdateChatReadOutbox

typealias TdUpdateChatUnreadMentionCount = TdApi.UpdateChatUnreadMentionCount

typealias TdUpdateChatNotificationSettings = TdApi.UpdateChatNotificationSettings

typealias TdUpdateScopeNotificationSettings = TdApi.UpdateScopeNotificationSettings

typealias TdUpdateChatPinnedMessage = TdApi.UpdateChatPinnedMessage

typealias TdUpdateChatReplyMarkup = TdApi.UpdateChatReplyMarkup

typealias TdUpdateChatDraftMessage = TdApi.UpdateChatDraftMessage

typealias TdUpdateChatOnlineMemberCount = TdApi.UpdateChatOnlineMemberCount

typealias TdUpdateNotification = TdApi.UpdateNotification

typealias TdUpdateNotificationGroup = TdApi.UpdateNotificationGroup

typealias TdUpdateActiveNotifications = TdApi.UpdateActiveNotifications

typealias TdUpdateHavePendingNotifications = TdApi.UpdateHavePendingNotifications

typealias TdUpdateDeleteMessages = TdApi.UpdateDeleteMessages

typealias TdUpdateUserChatAction = TdApi.UpdateUserChatAction

typealias TdUpdateUserStatus = TdApi.UpdateUserStatus

typealias TdUpdateUser = TdApi.UpdateUser

typealias TdUpdateBasicGroup = TdApi.UpdateBasicGroup

typealias TdUpdateSupergroup = TdApi.UpdateSupergroup

typealias TdUpdateSecretChat = TdApi.UpdateSecretChat

typealias TdUpdateUserFullInfo = TdApi.UpdateUserFullInfo

typealias TdUpdateBasicGroupFullInfo = TdApi.UpdateBasicGroupFullInfo

typealias TdUpdateSupergroupFullInfo = TdApi.UpdateSupergroupFullInfo

typealias TdUpdateServiceNotification = TdApi.UpdateServiceNotification

typealias TdUpdateFile = TdApi.UpdateFile

typealias TdUpdateFileGenerationStart = TdApi.UpdateFileGenerationStart

typealias TdUpdateFileGenerationStop = TdApi.UpdateFileGenerationStop

typealias TdUpdateCall = TdApi.UpdateCall

typealias TdUpdateUserPrivacySettingRules = TdApi.UpdateUserPrivacySettingRules

typealias TdUpdateUnreadMessageCount = TdApi.UpdateUnreadMessageCount

typealias TdUpdateUnreadChatCount = TdApi.UpdateUnreadChatCount

typealias TdUpdateOption = TdApi.UpdateOption

typealias TdUpdateInstalledStickerSets = TdApi.UpdateInstalledStickerSets

typealias TdUpdateTrendingStickerSets = TdApi.UpdateTrendingStickerSets

typealias TdUpdateRecentStickers = TdApi.UpdateRecentStickers

typealias TdUpdateFavoriteStickers = TdApi.UpdateFavoriteStickers

typealias TdUpdateSavedAnimations = TdApi.UpdateSavedAnimations

typealias TdUpdateSelectedBackground = TdApi.UpdateSelectedBackground

typealias TdUpdateLanguagePackStrings = TdApi.UpdateLanguagePackStrings

typealias TdUpdateConnectionState = TdApi.UpdateConnectionState

typealias TdUpdateTermsOfService = TdApi.UpdateTermsOfService

typealias TdUpdateNewInlineQuery = TdApi.UpdateNewInlineQuery

typealias TdUpdateNewChosenInlineResult = TdApi.UpdateNewChosenInlineResult

typealias TdUpdateNewCallbackQuery = TdApi.UpdateNewCallbackQuery

typealias TdUpdateNewInlineCallbackQuery = TdApi.UpdateNewInlineCallbackQuery

typealias TdUpdateNewShippingQuery = TdApi.UpdateNewShippingQuery

typealias TdUpdateNewPreCheckoutQuery = TdApi.UpdateNewPreCheckoutQuery

typealias TdUpdateNewCustomEvent = TdApi.UpdateNewCustomEvent

typealias TdUpdateNewCustomQuery = TdApi.UpdateNewCustomQuery

typealias TdUpdatePoll = TdApi.UpdatePoll

typealias TdUpdates = TdApi.Updates

typealias TdLogStream = TdApi.LogStream

typealias TdLogStreamDefault = TdApi.LogStreamDefault

typealias TdLogStreamFile = TdApi.LogStreamFile

typealias TdLogStreamEmpty = TdApi.LogStreamEmpty

typealias TdLogVerbosityLevel = TdApi.LogVerbosityLevel

typealias TdLogTags = TdApi.LogTags

typealias TdTestInt = TdApi.TestInt

typealias TdTestString = TdApi.TestString

typealias TdTestBytes = TdApi.TestBytes

typealias TdTestVectorInt = TdApi.TestVectorInt

typealias TdTestVectorIntObject = TdApi.TestVectorIntObject

typealias TdTestVectorString = TdApi.TestVectorString

typealias TdTestVectorStringObject = TdApi.TestVectorStringObject

typealias TdGetAuthorizationState = TdApi.GetAuthorizationState

typealias TdSetTdlibParameters = TdApi.SetTdlibParameters

typealias TdCheckDatabaseEncryptionKey = TdApi.CheckDatabaseEncryptionKey

typealias TdSetAuthenticationPhoneNumber = TdApi.SetAuthenticationPhoneNumber

typealias TdResendAuthenticationCode = TdApi.ResendAuthenticationCode

typealias TdCheckAuthenticationCode = TdApi.CheckAuthenticationCode

typealias TdRegisterUser = TdApi.RegisterUser

typealias TdCheckAuthenticationPassword = TdApi.CheckAuthenticationPassword

typealias TdRequestAuthenticationPasswordRecovery = TdApi.RequestAuthenticationPasswordRecovery

typealias TdRecoverAuthenticationPassword = TdApi.RecoverAuthenticationPassword

typealias TdCheckAuthenticationBotToken = TdApi.CheckAuthenticationBotToken

typealias TdGetCurrentState = TdApi.GetCurrentState

typealias TdSetDatabaseEncryptionKey = TdApi.SetDatabaseEncryptionKey

typealias TdGetPasswordState = TdApi.GetPasswordState

typealias TdSetPassword = TdApi.SetPassword

typealias TdGetRecoveryEmailAddress = TdApi.GetRecoveryEmailAddress

typealias TdSetRecoveryEmailAddress = TdApi.SetRecoveryEmailAddress

typealias TdCheckRecoveryEmailAddressCode = TdApi.CheckRecoveryEmailAddressCode

typealias TdResendRecoveryEmailAddressCode = TdApi.ResendRecoveryEmailAddressCode

typealias TdRequestPasswordRecovery = TdApi.RequestPasswordRecovery

typealias TdRecoverPassword = TdApi.RecoverPassword

typealias TdCreateTemporaryPassword = TdApi.CreateTemporaryPassword

typealias TdGetTemporaryPasswordState = TdApi.GetTemporaryPasswordState

typealias TdGetMe = TdApi.GetMe

typealias TdGetUser = TdApi.GetUser

typealias TdGetUserFullInfo = TdApi.GetUserFullInfo

typealias TdGetBasicGroup = TdApi.GetBasicGroup

typealias TdGetBasicGroupFullInfo = TdApi.GetBasicGroupFullInfo

typealias TdGetSupergroup = TdApi.GetSupergroup

typealias TdGetSupergroupFullInfo = TdApi.GetSupergroupFullInfo

typealias TdGetSecretChat = TdApi.GetSecretChat

typealias TdGetChat = TdApi.GetChat

typealias TdGetMessage = TdApi.GetMessage

typealias TdGetMessageLocally = TdApi.GetMessageLocally

typealias TdGetRepliedMessage = TdApi.GetRepliedMessage

typealias TdGetChatPinnedMessage = TdApi.GetChatPinnedMessage

typealias TdGetMessages = TdApi.GetMessages

typealias TdGetFile = TdApi.GetFile

typealias TdGetRemoteFile = TdApi.GetRemoteFile

typealias TdGetChats = TdApi.GetChats

typealias TdSearchPublicChat = TdApi.SearchPublicChat

typealias TdSearchPublicChats = TdApi.SearchPublicChats

typealias TdSearchChats = TdApi.SearchChats

typealias TdSearchChatsOnServer = TdApi.SearchChatsOnServer

typealias TdGetTopChats = TdApi.GetTopChats

typealias TdRemoveTopChat = TdApi.RemoveTopChat

typealias TdAddRecentlyFoundChat = TdApi.AddRecentlyFoundChat

typealias TdRemoveRecentlyFoundChat = TdApi.RemoveRecentlyFoundChat

typealias TdClearRecentlyFoundChats = TdApi.ClearRecentlyFoundChats

typealias TdCheckChatUsername = TdApi.CheckChatUsername

typealias TdGetCreatedPublicChats = TdApi.GetCreatedPublicChats

typealias TdGetGroupsInCommon = TdApi.GetGroupsInCommon

typealias TdGetChatHistory = TdApi.GetChatHistory

typealias TdDeleteChatHistory = TdApi.DeleteChatHistory

typealias TdSearchChatMessages = TdApi.SearchChatMessages

typealias TdSearchMessages = TdApi.SearchMessages

typealias TdSearchSecretMessages = TdApi.SearchSecretMessages

typealias TdSearchCallMessages = TdApi.SearchCallMessages

typealias TdSearchChatRecentLocationMessages = TdApi.SearchChatRecentLocationMessages

typealias TdGetActiveLiveLocationMessages = TdApi.GetActiveLiveLocationMessages

typealias TdGetChatMessageByDate = TdApi.GetChatMessageByDate

typealias TdGetChatMessageCount = TdApi.GetChatMessageCount

typealias TdRemoveNotification = TdApi.RemoveNotification

typealias TdRemoveNotificationGroup = TdApi.RemoveNotificationGroup

typealias TdGetPublicMessageLink = TdApi.GetPublicMessageLink

typealias TdGetMessageLink = TdApi.GetMessageLink

typealias TdGetMessageLinkInfo = TdApi.GetMessageLinkInfo

typealias TdSendMessage = TdApi.SendMessage

typealias TdSendMessageAlbum = TdApi.SendMessageAlbum

typealias TdSendBotStartMessage = TdApi.SendBotStartMessage

typealias TdSendInlineQueryResultMessage = TdApi.SendInlineQueryResultMessage

typealias TdForwardMessages = TdApi.ForwardMessages

typealias TdResendMessages = TdApi.ResendMessages

typealias TdSendChatSetTtlMessage = TdApi.SendChatSetTtlMessage

typealias TdSendChatScreenshotTakenNotification = TdApi.SendChatScreenshotTakenNotification

typealias TdAddLocalMessage = TdApi.AddLocalMessage

typealias TdDeleteMessages = TdApi.DeleteMessages

typealias TdDeleteChatMessagesFromUser = TdApi.DeleteChatMessagesFromUser

typealias TdEditMessageText = TdApi.EditMessageText

typealias TdEditMessageLiveLocation = TdApi.EditMessageLiveLocation

typealias TdEditMessageMedia = TdApi.EditMessageMedia

typealias TdEditMessageCaption = TdApi.EditMessageCaption

typealias TdEditMessageReplyMarkup = TdApi.EditMessageReplyMarkup

typealias TdEditInlineMessageText = TdApi.EditInlineMessageText

typealias TdEditInlineMessageLiveLocation = TdApi.EditInlineMessageLiveLocation

typealias TdEditInlineMessageMedia = TdApi.EditInlineMessageMedia

typealias TdEditInlineMessageCaption = TdApi.EditInlineMessageCaption

typealias TdEditInlineMessageReplyMarkup = TdApi.EditInlineMessageReplyMarkup

typealias TdGetTextEntities = TdApi.GetTextEntities

typealias TdParseTextEntities = TdApi.ParseTextEntities

typealias TdGetFileMimeType = TdApi.GetFileMimeType

typealias TdGetFileExtension = TdApi.GetFileExtension

typealias TdCleanFileName = TdApi.CleanFileName

typealias TdGetLanguagePackString = TdApi.GetLanguagePackString

typealias TdGetJsonValue = TdApi.GetJsonValue

typealias TdGetJsonString = TdApi.GetJsonString

typealias TdSetPollAnswer = TdApi.SetPollAnswer

typealias TdStopPoll = TdApi.StopPoll

typealias TdGetInlineQueryResults = TdApi.GetInlineQueryResults

typealias TdAnswerInlineQuery = TdApi.AnswerInlineQuery

typealias TdGetCallbackQueryAnswer = TdApi.GetCallbackQueryAnswer

typealias TdAnswerCallbackQuery = TdApi.AnswerCallbackQuery

typealias TdAnswerShippingQuery = TdApi.AnswerShippingQuery

typealias TdAnswerPreCheckoutQuery = TdApi.AnswerPreCheckoutQuery

typealias TdSetGameScore = TdApi.SetGameScore

typealias TdSetInlineGameScore = TdApi.SetInlineGameScore

typealias TdGetGameHighScores = TdApi.GetGameHighScores

typealias TdGetInlineGameHighScores = TdApi.GetInlineGameHighScores

typealias TdDeleteChatReplyMarkup = TdApi.DeleteChatReplyMarkup

typealias TdSendChatAction = TdApi.SendChatAction

typealias TdOpenChat = TdApi.OpenChat

typealias TdCloseChat = TdApi.CloseChat

typealias TdViewMessages = TdApi.ViewMessages

typealias TdOpenMessageContent = TdApi.OpenMessageContent

typealias TdReadAllChatMentions = TdApi.ReadAllChatMentions

typealias TdCreatePrivateChat = TdApi.CreatePrivateChat

typealias TdCreateBasicGroupChat = TdApi.CreateBasicGroupChat

typealias TdCreateSupergroupChat = TdApi.CreateSupergroupChat

typealias TdCreateSecretChat = TdApi.CreateSecretChat

typealias TdCreateNewBasicGroupChat = TdApi.CreateNewBasicGroupChat

typealias TdCreateNewSupergroupChat = TdApi.CreateNewSupergroupChat

typealias TdCreateNewSecretChat = TdApi.CreateNewSecretChat

typealias TdUpgradeBasicGroupChatToSupergroupChat = TdApi.UpgradeBasicGroupChatToSupergroupChat

typealias TdSetChatTitle = TdApi.SetChatTitle

typealias TdSetChatPhoto = TdApi.SetChatPhoto

typealias TdSetChatPermissions = TdApi.SetChatPermissions

typealias TdSetChatDraftMessage = TdApi.SetChatDraftMessage

typealias TdSetChatNotificationSettings = TdApi.SetChatNotificationSettings

typealias TdToggleChatIsPinned = TdApi.ToggleChatIsPinned

typealias TdToggleChatIsMarkedAsUnread = TdApi.ToggleChatIsMarkedAsUnread

typealias TdToggleChatDefaultDisableNotification = TdApi.ToggleChatDefaultDisableNotification

typealias TdSetChatClientData = TdApi.SetChatClientData

typealias TdSetChatDescription = TdApi.SetChatDescription

typealias TdPinChatMessage = TdApi.PinChatMessage

typealias TdUnpinChatMessage = TdApi.UnpinChatMessage

typealias TdJoinChat = TdApi.JoinChat

typealias TdLeaveChat = TdApi.LeaveChat

typealias TdAddChatMember = TdApi.AddChatMember

typealias TdAddChatMembers = TdApi.AddChatMembers

typealias TdSetChatMemberStatus = TdApi.SetChatMemberStatus

typealias TdGetChatMember = TdApi.GetChatMember

typealias TdSearchChatMembers = TdApi.SearchChatMembers

typealias TdGetChatAdministrators = TdApi.GetChatAdministrators

typealias TdClearAllDraftMessages = TdApi.ClearAllDraftMessages

typealias TdGetChatNotificationSettingsExceptions = TdApi.GetChatNotificationSettingsExceptions

typealias TdGetScopeNotificationSettings = TdApi.GetScopeNotificationSettings

typealias TdSetScopeNotificationSettings = TdApi.SetScopeNotificationSettings

typealias TdResetAllNotificationSettings = TdApi.ResetAllNotificationSettings

typealias TdSetPinnedChats = TdApi.SetPinnedChats

typealias TdDownloadFile = TdApi.DownloadFile

typealias TdGetFileDownloadedPrefixSize = TdApi.GetFileDownloadedPrefixSize

typealias TdCancelDownloadFile = TdApi.CancelDownloadFile

typealias TdUploadFile = TdApi.UploadFile

typealias TdCancelUploadFile = TdApi.CancelUploadFile

typealias TdWriteGeneratedFilePart = TdApi.WriteGeneratedFilePart

typealias TdSetFileGenerationProgress = TdApi.SetFileGenerationProgress

typealias TdFinishFileGeneration = TdApi.FinishFileGeneration

typealias TdReadFilePart = TdApi.ReadFilePart

typealias TdDeleteFile = TdApi.DeleteFile

typealias TdGenerateChatInviteLink = TdApi.GenerateChatInviteLink

typealias TdCheckChatInviteLink = TdApi.CheckChatInviteLink

typealias TdJoinChatByInviteLink = TdApi.JoinChatByInviteLink

typealias TdCreateCall = TdApi.CreateCall

typealias TdAcceptCall = TdApi.AcceptCall

typealias TdDiscardCall = TdApi.DiscardCall

typealias TdSendCallRating = TdApi.SendCallRating

typealias TdSendCallDebugInformation = TdApi.SendCallDebugInformation

typealias TdBlockUser = TdApi.BlockUser

typealias TdUnblockUser = TdApi.UnblockUser

typealias TdGetBlockedUsers = TdApi.GetBlockedUsers

typealias TdImportContacts = TdApi.ImportContacts

typealias TdGetContacts = TdApi.GetContacts

typealias TdSearchContacts = TdApi.SearchContacts

typealias TdRemoveContacts = TdApi.RemoveContacts

typealias TdGetImportedContactCount = TdApi.GetImportedContactCount

typealias TdChangeImportedContacts = TdApi.ChangeImportedContacts

typealias TdClearImportedContacts = TdApi.ClearImportedContacts

typealias TdGetUserProfilePhotos = TdApi.GetUserProfilePhotos

typealias TdGetStickers = TdApi.GetStickers

typealias TdSearchStickers = TdApi.SearchStickers

typealias TdGetInstalledStickerSets = TdApi.GetInstalledStickerSets

typealias TdGetArchivedStickerSets = TdApi.GetArchivedStickerSets

typealias TdGetTrendingStickerSets = TdApi.GetTrendingStickerSets

typealias TdGetAttachedStickerSets = TdApi.GetAttachedStickerSets

typealias TdGetStickerSet = TdApi.GetStickerSet

typealias TdSearchStickerSet = TdApi.SearchStickerSet

typealias TdSearchInstalledStickerSets = TdApi.SearchInstalledStickerSets

typealias TdSearchStickerSets = TdApi.SearchStickerSets

typealias TdChangeStickerSet = TdApi.ChangeStickerSet

typealias TdViewTrendingStickerSets = TdApi.ViewTrendingStickerSets

typealias TdReorderInstalledStickerSets = TdApi.ReorderInstalledStickerSets

typealias TdGetRecentStickers = TdApi.GetRecentStickers

typealias TdAddRecentSticker = TdApi.AddRecentSticker

typealias TdRemoveRecentSticker = TdApi.RemoveRecentSticker

typealias TdClearRecentStickers = TdApi.ClearRecentStickers

typealias TdGetFavoriteStickers = TdApi.GetFavoriteStickers

typealias TdAddFavoriteSticker = TdApi.AddFavoriteSticker

typealias TdRemoveFavoriteSticker = TdApi.RemoveFavoriteSticker

typealias TdGetStickerEmojis = TdApi.GetStickerEmojis

typealias TdSearchEmojis = TdApi.SearchEmojis

typealias TdGetEmojiSuggestionsUrl = TdApi.GetEmojiSuggestionsUrl

typealias TdGetSavedAnimations = TdApi.GetSavedAnimations

typealias TdAddSavedAnimation = TdApi.AddSavedAnimation

typealias TdRemoveSavedAnimation = TdApi.RemoveSavedAnimation

typealias TdGetRecentInlineBots = TdApi.GetRecentInlineBots

typealias TdSearchHashtags = TdApi.SearchHashtags

typealias TdRemoveRecentHashtag = TdApi.RemoveRecentHashtag

typealias TdGetWebPagePreview = TdApi.GetWebPagePreview

typealias TdGetWebPageInstantView = TdApi.GetWebPageInstantView

typealias TdSetProfilePhoto = TdApi.SetProfilePhoto

typealias TdDeleteProfilePhoto = TdApi.DeleteProfilePhoto

typealias TdSetName = TdApi.SetName

typealias TdSetBio = TdApi.SetBio

typealias TdSetUsername = TdApi.SetUsername

typealias TdChangePhoneNumber = TdApi.ChangePhoneNumber

typealias TdResendChangePhoneNumberCode = TdApi.ResendChangePhoneNumberCode

typealias TdCheckChangePhoneNumberCode = TdApi.CheckChangePhoneNumberCode

typealias TdGetActiveSessions = TdApi.GetActiveSessions

typealias TdTerminateSession = TdApi.TerminateSession

typealias TdTerminateAllOtherSessions = TdApi.TerminateAllOtherSessions

typealias TdGetConnectedWebsites = TdApi.GetConnectedWebsites

typealias TdDisconnectWebsite = TdApi.DisconnectWebsite

typealias TdDisconnectAllWebsites = TdApi.DisconnectAllWebsites

typealias TdSetSupergroupUsername = TdApi.SetSupergroupUsername

typealias TdSetSupergroupStickerSet = TdApi.SetSupergroupStickerSet

typealias TdToggleSupergroupSignMessages = TdApi.ToggleSupergroupSignMessages

typealias TdToggleSupergroupIsAllHistoryAvailable = TdApi.ToggleSupergroupIsAllHistoryAvailable

typealias TdReportSupergroupSpam = TdApi.ReportSupergroupSpam

typealias TdGetSupergroupMembers = TdApi.GetSupergroupMembers

typealias TdDeleteSupergroup = TdApi.DeleteSupergroup

typealias TdCloseSecretChat = TdApi.CloseSecretChat

typealias TdGetChatEventLog = TdApi.GetChatEventLog

typealias TdGetPaymentForm = TdApi.GetPaymentForm

typealias TdValidateOrderInfo = TdApi.ValidateOrderInfo

typealias TdSendPaymentForm = TdApi.SendPaymentForm

typealias TdGetPaymentReceipt = TdApi.GetPaymentReceipt

typealias TdGetSavedOrderInfo = TdApi.GetSavedOrderInfo

typealias TdDeleteSavedOrderInfo = TdApi.DeleteSavedOrderInfo

typealias TdDeleteSavedCredentials = TdApi.DeleteSavedCredentials

typealias TdGetSupportUser = TdApi.GetSupportUser

typealias TdGetBackgrounds = TdApi.GetBackgrounds

typealias TdGetBackgroundUrl = TdApi.GetBackgroundUrl

typealias TdSearchBackground = TdApi.SearchBackground

typealias TdSetBackground = TdApi.SetBackground

typealias TdRemoveBackground = TdApi.RemoveBackground

typealias TdResetBackgrounds = TdApi.ResetBackgrounds

typealias TdGetLocalizationTargetInfo = TdApi.GetLocalizationTargetInfo

typealias TdGetLanguagePackInfo = TdApi.GetLanguagePackInfo

typealias TdGetLanguagePackStrings = TdApi.GetLanguagePackStrings

typealias TdSynchronizeLanguagePack = TdApi.SynchronizeLanguagePack

typealias TdAddCustomServerLanguagePack = TdApi.AddCustomServerLanguagePack

typealias TdSetCustomLanguagePack = TdApi.SetCustomLanguagePack

typealias TdEditCustomLanguagePackInfo = TdApi.EditCustomLanguagePackInfo

typealias TdSetCustomLanguagePackString = TdApi.SetCustomLanguagePackString

typealias TdDeleteLanguagePack = TdApi.DeleteLanguagePack

typealias TdRegisterDevice = TdApi.RegisterDevice

typealias TdProcessPushNotification = TdApi.ProcessPushNotification

typealias TdGetPushReceiverId = TdApi.GetPushReceiverId

typealias TdGetRecentlyVisitedTMeUrls = TdApi.GetRecentlyVisitedTMeUrls

typealias TdSetUserPrivacySettingRules = TdApi.SetUserPrivacySettingRules

typealias TdGetUserPrivacySettingRules = TdApi.GetUserPrivacySettingRules

typealias TdGetOption = TdApi.GetOption

typealias TdSetOption = TdApi.SetOption

typealias TdSetAccountTtl = TdApi.SetAccountTtl

typealias TdGetAccountTtl = TdApi.GetAccountTtl

typealias TdDeleteAccount = TdApi.DeleteAccount

typealias TdGetChatReportSpamState = TdApi.GetChatReportSpamState

typealias TdChangeChatReportSpamState = TdApi.ChangeChatReportSpamState

typealias TdReportChat = TdApi.ReportChat

typealias TdGetChatStatisticsUrl = TdApi.GetChatStatisticsUrl

typealias TdGetStorageStatistics = TdApi.GetStorageStatistics

typealias TdGetStorageStatisticsFast = TdApi.GetStorageStatisticsFast

typealias TdGetDatabaseStatistics = TdApi.GetDatabaseStatistics

typealias TdOptimizeStorage = TdApi.OptimizeStorage

typealias TdSetNetworkType = TdApi.SetNetworkType

typealias TdGetNetworkStatistics = TdApi.GetNetworkStatistics

typealias TdAddNetworkStatistics = TdApi.AddNetworkStatistics

typealias TdResetNetworkStatistics = TdApi.ResetNetworkStatistics

typealias TdGetAutoDownloadSettingsPresets = TdApi.GetAutoDownloadSettingsPresets

typealias TdSetAutoDownloadSettings = TdApi.SetAutoDownloadSettings

typealias TdGetPassportElement = TdApi.GetPassportElement

typealias TdGetAllPassportElements = TdApi.GetAllPassportElements

typealias TdSetPassportElement = TdApi.SetPassportElement

typealias TdDeletePassportElement = TdApi.DeletePassportElement

typealias TdSetPassportElementErrors = TdApi.SetPassportElementErrors

typealias TdGetPreferredCountryLanguage = TdApi.GetPreferredCountryLanguage

typealias TdSendPhoneNumberVerificationCode = TdApi.SendPhoneNumberVerificationCode

typealias TdResendPhoneNumberVerificationCode = TdApi.ResendPhoneNumberVerificationCode

typealias TdCheckPhoneNumberVerificationCode = TdApi.CheckPhoneNumberVerificationCode

typealias TdSendEmailAddressVerificationCode = TdApi.SendEmailAddressVerificationCode

typealias TdResendEmailAddressVerificationCode = TdApi.ResendEmailAddressVerificationCode

typealias TdCheckEmailAddressVerificationCode = TdApi.CheckEmailAddressVerificationCode

typealias TdGetPassportAuthorizationForm = TdApi.GetPassportAuthorizationForm

typealias TdGetPassportAuthorizationFormAvailableElements =
        TdApi.GetPassportAuthorizationFormAvailableElements

typealias TdSendPassportAuthorizationForm = TdApi.SendPassportAuthorizationForm

typealias TdSendPhoneNumberConfirmationCode = TdApi.SendPhoneNumberConfirmationCode

typealias TdResendPhoneNumberConfirmationCode = TdApi.ResendPhoneNumberConfirmationCode

typealias TdCheckPhoneNumberConfirmationCode = TdApi.CheckPhoneNumberConfirmationCode

typealias TdSetBotUpdatesStatus = TdApi.SetBotUpdatesStatus

typealias TdUploadStickerFile = TdApi.UploadStickerFile

typealias TdCreateNewStickerSet = TdApi.CreateNewStickerSet

typealias TdAddStickerToSet = TdApi.AddStickerToSet

typealias TdSetStickerPositionInSet = TdApi.SetStickerPositionInSet

typealias TdRemoveStickerFromSet = TdApi.RemoveStickerFromSet

typealias TdGetMapThumbnailFile = TdApi.GetMapThumbnailFile

typealias TdAcceptTermsOfService = TdApi.AcceptTermsOfService

typealias TdSendCustomRequest = TdApi.SendCustomRequest

typealias TdAnswerCustomQuery = TdApi.AnswerCustomQuery

typealias TdSetAlarm = TdApi.SetAlarm

typealias TdGetCountryCode = TdApi.GetCountryCode

typealias TdGetInviteText = TdApi.GetInviteText

typealias TdGetDeepLinkInfo = TdApi.GetDeepLinkInfo

typealias TdGetApplicationConfig = TdApi.GetApplicationConfig

typealias TdSaveApplicationLogEvent = TdApi.SaveApplicationLogEvent

typealias TdAddProxy = TdApi.AddProxy

typealias TdEditProxy = TdApi.EditProxy

typealias TdEnableProxy = TdApi.EnableProxy

typealias TdDisableProxy = TdApi.DisableProxy

typealias TdRemoveProxy = TdApi.RemoveProxy

typealias TdGetProxies = TdApi.GetProxies

typealias TdGetProxyLink = TdApi.GetProxyLink

typealias TdPingProxy = TdApi.PingProxy

typealias TdSetLogStream = TdApi.SetLogStream

typealias TdGetLogStream = TdApi.GetLogStream

typealias TdSetLogVerbosityLevel = TdApi.SetLogVerbosityLevel

typealias TdGetLogVerbosityLevel = TdApi.GetLogVerbosityLevel

typealias TdGetLogTags = TdApi.GetLogTags

typealias TdSetLogTagVerbosityLevel = TdApi.SetLogTagVerbosityLevel

typealias TdGetLogTagVerbosityLevel = TdApi.GetLogTagVerbosityLevel

typealias TdAddLogMessage = TdApi.AddLogMessage

typealias TdTestCallEmpty = TdApi.TestCallEmpty

typealias TdTestCallString = TdApi.TestCallString

typealias TdTestCallBytes = TdApi.TestCallBytes

typealias TdTestCallVectorInt = TdApi.TestCallVectorInt

typealias TdTestCallVectorIntObject = TdApi.TestCallVectorIntObject

typealias TdTestCallVectorString = TdApi.TestCallVectorString

typealias TdTestCallVectorStringObject = TdApi.TestCallVectorStringObject

typealias TdTestSquareInt = TdApi.TestSquareInt

typealias TdTestNetwork = TdApi.TestNetwork

typealias TdTestProxy = TdApi.TestProxy

typealias TdTestGetDifference = TdApi.TestGetDifference

typealias TdTestUseUpdate = TdApi.TestUseUpdate

typealias TdTestReturnError = TdApi.TestReturnError
