package live.shuuyu.miu.utils

import com.kotlindiscord.kord.extensions.commands.CommandContext
import com.kotlindiscord.kord.extensions.commands.converters.builders.ValidationContext
import com.kotlindiscord.kord.extensions.i18n.TranslationsProvider
import dev.kord.common.Locale
import live.shuuyu.miu.MIU_TRANSLATION_BUNDLE
import live.shuuyu.miu.MIU_TRANSLATION_BUNDLE_KORDEX
import org.jetbrains.annotations.PropertyKey

object TranslationEmbed {
    suspend fun CommandContext.tr(
        @PropertyKey(resourceBundle = MIU_TRANSLATION_BUNDLE) key: String,
        vararg replacements: Any?
    ): String =
        translationsProvider.translate(key, getLocale(), MIU_TRANSLATION_BUNDLE_KORDEX, replacements.asList().toTypedArray())

    suspend fun ValidationContext<*>.tr(
        @PropertyKey(resourceBundle = MIU_TRANSLATION_BUNDLE) key: String,
        vararg replacements: Any?
    ): String =
        translations.translate(key, context.getLocale(), MIU_TRANSLATION_BUNDLE_KORDEX, replacements.asList().toTypedArray())

}