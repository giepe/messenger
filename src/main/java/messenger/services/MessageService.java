package messenger.services;

import messenger.database.DatabaseClass;
import messenger.model.Message;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Piotrek on 22.06.15.
 */
public class MessageService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "msg", "pg", new Date()));
        messages.put(2L, new Message(2, "msg2", "pg2", new Date()));
    }

    public List<Message> getAllMessages() {
        return new ArrayList(messages.values());
    }

    public Message getMessage(Long id) {
        return this.messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        message.setCreatedDate(new Date());
        this.messages.put(message.getId(), message);
        return messages.get(message.getId());
    }

    public Message updateMessage(Message message) {
        this.messages.put(message.getId(), message);
        return messages.get(message.getId());
    }

    public String deleteMessage(Long messageId) {
        try {
            this.messages.remove(messageId);
            return "<responseMessage><description>Message id " + messageId
                    + " has been deleted.</description></responseMessage>";
        }
        catch (Exception e) {
            return "<responseMessage><description>Exception while deleting message id " + messageId
                    + ".</description><exceptionMessage>Exception message: " + e.getMessage()
                    + "</exceptionMessage></responseMessage>";
        }
    }
}
