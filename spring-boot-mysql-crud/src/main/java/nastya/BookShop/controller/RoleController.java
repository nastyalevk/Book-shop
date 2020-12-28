package nastya.BookShop.controller;

import nastya.BookShop.service.interf.RolesService;
import nastya.BookShop.model.Role;
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

    @PostMapping("/save-user")
    public ResponseEntity<Void> saveRole(@RequestBody Role role){
        roleService.saveRole(role);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/roles"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

}
