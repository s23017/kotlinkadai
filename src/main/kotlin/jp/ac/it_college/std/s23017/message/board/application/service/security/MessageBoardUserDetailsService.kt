package jp.ac.it_college.std.s23017.message.board.application.service.security

import jp.ac.it_college.std.s23017.message.board.application.service.UserService
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class MessageBoardUserDetailsService(private val userService: UserService) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findUserByEmail(username)
            ?: throw UsernameNotFoundException("User not found with email: $username")

        val authorities = mutableListOf<SimpleGrantedAuthority>()
        // ユーザーのロールに基づいて権限を追加する場合は、ここにロジックを追加する

        return MessageBoardUserDetails(
            user.email,
            user.password,
            authorities
        )
    }
}
