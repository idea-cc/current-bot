package live.shuuyu.miu.commands.moderation

import dev.kord.common.entity.ChannelType
import dev.kord.core.behavior.channel.edit
import dev.kord.core.entity.channel.TextChannel
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class SlowmodeExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val channel = optionalChannel("channel", "The channel you want to slow.") {
            channelTypes = listOf(
                ChannelType.GuildText
            )
        }
        val time = integer("time", "The amount of time you want to slow the channel by.") {

        }
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.channel] as TextChannel
        val time = args[options.time].toDuration(DurationUnit.SECONDS)

        target.edit {
            rateLimitPerUser = time
        }

        context.sendMessage {

        }
    }
}