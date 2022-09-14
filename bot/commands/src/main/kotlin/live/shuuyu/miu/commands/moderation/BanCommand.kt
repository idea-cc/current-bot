package live.shuuyu.miu.commands.moderation

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.*
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.behavior.ban
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.days

class BanCommand : Extension() {
    override val name: String = "ban"
    @OptIn(ExperimentalTime::class)
    override suspend fun setup() {
        publicSlashCommand(::BanCommandArguments){
            name = "ban"
            description = "Bans a user from the server."

            check {
                anyGuild()
                hasPermission(Permission.BanMembers)
                requireBotPermissions(Permission.BanMembers)
            }

            action {
                val target = arguments.target
                val banreason = arguments.reason
                val intmessages = arguments.messages

                guild?.withStrategy(EntitySupplyStrategy.rest)?.ban(target.id) {
                    reason = banreason
                    deleteMessageDuration = 7.days
                }

                respond {
                    embed {
                        title = "User Banned"
                        description = "**User:** ${target.mention} \n" +
                                "**Ban Reason:** $banreason"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class BanCommandArguments : Arguments() {
        val target by user {
            name = "user"
            description = "The user you want to ban."
        }

        val reason by defaultingString {
            name = "reason"
            description = "Why the user is getting banned."
            defaultValue = "No reason provided."
        }

        val messages by defaultingInt {
            name = "int"
            description = "The number of days of messages you want to delete."
            defaultValue = 7
            validate {
                if (value < 0) {
                    throw DiscordRelayedException("You cannot delete less than 0 days worth of messages!")
                }
                if (value > 7) {
                    throw DiscordRelayedException("You cannot delete more than 7 days worth of messages!")
                }
            }
        }
    }
}