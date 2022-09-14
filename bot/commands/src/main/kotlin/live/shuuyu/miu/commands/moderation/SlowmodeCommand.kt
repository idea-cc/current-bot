package live.shuuyu.miu.commands.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.int
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.entity.channel.TextChannel
import kotlinx.datetime.DateTimePeriod

class SlowmodeCommand : Extension() {
    override val name: String = "slowmode"
    override suspend fun setup() {
        publicSlashCommand(::SlowmodeCommandArguments) {
            name = "slowmode"
            description = "Sets a slowmode for the provided channel."

            check {
                anyGuild()
                hasPermission(Permission.ManageChannels)
                requireBotPermissions(Permission.ManageChannels)
            }

        }
    }
    inner class SlowmodeCommandArguments : Arguments() {
        val channel by optionalChannel {
            name = "channel"
            description = "The channel you want to slow."
        }
        val time by int {
            name = "time"
            description = "The time you want to slow the chat by."
        }
    }
}