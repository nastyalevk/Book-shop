package nastya.BookShop.controller;

import nastya.BookShop.service.api.AssortmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assortment")
public class AssortmentController {

    private static final Logger logger = LoggerFactory.getLogger(AssortmentController.class);

    private final AssortmentService assortmentService;

    @Autowired
    public AssortmentController(AssortmentService assortmentService) {
        this.assortmentService = assortmentService;
    }

    @GetMapping("/shop/{id}")
    public ResponseEntity getAssortmentByShop(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity(assortmentService.getAssortmentByShop(id), HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/price/{id}")
    public ResponseEntity getLowestPrice(@PathVariable("id") Integer id){
        try{
            return new ResponseEntity(assortmentService.getPrice(id), HttpStatus.OK);
        }catch (Exception e){
            logger.error("Assortment error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
