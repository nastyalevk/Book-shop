package nastya.BookShop.controller;

import nastya.BookShop.dto.role.RoleDto;
import nastya.BookShop.service.api.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity findAll() {
        List<RoleDto> roleDto = roleService.findAll();
        if (roleDto.isEmpty()) {
            return new ResponseEntity("Roles dont exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(roleDto, HttpStatus.OK);
    }

    @PostMapping("/save-user")
    public ResponseEntity saveRole(@RequestBody RoleDto roleDto) {
        roleService.saveRole(roleDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
