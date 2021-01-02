package nastya.BookShop.service.api;

import nastya.BookShop.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getUserReview(Integer id);

    List<Review> getShopReview(Integer id);

    List<Review> findAll();

    void saveReview(Review review);
}
