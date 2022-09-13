package live.shuuyu.miu.commands.moderation

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.defaultingString
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class UnbanCommand : Extension() {
    override val name: String = "unban"
    override suspend fun setup() {
        publicSlashCommand(::UnbanCommandArguments) {
            name = "unban"
            description = "Unbans a user from the server."

            check {
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {
                val target = arguments.target
                val reason = arguments.reason


                guild?.withStrategy(EntitySupplyStrategy.rest)?.unban(target.id)

                respond {
                    embed {
                        title = "User Unbanned"
                        description = "**User Unbanned:** ${target.mention} \n" +
                                "**Reason:** $reason"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class UnbanCommandArguments : Arguments() {
        val target by user {
            name = "user"
            description = "The user you want to unban."
        }

        val reason by defaultingString {
            name = "reason"
            description = "The reason why the user was unbanned."
            defaultValue = "No reason provided."
        }
    }
}