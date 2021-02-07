package nastya.BookShop.service.api;

import nastya.BookShop.dto.review.BookReviewDto;
import nastya.BookShop.dto.review.ShopReviewDto;

import java.text.ParseException;
import java.util.List;

public interface ReviewService {

    List<BookReviewDto> getBookReview(Integer bookId);

    List<ShopReviewDto> getShopReview(Integer bookId);

    BookReviewDto saveBookReview(BookReviewDto bookReviewDto) throws ParseException;

    ShopReviewDto saveShopReview(ShopReviewDto shopReviewDto) throws ParseException;

}
