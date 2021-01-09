package nastya.BookShop.controller;

import nastya.BookShop.dto.user.UserDto;
import nastya.BookShop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        List<UserDto> userDto = userService.findAll();
        if (userDto.isEmpty()) {
            return new ResponseEntity("Users dont exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userDto, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable("id") Integer id) {
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/find/username/{username}")
    public ResponseEntity findByUserName(@PathVariable("username") String userName){
        return new ResponseEntity(userService.findByUsername(userName), HttpStatus.OK);
    }

    @GetMapping("/exist/username/{username}")
    public ResponseEntity existByUserName(@PathVariable("username") String username){
        return new ResponseEntity(userService.existsByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/exist/email/{email}")
    public ResponseEntity existByEmail(@PathVariable("email") String email){
        return new ResponseEntity(userService.existsByEmail(email), HttpStatus.OK);
    }
}
