package nastya.BookShop.service.interf;

import nastya.BookShop.model.Role;

import java.util.List;

public interface RolesService {

    void saveRole(Role role);

    List<Role> findAll();
}
