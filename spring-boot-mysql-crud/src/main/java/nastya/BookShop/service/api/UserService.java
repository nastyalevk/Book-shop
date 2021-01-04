package nastya.BookShop.service.api;

import nastya.BookShop.dto.user.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Integer id);

    List<UserDto> findAll();

    void saveUser(UserDto user);
}
