package nastya.BookShop.service.api;

import nastya.BookShop.model.Shop;

import java.util.List;

public interface ShopService {

    void addShop(Shop shop);

    List<Shop> userOrders(Integer id);

    List<Shop> userShops(Integer id);
}
