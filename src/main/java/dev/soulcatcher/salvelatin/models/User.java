package dev.soulcatcher.salvelatin.models;

import dev.soulcatcher.salvelatin.dtos.RegisterRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", nullable = false, insertable = false)
    private UUID userId = UUID.randomUUID();
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String password;
    @Column(nullable = false)
    private long registeredAt = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    @Column(nullable = false)
    private boolean verified = false;

    public User() {
        super();
    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(RegisterRequest registerRequest) {
        this(registerRequest.getEmail(), registerRequest.getUsername(), registerRequest.getPassword());
    }

    public User(UUID userId, String email, String username, String password, long registeredAt, boolean verified) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.registeredAt = registeredAt;
        this.verified = verified;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getRegisteredAt() {
        return registeredAt;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return registeredAt == user.registeredAt && verified == user.verified && userId.equals(user.userId)
                && email.equals(user.email) && username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, username, password, registeredAt, verified);
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", email='" + email + '\'' + ", username='" + username + '\''
                + ", password='" + password + '\'' + ", registeredAt=" + registeredAt + ", verified=" + verified + '}';
    }
}
