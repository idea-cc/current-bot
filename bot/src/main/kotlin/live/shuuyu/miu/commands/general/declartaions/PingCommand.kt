package live.shuuyu.miu.commands.general.declartaions

import live.shuuyu.miu.commands.general.PingExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class PingCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("ping", "Pings the bot and show how bad your ping is.") {
        executor = PingExecutor()
    }
}