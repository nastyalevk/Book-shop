package nastya.BookShop.controller;

import nastya.BookShop.dto.userRoles.UserRolesDto;
import nastya.BookShop.service.api.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/role")
public class UserRolesController {

    private final UserRolesService userRolesService;

    @Autowired
    public UserRolesController(UserRolesService userRolesService) {
        this.userRolesService = userRolesService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        List<UserRolesDto> userRolesDto = userRolesService.findAll();
        if (userRolesDto.isEmpty()) {
            return new ResponseEntity("Users have no roles", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userRolesDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity setRole(@RequestBody UserRolesDto userRolesDto) {
        return new ResponseEntity(userRolesService.saveUserRole(userRolesDto), HttpStatus.OK);
    }
}
