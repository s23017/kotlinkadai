package jp.ac.it_college.std.s23017.message.board.presentation.form

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserRequest(
    val username: String,
    val email: String,
    val password: String
)