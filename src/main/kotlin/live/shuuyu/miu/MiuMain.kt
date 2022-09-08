package live.shuuyu.miu

import com.kotlindiscord.kord.extensions.ExtensibleBot
import dev.kord.common.entity.PresenceStatus
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import live.shuuyu.miu.Constants.TOKEN
import live.shuuyu.miu.commands.*

@OptIn(PrivilegedIntent::class)
suspend fun main() {
    val bot = ExtensibleBot(TOKEN) {
        applicationCommands {
            enabled = true
        }

        intents {
            +Intent.DirectMessages
            +Intent.GuildMembers
        }

        extensions {
            add(::UserCommand)
            add(::BotInfoCommand)
            add(::LatencyCommand)
            add(::GuildInfoCommand)
        }

        presence {
            status = PresenceStatus.Idle
            playing("In the moonlight skies")
        }
    }
    bot.start()
}