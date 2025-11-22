package networkArora.ayurvedaHub.controller.publicController;

import networkArora.ayurvedaHub.model.User;
import networkArora.ayurvedaHub.model.enums.Role;
import networkArora.ayurvedaHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public")
public class UserPublicController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        user.setRole(Role.GUEST);
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }
}
