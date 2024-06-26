//package jp.ac.it_college.std.s23017.message.board.presentation.controller
//
//import jp.ac.it_college.std.s23017.message.board.application.service.MessageService
//import jp.ac.it_college.std.s23017.message.board.domain.model.Message
//import org.springframework.http.ResponseEntity
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("/api/messages")
//class MessageController(private val messageService: MessageService) {
//
//    @PostMapping
//    fun createMessage(@RequestBody message: Message): ResponseEntity<Message> {
//        return ResponseEntity.ok(messageService.createMessage(message))
//    }
//
//    @GetMapping("/thread/{threadId}")
//    fun getMessagesByThreadId(@PathVariable threadId: Long): ResponseEntity<List<Message>> {
//        return ResponseEntity.ok(messageService.getMessagesByThreadId(threadId))
//    }
//}