package live.shuuyu.miu.utils

import com.kotlindiscord.kord.extensions.commands.CommandContext
import com.kotlindiscord.kord.extensions.commands.converters.builders.ValidationContext
import com.kotlindiscord.kord.extensions.i18n.TranslationsProvider
import org.jetbrains.annotations.PropertyKey
import live.shuuyu.miu.*
import java.util.*

object TranslationEmbed {
    fun TranslationsProvider.tr(
        @PropertyKey(resourceBundle = MIU_TRANSLATION_BUNDLE) key: String,
        locale: Locale,
        vararg replacements: Any?
    ): String =
        translate(key, locale, MIU_TRANSLATION_BUNDLE_KORDEX, replacements.asList().toTypedArray())

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