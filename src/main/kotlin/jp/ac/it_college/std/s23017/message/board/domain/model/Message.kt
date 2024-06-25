package jp.ac.it_college.std.s23017.message.board.domain.model

data class Message(
    val id: Long,
    val content: String,
    val userId: Long,
    val threadId: Long
)