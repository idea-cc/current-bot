package live.shuuyu.miu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.converters.impl.optionalUser
import com.kotlindiscord.kord.extensions.commands.converters.impl.user
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import com.kotlindiscord.kord.extensions.utils.createdAt
import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.entity.UserFlag
import dev.kord.common.toMessageFormat
import dev.kord.core.supplier.EntitySupplyStrategy
import dev.kord.rest.builder.message.create.embed
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime

class UserCommand : Extension() {
    override val name: String = "user"
    @OptIn(ExperimentalTime::class)
    override suspend fun setup() {
        publicSlashCommand(::UserCommandArguments) {
            name = "user"
            description = "Looks up a user."

            check {
                anyGuild()
            }

            action {
                val target = arguments.userArgs ?: this.user.asUser()
                val userAvatar = user.withStrategy(EntitySupplyStrategy.rest).fetchUser().avatar
                val userJoinDate = target.withStrategy(EntitySupplyStrategy.rest).id.timestamp.toMessageFormat(DiscordTimestampStyle.ShortDateTime)

                respond {
                    embed {
                        title = "${target.username}#${target.discriminator}'s Info"
                        field {
                            name = "**User Join Date**: **$userJoinDate**"
                            inline = true
                        }
                        field {

                        }
                        timestamp = Clock.System.now()
                    }
                }
            }
        }
    }
    inner class UserCommandArguments : Arguments() {
        val userArgs by optionalUser {
            name = "user"
            description = "The user you want to lookup."
        }
    }

    private fun getBadge(flag: UserFlag): String {
        return when (flag) {
            UserFlag.DiscordEmployee -> "<:furry:907322194156224542>"
            UserFlag.DiscordPartner -> "<:partnered:907322256567447552>"
            UserFlag.BugHunterLevel1 -> "<:bug_hunter:907322130151141416>"
            UserFlag.BugHunterLevel2 -> "<:gold_bughunter:907322205917052978>"
            UserFlag.HypeSquad -> "<:hypesquad_events_v1:907322220056023080>"
            UserFlag.HouseBravery -> "<:bravery:907322115454300190>"
            UserFlag.HouseBrilliance -> "<:brilliance:907322122580406332>"
            UserFlag.HouseBalance -> "<:balance:907321974211108984>"
            UserFlag.EarlySupporter -> "<:early_supporter:907322161159626753>"
            UserFlag.TeamUser -> "`team user`"
            UserFlag.VerifiedBot -> "`verified bot`"
            UserFlag.VerifiedBotDeveloper -> "<:early_verified_developer:907322174329716818>"
            UserFlag.DiscordCertifiedModerator -> "<:certified_virgin:907322144109756426>"
            UserFlag.BotHttpInteractions -> "`http bot`"
            UserFlag.System -> "`System User`"
        }
    }
}