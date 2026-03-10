package com.vkmaster.hotelmanagement.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("mySuperSecretKeyForHotelManagementSystem12345".getBytes());

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ 86400000))
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUsername(String token){

        return extractClaims(token).getSubject();
    }

    public  boolean validateToken(String token){

        try{
            extractClaims(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private  Claims extractClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
