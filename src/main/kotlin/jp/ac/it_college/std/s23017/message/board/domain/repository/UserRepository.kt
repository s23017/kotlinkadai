package jp.ac.it_college.std.s23017.message.board.domain.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.User

interface UserRepository {
    fun findByName(name: String): User?
    fun save(user: User): User
}
