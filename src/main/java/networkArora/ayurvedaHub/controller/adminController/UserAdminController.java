package networkArora.ayurvedaHub.controller.adminController;

import networkArora.ayurvedaHub.model.User;
import networkArora.ayurvedaHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/user/count")
    public ResponseEntity<Long> getUserCound() {
        return new ResponseEntity<>(userService.getUserCount(), HttpStatus.OK);
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "20") int size) {
        return new ResponseEntity<>(userService.getAllUsers(page, size), HttpStatus.OK);
    }

}
