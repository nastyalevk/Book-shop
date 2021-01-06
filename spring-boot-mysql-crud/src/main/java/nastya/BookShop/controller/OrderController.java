package nastya.BookShop.controller;

import nastya.BookShop.dto.order.OrderDto;
import nastya.BookShop.service.api.OrderService;
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
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/client-orders/{id}")
    public ResponseEntity getOrdersByClient(@PathVariable("id") Integer id) {
        List<OrderDto> orderDto = orderService.findByClientId(id);
        if (orderDto.isEmpty()) {
            return new ResponseEntity("This client has no orders", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(orderDto, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity getOrder(@PathVariable("id") Integer id) {
        return new ResponseEntity(orderService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity findAll() {
        List<OrderDto> orderDto = orderService.findAll();
        if (orderDto.isEmpty()) {
            return new ResponseEntity("This client has no orders", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(orderDto, HttpStatus.OK);
    }

    @PostMapping("/new-order")
    public ResponseEntity createOrder(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
