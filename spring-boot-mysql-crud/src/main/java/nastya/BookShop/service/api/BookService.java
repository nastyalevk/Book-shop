package nastya.BookShop.service.api;

import nastya.BookShop.dto.book.BookDto;
import nastya.BookShop.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    BookDto findById(Integer id);

    List<BookDto> findAll();

    Book saveBook(BookDto book);

    void deleteById(Integer id);

    Map<String, Object> getAllBooksPage(String bookName, int page, int size, String[] sort);

}
