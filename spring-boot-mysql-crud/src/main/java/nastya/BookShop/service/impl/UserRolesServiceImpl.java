package nastya.BookShop.service.impl;

import nastya.BookShop.model.UserRoles;
import nastya.BookShop.repository.UserRolesRepository;
import nastya.BookShop.service.api.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesServiceImpl implements UserRolesService {
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserRolesServiceImpl(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public void saveUserRole(UserRoles userRoles) {
        userRolesRepository.save(userRoles);
    }

    @Override
    public List<UserRoles> findAll() {
        return userRolesRepository.findAll();
    }

    @Override
    public UserRoles findById(Integer id) {
        return userRolesRepository.getOne(id);
    }
}
