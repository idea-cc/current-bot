package live.shuuyu.miu

import dev.kord.common.entity.Snowflake
import live.shuuyu.miu.commands.general.declartaions.PingCommand
import net.perfectdreams.discordinteraktions.common.DiscordInteraKTions
import java.io.File

class MiuCore(token: String) {
    val interaKTions = DiscordInteraKTions(token = File("token.txt").readText(), APPLICATION_ID)

    suspend fun registerCommands() {
        interaKTions.manager.register(PingCommand())
    }
    companion object {
        val APPLICATION_ID = Snowflake("1008110839376646304")
    }
}