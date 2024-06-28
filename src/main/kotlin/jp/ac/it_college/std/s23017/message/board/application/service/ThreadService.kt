package jp.ac.it_college.std.s23017.message.board.application.service

import jp.ac.it_college.std.s23017.message.board.domain.model.Thread
import jp.ac.it_college.std.s23017.message.board.domain.repository.ThreadRepository
import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class ThreadService(
    private val threadRepository: ThreadRepository,
    private val userRepository: UserRepository
) {
    fun getList(): List<Thread> {
        return threadRepository.findAll()
    }

    fun newPost(title: String, message: String, userId: Long): Long {
        val user = userRepository.findById(userId)
            ?: throw IllegalArgumentException("User not found")
        val thread = Thread(title = title, user = user)
        threadRepository.save(thread)
        return thread.id
    }

    fun updateTitle(id: Long, title: String, userId: Long): Thread {
        val thread = threadRepository.findById(id)
            ?: throw IllegalArgumentException("Thread not found")
        if (thread.user.id != userId) {
            throw IllegalAccessException("Unauthorized user")
        }
        thread.title = title
        threadRepository.save(thread)
        return thread
    }

    fun delete(id: Long, userId: Long): Thread {
        val thread = threadRepository.findById(id)
            ?: throw IllegalArgumentException("Thread not found")
        if (thread.user.id != userId) {
            throw IllegalAccessException("Unauthorized user")
        }
        threadRepository.delete(thread)
        return thread
    }

    fun getDetails(threadId: Long): Thread {
        return threadRepository.findById(threadId)
            ?: throw IllegalArgumentException("Thread not found")
    }
}
