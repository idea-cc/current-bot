package live.shuuyu.miu.commands.developer.declarations

import live.shuuyu.miu.commands.developer.ShutdownExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class ShutdownCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("shutdown", "Shuts down the bot.") {
        executor = ShutdownExecutor()
    }
}