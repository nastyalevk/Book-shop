package nastya.bookShop.Service;

import nastya.bookShop.repository.ClassificationRepository;
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
