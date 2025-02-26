/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mancs_tars.controller;

import com.mancs_tars.model.Dog;
import com.mancs_tars.service.DogService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("dog")
public class DogController {
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DogResource
     */
    public DogController() {
    }

    /**
     * Retrieves representation of an instance of com.mancs_tars.controller.DogController
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of DogController
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    @GET
    @Path("getAllDogs")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDogs() {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode =  200;
        
          
        List<Dog> dogList = DogService.getAllDogs();
       
       if (dogList == null){
           status = "Modelexception";
           statusCode = 500; 
       } else if (dogList.isEmpty()) {
           status = "NoDogsFound";
           statusCode = 417;
       } else {
           JSONArray result = new JSONArray();
           
           for (Dog actualDog : dogList) {
               JSONObject toAdd = new JSONObject();
               toAdd.put("id", actualDog.getId());
               toAdd.put("name", actualDog.getName());
               toAdd.put("breed", actualDog.getBreed());
               toAdd.put("age", actualDog.getAge());
               toAdd.put("gender", actualDog.getGender());
               toAdd.put("kidsFriendly", actualDog.getKidsFriendly());
               toAdd.put("apartmentFriendly", actualDog.getApartmnetFriendly());
               toAdd.put("tendencyToGainWeight", actualDog.getTendencyToGainWeight());
               toAdd.put("health", actualDog.getHealth());
               toAdd.put("intelligence", actualDog.getIntelligence());
               toAdd.put("tendencyToEscape", actualDog.getTedencytoEscape());
               toAdd.put("playfulness", actualDog.getPlayfulness());
               toAdd.put("catFriendly", actualDog.getCatFriendly());
               toAdd.put("energyLevel", actualDog.getEnergyLevel());
               toAdd.put("dogImg", actualDog.getDogImg());
               toAdd.put("userId", actualDog.getUserId());
               toAdd.put("shelterId", actualDog.getShelterId());
               
               result.put(toAdd);
               
               
               
           }
           
           toReturn.put("result", result);
       }
       
       toReturn.put("status", status);
       toReturn.put("StatusCode", statusCode);
       
       return Response.status(statusCode).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
              
               
      
        
    }

}
