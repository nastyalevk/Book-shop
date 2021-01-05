package nastya.BookShop.service.impl;

import nastya.BookShop.dto.book.BookDto;
import nastya.BookShop.model.Book;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto findById(Integer id) {
        return transfer(bookRepository.getOne(id));
    }

    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<BookDto>();
        for (Book i : books) {
            bookDtos.add(transfer(i));
        }
        return bookDtos;
    }

    @Override
    public Book saveBook(BookDto bookDto) {
        return bookRepository.save(transfer(bookDto));
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    private BookDto transfer(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setBookName(book.getBookName());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setGenre(book.getGenre());
        bookDto.setPages(book.getPages());
        bookDto.setPublicationYear(book.getPublicationYear());
        bookDto.setDescription(book.getDescription());
        return bookDto;
    }

    private Book transfer(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setBookName(bookDto.getBookName());
        book.setAuthor(bookDto.getAuthor());
        book.setGenre(bookDto.getGenre());
        book.setPages(bookDto.getPages());
        book.setPublicationYear(bookDto.getPublicationYear());
        book.setDescription(bookDto.getDescription());
        return book;
    }
}
