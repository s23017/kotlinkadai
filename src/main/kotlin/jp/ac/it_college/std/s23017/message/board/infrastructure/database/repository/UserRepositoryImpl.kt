package jp.ac.it_college.std.s23017.message.board.infrastructure.database.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.UserEntity
import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.UserTable
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepositoryImpl : UserRepository {

    override fun findById(id: Long): User? {
        return transaction {
            val userEntity = UserEntity.findById(id)
            userEntity?.toUser()
        }
    }

    override fun findByEmail(email: String): User? {
        return transaction {
            val userEntity = UserEntity.find { UserTable.email eq email }.firstOrNull()
            userEntity?.toUser()
        }
    }

    override fun save(user: User): User {
        return transaction {
            val newUserEntity = UserEntity.new {
                username = user.username
                password = user.password
                roleType = user.roleType
            }
            newUserEntity.toUser()
        }
    }

    override fun update(user: User): User {
        return transaction {
            val userEntity = UserEntity.findById(user.id) ?: throw IllegalArgumentException("User not found")
            userEntity.apply {
                username = user.username
                password = user.password
                roleType = user.roleType
            }
            userEntity.toUser()
        }
    }

    override fun delete(user: User) {
        transaction {
            val userEntity = UserEntity.findById(user.id) ?: throw IllegalArgumentException("User not found")
            userEntity.delete()
        }
    }
}