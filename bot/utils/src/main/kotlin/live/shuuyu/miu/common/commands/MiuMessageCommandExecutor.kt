package live.shuuyu.miu.common.commands

import mu.KotlinLogging
import net.perfectdreams.discordinteraktions.common.commands.MessageCommandExecutor

abstract class MiuMessageCommandExecutor : MessageCommandExecutor() {
    companion object {
        private val logger = KotlinLogging.logger {}
    }
}