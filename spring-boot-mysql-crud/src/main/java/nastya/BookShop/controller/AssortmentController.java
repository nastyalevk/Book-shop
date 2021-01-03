package nastya.BookShop.controller;

import nastya.BookShop.model.Assortment;
import nastya.BookShop.service.api.AssortmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AssortmentController {
    private final AssortmentService assortmentService;

    @Autowired
    public AssortmentController(AssortmentService assortmentService) {
        this.assortmentService = assortmentService;
    }

    @GetMapping("/shop-assortment/{id}")
    public List<Assortment> getAssortmentByShop(@PathVariable("id") Integer id) {
        return assortmentService.getAssortmentByShop(id);
    }
}
