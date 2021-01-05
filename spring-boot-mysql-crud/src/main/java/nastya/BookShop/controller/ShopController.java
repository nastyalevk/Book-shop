package nastya.BookShop.controller;

import nastya.BookShop.dto.shop.ShopDto;
import nastya.BookShop.service.api.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(path = "/shop-create")
    public ResponseEntity createShop(@RequestBody ShopDto shopDto) {
        shopService.saveShop(shopDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/shops/{id}")
    public ResponseEntity findUserShops(@PathVariable("id") Integer id) {
        List<ShopDto> shopDto = shopService.userShops(id);
        if (shopDto.isEmpty()) {
            return new ResponseEntity("No shops found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(shopDto, HttpStatus.OK);
    }
}
