package nastya.BookShop.controller;

import nastya.BookShop.dto.orderContent.OrderContentDto;
import nastya.BookShop.service.api.OrderContentService;
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
@RequestMapping("/order/content")
public class OrderContentController {

    private static final Logger logger = LoggerFactory.getLogger(OrderContentController.class);

    private final OrderContentService orderContentService;

    @Autowired
    public OrderContentController(OrderContentService orderContentService) {
        this.orderContentService = orderContentService;
    }

    @GetMapping()
    public ResponseEntity<List<OrderContentDto>> findAll() {
        try {
            return new ResponseEntity<>(orderContentService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Order content error: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<List<OrderContentDto>> getOrderContent(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(orderContentService.getOrderContent(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Order content error: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> saveContent(@RequestBody OrderContentDto orderContentDto) {
        try {
            System.out.println(orderContentDto.getOrderNumber());
            orderContentService.saveOrderContent(orderContentDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
