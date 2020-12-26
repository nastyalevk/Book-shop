package nastya.BookShop.controller;

import nastya.BookShop.service.interf.BookService;
import nastya.BookShop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        findAll();
    }

    //make forwarding
    @GetMapping("/book-delete/{id}")
    public void deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    //make forwarding
    @RequestMapping(value = "/book-update", method = RequestMethod.POST)
//    @PostMapping("/book-update")
    public void updateBook(@RequestBody Book book, HttpServletResponse response) throws IOException {
        bookService.saveBook(book);
        response.sendRedirect("/books");
    }
}
