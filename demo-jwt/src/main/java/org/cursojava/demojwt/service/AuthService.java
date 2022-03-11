package org.cursojava.demojwt.service;

import org.cursojava.demojwt.dto.JwtResponse;
import org.cursojava.demojwt.security.JwtIO;
import org.cursojava.demojwt.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtIO jwtIO;

    @Autowired 
    private DateUtils dateUtils;

    @Value("${jms.jwt.token.expires_in:3600}")
    private int EXPIRES_IN;

    public JwtResponse login(String clientId, String clientSecret){
        
        JwtResponse jwt = JwtResponse.builder()
            .tokenType("bearer")
            .accessToken(jwtIO.generateToken("Hola Mundo desde AuthService"))
            .issuedAt(dateUtils.getDateMillis()+"")
            .clientId(clientId)
            .expiresIn(EXPIRES_IN)
            .build();

        return jwt;
    }
    
}
