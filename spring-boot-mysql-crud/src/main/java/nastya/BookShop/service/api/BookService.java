package nastya.BookShop.service.api;

import nastya.BookShop.model.Book;

import java.util.List;

public interface BookService {

    Book findById(Integer id);

    List<Book> findAll();

    Book saveBook(Book book);

    void deleteById(Integer id);
}
