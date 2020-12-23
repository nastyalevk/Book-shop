package nastya.bookShop.Service;

import nastya.bookShop.model.Review;
import nastya.bookShop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviewById(Integer id){
        return  null;
    }
}
