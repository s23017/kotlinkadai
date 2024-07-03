package jp.ac.it_college.std.s23017.message.board.infrastructure.database.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.UserEntity
import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.UserTable
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    override fun findByEmail(email: String): User? {
        return transaction {
            UserEntity.find { UserTable.email eq email }.singleOrNull()?.toDomain()
        }
    }

    override fun findById(id: Long): User? {
        return transaction {
            UserEntity.findById(id)?.toDomain()
        }
    }

    override fun save(user: User): User {
        return transaction {
            val userEntity = if (user.id == null) {
                UserEntity.new {
                    viewName = user.viewName
                    email = user.email
                    password = user.password
                }
            } else {
                val existingUser = UserEntity.findById(user.id)
                    ?: throw IllegalArgumentException("User not found")
                existingUser.apply {
                    viewName = user.viewName
                    email = user.email
                    password = user.password
                }
            }
            userEntity.toDomain()
        }
    }

    private fun UserEntity.toDomain(): User {
        return User(
            id = this.id.value,
            viewName = this.viewName,
            email = this.email,
            password = this.password
        )
    }
}