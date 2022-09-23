package live.shuuyu.miu.commands.moderation

import live.shuuyu.miu.utils.MiuSlashCommandExecutor
import net.perfectdreams.discordinteraktions.common.commands.GuildApplicationCommandContext
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

class TestCommand : MiuSlashCommandExecutor() {
    override suspend fun execute(context: GuildApplicationCommandContext, args: SlashCommandArguments) {
        context.sendMessage {

        }
    }
}