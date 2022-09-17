package live.shuuyu.miu.core

import kotlinx.coroutines.runBlocking
import java.io.File

object MiuCore {
    suspend fun launch() {
        runBlocking {
            val env = File(".env").readText()
        }
    }
}

suspend fun main() {
    MiuCore.launch()
}