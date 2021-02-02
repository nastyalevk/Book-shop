package nastya.BookShop.service.api;

import nastya.BookShop.dto.book.BookDto;
import nastya.BookShop.dto.response.PageResponse;

import java.util.List;

public interface BookService {

    BookDto findById(Integer id);

    List<BookDto> findAll();

    BookDto saveBook(BookDto book);

    void deleteById(Integer id);

    PageResponse getAllBooksPage(String bookName, int page, int size, String[] sort);

    List<BookDto> getBookByShop(Integer shopId);
}
