package nastya.BookShop.service.api;

import nastya.BookShop.dto.role.RoleDto;
import nastya.BookShop.model.Role;

import java.util.List;
import java.util.Optional;

public interface RolesService {

    void saveRole(RoleDto role);

    List<RoleDto> findAll();

    Optional<Role> findByName(String name);

}
