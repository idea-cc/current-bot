package live.shuuyu.miu.commands.moderation

import net.perfectdreams.discordinteraktions.common.commands.ApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.options.ApplicationCommandOptions
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class UnbanExecutor : SlashCommandExecutor() {
    inner class Options: ApplicationCommandOptions() {
        val user = user("unban", "Unbans the specified user from the server.")
        val reason = optionalString("reason", "The reason why the user is being unbanned from the server.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val reason = args[options.reason]

    }
}