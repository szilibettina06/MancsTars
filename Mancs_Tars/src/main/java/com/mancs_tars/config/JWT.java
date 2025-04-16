/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mancs_tars.config;

import com.mancs_tars.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;




/**
 *
 * @author rkczi
 */
public class JWT {

  private static final String SIGN = "09ce78e64c7d6667e04798aa897e2bbc194d0ce5d19aef677b4477ba0932d972";
    private static final byte[] SECRET = Base64.getDecoder().decode(SIGN);
    private static ExceptionLogger exceptionLogger = new  ExceptionLogger(JWT.class);

    public static String createJWT(User u) {
        Instant now = Instant.now();

        String token = Jwts.builder()
                .setIssuer("MANCS_TARS")
                .setSubject("valamit")
                .claim("id", u.getId())
                .claim("isAdmin", u.getIsAdmin())
                .claim("createdAt", u.getCreatedAt())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(SIGN)
                )
                .compact();

        return token;
    }

    public static int validateJWT(String jwt) {
        try {
            Jws<Claims> result;
            result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(SECRET)).parseClaimsJws(jwt);
            int id = result.getBody().get("id", Integer.class);
            User u = new User(id);

            if (u.getId() == id) {
                return 1;
            } else {
                return 2; //Ez akkor történik amikor egy érvénytelen tokent akarunk validáltatni
            }
        } catch (Exception e) {
            //System.err.println("JWT validation error: " + e.getLocalizedMessage());
            exceptionLogger.errorLog(e);
            return 3; //Akkor történik ha lejárt a JWT-k
        }

    }
    public static Boolean isAdmin(String jwt){
        Jws<Claims> result;
        result = Jwts.parser().setSigningKey(Keys.hmacShaKeyFor(SECRET)).parseClaimsJws(jwt);
        Boolean isAdmin =result.getBody().get("isadmin", Boolean.class);
        return isAdmin;
    }
    
     /*
        eyJhbGciOiJIUzI1NiJ9.
    eyJpc3MiOiJWaXN1ZWxzZSIsInN1YiI6Im1hbmFnZW1lbnQiLCJpZCI6MTI3LCJzY29wZSI6InVzZXIiLCJzc1RhZyI6IkBBQiIsImlhdCI6MTcyNDk1NzMwOSwiZXhwIjoxNzI1NTYyMTA5fQ.
    
    Wj7kKUIVtWpLHwEkghRqnAjkb0xO7GJ4mOpiEDgxrs0
     */
    
}