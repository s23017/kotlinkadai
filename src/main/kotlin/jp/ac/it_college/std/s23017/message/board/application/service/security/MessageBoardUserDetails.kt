package jp.ac.it_college.std.s23017.message.board.application.service.security

import jp.ac.it_college.std.s23017.message.board.domain.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class MessageBoardUserDetails(
    private val user: User
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return emptyList()
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.email // Userモデルのemailプロパティを使用する
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    val id: Long
        get() = user.id // null安全なアクセスに変更
}
