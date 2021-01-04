package nastya.BookShop.controller;

import nastya.BookShop.dto.role.RoleDto;
import nastya.BookShop.model.Role;
import nastya.BookShop.service.api.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
    private final RolesService roleService;

    @Autowired
    public RoleController(RolesService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<RoleDto> findAll() {
        return roleService.findAll();
    }

    @PostMapping("/save-user")
    public void saveRole(@RequestBody RoleDto roleDto) {
        roleService.saveRole(roleDto);
    }

}
