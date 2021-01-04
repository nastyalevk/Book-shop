package nastya.BookShop.service.api;


import nastya.BookShop.dto.order.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findByClientId(Integer id);

    OrderDto findById(Integer id);

    List<OrderDto> findAll();

    void saveOrder(OrderDto order);
}
