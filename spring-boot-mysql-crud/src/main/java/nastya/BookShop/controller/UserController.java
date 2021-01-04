package nastya.BookShop.controller;

import nastya.BookShop.dto.user.UserDto;
import nastya.BookShop.model.User;
import nastya.BookShop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping(path = "/user-create")
    public void createUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/user-update")
    public void updateBook(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }
}
