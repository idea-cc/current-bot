package live.shuuyu.miu.commands.developer

import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments
import kotlin.system.exitProcess

class ShutdownExecutor : SlashCommandExecutor() {
    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        context.sendMessage {
            embed {
                timestamp = Clock.System.now()
            }
        }

        exitProcess(0)
    }
}