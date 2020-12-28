package nastya.BookShop.controller;

import nastya.BookShop.service.interf.AssortmentService;
import nastya.BookShop.model.Assortment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssortmentController {
    private final AssortmentService assortmentService;

    @Autowired
    public AssortmentController(AssortmentService assortmentService) {
        this.assortmentService = assortmentService;
    }

    @GetMapping("/shop-assortment/{id}")
    public List<Assortment> getAssortmentByShop(@PathVariable("id") Integer shopId){
        return assortmentService.getAssortmentByShop(shopId);
    }
}
