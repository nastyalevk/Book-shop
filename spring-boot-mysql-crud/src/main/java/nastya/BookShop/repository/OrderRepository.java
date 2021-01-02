package nastya.BookShop.repository;

import nastya.BookShop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByUserId(Integer id);
}
