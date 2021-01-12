package nastya.BookShop.service.impl;

import nastya.BookShop.repository.ClassificationRepository;
import nastya.BookShop.service.api.ClassificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private static final Logger logger = LoggerFactory.getLogger(ClassificationServiceImpl.class);

    private final ClassificationRepository classificationRepository;

    @Autowired
    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public String getClassificationById(Integer id) {
        try {
            return classificationRepository.getClassificationById(id).getName();
        } catch (Exception e) {
            logger.error("Classification error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
