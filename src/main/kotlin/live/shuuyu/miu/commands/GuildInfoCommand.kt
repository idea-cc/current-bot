package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.toMessageFormat
import dev.kord.core.entity.Guild
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock

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
                val targetGuild = this.guild?.asGuild() as Guild
                val guildMemberAmount = targetGuild.withStrategy(EntitySupplyStrategy.rest).fetchGuild().memberCount
                val guildBoostLevel = targetGuild.withStrategy(EntitySupplyStrategy.rest).premiumSubscriptionCount
                val guildOwner = targetGuild.withStrategy(EntitySupplyStrategy.rest).fetchGuild().ownerId
                val guildCreationDate = targetGuild.withStrategy(EntitySupplyStrategy.rest).id.timestamp.toMessageFormat(DiscordTimestampStyle.ShortDateTime)

                // TODO: Fix Member count and guild owner stuff because it doesn't collect stuff correctly
                respond {
                    embed {
                        title = "Guild Information: ${targetGuild.name}"
                        field {
                            name = "General Information:"
                            value = "**Guild Creation Date:** $guildCreationDate" +
                                    "**Guild Owner:** <@$guildOwner>" +
                                    "**Server Boost Amount:** $guildBoostLevel" +
                                    "**Guild Member Amount:** $guildMemberAmount"
                        }
                        field {
                            name = "Roles:"
                        }
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}