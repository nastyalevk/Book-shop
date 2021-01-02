package nastya.BookShop.service.api;

import nastya.BookShop.model.OrderContent;

import java.util.List;

public interface OrderContentService {

    List<OrderContent> findAll();

    List<OrderContent> getShopOrderContent(Integer id);

    List<OrderContent> getUserOrderContent(Integer id);

    void saveOrderContent(OrderContent orderContent);

    OrderContent getOne(Integer id);

}
