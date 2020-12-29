package nastya.BookShop.service.interf;

import nastya.BookShop.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getUserReview(Integer id);

    List<Review> getShopReview(Integer id);
}
