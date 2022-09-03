package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

class LatencyCommand : Extension() {
    override val name: String = "latency"
    override suspend fun setup() {
        publicSlashCommand {
            name = "latency"
            description = "Shows your ping between you and Miu"

            check {
                anyGuild()
            }

            action {
                val latency = this@LatencyCommand.kord.gateway.averagePing

                respond {
                    embed {
                        title = "Latency"
                        description = "Your latency with Miu is **$latency**"
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}