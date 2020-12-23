package nastya.bookShop.controller;

import nastya.bookShop.Service.OrderContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderContentController {
    private final OrderContentService orderContentService;

    @Autowired
    public OrderContentController(OrderContentService orderContentService) {
        this.orderContentService = orderContentService;
    }
}
