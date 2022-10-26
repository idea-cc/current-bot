package live.shuuyu.miu.commands.general.declartaions

import live.shuuyu.miu.commands.general.UserExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class UserCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("user", "Looks up a user.") {
        executor = UserExecutor()
    }
}