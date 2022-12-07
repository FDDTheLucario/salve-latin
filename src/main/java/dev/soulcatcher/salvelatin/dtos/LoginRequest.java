package dev.soulcatcher.salvelatin.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
