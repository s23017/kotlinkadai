package jp.ac.it_college.std.s23017.message.board.application.service

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import org.jetbrains.exposed.dao.exceptions.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun findUserById(id: Long): User? {
        return userRepository.findById(id)
    }

    fun findUserByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    fun registerUser(user: User): User {
        // ここでパスワードのハッシュ化などのビジネスロジックを実装することができます
        return userRepository.save(user)
    }
}