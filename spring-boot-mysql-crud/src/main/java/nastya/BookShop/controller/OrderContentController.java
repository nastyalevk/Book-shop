package nastya.BookShop.controller;

import nastya.BookShop.model.OrderContent;
import nastya.BookShop.service.api.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<OrderContent>findAll(){
        return orderContentService.findAll();
    }

    @GetMapping("/order-content-user/{id}")
    public List<OrderContent> getUserOrderContent(@PathVariable("id") Integer id){
        return orderContentService.getUserOrderContent(id);
    }

    @GetMapping("/order-content-shop/{id}")
    public List<OrderContent> getShopOrderContent(@PathVariable("id") Integer id){
        return orderContentService.getShopOrderContent(id);
    }

    @GetMapping("/order-content/{id}")
    public OrderContent getOrderContent(@PathVariable("id") Integer id){
        return orderContentService.getOne(id);
    }

    @PostMapping("/add-content")
    public void saveContent(@RequestBody OrderContent orderContent){
        orderContentService.saveOrderContent(orderContent);
    }

}
