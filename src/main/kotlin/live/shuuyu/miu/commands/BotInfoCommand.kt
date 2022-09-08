package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.components.components
import com.kotlindiscord.kord.extensions.components.linkButton
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
                        title = "Miu Information"
                        field {
                            name = "Miu Libraries and Core Utilities"
                            value = "**Java Version:** $javaVersion"
                                    "**Operating System:** $osName " +
                                    "**Operating System Version:** $osRevision"
                        }
                        field {

                        }

                        footer {
                            text = "Made by IDEA-CC. Licensed under the LGPL-3.0 license."
                        }

                        timestamp = Clock.System.now()
                    }
                    components {
                        linkButton {
                            label = "Source Code"
                            url = "https://github.com/idea-cc/current-bot"
                        }
                    }
                }
            }
        }
    }
}