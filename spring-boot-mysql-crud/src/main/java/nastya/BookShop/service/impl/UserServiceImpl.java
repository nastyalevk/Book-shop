package nastya.BookShop.service.impl;

import nastya.BookShop.dto.role.ERole;
import nastya.BookShop.dto.role.RoleDto;
import nastya.BookShop.dto.user.UserDto;
import nastya.BookShop.model.Role;
import nastya.BookShop.model.User;
import nastya.BookShop.model.UserRoles;
import nastya.BookShop.model.UserRolesId;
import nastya.BookShop.repository.RolesRepository;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.repository.UserRolesRepository;
import nastya.BookShop.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRolesRepository userRolesRepository, RolesRepository rolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public UserDto findById(Integer id) {
        try {
            return transfer(userRepository.getOne(id));
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<UserDto> findAll() {
        try {
            List<User> users = userRepository.findAll();
            List<UserDto> userDtos = new ArrayList<>();
            for (User i : users) {
                userDtos.add(transfer(i));
            }
            return userDtos;
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }



    @Override
    public User saveUser(UserDto userDto) {
        try {
            User user = createUser(userDto);
            updateUserRoles(userDto);
            return user;
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private User createUser(UserDto userDto) {
        try {
            return userRepository.save(transfer(userDto));
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserDto findByUsername(String userName) {
        try {
            return transfer(userRepository.findByUsername(userName));
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean existsByUsername(String username) {
        try {
            return userRepository.existsByUsername(username);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean existsByEmail(String email) {
        try {
            return userRepository.existsByEmail(email);
        } catch (Exception e) {
            logger.error("User error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private UserDto transfer(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setEmail(user.getEmail());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        List<UserRoles> userRoles = userRolesRepository.findUserRolesByUserRolesId_User(user);
        Set<RoleDto> rolesDto = new HashSet<>();
        for (UserRoles i : userRoles) {
            RoleDto roleDto = new RoleDto();
            roleDto.setName(ERole.valueOf(i.getUserRolesId().getRole().getRoleName()));
            roleDto.setId(i.getUserRolesId().getRole().getId());
            rolesDto.add(roleDto);
        }
        userDto.setRoles(rolesDto);
        userDto.setActivated(user.getActivated());
        return userDto;
    }

    private User transfer(UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setActivated(userDto.getActivated());
        return user;
    }

    public void updateUserRoles(UserDto userDto){
        User user = transfer(userDto);
        userRolesRepository.deleteAllByUserRolesIdUser(user);
        Set<RoleDto> roleDtos = userDto.getRoles();
        for(RoleDto i : roleDtos){
            UserRoles userRoles = new UserRoles();
            Role role = rolesRepository.getOne(i.getId());
            UserRolesId userRolesId = new UserRolesId();
            userRolesId.setRole(role);
            userRolesId.setUser(user);
            userRoles.setUserRolesId(userRolesId);
            userRolesRepository.save(userRoles);
        }
    }

}
