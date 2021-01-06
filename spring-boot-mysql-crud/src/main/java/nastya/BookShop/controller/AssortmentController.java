package nastya.BookShop.controller;

import nastya.BookShop.dto.Assortment.AssortmentDto;
import nastya.BookShop.service.api.AssortmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity getAssortmentByShop(@PathVariable("id") Integer id) {
        List<AssortmentDto> assortmentDto = assortmentService.getAssortmentByShop(id);
        if(assortmentDto.isEmpty()){
            return new ResponseEntity("This shop dont have assortment", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(assortmentDto, HttpStatus.OK);
    }
}
