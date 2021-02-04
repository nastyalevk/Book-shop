package nastya.BookShop.service.impl;

import nastya.BookShop.dto.review.BookReviewDto;
import nastya.BookShop.dto.review.ShopReviewDto;
import nastya.BookShop.model.BookReview;
import nastya.BookShop.model.ShopReview;
import nastya.BookShop.repository.BookRepository;
import nastya.BookShop.repository.BookReviewRepository;
import nastya.BookShop.repository.ShopRepository;
import nastya.BookShop.repository.ShopReviewRepository;
import nastya.BookShop.repository.UserRepository;
import nastya.BookShop.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ReviewServiceImpl implements ReviewService {

    private final BookReviewRepository bookReviewRepository;
    private final ShopReviewRepository shopReviewRepository;
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ReviewServiceImpl(BookReviewRepository bookReviewRepository, ShopReviewRepository shopReviewRepository, ShopRepository shopRepository,
                             UserRepository userRepository, BookRepository bookRepository) {
        this.bookReviewRepository = bookReviewRepository;
        this.shopReviewRepository = shopReviewRepository;
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<ShopReviewDto> getShopReview(Integer id) {
        List<ShopReview> reviews = shopReviewRepository.findAllByShopId(id);
        List<ShopReviewDto> reviewDtos = new ArrayList<>();
        for (ShopReview i : reviews) {
            reviewDtos.add(transfer(i));
        }
        return reviewDtos;
    }

    @Override
    public BookReviewDto saveBookReview(BookReviewDto bookReviewDto) {
        return transfer(bookReviewRepository.save(transfer(bookReviewDto)));
    }

    @Override
    public ShopReviewDto saveShopReview(ShopReviewDto shopReviewDto) {
        return transfer(shopReviewRepository.save(transfer(shopReviewDto)));
    }

    @Override
    public List<BookReviewDto> getBookReview(Integer id) {
        List<BookReview> reviews = bookReviewRepository.findAllByBookId(id);
        List<BookReviewDto> reviewDtos = new ArrayList<>();
        for (BookReview i : reviews) {
            reviewDtos.add(transfer(i));
        }
        return reviewDtos;
    }


    private BookReviewDto transfer(BookReview review) {
        BookReviewDto reviewDto = new BookReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setUsername(review.getUser().getUsername());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        reviewDto.setBookId(review.getBook().getId());
        return reviewDto;
    }

    private ShopReviewDto transfer(ShopReview review) {
        ShopReviewDto reviewDto = new ShopReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setUsername(review.getUser().getUsername());
        reviewDto.setComment(review.getComment());
        reviewDto.setRating(review.getRating());
        reviewDto.setShopId(review.getShop().getId());
        return reviewDto;
    }

    private BookReview transfer(BookReviewDto reviewDto) {
        BookReview review = new BookReview();
        review.setId(reviewDto.getId());
        review.setUser(userRepository.findByUsername(reviewDto.getUsername()));
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setBook(bookRepository.getOne(reviewDto.getBookId()));
        return review;
    }

    private ShopReview transfer(ShopReviewDto reviewDto) {
        ShopReview review = new ShopReview();
        review.setId(reviewDto.getId());
        review.setUser(userRepository.findByUsername(reviewDto.getUsername()));
        review.setComment(reviewDto.getComment());
        review.setRating(reviewDto.getRating());
        review.setShop(shopRepository.getOne(reviewDto.getShopId()));
        return review;
    }
}
