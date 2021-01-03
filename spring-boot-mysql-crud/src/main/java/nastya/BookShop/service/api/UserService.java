package nastya.BookShop.service.api;

import nastya.BookShop.model.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    void saveUser(User user);
}
