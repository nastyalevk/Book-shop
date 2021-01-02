package nastya.BookShop.controller;

import nastya.BookShop.service.api.OrderService;
import nastya.BookShop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Order> getOrdersByClient(@PathVariable("id") Integer id){
        return orderService.findByClientId(id);
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
    public void createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }
}
