package com.enviro.service;

import com.enviro.domain.LoginAttempt;
import com.enviro.repository.LoginRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public LoginAttempt save(LoginAttempt loginAttempt) {
        return loginRepository.save(loginAttempt);
    }
}
