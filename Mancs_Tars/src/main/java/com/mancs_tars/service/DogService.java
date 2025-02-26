/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.service;

import com.mancs_tars.model.Dog;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author rkczi
 */
public class DogService {
    
   private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com_Mancs_Tars_war_1.0-SNAPPU");
   
   public static List<Dog> getAllDogs(){
       EntityManager em = emf.createEntityManager();
       List<Dog> dogList = new ArrayList<>();
       
       try {
           Query query = em.createQuery("SELECT d From Dog d");
           dogList = query.getResultList();
           
       } catch (Exception e) {
           System.err.println("Hiba: " + e.getLocalizedMessage());
           
          
       } finally {
           em.clear();
           em.close();
       }
       return dogList;
   }
    
}


