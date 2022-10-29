package live.shuuyu.miu.commands

import dev.kord.core.Kord
import live.shuuyu.miu.MiuLaunch

abstract class AbstractCommandExtension() {
    abstract val name: String
    abstract val description: String
    val kord = MiuLaunch.client

    abstract suspend fun setup()
}