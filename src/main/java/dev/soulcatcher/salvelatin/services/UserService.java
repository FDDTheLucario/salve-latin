package dev.soulcatcher.salvelatin.services;

import dev.soulcatcher.salvelatin.dtos.AuthResponse;
import dev.soulcatcher.salvelatin.exceptions.UserNotFoundException;
import dev.soulcatcher.salvelatin.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<AuthResponse> findAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(AuthResponse::new)
                .collect(Collectors.toList());
    }

    public AuthResponse findById(UUID id) {
        return userRepo.findById(id)
                .map(AuthResponse::new)
                .orElseThrow(UserNotFoundException::new);
    }
}
