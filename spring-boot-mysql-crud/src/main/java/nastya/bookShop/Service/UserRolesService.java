package nastya.bookShop.Service;

import nastya.bookShop.model.UserRoles;
import nastya.bookShop.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRolesService {
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserRolesService(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    public void saveUserRole(UserRoles userRoles ){
        userRolesRepository.save(userRoles);
    }

    public List<UserRoles> findAll(){
        return userRolesRepository.findAll();
    }

    public UserRoles findById(Integer id){
        return userRolesRepository.getOne(id);
    }
}
