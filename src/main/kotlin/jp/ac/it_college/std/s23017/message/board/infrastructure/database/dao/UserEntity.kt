package jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao

import jp.ac.it_college.std.s23017.message.board.infrastructure.database.dao.UserTable
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserEntity(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<UserEntity>(UserTable)

    var username by UserTable.username
    var password by UserTable.password
    var roleType by UserTable.roleType
}