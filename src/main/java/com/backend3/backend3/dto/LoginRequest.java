package com.backend3.backend3.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
