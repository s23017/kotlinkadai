package jp.ac.it_college.std.s23017.message.board.domain.model

import jp.ac.it_college.std.s23017.message.board.domain.types.RoleType

data class User(
    val id: Long,
    val username: String,
    val password: String,
    val roleType: RoleType
)