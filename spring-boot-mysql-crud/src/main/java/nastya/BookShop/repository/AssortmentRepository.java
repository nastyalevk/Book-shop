package nastya.BookShop.repository;

import nastya.BookShop.model.Assortment;
import nastya.BookShop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssortmentRepository extends JpaRepository<Assortment, Integer> {

    List<Assortment> findAllByAssortmentIdShopId(Integer id);

    List<Assortment> findAssortmentByAssortmentIdBookId(Integer id);

    Assortment findByAssortmentIdBookIdAndAssortmentIdShopId(Integer bookId, Integer shopId);

}
