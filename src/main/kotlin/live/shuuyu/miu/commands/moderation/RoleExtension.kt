package live.shuuyu.miu.commands.moderation

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.role
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed

class RoleExtension : Extension() {
    override val name: String = "role"
    override suspend fun setup() {
        publicSlashCommand(::RoleExtensionArguments) {
            name = "role"
            description = "Information about roles."

            check {
                anyGuild()
            }

            publicSubCommand(::GiveRoleArguments) {
                name = "grant" + "give"
                description = "Gives the role to the specified user."

                check {
                    anyGuild()
                    hasPermission(Permission.ManageRoles)
                    requireBotPermissions(Permission.ManageRoles)
                }

                action {
                    val userTarget = guild?.let { arguments.targetGrantUser.asMember(it.id) }
                    val roleTarget = arguments.targetGrantRole.asRole()

                    userTarget?.withStrategy(EntitySupplyStrategy.rest)?.addRole(roleTarget.id)

                    respond {
                        embed {
                            title = "Role Given"
                            if (userTarget != null) {
                                description = "The role, <@${roleTarget.id}>, as been given to <@${userTarget.id}>"
                            }
                        }
                    }
                }
            }
        }
    }
    inner class RoleExtensionArguments: Arguments() {

    }

    inner class GiveRoleArguments: Arguments() {
        val targetGrantUser by user {
            name = "user"
            description = "The user you want to grant the role to."
        }
        val targetGrantRole by role {
            name = "role"
            description = "The role you want to grant the specified user."
        }
    }
    inner class RemoveRoleArguments: Arguments() {
        val targetRevokeUser by user {
            name = "user"
            description = "The user you want to revoke the role to."
        }
        val targetRevokeRole by role {
            name = "role"
            description = "The role you want to revoke from the specified user."
            validate {

            }
        }
    }
}