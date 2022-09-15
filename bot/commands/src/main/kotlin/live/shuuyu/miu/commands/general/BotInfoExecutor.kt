package live.shuuyu.miu.commands.general

import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class BotInfoExecutor : SlashCommandExecutor() {
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        context.sendMessage {
            embed {
                title = "Bot Information"
                description = ""
                timestamp = Clock.System.now()
            }
        }
    }
}