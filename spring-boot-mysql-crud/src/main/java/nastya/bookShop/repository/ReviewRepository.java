package nastya.bookShop.repository;

import nastya.bookShop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
