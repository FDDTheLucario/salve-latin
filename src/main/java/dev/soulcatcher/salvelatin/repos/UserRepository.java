package dev.soulcatcher.salvelatin.repos;


import dev.soulcatcher.salvelatin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Query
    boolean existsByEmail(String email);
    @Query
    boolean existsByUsername(String username);
}
