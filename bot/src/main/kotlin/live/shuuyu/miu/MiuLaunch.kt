package live.shuuyu.miu

import dev.kord.gateway.DefaultGateway
import kotlinx.coroutines.runBlocking

object MiuLaunch {
    suspend fun launch() {
        runBlocking {
            val token = System.getenv("TOKEN")

            val core = MiuCore("$token")
            core.registerCommands()

            val gateway = DefaultGateway {}
        }
    }
}

suspend fun main() {
    MiuLaunch.launch()
}