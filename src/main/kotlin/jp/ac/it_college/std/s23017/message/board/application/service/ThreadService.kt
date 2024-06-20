package jp.ac.it_college.std.s23017.message.board.application.service

import jp.ac.it_college.std.s23017.message.board.domain.model.Thread
import jp.ac.it_college.std.s23017.message.board.domain.repository.ThreadRepository
import org.springframework.stereotype.Service

@Service
class ThreadService(private val threadRepository: ThreadRepository) {

    fun createThread(thread: Thread): Thread {
        return threadRepository.save(thread)
    }

    fun getAllThreads(): List<Thread> {
        return threadRepository.findAll()
    }

    fun getThreadById(id: Long): Thread? {
        return threadRepository.findById(id).orElse(null)
    }
}