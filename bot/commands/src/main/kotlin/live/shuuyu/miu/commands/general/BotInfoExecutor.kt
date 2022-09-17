package live.shuuyu.miu.commands.general

import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.*
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class BotInfoExecutor : SlashCommandExecutor() {
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val javaVersion = System.getProperty("java.version")

        context.sendMessage {
            embed {
                title = "Bot Information"
                timestamp = Clock.System.now()
            }
        }
    }
}