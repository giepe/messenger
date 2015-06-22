package messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Piotrek on 22.06.15.
 */

@Path("/messages")
public class MessageResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessages() {
        return "It's working!";
    }

}
