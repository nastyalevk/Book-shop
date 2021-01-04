package nastya.BookShop.service.impl;

import nastya.BookShop.dto.user.UserDto;
import nastya.BookShop.model.User;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto findById(Integer id) {
        return transfer(userRepository.getOne(id));
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for(User i: users){
            userDtos.add(transfer(i));
        }
        return userDtos;
    }

    @Override
    public void saveUser(UserDto userDto) {
        userRepository.save(transfer(userDto));
    }

    private UserDto transfer(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setFirstName(user.getFirstName());
        userDto.setEmail(user.getEmail());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    private User transfer(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setFirstName(userDto.getFirstName());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
