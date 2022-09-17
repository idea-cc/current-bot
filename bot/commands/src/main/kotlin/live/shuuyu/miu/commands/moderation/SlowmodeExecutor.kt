package live.shuuyu.miu.commands.moderation

import dev.kord.core.entity.channel.TextChannel
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class SlowmodeExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val channel = optionalChannel("channel", "The channel you want to slow.")
        val time =  string("time", "The amount of time you want to slow the channel by.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.channel] as TextChannel

        target.userRateLimit

        context.sendMessage {

        }
    }
}