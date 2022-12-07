package dev.soulcatcher.salvelatin;

import dev.soulcatcher.salvelatin.dtos.RegisterRequest;
import dev.soulcatcher.salvelatin.exceptions.UserConflictException;
import dev.soulcatcher.salvelatin.models.AuthResponse;
import dev.soulcatcher.salvelatin.repos.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }



    private String generatePassword(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt(14));
    }
}
