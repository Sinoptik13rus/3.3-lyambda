object ChatService {
    private val chats = mutableListOf<Chat>()

    fun sendMessage(senderId: Int, recipientId: Int, text: String) {
        var chatsId = 1
        var n = 1
        val message = Message(id = 1, message = text, ownerId = senderId)
        for (i in chats) {
            if (i.users.containsAll(listOf(senderId, recipientId))) {
                val newMessage = i.messages + message
                val newChat = Chat(
                    id = i.id,
                    messages = newMessage,
                    users = listOf(senderId,recipientId))
                chats.removeIf { newChat.id == it.id }
                chats.add(newChat)
            } else {
                val newChat2 = Chat(
                    id = n,
                    messages = listOf(message),
                    users = listOf(senderId,recipientId)
                )
                chats.add(newChat2)
            }
            n++
        }
        chats.filter(fun (chat: Chat): Boolean { return chat.id >0})
    }


    fun delete(chatID: Int): Boolean {
        for (i in chats) {
            chats.removeIf { i.id == chatID }
        }
        return true
    }

    fun getAllMessage(id: Int): List<Message> {
        val chat = chats.firstOrNull { it.id == id } ?: return emptyList()

        val updateMessages = chat.messages
            .map { it.copy(messageRead = true) }

        val updatedChat = chat.copy(messages = updateMessages)
        chats.removeIf { updatedChat.id == it.id }
        chats.add(updatedChat)

        return updateMessages
    }
}