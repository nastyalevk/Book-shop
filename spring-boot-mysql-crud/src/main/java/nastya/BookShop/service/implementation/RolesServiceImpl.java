package nastya.BookShop.service.implementation;

import nastya.BookShop.model.Role;
import nastya.BookShop.repository.RolesRepository;
import nastya.BookShop.service.interf.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void saveRole(Role role){
        rolesRepository.save(role);
    }

    @Override
    public List<Role> findAll(){
        return rolesRepository.findAll();
    }

}
