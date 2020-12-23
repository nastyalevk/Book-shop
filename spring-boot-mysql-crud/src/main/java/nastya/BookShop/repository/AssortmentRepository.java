package nastya.BookShop.repository;

import nastya.BookShop.model.Assortment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssortmentRepository extends JpaRepository<Assortment, Integer> {
}
