package nastya.BookShop.service.impl;

import nastya.BookShop.model.Shop;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.service.api.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public void addShop(Shop shop) {

    }

    @Override
    public List<Shop> userOrders(Integer id) {
        return null;
    }

    @Override
    public List<Shop> userShops(Integer id) {
        return null;
    }
}
