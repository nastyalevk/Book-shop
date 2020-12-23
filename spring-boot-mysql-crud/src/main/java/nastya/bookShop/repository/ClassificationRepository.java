package nastya.bookShop.repository;

import nastya.bookShop.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<Classification, Integer> {
}
