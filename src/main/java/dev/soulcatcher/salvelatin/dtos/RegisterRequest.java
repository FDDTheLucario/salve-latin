package dev.soulcatcher.salvelatin.dtos;

import dev.soulcatcher.salvelatin.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String username;
    private String password;

    public RegisterRequest(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
