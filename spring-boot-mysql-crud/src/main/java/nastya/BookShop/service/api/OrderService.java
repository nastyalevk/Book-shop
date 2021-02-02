package nastya.BookShop.service.api;

import nastya.BookShop.dto.order.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findByClientId(Integer id);

    List<OrderDto> findByClientUsername(String username);

    OrderDto findById(Integer id);

    List<OrderDto> findAll();

    OrderDto saveOrder(OrderDto order);

    List<OrderDto> getOrderByShop(Integer shopId);
}
