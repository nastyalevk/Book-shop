package nastya.BookShop.service.api;

import nastya.BookShop.dto.userRoles.UserRolesDto;

import java.util.List;

public interface UserRolesService {

    void saveUserRole(UserRolesDto userRoles);

    List<UserRolesDto> findAll();

    UserRolesDto findById(Integer id);
}
