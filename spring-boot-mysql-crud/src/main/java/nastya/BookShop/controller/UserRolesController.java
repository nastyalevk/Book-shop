package nastya.BookShop.controller;

import nastya.BookShop.dto.userRoles.UserRolesDto;
import nastya.BookShop.model.UserRoles;
import nastya.BookShop.service.api.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRolesController {
    private final UserRolesService userRolesService;

    @Autowired
    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    @GetMapping("/user-roles")
    public List<UserRolesDto> findAll() {
        return userRolesService.findAll();
    }

    @PostMapping("/set-role")
    public void setRole(@RequestBody UserRolesDto userRolesDto) {
        userRolesService.saveUserRole(userRolesDto);
    }
}
