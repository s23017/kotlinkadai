//package jp.ac.it_college.std.s23017.message.board.domain.repository
//
//import jp.ac.it_college.std.s23017.message.board.domain.model.Message
//import org.springframework.data.jpa.repository.JpaRepository
//
//interface MessageRepository : JpaRepository<Message, Long> {
//    fun findByThreadId(threadId: Long): List<Message>
//}