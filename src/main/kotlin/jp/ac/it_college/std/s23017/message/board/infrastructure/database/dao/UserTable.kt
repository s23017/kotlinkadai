package jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao

import jp.ac.it_college.std.s23017.message.board.domain.type.RoleType
import org.jetbrains.exposed.dao.id.LongIdTable

object UserTable : LongIdTable("user") {
    val username = varchar("username", 256).uniqueIndex()
    val password = varchar("password", 128)
    val email = varchar("email", 256).uniqueIndex()
    val roleType = enumerationByName("role_type", 50, RoleType::class)
}