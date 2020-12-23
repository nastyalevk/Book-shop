package nastya.bookShop.repository;

import nastya.bookShop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
