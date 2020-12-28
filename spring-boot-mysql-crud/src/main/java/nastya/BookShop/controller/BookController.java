package nastya.BookShop.controller;

import nastya.BookShop.model.Book;
import nastya.BookShop.service.interf.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookService.saveBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/books"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/book-delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/books"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @PostMapping("/book-update")
    public ResponseEntity<Void> updateBook(@RequestBody Book book){
        bookService.saveBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/books"));
        return new ResponseEntity<Void>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
