package nastya.BookShop.service.api;

import nastya.BookShop.dto.orderContent.OrderContentDto;
import nastya.BookShop.model.OrderContent;

import java.util.List;

public interface OrderContentService {

    List<OrderContentDto> findAll();

    List<OrderContentDto> getOrderContent(Integer orderId);

    OrderContent saveOrderContent(OrderContentDto orderContent);

}
