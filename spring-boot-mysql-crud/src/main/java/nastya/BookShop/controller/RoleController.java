package nastya.BookShop.controller;

import nastya.BookShop.service.interf.RolesService;
import nastya.BookShop.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    private final RolesService roleService;

    @Autowired
    public RoleController(RolesService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> findAll(){
        return roleService.findAll();
    }

    //make forwarding
    @PostMapping("/save-user")
    public void saveRole(@RequestBody Role role){
        roleService.saveRole(role);
    }

}
