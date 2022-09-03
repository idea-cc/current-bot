package live.shuuyu.miu

import com.kotlindiscord.kord.extensions.ExtensibleBot
import live.shuuyu.miu.Constants.TOKEN
import live.shuuyu.miu.commands.BotInfoCommand
import live.shuuyu.miu.commands.UserCommand

suspend fun main() {
    val bot = ExtensibleBot(TOKEN) {
        applicationCommands {
            enabled = true
        }

        extensions {
            add(::UserCommand)
            add(::BotInfoCommand)
        }
    }
    bot.start()
}