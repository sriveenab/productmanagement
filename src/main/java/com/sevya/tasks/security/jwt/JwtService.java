package com.sevya.tasks.security.jwt;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
    private static final String ISSUER = "in.sevya.jwt";
    private SecretKeyProvider secretKeyProvider;

    @SuppressWarnings("unused")
    public JwtService() {
        this(null);
    }

    @Autowired
    public JwtService(SecretKeyProvider secretKeyProvider) {
        this.secretKeyProvider = secretKeyProvider;
    }
    
    public JwtAuthenticatedUserDto verify(String token) throws IOException, URISyntaxException {
    	
        byte[] secretKey = secretKeyProvider.getKey();
        Jws<Claims> claims = null;
        try{
        	claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        }catch(Exception e){
        	if(e.getMessage().contains("JWT expired")) {
        		throw new NullPointerException("Session expired !!!");
        	}
            throw new JwtAuthenticationException(e.getMessage(), new Exception());
        }
        JwtAuthenticatedUserDto jwtAuthenticatedUserDto = new JwtAuthenticatedUserDto();
        String email = claims.getBody().get("email").toString();
        jwtAuthenticatedUserDto.setEmail(email);
        jwtAuthenticatedUserDto.setTimeZone(claims.getBody().get("timeZone").toString());
        jwtAuthenticatedUserDto.setUserId(Integer.parseInt((claims.getBody().get("id").toString())));
        return jwtAuthenticatedUserDto;
    }

    public String tokenFor(JwtAuthenticatedUserDto authenticatedUserDto) throws IOException, URISyntaxException {
    	
        byte[] secretKey = secretKeyProvider.getKey();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, 6);
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        
        Date expiration = cal.getTime();
//        Date expiration = Date.from(LocalDateTime.now().plusHours(6).toInstant(UTC));
        
        return Jwts.builder()
                .setSubject(authenticatedUserDto.getEmail())
                .setId(authenticatedUserDto.getUserId().toString())
                .setClaims(getClaims(authenticatedUserDto))
                .setExpiration(expiration)
                .setIssuer(ISSUER)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    private Map<String,Object> getClaims(JwtAuthenticatedUserDto authenticatedUserDto){
       
    	Map<String,Object> claims = new LinkedHashMap<>();
    	claims.put("email", authenticatedUserDto.getEmail());
    	claims.put("id", authenticatedUserDto.getUserId());
    	claims.put("timeZone", authenticatedUserDto.getTimeZone());
    	return claims;
    }
}