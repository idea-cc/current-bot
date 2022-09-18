package live.shuuyu.miu.commands.general.declartaions

import live.shuuyu.miu.commands.general.BotInfoExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class BotInfoCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("bot", "Provides information about the bot.") {
        executor = BotInfoExecutor()
    }
}