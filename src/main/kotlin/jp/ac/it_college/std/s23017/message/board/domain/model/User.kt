package jp.ac.it_college.std.s23017.message.board.domain.model

import kotlinx.datetime.LocalDateTime

data class User(
    val id: Long? = null,
    val viewName: String,
    val email: String,
    val password: String,
    val roleType: String = "USER",
    val createdAt: LocalDateTime? = null,
    val updatedAt: LocalDateTime? = null
)