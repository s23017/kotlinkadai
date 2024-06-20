package jp.ac.it_college.std.s23017.message.board.presentation.controller

import jp.ac.it_college.std.s23017.message.board.application.service.ThreadService
import jp.ac.it_college.std.s23017.message.board.domain.model.Thread
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/threads")
class ThreadController(private val threadService: ThreadService) {

    @PostMapping
    fun createThread(@RequestBody thread: Thread): ResponseEntity<Thread> {
        return ResponseEntity.ok(threadService.createThread(thread))
    }

    @GetMapping
    fun getAllThreads(): ResponseEntity<List<Thread>> {
        return ResponseEntity.ok(threadService.getAllThreads())
    }

    @GetMapping("/{id}")
    fun getThreadById(@PathVariable id: Long): ResponseEntity<Thread?> {
        return ResponseEntity.ok(threadService.getThreadById(id))
    }
}