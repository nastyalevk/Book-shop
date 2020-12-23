package nastya.bookShop.repository;

import nastya.bookShop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
