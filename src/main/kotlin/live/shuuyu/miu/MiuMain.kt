package live.shuuyu.miu

import com.kotlindiscord.kord.extensions.ExtensibleBot
import dev.kord.common.entity.PresenceStatus
import live.shuuyu.miu.Constants.TOKEN
import live.shuuyu.miu.commands.*

suspend fun main() {
    val bot = ExtensibleBot(TOKEN) {
        applicationCommands {
            enabled = true
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