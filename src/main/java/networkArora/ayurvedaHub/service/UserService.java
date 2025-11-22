package networkArora.ayurvedaHub.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import networkArora.ayurvedaHub.exception.apiException;
import networkArora.ayurvedaHub.model.User;
import networkArora.ayurvedaHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create new user
    @Transactional
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser != null) {
            throw new apiException("User with email " + user.getEmail() + " already exists!", HttpStatus.CONFLICT);
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setCreatedAt(Instant.now());
        return userRepository.save(user);
    }

    // Get total user count
    public Long getUserCount(){
        return userRepository.count();
    }

    // Get all users
    public List<User> getAllUsers(int page, int size) {
        int safeSize = Math.min(size, 50); // Limit size to a maximum of 50

        PageRequest pageRequest = PageRequest.of(page, safeSize);
        Page<User> user = userRepository.findAll(pageRequest);

        if(user.isEmpty()) {
            throw new apiException("No users found!", HttpStatus.NO_CONTENT);
        }
        return user.getContent();
    }

}
