package nastya.BookShop.repository;

import nastya.BookShop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
//    List<Book> findByName(String book_name);
}
