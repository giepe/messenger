package com.github.giepe.messenger.resources;

import com.github.giepe.messenger.model.Message;
import com.github.giepe.messenger.services.MessageService;

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

    MessageService messageService = new MessageService();

    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
//    @Produces(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") Long id) {
        return messageService.getMessage(id);
    }

    @POST
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML)
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML)
    public Message updateMessage(Message message) {
        return messageService.updateMessage(message);
    }

    @DELETE
//    @Consumes(MediaType.APPLICATION_XML)
//    @Produces(MediaType.APPLICATION_XML)
    public String deleteMessage(Message message) {
        return messageService.deleteMessage(message.getId());
    }

}