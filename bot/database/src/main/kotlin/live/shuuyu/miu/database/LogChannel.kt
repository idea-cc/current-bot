package live.shuuyu.miu.database

import org.jetbrains.exposed.dao.id.LongIdTable

object LogChannel : LongIdTable("logging_channels") {
    val moderationChannel = long("channel").index()
}