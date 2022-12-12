package dev.soulcatcher.salvelatin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String username;
    private String password;
}
