package com.resume.demo.service;

import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resume.demo.dto.AuthDTO;
import com.resume.demo.dto.AuthResponseDTO;

@Service
public class AuthService {

    public AuthResponseDTO authenticate(AuthDTO auth) {

        AuthResponseDTO response = new AuthResponseDTO();
        response.setUsername(auth.getUsername());

        String mockHashedPasswordFromDB = "$2y$12$gg6i70i.wPPr/.Q9Epn5vuiumsiA2jabkjby6ppT3uHbctuZsYb7e";
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();

        if (b.matches(auth.getPassword(), mockHashedPasswordFromDB) && auth.getUsername().equals("demo")) {

            response.setAuthenticated(true);
            response.setResponse("User Authenticated");
            return response;

        } else {

            response.setAuthenticated(false);
            response.setResponse("Incorrect Password/Username combination");
            return response;

        }

    }

}
