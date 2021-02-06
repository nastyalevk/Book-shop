package nastya.BookShop.controller;

import nastya.BookShop.dto.order.OrderDto;
import nastya.BookShop.dto.response.PageResponse;
import nastya.BookShop.service.api.OrderService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<OrderDto>> getOrdersByClient(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(orderService.findByClientId(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Order error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(orderService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping()
    public ResponseEntity<List<OrderDto>> findAll() {
        try {
            return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        try {
            return new ResponseEntity<>(orderService.saveOrder(orderDto), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Order error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/client/")
    public ResponseEntity<PageResponse> getOrdersByClient(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "9") int size,
                                                          @RequestParam() String username) {
        try {
            return new ResponseEntity<>(orderService.findByClientUsername(page, size, username), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Order error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/shop/{id}")
    public ResponseEntity<List<OrderDto>> getOrdersByShop(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(orderService.getOrderByShop(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Order error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
