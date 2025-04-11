/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.service;

import com.mancs_tars.config.JWT;
import com.mancs_tars.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Path;
import org.json.JSONArray;
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

        for (char c : password.toCharArray()) {
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

    public JSONObject login(String email, String password) {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode = 200;

        if (isValidEmail(email)) {
            User modelResult = layer.login(email, password);

            if (modelResult == null) {
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
                    result.put("isDeleted", modelResult.getIsDeleted());

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
    public JSONObject registerUser(User u) {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode = 200;

        if (isValidEmail(u.getEmail())) {
            if (isValidPassword(u.getPassword())) {
                boolean userIsExists = User.isUserExists(u.getEmail());
                if (User.isUserExists(u.getEmail()) == null) {
                    status = "ModelException";
                    statusCode = 500;
                } else if (userIsExists == true) {
                    status = "UserAlreadyExists";
                    statusCode = 417;
                } else {
                    boolean registerUser = layer.registerUser(u);
                    if (registerUser == false) {
                        status = "fail";
                        statusCode = 417;
                    }
                }
            } else {
                status = "invalidPassword";
                statusCode = 417;
            }
        } else {
            status = "invalidEmail";
            statusCode = 417;
        }

        toReturn.put("status", status);
        toReturn.put("statusCode", statusCode);
        return toReturn;
    }

    public JSONObject registerAdmin(User u, String jwr) {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode = 200;
        if (JWT.isAdmin(jwr)) {
            if (isValidEmail(u.getEmail())) {
                if (isValidPassword(u.getPassword())) {
                    boolean userIsExists = User.isUserExists(u.getEmail());
                    if (User.isUserExists(u.getEmail()) == null) {
                        status = "ModelException";
                        statusCode = 500;
                    } else if (userIsExists == true) {
                        status = "UserAlreadyExists";
                        statusCode = 417;
                    } else {
                        boolean registerAdmin = layer.registerAdmin(u);
                        if (registerAdmin == false) {
                            status = "fail";
                            statusCode = 417;
                        }
                    }
                } else {
                    status = "invalidPassword";
                    statusCode = 417;
                }
            } else {
                status = "invalidEmail";
                statusCode = 417;
            }
        } else {
            status = "permissionError";
            statusCode = 417;

        }

        toReturn.put("status", status);
        toReturn.put("statusCode", statusCode);
        return toReturn;
    }
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com_Mancs_Tars_war_1.0-SNAPPU");

    /*  
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
     */
    public JSONObject getAllUser() {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode = 200;
        List<User> modelResult = layer.getAllUser();
        if (modelResult == null) {
            status = "Modelexception";
            statusCode = 500;
        } else if (modelResult.isEmpty()) {
            status = "NoUsersFound";
            statusCode = 417;
        } else {
            JSONArray result = new JSONArray();
            for (User actualUser : modelResult) {
                JSONObject toAdd = new JSONObject();
                toAdd.put("id", actualUser.getId());
                toAdd.put("email", actualUser.getEmail());
                toAdd.put("firstName", actualUser.getFirstName());
                toAdd.put("lastName", actualUser.getLastName());
                toAdd.put("isAdmin", actualUser.getIsAdmin());
                toAdd.put("isDeleted", actualUser.getIsDeleted());
                toAdd.put("createdAt", actualUser.getCreatedAt());
                toAdd.put("deletedAt", actualUser.getDeletedAt());

                result.put(toAdd);
            }
            toReturn.put("result", result);
        }

        toReturn.put("status", status);
        toReturn.put("statusCode", statusCode);
        return toReturn;
    }
     public JSONObject getUserById(Integer id) {
        JSONObject toReturn = new JSONObject();
        String status = "success";
        int statusCode = 200;
        User modelResult = new User(id);
        
        if(modelResult.getEmail()==null){
            status ="user not found";
            statusCode=417;
        }else{
            JSONObject user = new JSONObject();
            user.put("id", modelResult.getId());
            user.put("email", modelResult.getEmail());
            user.put("phoneNumber", modelResult.getPhoneNumber());
            user.put("firstname", modelResult.getFirstName());
            user.put("lastname", modelResult.getLastName());
            user.put("isAdmin", modelResult.getIsAdmin());
            user.put("isDeleted", modelResult.getIsDeleted());
            user.put("CreatedAt", modelResult.getCreatedAt());
            
            toReturn.put("result", user);
        }
        
        toReturn.put("status", status);
        toReturn.put("statusCode", statusCode);
        return toReturn;
    }
}
