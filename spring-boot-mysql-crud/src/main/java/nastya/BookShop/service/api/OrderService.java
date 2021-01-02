package nastya.BookShop.service.api;

import nastya.BookShop.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> findByClientId(Integer clientId);

    Order findById(Integer id);

    List<Order> findAll();

    void saveOrder(Order order);
}
