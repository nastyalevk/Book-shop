package nastya.BookShop.service.impl;

import nastya.BookShop.dto.role.ERole;
import nastya.BookShop.dto.role.RoleDto;
import nastya.BookShop.model.Role;
import nastya.BookShop.repository.RolesRepository;
import nastya.BookShop.service.api.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {

    private static final Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);

    private final RolesRepository rolesRepository;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void saveRole(RoleDto roleDto) {
        try {
            rolesRepository.save(transfer(roleDto));
        } catch (Exception e) {
            logger.error("Role error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RoleDto> findAll() {
        try {
            List<Role> roles = rolesRepository.findAll();
            List<RoleDto> roleDtos = new ArrayList<>();
            for (Role i : roles) {
                roleDtos.add(transfer(i));
            }
            return roleDtos;
        } catch (Exception e) {
            logger.error("Role error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Role> findByName(String name) {
        try {
            return rolesRepository.findByRoleName(ERole.valueOf(name));
        } catch (Exception e) {
            logger.error("Role error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private RoleDto transfer(Role role) {
        return new RoleDto(role.getId(), role.getRoleName());
    }

    private Role transfer(RoleDto roleDto) {
        return new Role(roleDto.getId(), roleDto.getName().toString());
    }

}
