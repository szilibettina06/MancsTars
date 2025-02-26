/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.service;

import com.mancs_tars.model.Cat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author rkczi
 */
public class CatService {
     private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com_Mancs_Tars_war_1.0-SNAPPU");
   
   public static List<Cat> getAllCats(){
       EntityManager em = emf.createEntityManager();
       List<Cat> catList = new ArrayList<>();
       
       try {
           Query query = em.createQuery("SELECT c From Cat c");
           catList = query.getResultList();
           
       } catch (Exception e) {
           System.err.println("Hiba: " + e.getLocalizedMessage());
           
          
       } finally {
           em.clear();
           em.close();
       }
       return catList;
   }
    
}
