package live.shuuyu.miu.commands.general.declartaions

import live.shuuyu.miu.commands.general.GuildExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class GuildCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand(
        "guild",
        "Shows you information about the current guild."
    ) {
        executor = GuildExecutor()
    }
}