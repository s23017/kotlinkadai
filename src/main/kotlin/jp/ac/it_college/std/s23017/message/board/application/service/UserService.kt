package jp.ac.it_college.std.s23017.message.board.application.service

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(viewName: String, email: String, password: String): User {
        val encodedPassword = passwordEncoder.encode(password)
        val user = User(viewName = viewName, email = email, password = encodedPassword)
        return userRepository.save(user)
    }

    fun find(userId: Long): User? {
        return userRepository.findById(userId)
    }
}
