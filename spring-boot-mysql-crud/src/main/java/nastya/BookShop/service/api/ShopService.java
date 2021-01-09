package nastya.BookShop.service.api;

import nastya.BookShop.dto.shop.ShopDto;

import java.util.List;

public interface ShopService {

    void saveShop(ShopDto shopDto);

    List<ShopDto> userShops(Integer id);

}
