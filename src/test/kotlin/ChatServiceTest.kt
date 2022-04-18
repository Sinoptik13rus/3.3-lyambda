import ChatService.sendMessage
import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun sendMessageTest() {
        val finish = ChatService
        val senderId = 1
        val recipientId = 13
        val text = "Lyambda"
        val result = finish.sendMessage(senderId, recipientId, text)
    }

    @Test
    fun deleteTest() {
        val finish = ChatService
        val chatId = 1
        finish.sendMessage(1, 13, "Lyambda")
        finish.sendMessage(2, 5, "kokoko")
        val result = finish.delete(chatId)
        assertTrue(result)
    }

    @Test
    fun getAllMessageTest() {
        val finish = ChatService
        val id = 1
        finish.sendMessage(1, 13, "Lyambda")
        finish.sendMessage(2, 5, "kokoko")
        val result = finish.getAllMessage(id)
        assertTrue(result.isEmpty())
    }
}