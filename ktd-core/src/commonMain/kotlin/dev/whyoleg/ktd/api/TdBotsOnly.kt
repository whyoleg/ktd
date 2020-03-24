package dev.whyoleg.ktd.api

/**
 * Annotation mark fields that can be used only by bots
 */
@RequiresOptIn("Fields annotated with such annotation can be used only by bots", RequiresOptIn.Level.WARNING)
annotation class TdBotsOnly