package nastya.BookShop.controller;

import nastya.BookShop.service.interf.UserService;
import nastya.BookShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    //make forwarding
    @PostMapping(path = "/user-create")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        return userService.findById(id).toString();
    }

    //make forwarding
    @PostMapping("user-update")
    public void updateBook(@RequestBody User user) {
        userService.saveUser(user);
    }
}
