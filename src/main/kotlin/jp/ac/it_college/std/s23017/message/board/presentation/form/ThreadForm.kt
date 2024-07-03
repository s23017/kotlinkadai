//package jp.ac.it_college.std.s23017.message.board.presentation.form
//
//import kotlinx.serialization.Serializable
//import kotlinx.datetime.LocalDateTime
//import jp.ac.it_college.std.s23017.message.board.domain.model.Thread
//
//@Serializable
//data class GetThreadListResponse(val threadsList: List<ThreadInfo>)
//
//@Serializable
//data class ThreadInfo(
//    val id: Long,
//    val title: String,
//    val createdAt: LocalDateTime,
//    val updatedAt: LocalDateTime?
//) {
//    constructor(model: Thread) : this(model.id, model.title, model.createdAt, model.updatedAt)
//}
