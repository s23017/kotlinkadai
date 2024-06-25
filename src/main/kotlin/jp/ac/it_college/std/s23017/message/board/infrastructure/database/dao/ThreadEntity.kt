package jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao

import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.ThreadTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ThreadEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<ThreadEntity>(ThreadTable)

    var title by ThreadTable.title
}