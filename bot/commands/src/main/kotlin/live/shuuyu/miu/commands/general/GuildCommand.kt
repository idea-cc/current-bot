package live.shuuyu.miu.commands.general

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.toMessageFormat
import dev.kord.core.entity.Guild
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import kotlinx.coroutines.flow.count
import kotlinx.datetime.Clock

class GuildCommand : Extension() {
    override val name: String = "guildinfo"
    override suspend fun setup() {
        publicSlashCommand {
            name = "guild"
            description = "Shows information about this guild."

            check {
                anyGuild()
            }

            action {
                val targetGuild = this.guild?.asGuild() as Guild
                val guildMemberAmount = targetGuild.withStrategy(EntitySupplyStrategy.rest).fetchGuild().memberCount
                val guildBoostLevel = targetGuild.withStrategy(EntitySupplyStrategy.rest).premiumSubscriptionCount
                val guildOwner = targetGuild.withStrategy(EntitySupplyStrategy.rest).fetchGuild().ownerId
                val guildCreationDate = targetGuild.withStrategy(EntitySupplyStrategy.rest).id.timestamp.toMessageFormat(
                    DiscordTimestampStyle.ShortDateTime)
                val getRoles = targetGuild.withStrategy(EntitySupplyStrategy.rest).roleIds

                respond {
                    embed {
                        title = "Guild Information: ${targetGuild.name}"
                        field {
                            name = "> General Information:"
                            value = "**Guild Creation Date:** $guildCreationDate \n" +
                                    "**Guild Owner:** <@$guildOwner>\n " +
                                    "**Server Boost Amount:** $guildBoostLevel \n" +
                                    "**Guild Member Amount:** $guildMemberAmount \n"
                        }
                        field {
                            name = "> Server Levels:"
                            value = "**Server Verification Level:** ${targetGuild.verificationLevel.value} \n" +
                                    "**Content Filter Level:** ${targetGuild.contentFilter.value} \n" +
                                    "**Server NSFW Level:** ${targetGuild.nsfw.value} \n"
                        }

                        field {
                            name = "> Role Count: [${targetGuild.roles.count()}]"
                            value = "**Roles:** $getRoles"
                        }

                        field {
                            name = "> Text Channel Count: [${targetGuild.channels.count()}]"
                            value = "**Channels:** #${targetGuild.channelIds}"
                        }

                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
}