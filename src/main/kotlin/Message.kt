data class Message(
    val id: Int,
    val ownerId: Int,
    val message: String,
    val messageRead: Boolean = false

)