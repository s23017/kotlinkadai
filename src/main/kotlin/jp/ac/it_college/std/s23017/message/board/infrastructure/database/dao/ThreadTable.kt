package jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object ThreadTable : LongIdTable("thread") {
    val title = varchar("title", 255)
}