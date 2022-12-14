package live.shuuyu.miu.commands.moderation

import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class KickExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to kick.")
        val reason = optionalString("user", "The reason why the user was kicked.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val reason = args[options.reason] ?: "No reason provided."



        context.sendMessage {
            embed {
                timestamp = Clock.System.now()
            }
        }
    }
}