package live.shuuyu.miu

import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord
import dev.kord.gateway.DefaultGateway
import dev.kord.gateway.Intents
import dev.kord.gateway.PrivilegedIntent
import kotlinx.coroutines.runBlocking
import java.io.File

object MiuLaunch {
    lateinit var client: Kord
    @OptIn(PrivilegedIntent::class)
    suspend fun launch(token: String) {
        client = Kord(token)

        client.login {
            presence {
                status = PresenceStatus.Idle
            }
            intents = Intents.all
        }

    }
}

suspend fun main(args: Array<String>) {
    runBlocking {
        MiuLaunch.launch(File("token.txt").readText())
    }
}