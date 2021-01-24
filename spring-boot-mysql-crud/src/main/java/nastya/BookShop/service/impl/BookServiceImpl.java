package nastya.BookShop.service.impl;

import nastya.BookShop.dto.book.BookDto;
import nastya.BookShop.dto.response.PageResponse;
import nastya.BookShop.model.Book;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public PageResponse getAllBooksPage(String bookName, int page, int size, String[] sort) {
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(sortType(sort)));
        Page<Book> pageBook;
        if (bookName == null) {
            pageBook = bookRepository.findAll(pagingSort);
        } else {
        pageBook = bookRepository.findByBookNameContaining(bookName, pagingSort);
        }

        return transfer(pageBook);
    }

    private List<Sort.Order> sortType(String[] fieldsort) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        for (String i : fieldsort) {
            System.out.println(i);
            String[] split = i.split("_");
            Sort sort = Sort.unsorted();
            if ("asc".equalsIgnoreCase(split[1])) {
                orders.add(new Sort.Order(Sort.Direction.ASC, split[0]));
            } else if ("desc".equalsIgnoreCase(split[1])) {
                orders.add(new Sort.Order(Sort.Direction.DESC, split[0]));

            }
        }
        return orders;
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
