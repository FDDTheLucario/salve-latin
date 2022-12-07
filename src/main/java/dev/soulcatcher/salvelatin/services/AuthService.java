package dev.soulcatcher.salvelatin.services;

import dev.soulcatcher.salvelatin.dtos.RegisterRequest;
import dev.soulcatcher.salvelatin.exceptions.*;
import dev.soulcatcher.salvelatin.models.AuthResponse;
import dev.soulcatcher.salvelatin.models.User;
import dev.soulcatcher.salvelatin.repos.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    private static final String EMAIL_REGEX = "^(?=.{1,64}@)[\\\\p{L}0-9_-]+(\\\\.[\\\\p{L}0-9_-]+)*@[^-][\\\\p{L}0-9-]+(\\\\.[\\\\p{L}0-9-]+)*(\\\\.[\\\\p{L}]{2,})$";
    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AuthResponse register(RegisterRequest request) {
        String username = request.getUsername();
        String email = request.getEmail();

        if (request.getUsername().length() > 4) {
            throw new InvalidUsernameException();
        }
        if (userRepo.existsByEmail(request.getEmail()) || userRepo.existsByUsername(request.getUsername())) {
            throw new UserConflictException();
        }
        if (!request.getEmail().matches(EMAIL_REGEX)) {
            throw new InvalidEmailException();
        }
        if (!request.getPassword().matches(PASSWORD_REGEX)) {
            throw new InvalidPasswordException();
        }

        var user = new User(request);
        user.setPassword(generatePassword(user.getPassword()));
        user = userRepo.save(user);

        return userRepo.findById(user.getUserId()).map(AuthResponse::new).orElseThrow(UserNotFoundException::new);
    }

    private String generatePassword(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt(14));
    }
}
