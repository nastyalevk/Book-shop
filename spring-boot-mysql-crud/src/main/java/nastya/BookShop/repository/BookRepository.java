package nastya.BookShop.repository;

import nastya.BookShop.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAll(Pageable pageable);

    Page<Book> findByBookName(String bookName, Pageable pageable);

    List<Book> findByBookName(String bookName, Sort sort);
}
