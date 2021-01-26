package nastya.BookShop.service.impl;

import nastya.BookShop.dto.shop.ShopDto;
import nastya.BookShop.model.Assortment;
import nastya.BookShop.model.Shop;
import nastya.BookShop.repository.AssortmentRepository;
import nastya.BookShop.repository.ClassificationRepository;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.service.api.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final ClassificationRepository classificationRepository;
    private final UserRepository userRepository;
    private final AssortmentRepository assortmentRepository;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, ClassificationRepository classificationRepository,
                           UserRepository userRepository, AssortmentRepository assortmentRepository) {
        this.shopRepository = shopRepository;
        this.classificationRepository = classificationRepository;
        this.userRepository = userRepository;
        this.assortmentRepository = assortmentRepository;
    }

    @Override
    public void saveShop(ShopDto shopDto) {
        shopRepository.save(transfer((shopDto)));
    }

    @Override
    public List<ShopDto> userShops(Integer id) {
        return transfer(shopRepository.findAllByUserId(id));
    }

    @Override
    public List<ShopDto> getShopByBook(Integer id) {
        List<ShopDto> result = new ArrayList<>();
        List<Assortment> assortments = assortmentRepository.findAssortmentByAssortmentId_Book_Id(id);
        for (Assortment i : assortments) {
            result.add(transfer(i.getAssortmentId().getShop()));
        }
        return result;
    }

    private List<ShopDto> transfer(List<Shop> shops){
        List<ShopDto> shopDtos = new ArrayList<>();
        for (Shop i : shops) {
            shopDtos.add(transfer(i));
        }
        return shopDtos;
    }

    private ShopDto transfer(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setId(shop.getId());
        shopDto.setShopName(shop.getShopName());
        shopDto.setCountry(shop.getCountry());
        shopDto.setCity(shop.getCity());
        shopDto.setAddress(shop.getAddress());
        shopDto.setDescription(shop.getDescription());
        shopDto.setClassificationId(shop.getClassification().getId());
        shopDto.setClassificationStatus(shop.getClassification().getName());
        shopDto.setUserId(shop.getUser().getId());
        return shopDto;
    }

    private Shop transfer(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setId(shopDto.getId());
        shop.setShopName(shopDto.getShopName());
        shop.setCountry(shopDto.getCountry());
        shop.setCity(shopDto.getCity());
        shop.setAddress(shopDto.getAddress());
        shop.setDescription(shopDto.getDescription());
        shop.setClassification(classificationRepository.getClassificationById(shopDto.getClassificationId()));
        shop.setUser(userRepository.getOne(shopDto.getUserId()));
        return shop;
    }
}
