package nastya.BookShop.controller;

import nastya.BookShop.dto.shop.ShopDto;
import nastya.BookShop.service.api.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shopDto) {
        try {
            return new ResponseEntity<>(shopService.saveShop(shopDto), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Shop error: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<ShopDto>> findUserShops(@PathVariable("username") String username) {
        try {
            return new ResponseEntity<>(shopService.userShops(username), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Shop error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<List<ShopDto>> findBookShops(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(shopService.getShopsByBook(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Shop error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getShop(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(shopService.getOne(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Shop error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
