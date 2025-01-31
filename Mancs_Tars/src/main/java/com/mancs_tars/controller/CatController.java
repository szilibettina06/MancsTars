/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mancs_tars.controller;

import com.mancs_tars.model.Cat;
import com.mancs_tars.service.CatService;
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
@Path("cat")
public class CatController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CatController
     */
    public CatController() {
    }

    /**
     * Retrieves representation of an instance of com.mancs_tars.controller.CatController
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CatController
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
     @GET
    @Path("getAllCats")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCats() {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode =  200;
        
          
        List<Cat> catList = CatService.getAllCats();
       
       if (catList == null){
           status = "Modelexception";
           statusCode = 500; 
       } else if (catList.isEmpty()) {
           status = "NoCatsFound";
           statusCode = 417;
       } else {
           JSONArray result = new JSONArray();
           
           for (Cat actualCat : catList) {
               JSONObject toAdd = new JSONObject();
               toAdd.put("id", actualCat.getId());
               toAdd.put("name", actualCat.getName());
               toAdd.put("breed", actualCat.getBreed());
               toAdd.put("age", actualCat.getAge());
               toAdd.put("gender", actualCat.getGender());
               toAdd.put("kidsFriendly", actualCat.getKidsFriendly());
               toAdd.put("apartmentFriendly", actualCat.getApartmentFriendly());
               toAdd.put("tendencyToGainWeight", actualCat.getTendencyToGainWeight());
               toAdd.put("health", actualCat.getHealth());
               toAdd.put("intelligence", actualCat.getIntelligence());
               toAdd.put("tendencyToEscape", actualCat.getTendencytoEscape());
               toAdd.put("playfulness", actualCat.getPlayfulness());
               toAdd.put("dogFriendly", actualCat.getDogFriendly());
               toAdd.put("energyLevel", actualCat.getEnergyLevel());
               toAdd.put("rateOfHairLoss", actualCat.getRateOfHairLoss());
               toAdd.put("catImg", actualCat.getCatImg());
               toAdd.put("userId", actualCat.getUserId());
               toAdd.put("shelterId", actualCat.getShelterId());
               
               
               result.put(toAdd);
               
               
               
               
           }
           
           toReturn.put("result", result);
       }
       
       toReturn.put("status", status);
       toReturn.put("StatusCode", statusCode);
       
       return Response.status(statusCode).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
              
               
      
        
    }

}
