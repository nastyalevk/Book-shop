package nastya.BookShop.controller;

import nastya.BookShop.service.interf.UserService;
import nastya.BookShop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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

    @PostMapping(path = "/user-create")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/users"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") Integer id) {
        return userService.findById(id).toString();
    }

    @PostMapping("user-update")
    public ResponseEntity<Void> updateBook(@RequestBody User user) {
        userService.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/users"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
