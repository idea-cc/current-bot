package live.shuuyu.miu.common.commands

import dev.kord.common.entity.Snowflake
import dev.kord.core.entity.*
import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.entities.messages.Message

abstract class MiuUserCommandExecutor : UserCommandExecutor() {
    companion object {
        private val logger = KotlinLogging.logger {}
    }

    // TODO: Fix this because it brokey
    /*
    abstract suspend fun execute(
        context: UserCommandExecutor,
        user: User,
        member: Member?
    )

    override suspend fun execute(
        context: UserCommandExecutor,
        user: User,
        member: Member?
    ) {
        logger.info {  }
    }
     */

    private suspend fun executeCommand(
        rootDeclarationClazzName: String,
        executorClazzName: String,
        context: ApplicationCommandContext,
        guildId: Snowflake?,
        targetMessage: Message
    ) {

    }
}