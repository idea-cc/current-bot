package live.shuuyu.miu.commands

import dev.kord.core.behavior.reply
import dev.kord.core.entity.Message
import dev.kord.rest.builder.message.create.embed

object HelpCommand : AbstractCommandExtension() {
    override val name = "help"
    override val description = "Description of the command"

    override suspend fun setup() {
        TODO("Not yet implemented")
    }

    private suspend fun help(message: Message) {
        message.reply {
            embed {
                title = "Why did you execute this command"
                description = "This was not worth it"
            }
        }
    }
}