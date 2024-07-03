//package jp.ac.it_college.std.s23017.message.board.application.service
//
//import jp.ac.it_college.std.s23017.message.board.domain.model.Message
//import jp.ac.it_college.std.s23017.message.board.domain.repository.MessageRepository
//import jp.ac.it_college.std.s23017.message.board.domain.repository.ThreadRepository
//import jp.ac.it_college.std.s23017.message.board.domain.repository.UserRepository
//import org.springframework.stereotype.Service
//
//@Service
//class MessageService(
//    private val messageRepository: MessageRepository,
//    private val threadRepository: ThreadRepository,
//    private val userRepository: UserRepository
//) {
//    fun getListByThread(threadId: Long): List<Message> {
//        return messageRepository.findByThreadId(threadId)
//    }
//
//    fun newPost(threadId: Long, message: String, userId: Long): Message {
//        val thread = threadRepository.findById(threadId)
//            ?: throw IllegalArgumentException("Thread not found")
//        val user = userRepository.findById(userId)
//            ?: throw IllegalArgumentException("User not found")
//        val newMessage = Message(message = message, thread = thread, user = user)
//        messageRepository.save(newMessage)
//        return newMessage
//    }
//
//    fun updateMessage(id: Long, message: String, userId: Long): Message {
//        val existingMessage = messageRepository.findById(id)
//            ?: throw IllegalArgumentException("Message not found")
//        if (existingMessage.user.id != userId) {
//            throw IllegalAccessException("Unauthorized user")
//        }
//        existingMessage.message = message
//        messageRepository.save(existingMessage)
//        return existingMessage
//    }
//
//    fun deleteMessage(id: Long, userId: Long): Message {
//        val existingMessage = messageRepository.findById(id)
//            ?: throw IllegalArgumentException("Message not found")
//        if (existingMessage.user.id != userId) {
//            throw IllegalAccessException("Unauthorized user")
//        }
//        messageRepository.delete(existingMessage)
//        return existingMessage
//    }
//}
