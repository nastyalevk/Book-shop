package nastya.BookShop.service.impl;

import nastya.BookShop.repository.ClassificationRepository;
import nastya.BookShop.service.api.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    @Autowired
    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public String getClassificationById(Integer id) {
        return classificationRepository.getClassificationById(id).getName();
    }
}
