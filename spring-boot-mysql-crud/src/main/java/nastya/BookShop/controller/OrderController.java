package nastya.BookShop.controller;

import nastya.BookShop.service.interf.OrderService;
import nastya.BookShop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/client-orders/{id}")
    public Optional<Order> getOrdersByClient(@PathVariable("id") Integer clientId){
        return orderService.findByClientId(clientId);
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable("id") Integer id){
        return orderService.findById(id);
    }

    @GetMapping("/orders")
    public List<Order> findAll(){
        return orderService.findAll();
    }

    @PostMapping("/new-order")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/orders"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
