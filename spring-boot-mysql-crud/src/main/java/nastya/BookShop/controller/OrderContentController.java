package nastya.BookShop.controller;

import nastya.BookShop.dto.orderContent.OrderContentDto;
import nastya.BookShop.service.api.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderContentController {
    private final OrderContentService orderContentService;

    @Autowired
    public OrderContentController(OrderContentService orderContentService) {
        this.orderContentService = orderContentService;
    }

    @GetMapping("/order-content")
    public ResponseEntity findAll() {
        List<OrderContentDto> orderContentDto = orderContentService.findAll();
        if (orderContentDto.isEmpty()) {
            return new ResponseEntity("No order content found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(orderContentDto, HttpStatus.OK);
    }

    @GetMapping("/order-content/{id}")
    public ResponseEntity getOrderContent(@PathVariable("id") Integer id) {
        return new ResponseEntity(orderContentService.getOrderContent(id), HttpStatus.OK);
    }

    @PostMapping("/add-content")
    public ResponseEntity saveContent(@RequestBody OrderContentDto orderContentDto) {
        orderContentService.saveOrderContent(orderContentDto);
        return new ResponseEntity(HttpStatus.OK);
    }

}
