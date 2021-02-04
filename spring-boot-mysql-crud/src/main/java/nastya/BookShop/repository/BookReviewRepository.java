package nastya.BookShop.repository;

import nastya.BookShop.model.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookReviewRepository extends JpaRepository<BookReview, Integer> {

    List<BookReview> findAllByBookId(Integer id);

}
