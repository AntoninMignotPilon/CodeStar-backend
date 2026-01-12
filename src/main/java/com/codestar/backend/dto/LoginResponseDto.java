package com.codestar.backend.dto;

public class LoginResponseDto {
    private String token;
    private String message;

    public LoginResponseDto(String token, String message) {
        this.token = token;
        this.message = message;
    }

    // Getters
    public String getToken() { return token; }
    public String getMessage() { return message; }
}