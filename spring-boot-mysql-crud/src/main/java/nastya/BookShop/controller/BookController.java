package nastya.BookShop.controller;

import nastya.BookShop.model.Book;
import nastya.BookShop.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @PostMapping(path = "/book-create")
    public void createBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @GetMapping("/book-delete/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @PostMapping("/book-update")
    public void updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }
}
