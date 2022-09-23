package live.shuuyu.miu.commands.moderation

import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import live.shuuyu.miu.MiuCore
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
class BanExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to ban.")
        val reason = optionalString("reason", "The reason why the user is banned.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val reason = args[options.reason]
        val moderator = context.sender

        context.sendMessage {
            embed {

            }
        }
    }
}