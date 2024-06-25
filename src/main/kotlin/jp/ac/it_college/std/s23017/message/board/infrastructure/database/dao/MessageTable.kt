package jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object MessageTable : LongIdTable("message") {
    val content = varchar("content", 255)
    val userId = reference("user_id", UserTable)
    val threadId = reference("thread_id", ThreadTable)
}