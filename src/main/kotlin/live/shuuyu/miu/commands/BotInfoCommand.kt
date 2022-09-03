package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class BotInfoCommand : Extension() {
    override val name: String = "botinfo"
    override suspend fun setup() {
        publicSlashCommand {
            name = "botinfo"
            description = "Shows you information about the specified bot."

            check {
                anyGuild()
            }

            action {
                val javaVersion = System.getProperty("java.version")
                val osName = System.getProperty("os.name")
                val osRevision = System.getProperty("os.version")

                respond {
                    embed {
                        title = "Miu information"
                        field {
                            name = "**OS Revision Version** >>> **[$osRevision]**"
                            inline = true
                        }
                        field {
                            name = "**Operating System** >>> **[$osName]**"
                            inline = true
                        }
                        field {
                            name = "**Java Version** >>> **[$javaVersion]**"
                            inline = true
                        }

                        footer {
                            text = "Made by IDEA-CC. Licensed under the CC-BY-NC-SA-4.0 license."
                        }

                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}