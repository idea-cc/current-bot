package live.shuuyu.miu.commands.moderation.declarations

import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions
import live.shuuyu.miu.commands.moderation.UnbanExecutor
import net.perfectdreams.discordinteraktions.common.commands.SlashCommandDeclarationWrapper
import net.perfectdreams.discordinteraktions.common.commands.slashCommand

class UnbanCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("unban", "Unbans the user from the server.") {
        dmPermission = true
        defaultMemberPermissions = Permissions {
            + Permission.BanMembers
        }
        executor = UnbanExecutor()
    }
}