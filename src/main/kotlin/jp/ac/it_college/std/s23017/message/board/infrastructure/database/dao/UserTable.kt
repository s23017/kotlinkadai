package jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao

import org.jetbrains.exposed.dao.id.LongIdTable

object UserTable : LongIdTable("users") {
    val viewName = varchar("view_name", 50)
    val email = varchar("email", 255).uniqueIndex()
    val password = varchar("password", 255)
}