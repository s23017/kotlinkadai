package jp.ac.it_college.std.s23017.message.board.infrastructure.database.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.UserEntity
import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.UserTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {

    override fun findByEmail(email: String): User? = transaction {
        UserEntity.find { UserTable.email eq email }.firstOrNull()?.toUser()
    }

    override fun findById(id: Long): User? = transaction {
        UserEntity.findById(id)?.toUser()
    }

    override fun save(user: User): User = transaction {
        val userEntity = UserEntity.new(user.id) {
            username = user.username
            password = user.password
            email = user.email
            roleType = user.roleType
        }
        userEntity.toUser()
    }
}