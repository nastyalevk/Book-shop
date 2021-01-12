package nastya.BookShop.controller;

import nastya.BookShop.dto.role.RoleDto;
import nastya.BookShop.service.api.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private final RolesService roleService;

    @Autowired
    public RoleController(RolesService roleService) {
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        try {
            return new ResponseEntity(roleService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Role error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity saveRole(@RequestBody RoleDto roleDto) {
        try {
            roleService.saveRole(roleDto);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Role error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{role}")
    public ResponseEntity findByName(@PathVariable("role") String name) {
        try {
            return new ResponseEntity(roleService.findByName(name), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Role error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }


}
