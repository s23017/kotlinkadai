package jp.ac.it_college.std.s23017.message.board.domain.repository

import jp.ac.it_college.std.s23017.message.board.domain.model.Thread
import org.springframework.data.jpa.repository.JpaRepository

interface ThreadRepository : JpaRepository<Thread, Long> {
}