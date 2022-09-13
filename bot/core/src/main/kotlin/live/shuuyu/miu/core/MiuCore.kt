package live.shuuyu.miu.core

import com.kotlindiscord.kord.extensions.ExtensibleBot
import dev.kord.common.entity.PresenceStatus
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent
import live.shuuyu.miu.common.Constants.TOKEN

import live.shuuyu.miu.commands.general.*
import live.shuuyu.miu.commands.moderation.*

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
            add(::GuildCommand)

            add(::BanCommand)
        }

        presence {
            status = PresenceStatus.Idle
            playing("In the moonlight skies")
        }
    }
    bot.start()
}