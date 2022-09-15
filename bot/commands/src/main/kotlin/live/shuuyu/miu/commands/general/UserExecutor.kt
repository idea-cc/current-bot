package live.shuuyu.miu.commands.general

import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class UserExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = optionalUser("user", "The user you want to lookup.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user] ?: context.sender

        context.sendMessage {
            embed {
                title = ""
                timestamp = Clock.System.now()
            }
        }
    }
}