package jp.ac.it_college.std.s23017.message.board.domain.model

data class User(
    val id: Long? = null,
    val viewName: String,
    val email: String,
    val password: String
)