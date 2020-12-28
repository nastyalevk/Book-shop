package nastya.BookShop.controller;

import nastya.BookShop.service.interf.UserRolesService;
import nastya.BookShop.model.UserRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class UserRolesController {
    private final UserRolesService userRolesService;

    @Autowired
    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    @GetMapping("/user-roles")
    public List<UserRoles> findAll(){
        return userRolesService.findAll();
    }

    @PostMapping("/set-role")
    public ResponseEntity<Void> setRole(@RequestBody UserRoles userRoles){
        userRolesService.saveUserRole(userRoles);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/user-roles"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
