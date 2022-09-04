package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.core.entity.Guild
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed

class GuildInfoCommand : Extension() {
    override val name: String = "guildinfo"
    override suspend fun setup() {
        publicSlashCommand {
            name = "guildinfo"
            description = "Shows information about this guild."

            check {
                anyGuild()
            }

            action {
                val targetGuild = this.guild?.asGuild()?.name
                val guildMemberAmount = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.memberCount
                val guildBoostLevel = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.premiumSubscriptionCount
                val guildOwner = guild?.withStrategy(EntitySupplyStrategy.rest)?.fetchGuild()?.getOwner()?.id

                // TODO: Fix Member count and guild owner stuff because it doesm't collect stuff correctly
                respond {
                    embed {
                        title = "$targetGuild's Information"
                        field {
                            name = "**Guild Owner**: **[**<@$guildOwner>**]**"
                        }
                        field {
                            name = "**Guild Member Amount**: **[$guildMemberAmount]**"
                            inline = true
                        }
                        field {
                            name = "**Server Boost Amount**: **[$guildBoostLevel]**"
                            inline = true
                        }
                    }
                }
            }
        }
    }
}