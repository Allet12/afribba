package com.enviro.dto;

public class LoginRequest {
    private String username;
    private String pin;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
