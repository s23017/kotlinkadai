package jp.ac.it_college.std.s23017.message.board.domain.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.Thread

interface ThreadRepository {
    fun findAll(): List<Thread>
    fun findById(id: Long): Thread?
    fun save(thread: Thread): Thread
    fun delete(thread: Thread)
}

