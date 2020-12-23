package nastya.bookShop.controller;

import nastya.bookShop.Service.BookService;
import nastya.bookShop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String getBook(@PathVariable("id") Integer id) {
        return bookService.findById(id).toString();
    }

    //make forwarding
    @PostMapping("/book-update")
    public void updateBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }
}
