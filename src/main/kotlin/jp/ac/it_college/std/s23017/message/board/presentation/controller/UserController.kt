package jp.ac.it_college.std.s23017.message.board.presentation.controller

import jp.ac.it_college.std.s23017.message.board.application.service.UserService
import jp.ac.it_college.std.s23017.message.board.presentation.form.RegisterUserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
@CrossOrigin
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterUserRequest) {
        userService.register(request.username, request.email, request.password)
    }
}

