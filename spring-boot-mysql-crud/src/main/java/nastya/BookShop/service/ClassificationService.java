package nastya.BookShop.service;

import nastya.BookShop.repository.ClassificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificationService {
    private final ClassificationRepository classificationRepository;

    @Autowired
    public ClassificationService(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }
}
