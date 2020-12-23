package nastya.BookShop.repository;

import nastya.BookShop.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
