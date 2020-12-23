package nastya.bookShop.repository;

import nastya.bookShop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
//    List<Book> findByName(String book_name);
}
