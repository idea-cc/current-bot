package live.shuuyu.miu.commands.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalChannel
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalInt
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.core.entity.channel.TextChannel

class PurgeCommand : Extension() {
    override val name: String = "purge"
    override suspend fun setup() {
        publicSlashCommand(::PurgeCommandArguments) {
            name = "purge"
            description = "Purges the specified amount of messages from the channel."

            check {
                anyGuild()
                hasPermission(Permission.ManageMessages)
                requireBotPermissions(Permission.ManageMessages)
            }

            action {
                val target = (arguments.targetChannel ?: this.channel.asChannel()) as TextChannel
                val intMessages = arguments.targetMessages

                suspend fun uploadMessagestoHastebin() {
                    try {

                    } catch (e: Exception) {
                        e
                    }
                }
            }
        }
    }
    inner class PurgeCommandArguments : Arguments() {
        val targetChannel by optionalChannel {
            name = "channel"
            description = "The channel you want to delete messages from."
        }
        val targetMessages by optionalInt {
            name = "messages"
            description = "The amount of messages you want to delete from the channel."
        }
    }
}