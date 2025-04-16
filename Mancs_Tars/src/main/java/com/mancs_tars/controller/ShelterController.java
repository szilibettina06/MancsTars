/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mancs_tars.controller;

import com.mancs_tars.model.Shelter;
import com.mancs_tars.service.ShelterService;
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
@Path("shelter")
public class ShelterController {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ShelterController
     */
    public ShelterController() {
    }

    /**
     * Retrieves representation of an instance of com.mancs_tars.controller.ShelterController
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ShelterController
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
      @GET
    @Path("getAllShelters")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShelters() {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode =  200;
        
          
        List<Shelter> shelterList = ShelterService.getAllShelters();
       
       if (shelterList == null){
           status = "Modelexception";
           statusCode = 500; 
       } else if (shelterList.isEmpty()) {
           status = "NoSheltersFound";
           statusCode = 417;
       } else {
           JSONArray result = new JSONArray();
           
           for (Shelter actualShelter : shelterList) {
               JSONObject toAdd = new JSONObject();
               toAdd.put("id", actualShelter.getId());
               toAdd.put("address", actualShelter.getAddress());
               toAdd.put("directorName", actualShelter.getDirectorName());
               toAdd.put("email", actualShelter.getEmail());
               toAdd.put("phoneNumber", actualShelter.getPhoneNumber());
               toAdd.put("shelterName", actualShelter.getShelterName());
               toAdd.put("webAddress", actualShelter.getWebAddress());
               toAdd.put("comment", actualShelter.getComment());
               toAdd.put("dogId", actualShelter.getDogId());
               toAdd.put("catId", actualShelter.getCatId());
               toAdd.put("userId", actualShelter.getUserId());
             
               
               result.put(toAdd);
               
               
               
           }
           
           toReturn.put("result", result);
       }
       
       toReturn.put("status", status);
       toReturn.put("StatusCode", statusCode);
       
       return Response.status(statusCode).entity(toReturn.toString()).type(MediaType.APPLICATION_JSON).build();
              
               
      
        
    }

}


