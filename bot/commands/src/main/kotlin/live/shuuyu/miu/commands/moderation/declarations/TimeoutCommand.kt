package live.shuuyu.miu.commands.moderation.declarations

import dev.kord.common.entity.*
import live.shuuyu.miu.commands.moderation.TimeoutExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class TimeoutCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("timeout", "Times out the user for the specified amaount of time.") {
        dmPermission = true
        defaultMemberPermissions = Permissions {
            + Permission.ModerateMembers
        }
        executor = TimeoutExecutor()
    }
}