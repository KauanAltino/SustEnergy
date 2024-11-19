package com.mvn_project.SustEnergy;

import com.mvn_project.SustEnergy.model.User;
import com.mvn_project.SustEnergy.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateAndFindUser() {
        User user = new User();
        user.setName("Test User");
        user.setEmail("testuser@example.com");

        // Salve o objeto
        userRepository.save(user);

        // Tente recuperar o objeto salvo
        Optional<User> foundUser = userRepository.findById(user.getId());
        assertTrue(foundUser.isPresent());
        assertEquals("Test User", foundUser.get().getName());
        assertEquals("testuser@example.com", foundUser.get().getEmail());
    }
}
