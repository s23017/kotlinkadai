package jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao

import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.MessageTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MessageEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<MessageEntity>(MessageTable)

    var content by MessageTable.content
    var userId by UserEntity referencedOn MessageTable.userId
    var threadId by ThreadEntity referencedOn MessageTable.threadId
}