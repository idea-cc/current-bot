package live.shuuyu.miu.commands.moderation

import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.*
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class TimeoutExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to time out.")
        val reason = string("reason", "The reason why this user is getting timed out.")
        val timeout = string("time", "The amount of time the user is going to be timed out for.") {

        }
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val reason = args[options.reason]

        context.sendMessage {
            embed {
                timestamp = Clock.System.now()
            }
        }
    }
}