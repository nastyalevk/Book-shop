package nastya.BookShop.controller;

import nastya.BookShop.dto.Assortment.AssortmentDto;
import nastya.BookShop.service.api.AssortmentService;
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
@RequestMapping("/assortment")
public class AssortmentController {

    private static final Logger logger = LoggerFactory.getLogger(AssortmentController.class);

    private final AssortmentService assortmentService;

    @Autowired
    public AssortmentController(AssortmentService assortmentService) {
        this.assortmentService = assortmentService;
    }

    @GetMapping("/shop/{id}")
    public ResponseEntity<List<AssortmentDto>> getAssortmentByShop(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(assortmentService.getAssortmentByShop(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/price/{id}")
    public ResponseEntity<Integer> getMinPrice(@PathVariable("id") Integer bookId) {
        try {
            return new ResponseEntity<>(assortmentService.getMinPrice(bookId), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/price/{bookId}/{shopId}")
    public ResponseEntity<Integer> getPriceByBookShop
            (@PathVariable("bookId") Integer bookId, @PathVariable("shopId") Integer shopId) {
        try {
            return new ResponseEntity<>(assortmentService.getPriceByBookShop(bookId, shopId), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<AssortmentDto> createAssortment(@RequestBody AssortmentDto assortmentDto) {
        try {
            return new ResponseEntity<>(assortmentService.save(assortmentDto), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/exists/{bookId}/{shopId}")
    public ResponseEntity<Boolean> existsByBook(@PathVariable("bookId") Integer bookId,
                                                @PathVariable("shopId") Integer shopId) {
        try {
            return new ResponseEntity<>(assortmentService.existsByBook(bookId, shopId), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/delete/{bookId}/{shopId}")
    public ResponseEntity deleteAssortment(@PathVariable("bookId") Integer bookId,
                                           @PathVariable("shopId") Integer shopId) {
        try {
            assortmentService.delete(bookId, shopId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{bookId}/{shopId}")
    public ResponseEntity<AssortmentDto> getOne(@PathVariable("bookId") Integer bookId,
                                                @PathVariable("shopId") Integer shopId) {
        try {
            return new ResponseEntity<>(assortmentService.getOne(bookId, shopId), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
