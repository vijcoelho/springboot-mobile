package com.security.jwt.security;

import org.springframework.stereotype.Service;
import org.springframework.security.oauth2.jwt.JwtEncoder;

@Service
public class JwtService {

    private final JwtEncoder encoder;
}
