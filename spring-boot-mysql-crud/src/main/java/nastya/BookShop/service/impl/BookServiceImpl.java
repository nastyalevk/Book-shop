package nastya.BookShop.service.impl;

import nastya.BookShop.dto.book.BookDto;
import nastya.BookShop.model.Book;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.service.api.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto findById(Integer id) {
        try {
            return transfer(bookRepository.getOne(id));
        } catch (Exception e) {
            logger.error("Book error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<BookDto> findAll() {
        try {
            List<Book> books = bookRepository.findAll();
            List<BookDto> bookDtos = new ArrayList<BookDto>();
            for (Book i : books) {
                bookDtos.add(transfer(i));
            }
            return bookDtos;
        } catch (Exception e) {
            logger.error("Book error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    @Override
    public Book saveBook(BookDto bookDto) {
        try {
            return bookRepository.save(transfer(bookDto));
        } catch (Exception e) {
            logger.error("Book error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Book error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Object> getAllBooksPage(String bookName, int page, int size, String[] sort) {
        try {
            List<Sort.Order> orders = new ArrayList<Sort.Order>();
            if (sort[0].contains(",")) {
                // will sort more than 2 fields
                // sortOrder="field, direction"
                for (String sortOrder : sort) {
                    String[] _sort = sortOrder.split(",");
                    orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
                }
            } else {
                // sort=[field, direction]
                orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
            }

            List<Book> books = new ArrayList<Book>();
            Pageable pagingSort = PageRequest.of(page, size);

            Page<Book> pageBook;
            if (bookName == null)
                pageBook = bookRepository.findAll(pagingSort);
            else
                pageBook = bookRepository.findByBookNameContaining(bookName, pagingSort);

            books = pageBook.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("books", books);
            response.put("currentPage", pageBook.getNumber());
            response.put("totalItems", pageBook.getTotalElements());
            response.put("totalPages", pageBook.getTotalPages());
            return response;

        } catch (Exception e) {
            logger.error("Book error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
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
