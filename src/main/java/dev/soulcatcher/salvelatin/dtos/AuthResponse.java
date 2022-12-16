package dev.soulcatcher.salvelatin.dtos;

import dev.soulcatcher.salvelatin.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private UUID userId;
    private long sessionStartedAt = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

    public AuthResponse(User user) {
        this.userId = user.getUserId();
    }
}
