package com.example.demo.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LoginResponse {
    private String token;
    private String tokenType = "Bearer";
    private String email;
}
