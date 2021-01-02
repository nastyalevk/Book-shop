package nastya.BookShop.service.api;

import nastya.BookShop.model.Role;

import java.util.List;

public interface RolesService {

    void saveRole(Role role);

    List<Role> findAll();
}
