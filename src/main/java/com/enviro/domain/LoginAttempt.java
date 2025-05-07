package com.enviro.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "login_attempt")
public class LoginAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String pin;
    private String password;

    public LoginAttempt() {}

    public LoginAttempt(String username, String pin, String password) {
        this.username = username;
        this.pin = pin;
        this.password = password;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getPin() { return pin; }
    public String getPassword() { return password; }

    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPin(String pin) { this.pin = pin; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "LoginAttempt{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pin='" + pin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
