package jp.ac.it_college.std.s23017.message.board.domain.model

import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val id = long("id").autoIncrement()
    val name = varchar("name", 64)
    val email = varchar("email", 128) // 新たに追加
    val password = varchar("password", 60)

    override val primaryKey = PrimaryKey(id)
}

data class User(
    val id: Long,
    val name: String,
    val email: String, // 新たに追加
    val password: String
)
