package nastya.BookShop.controller;

import nastya.BookShop.service.BookService;
import nastya.BookShop.model.Book;
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

    //make forwarding
    @PostMapping(path = "/book-create")
    public void createBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    //make forwarding
    @GetMapping("/book-delete/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        Book book = bookService.findById(id);
        System.out.println(book.getBookName());
        System.out.println(book.getId());
        return bookService.findById(id);
    }

    //make forwarding
    @PostMapping("/book-update")
    public void updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }
}
