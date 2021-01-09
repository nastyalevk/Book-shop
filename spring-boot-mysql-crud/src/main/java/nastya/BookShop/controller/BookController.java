package nastya.BookShop.controller;

import nastya.BookShop.dto.book.BookDto;
import nastya.BookShop.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        List<BookDto> bookDto = bookService.findAll();
        if (bookDto.isEmpty()) {
            return new ResponseEntity("No books found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(bookDto, HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity createBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getBook(@PathVariable("id") Integer id) {
        return new ResponseEntity(bookService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity updateBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(bookDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
