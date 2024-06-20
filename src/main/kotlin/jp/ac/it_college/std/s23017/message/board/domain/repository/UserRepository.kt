package jp.ac.it_college.std.s23017.message.board.domain.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): Optional<User>
}