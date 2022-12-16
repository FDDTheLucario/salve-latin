package dev.soulcatcher.salvelatin.services;

import dev.soulcatcher.salvelatin.dtos.RegisterRequest;
import dev.soulcatcher.salvelatin.exceptions.*;
import dev.soulcatcher.salvelatin.dtos.AuthResponse;
import dev.soulcatcher.salvelatin.models.User;
import dev.soulcatcher.salvelatin.repos.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    // Must be at least 8 characters with one uppercase letter, one lower, one number, and one special character.
    private static final String EMAIL_REGEX = "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.\\p{L}{2,})$";

    // Email Regex that supports Unicode.
    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public AuthResponse register(RegisterRequest request) {
        String username = request.getUsername();
        String email = request.getEmail();

        if (request.getUsername().length() < 4) {
            throw new InvalidUsernameException(); // must be at least 5 characters
        }
        if (userRepo.existsByEmail(request.getEmail()) || userRepo.existsByUsername(request.getUsername())) {
            throw new UserConflictException(); // info already exists
        }
        if (!Pattern.compile(EMAIL_REGEX).matcher(email).matches()) {
            throw new InvalidEmailException(); // not a valid email
        }
        if (!request.getPassword().matches(PASSWORD_REGEX)) {
            throw new InvalidPasswordException(); // not a valid password
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
