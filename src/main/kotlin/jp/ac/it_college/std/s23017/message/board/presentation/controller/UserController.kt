package jp.ac.it_college.std.s23017.message.board.presentation.controller

import jp.ac.it_college.std.s23017.message.board.application.service.UserService
import jp.ac.it_college.std.s23017.message.board.domain.model.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(userService.registerUser(user))
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User?> {
        return ResponseEntity.ok(userService.findUserById(id))
    }
}