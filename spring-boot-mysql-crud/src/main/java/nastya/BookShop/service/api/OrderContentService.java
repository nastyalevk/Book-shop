package nastya.BookShop.service.api;

import nastya.BookShop.dto.orderContent.OrderContentDto;
import nastya.BookShop.model.OrderContent;

import java.util.List;

public interface OrderContentService {

    List<OrderContentDto> findAll();

    List<OrderContentDto> getShopOrderContent(Integer id);

    List<OrderContentDto> getUserOrderContent(Integer id);

    OrderContent saveOrderContent(OrderContentDto orderContent);

    OrderContentDto getOne(Integer id);

}
