package nastya.bookShop.controller;

import nastya.bookShop.Service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassificationController {
    private final ClassificationService classificationService;

    @Autowired
    public ClassificationController(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }
}
