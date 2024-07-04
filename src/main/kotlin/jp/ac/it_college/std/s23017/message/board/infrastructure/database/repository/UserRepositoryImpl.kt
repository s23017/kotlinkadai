package jp.ac.it_college.std.s23017.message.board.infrastructure.database.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import jp.ac.it_college.std.s23017.message.board.domain.model.Users
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {

    override fun findByName(name: String): User? {
        return transaction {
            Users.select { Users.name eq name }
                .map { toUser(it) }
                .singleOrNull()
        }
    }

    override fun save(user: User): User {
        val userId = transaction {
            Users.insert {
                it[name] = user.name
                it[email] = user.email // 追加
                it[password] = user.password
            } get Users.id
        }
        return user.copy(id = userId)
    }

    private fun toUser(row: ResultRow): User =
        User(
            id = row[Users.id],
            name = row[Users.name],
            email = row[Users.email], // 追加
            password = row[Users.password]
        )
}
