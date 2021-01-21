package nastya.BookShop.service.impl;

import nastya.BookShop.dto.book.BookDto;
import nastya.BookShop.dto.response.PageResponse;
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
    public PageResponse getAllBooksPage(String bookName, int page, int size, String sort) {
        try {
            Pageable pagingSort = PageRequest.of(page, size, SortType(sort));
            Page<Book> pageBook;
            if (bookName == null) {
                pageBook = bookRepository.findAll(pagingSort);
            } else {
                pageBook = bookRepository.findByBookNameContaining(bookName, pagingSort);
            }

            return transfer(pageBook);

        } catch (Exception e) {
            logger.error("Book error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private Sort SortType(String fieldsort) {
        String[] split = fieldsort.split("_");
        Sort sort = Sort.unsorted();
        Sort result = Sort.unsorted();
            if ("asc".equalsIgnoreCase(split[1])) {
                sort = Sort.by(split[0]).ascending();
            } else if ("desc".equalsIgnoreCase(split[1])) {
                sort = Sort.by(split[0]).descending();
            }
            if (result == null) {
                result = sort;
            } else {
                result = result.and(sort);
            }
        return result;
    }

    private List<BookDto> transfer(List<Book> books) {
        List<BookDto> booksDto = new ArrayList<>();
        for (Book i : books) {
            booksDto.add(transfer(i));
        }
        return booksDto;
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

    private PageResponse transfer(Page page) {
        PageResponse<BookDto> pageResponse = new PageResponse<>();
        pageResponse.setContent(transfer(page.getContent()));
        pageResponse.setCurrentPage(page.getNumber());
        pageResponse.setTotalElements(page.getTotalElements());
        pageResponse.setTotalPages(page.getTotalPages());
        return pageResponse;
    }

}
