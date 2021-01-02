package nastya.BookShop.service.impl;

import nastya.BookShop.model.Review;
import nastya.BookShop.repository.ReviewRepository;
import nastya.BookShop.service.api.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getUserReview(Integer id) {
        return reviewRepository.findAllByUserId(id);
    }

    @Override
    public List<Review> getShopReview(Integer id) {
        return reviewRepository.findAllByShopId(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
