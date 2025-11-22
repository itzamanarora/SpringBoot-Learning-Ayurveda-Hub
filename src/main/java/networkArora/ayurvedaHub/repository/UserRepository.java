package networkArora.ayurvedaHub.repository;

import networkArora.ayurvedaHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUserName(String userName);
    public Optional<User> findByEmail(String email);
    public Long countByUserId(String userId);
}