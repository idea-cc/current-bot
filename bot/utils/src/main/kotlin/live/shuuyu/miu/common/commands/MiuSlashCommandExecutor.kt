package live.shuuyu.miu.common.commands

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.Guild
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.SlashCommandArguments

/**
 * A slash command abstraction. We use this for most of the moderation commands, as we rely on guild for the most part.
 *
 * @since 0.0.1
 */
abstract class MiuSlashCommandExecutor : SlashCommandExecutor() {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    abstract suspend fun execute(
        context: GuildApplicationCommandContext,
        args: SlashCommandArguments
    )

    override suspend fun execute(
        context: ApplicationCommandContext,
        args: SlashCommandArguments
    ) {
    }

    private suspend fun executeCommand(
        rootDeclarationClazzName: String,
        executorClazzName: String,
        context: ApplicationCommandContext,
        args: SlashCommandArguments,
        guildId: Snowflake?,
        guild: Guild
    ) {

    }
}