package nastya.BookShop.repository;

import nastya.BookShop.model.OrderContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderContentRepository extends JpaRepository<OrderContent, Integer> {

    List<OrderContent> findAllByOrderContentIdOrderId(Integer id);

}
