package nastya.BookShop.repository;

import nastya.BookShop.model.OrderContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderContentRepository extends JpaRepository<OrderContent, Integer> {
}
