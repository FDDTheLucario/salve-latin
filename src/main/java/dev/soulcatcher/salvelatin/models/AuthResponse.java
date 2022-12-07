package dev.soulcatcher.salvelatin.models;

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
    private long registeredAt = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

    public AuthResponse(User user) {
        this.userId = user.getUserId();
    }
}
