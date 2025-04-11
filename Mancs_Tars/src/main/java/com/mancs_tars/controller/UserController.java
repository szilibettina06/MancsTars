/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mancs_tars.controller;


import com.mancs_tars.config.JWT;
import com.mancs_tars.model.User;
import com.mancs_tars.service.ShelterService;
import com.mancs_tars.service.UserService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author rkczi
 */
@Path("user")
public class UserController {

    @Context
    private UriInfo context;
    private UserService layer = new UserService();

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    /**
     * Retrieves representation of an instance of com.mancs_tars.controller.UserController
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of UserController
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
     @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(String bodyString) {
        JSONObject body = new JSONObject(bodyString);

        JSONObject obj = layer.login(body.getString("email"), body.getString("password"));
        return Response.status(obj.getInt("statusCode")).entity(obj.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @POST
    @Path("registerUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(String bodyString) {
        JSONObject body = new JSONObject(bodyString);

        User u = new User(
                body.getString("email"),
                body.getString("phoneNumber"),
                body.getString("firstName"),
                body.getString("lastName"),
                body.getString("password")
        );

        JSONObject obj = layer.registerUser(u);
        return Response.status(obj.getInt("statusCode")).entity(obj.toString()).type(MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("registerAdmin")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerAdmin(@HeaderParam("token") String jwt, String bodyString) {
        JSONObject body = new JSONObject(bodyString);

        User u = new User(
                body.getString("email"),
                body.getString("phoneNumber"),
                body.getString("firstName"),
                body.getString("lastName"),
                body.getString("password")
        );

        JSONObject obj = layer.registerAdmin(u, jwt);
        return Response.status(obj.getInt("statusCode")).entity(obj.toString()).type(MediaType.APPLICATION_JSON).build();
    }

   @GET
    @Path("getAllUsers")
    @Produces(MediaType.APPLICATION_JSON)
       public Response registerAdmin(@HeaderParam("token") String jwt) {
        int isValid = JWT.validateJWT(jwt);

        if (isValid == 1) {
            JSONObject obj = layer.getAllUser();
            return Response.status(obj.getInt("statusCode")).entity(obj.toString()).type(MediaType.APPLICATION_JSON).build();
        } else if (isValid == 2) {
            return Response.status(400).entity("InvalidToken").type(MediaType.APPLICATION_JSON).build();
        } else {
            return Response.status(400).entity("TokenExpired").type(MediaType.APPLICATION_JSON).build();
        }
    }
   /* public Response getAllUsers() {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode =  200;
        
          
        List<User> userList = UserService.getAllUsers();
       
       if (userList == null){
           status = "Modelexception";
           statusCode = 500; 
       } else if (userList.isEmpty()) {
           status = "NoUsersFound";
           statusCode = 417;
       } else {
           JSONArray result = new JSONArray();
           
           for (User actualUser : userList) {
               JSONObject toAdd = new JSONObject();
               toAdd.put("id", actualUser.getId());
               toAdd.put("firstName", actualUser.getFirstName());
               toAdd.put("lastName", actualUser.getLastName());
               toAdd.put("email", actualUser.getEmail());
               toAdd.put("phoneNumber", actualUser.getPhoneNumber());
               toAdd.put("age", actualUser.getAge());
               toAdd.put("isAdmin", actualUser.getIsAdmin());
               toAdd.put("isDeleted", actualUser.getIsDeleted());
               toAdd.put("password", actualUser.getPassword());
             
               
               result.put(toAdd);
               
               
               
           }
           
           toReturn.put("result", result);
       }
       
       toReturn.put("status", status);
       toReturn.put("StatusCode", statusCode);
       
       return Response.status(statusCode).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
              
               
      
        
    }
    */
}
