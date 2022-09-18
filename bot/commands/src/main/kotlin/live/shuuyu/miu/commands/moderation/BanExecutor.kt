package live.shuuyu.miu.commands.moderation

import dev.kord.core.behavior.ban
import dev.kord.core.entity.Guild
import dev.kord.core.supplier.EntitySupplyStrategy
import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*
import kotlin.time.Duration.Companion.days
import kotlin.time.ExperimentalTime
import kotlin.time.days

class BanExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = user("user", "The user you want to ban.")
        val reason = optionalString("reason", "The reason why the user is banned.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user]
        val reason = args[options.reason]

        context.sendMessage {
            embed {
                timestamp = Clock.System.now()

                footer {
                    text = "Licensed under the LGPL-3.0 license."
                }
            }
        }
    }
}