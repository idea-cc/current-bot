package live.shuuyu.miu.commands.moderation.declarations

import live.shuuyu.miu.commands.moderation.BanExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class BanCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("ban", "Bans the specified user from the server.") {
        executor = BanExecutor()
    }
}