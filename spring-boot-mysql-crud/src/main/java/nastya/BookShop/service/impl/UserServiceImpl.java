package nastya.BookShop.service.impl;

import nastya.BookShop.dto.role.ERole;
import nastya.BookShop.dto.role.RoleDto;
import nastya.BookShop.dto.user.UserDto;
import nastya.BookShop.model.User;
import nastya.BookShop.model.UserRoles;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.repository.UserRolesRepository;
import nastya.BookShop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository = userRolesRepository;
    }

    @Override
    public UserDto findById(Integer id) {
        return transfer(userRepository.getOne(id));
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User i : users) {
            userDtos.add(transfer(i));
        }
        return userDtos;
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(transfer(userDto));
    }

    @Override
    public UserDto findByUsername(String userName) {
        return transfer(userRepository.findByUsername(userName));
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    private UserDto transfer(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setFirstName(user.getFirstName());
        userDto.setEmail(user.getEmail());
        userDto.setLastName(user.getLastName());
        userDto.setPassword(user.getPassword());
        Set<UserRoles> userRoles = userRolesRepository.findByUserRolesId_User(user).map(Collections::singleton).
                orElse(Collections.emptySet());
        Set<RoleDto> rolesDto = new HashSet<>();
        for (UserRoles i : userRoles) {
            RoleDto roleDto = new RoleDto();
            roleDto.setName(ERole.valueOf(i.getUserRolesId().getRole().getRoleName()));
            roleDto.setId(i.getUserRolesId().getRole().getId());
            rolesDto.add(roleDto);
        }
        userDto.setRoles(rolesDto);
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
        return user;
    }
}
