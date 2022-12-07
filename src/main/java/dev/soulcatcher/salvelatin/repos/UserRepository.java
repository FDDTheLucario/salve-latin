package dev.soulcatcher.salvelatin.repos;


import dev.soulcatcher.salvelatin.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
