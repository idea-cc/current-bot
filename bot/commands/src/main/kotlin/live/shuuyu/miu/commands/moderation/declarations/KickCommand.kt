package live.shuuyu.miu.commands.moderation.declarations

import dev.kord.common.entity.*
import live.shuuyu.miu.commands.moderation.KickExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class KickCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("kick", "Kicks the specified user from the server.") {
        defaultMemberPermissions = Permissions {
            + Permission.KickMembers
        }
        executor = KickExecutor()
    }
}