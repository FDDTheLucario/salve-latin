package dev.soulcatcher.salvelatin;

import dev.soulcatcher.salvelatin.dtos.RegisterRequest;
import dev.soulcatcher.salvelatin.exceptions.InvalidEmailException;
import dev.soulcatcher.salvelatin.exceptions.InvalidPasswordException;
import dev.soulcatcher.salvelatin.models.User;
import dev.soulcatcher.salvelatin.repos.UserRepository;
import dev.soulcatcher.salvelatin.services.AuthService;
import dev.soulcatcher.salvelatin.services.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class SalveLatinAuthTests {

    private final AuthService authService;
    private final UserService userService;
    private final UserRepository userRepo;
    private User testUser;
    private RegisterRequest request;
    private final Logger logger = LogManager.getLogger();

    @Autowired
    public SalveLatinAuthTests(UserRepository userRepo, AuthService authService, UserService userService) {
        this.userRepo = userRepo;
        this.authService = authService;
        this.userService = userService;
    }

    @BeforeEach
    public void setUp() {
        testUser = new User("usertesting@test.com", "testuser", "testp@ssword1!");
        if (!userRepo.existsById(testUser.getUserId())) {
            logger.info("Test user not added - adding to the test db.");
            userRepo.save(testUser);
        }
    }
    @AfterEach
    public void after() {
        userRepo.delete(testUser);
    }

    @Test
    @Transactional
    void whenRegisteringWithInvalidEmail_ExpectInvalidException() {
        request = new RegisterRequest("example", "testing", "test");
        assertThrows(InvalidEmailException.class, () -> authService.register(request));
    }

    @Test
    void whenRegisteringWithInsecurePassword_ExpectException() {
        request = new RegisterRequest("test@test.com", "test-account", "1234");
        assertThrows(InvalidPasswordException.class, () -> authService.register(request));
    }

    @Test
    void whenGivenUser_FindUserByItsId() {
        var user = userRepo.findById(testUser.getUserId()).get();

        assertEquals(user.getUserId(), testUser.getUserId());
    }

    @Test
    void givenValidRegisterRequest_PersistUserToDb() {
        request = new RegisterRequest("register-test@test.com", "test-user", "Passw0rd!");

        var response = authService.register(request);
        assertEquals(response.getUserId(), userRepo.findById(response.getUserId()).get().getUserId());
    }
    @Test
    void givenValidRegisterRequest_ExpectVerificationToBeFalse() {
        request = new RegisterRequest("tester@gmail.com", "tester1", "p@ssw0rd!");
        var response = authService.register(request);

        var unverifiedUser = userService.findById(response.getUserId());
        Assertions.assertThat(unverifiedUser.isVerified()).isFalse();
    }
}
