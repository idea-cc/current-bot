package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.role
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.core.entity.Guild
import dev.kord.rest.builder.message.create.embed

class RoleInfoCommand: Extension() {
    override val name: String = "roleinfo"
    override suspend fun setup() {
        publicSlashCommand(::RoleInfoArguments) {
            name = "roleinfo"
            description = "Provides information about the given role."

            check {
                anyGuild()
            }

            action {
                val guild = this.guild?.asGuild() as Guild
                val targetRole = arguments.role

                respond {
                    embed {
                        title = "Role Information: ${targetRole.name}"
                        field {
                            name = "Raw Data:"
                            value = "**Role Name:** ${targetRole.name} " +
                                    "**Role Color:** ${targetRole.color}" +
                                    ""
                        }
                    }
                }
            }
        }
    }

    inner class RoleInfoArguments: Arguments() {
        val role by role {
            name = "role"
            description = "The role you want to lookup. It must be within the corresponding server."
        }
    }
}