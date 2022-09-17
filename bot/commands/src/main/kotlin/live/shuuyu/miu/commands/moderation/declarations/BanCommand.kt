package live.shuuyu.miu.commands.moderation.declarations

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.miu.commands.moderation.BanExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class BanCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("ban", "Bans the specified user from the server.") {
        dmPermission = true
        defaultMemberPermissions = Permissions {
            + Permission.BanMembers
        }
        executor = BanExecutor()
    }
}