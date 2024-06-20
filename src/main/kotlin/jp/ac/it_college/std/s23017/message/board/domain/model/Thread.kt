package jp.ac.it_college.std.s23017.message.board.domain.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Thread(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val userId: Long,
    val createdAt: LocalDateTime = LocalDateTime.now()
)
