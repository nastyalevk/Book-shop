package nastya.bookShop.repository;

import nastya.bookShop.model.Assortment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssortmentRepository extends JpaRepository<Assortment, Integer> {
}
