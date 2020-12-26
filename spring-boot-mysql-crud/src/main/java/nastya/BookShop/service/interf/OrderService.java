package nastya.BookShop.service.interf;

import nastya.BookShop.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findByClientId(Integer clientId);

    Order findById(Integer id);

    List<Order> findAll();

    void saveOrder(Order order);
}
