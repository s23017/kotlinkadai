package jp.ac.it_college.std.s23017.message.board.application.service

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    @Autowired private val userRepository: UserRepository,
    @Autowired private val passwordEncoder: PasswordEncoder
) {

    fun registerUser(name: String, email: String, rawPassword: String) {
        val encodedPassword = passwordEncoder.encode(rawPassword)
        val user = User(id = 0, name = name, email = email, password = encodedPassword)
        userRepository.save(user)
    }
}
