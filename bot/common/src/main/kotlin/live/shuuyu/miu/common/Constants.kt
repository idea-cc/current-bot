package live.shuuyu.miu.common

import com.kotlindiscord.kord.extensions.utils.env

object Constants {
    val TOKEN = env("TOKEN")

    const val KORD_VERSION = "0.8.0-M16"
    const val KORDEX_VERSION = "1.5.5-SNAPSHOT"
    const val KOTLIN_VERSION = "1.7.10"
}

const val MIU_TRANSLATION_BUNDLE = "miu.strings"
const val MIU_TRANSLATION_BUNDLE_KORDEX = "translations.miu.strings"
