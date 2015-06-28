package messenger.resources;

import messenger.model.Message;
import messenger.services.MessageService;
import org.glassfish.jersey.server.model.ParamQualifier;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Piotrek on 22.06.15.
 */

@Path("/messages")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class MessageResource {

    MessageService msgservice = new MessageService();

    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return msgservice.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
//    @Produces(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") Long id) {
        return msgservice.getMessage(id);
    }

    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML)
    public Message addMessage(Message message) {
        return msgservice.addMessage(message);
    }

    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML)
    public Message updateMessage(Message message) {
        return msgservice.updateMessage(message);
    }

    @DELETE
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML)
    public String deleteMessage(Message message) {
        return msgservice.deleteMessage(message.getId());
    }

}