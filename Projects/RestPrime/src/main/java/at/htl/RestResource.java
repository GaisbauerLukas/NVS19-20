package at.htl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.time.LocalDateTime;

@Path("time")
public class RestResource {
    @GET
    public String time(){
        return "Time: " + LocalDateTime.now();
    }
}
