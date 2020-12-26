package nastya.BookShop.service.interf;

import nastya.BookShop.model.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User saveUser(User user);
}
