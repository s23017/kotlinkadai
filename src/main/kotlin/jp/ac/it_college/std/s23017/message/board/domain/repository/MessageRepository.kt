package jp.ac.it_college.std.s23017.message.board.domain.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.Message

interface MessageRepository {
    fun findByThreadId(threadId: Long): List<Message>
    fun findById(id: Long): Message?
    fun save(message: Message): Message
    fun delete(message: Message)
}
