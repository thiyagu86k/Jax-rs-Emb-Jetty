package com.fiable.service;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author HKG.TKALIDOSS
 */

@Path("/tester")
public class RestEx {   
    
    @Path("ping")
    @Produces(MediaType.TEXT_PLAIN)  
    @GET
    public String test(){
        return LocalDate.now().toString() + " " + LocalTime.now().toString();
    }
    
}
