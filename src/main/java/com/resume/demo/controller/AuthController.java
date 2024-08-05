package com.resume.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.resume.demo.service.AuthService;
import com.resume.demo.dto.AuthDTO;
import com.resume.demo.dto.AuthResponseDTO;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("api/authenticate")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("")
    public AuthResponseDTO auth(@RequestBody AuthDTO auth) {

        return authService.authenticate(auth);
    }

}
