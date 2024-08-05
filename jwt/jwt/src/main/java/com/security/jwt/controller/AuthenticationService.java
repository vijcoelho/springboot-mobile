package com.security.jwt.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationService {

    public String authenticate() {
        return "token";
    }
}
