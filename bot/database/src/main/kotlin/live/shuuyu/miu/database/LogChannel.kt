package live.shuuyu.miu.database

import dev.kord.common.entity.Snowflake
import org.jetbrains.exposed.sql.Table

@OptIn(ExperimentalUnsignedTypes::class)
object LogChannel : Table("logging_channels") {
    val moderationChannel = Snowflake("mod_logs")
}