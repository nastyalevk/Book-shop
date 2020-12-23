package nastya.bookShop.repository;

import nastya.bookShop.model.OrderContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderContentRepository extends JpaRepository<OrderContent, Integer> {
}
