package com.example.Internship_portal.login;

import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity<?> login(String email, String password);
}
