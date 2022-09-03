package live.shuuyu.miu.checks

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.types.CheckContext

suspend fun CheckContext<*>.isGuildOwner() {
    anyGuild()

    if (!passed) {
        return
    }
}