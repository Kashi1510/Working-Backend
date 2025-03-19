package com.example.Internship_portal.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Adjust as needed
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        return loginService.login(loginDTO.getEmail(), loginDTO.getPassword());
    }
}
