package dev.java.controller;

import domain.Users;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import service.UserService;

@Path("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Response findAllUsers(@QueryParam("page") @DefaultValue("0") Integer page,
                                 @QueryParam("pageSize") @DefaultValue("10") Integer pageSize){

        var users = Users.findAll().page(page, pageSize).list();
        return Response.ok(users).build();
    }

    @POST
    @Transactional
    public Response createUsers(Users users){
        return Response.ok(userService.createUsers(users)).build();
    }

}
