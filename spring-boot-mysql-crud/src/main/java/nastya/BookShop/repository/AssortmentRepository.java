package nastya.BookShop.repository;

import nastya.BookShop.model.Assortment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssortmentRepository extends JpaRepository<Assortment, Integer> {

    List<Assortment> findAllByAssortmentIdShopId(Integer id);

}
