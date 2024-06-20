package jp.ac.it_college.std.s23017.message.board.application.service

import jp.ac.it_college.std.s23017.message.board.domain.model.Message
import jp.ac.it_college.std.s23017.message.board.domain.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(private val messageRepository: MessageRepository) {

    fun createMessage(message: Message): Message {
        return messageRepository.save(message)
    }

    fun getMessagesByThreadId(threadId: Long): List<Message> {
        return messageRepository.findByThreadId(threadId)
    }
}