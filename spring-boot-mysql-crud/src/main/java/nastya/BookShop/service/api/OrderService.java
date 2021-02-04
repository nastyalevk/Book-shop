package nastya.BookShop.service.api;

import nastya.BookShop.dto.order.OrderDto;
import nastya.BookShop.dto.response.PageResponse;

import java.util.List;

public interface OrderService {

    List<OrderDto> findByClientId(Integer id);

    PageResponse findByClientUsername(int page, int size, String username);

    OrderDto findById(Integer id);

    List<OrderDto> findAll();

    OrderDto saveOrder(OrderDto order);

    List<OrderDto> getOrderByShop(Integer shopId);

}
