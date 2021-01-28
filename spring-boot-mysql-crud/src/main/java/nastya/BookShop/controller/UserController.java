package nastya.BookShop.controller;

import nastya.BookShop.dto.user.UserDto;
import nastya.BookShop.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> findAll() {
        try {
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserDto userDto) {
        try {
            userService.saveUser(userDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/update-roles/")
    public ResponseEntity<HttpStatus> updateUser(@RequestParam String[] roles,
                                     @RequestParam int id) {
        try {
            userService.updateUserRoles(roles, id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/find/username/{username}")
    public ResponseEntity<UserDto> findByUserName(@PathVariable("username") String userName) {
        try {
            return new ResponseEntity<>(userService.findByUsername(userName), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/exist/username/{username}")
    public ResponseEntity<Boolean> existByUserName(@PathVariable("username") String username) {
        try {
            return new ResponseEntity<>(userService.existsByUsername(username), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/exist/email/{email}")
    public ResponseEntity<Boolean> existByEmail(@PathVariable("email") String email) {
        try {
            return new ResponseEntity<>(userService.existsByEmail(email), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
