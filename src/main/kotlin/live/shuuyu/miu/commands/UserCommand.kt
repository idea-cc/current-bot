package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.utils.createdAt
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class UserCommand : Extension() {
    override val name: String = "user"
    override suspend fun setup() {
        publicSlashCommand(::UserCommandArguments) {
            name = "user"
            description = "Looks up a user."

            check {
                anyGuild()
            }

            action {
                val target = arguments.userArgs ?: this.user.asUser()
                val userAvatar = user.withStrategy(EntitySupplyStrategy.rest).fetchUser().avatar
                val userJoinDate = user.fetchUser().createdAt

                respond {
                    embed {
                        title = "User Lookup"
                        description = "User, <@${target.id}>, joined Discord at $userJoinDate"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class UserCommandArguments : Arguments() {
        val userArgs by optionalUser {
            name = "user"
            description = "The user you want to lookup."
        }
    }
}