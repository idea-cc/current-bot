package live.shuuyu.miu

import com.kotlindiscord.kord.extensions.utils.env

object Constants {
    val TOKEN = env("TOKEN")
}

const val MIU_TRANSLATION_BUNDLE = "miu.strings"
const val MIU_TRANSLATION_BUNDLE_KORDEX = "translations.miu.strings"
