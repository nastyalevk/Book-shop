package nastya.bookShop.controller;

import nastya.bookShop.Service.UserRolesService;
import nastya.bookShop.model.UserRoles;
import nastya.bookShop.model.UserRolesId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    //make forwarding
    @PostMapping("/set-role")
    public void setRole(@RequestBody UserRoles userRoles){
        userRolesService.saveUserRole(userRoles);
    }
}
