package com.techarchnotes.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/user")
@Produces(MediaType.TEXT_PLAIN)
public class UserResource {
    @GET
    @Path("login")
    @Timed
    public String logIn() {
        return "User has logged in";
    }
}
