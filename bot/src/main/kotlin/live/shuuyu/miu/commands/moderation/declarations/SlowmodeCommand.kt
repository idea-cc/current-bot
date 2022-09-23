package live.shuuyu.miu.commands.moderation.declarations

import dev.kord.common.entity.*
import live.shuuyu.miu.commands.moderation.SlowmodeExecutor
import net.perfectdreams.discordinteraktions.common.commands.*

class SlowmodeCommand : SlashCommandDeclarationWrapper {
    override fun declaration() = slashCommand("slowmode", "Slows the channel down by the requested amount of seconds.") {
        defaultMemberPermissions = Permissions {
            + Permission.ManageChannels
        }
        executor = SlowmodeExecutor()
    }
}