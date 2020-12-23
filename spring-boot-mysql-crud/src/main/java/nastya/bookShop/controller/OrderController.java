package nastya.bookShop.controller;

import nastya.bookShop.Service.OrderService;
import nastya.bookShop.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //make forwarding
    @PostMapping("/new-order")
    public void createOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }
}
