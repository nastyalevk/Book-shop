package nastya.BookShop.controller;

import nastya.BookShop.dto.userRoles.UserRolesDto;
import nastya.BookShop.service.api.UserRolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/role")
public class UserRolesController {

    private static final Logger logger = LoggerFactory.getLogger(UserRolesController.class);

    private final UserRolesService userRolesService;

    @Autowired
    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        try {
            return new ResponseEntity(userRolesService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity setRole(@RequestBody UserRolesDto userRolesDto) {
        try {
            return new ResponseEntity(userRolesService.saveUserRole(userRolesDto), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
