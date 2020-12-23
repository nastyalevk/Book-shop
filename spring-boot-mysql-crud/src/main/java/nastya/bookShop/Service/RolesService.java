package nastya.bookShop.Service;

import nastya.bookShop.model.Role;
import nastya.bookShop.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {
    private final RolesRepository rolesRepository;

    @Autowired
    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public void saveRole(Role role){
        rolesRepository.save(role);
    }

    public List<Role> findAll(){
        return rolesRepository.findAll();
    }

}
