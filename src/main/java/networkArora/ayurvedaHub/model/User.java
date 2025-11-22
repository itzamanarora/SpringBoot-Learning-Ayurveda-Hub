package networkArora.ayurvedaHub.model;

import jakarta.persistence.*;
import lombok.Data;
import networkArora.ayurvedaHub.model.enums.Role;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;

@Entity
@Table( name = "users")
@Data
public class User {

    @Id
    @UuidGenerator
    @GeneratedValue
    private String userId;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String countryCode;

    @Column(nullable = false, unique = true, length = 10)
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private boolean active;

    @Column(nullable = false)
    private Instant createdAt;

    private Instant updatedAt;

}
