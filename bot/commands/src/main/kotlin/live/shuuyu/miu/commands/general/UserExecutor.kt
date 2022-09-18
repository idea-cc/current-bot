package live.shuuyu.miu.commands.general

import dev.kord.common.DiscordTimestampStyle
import dev.kord.common.entity.UserFlag
import dev.kord.common.toMessageFormat
import kotlinx.datetime.Clock
import net.perfectdreams.discordinteraktions.common.builder.message.embed
import net.perfectdreams.discordinteraktions.common.commands.*
import net.perfectdreams.discordinteraktions.common.commands.options.*

class UserExecutor : SlashCommandExecutor() {
    inner class Options : ApplicationCommandOptions() {
        val user = optionalUser("user", "The user you want to lookup.")
    }

    override val options = Options()

    override suspend fun execute(context: ApplicationCommandContext, args: SlashCommandArguments) {
        val target = args[options.user] ?: context.sender
        val getflags = target.publicFlags?.flags?.joinToString(separator = " ") { getFlags(it) } ?: ""
        val username = target.username
        val discriminator = target.discriminator
        val joindate = target.id.timestamp.toMessageFormat(DiscordTimestampStyle.ShortDateTime)


        context.sendMessage {
            embed {
                title = "User Information: $username#$discriminator"
                field {

                }
                timestamp = Clock.System.now()
            }
        }
    }

    private fun getFlags(flag: UserFlag): String {
        return when (flag) {
            UserFlag.DiscordEmployee -> "<:stop_breaking_the_discord_api_nerds:907322194156224542>"
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