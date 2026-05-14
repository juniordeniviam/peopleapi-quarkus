package dev.java.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/users")
public class UserController {

    @GET
    public String hello(){
        return "Hello from UserController!";
    }

}
