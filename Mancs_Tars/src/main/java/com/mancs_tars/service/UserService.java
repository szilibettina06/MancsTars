/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.service;


import com.mancs_tars.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.json.JSONObject;

/**
 *
 * @author rkczi
 */
public class UserService {
    
    private User layer = new User();
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    //jelszo validalas
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        
        for(char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if ("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=.*[\\S]).{8,}$".indexOf(c) != -1) {
                hasSpecialChar = true;
            }
        }

        return hasNumber && hasUpperCase && hasLowerCase && hasSpecialChar;
    }
    public JSONObject login(String email, String password){
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode = 200;
        
        if (isValidEmail(email)){
            User modelResult = layer.login(email, password);
            
            if (modelResult  == null) {
                status = "modelExpection";
                statusCode = 500;
            } else {
                if (modelResult.getId() == null) {
                    status = "userNotFound";
                    statusCode = 417;
                } else {
                    JSONObject result = new JSONObject();
                    result.put("id", modelResult.getId());
                    result.put("email", modelResult.getEmail());
                    result.put("firtName", modelResult.getFirstName());
                    result.put("lastName", modelResult.getLastName());
                    result.put("isAdmin", modelResult.getIsAdmin());
                    result.put("isDeleted", modelResult.getIsDeleted() );
                    
                    toReturn.put("result", result);
                }
            }
        } else {
            status = "invalidEmail";
            statusCode = 417;
        }
        toReturn.put("status", status);
        toReturn.put("statusCode", statusCode);
        return toReturn;
        
    }
      private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com_Mancs_Tars_war_1.0-SNAPPU");
   
   public static List<User> getAllUsers(){
       EntityManager em = emf.createEntityManager();
       List<User> userList = new ArrayList<>();
       
       try {
           Query query = em.createQuery("SELECT u FROM User u");
           userList = query.getResultList();
           
       } catch (Exception e) {
           System.err.println("Hiba: " + e.getLocalizedMessage());
           
          
       } finally {
           em.clear();
           em.close();
       }
       return userList;
   }
    
    }

        

            
            
            
