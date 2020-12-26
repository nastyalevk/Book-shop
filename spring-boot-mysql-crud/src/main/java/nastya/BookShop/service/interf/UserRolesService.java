package nastya.BookShop.service.interf;

import nastya.BookShop.model.UserRoles;

import java.util.List;

public interface UserRolesService {

    void saveUserRole(UserRoles userRoles );

    List<UserRoles> findAll();

    UserRoles findById(Integer id);
}
