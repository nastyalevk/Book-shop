package nastya.BookShop.service.api;

import nastya.BookShop.dto.review.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> getUserReview(Integer id);

    List<ReviewDto> getShopReview(Integer id);

    List<ReviewDto> findAll();

    void saveReview(ReviewDto review);
}
