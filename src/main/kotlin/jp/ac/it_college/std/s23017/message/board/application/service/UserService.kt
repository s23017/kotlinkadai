package jp.ac.it_college.std.s23017.message.board.application.service

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun registerUser(user: User): User {
        val encodedPassword = passwordEncoder.encode(user.password)
        val userWithEncodedPassword = user.copy(password = encodedPassword)
        return userRepository.save(userWithEncodedPassword)
    }

    fun findUserByEmail(email: String): Optional<User> {
        return userRepository.findByEmail(email)
    }

    fun findUserById(id: Long): User? {
        return userRepository.findById(id).orElse(null)
    }
}